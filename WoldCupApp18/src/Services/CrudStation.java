/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author Bich
 */
import Utilities.DataSource;
import Entities.Station;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Bich
 */
public class CrudStation {
    
        public void addStation( Station st ) throws SQLException
    {
    String req ="INSERT INTO STATION(STATION_NAME,STATION_LOCATION,STATION_TYPE,STATION_LOCATION_X,STATION_LOCATION_Y) values (?,?,?,?,?)";
    
        PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(req);
        pst.setString(1, st.getSTATION_NAME());
        pst.setString(2, st.getSTATION_LOCATION());
        pst.setString(3, st.getSTATION_TYPE());
        pst.setString(4, st.getSTATION_LOCATION_X());
        pst.setString(5, st.getSTATION_LOCATION_Y());   
        pst.executeUpdate();
    }
    
            public ObservableList<Station> showStation() {
    

            ObservableList<Station> myList = FXCollections.observableArrayList();
            String req = "SELECT * FROM STATION";
            try{
                PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(req);
                ResultSet rs = pst.executeQuery(req);

                while(rs.next()){
                    Station s = new Station();
                    s.setSTATION_ID(rs.getInt(1));
                    s.setSTATION_NAME(rs.getString(2));
                    s.setSTATION_LOCATION(rs.getString(3));
                    s.setSTATION_TYPE(rs.getString(4));
                    s.setSTATION_LOCATION_X(rs.getString(5));
                    s.setSTATION_LOCATION_Y(rs.getString(6));
                    
                    myList.add(s);
                }
            }catch (SQLException ex){
                System.out.println("Error"+ex.getMessage());
            }
            return myList;
            
        }
      public void DeleteStation (int x) throws SQLException{
        String req ="DELETE FROM STATION WHERE STATION_ID = ?";
        PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(req);
        pst.setInt(1, x);
        pst.executeUpdate();
    
    }
      
   public Station findById(Integer id) {
        Station S = null;
        String req = "select * from STATION where STATION_ID =?";
        try {
                    PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(req);

            pst.setInt(1, id);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                S = new Station(resultSet.getInt("STATION_ID") ,
                        resultSet.getString(2), 
                        resultSet.getString(3), 
                        resultSet.getString(4), 
                        resultSet.getString(5), 
                        resultSet.getString(6)
                       ); }
        } catch (SQLException ex) {
        }
        return S;
    }
      
      public void updateStation (Station s){
        String req = "UPDATE STATION SET STATION_NAME=?, STATION_LOCATION=?, STATION_TYPE=?, STATION_LOCATION_X=?, STATION_LOCATION_Y=? WHERE STATION_ID =?";
        PreparedStatement preparedStatement;
        try {
        PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(req);
           
            pst.setString(1, s.getSTATION_NAME());
            pst.setString(2, s.getSTATION_LOCATION());
            pst.setString(3, s.getSTATION_TYPE());
            pst.setString(4, s.getSTATION_LOCATION_X());
            pst.setString(5, s.getSTATION_LOCATION_Y());
            
             pst.setInt(6, s.getSTATION_ID());
            
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error"+ex.getMessage());
        }
    }
    
}
