/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entities;

import java.sql.Date;

/**
 *
 * @author apple
 */
public class Game {
    private int match_id;
    private Date date_match;
    private String referee;
    private String time;
    private int Team1Score;
    private int Team2Score;
    public String gameKind; 
    public String Team1;
    public String Team2;
    public String Venue;
    public String Stadium;
    public int MatchNumber;
        
    
    
    public int getMatchNumber() {
        return MatchNumber;
    }

    public void setMatchNumber(int MatchNumber) {
        this.MatchNumber = MatchNumber;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public Date getDate_match() {
        return date_match;
    }

    public void setDate_match(Date date_match) {
        this.date_match = date_match;
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

    public int getTeam1Score() {
        return Team1Score;
    }

    public void setTeam1Score(int Winner_teamScore) {
        this.Team1Score = Winner_teamScore;
    }

    public int getTeam2Score() {
        return Team2Score;
    }

    public void setTeam2Score(int Looser_teamScore) {
        this.Team2Score = Looser_teamScore;
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

    public void setTeam1(String Winnerteam) {
        this.Team1 = Winnerteam;
    }

    public String getTeam2() {
        return Team2;
    }

    public void setTeam2(String LooserTeam) {
        this.Team2 = LooserTeam;
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

    public Game(int match_id, Date date_match, String referee, String time, int Team1Score, int Team2Score, String gameKind, String Team1, String Team2, String Venue, String Stadium, int MatchNumber) {
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

    public Game(Date date_match, String referee, String time, int Team1Score, int Team2Score, String gameKind, String Team1, String Team2, String Venue, String Stadium, int MatchNumber) {
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
   
    public Game(Date date_match, String referee, String time, int Winner_teamScore, int Looser_teamScore) {
        this.date_match = date_match;
        this.referee = referee;
        this.time = time;
        this.Team1Score = Winner_teamScore;
        this.Team2Score = Looser_teamScore;
    }



 
    
    
    
}
