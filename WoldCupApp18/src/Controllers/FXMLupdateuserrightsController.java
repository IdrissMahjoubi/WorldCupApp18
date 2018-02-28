/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import Entities.User;
import Services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author MyTEK
 */
public class FXMLupdateuserrightsController implements Initializable {

    @FXML
    private TableView<User> table;
    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableColumn<?, ?> last_name;
    @FXML
    private TableColumn<?, ?> birth_date;
    @FXML
    private TableColumn<?, ?> nationality;
    @FXML
    private TableColumn<?, ?> email;
    @FXML
    private TableColumn<?, ?> tel;
    @FXML
    private TableColumn<?, ?> login;
    @FXML
    private TableColumn<?, ?> password;
    @FXML
    private TableColumn<?, ?> favorite_team;
    @FXML
    private Button btn2;
    @FXML
    private TextField recherche_txt;
    @FXML
    private ChoiceBox<String> combo_rech;
    ObservableList<String> comboList = FXCollections.observableArrayList("nom","nationalite","equipe preferée");
    @FXML
    private Label label;
    @FXML
    private Button modifrights;
    @FXML
    private Button bloquer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
        combo_rech.setItems(comboList);
        recherche_txt.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                try {
                    filtrerUserList((String) oldValue, (String) newValue);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLupdateuserrightsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
  });
    }


    public void afficher()    
{
    try {
        ServiceUser s = new ServiceUser();
        name.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        last_name.setCellValueFactory(new PropertyValueFactory<>("user_last_name"));
        birth_date.setCellValueFactory(new PropertyValueFactory<>("user_birthday"));
        nationality.setCellValueFactory(new PropertyValueFactory<>("user_nationality"));
        email.setCellValueFactory(new PropertyValueFactory<>("user_email"));
        tel.setCellValueFactory(new PropertyValueFactory<>("user_tel"));
        login.setCellValueFactory(new PropertyValueFactory<>("user_login"));
        password.setCellValueFactory(new PropertyValueFactory<>("user_password"));
        favorite_team.setCellValueFactory(new PropertyValueFactory<>("user_team"));
        
        
        table.setItems(null);
        
        table.setItems(s.showUsers());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLupdateuserrightsController.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    @FXML
    private void deleteUser(ActionEvent event) {
         System.out.println("hhhhhhhhhhhhhhh");
        if (!table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Supprimer utilisateur");
            alert.setHeaderText("Etes vous sur de vouloir supprimer l'utilisateur : " + table.getSelectionModel().getSelectedItem().getUser_name()+ " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                ServiceUser s=new ServiceUser();
        s.DeleteUser(table.getSelectionModel().getSelectedItem().getUser_name());
            afficher();
                 
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText("Veuillez selectionner un team !");
             Optional<ButtonType> result = alert.showAndWait();
        }

    }

   
    
    void filtrerUserList(String oldValue, String newValue) throws SQLException {
        String choix = combo_rech.getValue();
        ServiceUser st = new ServiceUser();
        if(choix.equals("nom")){
        ObservableList<User> filteredList = FXCollections.observableArrayList();
        if (recherche_txt.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(st.showUsers());
        } else {

            newValue = newValue.toUpperCase();

            for (User user : table.getItems()) {

                String filterTeamName = user.getUser_name();

                if (filterTeamName.toUpperCase().contains(newValue)) {
                    filteredList.add(user);

                }

            }
            table.setItems(filteredList);

        }
        
    }
        else if(choix.equals("nationalite"))
        {
            
            ObservableList<User> filteredList = FXCollections.observableArrayList();
        if (recherche_txt.getText()== null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(st.showUsers());
        } else {

            newValue = newValue.toUpperCase();

            for (User user : table.getItems()) {

                String filterTeamName = user.getUser_nationality();

                if (filterTeamName.toUpperCase().contains(newValue)) {
                    filteredList.add(user);

                }

            }
            table.setItems(filteredList);

        }
            
        }
        else{
   
             ObservableList<User> filteredList = FXCollections.observableArrayList();
        if (recherche_txt.getText()== null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(st.showUsers());
        } else {

            newValue = newValue.toUpperCase();

            for (User user : table.getItems()) {

                String filterTeamName = user.getUser_team();

                if (filterTeamName.toUpperCase().contains(newValue)) {
                    filteredList.add(user);

                }

            }
            table.setItems(filteredList);

        }
        }
    }

    @FXML
    private void bannerCompte(ActionEvent event) {
        if (!table.getSelectionModel().isEmpty()) {
           ServiceUser su = new ServiceUser();

            
            
            su.closeAccount(table.getSelectionModel().getSelectedItem());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("bloquer un utilisateur");
            alert.setHeaderText("L'utilisateur"
                    + table.getSelectionModel().getSelectedItem().getUser_name()+ " est banné de l'application");
            Optional<ButtonType> result = alert.showAndWait();

        } else {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Erreur de selection");
            alert1.setHeaderText("Vous etes obligé de selectioner un utilisateur");

            Optional<ButtonType> result = alert1.showAndWait();

        }
        afficher();
    }

    
    
     @FXML
    private void updateUserRights(ActionEvent event) {
        if (!table.getSelectionModel().isEmpty()) {
           ServiceUser su = new ServiceUser();

            
            //System.out.println(table.getSelectionModel().getSelectedItem().getUser_id());
            su.upgradeUser(table.getSelectionModel().getSelectedItem());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("changer un membre en admin");
            alert.setHeaderText("L'utilisateur"
                    + table.getSelectionModel().getSelectedItem().getUser_name()+ " est devenu un admin de l'application");
            Optional<ButtonType> result = alert.showAndWait();

        } else {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Erreur de selection");
            alert1.setHeaderText("Vous etes obligé de selectioner un utilisateur");

            Optional<ButtonType> result = alert1.showAndWait();

        }
        afficher();
    }
}
