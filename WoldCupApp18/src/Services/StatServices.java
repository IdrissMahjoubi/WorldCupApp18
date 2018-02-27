/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Team;
import static Services.Match_services.instance;
import Utilities.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Doggaz Jihed
 */
public class StatServices {
    
    Connection connection;
    PreparedStatement preparedStatement;
    static StatServices instance;
   
    public StatServices() {
           connection = DataSource.getInstance().getConnection();

    }

      public static StatServices getInstance() {
        if (instance == null) {
            instance = new StatServices();
        }
        return instance;
    }
     public ObservableList<Team> showTeamsStat(){
        ObservableList<Team> myList=FXCollections.observableArrayList();
        String requete="SELECT * FROM `TEAM` ORDER BY `TEAM_GOALSFOR` DESC";
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
    
     public ObservableList<Team> showTeamsStatGain(){
        ObservableList<Team> myList=FXCollections.observableArrayList();
        String requete="SELECT * FROM `TEAM` ORDER BY `TEAM_INTMATCHWON` DESC";
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
}
