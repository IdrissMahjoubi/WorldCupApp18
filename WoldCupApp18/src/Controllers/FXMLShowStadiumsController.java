package Controllers;

import Entities.Stadium;
import Services.CrudStadium;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bich
 */
public class FXMLShowStadiumsController implements Initializable {

    @FXML
    private TableView<Stadium> table;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableColumn<?, ?> location;
    @FXML
    private TableColumn<?, ?> capacity;
    @FXML
    private Button btndelete;
    @FXML
    private Button Update;
    @FXML
    private TableColumn<?, ?> xmap;
    @FXML
    private TableColumn<?, ?> ymap;
    @FXML
    private Button goback;
    @FXML
    private TextField Recherche;
    @FXML
    private ChoiceBox<String> choiseBox;
    ObservableList<String> comboList = FXCollections.observableArrayList("Stadium Name", "Stadium Location", "Stadium Capacity");
    @FXML
    private TextField StadiumName;
    @FXML
    private TextField StadiumLocation;
    @FXML
    private TextField StadiumCapacity;
    @FXML
    private TextField XMAP;
    @FXML
    private TextField YMAP;
    @FXML
    private ImageView PicViewer;
    @FXML
    private Button ChosePic;
    String ID_Stadium_new;
    String Stadium_path;
    @FXML
    private Button map;

