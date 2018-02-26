/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Bich
 */
public class Station {
    public int STATION_ID ;

 
    private String STATION_NAME ;
    private String STATION_LOCATION ;
    private String STATION_TYPE ;
    private String STATION_LOCATION_X ;
    private String STATION_LOCATION_Y;
    private static Station instance ;
    
    
    public Station(int STATION_ID, String STATION_NAME, String STATION_LOCATION, String STATION_TYPE, String STATION_LOCATION_X, String STATION_LOCATION_Y) {
        this.STATION_ID = STATION_ID;
        this.STATION_NAME = STATION_NAME;
        this.STATION_LOCATION = STATION_LOCATION;
        this.STATION_TYPE = STATION_TYPE;
        this.STATION_LOCATION_X = STATION_LOCATION_X;
        this.STATION_LOCATION_Y = STATION_LOCATION_Y;
    }
    
    

    public Station() {
    }

    public Station(String STATION_NAME, String STATION_LOCATION, String STATION_TYPE, String STATION_LOCATION_X, String STATION_LOCATION_Y) {
        this.STATION_NAME = STATION_NAME;
        this.STATION_LOCATION = STATION_LOCATION;
        this.STATION_TYPE = STATION_TYPE;
        this.STATION_LOCATION_X = STATION_LOCATION_X;
        this.STATION_LOCATION_Y = STATION_LOCATION_Y;
    }

    public Station(int aInt, String string, String string0, int aInt0, int aInt1, int aInt2, int aInt3, int aInt4, int aInt5, int aInt6, int aInt7, String string1, String string2, String string3, String string4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       public int getSTATION_ID() {
        return STATION_ID;
    }

    public void setSTATION_ID(int STATION_ID) {
        this.STATION_ID = STATION_ID;
    }
    

    public String getSTATION_NAME() {
        return STATION_NAME;
    }

    public void setSTATION_NAME(String STATION_NAME) {
        this.STATION_NAME = STATION_NAME;
    }

    public String getSTATION_LOCATION() {
        return STATION_LOCATION;
    }

    public void setSTATION_LOCATION(String STATION_LOCATION) {
        this.STATION_LOCATION = STATION_LOCATION;
    }

    public String getSTATION_TYPE() {
        return STATION_TYPE;
    }

    public void setSTATION_TYPE(String STATION_TYPE) {
        this.STATION_TYPE = STATION_TYPE;
    }

    public String getSTATION_LOCATION_X() {
        return STATION_LOCATION_X;
    }

    public void setSTATION_LOCATION_X(String STATION_LOCATION_X) {
        this.STATION_LOCATION_X = STATION_LOCATION_X;
    }

    public String getSTATION_LOCATION_Y() {
        return STATION_LOCATION_Y;
    }

    public void setSTATION_LOCATION_Y(String STATION_LOCATION_Y) {
        this.STATION_LOCATION_Y = STATION_LOCATION_Y;
    }

    public static Station getInstance() {
        return instance;
    }

    public static void setInstance(Station instance) {
        Station.instance = instance;
    }

    @Override
    public String toString() {
        return "Station{" + "STATION_ID=" + STATION_ID + ", " + "STATION_NAME=" + STATION_NAME + ", STATION_LOCATION=" + STATION_LOCATION + ", STATION_TYPE=" + STATION_TYPE + ", STATION_LOCATION_X=" + STATION_LOCATION_X + ", STATION_LOCATION_Y=" + STATION_LOCATION_Y + '}';
    }
    
    
    
}

