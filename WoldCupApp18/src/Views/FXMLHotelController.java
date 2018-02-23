/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Entities.Hotel;
import Services.ServiceHotel;

/**
 * FXML Controller class
 *
 * @author MyTEK
 */
public class FXMLHotelController implements Initializable {

    @FXML
    private TextField hotelname;
    @FXML
    private TextField hotellocation;
    @FXML
    private TextField nbretoiles;
    @FXML
    private TextField hotelx;
    @FXML
    private TextField hotely;
    @FXML
    private Button addhotel;
    @FXML
    private Button annuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddHotel(ActionEvent event) throws SQLException {
        String Hotel_NAME = hotelname.getText(); 
        String Hotel_LOCATION = hotellocation.getText();
        int HOTEL_STARS = parseInt(nbretoiles.getText());
        String HOTEL_LOCATION_X = hotelx.getText();
        String HOTEL_LOCATION_Y = hotely.getText();
         
         Hotel hotel = new Hotel (Hotel_NAME,Hotel_LOCATION,HOTEL_STARS,HOTEL_LOCATION_X,HOTEL_LOCATION_Y);
         ServiceHotel sh = new ServiceHotel();
         sh.addHotel(hotel);
         FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLShowHotels.fxml"));
        try {
            Parent root = loader.load();
            FXMLShowHotelsController dc = loader.getController();
            addhotel.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLShowHotelsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Empltyfields(ActionEvent event) {
        hotelname.clear();
    hotellocation.clear();
    nbretoiles.clear();
    hotelx.clear();
    hotely.clear();
    }
    
}
