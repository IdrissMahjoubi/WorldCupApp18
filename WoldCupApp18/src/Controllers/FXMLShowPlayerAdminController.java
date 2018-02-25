/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import Entities.Player;
import Services.PlayerServices;
import Utilities.ParseClubs;
import Utilities.ParseJoueurs;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Doggaz Jihed
 */
public class FXMLShowPlayerAdminController implements Initializable {

    @FXML
    private TableColumn<?, ?> shirt;
    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableColumn<?, ?> position;
    @FXML
    private TableColumn<?, ?> age;
    @FXML
    private TableColumn<?, ?> club;
    @FXML
    private TableColumn<?, ?> team;
    @FXML
    private TableColumn<?, ?> height;
    @FXML
    private TableColumn<?, ?> weight;
    @FXML
    private TableColumn<?, ?> picture;
    @FXML
    private TableView<Player> table;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXButton bnt1;
    @FXML
    private ImageView pictureUpdate;
    @FXML
    private JFXComboBox<String> posUpdate;
    @FXML
    private JFXComboBox<String> clubUpdate;
    @FXML
    private JFXComboBox<String> teamUpdate;
    @FXML
    private JFXTextField shirtUpdate;
    @FXML
    private JFXTextField nameUpdate;
    @FXML
    private JFXTextField ageUpdate;
    @FXML
    private JFXTextField heightUpdate;
    @FXML
    private JFXTextField weightUpdate;
    @FXML
    private JFXButton update;
    
    int idTnew;
     String imgPath;
     
     
    ObservableList<String> comboList = FXCollections.observableArrayList("Name","Age","Team","Position","Club","Tshirt");
    ObservableList<String> comboPos = FXCollections.observableArrayList("Goalkeeper", "Defender","Midfielder","Forward");
    ObservableList<String> comboTeam = FXCollections.observableArrayList();
    @FXML
    private JFXTextField recherchePlayer_txt;
    @FXML
    private JFXComboBox<String> comboRech;
    @FXML
    private Button bntReparse;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
      ParseClubs pc = new ParseClubs();
      
