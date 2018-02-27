/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import Services.ArticleServices;
<<<<<<< HEAD
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
=======
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
>>>>>>> d81c846c29556b9486a139c561d9f4433db6ecb4

/**
 * FXML Controller class
 *
 * @author Doggaz Jihed
 */
public class FXMLShowArticleUserController implements Initializable {

<<<<<<< HEAD
    @FXML
    private ScrollPane sp;

    @FXML
    VBox vb;
    Label title;
    Label desc;
    ImageView img;
    VBox hb;
    @FXML
    private Button home;
=======
    
    
   @FXML
   private ScrollPane sp;
    
   @FXML
   VBox vb;


   Label title;
   Text desc;
   ImageView img;
   VBox hb;
>>>>>>> d81c846c29556b9486a139c561d9f4433db6ecb4

    //Pane p;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
<<<<<<< HEAD

        ArticleServices s = new ArticleServices();
        for (int i = 0; i < s.showArticles().size(); i++) {
            hb = new VBox();
            //p.getChildren().add(i, title);
            title = new Label(s.showArticles().get(i).ARTICLE_TITLE);
            img = new ImageView();
            desc = new Label(s.showArticles().get(i).ARTICLE_DESCRIPTION);
            Image image = new Image(s.showArticles().get(i).ARTICLE_IMAGE);
            img.setImage(image);

=======
        
        ArticleServices s = ArticleServices.getInstance();
        for (int i = 0; i <s.showArticles().size();i++ ){
          hb = new VBox();
          //p.getChildren().add(i, title);
           title = new Label(s.showArticles().get(i).ARTICLE_TITLE);
           img = new ImageView();
           
          desc = new Text(s.showArticles().get(i).ARTICLE_DESCRIPTION);
          Image image = new Image(s.showArticles().get(i).ARTICLE_IMAGE);
          img.setImage(image);
           
>>>>>>> d81c846c29556b9486a139c561d9f4433db6ecb4
            img.setFitWidth(350);
            img.setFitHeight(300);

            hb.getChildren().add(0, title);
            hb.getChildren().add(1, img);
            hb.getChildren().add(2, desc);
            vb.getChildren().add(i, hb);

        }
        sp.setContent(vb);

    }

    @FXML
    private void SwitchToHome(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLUserinterface.fxml"));  
        try {
            Parent root = loader.load();
            FXMLUserinterfaceController dc = loader.getController();
            home.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("ERROR USER DETAILS=" + ex.getMessage()); 
        }
    }
    

}
