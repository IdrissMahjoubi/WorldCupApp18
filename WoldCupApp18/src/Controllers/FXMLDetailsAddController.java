/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Doggaz Jihed
 */
public class FXMLDetailsAddController implements Initializable {

    @FXML
    private Label title;
    @FXML
    private ImageView img;
    @FXML
    private Label desc;
    @FXML
    private Button previous;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public Label getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(Image imgS) {
        this.img.setImage(imgS);
    }
    public Label getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc.setText(desc);
    }

    @FXML
    private void previousDetails(ActionEvent event) {
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLShowArticle.fxml"));
        try {
            Parent root=loader.load();
            previous.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDetailsAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
