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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Entities.Evenement;
import java.sql.Date;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Bich
 */
public class CrudEvenement {
    
   
     public void addEvent( Evenement e ) throws SQLException
    {
         
    String req ="INSERT INTO EVENT (EVENT_NAME,EVENT_DATE,EVENT_END,EVENT_GOUV,EVENT_PLACE,EVENT_DESC,NBR_PARTICIP) values (?,?,?,?,?,?,?)";
        PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(req);
        pst.setString(1, e.getEVENT_NAME());
        pst.setDate(2, (Date) e.getEVENT_DATE());
        pst.setDate(3, (Date) e.getEVENT_END());

        pst.setString(4, e.getEVENT_GOUV());
        pst.setString(5, e.getEVENT_PLACE());
        pst.setString(6, e.getEVENT_DESC());
        pst.setInt(7, e.getNBR_PARTICIP());
        pst.executeUpdate();
    }
     
    public void DeleteEvent (int x) throws SQLException  {
        String req ="DELETE FROM EVENT WHERE EVENT_ID= '"+x+"'";
        PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(req);
        pst.executeUpdate();
    }
    
    
            public void updateEvent (Evenement e){
        String req = "UPDATE EVENT SET `EVENT_NAME`=?,`EVENT_DATE`=?,`EVENT_END`=?,`EVENT_GOUV`=?,`EVENT_PLACE`=?,`EVENT_DESC`=?, `NBR_PARTICIP`=? WHERE EVENT_ID =?";
        PreparedStatement preparedStatement;
        try {
            
            preparedStatement = DataSource.getInstance().getConnection().prepareStatement(req);
            preparedStatement.setString(1, e.getEVENT_NAME());
            preparedStatement.setDate(2, (Date) e.getEVENT_DATE());
            preparedStatement.setDate(3, (Date) e.getEVENT_END());

            preparedStatement.setString(4, e.getEVENT_GOUV());

            preparedStatement.setString(5, e.getEVENT_PLACE());
            preparedStatement.setString(6, e.getEVENT_DESC());
            preparedStatement.setInt(7, e.getNBR_PARTICIP());

            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error"+ex.getMessage());
        }
    }




    public ObservableList<Evenement> showEvent() {
    
            ObservableList<Evenement> myList = FXCollections.observableArrayList();
            String req = "SELECT * FROM EVENT";
            try{
                PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(req);
                ResultSet rs = pst.executeQuery(req);

                while(rs.next()){
                    Evenement e = new Evenement();
                    e.setEVENT_ID(rs.getInt(1));
                    e.setEVENT_NAME(rs.getString(2));
                    e.setEVENT_DATE(rs.getDate(3));
                    e.setEVENT_END(rs.getDate(4));
                    e.setEVENT_GOUV(rs.getString(5));
                    e.setEVENT_PLACE(rs.getString(6));
                    e.setEVENT_DESC(rs.getString(7));
                    e.setNBR_PARTICIP(rs.getInt(8));
                  
                    myList.add(e);
                }
            }catch (SQLException ex){
                System.out.println("Error"+ex.getMessage());
            }
            return myList;
            
        }
    
    public void updateparticip( int y, String x)
    {
        
        
        String req1 = "UPDATE EVENT SET  NBR_PARTICIP=? WHERE EVENT_NAME=?  ";
            PreparedStatement preparedStatement;
        try {
            preparedStatement = DataSource.getInstance().getConnection().prepareStatement(req1);
        
           preparedStatement.setInt(1, y);
           preparedStatement.setString(2, x);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error"+ex.getMessage());
        }

    }
    
 
    

}

