/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Utilities.DataSource;
import static Utilities.DataSource.instance;
import java.sql.Date;

/**
 *
 * @author MyTEK
 */
public class User {
   private int user_id; 
   private String user_name;
   private String user_last_name;
   private Date user_birthday;
   private String user_nationality;
   private String user_email;
   private int user_tel;
   private String user_tel2;
   private String user_login;
   private String user_password;
   private String user_team;
   private int user_fidelity;
   private int user_state;
   private String user_type;
   
   
   
   public User(String email)
   {
      this.user_email=email;
   }
   
   public User(String tel,int a)
   {
      this.user_tel2=tel;
   }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public User(int user_id) {
        this.user_id = user_id;
        
    }
     public String getUser_tel2() {
        return user_tel2;
    }

    public void setUser_tel2() {
        this.user_tel2 = Integer.toString(user_tel);
    }
   

    public User(int user_id, String user_name, String user_last_name, Date user_birthday, String user_nationality, String user_email, int user_tel, String user_login, String user_password, String user_team, int user_fidelity, int user_state, String user_type) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_last_name = user_last_name;
        this.user_birthday = user_birthday;
        this.user_nationality = user_nationality;
        this.user_email = user_email;
        this.user_tel = user_tel;
        this.user_login = user_login;
        this.user_password = user_password;
        this.user_team = user_team;
        this.user_fidelity = user_fidelity;
        this.user_state = user_state;
        this.user_type = user_type;
    }

    public User(String user_name, String user_last_name, Date user_birthday, String user_nationality, String user_email, int user_tel, String user_login, String user_password, String user_team, int user_fidelity, int user_state, String user_type) {
        this.user_name = user_name;
        this.user_last_name = user_last_name;
        this.user_birthday = user_birthday;
        this.user_nationality = user_nationality;
        this.user_email = user_email;
        this.user_tel = user_tel;
        this.user_login = user_login;
        this.user_password = user_password;
        this.user_team = user_team;
        this.user_fidelity = user_fidelity;
        this.user_state = user_state;
        this.user_type = user_type;
    }

    public User(String user_name, String user_last_name, Date user_birthday, String user_nationality, String user_email, int user_tel, String user_login, String user_password, String user_team) {
        this.user_name = user_name;
        this.user_last_name = user_last_name;
        this.user_birthday = user_birthday;
        this.user_nationality = user_nationality;
        this.user_email = user_email;
        this.user_tel = user_tel;
        this.user_login = user_login;
        this.user_password = user_password;
        this.user_team = user_team;
        
    }

    public User() {
    }

   

    

    @Override
    public String toString() {
        return "User{" + "user_name=" + user_name + ", user_last_name=" + user_last_name + ", user_birthday=" + user_birthday + ", user_nationality=" + user_nationality + ", user_email=" + user_email + ", user_tel=" + user_tel + ", user_login=" + user_login + ", user_password=" + user_password + ", user_team=" + user_team + ", user_fidelity=" + user_fidelity + ", user_state=" + user_state + ", user_type=" + user_type + '}';
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_last_name() {
        return user_last_name;
    }

    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }

    public Date getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_nationality() {
        return user_nationality;
    }

    public void setUser_nationality(String user_nationality) {
        this.user_nationality = user_nationality;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public int getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(int user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_team() {
        return user_team;
    }

    public void setUser_team(String user_team) {
        this.user_team = user_team;
    }

    public int getUser_fidelity() {
        return user_fidelity;
    }

    public void setUser_fidelity(int user_fidelity) {
        this.user_fidelity = user_fidelity;
    }

    public int getUser_state() {
        return user_state;
    }

    public void setUser_state(int user_state) {
        this.user_state = user_state;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
     
   
   
    
}
