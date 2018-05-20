/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;
import com.esprit.Service.ServiceGame;
import com.esprit.Entities.Game;
import java.util.ArrayList;

/**
 *
 * @author sana
 */
public class ShowGame extends BaseForm{

    Form f;
    SpanLabel lb;

    public ShowGame(Resources res) {
        
        super("Newsfeed", BoxLayout.y());

         ServiceGame serviceGame =new ServiceGame();
        ArrayList<Game> list=serviceGame.getListOfGames();
     
        

          
          
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Games");
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


        
        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                    GridLayout.encloseIn(3, 
                            
                            FlowLayout.encloseCenter(
                            )
                    )
                )
        ));

        
                
        Container listGames = new Container(BoxLayout.y());
        listGames.setScrollable(true);
        for (Game game: list)
        {
            MultiButton mb = new MultiButton(game.getTeam1()+" VS "+game.getTeam2());
            mb.setTextLine2("more Details..");
            mb.addActionListener((e)->{
                
        new ShowSingle(res,game.getMatch_id()).show();
        });
            listGames.add(mb);
            
        }   
        
                add(listGames);


      
    }

    
       
    
  
}
