/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import Services.ServiceTeam;
import com.jfoenix.controls.JFXTabPane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

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
    @FXML
    private ScrollPane sp;
    PieChart.Data pc;
    PieChart.Data pc1;
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab tab1;
    @FXML
    private ScrollPane sp1;
    @FXML
    private VBox vb1;
    @FXML
    private PieChart pie1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ServiceTeam st = new ServiceTeam();
        
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
    }    
    
}
