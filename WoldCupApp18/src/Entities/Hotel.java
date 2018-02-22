/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author MyTEK
 */
public class Hotel {
    
    
    public int Hotel_ID ;
    public String Hotel_NAME ;
    public String Hotel_LOCATION ;
    public int HOTEL_STARS ;
    public String HOTEL_LOCATION_X ;
    public String HOTEL_LOCATION_Y;
    public static Hotel instance ;

    public Hotel() {
    }
        public Hotel(String Hotel_NAME, String Hotel_LOCATION, int HOTEL_STARS, String HOTEL_LOCATION_X, String HOTEL_LOCATION_Y) {
        this.Hotel_NAME = Hotel_NAME;
        this.Hotel_LOCATION = Hotel_LOCATION;
        this.HOTEL_STARS = HOTEL_STARS;
        this.HOTEL_LOCATION_X = HOTEL_LOCATION_X;
        this.HOTEL_LOCATION_Y = HOTEL_LOCATION_Y;
    }
        
    public Hotel(int Hotel_ID, String Hotel_NAME, String Hotel_LOCATION, int HOTEL_STARS, String HOTEL_LOCATION_X, String HOTEL_LOCATION_Y) {
        this.Hotel_ID = Hotel_ID;
        this.Hotel_NAME = Hotel_NAME;
        this.Hotel_LOCATION = Hotel_LOCATION;
        this.HOTEL_STARS = HOTEL_STARS;
        this.HOTEL_LOCATION_X = HOTEL_LOCATION_X;
        this.HOTEL_LOCATION_Y = HOTEL_LOCATION_Y;
    }
        
        
    @Override
    public String toString() {
        return "Hotel{" + "Hotel_ID=" + Hotel_ID + ", Hotel_NAME=" + Hotel_NAME + ", Hotel_LOCATION=" + Hotel_LOCATION + ", HOTEL_STARS=" + HOTEL_STARS + ", HOTEL_LOCATION_X=" + HOTEL_LOCATION_X + ", HOTEL_LOCATION_Y=" + HOTEL_LOCATION_Y + '}';
    }

    public int getHotel_ID() {
        return Hotel_ID;
    }

    public void setHotel_ID(int Hotel_ID) {
        this.Hotel_ID = Hotel_ID;
    }




   

    public String getHotel_NAME() {
        return Hotel_NAME;
    }

    public void setHotel_NAME(String Hotel_NAME) {
        this.Hotel_NAME = Hotel_NAME;
    }

    public String getHotel_LOCATION() {
        return Hotel_LOCATION;
    }

    public void setHotel_LOCATION(String Hotel_LOCATION) {
        this.Hotel_LOCATION = Hotel_LOCATION;
    }

    public int getHOTEL_STARS() {
        return HOTEL_STARS;
    }

    public void setHOTEL_STARS(int HOTEL_STARS) {
        this.HOTEL_STARS = HOTEL_STARS;
    }

    public String getHOTEL_LOCATION_X() {
        return HOTEL_LOCATION_X;
    }

    public void setHOTEL_LOCATION_X(String HOTEL_LOCATION_X) {
        this.HOTEL_LOCATION_X = HOTEL_LOCATION_X;
    }

    public String getHOTEL_LOCATION_Y() {
        return HOTEL_LOCATION_Y;
    }

    public void setHOTEL_LOCATION_Y(String HOTEL_LOCATION_Y) {
        this.HOTEL_LOCATION_Y = HOTEL_LOCATION_Y;
    }

    public static Hotel getInstance() {
        return instance;
    }

    public static void setInstance(Hotel instance) {
        Hotel.instance = instance;
    }

    
}