      table.getSelectionModel().selectedItemProperty().
              addListener((observable, oldValue, newValue) -> {
                if (newValue != null){
                    showPlayerDetails(newValue);
                }
                });
       comboRech.setItems(comboList);
      clubUpdate.setItems(pc.clubs());
       posUpdate.setItems(comboPos);
       teamUpdate.setItems(comboTeam);
       
afficher();
          
recherchePlayer_txt.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filtrerPlayerList((String) oldValue, (String) newValue);
            }

        });
    }  
    
    
    public void afficher(){
        PlayerServices ps = new PlayerServices();
        shirt.setCellValueFactory(new PropertyValueFactory<>("PLAYER_TSHIRT"));
        name.setCellValueFactory(new PropertyValueFactory<>("PLAYER_NAME"));
        position.setCellValueFactory(new PropertyValueFactory<>("PLAYER_POSITION"));
        age.setCellValueFactory(new PropertyValueFactory<>("PLAYER_AGE"));
        club.setCellValueFactory(new PropertyValueFactory<>("PLAYER_CLUB"));
        team.setCellValueFactory(new PropertyValueFactory<>("PLAYER_TEAM"));
        height.setCellValueFactory(new PropertyValueFactory<>("PLAYER_HEIGHT"));
        weight.setCellValueFactory(new PropertyValueFactory<>("PLAYER_WEIGHT"));
        picture.setCellValueFactory(new PropertyValueFactory<>("PLAYER_PICTURE"));
        
        table.setItems(ps.showPlayers());
    }

    @FXML
    private void update(ActionEvent event) {
        if (!table.getSelectionModel().isEmpty()) {
            
System.out.println(idTnew);
System.out.println(nameUpdate.getText());
System.out.println(posUpdate.getValue());
System.out.println(shirtUpdate.getText());
System.out.println(ageUpdate.getText());
System.out.println(clubUpdate.getValue());
System.out.println(teamUpdate.getValue());
System.out.println(heightUpdate.getText());
System.out.println(weightUpdate.getText());
System.out.println(imgPath);
PlayerServices ps = new PlayerServices();
            Player p = new Player();
            p.setPLAYER_ID(idTnew);
           
            p.setPLAYER_NAME(nameUpdate.getText());
            p.setPLAYER_POSITION(posUpdate.getValue());
            p.setPLAYER_TSHIRT(Integer.parseInt(shirtUpdate.getText()));
            p.setPLAYER_AGE(Integer.parseInt(ageUpdate.getText()));
            p.setPLAYER_CLUB(clubUpdate.getValue());
            
            p.setPLAYER_TEAM(ps.selectTeamByName(teamUpdate.getValue()));
            p.setPLAYER_HEIGHT(heightUpdate.getText());
            p.setPLAYER_WEIGHT(weightUpdate.getText());
            p.setPLAYER_PICTURE(imgPath);
            
            ps.updatePlayer(p);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Modifier Article ");
            alert.setHeaderText("Modification du joueur :"
                    + table.getSelectionModel().getSelectedItem().getPLAYER_NAME()+ " est effectué avec succes");
            Optional<ButtonType> result = alert.showAndWait();
  

        } else {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Erreur de selection");
            alert1.setHeaderText("Vous etes obligé de selectioner un joueur");

            Optional<ButtonType> result = alert1.showAndWait();

        }
        afficher();
    }
    
            void showPlayerDetails(Player p) {
                
                PlayerServices ps = new PlayerServices();

        idTnew = p.getPLAYER_ID();
        imgPath = String.valueOf(p.getPLAYER_PICTURE());
        
        shirtUpdate.setText(String.valueOf(p.getPLAYER_TSHIRT()));
        nameUpdate.setText(p.getPLAYER_NAME());
        posUpdate.setValue(p.getPLAYER_POSITION());
        ageUpdate.setText(String.valueOf(p.getPLAYER_AGE()));
        clubUpdate.setValue(p.getPLAYER_CLUB());
        
        teamUpdate.setValue(ps.selectTeamById(p.getPLAYER_TEAM()));
        heightUpdate.setText(String.valueOf(p.getPLAYER_HEIGHT()));
        weightUpdate.setText(String.valueOf(p.getPLAYER_WEIGHT()));
        
        
        
        Image image1 = new Image(p.getPLAYER_PICTURE());
        pictureUpdate.setImage(image1);
       

    }

    @FXML
    private void browsePic(ActionEvent event) throws MalformedURLException {
        String imageFile;
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);

            Image image1 = new Image(imageFile);

            pictureUpdate.setImage(image1);
            imgPath = imageFile;
           
        } else {
            System.out.println("file doesn't exist");
        }
    }
    void filtrerPlayerList(String oldValue, String newValue) {
        String choix = (String) comboRech.getValue();
        PlayerServices ps = new PlayerServices();
        if(choix.equals("Name")){
        ObservableList<Player> filteredList = FXCollections.observableArrayList();
        if (recherchePlayer_txt.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(ps.showPlayers());
        } else {

            newValue = newValue.toUpperCase();

            for (Player player : table.getItems()) {

                String filterPlayer = player.getPLAYER_NAME();

                if (filterPlayer.toUpperCase().contains(newValue)) {
                    filteredList.add(player);

                }

            }
            table.setItems(filteredList);

        }
        
    }
        else if(choix.equals("Age"))
        {
            
            ObservableList<Player> filteredList = FXCollections.observableArrayList();
        if (recherchePlayer_txt.getText()== null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(ps.showPlayers());
        } else {

            newValue = newValue.toUpperCase();

            for (Player player : table.getItems()) {

                String filterPlayer = String.valueOf(player.getPLAYER_AGE());

                if (filterPlayer.toUpperCase().contains(newValue)) {
                    filteredList.add(player);
                }

            }
            table.setItems(filteredList);

        }
            
        } else if(choix.equals("Position"))
        {
            
            ObservableList<Player> filteredList = FXCollections.observableArrayList();
        if (recherchePlayer_txt.getText()== null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(ps.showPlayers());
        } else {

            newValue = newValue.toUpperCase();

            for (Player player : table.getItems()) {

                String filterPlayer = player.getPLAYER_POSITION();

                if (filterPlayer.toUpperCase().contains(newValue)) {
                    filteredList.add(player);
                }

            }
            table.setItems(filteredList);

        }
            
        }
         else if(choix.equals("Club"))
        {
            
            ObservableList<Player> filteredList = FXCollections.observableArrayList();
        if (recherchePlayer_txt.getText()== null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(ps.showPlayers());
        } else {

            newValue = newValue.toUpperCase();

            for (Player player : table.getItems()) {

                String filterPlayer = player.getPLAYER_CLUB();

                if (filterPlayer.toUpperCase().contains(newValue)) {
                    filteredList.add(player);
                }

            }
            table.setItems(filteredList);

        }
            
        }
        else if(choix.equals("Tshirt"))
        {
            
            ObservableList<Player> filteredList = FXCollections.observableArrayList();
        if (recherchePlayer_txt.getText()== null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(ps.showPlayers());
        } else {

            newValue = newValue.toUpperCase();

            for (Player player : table.getItems()) {

                String filterPlayer = String.valueOf(player.getPLAYER_TSHIRT());

                if (filterPlayer.toUpperCase().contains(newValue)) {
                    filteredList.add(player);
                }

            }
            table.setItems(filteredList);

        }
            
        }
        

    }

    @FXML
    private void reparse(ActionEvent event) {
        PlayerServices ps = new PlayerServices();
        ParseJoueurs pj = new ParseJoueurs();
        
        ps.EmptyPlayer();
        pj.allemagne();
        pj.espagne();
        pj.argentine();
        pj.brésil();
        pj.france();
        afficher();
    }
    
}
