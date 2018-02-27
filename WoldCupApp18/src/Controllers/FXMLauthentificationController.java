/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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

import Services.ServiceUser;
import Utilities.Session;
import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.HyperlinkLabel;

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
    private Label ForgotPass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void authentification(ActionEvent event) throws SQLException {
        ServiceUser s = new ServiceUser();
        //System.out.println(s.CheckLoginAndPassword(login.getText(), password.getText()));
        if ((s.CheckLoginAndPassword(login.getText(), password.getText())) == 0){
            
            
             Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("error");
            alert.setHeaderText("Please check your parameters");
             Optional<ButtonType> result = alert.showAndWait();
            
        }
        else {
            
            if ("admin".equals(s.CheckType(login.getText(), password.getText())) && (s.CheckState(login.getText(), password.getText()))== 1 ){
            Session.LoggedUser = (s.findByLogin(login.getText()));

               
                
                /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Bienvenu");
            alert.setHeaderText("authentification avec succes ");
             Optional<ButtonType> result = alert.showAndWait();*/
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLadminInterface.fxml"));
        try {
            Parent root = loader.load();
            FXMLadminInterfaceController dc = loader.getController();
            connect.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLadminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
            else if ("membre".equals(s.CheckType(login.getText(), password.getText())) && (s.CheckState(login.getText(), password.getText()))== 1 ) {
                 
                             Session.LoggedUser = (s.findByLogin(login.getText()));
                             	//mail
        
                  /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Bienvenu");
            alert.setHeaderText("authentification avec succes ");
             Optional<ButtonType> result = alert.showAndWait();*/
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLUserinterface.fxml"));
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLCreate.fxml"));
        try {
            Parent root = loader.load();
            FXMLCreateAccountController dc = loader.getController();
            creer.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLCreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void sendSms(MouseDragEvent event) {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLPasswordRecovery.fxml"));
        try {
            Parent root = loader.load();
            FXMLPasswordRecoveryController pr = loader.getController();
            creer.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPasswordRecoveryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void SelectLabel(MouseEvent event) {
                ForgotPass.setStyle("-fx-text-fill:#273c75");

    }

    @FXML
    private void DeselectLabel(MouseEvent event) {
                        ForgotPass.setStyle("-fx-text-fill:#273c75");

    }
    
}
