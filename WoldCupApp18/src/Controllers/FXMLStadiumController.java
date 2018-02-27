package Controllers;

import Entities.Stadium;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Services.CrudStadium;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import validation.TextFieldValidation;

/**
 * FXML Controller class
 *
 * @author Bich
 */
public class FXMLStadiumController implements Initializable {

    @FXML
    private TextField StadiumName;
    @FXML
    private TextField StadiumLocation;
    @FXML
    private TextField StadiumCapacity;
    @FXML
    private TextField StadiumYmap;
    @FXML
    private TextField StadiumXmap;
    @FXML
    private Button addStadium;
    @FXML
    private Button Cancel;
    @FXML
    private Button ChosePicture;

    @FXML
    private ImageView PicViewer;
    @FXML
    private ListView<?> ListView;
    @FXML
    private Button afficher;
    @FXML
    private Label lbl1;
    @FXML
    private Label lbl12;
    @FXML
    private Label lbl13;
    @FXML
    private Label lbl14;
    @FXML
    private Label lbl5;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AddStadium(ActionEvent event) throws SQLException {

        boolean isnotAlphName = validation.TextFieldValidation.textalphabet(StadiumName, lbl1, "Il faut remplir avec des alphabets");
        boolean isnotAlphLocation = validation.TextFieldValidation.textalphabet(StadiumLocation, lbl12, "Il faut remplir avec des alphabets");
        boolean isnotNumCapacity = TextFieldValidation.texNum(StadiumCapacity, lbl13, "Il faut remplir avec des chiffres");
        boolean isnotNumXmap = TextFieldValidation.texNum(StadiumXmap, lbl14, "Il faut remplir avec des chiffres pour latitude");
        boolean isnotNumYmap = TextFieldValidation.texNum(StadiumYmap, lbl5, "Il faut remplir avec des chiffres pour Longtitude");
        boolean var = false ;
        
        if (isnotAlphName) {
            lbl1.setText("");
        }
        if (isnotAlphLocation) {
            lbl12.setText("");
        }
        if (isnotNumCapacity) {
            lbl13.setText("");
        }
        if (isnotNumXmap) {
            lbl14.setText("");
        }
         if (isnotNumYmap) {
            lbl5.setText("");
        }
        
      
        String STADIUM_NAME = StadiumName.getText();
        String STADIUM_LOCATION = StadiumLocation.getText();
        int STADIUM_CAPACITY;
        STADIUM_CAPACITY = Integer.parseInt(StadiumCapacity.getText());
        String STADUIM_LOCATION_X = StadiumXmap.getText();
        String STADUIM_LOCATION_Y = StadiumYmap.getText();

        Stadium s = new Stadium(STADIUM_NAME, STADIUM_LOCATION, STADIUM_CAPACITY, STADUIM_LOCATION_X, STADUIM_LOCATION_Y);
        s.setSTADIUM_PICTURE(image_path);
        CrudStadium cr = new CrudStadium();
        cr.addStadium(s);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLShowStadiums.fxml"));
        try {
            Parent root = loader.load();
            FXMLShowStadiumsController dc = loader.getController();
            addStadium.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLShowStadiumsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void EmptyFields(ActionEvent event) {
        StadiumName.clear();
        StadiumLocation.clear();
        StadiumCapacity.clear();

        StadiumXmap.clear();
        StadiumYmap.clear();
        try {
            Parent page1 = FXMLLoader.load(getClass().getResource("/Views/FXMLMenu.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    String image_path;

    @FXML
    private void ChosePicture(ActionEvent event) throws MalformedURLException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
            image_path = selectedFile.toURI().toURL().toString();
            Image image = new Image(image_path);
            PicViewer.setImage(image);
        } else {
            System.out.println("fichier invalide");
        }
    }

    @FXML
    private void afficherStades(ActionEvent event) {
        try {
            Parent page1 = FXMLLoader.load(getClass().getResource("/Views/FXMLShowStadiums.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
