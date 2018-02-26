/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Entities.Hotel;
import Utilities.DataSource;

/**
 *
 * @author MyTEK
 */
public class ServiceHotel {
    
     public void addHotel( Hotel hotel ) throws SQLException
    {
    String req ="INSERT INTO `HOTEL`(`HOTEL_NAME`, `HOTEL_LOCATION`, `HOTEL_STARS`, `HOTEL_LOCATION_X`, `HOTEL_LOCATION_Y`) VALUES (?,?,?,?,?)";
    
        PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(req);
        pst.setString(1, hotel.getHotel_NAME());
        pst.setString(2, hotel.getHotel_LOCATION());
        pst.setInt(3, hotel.getHOTEL_STARS());
        pst.setString(4, hotel.getHOTEL_LOCATION_X());
        pst.setString(5, hotel.getHOTEL_LOCATION_Y());

       
        pst.executeUpdate();
    
    
    }
     
     
      public ObservableList<Hotel> showHotel() {
    

                ObservableList<Hotel> myList = FXCollections.observableArrayList();
            String req = "SELECT * FROM `HOTEL`";
            try{
                PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(req);
                ResultSet rs = pst.executeQuery(req);

                while(rs.next()){
                    Hotel hotel = new Hotel();
                    hotel.setHotel_ID(rs.getInt(1));
                    hotel.setHotel_NAME(rs.getString(2));
                    hotel.setHotel_LOCATION(rs.getString(3));
                    hotel.setHOTEL_STARS(rs.getInt(4));
                    hotel.setHOTEL_LOCATION_X(rs.getString(5));
                    hotel.setHOTEL_LOCATION_Y(rs.getString(6));
                    
                    myList.add(hotel);
                }
            }catch (SQLException ex){
                System.out.println("Error"+ex.getMessage());
            }
            return myList;
            
        }
      
       public void DeleteHotel (int x) throws SQLException{
        String req ="DELETE FROM HOTEL WHERE HOTEL_ID = ?";
        PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(req);
        pst.setInt(1, x);
        pst.executeUpdate();
    
    }
       
        public void updateHotel (Hotel h){
        String req = "UPDATE HOTEL SET `HOTEL_NAME`=?,`HOTEL_LOCATION`=?,`HOTEL_STARS`=?,`HOTEL_LOCATION_X`=?,`HOTEL_LOCATION_Y`=? WHERE HOTEL_ID =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = DataSource.getInstance().getConnection().prepareStatement(req);
  
            preparedStatement.setString(1, h.getHotel_NAME());
            preparedStatement.setString(2, h.getHotel_LOCATION());
            preparedStatement.setInt(3, h.getHOTEL_STARS());
            preparedStatement.setString(4, h.getHOTEL_LOCATION_X());
            preparedStatement.setString(5, h.getHOTEL_LOCATION_Y());
            preparedStatement.setInt(6, h.getHotel_ID());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error"+ex.getMessage());
        }
    }
    
}
