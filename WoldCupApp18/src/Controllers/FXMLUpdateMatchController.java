/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import Entities.Match;
import Entities.Team;
import Services.Match_services;

/**
 * FXML Controller class
 *
 * @author apple
 */
public class FXMLUpdateMatchController implements Initializable {

    @FXML
    private TextField Referee_textfield;
    @FXML
    private Button update_button;
    @FXML
    private DatePicker DatePiker;
    @FXML
    private TextField winner_textfield;
    @FXML
    private TextField looser_textfield;
    @FXML
    private TextField time_textfield;
    Match_services match_services = Match_services.getInstance();
    private int id_match;
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

    public int getId_match() {
        return id_match;
    }

    public void setId_match(int id_match) {
        this.id_match = id_match;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public TextField getReferee_textfield() {
        return Referee_textfield;
    }

    public void setReferee_textfield(String Referee_textfield) {
        this.Referee_textfield.setText(Referee_textfield);
    }

    public DatePicker getDatePiker() {
        return DatePiker;
    }

    public void setDatePiker(Date DatePiker) {
        this.DatePiker.setValue(DatePiker.toLocalDate());

    }

    public TextField getWinner_textfield() {
        return winner_textfield;
    }

    public void setWinner_textfield(Integer winner_textfield) {
        this.winner_textfield.setText(winner_textfield.toString());
    }

    public TextField getLooser_textfield() {
        return looser_textfield;
    }

    public void setLooser_textfield(Integer looser_textfield) {
        this.looser_textfield.setText(looser_textfield.toString());
    }

    public TextField getTime_textfield() {
        return time_textfield;
    }

    public void setTime_textfield(String time_textfield) {
        this.time_textfield.setText(time_textfield);
    }

    public TextField getGamekind_textfield() {
        return gamekind_textfield;
    }

    public void setGamekind_textfield(String gamekind_textfield) {
        this.gamekind_textfield.setText(gamekind_textfield);
    }

    public TextField getWinnerTeam_textfield1() {
        return winnerTeam_textfield1;
    }

    public void setWinnerTeam_textfield1(String winnerTeam_textfield1) {
        this.winnerTeam_textfield1.setText(winnerTeam_textfield1);
    }

    public TextField getLooserTeam_textfield() {
        return LooserTeam_textfield;
    }

    public void setLooserTeam_textfield(String LooserTeam_textfield) {
        this.LooserTeam_textfield.setText(LooserTeam_textfield);
    }

    public TextField getVenue_textfield() {
        return Venue_textfield;
    }

    public void setVenue_textfield(String Venue_textfield) {
        this.Venue_textfield.setText(Venue_textfield);
    }

    public TextField getStadium_textfield() {
        return Stadium_textfield;
    }

    public void setStadium_textfield(String Stadium_textfield) {
        this.Stadium_textfield.setText(Stadium_textfield);
    }

    public TextField getMatchNumber_textfield() {
        return MatchNumber_textfield;
    }

    public void setMatchNumber_textfield(Integer MatchNumber_textfield) {
        this.MatchNumber_textfield.setText(MatchNumber_textfield.toString());
    }

    @FXML
    private void Update() {

        FXMLLoader ld = new FXMLLoader(getClass().getResource("/Views/FXMLShowMatchs.fxml"));

        try {
            String referee = Referee_textfield.getText();
            int winnerScore = Integer.parseInt(winner_textfield.getText());
            int looserScore = Integer.parseInt(looser_textfield.getText());
            String time = time_textfield.getText();
            java.sql.Date date = java.sql.Date.valueOf(DatePiker.getValue());
            String gamekind = gamekind_textfield.getText();
            String looserTeam = LooserTeam_textfield.getText();
            int MatchNumber = Integer.parseInt(MatchNumber_textfield.getText());
            String stadium = Stadium_textfield.getText();
            String venue = Venue_textfield.getText();
            String winnerTeam = winnerTeam_textfield1.getText();
            int Id= getId_match();
            Match M = new Match(Id, date, referee, time, winnerScore, looserScore, gamekind, winnerTeam, looserTeam, venue, stadium, MatchNumber);
            


            match_services.PointsCount(M);
            match_services.updateMatch(M);
            Parent root = ld.load();
            update_button.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println("Update Controller ERROR="+ex.getMessage());
        }

    }

    @FXML
    private void ReturnToView(ActionEvent event) {
                FXMLLoader ld = new FXMLLoader(getClass().getResource("/Views/FXMLShowMatchs.fxml"));
            try{
            Parent root = ld.load();
            update_button.getScene().setRoot(root);
                    } catch (IOException ex) {
            System.out.println("Return ERROR="+ex.getMessage());
        }
        
    }
}
    

