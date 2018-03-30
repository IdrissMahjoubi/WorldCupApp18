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
    protected String url = "jdbc:mysql://localhost/world_cup_app_18";
    protected String username = "root";
    protected String password = "root";
    protected Connection connection;

    DataSource() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("Data base connexion failed ! check parametres" + ex.getMessage());
        }
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
