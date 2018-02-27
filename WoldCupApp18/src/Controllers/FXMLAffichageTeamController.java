/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Team;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import Services.ServiceTeam;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author pacha
 */
public class FXMLAffichageTeamController implements Initializable {

    String logo_path, flag_path;
    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableColumn<?, ?> coach;
    @FXML
    private TableColumn<?, ?> continent;
    private TableColumn<?, ?> flag;
    private TableColumn<?, ?> logo;
    @FXML
    private TableView<Team> table;
    @FXML
    private TextField team_txt;
    @FXML
    private TextField coach_txt;
    @FXML
    private ImageView flagimage;
    @FXML
    private ImageView team_logo;
    @FXML
    private TextField rechercheteam_txt;
    @FXML
    private TableColumn<?, ?> groupe;
    @FXML
    private ChoiceBox<String> comboRech;
    ObservableList<String> comboList = FXCollections.observableArrayList("Equipe", "Continent", "Groupe");
    ObservableList<String> comboListCont = FXCollections.observableArrayList("Asie & Océanie", "Afrique", "Amerique de sud", "Europe", "Amerique de nord");

    ObservableList<String> comboListGRP = FXCollections.observableArrayList("A", "B", "C", "D", "E", "F", "G", "H");
    @FXML
    private MediaView view;
    @FXML
    private Button play;
    @FXML
    private Button stop;
    Media media;
    MediaPlayer mediaPlayer;
    static MediaPlayer mediaPlayer2;

    @FXML
    private ComboBox<String> ComboContinent;
    @FXML
    private ComboBox<String> ComboGrp;
    @FXML
    private ComboBox<String> ComboRechCont;
    @FXML
    private ComboBox<String> ComboRechGrp;
    @FXML
    private Button play2;

    public static String urlm = "";
    @FXML
    private Button stop2;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private Button BrowseFlag;
    @FXML
    private Button BrowseLogo;
    @FXML
    private Button ajouter;

