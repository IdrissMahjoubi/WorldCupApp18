/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Hotel;
import Services.ServiceHotel;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MyTEK
 */
public class FXMLuserHotelController implements Initializable {

    @FXML
    private TableView<Hotel> table;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> nameh;
    @FXML
    private TableColumn<?, ?> locationh;
    @FXML
    private TableColumn<?, ?> hotelstars;
    @FXML
    private TableColumn<?, ?> xmap;
    @FXML
    private TableColumn<?, ?> ymap;
    @FXML
    private TextField Recherche;
    @FXML
    private ChoiceBox<String> choiseBox;
    ObservableList<String> comboList = FXCollections.observableArrayList("Hotel name", "Hotel Location","Hotel stars");
    @FXML
    private Button home;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choiseBox.setItems(comboList);
        afficherHotel();
        
         Recherche.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                try {
                    filtrerHotelList((String) oldValue, (String) newValue);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLadminHotelController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }    
    
    
    void filtrerHotelList(String oldValue, String newValue) throws SQLException {
        
      ServiceHotel s = new  ServiceHotel();

      String choix = choiseBox.getValue();
      if (choix.equals("Hotel name")){
        ObservableList<Hotel> filteredList = FXCollections.observableArrayList();
        if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(s.showHotel());

        }else{ 
            newValue = newValue.toUpperCase();
            for (Hotel h : table.getItems()) {
               
               String filterHotelName = h.getHotel_NAME();

             
                if (filterHotelName.toUpperCase().contains(newValue)){
                    filteredList.add(h);
                }
            }
      
            table.setItems(filteredList);
    }
      }
    
      
      else if (choix.equals("Hotel Location")){
        ObservableList<Hotel> filteredList = FXCollections.observableArrayList();
        if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(s.showHotel());

        }else{ 
            newValue = newValue.toUpperCase();
            for (Hotel h : table.getItems()) {
               
               String filterStadiumLocation = h.getHotel_LOCATION();

             
                if (filterStadiumLocation.toUpperCase().contains(newValue)){
                    filteredList.add(h);
                }
            }
      
            table.setItems(filteredList);
    }
      }
            else if (choix.equals("Hotel stars")){
        ObservableList<Hotel> filteredList = FXCollections.observableArrayList();
        if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(s.showHotel());

        }else{ 
            newValue = newValue.toUpperCase();
            for (Hotel h : table.getItems()) {
               
                String filterStadiumCapacity = Integer.toString(h.getHOTEL_STARS());

             
                if (filterStadiumCapacity.toUpperCase().contains(newValue)){
                    filteredList.add(h);
                }
            }
      
            table.setItems(filteredList);
    }
      }
      
      
    }
    
    
     public void afficherHotel(){
        ServiceHotel s = new ServiceHotel();
        id.setCellValueFactory(new PropertyValueFactory<>("Hotel_ID"));
        nameh.setCellValueFactory(new PropertyValueFactory<>("Hotel_NAME"));
        locationh.setCellValueFactory(new PropertyValueFactory<>("Hotel_LOCATION"));
        hotelstars.setCellValueFactory(new PropertyValueFactory<>("HOTEL_STARS"));
        xmap.setCellValueFactory(new PropertyValueFactory<>("HOTEL_LOCATION_X"));
        ymap.setCellValueFactory(new PropertyValueFactory<>("HOTEL_LOCATION_Y"));
        table.setItems(null);
        table.setItems(s.showHotel());
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
                Logger.getLogger(FXMLuserHotelController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
