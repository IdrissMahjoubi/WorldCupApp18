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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLMAPController implements Initializable,MapComponentInitializedListener {

    
  //  private WebView map;
    @FXML
    private GoogleMapView gmap;
    private GoogleMap map;
    private GeocodingService G;
    private boolean ready;
    @FXML
    private Button retour;
    @FXML
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      // Stade.setItems(Stades);
       gmap.addMapInializedListener(this);
    }   
   
        

        @FXML
    private void ReturnToListStadium(ActionEvent event) {
                    try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/Views/FXMLShowStadiums.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLMAPController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    
 
    public void createMap(){
          map = new GoogleMap();
        G = new GeocodingService();
        MapOptions mapOptions = new  MapOptions();
          mapOptions.center(new LatLong(61.920454, 54.586139))
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
    
    @Override
    public void mapInitialized() {
     //  String St = Stade.getValue();
         createMap();
         
     //if(St == "Stade Loujniki")
       // {
       String x="stade Loujniki, moscou";
              

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
                //System.out.println("result LG "+latLong.getLongitude()+ "   " +latLong.getLatitude());
                markerOptions.position(latLong)
                        .visible(Boolean.TRUE)
                        .title("Stade Loujniki");
               

                Marker marker = new Marker(markerOptions);
                map.addMarker(marker);

            }

            map.setCenter(latLong);
       });
       // }
             
     // if(St == "Otkrytie Arena")
      //  {
              G.geocode("Otkrytie Arena, Moscou", (GeocodingResult[] results, GeocoderStatus status) -> {

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
                MarkerOptions markerOptions1 = new MarkerOptions();
               // System.out.println("result LG "+latLong.getLongitude()+ "   " +latLong.getLatitude());
                markerOptions1.position(latLong)
                        .visible(Boolean.TRUE)
                        .title("Otkrytie Arena");

                Marker marker1 = new Marker(markerOptions1);
                map.addMarker(marker1);

            }

            map.setCenter(latLong);
       });  
       
      //  }
      
      // if(St == "Stade Krestovski")
       // {
         G.geocode("Stade Krestovski, Saint-Pétersbourg", (GeocodingResult[] results, GeocoderStatus status) -> {

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
                MarkerOptions markerOptions2 = new MarkerOptions();
                //System.out.println("result LG "+latLong.getLongitude()+ "   " +latLong.getLatitude());
                markerOptions2.position(latLong)
                        .visible(Boolean.TRUE)
                        .title("Stade Krestovski");

                Marker marker2 = new Marker(markerOptions2);
                map.addMarker(marker2);

            }

            map.setCenter(latLong);
       });
        //}
       
        // if(St == "Stade de nijni Novgorod")
       // {
         
        G.geocode("Stade de Nijni Novgorod, Nijni Novgorod", (GeocodingResult[] results, GeocoderStatus status) -> {

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
                MarkerOptions markerOptions3 = new MarkerOptions();
               // System.out.println("result LG "+latLong.getLongitude()+ "   " +latLong.getLatitude());
                markerOptions3.position(latLong)
                        .visible(Boolean.TRUE)
                        .title("Stade de Nijni Novgorod");

                Marker marker3 = new Marker(markerOptions3);
                map.addMarker(marker3);

            }

            map.setCenter(latLong);
       });
       // }
       
       //    if(St == "Stade de Kaliningrad")
       // {
        G.geocode("Stade de Kaliningrad, Kaliningrad", (GeocodingResult[] results, GeocoderStatus status) -> {

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
                MarkerOptions markerOptions4 = new MarkerOptions();
               // System.out.println("result LG "+latLong.getLongitude()+ "   " +latLong.getLatitude());
                markerOptions4.position(latLong)
                        .visible(Boolean.TRUE)
                        .title("Stade de Kaliningrad");

                Marker marker4 = new Marker(markerOptions4);
                map.addMarker(marker4);

            }

            map.setCenter(latLong);
       });
      //  }
           
         //      if(St == "lekaterinbourg Arena")
      //  {
        
           G.geocode("lekaterinbourg Arena, Iekaterinbourg", (GeocodingResult[] results, GeocoderStatus status) -> {

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
                MarkerOptions markerOptions5 = new MarkerOptions();
               // System.out.println("result LG "+latLong.getLongitude()+ "   " +latLong.getLatitude());
                markerOptions5.position(latLong)
                        .visible(Boolean.TRUE)
                        .title("lekaterinbourg Arena");

                Marker marker5 = new Marker(markerOptions5);
                map.addMarker(marker5);

            }

            map.setCenter(latLong);
       });
       // }

           //   if(St == "Stade de Mordovie")
       // {
               G.geocode("Stade de Mordovie, Saransk", (GeocodingResult[] results, GeocoderStatus status) -> {

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
                MarkerOptions markerOptions6 = new MarkerOptions();
              //  System.out.println("result LG "+latLong.getLongitude()+ "   " +latLong.getLatitude());
                markerOptions6.position(latLong)
                        .visible(Boolean.TRUE)
                        .title("Stade de Mordovie");

                Marker marker6 = new Marker(markerOptions6);
                map.addMarker(marker6);

            }
               

            map.setCenter(latLong);
       });
       // }
              
              
          //     if(St == "Kuzan Arena")
       // {
             G.geocode("Kazan-Arena, Kazan", (GeocodingResult[] results, GeocoderStatus status) -> {

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
                MarkerOptions markerOptions7 = new MarkerOptions();
             //   System.out.println("result LG "+latLong.getLongitude()+ "   " +latLong.getLatitude());
                markerOptions7.position(latLong)
                        .visible(Boolean.TRUE)
                        .title("Kazan-Arena");

                Marker marker7 = new Marker(markerOptions7);
                map.addMarker(marker7);

            }

            map.setCenter(latLong);
       });   
       // }
               
       //  if(St == "Cosmos Arena")
       // {
             G.geocode("Cosmos Arena, Samara", (GeocodingResult[] results, GeocoderStatus status) -> {

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
                MarkerOptions markerOptions8 = new MarkerOptions();
             //   System.out.println("result LG "+latLong.getLongitude()+ "   " +latLong.getLatitude());
                markerOptions8.position(latLong)
                        .visible(Boolean.TRUE)
                        .title("Cosmos Arena");

                Marker marker8 = new Marker(markerOptions8);
                map.addMarker(marker8);

            }

            map.setCenter(latLong);
       });   
      //  }
         
         
        //   if(St == "Rostov Arena")
       // {
        
              G.geocode("Rostov Arena, Rostov-sur-le-Don", (GeocodingResult[] results, GeocoderStatus status) -> {

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
                MarkerOptions markerOptions9 = new MarkerOptions();
              //  System.out.println("result LG "+latLong.getLongitude()+ "   " +latLong.getLatitude());
                markerOptions9.position(latLong)
                        .visible(Boolean.TRUE)
                        .title("Rostov Arena");

                Marker marker9 = new Marker(markerOptions9);
                map.addMarker(marker9);

            }

            map.setCenter(latLong);
       });   
       // }
           
       //     if(St == "Stade Ficht")
      //  {
             G.geocode("Stade Ficht, Sotchi", (GeocodingResult[] results, GeocoderStatus status) -> {

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
                MarkerOptions markerOptions10 = new MarkerOptions();
             //   System.out.println("result LG "+latLong.getLongitude()+ "   " +latLong.getLatitude());
                markerOptions10.position(latLong)
                        .visible(Boolean.TRUE)
                        .title("Stade Ficht");

                Marker marker10 = new Marker(markerOptions10);
                map.addMarker(marker10);
                        }

            map.setCenter(latLong);
       });  
       // }
            
       // if(St == "Volgograd Arena")
       // {
              
                G.geocode("Volgograd Arena, Volgograd", (GeocodingResult[] results, GeocoderStatus status) -> {

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
                MarkerOptions markerOptions11 = new MarkerOptions();
               // System.out.println("result LG "+latLong.getLongitude()+ "   " +latLong.getLatitude());
                markerOptions11.position(latLong)
                        .visible(Boolean.TRUE)
                        .title("Volgograd Arena");

                Marker marker11 = new Marker(markerOptions11);
                map.addMarker(marker11);

            }

            map.setCenter(latLong);
       });   
      //  }
               

    
       }
    
}




