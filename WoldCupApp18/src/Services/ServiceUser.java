/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Controllers.ControllerSendMail;
import Controllers.ControllerSendSms;
import Controllers.FXMLPasswordRecoveryController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Entities.User;
import Utilities.DataSource;
import static Utilities.DataSource.instance;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author MyTEK
 */
public class ServiceUser {

    public Connection con;
    PreparedStatement ste;
    public static ServiceUser instance;
    
    public static ServiceUser getInstance(){
        if (instance==null){
            instance = new ServiceUser();
        }
        return instance;
    }

    public ServiceUser() {

        con = DataSource.getInstance().getConnection();
        
    }
    

    public void addUser(User u){

        try {
            String req = "INSERT INTO `USER`(`USER_NAME`, `USER_LASTNAME`, `USER_BIRTHDAY`, `USER_NATIONALITY`, `USER_EMAIL`, `USER_TEL`, `USER_LOGIN`, `USER_PASSWORD`, `USER_TEAM`)  VALUES (?,?,?,?,?,?,?,?,?)";
            ste = con.prepareStatement(req);
            ste.setString(1, u.getUser_name());
            ste.setString(2, u.getUser_last_name());
            ste.setDate(3, (Date)u.getUser_birthday());
            ste.setString(4, u.getUser_nationality());
            ste.setString(5, u.getUser_email());
            ste.setInt(6, u.getUser_tel());
            ste.setString(7, u.getUser_login());
            ste.setString(8, u.getUser_password());
            ste.setString(9, u.getUser_team());
            ste.executeUpdate();
        } catch (SQLException ex) {
                System.out.println("ERROR CREATE USER= "+ex.getMessage());
        }

    }

    public ObservableList<User> showUsers() throws SQLException {
        ObservableList<User> myList = FXCollections.observableArrayList();
        String requete = "SELECT * FROM `USER`";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(requete);
            ResultSet rs = preparedStatement.executeQuery(requete);

            while (rs.next()) {

                User u = new User();
                u.setUser_id(rs.getInt(1));
                u.setUser_name(rs.getString(2));
                u.setUser_last_name(rs.getString(3));
                u.setUser_birthday(rs.getDate(4));
                u.setUser_nationality(rs.getString(5));
                u.setUser_email(rs.getString(6));
                u.setUser_tel(rs.getInt(7));
                u.setUser_login(rs.getString(8));
                u.setUser_password(rs.getString(9));
                u.setUser_team(rs.getString(10));
                //System.out.println(u);
                myList.add(u);
            }
            //myList.forEach(e -> System.out.println(e));
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        return myList;

    }

