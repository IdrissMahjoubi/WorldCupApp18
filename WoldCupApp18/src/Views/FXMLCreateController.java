/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import Entities.User;
import Services.service_user;

/**
 * FXML Controller class
 *
 * @author MyTEK
 */
public class FXMLCreateController implements Initializable {

   

    @FXML
    private Label label;
    @FXML
    private TextField name;
    @FXML
    private TextField lastname;
    @FXML
    private TextField birthday;
    @FXML
    private TextField nationality;
    @FXML
    private TextField email;
    @FXML
    private TextField tel;
    @FXML
    private TextField login;
    @FXML
    private TextField password;
    @FXML
    private ChoiceBox<String> team;
      ObservableList<String> comboList = FXCollections.observableArrayList("Egypte", "Maroc","Nigeria","Sénégal","Tunisie","Arabie Saoudite","Australie","Japon","Republique de Coree","RI Iran","Allemagne","Angleterre","Belgique","Croatie","Danemark","Espagne","France","Islande","Pologne","Portugal","Russie","Serbie","Suède","Suisse","Costa Rica","Mexique","Panama","Argentine","Brésil","Colombie","Pérou","Uruguay");
    @FXML
    private PasswordField password2;
    @FXML
    private Button retour;
   

    public Button getSave() {
        return save;
    }

    public void setSave(Button save) {
        this.save = save;
    }
    @FXML
    private Button save;

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public TextField getName() {
        return name;
    }

    public void setName(TextField name) {
        this.name = name;
    }

    public TextField getLastname() {
        return lastname;
    }

    public void setLastname(TextField lastname) {
        this.lastname = lastname;
    }

    public TextField getBirthday() {
        return birthday;
    }

    public void setBirthday(TextField birthday) {
        this.birthday = birthday;
    }

    public TextField getNationality() {
        return nationality;
    }

    public void setNationality(TextField nationality) {
        this.nationality = nationality;
    }

    public TextField getEmail() {
        return email;
    }

    public void setEmail(TextField email) {
        this.email = email;
    }

    public TextField getTel() {
        return tel;
    }

    public void setTel(TextField tel) {
        this.tel = tel;
    }

    public TextField getLogin() {
        return login;
    }

    public void setLogin(TextField login) {
        this.login = login;
    }

    public TextField getPassword() {
        return password;
    }

    public void setPassword(TextField password) {
        this.password = password;
    }

    
     public ChoiceBox<String> getTeam() {
        return team;
    }

    /*public void setTeam(ChoiceBox<?> team) {
        this.team = team;
    }*/

  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        team.setItems(comboList);
    }    

   

    @FXML
    private void addd(ActionEvent event) throws SQLException {
        System.out.println("hgjgjhg");
         String user_name = name.getText();
        String user_lastname = lastname.getText();
        String user_birthday = birthday.getText();
        String user_nationality = nationality.getText();
        String user_email = email.getText();
        int user_phonenumber = parseInt(tel.getText());
        String user_login = login.getText();
        String user_password = password.getText();
        if(password2.getText().equals(password.getText()) ){
            System.out.println("confirme");
        }
        String user_favoriteteam =team.getValue();
       
        User u = new User(user_name,user_lastname,user_birthday,user_nationality,user_email,user_phonenumber,user_login,user_password,user_favoriteteam);
        service_user s = new service_user();
        if(password2.getText().equals(password.getText()) ){
            System.out.println("confirme");
            s.addUser(u);
            /*try{
            String host ="smtp.gmail.com" ;
            String user = "your email address";
            String pass = "your password";
            String to = "receiever email ";
            String from = "sender email";
            String subject = "This is confirmation number for your expertprogramming account. Please insert this number to activate your account.";
            String messageText = "Your Is Test Email :";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); 
            msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }*/
       /*     try {
            // Construct data
            String apiKey = "apikey=" + "rtR1phxRYco-vWmlbO5fIwyHAeuu5M9D3etZEfQ6Nx	";
            String message = "&message=" + "Votre compte a été créé avec succes, enjoy";
            String sender = "&sender=" + "+21621245065";
            String numbers = "&numbers=" + "+21621245065";

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                JOptionPane.showMessageDialog(null, "successfuly");
            }
            rd.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Bienvenu");
            alert.setHeaderText("votre compte a été créé avec succes,binvenue"+user_login);
             Optional<ButtonType> result = alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("erreur");
            alert.setHeaderText("veuillez verifier votre mot de passe");
             Optional<ButtonType> result = alert.showAndWait();
        }*/
    }}

    @FXML
    private void retour(ActionEvent event) {
    }
    
}
