/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author apple
 */
public class Game {
    private int match_id;
    private Date date_match;
    private String referee;
    private String time;
    private String Team1Score;
    private String Team2Score;
    public String gameKind; 
    public String Team1;
    public String Team2;
    public String Venue;
    public String Stadium;
    public String MatchNumber;

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public Date getDate_match() {
        return date_match;
    }

    public void setDate_match(String date_match) {
        DateFormat format = new SimpleDateFormat("yyyy-MMMM-d");
        try {
            this.date_match= format.parse(date_match);
        } catch (ParseException ex) {
            System.out.println("err");
        }
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeam1Score() {
        return Team1Score;
    }

    public void setTeam1Score(String Team1Score) {
        this.Team1Score = Team1Score;
    }

    public String getTeam2Score() {
        return Team2Score;
    }

    public void setTeam2Score(String Team2Score) {
        this.Team2Score = Team2Score;
    }

    public String getGameKind() {
        return gameKind;
    }

    public void setGameKind(String gameKind) {
        this.gameKind = gameKind;
    }

    public String getTeam1() {
        return Team1;
    }

    public void setTeam1(String Team1) {
        this.Team1 = Team1;
    }

    public String getTeam2() {
        return Team2;
    }

    public void setTeam2(String Team2) {
        this.Team2 = Team2;
    }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String Venue) {
        this.Venue = Venue;
    }

    public String getStadium() {
        return Stadium;
    }

    public void setStadium(String Stadium) {
        this.Stadium = Stadium;
    }

    public String getMatchNumber() {
        return MatchNumber;
    }

    public void setMatchNumber(String MatchNumber) {
        this.MatchNumber = MatchNumber;
    }

    public Game(int match_id, Date date_match, String referee, String time, String Team1Score, String Team2Score, String gameKind, String Team1, String Team2, String Venue, String Stadium, String MatchNumber) {
        this.match_id = match_id;
        this.date_match = date_match;
        this.referee = referee;
        this.time = time;
        this.Team1Score = Team1Score;
        this.Team2Score = Team2Score;
        this.gameKind = gameKind;
        this.Team1 = Team1;
        this.Team2 = Team2;
        this.Venue = Venue;
        this.Stadium = Stadium;
        this.MatchNumber = MatchNumber;
    }

    public Game(Date date_match, String referee, String time, String Team1Score, String Team2Score, String gameKind, String Team1, String Team2, String Venue, String Stadium, String MatchNumber) {
        this.date_match = date_match;
        this.referee = referee;
        this.time = time;
        this.Team1Score = Team1Score;
        this.Team2Score = Team2Score;
        this.gameKind = gameKind;
        this.Team1 = Team1;
        this.Team2 = Team2;
        this.Venue = Venue;
        this.Stadium = Stadium;
        this.MatchNumber = MatchNumber;
    }
        
    
    
    public Game()
    {
        
    }


 
    
    
    
}
