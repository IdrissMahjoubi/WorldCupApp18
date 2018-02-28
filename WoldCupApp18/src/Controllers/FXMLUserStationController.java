/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Station;
import Services.CrudStation;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
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
public class FXMLUserStationController implements Initializable {

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
    @FXML
    private Button Map;
    private Button acceuil;
    String ID_Station_new;
    @FXML
    private Button home;
    /**
     * Initializes the controller class.
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

    /*private void acceuil(ActionEvent event) {
       
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMenu.fxml"));
        try{
            Parent root = loader.load();
            FXMLMenuController dc = loader.getController();
            acceuil.getScene().setRoot(root);
        }catch (IOException ex) {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        
    } 
    }*/
    
    
    
        void showStationsDetails(Station st) {
        ID_Station_new = String.valueOf(st.getSTATION_ID());
        StationName.setText(st.getSTATION_NAME());
        StationLocation.setText(st.getSTATION_LOCATION());
        StationType.setText(st.getSTATION_TYPE());
        XMAP.setText(st.getSTATION_LOCATION_X());
        YMAP.setText(st.getSTATION_LOCATION_Y());
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
   private void SwitchToHome(ActionEvent event) {
                    try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/Views/FXMLMenu.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLUserStationController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
