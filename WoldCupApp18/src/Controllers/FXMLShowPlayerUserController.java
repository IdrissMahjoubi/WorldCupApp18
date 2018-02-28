/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.FXMLAffichageTeamUserController.teamImg;
import static Controllers.FXMLAffichageTeamUserController.teamS;
import Entities.Player;
import Services.ArticleServices;
import Services.NoteServices;
import Services.PlayerServices;
import Utilities.Session;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author Doggaz Jihed
 */
public class FXMLShowPlayerUserController implements Initializable {

 
    
    @FXML
    TableColumn<?, ?> name;
    @FXML
    TableColumn<?, ?> pos;
    @FXML
    TableColumn<?, ?> club;

    @FXML
    private Button bntBack;
    @FXML
    private Text player;
    @FXML
    private TableView<Player> table;
    @FXML
    private TableColumn<?, ?> tshirt;
    @FXML
    private TableColumn<?, ?> age;
    @FXML
    private TableColumn<?, ?> weight;
    @FXML
    private TableColumn<?, ?> height;
    @FXML
    private TableColumn<?, ?> team;
    @FXML
    private ImageView imgPlayer;
    @FXML
    private ImageView imgTeam;
    
   String imgPath;
    @FXML
    private Rating note;
    @FXML
    private Button bntNote;
    int user_id;
    int player_id;

        public Text getTitle() {
        return player;
    }

    public void setTitle(String title) {
        this.player.setText(title);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user_id = Session.LoggedUser.getUser_id();
        PlayerServices s = PlayerServices.getInstance();
     
        tshirt.setCellValueFactory(new PropertyValueFactory<>("PLAYER_TSHIRT"));
        name.setCellValueFactory(new PropertyValueFactory<>("PLAYER_NAME"));
        pos.setCellValueFactory(new PropertyValueFactory<>("PLAYER_POSITION"));
        age.setCellValueFactory(new PropertyValueFactory<>("PLAYER_AGE"));
        club.setCellValueFactory(new PropertyValueFactory<>("PLAYER_CLUB"));
        team.setCellValueFactory(new PropertyValueFactory<>("PLAYER_TEAM"));
        height.setCellValueFactory(new PropertyValueFactory<>("PLAYER_HEIGHT"));
        weight.setCellValueFactory(new PropertyValueFactory<>("PLAYER_WEIGHT"));
      
        table.setItems(s.showPlayersByTeam(teamS));

        table.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                if (newValue !=null){
                    showPlayerDetails(newValue);
                    note.setVisible(true);
                    bntNote.setVisible(true);
                }

                });
    }  
    

    
           void showPlayerDetails(Player p) {

        Image image1 = new Image(p.getPLAYER_PICTURE());
        imgPlayer.setImage(image1);
        
        //Image image2 = new Image(teamImg);
       // imgTeam.setImage(image2);
       
    }
    
   
    
    
    @FXML
    private void back(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLAffichageTeamUser.fxml"));
        try {
            Parent root = loader.load();
            FXMLAffichageTeamUserController dc = loader.getController();
            bntBack.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLAffichageTeamUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }


    @FXML
    private void notePlayer(ActionEvent event) {
        
        
        NoteServices ns = NoteServices.getInstance();
        player_id = table.getSelectionModel().getSelectedItem().getPLAYER_ID();
        try {
            if(ns.CheckNote(user_id, player_id)){
                int x = (int) note.getRating();
                int y = ns.getNumberNote(player_id);
                int z = ns.getNote(player_id);
                ns.addNotePlayer(x+z, y+1, player_id);
                ns.addNote(user_id, player_id);
                 int y1 = ns.getNumberNote(player_id);
                int z1 = ns.getNote(player_id);
                float w= (float) z1/y1;
                ns.addRatingPlayer(w, player_id);
                
            }else{
                Alert alert1 = new Alert(Alert.AlertType.WARNING);
                alert1.setTitle("Erreur de selection");
                alert1.setHeaderText("Vous etes déja votez");
                
                Optional<ButtonType> result = alert1.showAndWait();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLShowPlayerUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    
}
