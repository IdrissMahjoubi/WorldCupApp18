/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Utilities.DataSource;
import static Utilities.DataSource.instance;

/**
 *
 * @author Bich
 */
public class Stadium {
    private int STADIUM_ID ;
    private String STADIUM_NAME ;
    private String STADIUM_LOCATION ;
    private int STADIUM_CAPACITY ;
    private String STADIUM_PICTURE ;
    private String STADIUM_LOCATION_X  ;
    private String STADIUM_LOCATION_Y  ;
    
    
    public static Stadium instance ;
    
        public static Stadium getInstance(){
        if (instance==null){
            instance = new Stadium();
        }
        return instance;
    }

    public Stadium() {
    }


    public static void setInstance(Stadium instance) {
        Stadium.instance = instance;
    }

    public Stadium(String STADIUM_NAME, String STADIUM_LOCATION, int STADIUM_CAPACITY, String STADIUM_PICTURE, String STADUIM_LOCATION_X, String STADUIM_LOCATION_Y) {
        this.STADIUM_NAME = STADIUM_NAME;
        this.STADIUM_LOCATION = STADIUM_LOCATION;
        this.STADIUM_CAPACITY = STADIUM_CAPACITY;
        this.STADIUM_PICTURE = STADIUM_PICTURE;
        this.STADIUM_LOCATION_X = STADUIM_LOCATION_X;
        this.STADIUM_LOCATION_Y = STADUIM_LOCATION_Y;
    }



  

    public int getSTADIUM_ID() {
        return STADIUM_ID;
    }

    public void setSTADIUM_ID(int STADIUM_ID) {
        this.STADIUM_ID = STADIUM_ID;
    }

    public String getSTADIUM_NAME() {
        return STADIUM_NAME;
    }

    public void setSTADIUM_NAME(String STADIUM_NAME) {
        this.STADIUM_NAME = STADIUM_NAME;
    }

    public String getSTADIUM_LOCATION() {
        return STADIUM_LOCATION;
    }

    public void setSTADIUM_LOCATION(String STADIUM_LOCATION) {
        this.STADIUM_LOCATION = STADIUM_LOCATION;
    }

    public int getSTADIUM_CAPACITY() {
        return STADIUM_CAPACITY;
    }

    public void setSTADIUM_CAPACITY(int STADIUM_CAPACITY) {
        this.STADIUM_CAPACITY = STADIUM_CAPACITY;
    }

    public String getSTADIUM_PICTURE() {
        return STADIUM_PICTURE;
    }

    public void setSTADIUM_PICTURE(String STADIUM_PICTURE) {
        this.STADIUM_PICTURE = STADIUM_PICTURE;
    }

    public String getSTADIUM_LOCATION_X() {
        return STADIUM_LOCATION_X;
    }

    public void setSTADIUM_LOCATION_X(String STADUIM_LOCATION_X) {
        this.STADIUM_LOCATION_X = STADUIM_LOCATION_X;
    }

    public String getSTADIUM_LOCATION_Y() {
        return STADIUM_LOCATION_Y;
    }

    public void setSTADIUM_LOCATION_Y(String STADUIM_LOCATION_Y) {
        this.STADIUM_LOCATION_Y = STADUIM_LOCATION_Y;
    }

    public Stadium(String STADIUM_NAME, String STADIUM_LOCATION, int STADIUM_CAPACITY, String STADUIM_LOCATION_X, String STADUIM_LOCATION_Y) {
        this.STADIUM_NAME = STADIUM_NAME;
        this.STADIUM_LOCATION = STADIUM_LOCATION;
        this.STADIUM_CAPACITY = STADIUM_CAPACITY;
        this.STADIUM_LOCATION_X = STADUIM_LOCATION_X;
        this.STADIUM_LOCATION_Y = STADUIM_LOCATION_Y;
    }



    @Override
    public String toString() {
        return "Stadium{" + "STADIUM_ID=" + STADIUM_ID + ", STADIUM_NAME=" + STADIUM_NAME + ", STADIUM_LOCATION=" + STADIUM_LOCATION + ", STADIUM_CAPACITY=" + STADIUM_CAPACITY + ", STADIUM_PICTURE=" + STADIUM_PICTURE + ", STADUIM_LOCATION_X=" + STADIUM_LOCATION_X + ", STADUIM_LOCATION_Y=" + STADIUM_LOCATION_Y + '}';
    }

  
    
    
 
 
    
    
}