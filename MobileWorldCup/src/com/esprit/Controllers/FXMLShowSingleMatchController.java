/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Controllers;

import Entities.Match;
import Entities.Team;
import Services.Match_services;
import Services.ServiceTeam;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author apple
 */
public class FXMLShowSingleMatchController implements Initializable {

    @FXML
    private Label VS;
    @FXML
    private ImageView Team1;
    @FXML
    private ImageView Team2;
    @FXML
    public AnchorPane Mainpane;
    Match_services ms = Match_services.getInstance();
    Team t1, t2;
    Match m;
    @FXML
    private Text MatchDate;
    @FXML
    private Text MatchTime;
    @FXML
    private Text MatchNumber;
    @FXML
    private Text MatchStad;
    @FXML
    private Text MatchVenue;
    @FXML
    private Text MatchKind;
    @FXML
    private Text MatchReferee;
    @FXML
    private Text NameTeam1;
    @FXML
    private Text PointsTeam1;
    @FXML
    private Text PositionTeam1;
    @FXML
    private Text WonTeam1;
    @FXML
    private Text LostTeam1;
    @FXML
    private Text DrawTeam1;
    @FXML
    private Text AgainstTeam1;
    @FXML
    private Text ForTeam1;
    @FXML
    private Text ScoreTeam1;
    @FXML
    private Text PlayedTeam1;
    @FXML
    private Text NameTeam2;
    @FXML
    private Text PointsTeam2;
    @FXML
    private Text PositionTeam2;
    @FXML
    private Text WonTeam2;
    @FXML
    private Text LostTeam2;
    @FXML
    private Text DrawTeam2;
    @FXML
    private Text AgainstTeam2;
    @FXML
    private Text ForTeam2;
    @FXML
    private Text ScoreTeam2;
    @FXML
    private Text PlayedTeam2;
    @FXML
    private JFXButton BackBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        System.out.println("Single " + FXMLShowMatchUserController.matchNumber);
        m = ms.getMatchbyMatchNumber(FXMLShowMatchUserController.matchNumber);
        t1 = ms.getTeamByName(m.Team1);
        t2 = ms.getTeamByName(m.Team2);
        System.out.println("two " + FXMLShowMatchUserController.matchNumber);

        InitLogos();
        InitMatch(m);
        InitTeam(t1, t2);
        System.out.println("three" + FXMLShowMatchUserController.matchNumber);

    }

    public void InitLogos() {

        File file1 = new File("src/Resources/Icons/Logos/" + t1.getTEAM_LOGO());
        Image image1 = new Image(file1.toURI().toString());
        Team1.setImage(image1);

        File file2 = new File("src/Resources/Icons/Logos/" + t2.getTEAM_LOGO());
        Image image2 = new Image(file2.toURI().toString());
        Team2.setImage(image2);

    }

    public void InitMatch(Match m) {

        MatchDate.setText(m.getDate_match().toString());
        MatchTime.setText(m.getTime());
        MatchNumber.setText(String.valueOf(m.getMatchNumber()));
        MatchStad.setText(m.getStadium());
        MatchVenue.setText(m.getVenue());
        MatchKind.setText(m.getGameKind());
        MatchReferee.setText(m.getReferee());
        ScoreTeam1.setText(String.valueOf(m.getTeam1Score()));
        ScoreTeam2.setText(String.valueOf(m.getTeam2Score()));

    }

    public void InitTeam(Team t1, Team t2) {
        NameTeam1.setText(t1.getTEAM_NAME());
        PointsTeam1.setText(String.valueOf(t1.getTEAM_POINTS()));
        PositionTeam1.setText(String.valueOf(t1.getTEAM_POSITION()));
        WonTeam1.setText(String.valueOf(t1.getTEAM_NUMBERMATCHWON()));
        LostTeam1.setText(String.valueOf(t1.getTEAM_NUMBERMATCHLOST()));
        DrawTeam1.setText(String.valueOf(t1.getTEAM_NUMBERMATCHDRAW()));
        AgainstTeam1.setText(String.valueOf(t1.getTEAM_GOALSAGAINST()));
        ForTeam1.setText(String.valueOf(t1.getTEAM_GOALSFOR()));
        PlayedTeam1.setText(String.valueOf(t1.getTEAM_NUMBERMATCHPLAYED()));

        NameTeam2.setText(t2.getTEAM_NAME());
        PointsTeam2.setText(String.valueOf(t2.getTEAM_POINTS()));
        PositionTeam2.setText(String.valueOf(t2.getTEAM_POSITION()));
        WonTeam2.setText(String.valueOf(t2.getTEAM_NUMBERMATCHWON()));
        LostTeam2.setText(String.valueOf(t2.getTEAM_NUMBERMATCHLOST()));
        DrawTeam2.setText(String.valueOf(t2.getTEAM_NUMBERMATCHDRAW()));
        AgainstTeam2.setText(String.valueOf(t2.getTEAM_GOALSAGAINST()));
        ForTeam2.setText(String.valueOf(t2.getTEAM_GOALSFOR()));
        PlayedTeam2.setText(String.valueOf(t2.getTEAM_NUMBERMATCHPLAYED()));
    }

    @FXML
    private void backFunction(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/Views/FXMLShowMatchUser.fxml"));
            Mainpane.getChildren().setAll(pane);
        } catch (IOException ex) {
            System.out.println("error view" + ex.getMessage());
        }
    }

}
