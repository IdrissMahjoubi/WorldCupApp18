/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Doggaz Jihed
 */
public class Player {
    private int PLAYER_ID;
    private String PLAYER_NAME;
    private int PLAYER_AGE;
    private String PLAYER_TEAM;
    private String PLAYER_POSITION;
    private String PLAYER_CLUB;
    private String PLAYER_HEIGHT;
    private int PLAYER_TSHIRT;
    private String PLAYER_WEIGHT;
    private String PLAYER_PICTURE;
   

    public Player() {
    }

    public Player(int PLAYER_ID, String PLAYER_NAME, int PLAYER_AGE, String PLAYER_TEAM, String PLAYER_POSITION, String PLAYER_CLUB, String PLAYER_HEIGHT, int PLAYER_TSHIRT, String PLAYER_WEIGHT, String PLAYER_PICTURE) {
        this.PLAYER_ID = PLAYER_ID;
        this.PLAYER_NAME = PLAYER_NAME;
        this.PLAYER_AGE = PLAYER_AGE;
        this.PLAYER_TEAM = PLAYER_TEAM;
        this.PLAYER_POSITION = PLAYER_POSITION;
        this.PLAYER_CLUB = PLAYER_CLUB;
        this.PLAYER_HEIGHT = PLAYER_HEIGHT;
        this.PLAYER_TSHIRT = PLAYER_TSHIRT;
        this.PLAYER_WEIGHT = PLAYER_WEIGHT;
        this.PLAYER_PICTURE = PLAYER_PICTURE;
    }

    public Player(String PLAYER_NAME, int PLAYER_AGE, String PLAYER_POSITION, String PLAYER_CLUB, String PLAYER_HEIGHT, int PLAYER_TSHIRT, String PLAYER_WEIGHT) {
        this.PLAYER_NAME = PLAYER_NAME;
        this.PLAYER_AGE = PLAYER_AGE;
        this.PLAYER_POSITION = PLAYER_POSITION;
        this.PLAYER_CLUB = PLAYER_CLUB;
        this.PLAYER_HEIGHT = PLAYER_HEIGHT;
        this.PLAYER_TSHIRT = PLAYER_TSHIRT;
        this.PLAYER_WEIGHT = PLAYER_WEIGHT;
        
    }
    
    

    public Player(String PLAYER_NAME, int PLAYER_AGE, String PLAYER_TEAM, String PLAYER_POSITION, String PLAYER_CLUB, String PLAYER_HEIGHT, int PLAYER_TSHIRT, String PLAYER_WEIGHT, String PLAYER_PICTURE) {
        this.PLAYER_NAME = PLAYER_NAME;
        this.PLAYER_AGE = PLAYER_AGE;
        this.PLAYER_TEAM = PLAYER_TEAM;
        this.PLAYER_POSITION = PLAYER_POSITION;
        this.PLAYER_CLUB = PLAYER_CLUB;
        this.PLAYER_HEIGHT = PLAYER_HEIGHT;
        this.PLAYER_TSHIRT = PLAYER_TSHIRT;
        this.PLAYER_WEIGHT = PLAYER_WEIGHT;
        this.PLAYER_PICTURE = PLAYER_PICTURE;
    }

    public Player(int PLAYER_ID, String PLAYER_NAME, int PLAYER_AGE, String PLAYER_POSITION, String PLAYER_CLUB, String PLAYER_HEIGHT, int PLAYER_TSHIRT, String PLAYER_PICTURE) {
        this.PLAYER_ID = PLAYER_ID;
        this.PLAYER_NAME = PLAYER_NAME;
        this.PLAYER_AGE = PLAYER_AGE;
        this.PLAYER_POSITION = PLAYER_POSITION;
        this.PLAYER_CLUB = PLAYER_CLUB;
        this.PLAYER_HEIGHT = PLAYER_HEIGHT;
        this.PLAYER_TSHIRT = PLAYER_TSHIRT;
        this.PLAYER_PICTURE = PLAYER_PICTURE;
    }

