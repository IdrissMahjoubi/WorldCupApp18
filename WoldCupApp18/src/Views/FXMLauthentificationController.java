/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import Services.service_user;
import Utilities.Session;
import com.jfoenix.controls.JFXButton;

/**
 * FXML Controller class
 *
 * @author MyTEK
 */
public class FXMLauthentificationController implements Initializable {

    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private Button connect;
    @FXML
    private Button creer;
    @FXML
    private JFXButton sms;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void authentification(ActionEvent event) throws SQLException {
        service_user s = new service_user();
        System.out.println(s.CheckLoginAndPassword(login.getText(), password.getText()));
        if ((s.CheckLoginAndPassword(login.getText(), password.getText())) == 0){
            
            System.out.println("asber");
            System.out.println("veuillez verifier vos parametres");
             Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("erreur");
            alert.setHeaderText("veuillez verifier vos parametres");
             Optional<ButtonType> result = alert.showAndWait();
            
        }
        else {
           System.out.println("sahit"); 
            if ("admin".equals(s.CheckType(login.getText(), password.getText())) && (s.CheckState(login.getText(), password.getText()))== 1 ){
            Session.LoggedUser = (s.findByLogin(login.getText()));

                System.out.println("bienvenue admin");
                
                /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Bienvenu");
            alert.setHeaderText("authentification avec succes ");
             Optional<ButtonType> result = alert.showAndWait();*/
             FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLadminInterface.fxml"));
        try {
            Parent root = loader.load();
            FXMLadminInterfaceController dc = loader.getController();
            connect.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLadminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
            else if ("membre".equals(s.CheckType(login.getText(), password.getText())) && (s.CheckState(login.getText(), password.getText()))== 1 ) {
                 System.out.println("bienvenue membre");
                             Session.LoggedUser = (s.findByLogin(login.getText()));
                             	//mail
        
                  /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Bienvenu");
            alert.setHeaderText("authentification avec succes ");
             Optional<ButtonType> result = alert.showAndWait();*/
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLUserinterface.fxml"));
        try {
            Parent root = loader.load();
            FXMLUserinterfaceController dc = loader.getController();
            connect.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLUserinterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        } 
                
            }else{
                 Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("erreur");
            alert.setHeaderText("ce compte est bloqué");
             Optional<ButtonType> result = alert.showAndWait();
                
                }
        }
    }

    @FXML
    private void creerCompte(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLCreate.fxml"));
        try {
            Parent root = loader.load();
            FXMLCreateController dc = loader.getController();
            creer.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLCreateController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void sendSms(ActionEvent event) {
    }
    
}
