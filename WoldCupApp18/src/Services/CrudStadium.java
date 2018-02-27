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
import Entities.Stadium;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Utilities.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Bich
 */
public class CrudStadium {
    
    
 DataSource ds = DataSource.getInstance();
    Statement statement;
    Connection connection;
    ResultSet result;
    static CrudStadium instance;
    static CrudStadium crudStadium;
    

    public CrudStadium() {
        connection = ds.getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println("Constructor Crud Stadium" + ex.getMessage());
        }
    }
    
     public void addStadium( Stadium s ) throws SQLException
    {
    String req ="INSERT INTO STADIUM (STADIUM_NAME,STADIUM_LOCATION,STADIUM_CAPACITY,STADIUM_PICTURE,STADIUM_LOCATION_X,STADIUM_LOCATION_Y) values (?,?,?,?,?,?)";
    
        PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(req);
        pst.setString(1, s.getSTADIUM_NAME());
        pst.setString(2, s.getSTADIUM_LOCATION());
        pst.setInt(3, s.getSTADIUM_CAPACITY());
        pst.setString(4, s.getSTADIUM_PICTURE());
        pst.setString(5, s.getSTADIUM_LOCATION_X());
        pst.setString(6, s.getSTADIUM_LOCATION_Y());
        pst.executeUpdate();
    }
     
     
    public ObservableList<Stadium> showStadium() throws SQLException{
    
            ObservableList<Stadium> myList = FXCollections.observableArrayList();
            String req = "SELECT * FROM STADIUM";
            try{
                PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(req);
                ResultSet rs = pst.executeQuery(req);

                while(rs.next()){
                    Stadium s = new Stadium();
                    s.setSTADIUM_ID(rs.getInt(1));
                    s.setSTADIUM_NAME(rs.getString(2));
                    s.setSTADIUM_LOCATION(rs.getString(3));
                    s.setSTADIUM_CAPACITY(rs.getInt(4));
                    s.setSTADIUM_PICTURE(rs.getString(5));
                    s.setSTADIUM_LOCATION_X(rs.getString(6));
                    s.setSTADIUM_LOCATION_Y(rs.getString(7));

                    myList.add(s);
                }
            }catch (SQLException ex){
                System.out.println("Error"+ex.getMessage());
            }
            return myList;
            
        }
    
    public void DeleteStadium (int x) throws SQLException{
    String req ="DELETE FROM STADIUM WHERE STADIUM_ID= '"+x+"'";
        PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(req);
        pst.executeUpdate();
    
    }
    

        public void updateStadium (Stadium s){
        String req = "UPDATE STADIUM SET `STADIUM_NAME`=?,`STADIUM_LOCATION`=?,`STADIUM_CAPACITY`=?,`STADIUM_PICTURE`=?,`STADIUM_LOCATION_X`=?,`STADIUM_LOCATION_Y`=? WHERE STADIUM_ID =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = DataSource.getInstance().getConnection().prepareStatement(req);
  
            preparedStatement.setString(1, s.getSTADIUM_NAME());
            preparedStatement.setString(2, s.getSTADIUM_LOCATION());
            preparedStatement.setInt(3, s.getSTADIUM_CAPACITY());
            preparedStatement.setString(4, s.getSTADIUM_PICTURE());
            preparedStatement.setString(5, s.getSTADIUM_LOCATION_X());
            preparedStatement.setString(6, s.getSTADIUM_LOCATION_Y());
            preparedStatement.setInt(7, s.getSTADIUM_ID());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error"+ex.getMessage());
        }
    }
        
        
        
}
    
    



