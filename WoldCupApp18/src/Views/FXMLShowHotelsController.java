/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import Entities.Hotel;
import Services.ServiceHotel;

/**
 * FXML Controller class
 *
 * @author MyTEK
 */
public class FXMLShowHotelsController implements Initializable {

    @FXML
    private TableView<Hotel> table;
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
    private ChoiceBox<?> choiseBox;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherhotel();
    }    

    @FXML
    private void deleteHotel(ActionEvent event) throws SQLException {
        if (!table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Supprimer Hotel");
            alert.setHeaderText("Etes vous sur de vouloir supprimer : " + table.getSelectionModel().getSelectedItem().getHotel_ID());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
            ServiceHotel s=new ServiceHotel();
            s.DeleteHotel(table.getSelectionModel().getSelectedItem().getHotel_ID());
            afficherhotel();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText("Veuillez selectionner un hotel !");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @FXML
    private void UpdateStation(ActionEvent event) {
    }

    @FXML
    private void goback(ActionEvent event) {
    }
    
      public void afficherhotel(){
           
        ServiceHotel s = new ServiceHotel();
        id.setCellValueFactory(new PropertyValueFactory<>("HOTEL_ID"));
        name.setCellValueFactory(new PropertyValueFactory<>("Hotel_NAME"));
        location.setCellValueFactory(new PropertyValueFactory<>("Hotel_LOCATION"));
        type.setCellValueFactory(new PropertyValueFactory<>("HOTEL_STARS"));
        x.setCellValueFactory(new PropertyValueFactory<>("HOTEL_LOCATION_X"));
        y.setCellValueFactory(new PropertyValueFactory<>("HOTEL_LOCATION_Y"));
        table.setItems(null);
        table.setItems(s.showHotel());
           
    }
    
}
