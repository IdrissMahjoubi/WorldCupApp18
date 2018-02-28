/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Utilities.Session;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Doggaz Jihed
 */
public class FXMLHomeController implements Initializable {

    @FXML
    private Label userwelcome;
    @FXML
    private MediaView media;
    Media media1;
    MediaPlayer mediaPlayer;
<<<<<<< HEAD
    @FXML
    private JFXButton bntStop;
=======
    
    //public Image image=new Image("file:/Users/apple/Desktop/WorldCupApp18/WoldCupApp18/src/Resources/Icons/FIFA_World_Cup_2018_Logo.png",true);
>>>>>>> 2c253b18dab205abc03ca6f369f65d32130b3eed
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userwelcome.setText(Session.LoggedUser.getUser_name());
        try {
            File f=new File("src/Resources/v.mp4");
            media1 = new Media(f.toURI().toURL().toString());
        } catch (MalformedURLException ex) {
            System.out.println("error media");
        }
        mediaPlayer = new MediaPlayer(media1);
        media.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);
        TrayNotification tray = new TrayNotification();
        tray.setTitle("Hi");
        tray.setMessage(Session.LoggedUser.getUser_name());
        tray.showAndDismiss(Duration.seconds(4));
        //tray.setImage(image);
    }    

    @FXML
    private void stop(ActionEvent event) {
        mediaPlayer.stop();
    }
    
}
