/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import static javax.management.remote.JMXConnectorFactory.connect;

/**
 * FXML Controller class
 *
 * @author MyTEK
 */
public class FXMLUserinterfaceController implements Initializable {

    @FXML
    private ImageView bouton_modif;
    @FXML
    private ImageView logout;
    @FXML
    private Button teams;
    private Button hotels;
    @FXML
    private Button bntArticle;
    @FXML
    private JFXButton bntAccomodation;
    @FXML
    private JFXButton bntStat;
    @FXML
    private JFXButton home;
    @FXML
    private JFXButton bntGroups;
    @FXML
    private JFXButton bntStream;
    @FXML
    private AnchorPane panePrincipale;
    
    AnchorPane homePane,gamesPane,groupsPane,teamsPane,accomodationsPane,articlesPane,streamPane,statisticsPane;
    @FXML
    private JFXButton bntGame;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                try {
            homePane = FXMLLoader.load(getClass().getResource("/Views/FXMLHome.fxml"));
            gamesPane = FXMLLoader.load(getClass().getResource("/Views/FXMLShowMatchUser.fxml"));
            //groupsPane = FXMLLoader.load(getClass().getResource("/Views/FXML.fxml"));
            teamsPane = FXMLLoader.load(getClass().getResource("/Views/FXMLAffichageTeamUser.fxml"));
            //accomodationsPane = FXMLLoader.load(getClass().getResource("/Views/Evenement.fxml"));
            articlesPane = FXMLLoader.load(getClass().getResource("/Views/FXMLShowArticleUser.fxml"));
            //streamPane = FXMLLoader.load(getClass().getResource("/Views/GererProfile.fxml"));
            statisticsPane = FXMLLoader.load(getClass().getResource("/Views/FXMLStatPlayer.fxml"));
            setNode(homePane);

        } catch (IOException ex) {
            Logger.getLogger(FXMLUserinterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        private void setNode(Node node) {
        panePrincipale.getChildren().clear();
        panePrincipale.getChildren().add((Node) node);


    }
        // TODO
        

   /* private void updateUserDetails(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLUpdateUser.fxml"));
        try {
            Parent root = loader.load();
            FXMLUpdateUserController dc = loader.getController();
            bouton_modif.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("ERROR USER DETAILS=" + ex.getMessage());        } 
    }

    private void logout(ActionEvent event) {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLauthentification.fxml"));  
        try {
            Parent root = loader.load();
            FXMLauthentificationController dc = loader.getController();
            logout.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("ERROR LOGOUT=" + ex.getMessage());        
        } 
    }*/

    @FXML
    private void teams(ActionEvent event) throws IOException {
        setNode(teamsPane);
    }

   /* private void goToHotels(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLuserHotel.fxml"));
        try {
            Parent root = loader.load();
            FXMLuserHotelController dc = loader.getController();
            hotels.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLuserHotelController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }*/

    @FXML
    private void statPlayer(ActionEvent event) throws IOException {
      setNode(statisticsPane);
    }

    @FXML
    private void article(ActionEvent event) throws IOException {
       setNode(articlesPane);
    }

    @FXML
    private void accomodation(ActionEvent event) {
        //setNode(accomodationsPane);
    }

    @FXML
    private void homePage(ActionEvent event) {
        setNode(homePane);
    }

    @FXML
    private void groups(ActionEvent event) {
        //setNode(groupsPane);
    }

    @FXML
    private void stream(ActionEvent event) {
        //setNode(streamPane);
    }

    @FXML
    private void logout(MouseEvent event) {
    }

    @FXML
    private void updateUserDetails(MouseEvent event) {
    }

    @FXML
    private void games(ActionEvent event) {
        setNode(gamesPane);
    }
    
}
