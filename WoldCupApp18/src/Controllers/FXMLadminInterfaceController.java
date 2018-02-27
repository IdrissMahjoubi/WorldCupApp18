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
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author MyTEK
 */
public class FXMLadminInterfaceController implements Initializable {

    @FXML
    private Button gererusers;
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
    private void gererUsers(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLupdateuserrights.fxml"));  
        try {
            Parent root = loader.load();
            FXMLShowUserToAdminController dc = loader.getController();
            gererusers.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLShowUserToAdminController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @FXML
    private void goToHotels(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLadminHotel.fxml"));  
        try {
            Parent root = loader.load();
            FXMLadminHotelController dc = loader.getController();
            hotels.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLadminHotelController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
