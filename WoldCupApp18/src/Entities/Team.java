/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author pacha
 */
public class Team {
    private int TEAM_ID;
    private String TEAM_NAME;
    private String TEAM_COACH;
    private int TEAM_NUMBERMATCHPLAYED;
    private int TEAM_NUMBERMATCHWON;
    private int TEAM_NUMBERMATCHLOST;
    private int TEAM_NUMBERMATCHDRAW;
    private int TEAM_GOALSFOR;
    private int TEAM_GOALSAGAINST;
    private int TEAM_POINTS;
    private int TEAM_POSITION;
    private String TEAM_GROUP;

    public static void setInstance(Team instance) {
        Team.instance = instance;
    }
    private String TEAM_CONTINENT;
    private String TEAM_LOGO;
    private String TEAM_FLAG;
    public static Team instance;

    public Team() {
    }

    public Team(String TEAM_NAME, int TEAM_GOALSFOR) {
        this.TEAM_NAME = TEAM_NAME;
        this.TEAM_GOALSFOR = TEAM_GOALSFOR;
    }
    
    

    public Team(String TEAM_NAME, String TEAM_COACH, String TEAM_GROUP, String TEAM_CONTINENT, String TEAM_LOGO, String TEAM_FLAG) {
        this.TEAM_NAME = TEAM_NAME;
        this.TEAM_COACH = TEAM_COACH;
        this.TEAM_GROUP = TEAM_GROUP;
        this.TEAM_CONTINENT = TEAM_CONTINENT;
        this.TEAM_LOGO = TEAM_LOGO;
        this.TEAM_FLAG = TEAM_FLAG;
    }

    public Team(int TEAM_ID, String TEAM_NAME, String TEAM_COACH, int TEAM_NUMBERMATCHPLAYED, int TEAM_NUMBERMATCHWON, int TEAM_NUMBERMATCHLOST, int TEAM_NUMBERMATCHDRAW, int TEAM_GOALSFOR, int TEAM_GOALSAGAINST, int TEAM_POINTS, int TEAM_POSITION, String TEAM_GROUP, String TEAM_CONTINENT, String TEAM_LOGO, String TEAM_FLAG) {
        this.TEAM_ID = TEAM_ID;
        this.TEAM_NAME = TEAM_NAME;
        this.TEAM_COACH = TEAM_COACH;
        this.TEAM_NUMBERMATCHPLAYED = TEAM_NUMBERMATCHPLAYED;
        this.TEAM_NUMBERMATCHWON = TEAM_NUMBERMATCHWON;
        this.TEAM_NUMBERMATCHLOST = TEAM_NUMBERMATCHLOST;
        this.TEAM_NUMBERMATCHDRAW = TEAM_NUMBERMATCHDRAW;
        this.TEAM_GOALSFOR = TEAM_GOALSFOR;
        this.TEAM_GOALSAGAINST = TEAM_GOALSAGAINST;
        this.TEAM_POINTS = TEAM_POINTS;
        this.TEAM_POSITION = TEAM_POSITION;
        this.TEAM_GROUP = TEAM_GROUP;
        this.TEAM_CONTINENT = TEAM_CONTINENT;
        this.TEAM_LOGO = TEAM_LOGO;
        this.TEAM_FLAG = TEAM_FLAG;
    }

    public int getTEAM_ID() {
        return TEAM_ID;
    }

    public void setTEAM_ID(int TEAM_ID) {
        this.TEAM_ID = TEAM_ID;
    }

    public String getTEAM_NAME() {
        return TEAM_NAME;
    }

    public void setTEAM_NAME(String TEAM_NAME) {
        this.TEAM_NAME = TEAM_NAME;
    }

    public String getTEAM_COACH() {
        return TEAM_COACH;
    }

    public void setTEAM_COACH(String TEAM_COACH) {
        this.TEAM_COACH = TEAM_COACH;
    }

    public int getTEAM_NUMBERMATCHPLAYED() {
        return TEAM_NUMBERMATCHPLAYED;
    }

    public void setTEAM_NUMBERMATCHPLAYED(int TEAM_NUMBERMATCHPLAYED) {
        this.TEAM_NUMBERMATCHPLAYED = TEAM_NUMBERMATCHPLAYED;
    }

    public int getTEAM_NUMBERMATCHWON() {
        return TEAM_NUMBERMATCHWON;
    }

