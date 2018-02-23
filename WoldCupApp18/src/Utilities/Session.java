/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import Entities.User;
import Services.ServiceUser;


/**
 *
 * @author MyTEK
 */
public class Session {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





/**
 * 
 * @author Nourelhouda 
 */

    
    //private static Session instance ; 

  
    public static ServiceUser su =new ServiceUser();
    public  static User LoggedUser ;

    public static Session getDefaultInstance(Properties props, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

    public Session() {
    }

   

    public User getLoggedUser() {
        return LoggedUser;
    }

    

    public  void setLoggedUser(User LoggedUser) {
        this.LoggedUser = LoggedUser;
    }

  
    
    /**
     *
     * @param login
     * @return
     * @throws SQLException
     */
    public User SetLoggedUser (String login ) throws SQLException{
       Connection connection;
         connection = DataSource.getInstance().getConnection();
               
        String sql = "SELECT * FROM user WHERE USER_LOGIN=? " ;
        
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, login);
        
        ResultSet resultSet = pst.executeQuery();
        if(resultSet.next()){
         LoggedUser = new User(); 
        LoggedUser.setUser_id(resultSet.getInt("USER_ID") );  
        LoggedUser = su.findById(LoggedUser.getUser_id());
        }
        
       
        return LoggedUser;   
        /*
         g req = "select * from fos_user WHERE username=?";
        try {
            ste=datasource.getConnection().prepareStatement(req);
            ste.setString(1, username);
            rs = ste.executeQuery();
            if (rs.next()) {
                loggedUser = new fos_user();
             loggedUser.setId(rs.getInt("id"));
            loggedUser.setUsername(rs.getString("username"));
            loggedUser.setRole(rs.getString("roles"));
             loggedUser.setRole(rs.getString("password"));
            return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
        */
    }

    

}


