/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Controllers.FXMLShowMatchsController;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.scene.control.Alert;

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
        FXMLShowMatchsController.alertMessage("Group Stage", Alert.AlertType.WARNING);
        //get both teams from table view
        Team t1 = getTeamByName(m.getTeam1());
        Team t2 = getTeamByName(m.getTeam2());

        //team one goals for and agains
        t1.setTEAM_GOALSFOR(t1.getTEAM_GOALSFOR() + m.getTeam1Score());
        t1.setTEAM_GOALSAGAINST(t1.getTEAM_GOALSAGAINST() + m.getTeam2Score());

        //team two goals for and agains
        t2.setTEAM_GOALSFOR(t2.getTEAM_GOALSFOR() + m.getTeam2Score());
        t2.setTEAM_GOALSAGAINST(t2.getTEAM_GOALSAGAINST() + m.getTeam1Score());

        //Number of match played
        t1.setTEAM_NUMBERMATCHPLAYED(t1.getTEAM_NUMBERMATCHPLAYED() + 1);
        t2.setTEAM_NUMBERMATCHPLAYED(t2.getTEAM_NUMBERMATCHPLAYED() + 1);
     
        if(m.getGameKind().contains("Group"))
        {
        //Count Points
        if (m.getTeam1Score() > m.getTeam2Score()) {

            t1.setTEAM_POINTS(t1.getTEAM_POINTS() + 3);
            t1.setTEAM_NUMBERMATCHWON(t1.getTEAM_NUMBERMATCHWON()+1);
            t2.setTEAM_NUMBERMATCHLOST(t2.getTEAM_NUMBERMATCHLOST()+1);

        } else if (m.getTeam1Score() < m.getTeam2Score()) {

            t2.setTEAM_POINTS(t2.getTEAM_POINTS() + 3);
            t2.setTEAM_NUMBERMATCHWON(t2.getTEAM_NUMBERMATCHWON()+1);
            t1.setTEAM_NUMBERMATCHLOST(t1.getTEAM_NUMBERMATCHLOST()+1);

        } else {

            t1.setTEAM_POINTS(t1.getTEAM_POINTS() + 1);
            t2.setTEAM_POINTS(t2.getTEAM_POINTS() + 1);
            t1.setTEAM_NUMBERMATCHDRAW(t1.getTEAM_NUMBERMATCHDRAW()+1);
            t2.setTEAM_NUMBERMATCHDRAW(t2.getTEAM_NUMBERMATCHDRAW()+1);

        }
        //update database (table team)
        ServiceTeam st = new ServiceTeam();
        st.updatePoints(t2);
        st.updatePoints(t1);
        }else //if not in group stage
        {
                if (m.getTeam1Score() > m.getTeam2Score()) {
            t1.setTEAM_NUMBERMATCHWON(t1.getTEAM_NUMBERMATCHWON()+1);
            t2.setTEAM_NUMBERMATCHLOST(t2.getTEAM_NUMBERMATCHLOST()+1);
        } else if (m.getTeam1Score() < m.getTeam2Score()) {
            t2.setTEAM_NUMBERMATCHWON(t2.getTEAM_NUMBERMATCHWON()+1);
            t1.setTEAM_NUMBERMATCHLOST(t1.getTEAM_NUMBERMATCHLOST()+1);
        } else {
            t1.setTEAM_NUMBERMATCHDRAW(t1.getTEAM_NUMBERMATCHDRAW()+1);
            t2.setTEAM_NUMBERMATCHDRAW(t2.getTEAM_NUMBERMATCHDRAW()+1);
        }
        //update database (table team)
        ServiceTeam st = new ServiceTeam();
        st.updatePoints(t2);
        st.updatePoints(t1);
        }
    }
    
    public List<Team> DivideTeams(String Group)
    {
        ServiceTeam st= new ServiceTeam();
        List<Team> t=new ArrayList<Team>();
        List<Team> teams=st.showTeams();
        
  
        for (int i=0;i<teams.size();i++)
        {
                if (teams.get(i).getTEAM_GROUP().equals(Group)) 
                {
                t.add(teams.get(i));
                } 
        }
        return t;
    }

    public void sortTeamPosition(List<Team> t)
    {
        Collections.sort(t, new Comparator<Team>() {
        @Override 
        public int compare(Team p1, Team p2) {
            return   p2.getTEAM_POINTS() - p1.getTEAM_POINTS(); 
        }
        });
        for(int i=0;i<t.size();i++)
        {
            
            t.get(i).setTEAM_POSITION(i+1);
            updatePosition(t.get(i).getTEAM_NAME(), t.get(i).getTEAM_POSITION());
        }
    }
    
    public void setAllPositions()
    {
        List<Team> l=new ArrayList<Team>();
        for(char i='A';i<='H';i++)
        {
          l=DivideTeams(String.valueOf(i));
          sortTeamPosition(l);
                  
        }
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
            System.out.println("ERROR GET Team" + ex.getMessage());
        }
        return t;
    }

                public void updatePosition(String name, int pos) {
        try {
            if (!name.isEmpty()) {
                String req = "UPDATE `TEAM` SET `TEAM_POSITION`='" + pos + "'WHERE TEAM_NAME='" + name + "'";
                statement.executeUpdate(req);
            }
        } catch (SQLException ex) {
            System.out.println("UPDATE ERROR= " + ex.getMessage());
        }
    }
                                
               
}
