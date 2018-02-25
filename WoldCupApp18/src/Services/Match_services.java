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
import Entities.Team;
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
    static ServiceTeam ServiceTeam;

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

        String requete = "INSERT INTO `GAME`(`GAME_KIND`, `GAME_WINNERTEAM`, `GAME_LOSSTEAM`, `GAME_TIME`, `GAME_DATE`, `GAME_WINNERTEAMSCORE`, `GAME_LOSSTEAMSCORE`, `GAME_REFEREE`, `GAME_STADIUM`, `GAME_VENUE`, `GAME_MATCHNUMBER`) VALUES ('" + m.getGameKind() + "','" + m.getTeam1() + "','" + m.getTeam2() + "','" + m.getTime() + "','" + m.getDate_match() + "','" + m.getTeam1Score() + "','" + m.getTeam2Score() + "','" + m.getReferee() + "','" + m.getStadium() + "','" + m.getVenue() + "','" + m.getMatchNumber() + "')";

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
        Match m = null;
        try {
            result = statement.executeQuery("SELECT * from GAME where GAME_ID='" + id + "'");
            if (result.next()) {
                m = new Match(result.getInt("GAME_ID"), result.getDate("GAME_DATE"), result.getString("GAME_REFEREE"), result.getString("GAME_TIME"), result.getInt("GAME_WINNERTEAMSCORE"), result.getInt("GAME_LOSSTEAMSCORE"), result.getString("GAME_KIND"), result.getString("GAME_WINNERTEAM"), result.getString("GAME_LOSSTEAM"), result.getString("GAME_VENUE"), result.getString("GAME_STADIUM"), result.getInt("GAME_MATCHNUMBER"));
            }

        } catch (SQLException ex) {
            System.out.println("GetById ERROR = " + ex.getMessage());
        }
        return m;
    }

    @Override
    public boolean deleteMatch(int id) {

        Match m = getMatchbyId(id);
        if (m != null) {
            try {
                statement.executeUpdate("DELETE FROM `GAME` WHERE GAME_ID='" + id + "'");
            } catch (SQLException ex) {
                System.out.println("DELETE ERROR= " + ex.getMessage());
            }
            return true;
        }

        return false;
    }

    @Override
    public void updateMatch(Match m) {

        try {
            if (m != null) {
                String req = "UPDATE `GAME` SET `GAME_KIND`='" + m.getGameKind() + "',`GAME_WINNERTEAM`='" + m.getTeam1() + "',`GAME_LOSSTEAM`='" + m.getTeam2() + "',`GAME_TIME`='" + m.getTime() + "',`GAME_DATE`='" + m.getDate_match() + "',`GAME_WINNERTEAMSCORE`='" + m.getTeam1Score() + "',`GAME_LOSSTEAMSCORE`='" + m.getTeam2Score() + "',`GAME_REFEREE`='" + m.getReferee() + "',`GAME_STADIUM`='" + m.getStadium() + "',`GAME_VENUE`='" + m.getVenue() + "',`GAME_MATCHNUMBER`='" + m.getMatchNumber() + "' WHERE game_id='" + m.getMatch_id() + "'";
                statement.executeUpdate(req);
            }
        } catch (SQLException ex) {
            System.out.println("UPDATE ERROR= " + ex.getMessage());
        }

    }

    @Override
    public ObservableList getAllMatchs() {

        ObservableList List = FXCollections.observableArrayList();
        try {
            result = statement.executeQuery("select * from GAME");
            while (result.next()) {
                Match m = new Match(result.getInt("GAME_ID"), result.getDate("GAME_DATE"), result.getString("GAME_REFEREE"), result.getString("GAME_TIME"), result.getInt("GAME_WINNERTEAMSCORE"), result.getInt("GAME_LOSSTEAMSCORE"), result.getString("GAME_KIND"), result.getString("GAME_WINNERTEAM"), result.getString("GAME_LOSSTEAM"), result.getString("GAME_VENUE"), result.getString("GAME_STADIUM"), result.getInt("GAME_MATCHNUMBER"));
                List.add(m);
            }

        } catch (SQLException ex) {
            System.out.println("GET ALL MATCHES " + ex.getMessage());
        }

        return List;
    }

    @Override
    public void EmptyMatch() {

        String sql = "DELETE FROM GAME";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Empty table failed" + ex.getMessage());
        }

    }

    @Override
    public void updateReferee(String referee, int Id) {
        try {
            if (!referee.isEmpty()) {
                String req = "UPDATE `GAME` SET `GAME_REFEREE`='" + referee + "'WHERE GAME_MATCHNUMBER='" + Id + "'";
                statement.executeUpdate(req);
            }
        } catch (SQLException ex) {
            System.out.println("UPDATE ERROR= " + ex.getMessage());
        }
    }

    
    public void PointsCount(Match m) {

        Team t1 = getTeamByName(m.getTeam1());
        Team t2 = getTeamByName(m.getTeam2());

        t1.setTEAM_GOALSFOR(t1.getTEAM_GOALSFOR()+m.getTeam1Score());
        t1.setTEAM_GOALSAGAINST(t1.getTEAM_GOALSAGAINST()+m.getTeam2Score());
       
        t2.setTEAM_GOALSFOR(t2.getTEAM_GOALSFOR()+m.getTeam2Score());
        t2.setTEAM_GOALSAGAINST(t2.getTEAM_GOALSAGAINST()+m.getTeam1Score());

        t1.setTEAM_NUMBERMATCHPLAYED(t1.getTEAM_NUMBERMATCHPLAYED()+1);
        t2.setTEAM_NUMBERMATCHPLAYED(t2.getTEAM_NUMBERMATCHPLAYED()+1);

        if (m.getTeam1Score()> m.getTeam2Score()) {
            
            
         t1.setTEAM_POINTS(t1.getTEAM_POINTS()+3);
            
            
            
            
        } else if (m.getTeam1Score() < m.getTeam2Score()) {
            
            
            
         t2.setTEAM_POINTS(t2.getTEAM_POINTS()+3);
        } else {
            
            
            
         t1.setTEAM_POINTS(t1.getTEAM_POINTS()+1);
         t2.setTEAM_POINTS(t2.getTEAM_POINTS()+1);
        }
        System.out.println(t1.toString());
        System.out.println(t2.toString());

            ServiceTeam st = new ServiceTeam();
            st.update(t2);
            st.update(t1);
    }
    
        public Team getTeamByName(String team) {
                            Team t = new Team();
        try {
                 String req = "SELECT * from TEAM where TEAM_NAME='" + team + "'";
            result = statement.executeQuery(req);
             if (result.next()) {
                t.setTEAM_ID(result.getInt(1));
                t.setTEAM_NAME(result.getString(2));
                t.setTEAM_COACH(result.getString(3));
                t.setTEAM_NUMBERMATCHPLAYED(result.getInt(4));
                t.setTEAM_NUMBERMATCHWON(result.getInt(5));
                t.setTEAM_NUMBERMATCHLOST(result.getInt(6));
                t.setTEAM_NUMBERMATCHDRAW(result.getInt(7));
                t.setTEAM_GOALSFOR(result.getInt(8));
                t.setTEAM_GOALSAGAINST(result.getInt(9));
                t.setTEAM_POINTS(result.getInt(10));
                t.setTEAM_POSITION(result.getInt(11));
                t.setTEAM_GROUP(result.getString(12));
                t.setTEAM_CONTINENT(result.getString(13));
                t.setTEAM_LOGO(result.getString(14));
                t.setTEAM_FLAG(result.getString(15));     
            }
        } catch (SQLException ex) {
            System.out.println("ERROR GET Team"+ex.getMessage());        
        }
        return t;
}

  
    
    

}
