/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import static javax.management.remote.JMXConnectorFactory.connect;

/**
 * FXML Controller class
 *
 * @author MyTEK
 */
public class FXMLUserinterfaceController implements Initializable {

    @FXML
    private Button bouton_modif;
    @FXML
    private Button logout;
    @FXML
    private Button teams;
    @FXML
    private Button hotels;
    @FXML
    private Button game_stage;
    @FXML
    private Button streaming;
    @FXML
    private Button articles;
    @FXML
    private Button statistics;
    @FXML
    private Button stadiums;
    @FXML
    private Button stations;
    @FXML
    private Button events;
    @FXML
    private MediaView video;
    Media media;
    MediaPlayer mediaPlayer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File f=new File("src/ImagesPacha/v.mp4");
        try {
            //String urlv = "";
            media = new Media(f.toURI().toURL().toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(FXMLAffichageTeamController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mediaPlayer = new MediaPlayer(media);
        //view.setFitHeight(600);
        //view.setFitWidth(400);
        video.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);



    }    

    @FXML
    private void updateUserDetails(ActionEvent event) {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLUpdateUser.fxml"));
        try {
            Parent root = loader.load();
            FXMLUpdateUserController dc = loader.getController();
            bouton_modif.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLUpdateUserController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @FXML
    private void logout(ActionEvent event) {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLauthentification.fxml"));  
        try {
            Parent root = loader.load();
            FXMLauthentificationController dc = loader.getController();
            logout.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("ERROR LOGOUT=" + ex.getMessage());        
        } 
    }

    @FXML
    private void teams(ActionEvent event) throws IOException {
        Stage stage = new Stage();    
            Parent root = FXMLLoader.load(getClass().getResource("/Views/FXMLAffichageTeamUser.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void goToHotels(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLuserHotel.fxml"));
        try {
            Parent root = loader.load();
            FXMLuserHotelController dc = loader.getController();
            hotels.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("ERROR USER DETAILS=" + ex.getMessage());
        } 
    }

    @FXML
    private void switchToGameStage(ActionEvent event) {
         
    }

    @FXML
    private void switchToStreaming(ActionEvent event) {
    }

    @FXML
    private void switchToArticles(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLShowArticleUser.fxml"));
        try {
            Parent root = loader.load();
            FXMLShowArticleUserController dc = loader.getController();
            articles.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("ERROR USER DETAILS=" + ex.getMessage());
        } 
    }

    @FXML
    private void switchTostatistics(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLStatPlayer.fxml"));
        try {
            Parent root = loader.load();
            FXMLStatPlayerController dc = loader.getController();
            statistics.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("ERROR USER DETAILS=" + ex.getMessage());
        } 
    }

    @FXML
    private void SwitchTotadiums(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLUserStadium.fxml"));
        try {
            Parent root = loader.load();
            FXMLUserStadiumController dc = loader.getController();
            stadiums.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("ERROR USER DETAILS=" + ex.getMessage());
        } 
    }

    @FXML
    private void SwitchToEvents(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLEvenement.fxml"));
        try {
            Parent root = loader.load();
            FXMLEvenementController dc = loader.getController();
            events.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("ERROR USER DETAILS=" + ex.getMessage());
        } 
    }

    @FXML
    private void SwitchToStations(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLUserStation.fxml"));
        try {
            Parent root = loader.load();
            FXMLUserStationController dc = loader.getController();
            stations.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("ERROR USER DETAILS=" + ex.getMessage());        
        } 
    }
    
}
