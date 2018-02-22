package Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pacha
 */
public class DataSource {
    public static DataSource instance;
    String url="jdbc:mysql://sql11.freemysqlhosting.net/sql11222693";
    String username="sql11222693";
    String password= "HsKTYLsInw";
    Connection conn ;
    DataSource() {
       
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("Data base connexion failed ! check parametres"+ex.getMessage());
        }
   
    }
    public static DataSource getInstance(){
        if (instance==null){
            instance = new DataSource();
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }
}
