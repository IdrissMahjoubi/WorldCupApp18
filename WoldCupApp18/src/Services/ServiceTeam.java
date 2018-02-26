/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Team;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Utilities.DataSource;

/**
 *
 * @author pacha
 */
public class ServiceTeam {
    Connection connection;
    PreparedStatement preparedStatement;
    public void addTeam(Team t){
        String requete="INSERT INTO TEAM (`TEAM_NAME`, `TEAM_COACH`, `TEAM_GROUP`, `TEAM_CONTINENT`, `TEAM_LOGO`, `TEAM_FLAG`) VALUES (?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(requete);
          
            preparedStatement.setString(1, t.getTEAM_NAME());
            preparedStatement.setString(2, t.getTEAM_COACH());
            preparedStatement.setString(3, t.getTEAM_GROUP());
            preparedStatement.setString(4, t.getTEAM_CONTINENT());
            preparedStatement.setString(5, t.getTEAM_LOGO());
            preparedStatement.setString(6, t.getTEAM_FLAG());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("add error = "+ex.getMessage());
        }
    }
    public ObservableList<Team> showTeams(){
        ObservableList<Team> myList=FXCollections.observableArrayList();
        String requete="Select * from TEAM";
        PreparedStatement preparedStatement;
        try {
            preparedStatement=connection.prepareStatement(requete);
            ResultSet rs = preparedStatement.executeQuery(requete);
            while(rs.next()){
                Team t = new Team();
                t.setTEAM_ID(rs.getInt(1));
                t.setTEAM_NAME(rs.getString(2));
                t.setTEAM_COACH(rs.getString(3));
                t.setTEAM_NUMBERMATCHPLAYED(rs.getInt(4));
                t.setTEAM_NUMBERMATCHWON(rs.getInt(5));
                t.setTEAM_NUMBERMATCHLOST(rs.getInt(6));
                t.setTEAM_NUMBERMATCHDRAW(rs.getInt(7));
                t.setTEAM_GOALSFOR(rs.getInt(8));
                t.setTEAM_GOALSAGAINST(rs.getInt(9));
                t.setTEAM_POINTS(rs.getInt(10));
                t.setTEAM_POSITION(rs.getInt(11));
                t.setTEAM_GROUP(rs.getString(12));
                t.setTEAM_CONTINENT(rs.getString(13));
                t.setTEAM_LOGO(rs.getString(14));
                t.setTEAM_FLAG(rs.getString(15));
                
                myList.add(t);
                
            }
        } catch (SQLException ex) {
            System.out.println("Error = "+ex.getMessage());
        }
        return myList;
        
    }
   
    public void removeEquipe(int team_id) {
        String req = "delete from TEAM where TEAM_ID =?";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, team_id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
    }
     public void update(Team t) {
        String req = "UPDATE TEAM SET `TEAM_NAME`=?,`TEAM_COACH`=?,`TEAM_GROUP`=?,`TEAM_CONTINENT`=?,`TEAM_LOGO`=?,`TEAM_FLAG`=? WHERE TEAM_ID = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getTEAM_NAME());
            preparedStatement.setString(2, t.getTEAM_COACH());
            preparedStatement.setString(3, t.getTEAM_GROUP());
            preparedStatement.setString(4, t.getTEAM_CONTINENT());
            preparedStatement.setString(5, t.getTEAM_LOGO());
            preparedStatement.setString(6, t.getTEAM_FLAG());
            preparedStatement.setInt(7, t.getTEAM_ID());
   
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
      public void updatePoints(Team t) {
        String req = "UPDATE `TEAM` SET `TEAM_NAME`=?,`TEAM_COACH`=?,`TEAM_INTMATCHPLAYED`=?,`TEAM_INTMATCHWON`=?,`TEAM_INTMATCHLOST`=?,`TEAM_INTMATCHDRAW`=?,`TEAM_GOALSFOR`=?,`TEAM_GOALSAGAINST`=?,`TEAM_POINTS`=?,`TEAM_POSITION`=?,`TEAM_GROUP`=?,`TEAM_CONTINENT`=?,`TEAM_LOGO`=?,`TEAM_FLAG`=? WHERE TEAM_ID = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getTEAM_NAME());
            preparedStatement.setString(2, t.getTEAM_COACH());
            preparedStatement.setInt(3, t.getTEAM_NUMBERMATCHPLAYED());
            preparedStatement.setInt(4, t.getTEAM_NUMBERMATCHWON());
            preparedStatement.setInt(5, t.getTEAM_NUMBERMATCHLOST());
            preparedStatement.setInt(6, t.getTEAM_NUMBERMATCHDRAW());
            preparedStatement.setInt(7, t.getTEAM_GOALSFOR());
            preparedStatement.setInt(8, t.getTEAM_GOALSAGAINST());
            preparedStatement.setInt(9, t.getTEAM_POINTS());
            preparedStatement.setInt(10, t.getTEAM_POSITION());
            preparedStatement.setString(11, t.getTEAM_GROUP());
            preparedStatement.setString(12, t.getTEAM_CONTINENT());
            preparedStatement.setString(13, t.getTEAM_LOGO());
            preparedStatement.setString(14, t.getTEAM_FLAG());
            preparedStatement.setInt(15, t.getTEAM_ID());
   
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
     

    public ServiceTeam() {
        connection = DataSource.getInstance().getConnection();
    }
}

