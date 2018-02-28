/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Stadium;
import Services.CrudStadium;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bich
 */
public class FXMLUserStadiumController implements Initializable {

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
    private TableColumn<?, ?> xmap;
    @FXML
    private TableColumn<?, ?> ymap;
    @FXML
    private TextField Recherche;
    @FXML
    private ChoiceBox<String> choiseBox;
    ObservableList<String> comboList = FXCollections.observableArrayList("Stadium Name", "Stadium Location","Stadium Capacity");

    @FXML
    private Button map;
    private Button acceuil;
    String ID_Stadium_new;
    String Stadium_path;
    @FXML
    private ImageView PicViewer;
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
    private Button home;
    static String StadiumNM;
    static String GouvSM;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               choiseBox.setItems(comboList);
       afficherstadium();
       table.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {

                    showStadiumsDetails(newValue);

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
        void showStadiumsDetails(Stadium st) {
        ID_Stadium_new = String.valueOf(st.getSTADIUM_ID());
        StadiumName.setText(st.getSTADIUM_NAME());
        Stadium_path= String.valueOf(st.getSTADIUM_PICTURE());
        StadiumLocation.setText(st.getSTADIUM_LOCATION());
        Image image1 = new Image(st.getSTADIUM_PICTURE());
        PicViewer.setImage(image1);
        StadiumCapacity.setText(Integer.toString(st.getSTADIUM_CAPACITY()));
        XMAP.setText(st.getSTADIUM_LOCATION_X());
        YMAP.setText(st.getSTADIUM_LOCATION_Y());
        
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

    private void acceuil(ActionEvent event) {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLMenu.fxml"));
        try{
            Parent root = loader.load();
            FXMLUserStadiumController dc = loader.getController();
            acceuil.getScene().setRoot(root);
        }catch (IOException ex) {
            Logger.getLogger(FXMLUserStadiumController.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    }
    
        
    void filtrerStadiumList(String oldValue, String newValue) throws SQLException {
        
      CrudStadium s = new CrudStadium();

      String choix = choiseBox.getValue();
      if (choix.equals("Stadium Name")){
        ObservableList<Stadium> filteredList = FXCollections.observableArrayList();
        if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(s.showStadium());

        }else{ 
            newValue = newValue.toUpperCase();
            for (Stadium st : table.getItems()) {
               
               String filterStadiumName = st.getSTADIUM_NAME();

             
                if (filterStadiumName.toUpperCase().contains(newValue)){
                    filteredList.add(st);
                }
            }
      
            table.setItems(filteredList);
    }
      }
    
      
      else if (choix.equals("Stadium Location")){
        ObservableList<Stadium> filteredList = FXCollections.observableArrayList();
        if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(s.showStadium());

        }else{ 
            newValue = newValue.toUpperCase();
            for (Stadium st : table.getItems()) {
               
               String filterStadiumLocation = st.getSTADIUM_LOCATION();

             
                if (filterStadiumLocation.toUpperCase().contains(newValue)){
                    filteredList.add(st);
                }
            }
      
            table.setItems(filteredList);
    }
      }
            else if (choix.equals("Stadium Capacity")){
        ObservableList<Stadium> filteredList = FXCollections.observableArrayList();
        if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(s.showStadium());

        }else{ 
            newValue = newValue.toUpperCase();
            for (Stadium st : table.getItems()) {
               
                String filterStadiumCapacity = Integer.toString(st.getSTADIUM_CAPACITY());

             
                if (filterStadiumCapacity.toUpperCase().contains(newValue)){
                    filteredList.add(st);
                }
            }
      
            table.setItems(filteredList);
    }
      }
      
      
    }
    
    
    public void afficherstadium(){
        try {
        CrudStadium s = new CrudStadium();
        id.setCellValueFactory(new PropertyValueFactory<>("STADIUM_ID"));
        name.setCellValueFactory(new PropertyValueFactory<>("STADIUM_NAME"));
        location.setCellValueFactory(new PropertyValueFactory<>("STADIUM_LOCATION"));
        capacity.setCellValueFactory(new PropertyValueFactory<>("STADIUM_CAPACITY"));
        xmap.setCellValueFactory(new PropertyValueFactory<>("STADUIM_LOCATION_X"));
        ymap.setCellValueFactory(new PropertyValueFactory<>("STADUIM_LOCATION_Y"));
        table.setItems(null);
        table.setItems(s.showStadium());
               } catch (SQLException ex) {
            Logger.getLogger(FXMLShowStadiumsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void SwitchToHome(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLUserinterface.fxml"));  
        try {
            Parent root = loader.load();
            FXMLUserinterfaceController dc = loader.getController();
            home.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("ERROR USER DETAILS=" + ex.getMessage()); 
        }
    }
}
