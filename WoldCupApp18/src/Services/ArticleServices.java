/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Utilities.DataSource;

/**
 *
 * @author Doggaz Jihed
 */
public class ArticleServices {
    
    Connection connection;
    PreparedStatement preparedStatement;
    
    static ArticleServices instance;
   
    public ArticleServices() {
           connection = DataSource.getInstance().getConnection();

    }

      public static ArticleServices getInstance() {
        if (instance == null) {
            instance = new ArticleServices();
        }
        return instance;
    }
    
    public void addArticle(Article a){
        String requete="INSERT INTO `ARTICLE`(`ARTICLE_TITLE`,`ARTICLE_DESCRIPTION` , `ARTICLE_IMAGE`) VALUES (?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(requete);
          
            preparedStatement.setString(1, a.getARTICLE_TITLE());
            preparedStatement.setString(2, a.getARTICLE_DESCRIPTION());
            preparedStatement.setString(3, a.getARTICLE_IMAGE());
           
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public ObservableList<Article> showArticles(){
        ObservableList<Article> myList=FXCollections.observableArrayList();
        String requete="Select * from ARTICLE";
        PreparedStatement preparedStatement;
        try {
            preparedStatement=connection.prepareStatement(requete);
            //Statement st=DataSource.getInstance().getConn().createStatement();
            ResultSet rs = preparedStatement.executeQuery(requete);
            while(rs.next()){
                Article a = new Article();
                a.ARTICLE_ID=rs.getInt(1);
                a.ARTICLE_TITLE=rs.getString(2);
                a.ARTICLE_DESCRIPTION=rs.getString(3);
                a.ARTICLE_IMAGE=rs.getString(4);
                
                
                myList.add(a);
            }
        } catch (SQLException ex) {
            System.out.println("Error"+ex.getMessage());
        }
        return myList;
    }
        
   /*public Team findById(Integer id_team) {
        Team t = null;
        String req = "select * from team where TEAM_ID =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_team);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                t = new Team(resultSet.getInt("TEAM_ID") ,
                        resultSet.getString(2), 
                        resultSet.getString(3), 
                        resultSet.getInt(4), 
                        resultSet.getInt(5), 
                        resultSet.getInt(6), 
                        resultSet.getInt(7), 
                        resultSet.getInt(8), 
                        resultSet.getInt(9), 
                        resultSet.getInt(10), 
                        resultSet.getInt(11), 
                        resultSet.getString(12), 
                        resultSet.getString(13) , 
                        resultSet.getString(14) ,  
                        resultSet.getString(15) );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return t;
    }*/
    public void removeArticle(int team_id) {
        String req = "delete from ARTICLE where ARTICLE_ID =?";
        //PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, team_id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
    }
     public void updateArticle(Article a) {
        String req = "UPDATE `ARTICLE` SET `ARTICLE_TITLE`=?,`ARTICLE_DESCRIPTION`=?,`ARTICLE_IMAGE`=? WHERE ARTICLE_ID = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, a.getARTICLE_TITLE());
            preparedStatement.setString(2, a.getARTICLE_DESCRIPTION());
            preparedStatement.setString(3, a.getARTICLE_IMAGE());
            preparedStatement.setInt(4, a.getARTICLE_ID());
            
            
            
            
   
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
     

 
    
}
