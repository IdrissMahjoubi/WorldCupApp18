/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utilities.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            preparedStatement.setInt(1, user_id);
            preparedStatement.setInt(2, player_id);
            
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
        
}
