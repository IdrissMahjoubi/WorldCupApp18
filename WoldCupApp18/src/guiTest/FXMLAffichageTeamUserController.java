/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiTest;

import Controllers.FXMLUserinterfaceController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author MyTEK
 */
public class FXMLAffichageTeamUserController implements Initializable {

    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> team;
    @FXML
    private TableColumn<?, ?> coach;
    @FXML
    private TableColumn<?, ?> group;
    @FXML
    private TableColumn<?, ?> continent;
    @FXML
    private ImageView flagview;
    @FXML
    private ImageView logoview;
    @FXML
    private Button PLAY;
    @FXML
    private Button STOP;
    @FXML
    private ChoiceBox<?> choice;
    @FXML
    private TextField rechercheteam_txt;
    @FXML
    private ComboBox<?> continents;
    @FXML
    private ComboBox<?> groupes;
    @FXML
    private Button home;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void play(ActionEvent event) {
    }

    @FXML
    private void stop(ActionEvent event) {
    }

    @FXML
    private void rechercheContinent(ActionEvent event) {
    }

    @FXML
    private void rechercheGroupes(ActionEvent event) {
    }

    @FXML
    private void SwitchToHome(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLUserinterface.fxml"));  
        try {
            Parent root = loader.load();
            FXMLUserinterfaceController dc = loader.getController();
            home.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("ERROR USER DETAILS=" + ex.getMessage()); 
        }
    }
    
}
