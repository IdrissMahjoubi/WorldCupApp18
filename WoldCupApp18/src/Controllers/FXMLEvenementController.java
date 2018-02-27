/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Evenement;
import Entities.Participation;
import Services.CrudEvenement;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import Utilities.Session;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import Services.ParticipationServices;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * FXML Controller class
 *
 * @author Bich
 */
public class FXMLEvenementController implements Initializable {

    @FXML
    private TextField EventName;
    @FXML
    private TextField EventPlace;
    @FXML
    private TextField EventDesc;
    @FXML
    private Button Valider;
    @FXML
    private Button Cancel;
    @FXML
    private Button GoBack;
    @FXML
    private DatePicker EventDate;
    @FXML
    private TextField EventGouv;
    @FXML
    private TableView<Evenement> Table;
    @FXML
    private TableColumn<?, ?> EvName;
    @FXML
    private TableColumn<?, ?> EvDate;
    @FXML
    private TableColumn<?, ?> EvEndroit;
    @FXML
    private TableColumn<?, ?> Evdesc;
    @FXML
    private Button showmap;
    @FXML
    private DatePicker EventEnd;
    @FXML
    private TableColumn<?, ?> EvFin;
    @FXML
    private TableColumn<?, ?> Evgouv;
    @FXML
    private TableColumn<?, ?> nbrparticip;
    @FXML
    private Button Participer;
    @FXML
    private Label txtnbrparticipant;
    @FXML
    private TextField txtparticipant;
<<<<<<< HEAD
    int nbrpart=0;
    String newid;
    @FXML
    private TableColumn<?, ?> nbrparticip;
    @FXML
    private Button home;
=======

    int nbrpart = 0;
    CrudEvenement cr = new CrudEvenement();
    PreparedStatement pst;
    int xe;
    static String gouv;
    static String endro;
    int userid;

    ParticipationServices ps = new ParticipationServices();
    Participation p = new Participation();

>>>>>>> d81c846c29556b9486a139c561d9f4433db6ecb4
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
            Date todayWithZeroTime;
        try {
            todayWithZeroTime = formatter.parse(formatter.format(today));
            System.out.println(todayWithZeroTime);

        } catch (ParseException ex) {
            Logger.getLogger(FXMLEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        afficherEvent();
        txtnbrparticipant.setVisible(false);
        txtparticipant.setVisible(false);
        userid = Session.LoggedUser.getUser_id();

    }

    public void afficherEvent() {
        EvName.setCellValueFactory(new PropertyValueFactory<>("EVENT_NAME"));
        EvDate.setCellValueFactory(new PropertyValueFactory<>("EVENT_DATE"));
        EvFin.setCellValueFactory(new PropertyValueFactory<>("EVENT_END"));
        Evgouv.setCellValueFactory(new PropertyValueFactory<>("EVENT_GOUV"));
        EvEndroit.setCellValueFactory(new PropertyValueFactory<>("EVENT_PLACE"));
        Evdesc.setCellValueFactory(new PropertyValueFactory<>("EVENT_DESC"));
        nbrparticip.setCellValueFactory(new PropertyValueFactory<>("NBR_PARTICIP"));
        Table.setItems(null);
        Table.setItems(cr.showEvent());
    }

    @FXML
    private void AddEvent(ActionEvent event) throws SQLException {
        String EVENT_NAME = EventName.getText();
        Date EVENT_DATE = java.sql.Date.valueOf(EventDate.getValue());
        Date EVENT_END = java.sql.Date.valueOf(EventEnd.getValue());
        String EVENT_GOUV = EventGouv.getText();
        String EVENT_PLACE = EventPlace.getText();
        String EVENT_DESC = EventDesc.getText();
        int NBR_PARTICIP = 0;
        Evenement e = new Evenement(EVENT_NAME, EVENT_DATE, EVENT_END, EVENT_GOUV, EVENT_PLACE, EVENT_DESC, NBR_PARTICIP);
        cr.addEvent(e);
        afficherEvent();
    }

    @FXML
    private void EmptyFields(ActionEvent event) {
        EventName.clear();
        EventDesc.clear();
        EventPlace.clear();
        EventDate.getEditor().clear();
        EventEnd.getEditor().clear();
    }

    @FXML
    private void GoBack(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLMenu.fxml"));
        try {
            Parent root = loader.load();
            FXMLMenuController dc = loader.getController();
            GoBack.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ShowMap(ActionEvent event) {
        if (!Table.getSelectionModel().getSelectedItems().isEmpty()) {

            endro = Table.getSelectionModel().getSelectedItem().getEVENT_PLACE();
            gouv = Table.getSelectionModel().getSelectedItem().getEVENT_GOUV();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLEventMap.fxml"));
            try {
                Parent root = loader.load();
                FXMLEventMapController dc = loader.getController();
                showmap.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(FXMLEventMapController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText("Would you select an event !");
            Optional<ButtonType> result = alert.showAndWait();
        }

    }

    @FXML
<<<<<<< HEAD
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


=======
    public void Participate(ActionEvent event) throws SQLException {
        xe = Table.getSelectionModel().getSelectedItem().getEVENT_ID();
        int h = ps.CheckIDexistance(userid, xe);
        if (h != 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText("You already participate in this event !");
            Optional<ButtonType> result = alert.showAndWait();
        } else if (Table.getSelectionModel().getSelectedItems().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText("Would you select an event !");
            Optional<ButtonType> result = alert.showAndWait();
        } else {
            int newuserid = Session.LoggedUser.getUser_id();
            nbrpart = Table.getSelectionModel().getSelectedItem().getNBR_PARTICIP();
            nbrpart = nbrpart + 1;
            txtparticipant.setText(String.valueOf(nbrpart));
            txtnbrparticipant.setVisible(true);
            txtparticipant.setVisible(true);
            String nameev = Table.getSelectionModel().getSelectedItem().getEVENT_NAME();
            int y = (Integer.parseInt(txtparticipant.getText()));
            cr.updateparticip(y, nameev);
            afficherEvent();
            ps.addParticipation(userid, xe);
            System.out.println(userid);
            System.out.println(xe);

        }

    }

   /* private void DeleteEvent() throws SQLException {
       Evenement e = new Evenement();
       DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date today = new Date();

        try {
            Date todayWithZeroTime = formatter.parse(formatter.format(today));
          if (e.getEVENT_END().after(todayWithZeroTime)) 
          {
            int x = e.getEVENT_ID();
                cr.DeleteEvent(x);

        }
        } catch (ParseException ex) {
            Logger.getLogger(FXMLEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }

  
    }*/
    
    
}
>>>>>>> d81c846c29556b9486a139c561d9f4433db6ecb4