    public User findById(Integer user_id) {
        User u = null;
        String req = "select * from USER where USER_ID =?";
        try {
            ste = con.prepareStatement(req);
            ste.setInt(1, user_id);
            ResultSet resultSet = ste.executeQuery();
            while (resultSet.next()) {
                u = new User(resultSet.getInt("USER_ID"));
                resultSet.getInt(1);
                resultSet.getString(2);
                resultSet.getString(3);
                resultSet.getString(4);
                resultSet.getString(5);
                resultSet.getString(6);
                resultSet.getInt(7);
                resultSet.getString(8);
                resultSet.getString(9);
                resultSet.getInt(10);
                resultSet.getInt(11);
                resultSet.getInt(12);
                resultSet.getInt(13);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return u;
    }

    public User findByLogin(String login) {
        User u = null;
        String req = "select * from USER where USER_LOGIN =?";
        try {
            ste = con.prepareStatement(req);
            ste.setString(1, login);
            ResultSet resultSet = ste.executeQuery();
            while (resultSet.next()) {
                u = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getInt(11),
                        resultSet.getInt(12),
                        resultSet.getString(13));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return u;
    }

    public void DeleteUser(String user_name) {

        String requete = "DELETE  FROM `USER` where  USER_NAME = ?";
        // System.out.println("aaa");
        try {
            ste = con.prepareStatement(requete);
            ste.setString(1, user_name);
            ste.executeUpdate();
            System.out.println("aaaaaaa");

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    public int CheckLoginAndPassword(String log, String Pass) throws SQLException {

        String sql = "SELECT * FROM USER WHERE USER_LOGIN='" + log + "' AND USER_PASSWORD='" + Pass + "'";

        int isValid = 0;
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println(sql);

            while (rs.next()) {
                isValid = rs.getInt(1);
            }
            
            

        } catch (Exception ex) {
        }

        return isValid;
    }

    public String CheckType(String log, String Pass) throws SQLException {

        String sql = "SELECT * FROM USER WHERE USER_LOGIN='" + log + "' AND USER_PASSWORD='" + Pass + "' ";

        String type = "";
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println(sql);
//Session.LoggedUser.getUser_id();

            while (rs.next()) {
                type = rs.getString(13);
            }

        } catch (Exception ex) {
        }

        return type;
    }

    public void updateUser(User u) {
        String req = "UPDATE USER SET `USER_NAME`=?,`USER_LASTNAME`=?,`USER_BIRTHDAY`=?,`USER_NATIONALITY`=?,`USER_EMAIL`=?,`USER_TEL`=?,`USER_LOGIN`=?,`USER_PASSWORD`=?,`USER_TEAM`=? WHERE USER_ID =?";
        try {
            ste = con.prepareStatement(req);

            ste.setString(1, u.getUser_name());
            ste.setString(2, u.getUser_last_name());
            ste.setDate(3, (Date) u.getUser_birthday());
            ste.setString(4, u.getUser_nationality());
            ste.setString(5, u.getUser_email());
            ste.setInt(6, u.getUser_tel());
            ste.setString(7, u.getUser_login());
            ste.setString(8, u.getUser_password());
            ste.setString(9, u.getUser_team());
            ste.setInt(10, u.getUser_id());

            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    public void closeAccount(User u) {
        String req = "UPDATE USER SET `USER_STATE`=0 WHERE USER_ID =?";
        try {
            ste = con.prepareStatement(req);
            //ste.setInt(1, u.getUser_state());
            ste.setInt(1, u.getUser_id());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    public void upgradeUser(User u) {
        String req = "UPDATE USER SET `USER_TYPE`='admin' WHERE USER_ID =?";
        try {
            ste = con.prepareStatement(req);
            //ste.setInt(1, u.getUser_state());
            ste.setInt(1, u.getUser_id());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    public int CheckState(String log, String Pass) throws SQLException {

        String sql = "SELECT * FROM USER WHERE USER_LOGIN='" + log + "' AND USER_PASSWORD='" + Pass + "' ";

        int state = 1;
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println(sql);
//Session.LoggedUser.getUser_id();

            while (rs.next()) {
                state = rs.getInt(12);
            }

        } catch (Exception ex) {
        }

        return state;
    }

    /*public void changeAdminToMember (User u){
            String req = "UPDATE user SET `USER_TYPE`=`membre` WHERE USER_ID =?";
           System.out.println(req);
           
        try {
            ste = con.prepareStatement(req);
            //ste.setInt(1, u.getUser_state());
            ste.setInt(3, u.getUser_id());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error"+ex.getMessage());
        }
    }*/
    public static void sendPassword(User u)
    {
               Connection bd = DataSource.getInstance().getConnection();
               String query="select USER_PASSWORD from USER where USER_EMAIL = ?";
        try {
            PreparedStatement statement = bd.prepareStatement(query);
            statement.setString(1, u.getUser_email());
            ResultSet rs = statement.executeQuery();
            int count = 0;
            while(rs.next())
            {
                try {
                    ControllerSendMail.sendMail(u.getUser_email(),"password recovery" ,rs.getString("USER_PASSWORD") );
                    FXMLPasswordRecoveryController.isfound="true";
                    count++;

                } catch (MessagingException ex) {
                    Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            if(count <=0)
            {
                FXMLPasswordRecoveryController.isfound="false";

            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void sendPassword2(User u)
    {
               Connection bd = DataSource.getInstance().getConnection();
               String query="select USER_PASSWORD from USER where USER_TEL = ?";
        try {
            PreparedStatement statement = bd.prepareStatement(query);
            statement.setString(1, u.getUser_tel2());
            ResultSet rs = statement.executeQuery();
            int count = 0;
            while(rs.next())
            {
                ControllerSendSms.sendSms("+216"+u.getUser_tel2(),"WORLD CUP APP Password : "+rs.getString("USER_PASSWORD") );
                FXMLPasswordRecoveryController.isfound="true";
                count++;
            }
            
            
            if(count <=0)
            {
                FXMLPasswordRecoveryController.isfound="false";

            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
}
