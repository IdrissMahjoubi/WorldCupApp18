/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Team;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import Services.ServiceTeam;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.UUID;
import javafx.scene.control.Label;
import org.controlsfx.tools.Utils;

import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author pacha
 */
public class FXMLAddTeamController implements Initializable {

    @FXML
    private TextField TEAM_NAME;
    @FXML
    private TextField TEAM_COACH;
    @FXML
    private ChoiceBox<String> TEAM_CONTINENT;
    ObservableList<String> comboList2 = FXCollections.observableArrayList("Afrique","Asie & Océanie","Europe","Amerique de sud","Amerique de nord");
    @FXML
    private Button saveTeam;
    @FXML
    private Button addFlag;
    @FXML
    private Button addLogo;
    @FXML
    private ImageView pic;
    @FXML
    private ImageView pic1;
    
    String imageFile;
    String imageFile1;
   // private static String uuid;  
    @FXML
    private ChoiceBox<String> groupcb;
    ObservableList<String> comboList = FXCollections.observableArrayList("A","B","C","D","E","F","G","H");
    MediaPlayer mediaPlayer;
    @FXML
    private Button retour;
    @FXML
    private Label erreur;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        groupcb.setItems(comboList);
        TEAM_CONTINENT.setItems(comboList2);
        // TODO
    }    
    
    @FXML
    private void addFlag(ActionEvent event)throws MalformedURLException, IOException  {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
         
            Image image = new Image(selectedFile.toURI().toString());
            pic.setImage(image);
            imageFile = selectedFile.getName();
            int pos = imageFile.lastIndexOf("/");
            if (pos > 0) {
            imageFile = imageFile.substring(0, pos);
            }
            pic.setImage(image);
            String emplacement = "C:\\wamp64\\www\\ImagesPacha\\" + imageFile;
            System.out.println(emplacement);
            CopyImage(emplacement, selectedFile.toPath().toString());
       

        } else {
            System.out.println("file doesn't exist");
        }
    }

    @FXML
    private void addLogo(ActionEvent event) throws MalformedURLException, IOException {
       FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
         
            Image image = new Image(selectedFile.toURI().toString());
            pic1.setImage(image);
            imageFile1 = selectedFile.getName();
            int pos = imageFile1.lastIndexOf("/");
            if (pos > 0) {
            imageFile1 = imageFile1.substring(0, pos);
            }
            pic1.setImage(image);
            String emplacement = "C:\\wamp64\\www\\ImagesPacha\\" + imageFile1;
            System.out.println(emplacement);
            CopyImage(emplacement, selectedFile.toPath().toString());

        } else {
            System.out.println("file doesn't exist");
        }
    }
     File file = new File("src/Resources/Icons/FIFA_World_Cup_2018_Logo.png");
        Image image = new Image(file.toURI().toString());
    @FXML
    private void saveTeam(ActionEvent event) throws SQLException {
       if (!verifChamp()) {
            return;
        }
        String team_name = TEAM_NAME.getText();
        String team_coach = TEAM_COACH.getText();
        String team_group=groupcb.getValue();
        String team_continent = TEAM_CONTINENT.getValue();
        
        
        Team t = new Team(team_name,team_coach,team_group,team_continent);
        t.setTEAM_FLAG(imageFile);
        t.setTEAM_LOGO(imageFile1);
        System.out.println(t);
                    
        ServiceTeam s=new ServiceTeam();
        s.addTeam(t);
        
        TrayNotification tray = new TrayNotification();
        tray.setTitle("Equipe ajoutée");
        tray.setMessage(t.getTEAM_NAME());
        tray.showAndDismiss(Duration.seconds(4));
        tray.setImage(image);
        
    }
    public boolean verifChampVid(TextField element) {
        if (element.getText() == null || element.getText().trim().isEmpty()) {
            return false;

        }

        return true;
    }

    public boolean verifChamp() throws SQLException {
        if (verifChampVid(TEAM_NAME) && verifChampVid(TEAM_COACH)) {
            erreur.setVisible(false);

            return true;
        } else {
            erreur.setVisible(true);
            erreur.setText("Vous devez saisir tous les champs");
            return false;
        }
    }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
        Stage stage = new Stage();    
            Parent root = FXMLLoader.load(getClass().getResource("/Views/FXMLAffichageTeams.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            ((Node) event.getSource()).getScene().getWindow().hide();
            mediaPlayer.pause();
    }


    
    public void CopyImage(String url, String imageDestination) throws IOException {
        
        //URL l'emplacement de fichier image sous wamp exemple (http://localhost/image/product)
        

        InputStream inputStream = new FileInputStream(imageDestination);//upload l'image
        System.out.println("Start uploading second file");
        
        OutputStream output = new FileOutputStream(url);
        byte[] bytesIn = new byte[4096];
        int read = 1;
        while ((read = inputStream.read(bytesIn)) != -1) {//copier l'image au serveur
            output.write(bytesIn, 0, read);
        }
        output.close();
        inputStream.close();
    }

}
