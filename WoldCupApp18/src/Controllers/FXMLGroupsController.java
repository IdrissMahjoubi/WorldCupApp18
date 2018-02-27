/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Team;
import Services.ServiceTeam;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author pacha
 */
public class FXMLGroupsController implements Initializable {
    @FXML
    private TableColumn<?, ?> position;
    @FXML
    private TableColumn<?, ?> team;
    @FXML
    private TableColumn<?, ?> points;
    @FXML
    private TableColumn<?, ?> mp;
    @FXML
    private TableColumn<?, ?> mw;
    @FXML
    private TableColumn<?, ?> ml;
    @FXML
    private TableColumn<?, ?> md;
    @FXML
    private TableColumn<?, ?> gf;
    @FXML
    private TableColumn<?, ?> ga;
    @FXML
    private TableView<Team> group1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
    }    
    
    public void afficher() {
        ServiceTeam s = new ServiceTeam();
        position.setCellValueFactory(new PropertyValueFactory<>("TEAM_POSITION"));
        team.setCellValueFactory(new PropertyValueFactory<>("TEAM_NAME"));
        points.setCellValueFactory(new PropertyValueFactory<>("TEAM_POINTS"));
        mp.setCellValueFactory(new PropertyValueFactory<>("TEAM_NUMBERMATCHPLAYED"));
        mw.setCellValueFactory(new PropertyValueFactory<>("TEAM_NUMBERMATCHWON"));
        ml.setCellValueFactory(new PropertyValueFactory<>("TEAM_NUMBERMATCHLOST"));
        md.setCellValueFactory(new PropertyValueFactory<>("TEAM_NUMBERMATCHDRAW"));
        gf.setCellValueFactory(new PropertyValueFactory<>("TEAM_GOALSFOR"));
        ga.setCellValueFactory(new PropertyValueFactory<>("TEAM_GOALSAGAINST"));
        group1.setItems(s.showTeams());
    }
    
}
