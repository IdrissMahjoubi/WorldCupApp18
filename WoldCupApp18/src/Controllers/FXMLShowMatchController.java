/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author apple
 */
public class FXMLShowMatchController implements Initializable {
    @FXML
    private Label Label_date;
    @FXML
    private Label Label_Referee;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    public Label getLabel_date() {
        return Label_date;
    }

    public void setLabel_date(String Label_date) {
        this.Label_date.setText(Label_date);
    }

    public Label getLabel_Referee() {
        return Label_Referee;
    }

    public void setLabel_Referee(String Label_Referee) {
        this.Label_Referee.setText(Label_Referee);
    }


    }    
    

