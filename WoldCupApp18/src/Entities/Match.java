/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author apple
 */
public class Match {
    private int match_id;
    private Date date_match;
    private String referee;
    private String time;
    private int Winner_teamScore;
    private int Looser_teamScore;
    public String gameKind; 
    public String Winnerteam;
    public String LooserTeam;
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

    public int getWinner_teamScore() {
        return Winner_teamScore;
    }

    public void setWinner_teamScore(int Winner_teamScore) {
        this.Winner_teamScore = Winner_teamScore;
    }

    public int getLooser_teamScore() {
        return Looser_teamScore;
    }

    public void setLooser_teamScore(int Looser_teamScore) {
        this.Looser_teamScore = Looser_teamScore;
    }

    public String getGameKind() {
        return gameKind;
    }

    public void setGameKind(String gameKind) {
        this.gameKind = gameKind;
    }

    public String getWinnerteam() {
        return Winnerteam;
    }

    public void setWinnerteam(String Winnerteam) {
        this.Winnerteam = Winnerteam;
    }

    public String getLooserTeam() {
        return LooserTeam;
    }

    public void setLooserTeam(String LooserTeam) {
        this.LooserTeam = LooserTeam;
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

    public Match(int match_id, Date date_match, String referee, String time, int Winner_teamScore, int Looser_teamScore, String gameKind, String Winnerteam, String LooserTeam, String Venue, String Stadium, int MatchNumber) {
        this.match_id = match_id;
        this.date_match = date_match;
        this.referee = referee;
        this.time = time;
        this.Winner_teamScore = Winner_teamScore;
        this.Looser_teamScore = Looser_teamScore;
        this.gameKind = gameKind;
        this.Winnerteam = Winnerteam;
        this.LooserTeam = LooserTeam;
        this.Venue = Venue;
        this.Stadium = Stadium;
        this.MatchNumber = MatchNumber;
    }

    public Match(Date date_match, String referee, String time, int Winner_teamScore, int Looser_teamScore, String gameKind, String Winnerteam, String LooserTeam, String Venue, String Stadium, int MatchNumber) {
        this.date_match = date_match;
        this.referee = referee;
        this.time = time;
        this.Winner_teamScore = Winner_teamScore;
        this.Looser_teamScore = Looser_teamScore;
        this.gameKind = gameKind;
        this.Winnerteam = Winnerteam;
        this.LooserTeam = LooserTeam;
        this.Venue = Venue;
        this.Stadium = Stadium;
        this.MatchNumber = MatchNumber;
    }
    public Match()
    {
        
    }
   
    public Match(Date date_match, String referee, String time, int Winner_teamScore, int Looser_teamScore) {
        this.date_match = date_match;
        this.referee = referee;
        this.time = time;
        this.Winner_teamScore = Winner_teamScore;
        this.Looser_teamScore = Looser_teamScore;
    }



 
    
    
    
}