    public void setTEAM_NUMBERMATCHWON(int TEAM_NUMBERMATCHWON) {
        this.TEAM_NUMBERMATCHWON = TEAM_NUMBERMATCHWON;
    }

    public int getTEAM_NUMBERMATCHLOST() {
        return TEAM_NUMBERMATCHLOST;
    }

    public void setTEAM_NUMBERMATCHLOST(int TEAM_NUMBERMATCHLOST) {
        this.TEAM_NUMBERMATCHLOST = TEAM_NUMBERMATCHLOST;
    }

    public int getTEAM_NUMBERMATCHDRAW() {
        return TEAM_NUMBERMATCHDRAW;
    }

    public void setTEAM_NUMBERMATCHDRAW(int TEAM_NUMBERMATCHDRAW) {
        this.TEAM_NUMBERMATCHDRAW = TEAM_NUMBERMATCHDRAW;
    }

    public int getTEAM_GOALSFOR() {
        return TEAM_GOALSFOR;
    }

    public void setTEAM_GOALSFOR(int TEAM_GOALSFOR) {
        this.TEAM_GOALSFOR = TEAM_GOALSFOR;
    }

    public int getTEAM_GOALSAGAINST() {
        return TEAM_GOALSAGAINST;
    }

    public void setTEAM_GOALSAGAINST(int TEAM_GOALSAGAINST) {
        this.TEAM_GOALSAGAINST = TEAM_GOALSAGAINST;
    }

    public int getTEAM_POINTS() {
        return TEAM_POINTS;
    }

    public void setTEAM_POINTS(int TEAM_POINTS) {
        this.TEAM_POINTS = TEAM_POINTS;
    }

    public int getTEAM_POSITION() {
        return TEAM_POSITION;
    }

    public void setTEAM_POSITION(int TEAM_POSITION) {
        this.TEAM_POSITION = TEAM_POSITION;
    }

    public String getTEAM_GROUP() {
        return TEAM_GROUP;
    }

    public void setTEAM_GROUP(String TEAM_GROUP) {
        this.TEAM_GROUP = TEAM_GROUP;
    }

    public String getTEAM_CONTINENT() {
        return TEAM_CONTINENT;
    }

    public void setTEAM_CONTINENT(String TEAM_CONTINENT) {
        this.TEAM_CONTINENT = TEAM_CONTINENT;
    }

    public String getTEAM_LOGO() {
        return TEAM_LOGO;
    }

    public void setTEAM_LOGO(String TEAM_LOGO) {
        this.TEAM_LOGO = TEAM_LOGO;
    }

    public String getTEAM_FLAG() {
        return TEAM_FLAG;
    }

    public void setTEAM_FLAG(String TEAM_FLAG) {
        this.TEAM_FLAG = TEAM_FLAG;
    }

    @Override
    public String toString() {
        return "Team{" + "TEAM_ID=" + TEAM_ID + ", TEAM_NAME=" + TEAM_NAME + ", TEAM_COACH=" + TEAM_COACH + ", TEAM_NUMBERMATCHPLAYED=" + TEAM_NUMBERMATCHPLAYED + ", TEAM_NUMBERMATCHWON=" + TEAM_NUMBERMATCHWON + ", TEAM_NUMBERMATCHLOST=" + TEAM_NUMBERMATCHLOST + ", TEAM_NUMBERMATCHDRAW=" + TEAM_NUMBERMATCHDRAW + ", TEAM_GOALSFOR=" + TEAM_GOALSFOR + ", TEAM_GOALSAGAINST=" + TEAM_GOALSAGAINST + ", TEAM_POINTS=" + TEAM_POINTS + ", TEAM_POSITION=" + TEAM_POSITION + ", TEAM_GROUP=" + TEAM_GROUP + ", TEAM_CONTINENT=" + TEAM_CONTINENT + ", TEAM_LOGO=" + TEAM_LOGO + ", TEAM_FLAG=" + TEAM_FLAG + '}';
    }
    
    public static Team getInstance(){
        if (instance==null){
            instance = new Team();
        }
        return instance;
    }    

    public Team(String TEAM_NAME, String TEAM_COACH, String TEAM_GROUP, String TEAM_CONTINENT) {
        this.TEAM_NAME = TEAM_NAME;
        this.TEAM_COACH = TEAM_COACH;
        this.TEAM_GROUP = TEAM_GROUP;
        this.TEAM_CONTINENT = TEAM_CONTINENT;
    }

    
    
}
