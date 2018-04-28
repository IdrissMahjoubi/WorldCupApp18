/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.view;

import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.spinner.Picker;
import com.esprit.Service.ServiceGame;
import com.esprit.Entities.Game;
import javafx.scene.control.DatePicker;

/**
 *
 * @author sana
 */
public class HomeGame {

    Form f;

    Picker gameDate;
    TextField referee;
    Picker time;
    TextField Team1Score;
    TextField Team2Score;
    TextField gameKind; 
    TextField Team1;
    TextField Team2;
    TextField Venue;
    TextField Stadium;
    TextField MatchNumber;
    Button AddButton,ShowButton;

    public HomeGame() {
        f = new Form("home");
     gameDate =new Picker();
     gameDate.setType(Display.PICKER_TYPE_DATE);
     referee = new TextField();
     time =new Picker();
     time.setType(Display.PICKER_TYPE_TIME); 
     Team1Score= new TextField(TextArea.NUMERIC);
     Team2Score= new TextField(TextArea.NUMERIC);
     gameKind= new TextField(); 
     Team1= new TextField();
     Team2= new TextField();
     Venue= new TextField();
     Stadium= new TextField();
     MatchNumber= new TextField(TextArea.NUMERIC);
     
        AddButton = new Button("Add");
        ShowButton=new Button("Show");
        f.add(gameDate);
        f.add(MatchNumber);
        f.add(Stadium);
        f.add(Venue);
        f.add(Team1);
        f.add(Team2);
        f.add(Team1Score);
        f.add(Team2Score);
        f.add(time);
        f.add(referee);
        f.add(gameKind);

        f.add(AddButton);
        f.add(ShowButton);
        AddButton.addActionListener((e) -> {
            ServiceGame serviceGame = new ServiceGame();
           
           Game game = new Game(gameDate.getDate(), referee.getText(), time.getText(), Team1Score.getText(), Team2Score.getText(), gameKind.getText(), Team1.getText(), Team2.getText(), Venue.getText(), Stadium.getText(), MatchNumber.getText());
//ADD FUNCTION CALL HERE            

        });
        ShowButton.addActionListener((e)->{
        ShowGame a=new ShowGame();
        a.getF().show();
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }



    public Picker getGameDate() {
        return gameDate;
    }

    public void setGameDate(Picker gameDate) {
        this.gameDate = gameDate;
    }

    public TextField getReferee() {
        return referee;
    }

    public void setReferee(TextField referee) {
        this.referee = referee;
    }

    public Picker getTime() {
        return time;
    }

    public void setTime(Picker time) {
        this.time = time;
    }

    public TextField getTeam1Score() {
        return Team1Score;
    }

    public void setTeam1Score(TextField Team1Score) {
        this.Team1Score = Team1Score;
    }

    public TextField getTeam2Score() {
        return Team2Score;
    }

    public void setTeam2Score(TextField Team2Score) {
        this.Team2Score = Team2Score;
    }

    public TextField getGameKind() {
        return gameKind;
    }

    public void setGameKind(TextField gameKind) {
        this.gameKind = gameKind;
    }

    public TextField getTeam1() {
        return Team1;
    }

    public void setTeam1(TextField Team1) {
        this.Team1 = Team1;
    }

    public TextField getTeam2() {
        return Team2;
    }

    public void setTeam2(TextField Team2) {
        this.Team2 = Team2;
    }

    public TextField getVenue() {
        return Venue;
    }

    public void setVenue(TextField Venue) {
        this.Venue = Venue;
    }

    public TextField getStadium() {
        return Stadium;
    }

    public void setStadium(TextField Stadium) {
        this.Stadium = Stadium;
    }

    public TextField getMatchNumber() {
        return MatchNumber;
    }

    public void setMatchNumber(TextField MatchNumber) {
        this.MatchNumber = MatchNumber;
    }
    
    

}
