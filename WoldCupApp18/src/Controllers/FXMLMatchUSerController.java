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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ShowStream(ActionEvent event) {
           Webeng.load("blob:http://www.247bay.tv/b6a24975-0f4a-4857-b465-351b7b5e7288");
          StreamPane.getChildren().addAll(StreamBeing);

    }

    @FXML
    private void ReloadFn(ActionEvent event) {
        Webeng.reload();
    }
    
    
    
}
