/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import Entities.Player;
import Services.ArticleServices;
import Services.NoteServices;
import Services.ServiceTeam;
import Services.StatServices;
import com.jfoenix.controls.JFXTabPane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author Doggaz Jihed
 */
public class FXMLStatPlayerController implements Initializable {

    @FXML
    private PieChart pie;
    @FXML
    private VBox vb;

    @FXML
    private Text text;
    PieChart.Data pc;
    PieChart.Data pc1;
    PieChart.Data pc2;
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab tab1;
    @FXML
    private VBox vb1;
    @FXML
    private PieChart pie1;
    @FXML
    private Tab tab2;
    @FXML
    private Tab tab3;
    @FXML
    private TableView<Player> table;
    @FXML
    private TableColumn<?, ?> player;
    @FXML
    private TableColumn<?, ?> ratings;
    @FXML
    private ImageView imgPlayer;
    @FXML
    private Label name;
    @FXML
    private Label team;
    @FXML
    private Label club;
    @FXML
    private Label age;
    @FXML
    private Label weight;
    @FXML
    private Label height;
    @FXML
    private Rating note;
    
    Image image;
    private PieChart pie3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NoteServices sn = NoteServices.getInstance();
        StatServices st = StatServices.getInstance();
        
        ObservableList<PieChart.Data> myList = FXCollections.observableArrayList();
        ObservableList<PieChart.Data> myList1 = FXCollections.observableArrayList();
        
        
        for (int i = 0; i<10; i++){
            pc = new PieChart.Data(st.showTeamsStat().get(i).getTEAM_NAME(), st.showTeamsStat().get(i).getTEAM_GOALSFOR());
            myList.add(pc);
             pc1 = new PieChart.Data(st.showTeamsStatGain().get(i).getTEAM_NAME(), st.showTeamsStatGain().get(i).getTEAM_NUMBERMATCHWON());
            myList1.add(pc1);
        }
        
              
        
        
        


        pie.setData(myList);
        pie.setLegendSide(Side.LEFT);
        

        pie1.setData(myList1);
        pie1.setLegendSide(Side.LEFT);
        
       
        
        
        player.setCellValueFactory(new PropertyValueFactory<>("PLAYER_NAME"));
        ratings.setCellValueFactory(new PropertyValueFactory<>("PLAYER_RATING"));
        table.setItems(sn.getTopRatings());
        
        
        image = new Image(sn.getTopRatings().get(0).getPLAYER_PICTURE());
        imgPlayer.setImage(image);
        name.setText(sn.getTopRatings().get(0).getPLAYER_NAME());
        team.setText(sn.getTopRatings().get(0).getPLAYER_TEAM());
        club.setText(sn.getTopRatings().get(0).getPLAYER_CLUB());
        height.setText(sn.getTopRatings().get(0).getPLAYER_HEIGHT());
        weight.setText(sn.getTopRatings().get(0).getPLAYER_WEIGHT());
        age.setText(String.valueOf(sn.getTopRatings().get(0).getPLAYER_AGE()));
        note.setRating(sn.getTopRatings().get(0).getPLAYER_RATING());
        
    }    
    
}