    static String StadiumNM;
    static String GouvSM;
    @FXML
    private Button acceuil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choiseBox.setItems(comboList);
        afficherstadium();
        table.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        showStadiumsDetails(newValue);
                    }
                });
        Recherche.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                try {
                    filtrerStadiumList((String) oldValue, (String) newValue);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLShowStadiumsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

    void filtrerStadiumList(String oldValue, String newValue) throws SQLException {

        CrudStadium s = new CrudStadium();

        String choix = choiseBox.getValue();
        if (choix.equals("Stadium Name")) {
            ObservableList<Stadium> filteredList = FXCollections.observableArrayList();
            if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
                table.setItems(s.showStadium());

            } else {
                newValue = newValue.toUpperCase();
                for (Stadium st : table.getItems()) {

                    String filterStadiumName = st.getSTADIUM_NAME();

                    if (filterStadiumName.toUpperCase().contains(newValue)) {
                        filteredList.add(st);
                    }
                }

                table.setItems(filteredList);
            }
        } else if (choix.equals("Stadium Location")) {
            ObservableList<Stadium> filteredList = FXCollections.observableArrayList();
            if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
                table.setItems(s.showStadium());

            } else {
                newValue = newValue.toUpperCase();
                for (Stadium st : table.getItems()) {

                    String filterStadiumLocation = st.getSTADIUM_LOCATION();

                    if (filterStadiumLocation.toUpperCase().contains(newValue)) {
                        filteredList.add(st);
                    }
                }

                table.setItems(filteredList);
            }
        } else if (choix.equals("Stadium Capacity")) {
            ObservableList<Stadium> filteredList = FXCollections.observableArrayList();
            if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
                table.setItems(s.showStadium());

            } else {
                newValue = newValue.toUpperCase();
                for (Stadium st : table.getItems()) {

                    String filterStadiumCapacity = Integer.toString(st.getSTADIUM_CAPACITY());

                    if (filterStadiumCapacity.toUpperCase().contains(newValue)) {
                        filteredList.add(st);
                    }
                }

                table.setItems(filteredList);
            }
        }

    }

    public void afficherstadium() {
        try {
            CrudStadium s = new CrudStadium();
            id.setCellValueFactory(new PropertyValueFactory<>("STADIUM_ID"));
            name.setCellValueFactory(new PropertyValueFactory<>("STADIUM_NAME"));
            location.setCellValueFactory(new PropertyValueFactory<>("STADIUM_LOCATION"));
            capacity.setCellValueFactory(new PropertyValueFactory<>("STADIUM_CAPACITY"));
            xmap.setCellValueFactory(new PropertyValueFactory<>("STADIUM_LOCATION_X"));
            ymap.setCellValueFactory(new PropertyValueFactory<>("STADIUM_LOCATION_Y"));
            table.setItems(null);
            table.setItems(s.showStadium());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLShowStadiumsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void delete(ActionEvent event) throws SQLException {
        if (!table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Stadium");
            alert.setHeaderText("Are you sure you want to delete this stadium : " + table.getSelectionModel().getSelectedItem().getSTADIUM_ID() + " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                CrudStadium st = new CrudStadium();
                st.DeleteStadium(table.getSelectionModel().getSelectedItem().getSTADIUM_ID());
                afficherstadium();
                EmptyFields(event);

            }
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText("Would you select a stadium ! !");
            Optional<ButtonType> result = alert.showAndWait();
        }
        EmptyFields(event);
    }

    @FXML
    private void UpdateStadium(ActionEvent event) {

        if (!table.getSelectionModel().isEmpty()) {
            CrudStadium cs = new CrudStadium();
            Stadium st = new Stadium();

            st.setSTADIUM_ID(Integer.valueOf(ID_Stadium_new));
            st.setSTADIUM_NAME(StadiumName.getText());
            st.setSTADIUM_LOCATION(StadiumLocation.getText());
            st.setSTADIUM_CAPACITY(Integer.parseInt(StadiumCapacity.getText()));
            st.setSTADIUM_PICTURE(Stadium_path);
            st.setSTADIUM_LOCATION_X(XMAP.getText());
            st.setSTADIUM_LOCATION_Y(YMAP.getText());
            cs.updateStadium(st);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update Stadium ");
            alert.setHeaderText("Updating d stadium :"
                    + table.getSelectionModel().getSelectedItem().getSTADIUM_NAME() + " done");
            Optional<ButtonType> result = alert.showAndWait();

        } else {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Erreur de selection");
            alert1.setHeaderText("Would you select a stadium !  ");
            Optional<ButtonType> result = alert1.showAndWait();
        }
        afficherstadium();
        EmptyFields(event);
    }

    @FXML
    private void goBack(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLStadium.fxml"));
        try {
            Parent root = loader.load();
            FXMLStadiumController dc = loader.getController();
            goback.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLShowStadiumsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ChosePicture(ActionEvent event) throws MalformedURLException {

        String imageFile;
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {

            imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);

            Image image1 = new Image(imageFile);

            PicViewer.setImage(image1);
            Stadium_path = imageFile;

        } else {
            System.out.println("file doesn't exist");
        }
    }

    void showStadiumsDetails(Stadium st) {
        ID_Stadium_new = String.valueOf(st.getSTADIUM_ID());
        StadiumName.setText(st.getSTADIUM_NAME());
        Stadium_path = String.valueOf(st.getSTADIUM_PICTURE());
        StadiumLocation.setText(st.getSTADIUM_LOCATION());
        Image image1 = new Image(st.getSTADIUM_PICTURE());
        PicViewer.setImage(image1);
        StadiumCapacity.setText(Integer.toString(st.getSTADIUM_CAPACITY()));
        XMAP.setText(st.getSTADIUM_LOCATION_X());
        YMAP.setText(st.getSTADIUM_LOCATION_Y());

    }

    private void EmptyFields(ActionEvent event) {
        StadiumName.clear();
        StadiumLocation.clear();
        StadiumCapacity.clear();

        XMAP.clear();
        YMAP.clear();
        PicViewer.setImage(null);
    }

    @FXML
    private void GotoMap(ActionEvent event) {

         StadiumNM = table.getSelectionModel().getSelectedItem().getSTADIUM_NAME();
         GouvSM = table.getSelectionModel().getSelectedItem().getSTADIUM_LOCATION();
        
        try {
            Parent page1 = FXMLLoader.load(getClass().getResource("/Views/FXMLMAP.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void acceuil(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLShowStadiums.fxml"));
        try {
            Parent root = loader.load();
            FXMLMenuController dc = loader.getController();
            acceuil.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
