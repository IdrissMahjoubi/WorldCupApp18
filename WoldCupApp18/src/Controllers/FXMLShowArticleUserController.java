/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXMasonryPane;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import Entities.Article;
import Services.ArticleServices;

/**
 * FXML Controller class
 *
 * @author Doggaz Jihed
 */
public class FXMLShowArticleUserController implements Initializable {

    
    
    @FXML
    private ScrollPane sp;
    
    @FXML
    VBox vb;
   Label title;
   Label desc;
    ImageView img;
    VBox hb;

    
    //Pane p;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ArticleServices s = new ArticleServices();
        for (int i = 0; i <s.showArticles().size();i++ ){
          hb = new VBox();
          //p.getChildren().add(i, title);
           title = new Label(s.showArticles().get(i).ARTICLE_TITLE);
           img = new ImageView();
           desc = new Label(s.showArticles().get(i).ARTICLE_DESCRIPTION);
          Image image = new Image(s.showArticles().get(i).ARTICLE_IMAGE);
          img.setImage(image);
           
            img.setFitWidth(350);
            img.setFitHeight(300);
            
            
           hb.getChildren().add(0, title);
           hb.getChildren().add(1, img);
           hb.getChildren().add(2, desc);
           vb.getChildren().add(i, hb);
           
           }
       sp.setContent(vb);
 
        
        

        
        
    }
        
        }
        
    
        
       
       
        
       
    
