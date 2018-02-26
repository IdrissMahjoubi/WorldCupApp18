/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import Entities.Article;
import Services.ArticleServices;

/**
 * FXML Controller class
 *
 * @author Doggaz Jihed
 */
public class FXMLShowArticleController implements Initializable {

    @FXML
    private TableView<Article> table;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private ChoiceBox<String> comboRech;
    @FXML
    private TableColumn<?, ?> title;
    @FXML
    private TableColumn<?, ?> desc;
    @FXML
    private TableColumn<?, ?> img;
    @FXML
    private TextField titleUpdate;
    @FXML
    private TextArea descUpdate;
    @FXML
    private Button BrowseImg;
    @FXML
    private ImageView imgUpdate;
    @FXML
    private TextField rechercheArticle_txt;
    
    String idTnew,imgPath;
    ObservableList<String> comboList = FXCollections.observableArrayList("Titre", "Description");
    @FXML
    private Button add;
    @FXML
    private Button user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
        comboRech.setItems(comboList);
        table.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                if (newValue !=null){
                    showArticleDetails(newValue);
                }

                });
        rechercheArticle_txt.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filtrerArticleList((String) oldValue, (String) newValue);
            }

        });
        // TODO
    }  
    
        public void afficher() {
            ArticleServices s = new ArticleServices();
        title.setCellValueFactory(new PropertyValueFactory<>("ARTICLE_TITLE"));
        desc.setCellValueFactory(new PropertyValueFactory<>("ARTICLE_DESCRIPTION"));
        img.setCellValueFactory(new PropertyValueFactory<>("ARTICLE_IMAGE"));

        table.setItems(s.showArticles());
    }
        
         @FXML
    private void modifier(ActionEvent event) {
         if (!table.getSelectionModel().isEmpty()) {
            ArticleServices s = new ArticleServices();

            Article a = new Article();
            a.setARTICLE_ID(Integer.valueOf(idTnew));
            a.setARTICLE_TITLE(titleUpdate.getText());
            a.setARTICLE_DESCRIPTION(descUpdate.getText());
            
            

            a.setARTICLE_IMAGE(imgPath);
            
            s.updateArticle(a);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Modifier Article ");
            alert.setHeaderText("Modification d'article :"
                    + table.getSelectionModel().getSelectedItem().getARTICLE_TITLE()+ " est effectué avec succes");
            Optional<ButtonType> result = alert.showAndWait();
  

        } else {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Erreur de selection");
            alert1.setHeaderText("Vous etes obligé de selectioner un article");

            Optional<ButtonType> result = alert1.showAndWait();

        }
        afficher();
    }



    @FXML
    private void BrowseLogo(ActionEvent event) throws MalformedURLException {
        String imageFile;
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);

            Image image1 = new Image(imageFile);

            imgUpdate.setImage(image1);
            imgPath = imageFile;
           
        } else {
            System.out.println("file doesn't exist");
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
                if (!table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Supprimer Article");
            alert.setHeaderText("Vouler vous vraiment supprimer  : " + table.getSelectionModel().getSelectedItem().getARTICLE_TITLE()+ " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                ArticleServices s = new ArticleServices();
                s.removeArticle(table.getSelectionModel().getSelectedItem().getARTICLE_ID());
                afficher();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText("Veuillez selectionner un team !");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

   
    
        void showArticleDetails(Article a) {

        idTnew = String.valueOf(a.getARTICLE_ID());
        imgPath = String.valueOf(a.getARTICLE_IMAGE());
        
        titleUpdate.setText(a.getARTICLE_TITLE());
        descUpdate.setText(a.getARTICLE_DESCRIPTION());
        
        
        Image image1 = new Image(a.getARTICLE_IMAGE());
        imgUpdate.setImage(image1);
       

    }
    
void filtrerArticleList(String oldValue, String newValue) {
        String choix = comboRech.getValue();
        ArticleServices s = new ArticleServices();
        if(choix.equals("Titre")){
        ObservableList<Article> filteredList = FXCollections.observableArrayList();
        if (rechercheArticle_txt.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(s.showArticles());
        } else {

            newValue = newValue.toUpperCase();

            for (Article article : table.getItems()) {

                String filterArticleName = article.getARTICLE_TITLE();

                if (filterArticleName.toUpperCase().contains(newValue)) {
                    filteredList.add(article);

                }

            }
            table.setItems(filteredList);

        }
        
    }
        else
        {
            
            ObservableList<Article> filteredList = FXCollections.observableArrayList();
        if (rechercheArticle_txt.getText()== null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(s.showArticles());
        } else {

            newValue = newValue.toUpperCase();

            for (Article article : table.getItems()) {

                String filterTeamName = article.getARTICLE_DESCRIPTION();

                if (filterTeamName.toUpperCase().contains(newValue)) {
                    filteredList.add(article);

                }

            }
            table.setItems(filteredList);

        }
            
        }

    }

    @FXML
    private void addArticle(ActionEvent event) {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FXMLAddArticle.fxml"));
        try {
            Parent root=loader.load();
            add.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLShowArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void user(ActionEvent event) {
                try {
            Parent root=FXMLLoader.load(getClass().getResource("/Views/FXMLShowArticleUser.fxml"));
            Scene scene=new Scene(root);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("START METHOD ERROR="+ex.getMessage());
        }
    }

   
}
