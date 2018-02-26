/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author apple
 */
public class FXMLMatchUSerController implements Initializable {

    @FXML
    private StackPane StreamPane;
    @FXML
    private JFXButton ShowStream;
    
    WebView StreamBeing = new WebView();
    WebEngine Webeng = StreamBeing.getEngine();
    @FXML
    private JFXButton Reload;
    @FXML
    private JFXButton Back;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ShowStream(ActionEvent event) {
           Webeng.load("https://connect.bein.net/en/");
          StreamPane.getChildren().addAll(StreamBeing);

    }

    @FXML
    private void ReloadFn(ActionEvent event) {
        Webeng.reload();
    }

    @FXML
    private void SwitchShowMatchUser(ActionEvent event) {
    }
    
    
    
}