    static String imageFile;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        rechercheteam_txt.setVisible(true);
        ComboRechCont.setVisible(false);
        ComboRechGrp.setVisible(false);
        ComboRechGrp.setItems(comboListGRP);
        ComboRechGrp.getSelectionModel().selectFirst();
        ComboRechCont.setItems(comboListCont);
        ComboRechCont.getSelectionModel().selectFirst();
        afficher();
        comboRech.setItems(comboList);
        table.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        showTeamDetails(newValue);
                         switch(newValue.getTEAM_NAME()) { 
                            case "Tunisia": 
                            
                                    Media musicFile1;
                        try {
                            File file = new File("src/Resources/jayin.mp3");
                            musicFile1 = new Media(file.toURI().toURL().toString());
                            mediaPlayer2=new MediaPlayer(musicFile1);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(FXMLAffichageTeamController.class.getName()).log(Level.SEVERE, null, ex);
                        }         
                            break; 
                            case "Bresil": 
                                                       
                                    Media musicFile2;
                        try {
                            File file = new File("src/Resources/Brésil.mp3");
                            musicFile2 = new Media(file.toURI().toURL().toString());
                            mediaPlayer2=new MediaPlayer(musicFile2);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(FXMLAffichageTeamController.class.getName()).log(Level.SEVERE, null, ex);
                        }         
                            break;
                                                       
                            case "Espagne": 
                                                        
                                    Media musicFile3;
                        try {
                            File file = new File("src/Resources/Espagne.mp3");
                            musicFile3 = new Media(file.toURI().toURL().toString());
                            mediaPlayer2=new MediaPlayer(musicFile3);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(FXMLAffichageTeamController.class.getName()).log(Level.SEVERE, null, ex);
                        }         
                            break; 
                            case "Panama": 
                                                        
                                    Media musicFile4;
                        try {
                            File file = new File("src/Resources/Panama.mp3");
                            musicFile4 = new Media(file.toURI().toURL().toString());
                            mediaPlayer2=new MediaPlayer(musicFile4);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(FXMLAffichageTeamController.class.getName()).log(Level.SEVERE, null, ex);
                        }         
                            break;
                            case "Russia": 
                                                        
                                    Media musicFile5;
                        try {
                            File file = new File("src/Resources/Russie.mp3");
                            musicFile5 = new Media(file.toURI().toURL().toString());
                            mediaPlayer2=new MediaPlayer(musicFile5);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(FXMLAffichageTeamController.class.getName()).log(Level.SEVERE, null, ex);
                        }         
                            break;
                            case "Egypt": 
                                                        
                                    Media musicFile6;
                        try {
                            File file = new File("src/Resources/Egypte.mp3");
                            musicFile6 = new Media(file.toURI().toURL().toString());
                            mediaPlayer2=new MediaPlayer(musicFile6);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(FXMLAffichageTeamController.class.getName()).log(Level.SEVERE, null, ex);
                        }         
                            break;
                            default: System.out.println("choose");
                            
                    }
                    }

                });
        comboRech.getSelectionModel().selectFirst();
        comboRech.setTooltip(new Tooltip("Selectionner critère"));
        comboRech.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                rechercheteam_txt.setText("");
                switch (comboRech.getSelectionModel().getSelectedIndex()) {
                    case 0:
                        rechercheteam_txt.setVisible(true);
                        ComboRechCont.setVisible(false);
                        ComboRechGrp.setVisible(false);
                        break;
                    case 1:
                        ComboRechCont.setVisible(true);
                        ComboRechGrp.setVisible(false);
                        rechercheteam_txt.setVisible(false);
                        break;
                    case 2:
                        ComboRechGrp.setVisible(true);
                        rechercheteam_txt.setVisible(false);
                        ComboRechCont.setVisible(false);
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

    public TableColumn<?, ?> getName() {
        return name;
    }

    public void setName(TableColumn<?, ?> name) {
        this.name = name;
    }

    public TableColumn<?, ?> getCoach() {
        return coach;
    }

    public void setCoach(TableColumn<?, ?> coach) {
        this.coach = coach;
    }

    public TableColumn<?, ?> getContinent() {
        return continent;
    }

    public void setContinent(TableColumn<?, ?> continent) {
        this.continent = continent;
    }

    public TableColumn<?, ?> getFlag() {
        return flag;
    }

    public void setFlag(TableColumn<?, ?> flag) {
        this.flag = flag;
    }

    public TableColumn<?, ?> getLogo() {
        return logo;
    }

    public void setLogo(TableColumn<?, ?> logo) {
        this.logo = logo;
    }

    public TableView<Team> getTable() {
        return table;
    }

    public void setTable(TableView<Team> table) {
        this.table = table;
    }

    String idTnew;

    public void afficher() {
        ServiceTeam s = new ServiceTeam();
        name.setCellValueFactory(new PropertyValueFactory<>("TEAM_NAME"));
        coach.setCellValueFactory(new PropertyValueFactory<>("TEAM_COACH"));
        continent.setCellValueFactory(new PropertyValueFactory<>("TEAM_CONTINENT"));
        groupe.setCellValueFactory(new PropertyValueFactory<>("TEAM_GROUP"));
        table.setItems(s.showTeams());
    }

    @FXML
    private void modifierTeam(ActionEvent event) {
        if (!table.getSelectionModel().isEmpty()) {
            ServiceTeam st = new ServiceTeam();

            Team t = new Team();
            t.setTEAM_ID(Integer.valueOf(idTnew));
            t.setTEAM_NAME(team_txt.getText());
            t.setTEAM_COACH(coach_txt.getText());
            t.setTEAM_GROUP(ComboGrp.getValue());
            t.setTEAM_CONTINENT(ComboContinent.getValue());
            t.setTEAM_FLAG(imageFile2);
            t.setTEAM_LOGO(imageFile);
            st.update(t);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Modifier team ");
            alert.setHeaderText("Modification d'equipe :"
                    + table.getSelectionModel().getSelectedItem().getTEAM_NAME() + " est effectué avec succes");
            Optional<ButtonType> result = alert.showAndWait();

        } else {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Erreur de selection");
            alert1.setHeaderText("Vous etes obligé de selectioner une equipe  ");

            Optional<ButtonType> result = alert1.showAndWait();

        }
        afficher();
    }

    @FXML
    private void BrowseLogo(ActionEvent event) throws MalformedURLException, IOException {

        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {

            Image image = new Image(selectedFile.toURI().toString());
            team_logo.setImage(image);
            imageFile = selectedFile.getName();
            int pos = imageFile.lastIndexOf("/");
            if (pos > 0) {
                imageFile = imageFile.substring(0, pos);
            }
            team_logo.setImage(image);
            String emplacement = "C:\\wamp64\\www\\ImagesPacha\\" + imageFile;
            System.out.println(emplacement);
            CopyImage(emplacement, selectedFile.toPath().toString());

        } else {
            System.out.println("file doesn't exist");
        }
    }
    static String imageFile2;

    @FXML
    private void BrowseFlag(ActionEvent event) throws MalformedURLException, IOException {

        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {

            Image image = new Image(selectedFile.toURI().toString());
            flagimage.setImage(image);
            imageFile2 = selectedFile.getName();
            int pos = imageFile2.lastIndexOf("/");
            if (pos > 0) {
                imageFile2 = imageFile2.substring(0, pos);
            }
            flagimage.setImage(image);
            String emplacement = "C:\\wamp64\\www\\ImagesPacha\\" + imageFile2;
            System.out.println(emplacement);
            CopyImage(emplacement, selectedFile.toPath().toString());

        } else {
            System.out.println("file doesn't exist");
        }
    }

    void showTeamDetails(Team t) {
        ComboContinent.getItems().clear();
        ComboGrp.getItems().clear();

        idTnew = String.valueOf(t.getTEAM_ID());

        flag_path = String.valueOf(t.getTEAM_FLAG());
        logo_path = String.valueOf(t.getTEAM_LOGO());
        team_txt.setText(t.getTEAM_NAME());
        ComboGrp.getItems().add(t.getTEAM_GROUP());
        ComboGrp.getSelectionModel().selectFirst();
        ComboContinent.getItems().add(t.getTEAM_CONTINENT());
        ComboContinent.getSelectionModel().selectFirst();
        coach_txt.setText(t.getTEAM_COACH());
        File file = new File("src/Resources/Icons/Flags/" + t.getTEAM_FLAG());
        Image image1 = new Image(file.toURI().toString());
        flagimage.setImage(image1);
        File file2 = new File("src/Resources/Icons/Logos/" + t.getTEAM_LOGO());
        Image image2 = new Image(file2.toURI().toString());
        team_logo.setImage(image2);

        for (int i = 0; i < comboListCont.size(); i++) {
            if (!t.getTEAM_CONTINENT().equals(comboListCont.get(i))) {
                ComboContinent.getItems().add(comboListCont.get(i));
            }
            ComboContinent.getSelectionModel().selectFirst();

        }

        for (int i = 0; i < comboListGRP.size(); i++) {
            if (!t.getTEAM_GROUP().equals(comboListGRP.get(i))) {
                ComboGrp.getItems().add(comboListGRP.get(i));
            }
            ComboGrp.getSelectionModel().selectFirst();

        }

    }

    void filtrerTeamList(String oldValue, String newValue) {
        String choix = comboRech.getValue();
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
            if (rechercheteam_txt.getText() == null || newValue == null) {
                table.setItems(st.showTeams());
            } else {
                table.setItems(st.showTeams());
                newValue = newValue.toUpperCase();

                for (Team team : table.getItems()) {

                    String filterTeamName = team.getTEAM_CONTINENT();

                    if (filterTeamName.toUpperCase().contains(newValue)) {
                        filteredList.add(team);

                    }

                }
                table.setItems(filteredList);

            }

        } else {

            ObservableList<Team> filteredList = FXCollections.observableArrayList();
            if (rechercheteam_txt.getText() == null || newValue == null) {
                table.setItems(st.showTeams());
            } else {
                table.setItems(st.showTeams());

                newValue = newValue.toUpperCase();

                for (Team team : table.getItems()) {

                    String filterTeamName = team.getTEAM_GROUP();

                    if (filterTeamName.toUpperCase().contains(newValue)) {
                        filteredList.add(team);

                    }

                }
                table.setItems(filteredList);

            }
        }
    }


    @FXML
    private void FonctionRechercheGrp(ActionEvent event) {
        rechercheteam_txt.setText(ComboRechGrp.getValue());
    }

    @FXML
    private void FonctionComboRechCont(ActionEvent event) {
        rechercheteam_txt.setText(ComboRechCont.getValue());
    }

    @FXML
    private void ajouterEquipe(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/FXMLAddTeam.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void playHymne(ActionEvent event) {
        mediaPlayer2.play();
    }

    @FXML
    private void stopp(ActionEvent event) {
        mediaPlayer2.stop();
    }

    @FXML
    private void supprimerTeamadmin(ActionEvent event) {
        if (!table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Supprimer Equipe");
            alert.setHeaderText("Vouler vous vraiment supprimer  : " + table.getSelectionModel().getSelectedItem().getTEAM_NAME() + " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                ServiceTeam st = new ServiceTeam();
                st.removeEquipe(table.getSelectionModel().getSelectedItem().getTEAM_ID());
                afficher();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText("Veuillez selectionner un team !");
            Optional<ButtonType> result = alert.showAndWait();
        }
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
