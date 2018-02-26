/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woldcupapp18;

import Services.PlayerServices;
import Services.ServiceTeam;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author apple
 */
public class WoldCupApp18 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //ServiceTeam sp = new ServiceTeam();
        
           // System.out.println(sp.showTeamsStat().get(0).getTEAM_CONTINENT());
    
       Parent root;
        try {
        root = FXMLLoader.load(getClass().getResource("/Views/FXMLShowMatchs.fxml"));

        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
        } catch (IOException ex) {
            System.out.println("START METHOD ERROR="+ex.getMessage());
        }

    
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
