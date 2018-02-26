/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Entities.Match;
import Services.Match_services;
import Utilities.ParseHTML;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import org.controlsfx.control.MaskerPane;

/**
 * FXML Controller class
 *
 * @author apple
 */
public class FXMLShowMatchsController implements Initializable {

    @FXML
    private TableColumn<Match, Date> Col_Date;
    @FXML
    private TableColumn<Match, String> Col_Referee;
    @FXML
    private TableView<Match> Table_matchAll;
    @FXML
    private TableColumn<Match, String> Col_Time;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Button Add_match_button;
    @FXML
    private Button Delete_match_button;
    @FXML
    private Button Edit_match_button;
    
    Match_services match_service = Match_services.getInstance();
    @FXML
    private TableColumn<?, ?> Col_MatchNumber;
    @FXML
    private TableColumn<?, ?> Col_WinnerTeam;
    @FXML
    private TableColumn<?, ?> Col_LooserTeam;
    @FXML
    private TableColumn<?, ?> Col_GameKind;
    @FXML
    private TableColumn<?, ?> Col_Venue;
    @FXML
    private TableColumn<?, ?> Col_Stadium;
    @FXML
    private TableColumn<?, ?> Col_WinnerTeamScore;
    @FXML
    private TableColumn<?, ?> Col_LooserTeamScore;
    @FXML
    private JFXButton Reparse_match_button;
    Match_services match_services = Match_services.getInstance();
    @FXML
    private MaskerPane maskerpane;
    
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        match_services.setAllPositions();
        affiche();
    }
    
    void affiche() {
        AnchorPane.toFront();
        ObservableList<Match> data = match_service.getAllMatchs();
        Col_Date.setCellValueFactory(new PropertyValueFactory<>("date_match"));
        Col_Referee.setCellValueFactory(new PropertyValueFactory<>("Referee"));
        Col_Time.setCellValueFactory(new PropertyValueFactory<>("time"));
        Col_WinnerTeam.setCellValueFactory(new PropertyValueFactory<>("Team1"));
        Col_LooserTeam.setCellValueFactory(new PropertyValueFactory<>("Team2"));  
        Col_GameKind.setCellValueFactory(new PropertyValueFactory<>("gameKind"));
        Col_MatchNumber.setCellValueFactory(new PropertyValueFactory<>("MatchNumber"));
        Col_Stadium.setCellValueFactory(new PropertyValueFactory<>("Stadium"));
        Col_Venue.setCellValueFactory(new PropertyValueFactory<>("Venue"));
        Col_WinnerTeamScore.setCellValueFactory(new PropertyValueFactory<>("Team1Score"));
        Col_LooserTeamScore.setCellValueFactory(new PropertyValueFactory<>("Team2Score"));
        
        Table_matchAll.setItems(null);
        Table_matchAll.setItems(data);
    }

    @FXML
    private void Link_Add(ActionEvent event) {
                FXMLLoader ld = new FXMLLoader(getClass().getResource("/Views/FXMLAddMatch.fxml"));
        try {
            Parent root = ld.load();
                    FXMLAddMatchController MatchCnt = ld.getController();
                    Add_match_button.getScene().setRoot(root);


        } catch (IOException ex) {
            System.out.println("Link_add_ERROR" + ex.getMessage());
        }

    }

    @FXML
    private void Delete_button(ActionEvent event) {

        
        if (!Table_matchAll.getSelectionModel().isEmpty()) {
        Optional<ButtonType> result = alertMessage("Vouler vous vraiment supprimer ?", Alert.AlertType.CONFIRMATION);
        if (result.get() == ButtonType.OK) {
        Match m = Table_matchAll.getSelectionModel().getSelectedItem();
        match_service.deleteMatch(m.getMatch_id());
        int selectedIndex = Table_matchAll.getSelectionModel().getSelectedIndex();
        Table_matchAll.getItems().remove(selectedIndex);
            }
        } else {
            alertMessage("Select a match please !", Alert.AlertType.ERROR);
        }
    }
    
    public static Optional<ButtonType> alertMessage(String message,Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setContentText(message);
        alert.setHeaderText(null);
        Optional<ButtonType> result = alert.showAndWait();
        return result;
    }

    @FXML
    private void updateShow(ActionEvent event) {
        Match m = Table_matchAll.getSelectionModel().getSelectedItem();
        FXMLLoader ld = new FXMLLoader(getClass().getResource("/Views/FXMLUpdateMatch.fxml"));
            if (!Table_matchAll.getSelectionModel().isEmpty()) {
            Optional<ButtonType> result = alertMessage("Vouler vous vraiment modifier ?", Alert.AlertType.CONFIRMATION);
            if (result.get() == ButtonType.OK) {
        try {
               
            Parent root = ld.load();
            FXMLUpdateMatchController upMatchCnt = ld.getController();
            upMatchCnt.setId_match(m.getMatch_id());
            upMatchCnt.setDatePiker(m.getDate_match());
            upMatchCnt.setLooser_textfield(m.getTeam2Score());
            upMatchCnt.setWinner_textfield(m.getTeam1Score());
            upMatchCnt.setReferee_textfield(m.getReferee());
            upMatchCnt.setTime_textfield(m.getTime());
            upMatchCnt.setGamekind_textfield(m.getGameKind());
            upMatchCnt.setLooserTeam_textfield(m.getTeam2());
            upMatchCnt.setWinnerTeam_textfield1(m.getTeam1());
            upMatchCnt.setVenue_textfield(m.getVenue());
            upMatchCnt.setStadium_textfield(m.getStadium());
            upMatchCnt.setMatchNumber_textfield(m.getMatchNumber());
            Add_match_button.getScene().setRoot(root);
        
        }catch (IOException ex) {
            System.out.println("UpdateShow="+ex.getMessage());
        }
            }
             }else{
            alertMessage("Select a match please !", Alert.AlertType.ERROR);
            }
    }
    
    


    @FXML
    private void ReparseMatch(ActionEvent event) {
           int i=1;
       // match_service.EmptyMatch();
       // ParseHTML.ParseMatch();
        //for (int j = 0; j < ParseHTML.ParseReferee().size(); j++) {
            
      //  match_service.updateReferee((String)ParseHTML.ParseReferee().get(j),i++);
       // }                       

               // maskerpane.setVisible(true);

                
      //  FXMLShowMatchsController.alertMessage("Reparsing reussie",Alert.AlertType.INFORMATION);
        FXMLLoader ld=new FXMLLoader(getClass().getResource("/Views/FXMLShowMatchs.fxml"));
        
        try {
            Parent root= ld.load();
            Add_match_button.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Load Empty to Show Fail= "+ex.getMessage());       
        }
    }
}
