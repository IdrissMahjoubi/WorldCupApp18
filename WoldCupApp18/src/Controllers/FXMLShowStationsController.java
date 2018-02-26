package Controllers;

import Entities.Station;
import Services.CrudStation;
import java.io.IOException;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bich
 */
public class FXMLShowStationsController implements Initializable {

    @FXML
    private TableView<Station> table;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableColumn<?, ?> location;
    @FXML
    private TableColumn<?, ?> type;
    @FXML
    private TableColumn<?, ?> x;
    @FXML
    private TableColumn<?, ?> y;
    @FXML
    private Button btndelete;
    @FXML
    private Button Update;
    @FXML
    private Button goback;
    @FXML
    private TextField Recherche;
    @FXML
    private ChoiceBox<String> choiseBox;
    ObservableList<String> comboList = FXCollections.observableArrayList("Station Name", "Station Location","Station type");
    @FXML
    private TextField StationName;
    @FXML
    private TextField StationLocation;
    @FXML
    private TextField StationType;
    @FXML
    private TextField XMAP;
    @FXML
    private TextField YMAP;

    String ID_Station_new;
    @FXML
    private Button Map;
    @FXML
    private Button acceuil;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        afficherstation();

               choiseBox.setItems(comboList);
               table.getSelectionModel().selectedItemProperty().
               addListener((observable, oldValue, newValue) -> {

                    showStationsDetails(newValue);

                });
            Recherche.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                    filtrerStationList((String) oldValue, (String) newValue);
            }

        });
    }    

    
    
    void filtrerStationList(String oldValue, String newValue) {
        
     CrudStation s = new CrudStation();

      String choix = choiseBox.getValue();
      if (choix.equals("Station Name"))
      {
        ObservableList<Station> filteredList = FXCollections.observableArrayList();
        if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) 
        {
            table.setItems(s.showStation());
        }
        else
        { 
            newValue = newValue.toUpperCase();
            for (Station st : table.getItems()) 
            {
               String filterStadiumName = st.getSTATION_NAME();
                if (filterStadiumName.toUpperCase().contains(newValue))
                {
                    filteredList.add(st);
                }
            }
            table.setItems(filteredList);
        }
      }
    
      
      else if (choix.equals("Station Location")){
        ObservableList<Station> filteredList = FXCollections.observableArrayList();
        if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) 
        {
            table.setItems(s.showStation());
        }
        else
        { 
            newValue = newValue.toUpperCase();
            for (Station st : table.getItems())
            {
               String filterStadiumName = st.getSTATION_LOCATION();
                if (filterStadiumName.toUpperCase().contains(newValue))
                {
                    filteredList.add(st);
                }
            }
            table.setItems(filteredList);
           }  
        }
      
      
        else if (choix.equals("Station type"))
        {
        ObservableList<Station> filteredList = FXCollections.observableArrayList();
        if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) 
        {
            table.setItems(s.showStation());
        }
        else
        { 
            newValue = newValue.toUpperCase();
            for (Station st : table.getItems()) 
            {
                String filterStadiumName = (st.getSTATION_TYPE());
                if (filterStadiumName.toUpperCase().contains(newValue))
                {
                    filteredList.add(st);
                }
            }
            table.setItems(filteredList);
        }
      }
      
    }
    
    
    public void afficherstation(){
           
        CrudStation s = new CrudStation();
        id.setCellValueFactory(new PropertyValueFactory<>("STATION_ID"));
        name.setCellValueFactory(new PropertyValueFactory<>("STATION_NAME"));
        location.setCellValueFactory(new PropertyValueFactory<>("STATION_LOCATION"));
        type.setCellValueFactory(new PropertyValueFactory<>("STATION_TYPE"));
        x.setCellValueFactory(new PropertyValueFactory<>("STATION_LOCATION_X"));
        y.setCellValueFactory(new PropertyValueFactory<>("STATION_LOCATION_Y"));
        table.setItems(null);
        table.setItems(s.showStation());
           
    }
    
    @FXML
    private void deleteStation(ActionEvent event) throws SQLException {
        
if (!table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Supprimer Station");
            alert.setHeaderText("Etes vous sur de vouloir supprimer : " + table.getSelectionModel().getSelectedItem().getSTATION_ID()+ " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
            CrudStation st=new CrudStation();
            st.DeleteStation(table.getSelectionModel().getSelectedItem().getSTATION_ID());
            afficherstation();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText("Veuillez selectionner une station !");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @FXML
    private void UpdateStation(ActionEvent event) {
        
            if (!table.getSelectionModel().isEmpty()) {
            CrudStation cs = new CrudStation();

            Station st = new Station();
            st.setSTATION_ID(Integer.valueOf(ID_Station_new));
            st.setSTATION_NAME(StationName.getText());
            st.setSTATION_LOCATION(StationLocation.getText());
            st.setSTATION_TYPE(StationType.getText());
            st.setSTATION_LOCATION_X(XMAP.getText());
            st.setSTATION_LOCATION_Y(YMAP.getText());

            cs.updateStation(st);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Modifier Station ");
            alert.setHeaderText("Modification de station :"
            + table.getSelectionModel().getSelectedItem().getSTATION_NAME() + " est effectué avec succes");
            Optional<ButtonType> result = alert.showAndWait();

        } else {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Erreur de selection");
            alert1.setHeaderText("Vous etes obligé de selectioner un stade  ");

            Optional<ButtonType> result = alert1.showAndWait();

        }
        afficherstation();
 
    }

    @FXML
    private void goback(ActionEvent event) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLStation.fxml"));
        try{
            Parent root = loader.load();
            FXMLStationController dc = loader.getController();
            goback.getScene().setRoot(root);
        }catch (IOException ex) {
            Logger.getLogger(FXMLShowStationsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
         
    void showStationsDetails(Station st) {
        ID_Station_new = String.valueOf(st.getSTATION_ID());
        StationName.setText(st.getSTATION_NAME());
        StationLocation.setText(st.getSTATION_LOCATION());
        StationType.setText(st.getSTATION_TYPE());
        XMAP.setText(st.getSTATION_LOCATION_X());
        YMAP.setText(st.getSTATION_LOCATION_Y());
    }

    @FXML
    private void AfficherMap(ActionEvent event) {
                            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/Views/FXMLMAPStation.fxml"));
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
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLMenu.fxml"));
        try{
            Parent root = loader.load();
            FXMLMenuController dc = loader.getController();
            acceuil.getScene().setRoot(root);
        }catch (IOException ex) {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        
    }
}
    
    
}
