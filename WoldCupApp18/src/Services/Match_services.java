/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Entities.Match;
import Utilities.DataSource;

/**
 *
 * @author apple
 */
public class Match_services implements Match_inteface {

    DataSource ds = DataSource.getInstance();
    Statement statement;
    Connection connection;
    ResultSet result;
    static Match_services instance;

    public Match_services() {
            connection = ds.getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println("Constructor Match Service" + ex.getMessage());
        }
    }

    public static Match_services getInstance() {
        if (instance == null) {
            instance = new Match_services();
        }
        return instance;
    }
    /**
     *
     * @param m
     */
    @Override
    public void createMatch(Match m) {

          String requete = "INSERT INTO `GAME`(`GAME_KIND`, `GAME_WINNERTEAM`, `GAME_LOSSTEAM`, `GAME_TIME`, `GAME_DATE`, `GAME_WINNERTEAMSCORE`, `GAME_LOSSTEAMSCORE`, `GAME_REFEREE`, `GAME_STADIUM`, `GAME_VENUE`, `GAME_MATCHNUMBER`) VALUES ('"+m.getGameKind()+"','"+m.getWinnerteam()+"','"+m.getLooserTeam()+"','"+m.getTime()+"','"+m.getDate_match()+"','"+m.getWinner_teamScore()+"','"+m.getLooser_teamScore()+"','"+m.getReferee()+"','"+m.getStadium()+"','"+m.getVenue()+"','"+m.getMatchNumber()+"')";
                                                                                                                                            

        try {
            statement.executeUpdate(requete);

        } catch (SQLException ex) {
            System.out.println("ERROR INSERT " + ex.getMessage());

        }

    }

    @Override
    public ObservableList getAMatch() {
        return null;
    }
    
    
        @Override
    public Match getMatchbyId(int id) {      
               Match m=null;
         try {
             result=statement.executeQuery("SELECT * from GAME where GAME_ID='"+id+"'");
             if(result.next())
              m = new Match(result.getInt("GAME_ID"),result.getDate("GAME_DATE"), result.getString("GAME_REFEREE"), result.getString("GAME_TIME"), result.getInt("GAME_WINNERTEAMSCORE"), result.getInt("GAME_LOSSTEAMSCORE"), result.getString("GAME_KIND"), result.getString("GAME_WINNERTEAM"), result.getString("GAME_LOSSTEAM"), result.getString("GAME_VENUE"), result.getString("GAME_STADIUM"), result.getInt("GAME_MATCHNUMBER"));              

         } catch (SQLException ex) {
                System.out.println("GetById ERROR = "+ex.getMessage());
         } 
                return m;
    }
    
    
        @Override
    public boolean deleteMatch(int id) {
        
            Match m=getMatchbyId(id);
        if(m!=null)
        {   try {
            statement.executeUpdate("DELETE FROM `GAME` WHERE GAME_ID='"+id+"'");
            } catch (SQLException ex) {
            System.out.println("DELETE ERROR= "+ex.getMessage());
            }
        return true;
        }
        
        return false;
    }

    
    @Override
    public void updateMatch(Match m) {
        
    try {     
        if(m!=null)
        { 
            String req ="UPDATE `GAME` SET `GAME_KIND`='"+m.getGameKind()+"',`GAME_WINNERTEAM`='"+m.getWinnerteam()+"',`GAME_LOSSTEAM`='"+m.getLooserTeam()+"',`GAME_TIME`='"+m.getTime()+"',`GAME_DATE`='"+m.getDate_match()+"',`GAME_WINNERTEAMSCORE`='"+m.getWinner_teamScore()+"',`GAME_LOSSTEAMSCORE`='"+m.getLooser_teamScore()+"',`GAME_REFEREE`='"+m.getReferee()+"',`GAME_STADIUM`='"+m.getStadium()+"',`GAME_VENUE`='"+m.getVenue()+"',`GAME_MATCHNUMBER`='"+m.getMatchNumber()+"' WHERE game_id='"+m.getMatch_id()+"'";
            statement.executeUpdate(req);
        }
            } catch (SQLException ex) {
                System.out.println("UPDATE ERROR= "+ex.getMessage());
            }
        
        
        
    }

    @Override
    public ObservableList getAllMatchs() {
     
     ObservableList List =FXCollections.observableArrayList();
        try {
            result = statement.executeQuery("select * from GAME");
            while (result.next()) {
              Match m = new Match(result.getInt("GAME_ID"),result.getDate("GAME_DATE"), result.getString("GAME_REFEREE"), result.getString("GAME_TIME"), result.getInt("GAME_WINNERTEAMSCORE"), result.getInt("GAME_LOSSTEAMSCORE"), result.getString("GAME_KIND"), result.getString("GAME_WINNERTEAM"), result.getString("GAME_LOSSTEAM"), result.getString("GAME_VENUE"), result.getString("GAME_STADIUM"), result.getInt("GAME_MATCHNUMBER"));              
              List.add(m);
            }

        } catch (SQLException ex) {
            System.out.println("GET ALL MATCHES "+ex.getMessage());
        }
        
        return List;
    }

    @Override
    public void EmptyMatch() {
          
        
    String sql = "DELETE FROM GAME";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Empty table failed"+ex.getMessage());        }

    }

    @Override
    public void updateReferee(String referee,int Id) {
                try {     
        if(!referee.isEmpty())
        { 
            String req ="UPDATE `GAME` SET `GAME_REFEREE`='"+referee+"'WHERE GAME_MATCHNUMBER='"+Id+"'";
            statement.executeUpdate(req);
        }
            } catch (SQLException ex) {
                System.out.println("UPDATE ERROR= "+ex.getMessage());
            }
    }
    
    

}
