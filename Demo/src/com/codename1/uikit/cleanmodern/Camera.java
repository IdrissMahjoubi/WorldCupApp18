/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.BOTTOM;
import static com.codename1.ui.CN.CENTER;
import static com.codename1.ui.CN.addNetworkErrorListener;
import static com.codename1.ui.CN.updateNetworkThreadCount;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.esprit.Service.CameraEvent;
import com.esprit.Service.CameraKit;
import com.esprit.Service.CameraListener;

/**
 *
 * @author apple
 */
public class Camera extends BaseForm{
    private CameraKit ck;

    public Camera(Resources res) {
        super("Camera", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Profile");
        getContentPane().setScrollVisible(false);
        
        super.addSideMenu(res);
        
        tb.addSearchCommand(e -> {});
        
        
        Image img = res.getImage("profile-background.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
    
            ck = CameraKit.create();

        if(ck != null && !ck.isStarted()) {
            ck.start();
        }

        setScrollableY(false);
        if(ck != null) {
            ck.addCameraListener(new CameraListener() {
                @Override
                public void onError(CameraEvent ev) {
                    // We currently get some errors on Android
                    Log.p(ev.getMessage() + " : " + ev.getExceptionMessage());
                }

                @Override
                public void onImage(CameraEvent ev) {
                    ToastBar.showInfoMessage("Captured image bytes");
                }

                @Override
                public void onVideo(CameraEvent ev) {
                    ToastBar.showInfoMessage("Captured video: " + ev.getFile());
                }


            });
            add(ck.getView());
            Button video = new Button();
            FontImage.setMaterialIcon(video, FontImage.MATERIAL_VIDEOCAM);
            video.addActionListener(e -> {
                Boolean b = (Boolean)video.getClientProperty("capturing");
                if(b == null) {
                    video.putClientProperty("capturing", Boolean.TRUE);
                    ck.captureVideo();
                    FontImage.setMaterialIcon(video, FontImage.MATERIAL_VIDEOCAM_OFF);
                } else {
                    video.putClientProperty("capturing", null);
                    ck.stopVideo();
                    FontImage.setMaterialIcon(video, FontImage.MATERIAL_VIDEOCAM);
                }
            });
            FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_CAMERA);
            fab.bindFabToContainer(this, CENTER, BOTTOM);
            fab.addActionListener(e -> ck.captureImage());

            Button toggleCamera = new Button();
            FontImage.setMaterialIcon(toggleCamera, FontImage.MATERIAL_CAMERA_FRONT);
            Button toggleFlash = new Button();
            FontImage.setMaterialIcon(toggleFlash, FontImage.MATERIAL_FLASH_ON);
            toggleCamera.addActionListener(e -> ck.toggleFacing());
            toggleFlash.addActionListener(e -> ck.toggleFlash());
            Container buttons = BoxLayout.encloseY(video, toggleCamera, toggleFlash);
            buttons.setScrollableY(true);
            add(BorderLayout.east(buttons));
        } else {
            add(BorderLayout.north(new SpanLabel("Loading native camera view")));
        }
    }

}
