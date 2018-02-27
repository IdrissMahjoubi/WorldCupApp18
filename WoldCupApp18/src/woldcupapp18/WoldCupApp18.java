/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woldcupapp18;


import java.io.IOException;
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
     
    
       Parent root;
        try {

<<<<<<< HEAD
        root = FXMLLoader.load(getClass().getResource("/Views/FXMLShowMatchs.fxml"));
=======
        root = FXMLLoader.load(getClass().getResource("/Views/FXMLShowStadiums.fxml"));
>>>>>>> 6a33d4aaa8ebba7bf00d836d2e5af64a86dc92f8


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
