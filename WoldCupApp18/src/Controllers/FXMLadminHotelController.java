/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Hotel;
import Services.ServiceHotel;
import Services.ServiceUser;
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
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author MyTEK
 */
public class FXMLadminHotelController implements Initializable {

    @FXML
    private TableView<Hotel> table;
    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> xmap;
    @FXML
    private TableColumn<?, ?> ymap;
    @FXML
    private Button btndelete;
    @FXML
    private Button Update;
    @FXML
    private TextField Recherche;
    @FXML
    private ChoiceBox<String> choiseBox;
    ObservableList<String> comboList = FXCollections.observableArrayList("Hotel name", "Hotel Location", "Hotel stars");
    @FXML
    private TextField XMAP;
    @FXML
    private TextField YMAP;
    @FXML
    private Button acceuil;
    @FXML
    private Button add;
    @FXML
    private TextField hotelLocation;
    @FXML
    private TableColumn<?, ?> hotelstars;
    @FXML
    private TextField hotelName;
    @FXML
    private TextField HOTELSTARS;
    String ID_Hotel_new;
    @FXML
    private TableColumn<?, ?> nameh;
    @FXML
    private TableColumn<?, ?> locationh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choiseBox.setItems(comboList);
        afficherHotel();
        table.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        showHotelDetails(newValue);
                    }
                });
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

        ServiceHotel s = new ServiceHotel();

        String choix = choiseBox.getValue();
        if (choix.equals("Hotel name")) {
            ObservableList<Hotel> filteredList = FXCollections.observableArrayList();
            if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
                table.setItems(s.showHotel());

            } else {
                newValue = newValue.toUpperCase();
                for (Hotel h : table.getItems()) {

                    String filterHotelName = h.getHotel_NAME();

                    if (filterHotelName.toUpperCase().contains(newValue)) {
                        filteredList.add(h);
                    }
                }

                table.setItems(filteredList);
            }
        } else if (choix.equals("Hotel Location")) {
            ObservableList<Hotel> filteredList = FXCollections.observableArrayList();
            if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
                table.setItems(s.showHotel());

            } else {
                newValue = newValue.toUpperCase();
                for (Hotel h : table.getItems()) {

                    String filterStadiumLocation = h.getHotel_LOCATION();

                    if (filterStadiumLocation.toUpperCase().contains(newValue)) {
                        filteredList.add(h);
                    }
                }

                table.setItems(filteredList);
            }
        } else if (choix.equals("Hotel stars")) {
            ObservableList<Hotel> filteredList = FXCollections.observableArrayList();
            if (Recherche.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
                table.setItems(s.showHotel());

            } else {
                newValue = newValue.toUpperCase();
                for (Hotel h : table.getItems()) {

                    String filterStadiumCapacity = Integer.toString(h.getHOTEL_STARS());

                    if (filterStadiumCapacity.toUpperCase().contains(newValue)) {
                        filteredList.add(h);
                    }
                }

                table.setItems(filteredList);
            }
        }

    }

    @FXML
    private void deleteHotel(ActionEvent event) {
        if (!table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Hotel");
            alert.setHeaderText("Are you sure you want to delete : " + table.getSelectionModel().getSelectedItem().getHotel_ID() + " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                ServiceHotel st = new ServiceHotel();
                try {
                    st.DeleteHotel(table.getSelectionModel().getSelectedItem().getHotel_ID());
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLadminHotelController.class.getName()).log(Level.SEVERE, null, ex);
                }
                afficherHotel();

            }
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText("Veuillez selectionner une station !");
            Optional<ButtonType> result = alert.showAndWait();
        }
        EmptyFields(event);
    }

    @FXML
    private void UpdateHotel(ActionEvent event) {
        if (!table.getSelectionModel().isEmpty()) {
            ServiceHotel sh = new ServiceHotel();
            Hotel h = new Hotel();

            h.setHotel_ID(Integer.valueOf(ID_Hotel_new));
            h.setHotel_NAME(hotelName.getText());
            h.setHotel_LOCATION(hotelLocation.getText());
            h.setHOTEL_STARS(Integer.parseInt(HOTELSTARS.getText()));
            h.setHOTEL_LOCATION_X(XMAP.getText());
            h.setHOTEL_LOCATION_Y(YMAP.getText());
            sh.updateHotel(h);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("update hotel");
            alert.setHeaderText("update of :"
                    + table.getSelectionModel().getSelectedItem().getHotel_NAME() + " was successfully made");
            Optional<ButtonType> result = alert.showAndWait();

        } else {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Error");
            alert1.setHeaderText("please select an hotel");
            Optional<ButtonType> result = alert1.showAndWait();
        }
        afficherHotel();
        EmptyFields(event);
    }

    @FXML
    private void addhotel(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLHotel.fxml"));
        try {
            Parent root = loader.load();
            FXMLHotelController dc = loader.getController();
            add.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLHotelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void returnToMenu(ActionEvent event) {
    }

    public void afficherHotel() {
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

    void showHotelDetails(Hotel h) {
        ID_Hotel_new = String.valueOf(h.getHotel_ID());
        hotelName.setText(h.getHotel_NAME());
        hotelLocation.setText(h.getHotel_LOCATION());
        HOTELSTARS.setText(Integer.toString(h.getHOTEL_STARS()));
        XMAP.setText(h.getHOTEL_LOCATION_X());
        YMAP.setText(h.getHOTEL_LOCATION_Y());

    }

    private void EmptyFields(ActionEvent event) {
        hotelName.clear();
        hotelLocation.clear();
        HOTELSTARS.clear();

        XMAP.clear();
        YMAP.clear();
    }

}
