/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Bich
 */
public class FXMLEventMapController implements Initializable,MapComponentInitializedListener  {

    @FXML
    private GoogleMapView gmap;
    @FXML
    private Button exit;
      private GoogleMap map;
    private GeocodingService G;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            gmap.addMapInializedListener(this);  
    }    
    
    
        public void createMap(){
          map = new GoogleMap();
        G = new GeocodingService();
        MapOptions mapOptions = new  MapOptions();
          mapOptions.center(new LatLong(35.830097, 8.786742))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(true)
                .panControl(true)
                .rotateControl(true)
                .scaleControl(true)
                .streetViewControl(true)
                .zoomControl(true)
                .zoom(6);
        map = gmap.createMap(mapOptions);
    }
        
            
    public void mapInitialized() {

         createMap();
         
       String x ;
        
        x = FXMLEvenementController.endro +", "+FXMLEvenementController.gouv ;
       
            G.geocode(x, (GeocodingResult[] results, GeocoderStatus status) -> {

            LatLong latLong = null;

            if (status == GeocoderStatus.ZERO_RESULTS) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No matching address found");
                alert.show();
                return;
            } else if (results.length > 1) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
                alert.show();
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            } else {
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
                MarkerOptions markerOptions = new MarkerOptions();
              
                markerOptions.position(latLong)
                        .visible(Boolean.TRUE)
                        .title("Stade Loujniki");
               
                Marker marker = new Marker(markerOptions);
                map.addMarker(marker);
            }
            map.setCenter(latLong);
       });
    
    }
    
    
    @FXML
    private void goback(ActionEvent event) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLEvenement.fxml"));
        try {
            Parent root = loader.load();
            FXMLEvenementController dc = loader.getController();
            exit.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
