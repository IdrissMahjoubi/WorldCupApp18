/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import Entities.Match;
import Services.Match_services;
import Controllers.FXMLShowMatchController;
import Controllers.FXMLShowMatchsController;
/**
 * FXML Controller class
 *
 * @author apple
 */
public class FXMLAddMatchController implements Initializable {
    @FXML
    private TextField Referee_textfield;
    @FXML
    private Button add_button;
    @FXML
    private DatePicker DatePiker;
    
    Match_services match_services = Match_services.getInstance();
    @FXML
    private TextField winner_textfield;
    @FXML
    private TextField looser_textfield;
    @FXML
    private TextField time_textfield;
    @FXML
    private TextField gamekind_textfield;
    @FXML
    private TextField winnerTeam_textfield1;
    @FXML
    private TextField LooserTeam_textfield;
    @FXML
    private TextField Venue_textfield;
    @FXML
    private TextField Stadium_textfield;
    @FXML
    private TextField MatchNumber_textfield;
    @FXML
    private Button return_button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SaveMatch(ActionEvent event) {
        
        Match m=new Match();
        m.setDate_match(java.sql.Date.valueOf(DatePiker.getValue()));
        m.setGameKind(gamekind_textfield.getText());
        m.setTeam2(LooserTeam_textfield.getText());
        m.setTeam2Score(Integer.parseInt(looser_textfield.getText()));
        m.setMatchNumber(Integer.parseInt(MatchNumber_textfield.getText()));
        m.setReferee(Referee_textfield.getText());
        m.setStadium(Stadium_textfield.getText());
        m.setTime(time_textfield.getText());
        m.setVenue(Venue_textfield.getText());
        m.setTeam1(winnerTeam_textfield1.getText());
        m.setTeam1Score(Integer.parseInt(winner_textfield.getText()));
        
        match_services.createMatch(m);
        FXMLShowMatchsController.alertMessage("ajout reussie",Alert.AlertType.INFORMATION);

        
          FXMLLoader ld=new FXMLLoader(getClass().getResource("/Views/FXMLShowMatchs.fxml"));
        
        try {
            Parent root= ld.load();
            DatePiker.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());       
        }
    }

    @FXML
    private void ReturnToView(ActionEvent event) {
               
          FXMLLoader ld=new FXMLLoader(getClass().getResource("/Views/FXMLShowMatchs.fxml"));
        
        try {
            Parent root= ld.load();
            DatePiker.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Return ERROR= "+ex.getMessage());       
        }
    }



}
