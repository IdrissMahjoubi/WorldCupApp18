/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import Entities.Player;

/**
 *
 * @author Doggaz Jihed
 */
public class ParseClubs {
        public ObservableList<String> clubs() {
         ObservableList<String> myList=FXCollections.observableArrayList();
 
     Document document = null;


        
       
            try {
                document = Jsoup.connect("http://www.eurotopteams.com/football/club.php").get();
            } catch (IOException ex) {
                Logger.getLogger(ParseClubs.class.getName()).log(Level.SEVERE, null, ex);
            }


            Elements joueurs = document.select("table > tbody > tr > td");
          
            for (Element joueur : joueurs) {
                if (!joueur.select("a").text().isEmpty())
                
                myList.add(joueur.select("a").text());
               

        }
            
            return myList;
        }
    
}

