/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Team;
import Services.ServiceTeam;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author apple
 */
public class FXMLShowMatchUserController implements Initializable {

    @FXML
    private Pane m16;
    @FXML
    private Pane m17;
    @FXML
    private Pane m18;
    @FXML
    private Pane m19;
    @FXML
    private Pane m20;
    @FXML
    private Pane m21;
    @FXML
    private Pane m22;
    @FXML
    private Pane m23;
    @FXML
    private Pane m24;
    @FXML
    private Pane m25;
    @FXML
    private Pane m26;
    @FXML
    private Pane m27;
    @FXML
    private Pane m28;
    @FXML
    private Pane m29;
    @FXML
    private Pane m30;
    @FXML
    private Pane m31;
    @FXML
    private Pane m1;
    @FXML
    private Pane m2;
    @FXML
    private Pane m3;
    @FXML
    private Pane m4;
    @FXML
    private Pane m5;
    @FXML
    private Pane m6;
    @FXML
    private Pane m7;
    @FXML
    private Pane m8;
    @FXML
    private Pane m9;
    @FXML
    private Pane m10;
    @FXML
    private Pane m11;
    @FXML
    private Pane m12;
    @FXML
    private Pane m13;
    @FXML
    private Pane m14;
    @FXML
    private Pane m15;
    @FXML
    private Pane m32;
    @FXML
    private Pane m33;
    @FXML
    private Pane m34;
    @FXML
    private Pane m35;
    @FXML
    private Pane m36;
    @FXML
    private Pane m37;
    @FXML
    private Pane m38;
    @FXML
    private Pane m39;
    @FXML
    private Pane m40;
    @FXML
    private Pane m41;
    @FXML
    private Pane m42;
    @FXML
    private Pane m43;
    @FXML
    private Pane m44;
    @FXML
    private Pane m45;
    @FXML
    private Pane m46;
    @FXML
    private Pane m47;
    @FXML
    private Pane m48;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private AnchorPane anchorPane;
    static int matchNumber = 0;
    @FXML
    private AnchorPane page;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        List<Node> lnodes = getAllNodes(anchorPane);

        for (Node node : lnodes) {
            setEvent((Pane) node);

        }

    }

    public void setEvent(Pane p) {
        p.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {

                matchNumber = Integer.parseInt(p.getId().substring(1, p.getId().length()));
                LoadSingleMatch();
            }

        });
    }

    public static ArrayList<Node> getAllNodes(Parent root) {
        ArrayList<Node> nodes = new ArrayList<>();
        addAllDescendents(root, nodes);
        return nodes;
    }

    private static void addAllDescendents(Parent parent, ArrayList<Node> nodes) {
        for (Node node : parent.getChildrenUnmodifiable()) {
            if (node.getClass() == Pane.class) {
                nodes.add(node);
            }
            if (node instanceof Parent) {
                addAllDescendents((Parent) node, nodes);
            }
        }
    }

    public void LoadSingleMatch() {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/Views/FXMLShowSingleMatch.fxml"));
            page.getChildren().setAll(pane);
        } catch (IOException ex) {
            System.out.println("error view" + ex.getMessage());
        }
    }

    private void back(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/FXMLUserinterface.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

}
