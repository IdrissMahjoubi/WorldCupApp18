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
    @FXML
    private ChoiceBox<String> groupcb;
    ObservableList<String> comboList = FXCollections.observableArrayList("A","B","C","D","E","F","G","H");
    MediaPlayer mediaPlayer;
    @FXML
    private Button retour;
    @FXML
    private Button stop;
    @FXML
    private Button play;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Media musicFile=new Media("file:/C:/Users/pacha/Music/Ya%20russia%20haw%20jayin.mp3");
        mediaPlayer=new MediaPlayer(musicFile);
        mediaPlayer.setAutoPlay(true);
        groupcb.setItems(comboList);
        TEAM_CONTINENT.setItems(comboList2);
        // TODO
    }    
    
    @FXML
    private void addFlag(ActionEvent event)throws MalformedURLException  {
         FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
         
            imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);

            Image image = new Image(imageFile);

            pic.setImage(image);
       

        } else {
            System.out.println("file doesn't exist");
        }
    }

    @FXML
    private void addLogo(ActionEvent event) throws MalformedURLException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
         
            imageFile1 = selectedFile.toURI().toURL().toString();
            

            Image image = new Image(imageFile1);

            pic1.setImage(image);
       

        } else {
            System.out.println("file doesn't exist");
        }
    }
    public Image image=new Image("file:/C:/Users/pacha/Pictures/FIFA_World_Cup_2018_Logo.png",true);
    @FXML
    private void saveTeam(ActionEvent event) {
        String team_name = TEAM_NAME.getText();
        String team_coach = TEAM_COACH.getText();
        String team_group=groupcb.getValue();
        String team_continent = TEAM_CONTINENT.getValue();
        
        Team t = new Team(team_name,team_coach,team_group,team_continent);
        t.setTEAM_FLAG(imageFile);
        t.setTEAM_LOGO(imageFile1);
                    
        ServiceTeam s=new ServiceTeam();
        s.addTeam(t);
        
        TrayNotification tray = new TrayNotification();
        tray.setTitle("Equipe ajoutée");
        tray.setMessage(t.getTEAM_NAME());
        tray.showAndDismiss(Duration.seconds(4));
        tray.setImage(image);
        
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

    @FXML
    private void stopper(ActionEvent event) {
        mediaPlayer.pause();
    }

    @FXML
    private void play(ActionEvent event) {
        mediaPlayer.play();
    }
}
