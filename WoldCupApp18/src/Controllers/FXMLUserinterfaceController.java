/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void updateUserDetails(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLUpdateUser.fxml"));  
        try {
            Parent root = loader.load();
            FXMLUpdateUserController dc = loader.getController();
            bouton_modif.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("ERROR USER DETAILS=" + ex.getMessage());        } 
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
            Parent root = FXMLLoader.load(getClass().getResource("/Views/FXMLAffichageTeams.fxml"));
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
            Logger.getLogger(FXMLuserHotelController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