    public Player(String PLAYER_NAME, int PLAYER_AGE, String PLAYER_TEAM, String PLAYER_POSITION, String PLAYER_CLUB, String PLAYER_HEIGHT, int PLAYER_TSHIRT, String PLAYER_WEIGHT) {
        this.PLAYER_NAME = PLAYER_NAME;
        this.PLAYER_AGE = PLAYER_AGE;
        this.PLAYER_TEAM = PLAYER_TEAM;
        this.PLAYER_POSITION = PLAYER_POSITION;
        this.PLAYER_CLUB = PLAYER_CLUB;
        this.PLAYER_HEIGHT = PLAYER_HEIGHT;
        this.PLAYER_TSHIRT = PLAYER_TSHIRT;
        this.PLAYER_WEIGHT = PLAYER_WEIGHT;
    }

   
    
    
    
    

    public int getPLAYER_ID() {
        return PLAYER_ID;
    }

    public void setPLAYER_ID(int PLAYER_ID) {
        this.PLAYER_ID = PLAYER_ID;
    }

    public String getPLAYER_NAME() {
        return PLAYER_NAME;
    }

    public void setPLAYER_NAME(String PLAYER_NAME) {
        this.PLAYER_NAME = PLAYER_NAME;
    }

    public int getPLAYER_AGE() {
        return PLAYER_AGE;
    }

    public void setPLAYER_AGE(int PLAYER_AGE) {
        this.PLAYER_AGE = PLAYER_AGE;
    }

    public String getPLAYER_TEAM() {
        return PLAYER_TEAM;
    }

    public void setPLAYER_TEAM(String PLAYER_TEAM) {
        this.PLAYER_TEAM = PLAYER_TEAM;
    }

    public String getPLAYER_POSITION() {
        return PLAYER_POSITION;
    }

    public void setPLAYER_POSITION(String PLAYER_POSITION) {
        this.PLAYER_POSITION = PLAYER_POSITION;
    }

    public String getPLAYER_CLUB() {
        return PLAYER_CLUB;
    }

    public void setPLAYER_CLUB(String PLAYER_CLUB) {
        this.PLAYER_CLUB = PLAYER_CLUB;
    }

    public String getPLAYER_HEIGHT() {
        return PLAYER_HEIGHT;
    }

    public void setPLAYER_HEIGHT(String PLAYER_HEIGHT) {
        this.PLAYER_HEIGHT = PLAYER_HEIGHT;
    }

    public int getPLAYER_TSHIRT() {
        return PLAYER_TSHIRT;
    }

    public void setPLAYER_TSHIRT(int PLAYER_TSHIRT) {
        this.PLAYER_TSHIRT = PLAYER_TSHIRT;
    }

    public String getPLAYER_WEIGHT() {
        return PLAYER_WEIGHT;
    }

    public void setPLAYER_WEIGHT(String PLAYER_WEIGHT) {
        this.PLAYER_WEIGHT = PLAYER_WEIGHT;
    }

    public String getPLAYER_PICTURE() {
        return PLAYER_PICTURE;
    }

    public void setPLAYER_PICTURE(String PLAYER_PICTURE) {
        this.PLAYER_PICTURE = PLAYER_PICTURE;
    }
    


    @Override
    public String toString() {
        return "Player{" + "PLAYER_ID=" + PLAYER_ID + ", PLAYER_NAME=" + PLAYER_NAME + ", PLAYER_AGE=" + PLAYER_AGE + ", PLAYER_TEAM=" + PLAYER_TEAM + ", PLAYER_POSITION=" + PLAYER_POSITION + ", PLAYER_CLUB=" + PLAYER_CLUB + ", PLAYER_HEIGHT=" + PLAYER_HEIGHT + ", PLAYER_TSHIRT=" + PLAYER_TSHIRT + ", PLAYER_WEIGHT=" + PLAYER_WEIGHT + '}';
    }
      
      
    
}
