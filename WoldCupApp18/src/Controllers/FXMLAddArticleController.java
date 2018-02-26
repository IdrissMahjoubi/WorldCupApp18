/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import Entities.Article;
import Services.ArticleServices;

/**
 * FXML Controller class
 *
 * @author Doggaz Jihed
 */
public class FXMLAddArticleController implements Initializable {

    @FXML
    private TextField title;
    @FXML
    private TextArea desc;
    @FXML
    private ImageView img;
    @FXML
    private Button bnt1;
    @FXML
    private Button bnt2;
    
    String imageFile;
    @FXML
    private Button cancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void browserImage(ActionEvent event) throws MalformedURLException {
        
          FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
         
            imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);

            Image image = new Image(imageFile);

            img.setImage(image);
       

        } else {
            System.out.println("file doesn't exist");
        }
        
    }

    @FXML
    private void addArticle(ActionEvent event) {
        String titleA = title.getText();
        String descA = desc.getText();

        
        Article a = new Article(titleA,descA,imageFile);
       
      
                    
        ArticleServices s=ArticleServices.getInstance();
        s.addArticle(a);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLDetailsAdd.fxml"));
        try {
            Parent root=loader.load();
            FXMLDetailsAddController details=loader.getController();
            details.setTitle(titleA);
            details.setDesc(descA);
            
            Image image = new Image(imageFile);
            details.setImg(image);
          
            bnt2.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLAddArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cancelAdd(ActionEvent event) {
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLShowArticle.fxml"));
        try {
            Parent root=loader.load();
           cancel.getScene().setRoot(root);
          
        } catch (IOException ex) {
            Logger.getLogger(FXMLAddArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
