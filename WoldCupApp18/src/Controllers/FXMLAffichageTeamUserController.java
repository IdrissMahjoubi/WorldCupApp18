/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Team;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import Services.ServiceTeam;

/**
 * FXML Controller class
 *
 * @author pacha
 */
public class FXMLAffichageTeamUserController implements Initializable {

    @FXML
    private TableView<Team> table;
    @FXML
    private ImageView flagview;
    @FXML
    private ImageView logoview;
    @FXML
    private TableColumn<?, ?> team;
    @FXML
    private TableColumn<?, ?> coach;
    @FXML
    private TableColumn<?, ?> group;
    @FXML
    private TableColumn<?, ?> continent;
    
    MediaPlayer mediaPlayer2;
    @FXML
    private Button PLAY;
    @FXML
    private Button STOP;
    @FXML
    private ChoiceBox<String> choice;
    @FXML
    private TextField rechercheteam_txt;
    
    ObservableList<String> comboList = FXCollections.observableArrayList("Equipe", "Continent", "Groupe");
    ObservableList<String> listC = FXCollections.observableArrayList("Asie & Océanie", "Afrique", "Amerique de sud", "Europe", "Amerique de nord");

    ObservableList<String> listG = FXCollections.observableArrayList("A", "B","C", "D", "E", "F", "G", "H");
    String flag_path;
    String logo_path;
    @FXML
    private ComboBox<String> continents;
    @FXML
    private ComboBox<String> groupes;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rechercheteam_txt.setVisible(true);
        groupes.setVisible(false);
        continents.setVisible(false);
        groupes.setItems(listG);
        groupes.getSelectionModel().selectFirst();
        continents.setItems(listC);
        continents.getSelectionModel().selectFirst();
        
        afficher();
        choice.setItems(comboList);
        
        table.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        showTeamDetails(newValue);
                        switch(newValue.getTEAM_NAME()) { 
                            case "Tunisie": 
                            Media musicFile=new Media("file:/C:/Users/pacha/Music/Tunisia%20National%20Anthem%20-%20HYMNE%20NATIONAL%20DE%20LA%20TUNISIE.mp3");
                            mediaPlayer2=new MediaPlayer(musicFile);
                            break; 
                            case "Bresil": 
                            Media musicFile2=new Media("file:/C:/Users/pacha/Music/Hymne%20National%20du%20Brésil.mp3");
                            mediaPlayer2=new MediaPlayer(musicFile2);
                            break; 
                            case "Allemagne": 
                            Media musicFile3=new Media("file:/C:/Users/pacha/Music/Hymne%20national%20de%20lAllemagne.mp3");
                            mediaPlayer2=new MediaPlayer(musicFile3);
                            break;
                            case "Espagne": 
                            Media musicFile4=new Media("file:/C:/Users/pacha/Music/Himno%20español.mp3");
                            mediaPlayer2=new MediaPlayer(musicFile4);
                            break; 
                            case "Panama": 
                            Media musicFile5=new Media("file:/C:/Users/pacha/Music/Panama.mp3");
                            mediaPlayer2=new MediaPlayer(musicFile5);
                            break;
                            case "Russie": 
                            Media musicFile6=new Media("file:/C:/Users/pacha/Music/Russie.mp3");
                            mediaPlayer2=new MediaPlayer(musicFile6);
                            break;
                            case "Egypt": 
                            Media musicFile7=new Media("file:/C:/Users/pacha/Music/Égypte.mp3");
                            mediaPlayer2=new MediaPlayer(musicFile7);
                            break; 
                            
                    }
                    }

                });
        choice.getSelectionModel().selectFirst();
        choice.setTooltip(new Tooltip("Selectionner critère"));
        choice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                rechercheteam_txt.setText("");
                switch (choice.getSelectionModel().getSelectedIndex()) {
                    case 0:
                        rechercheteam_txt.setVisible(true);
                        continents.setVisible(false);
                        groupes.setVisible(false);
                        break;
                    case 1:
                        continents.setVisible(true);
                        groupes.setVisible(false);
                        rechercheteam_txt.setVisible(false);
                        break;
                    case 2:
                        groupes.setVisible(true);
                        rechercheteam_txt.setVisible(false);
                        continents.setVisible(false);
                        break;
                    default:
                        break;
                }
            }
        });
        rechercheteam_txt.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filtrerTeamList((String) oldValue, (String) newValue);
            }

        });
        
    }
    
    
    
    public void afficher() {
        ServiceTeam s = new ServiceTeam();
        team.setCellValueFactory(new PropertyValueFactory<>("TEAM_NAME"));
        coach.setCellValueFactory(new PropertyValueFactory<>("TEAM_COACH"));
        continent.setCellValueFactory(new PropertyValueFactory<>("TEAM_CONTINENT"));
        group.setCellValueFactory(new PropertyValueFactory<>("TEAM_GROUP"));
        table.setItems(s.showTeams());
    }
    void showTeamDetails(Team t) {
       

        flag_path = String.valueOf(t.getTEAM_FLAG());
        logo_path = String.valueOf(t.getTEAM_LOGO());
        Image image1 = new Image(t.getTEAM_FLAG());
        flagview.setImage(image1);
        Image image2 = new Image(t.getTEAM_LOGO());
        logoview.setImage(image2);


    }
    void filtrerTeamList(String oldValue, String newValue) {
        String choix = choice.getValue();
        ServiceTeam st = new ServiceTeam();
        if (choix.equals("Equipe")) {
            ObservableList<Team> filteredList = FXCollections.observableArrayList();
            if (rechercheteam_txt.getText() == null || newValue == null) {
                table.setItems(st.showTeams());
            } else {
                table.setItems(st.showTeams());
                newValue = newValue.toUpperCase();

                for (Team team : table.getItems()) {

                    String filterTeamName = team.getTEAM_NAME();

                    if (filterTeamName.toUpperCase().contains(newValue)) {
                        filteredList.add(team);

                    }

                }
                table.setItems(filteredList);

            }

        } else if (choix.equals("Continent")) {

            ObservableList<Team> filteredList = FXCollections.observableArrayList();
            if (rechercheteam_txt.getText()== null || newValue == null) {
                table.setItems(st.showTeams());
            } else {
                table.setItems(st.showTeams());
                newValue = newValue.toUpperCase();

                for (Team team2 : table.getItems()) {

                    String filterTeamName = team2.getTEAM_CONTINENT();

                    if (filterTeamName.toUpperCase().contains(newValue)) {
                        filteredList.add(team2);

                    }

                }
                table.setItems(filteredList);

            }

        } else {
            
            ObservableList<Team> filteredList = FXCollections.observableArrayList();
            if (rechercheteam_txt.getText()== null || newValue == null) {
                table.setItems(st.showTeams());
            } else {
                table.setItems(st.showTeams());
              

                newValue = newValue.toUpperCase();

                for (Team team3 : table.getItems()) {
                   
                    String filterTeamName = team3.getTEAM_GROUP();

                    if (filterTeamName.toUpperCase().contains(newValue)) {
                        filteredList.add(team3);

                    }

                }
                table.setItems(filteredList);

            }
        }
    }

    @FXML
    private void play(ActionEvent event) {
        mediaPlayer2.play();
    }

    @FXML
    private void stop(ActionEvent event) {
        mediaPlayer2.stop();
    }

    @FXML
    private void rechercheContinent(ActionEvent event) {
        rechercheteam_txt.setText(continents.getValue());
    }

    @FXML
    private void rechercheGroupes(ActionEvent event) {
        rechercheteam_txt.setText(groupes.getValue());
    }


    
    
}
