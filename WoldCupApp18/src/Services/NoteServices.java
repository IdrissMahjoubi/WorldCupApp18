/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Player;
import Utilities.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Doggaz Jihed
 */
public class NoteServices {
        Connection connection;
    PreparedStatement preparedStatement;
    static NoteServices instance;
   
    public NoteServices() {
           connection = DataSource.getInstance().getConnection();

    }

      public static NoteServices getInstance() {
        if (instance == null) {
            instance = new NoteServices();
        }
        return instance;
    }
      
      public boolean CheckNote(int user_id, int player_id) throws SQLException {

        boolean y = true;
        String req1 = "SELECT * FROM NOTE WHERE PLAYER_ID='" +player_id+ "' AND USER_ID='" +user_id+ "'";

        PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(req1);
        try {
            ResultSet rs = pst.executeQuery(req1);
            while (rs.next()) {
                y = false;
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        return y;
    }
      
        public void addNote(int user_id, int player_id){
        String requete="INSERT INTO `NOTE`(`USER_ID`,`PLAYER_ID`) VALUES (?,?)";
            try {
                
            preparedStatement = connection.prepareStatement(requete);
            
            preparedStatement.setInt(1,user_id);
            preparedStatement.setInt(2,player_id);
             preparedStatement.executeUpdate();
             
            } catch (SQLException ex) {
                Logger.getLogger(NoteServices.class.getName()).log(Level.SEVERE, null, ex);
            }

          }
        
                public void addNotePlayer(int player_note, int player_number_note, int player_id){
        String requete="UPDATE `PLAYER` SET `PLAYER_NOTE`=?,`PLAYER_NUMBER_NOTE`=? WHERE PLAYER_ID =?";
            try {
                
            preparedStatement = connection.prepareStatement(requete);
            preparedStatement.setInt(1, player_note);
            preparedStatement.setInt(2, player_number_note);
            preparedStatement.setInt(3, player_id);
            preparedStatement.executeUpdate();
            
            } catch (SQLException ex) {
                Logger.getLogger(NoteServices.class.getName()).log(Level.SEVERE, null, ex);
            }

          }
                
        public void addRatingPlayer(float player_rating, int player_id){
        String requete="UPDATE `PLAYER` SET `PLAYER_RATING`=? WHERE PLAYER_ID =?";
            try {
                
            preparedStatement = connection.prepareStatement(requete);
            preparedStatement.setFloat(1, player_rating);
            preparedStatement.setInt(2, player_id);
            preparedStatement.executeUpdate();
            
            } catch (SQLException ex) {
                Logger.getLogger(NoteServices.class.getName()).log(Level.SEVERE, null, ex);
            }

          }
                
         public int getNumberNote(int player_id){
             int numberNote = 0;
           String requete="SELECT `PLAYER_NUMBER_NOTE` FROM PLAYER WHERE PLAYER_ID ="+player_id;
            try {
                preparedStatement = connection.prepareStatement(requete);
               
                ResultSet rs = preparedStatement.executeQuery(requete);
                while(rs.next()){
                  numberNote = rs.getInt(1);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(NoteServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            return numberNote;
         }
         
                  public int getNote(int player_id){
             int numberNote = 0;
           String requete="SELECT `PLAYER_NOTE` FROM PLAYER WHERE PLAYER_ID ="+player_id;
            try {
                preparedStatement = connection.prepareStatement(requete);
               
                ResultSet rs = preparedStatement.executeQuery(requete);
                while(rs.next()){
                  numberNote = rs.getInt(1);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(NoteServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            return numberNote;
         }
                  
         
         
         public ObservableList<Player> getTopRatings(){
        ObservableList<Player> myList=FXCollections.observableArrayList();
        String requete="SELECT * FROM PLAYER ORDER BY `PLAYER_RATING` DESC";
        PreparedStatement preparedStatement;
        try {
            preparedStatement=connection.prepareStatement(requete);
            //Statement st=DataSource.getInstance().getConn().createStatement();
            ResultSet rs = preparedStatement.executeQuery(requete);
            for (int i=0;i<10;i++){
                rs.next();
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
                p.setPLAYER_NOTE(rs.getInt(11));
                p.setPLAYER_NUMBER_NOTE(rs.getInt(12));
                p.setPLAYER_RATING(rs.getFloat(13));

                myList.add(p);
            
            
            }
        } catch (SQLException ex) {
            System.out.println("Error"+ex.getMessage());
        }
        return myList;
    }
        
}
