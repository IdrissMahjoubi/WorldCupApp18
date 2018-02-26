/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Services.ArticleServices;
import Services.PlayerServices;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Doggaz Jihed
 */
public class FXMLShowPlayerUserController implements Initializable {

    @FXML
    private ScrollPane sp;
    @FXML
    private VBox vb;
    
    Label name;
    Text pos;
    Text club;
    Text w;
    Text h;
    ImageView img;
    @FXML
    HBox hb;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        PlayerServices s = PlayerServices.getInstance();
        for (int i = 0; i <10;i++ ){
            hb = new HBox();

           name = new Label(s.showPlayers().get(i).getPLAYER_NAME());
           img = new ImageView();
           
          pos = new Text(s.showPlayers().get(i).getPLAYER_POSITION());
          club = new Text(s.showPlayers().get(i).getPLAYER_CLUB());
          w = new Text(s.showPlayers().get(i).getPLAYER_WEIGHT());
          h = new Text(s.showPlayers().get(i).getPLAYER_HEIGHT());
          Image image = new Image(s.showPlayers().get(i).getPLAYER_PICTURE());
          img.setImage(image);
           
            img.setFitWidth(40);
            img.setFitHeight(50);
            
            
           hb.getChildren().add(0, name);
           hb.getChildren().add(1, pos);
           hb.getChildren().add(2, club);
           hb.getChildren().add(3, w);
           hb.getChildren().add(4, h);
           hb.getChildren().add(5, img);
           
           hb.setLayoutX(30);
           hb.setLayoutX(30);
           hb.setId("hb");
           vb.setId("vb");

           vb.getChildren().add(i, hb);
           
           }
       sp.setContent(vb);
    }    
    
}
