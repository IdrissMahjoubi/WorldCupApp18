/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.User;
import Services.ServiceUser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MyTEK
 */
public class FXMLPasswordRecoveryController implements Initializable {

    @FXML
    private RadioButton smsOption;
    @FXML
    private RadioButton emailOption;
    @FXML
    private JFXTextField emailfield;
    @FXML
    private JFXTextField smsfield;
    @FXML
    private JFXButton sendPass;

    public static String isfound="";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        emailfield.setVisible(false);
        smsfield.setVisible(false);
        
        smsOption.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                smsfield.setVisible(true);
               emailOption.setSelected(false);
               emailfield.setVisible(false);
            }
        });
        
        emailOption.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               emailfield.setVisible(true);
               smsOption.setSelected(false);
               smsfield.setVisible(false);
            }
        });
        
        sendPass.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
               submitAction();
               if(isfound.equals("true"))
               {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Password recovery",new ButtonType("OK"));
                   
                    alert.setTitle("Password recovery");
                            alert.show();
                            alert.setOnCloseRequest(new EventHandler<DialogEvent>() {
                        @Override
                        public void handle(DialogEvent event) {
                         ((Stage) emailfield.getScene().getWindow()).close();

                         
                        }
                    });

               }
               else
                   if (isfound.equals("false"))
                   {
                     Alert alert = new Alert(Alert.AlertType.WARNING, "Sorry ! Inexistant Account",new ButtonType("OK"));
                    alert.show();
                    alert.setOnCloseRequest(new EventHandler<DialogEvent>() {
                         @Override
                         public void handle(DialogEvent event) {
                                                  ((Stage) emailfield.getScene().getWindow()).close();

                                
                         }
                     });
                   }
               
            }
        });
    }   
    
    
    private void submitAction()
    {
                if (smsOption.isSelected())
        {
            String userSms = smsfield.getText();
            
            
            ServiceUser.sendPassword2(new User(userSms, 1));
            
        }
         if (emailOption.isSelected())
        {

                        
                    String userEmail=emailfield.getText();
                    ServiceUser.sendPassword(new User(userEmail));
        }
        }
    
    

    
}
