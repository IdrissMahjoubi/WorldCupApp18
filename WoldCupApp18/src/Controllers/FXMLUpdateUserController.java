/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import Entities.User;
import Services.ServiceUser;
import Utilities.Session;
import java.sql.Date;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author MyTEK
 */
public class FXMLUpdateUserController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField last_name;
    @FXML
    private DatePicker birthday;
    @FXML
    private TextField nationaity;
    @FXML
    private TextField mail;
    @FXML
    private TextField tel;
    @FXML
    private TextField login;
    @FXML
    private TextField password;
    @FXML
    private ChoiceBox<String> team;
     ObservableList<String> comboList = FXCollections.observableArrayList("Egypte", "Maroc","Nigeria","Sénégal","Tunisie","Arabie Saoudite","Australie","Japon","Republique de Coree","RI Iran","Allemagne","Angleterre","Belgique","Croatie","Danemark","Espagne","France","Islande","Pologne","Portugal","Russie","Serbie","Suède","Suisse","Costa Rica","Mexique","Panama","Argentine","Brésil","Colombie","Pérou","Uruguay");
    @FXML
    private Button buttonvalid;
    @FXML
    private Button logout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         team.setItems(comboList);
         name.setText(Session.LoggedUser.getUser_name());
         last_name.setText(Session.LoggedUser.getUser_last_name());
         //birthday.value((Session.LoggedUser.getUser_birthday()));
         nationaity.setText(Session.LoggedUser.getUser_nationality());
         mail.setText(Session.LoggedUser.getUser_email());
         tel.setText(Integer.toString(Session.LoggedUser.getUser_tel()));
         login.setText(Session.LoggedUser.getUser_login());
         password.setText(Session.LoggedUser.getUser_password());
         team.getSelectionModel().selectFirst();
    }    

    @FXML
    private void updateUser(ActionEvent event) {
        
        int ID_User_new = Session.LoggedUser.getUser_id();
        
            ServiceUser su = new ServiceUser();
            User u = new User();
            
            
            u.setUser_id(Integer.valueOf(ID_User_new));
            
            u.setUser_name(name.getText());
            
            u.setUser_last_name(last_name.getText());
           
            u.setUser_birthday(java.sql.Date.valueOf(birthday.getValue()));
            
            u.setUser_nationality(nationaity.getText());
           
            u.setUser_email(mail.getText());
            
            u.setUser_tel(Integer.parseInt(tel.getText()));
            
            u.setUser_login(login.getText());
            
            u.setUser_password(password.getText());
            //team.setText(Session.LoggedUser.getUser_team());
            u.setUser_team(team.getValue());
            su.updateUser(u);
            System.out.println("update reussi");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Modifier Stadium ");
            alert.setHeaderText("La modification de votre compte a été effectué avec succès");
            Optional<ButtonType> result = alert.showAndWait();
            
    }

    @FXML
    private void logout(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLauthentification.fxml"));  
        try {
            Parent root = loader.load();
            FXMLauthentificationController dc = loader.getController();
            logout.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLauthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
}
