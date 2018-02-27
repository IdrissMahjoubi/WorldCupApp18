/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Entities.Player;
import Utilities.DataSource;

/**
 *
 * @author Doggaz Jihed
 */
public class PlayerServices {
    
    Connection connection;
    PreparedStatement preparedStatement;
    
    static PlayerServices instance;
   
    public PlayerServices() {
           connection = DataSource.getInstance().getConnection();

    }

      public static PlayerServices getInstance() {
        if (instance == null) {
            instance = new PlayerServices();
        }
        return instance;
    }
    
    
    public void addPlayer(Player p){
        String requete="INSERT INTO `PLAYER`(`PLAYER_NAME`,`PLAYER_AGE`,`PLAYER_TEAM` ,`PLAYER_POSITION`,`PLAYER_CLUB`,`PLAYER_HEIGHT`,`PLAYER_TSHIRT`,`PLAYER_WEIGHT`) VALUES (?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(requete);
          
            preparedStatement.setString(1, p.getPLAYER_NAME());
            preparedStatement.setInt(2, p.getPLAYER_AGE());
            preparedStatement.setString(3, p.getPLAYER_TEAM());
            preparedStatement.setString(4, p.getPLAYER_POSITION());
            preparedStatement.setString(5, p.getPLAYER_CLUB());
            preparedStatement.setString(6, p.getPLAYER_HEIGHT());
            preparedStatement.setInt(7, p.getPLAYER_TSHIRT());
            preparedStatement.setString(8, p.getPLAYER_WEIGHT());
           
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    public void EmptyPlayer() {
          
        
    String requete = "DELETE FROM PLAYER";
    PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(requete);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Empty table failed"+ex.getMessage());        }

    }
    
    public ObservableList<Player> showPlayers(){
        ObservableList<Player> myList=FXCollections.observableArrayList();
        String requete="Select * from PLAYER";
        PreparedStatement preparedStatement;
        try {
            preparedStatement=connection.prepareStatement(requete);
            //Statement st=DataSource.getInstance().getConn().createStatement();
            ResultSet rs = preparedStatement.executeQuery(requete);
            while(rs.next()){
                Player p = new Player();
                p.setPLAYER_ID(rs.getInt(1));
                p.setPLAYER_NAME(rs.getString(2));
                p.setPLAYER_AGE(rs.getInt(3));
                p.setPLAYER_TEAM(rs.getString(4));
                p.setPLAYER_POSITION(rs.getString(5));
                p.setPLAYER_CLUB(rs.getString(6));
                p.setPLAYER_HEIGHT(rs.getString(7));
                p.setPLAYER_TSHIRT(rs.getInt(8));
                p.setPLAYER_WEIGHT(rs.getString(9));
                p.setPLAYER_PICTURE(rs.getString(10));

                
                
                myList.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Error"+ex.getMessage());
        }
        return myList;
    }
    
   
    
 public ObservableList<String> showPlayersTeams(){
        ObservableList<String> myList=FXCollections.observableArrayList();
        String requete="Select `TEAM_NAME` from TEAM";
        PreparedStatement preparedStatement;
        try {
            preparedStatement=connection.prepareStatement(requete);
            //Statement st=DataSource.getInstance().getConn().createStatement();
            ResultSet rs = preparedStatement.executeQuery(requete);
            while(rs.next()){
     
                myList.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println("Error"+ex.getMessage());
        }
        return myList;
    }
 
  public ObservableList<Player> showPlayersByTeam(String team){
        ObservableList<Player> myList=FXCollections.observableArrayList();
        String requete="Select * from PLAYER WHERE PLAYER_TEAM ='"+team+"'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement=connection.prepareStatement(requete);
            //Statement st=DataSource.getInstance().getConn().createStatement();
            ResultSet rs = preparedStatement.executeQuery(requete);
            while(rs.next()){
                Player p = new Player();
                p.setPLAYER_ID(rs.getInt(1));
                p.setPLAYER_NAME(rs.getString(2));
                p.setPLAYER_AGE(rs.getInt(3));
                p.setPLAYER_TEAM(rs.getString(4));
                p.setPLAYER_POSITION(rs.getString(5));
                p.setPLAYER_CLUB(rs.getString(6));
                p.setPLAYER_HEIGHT(rs.getString(7));
                p.setPLAYER_TSHIRT(rs.getInt(8));
                p.setPLAYER_WEIGHT(rs.getString(9));
                p.setPLAYER_PICTURE(rs.getString(10));

                
                
                myList.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Error"+ex.getMessage());
        }
        return myList;
    }
        
 
    public void removePlayer(int player_id) {
        String req = "delete from PLAYER where PLAYER_ID =?";
        //PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, player_id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
    }
     public void updatePlayer(Player p) {
        String req = "UPDATE `PLAYER` SET `PLAYER_NAME`=?,`PLAYER_AGE`=?,`PLAYER_TEAM`=? ,`PLAYER_POSITION`=? ,`PLAYER_CLUB`=? ,`PLAYER_HEIGHT`=? ,`PLAYER_TSHIRT`=? ,`PLAYER_WEIGHT`=? ,`PLAYER_PICTURE`=? WHERE PLAYER_ID = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, p.getPLAYER_NAME());
            preparedStatement.setInt(2, p.getPLAYER_AGE());
            preparedStatement.setString(3, p.getPLAYER_TEAM());
            preparedStatement.setString(4, p.getPLAYER_POSITION());
            preparedStatement.setString(5, p.getPLAYER_CLUB());
            preparedStatement.setString(6, p.getPLAYER_HEIGHT());
            preparedStatement.setInt(7, p.getPLAYER_TSHIRT());
            preparedStatement.setString(8, p.getPLAYER_WEIGHT());
            preparedStatement.setString(9, p.getPLAYER_PICTURE());
            preparedStatement.setInt(10, p.getPLAYER_ID());
            
            
   
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
     

  
    
}
