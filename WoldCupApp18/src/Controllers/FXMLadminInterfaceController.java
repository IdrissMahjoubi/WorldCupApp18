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
public class FXMLadminInterfaceController implements Initializable {

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
      
    }

    @FXML
    private void article(ActionEvent event) throws IOException {
       
    }

    @FXML
    private void accomodation(ActionEvent event) {
        
           try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/Views/FXMLShowStadiums.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLadminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void homePage(ActionEvent event) {
       
    }

    @FXML
    private void groups(ActionEvent event) {
        try {
                        Parent page1 = FXMLLoader.load(getClass().getResource("/Views/FXMLadminHotel.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLadminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void stream(ActionEvent event) {
        try {
                        Parent page1 = FXMLLoader.load(getClass().getResource("/Views/FXMLShowStations.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLadminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    

    @FXML
    private void logout(MouseEvent event) throws IOException {
        try {
                        Parent page1 = FXMLLoader.load(getClass().getResource("/Views/FXMLauthentification.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLadminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void updateUserDetails(MouseEvent event) {
            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/Views/FXMLShowUserToAdmin.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLadminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void games(ActionEvent event) {
        
                try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/Views/FXMLShowMatchs.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLadminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
