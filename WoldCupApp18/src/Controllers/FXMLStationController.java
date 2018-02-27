package Controllers;

import Entities.Station;
import Services.CrudStation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bich
 */
public class FXMLStationController implements Initializable {

    @FXML
    private TextField Stationname;
    @FXML
    private TextField Stationlocation;
    @FXML
    private TextField Stationtype;
    @FXML
    private TextField Stationx;
    @FXML
    private TextField Stationy;
    @FXML
    private Button addStation;
    @FXML
    private Button Cancel;
    @FXML
    private Button afficher;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     *
     * @param event
     * @throws SQLException
     */
    @FXML
    public void AddStation(ActionEvent event) throws SQLException {
        String STATION_NAME = Stationname.getText();
        String STATION_LOCATION = Stationlocation.getText();
        String STATION_TYPE = Stationtype.getText();
        String STATION_LOCATION_X = Stationx.getText();
        String STATION_LOCATION_Y = Stationy.getText();

        Station st = new Station(STATION_NAME, STATION_LOCATION, STATION_TYPE, STATION_LOCATION_X, STATION_LOCATION_Y);
        CrudStation cr = new CrudStation();
        cr.addStation(st);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLShowStations.fxml"));
        try {
            Parent root = loader.load();
            FXMLShowStationsController dc = loader.getController();
            addStation.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLShowStationsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Empltyfields(ActionEvent event) {
        Stationname.clear();
        Stationlocation.clear();
        Stationtype.clear();
        Stationx.clear();
        Stationy.clear();
        try {
            Parent page1 = FXMLLoader.load(getClass().getResource("/Views/FXMLShowStations.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void afficherstations(ActionEvent event) {
        try {
            Parent page1 = FXMLLoader.load(getClass().getResource("/Views/FXMLShowStations.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
