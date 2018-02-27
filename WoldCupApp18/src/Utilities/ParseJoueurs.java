/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import Entities.Player;
import Services.PlayerServices;

/**
 *
 * @author Doggaz Jihed
 */
public class ParseJoueurs {
    
    PlayerServices ps = new PlayerServices();
    
    
    public static int countWords(String s){

    int wordCount = 0;

    boolean word = false;
    int endOfLine = s.length() - 1;

    for (int i = 0; i < s.length(); i++) {
        // if the char is a letter, word = true.
        if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
            word = true;
            // if char isn't a letter and there have been letters before,
            // counter goes up.
        } else if (!Character.isLetter(s.charAt(i)) && word) {
            wordCount++;
            word = false;
            // last word of String; if it doesn't end with a non letter, it
            // wouldn't count without this.
        } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
            wordCount++;
        }
    }
    return wordCount;
}
    
   
    
    public void espagne(){
            ArrayList<String> nom=new ArrayList();
 
     Document document = null;
     int i =0;
     String numM;
     String age;
     String taille;
     String poids;
     ArrayList<String> NumPull=new ArrayList();

        try {
            document = Jsoup.connect("http://www.sports.fr/football/espagne/effectif.html").get();

            Elements joueurs = document.select("tbody > tr");
          
            for (Element joueur : joueurs) {
                
               
                if (joueur.elementSiblingIndex()<=7){
                if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                 
                 
                            String player_position = "Goalkeeper";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                            String player_team = "Espagne";
                 
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                    }
                 
                }else if(joueur.elementSiblingIndex()>7 && joueur.elementSiblingIndex()<=18){
                     if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                 
                            String player_position = "Defender";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                            String player_team = "Espagne";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 
                 ps.addPlayer(p);
                     }
                 }else if(joueur.elementSiblingIndex()>18 && joueur.elementSiblingIndex()<=34){
                 if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                            String player_position = "Midfielder";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 String player_team = "Espagne";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                 }
                     }else{
                 if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                            String player_position = "Forward";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                 String player_team = "Espagne";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                 }
                 }
                }
                
               
 
        } catch (IOException ex) {
            System.out.println("PARSE MATCH ERROR "+ex.getMessage());
        }
}
    
    public  void france(){
            ArrayList<String> nom=new ArrayList();
 
     Document document = null;
     int i =0;
     String numM;
     String age;
     String taille;
     String poids;
     ArrayList<String> NumPull=new ArrayList();

        try {
            document = Jsoup.connect("http://www.sports.fr/football/equipe-de-france/effectif.html").get();

            Elements joueurs = document.select("tbody > tr");
          
            for (Element joueur : joueurs) {
                
               
                if (joueur.elementSiblingIndex()<=5){
                if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                            String player_position = "Goalkeeper";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                 String player_team = "France";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                }
                 
                }else if(joueur.elementSiblingIndex()>5 && joueur.elementSiblingIndex()<=14){
                     if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                            String player_position = "Defender";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                String player_team = "France";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                     }
                 }else if(joueur.elementSiblingIndex()>14 && joueur.elementSiblingIndex()<=20){
                 if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                            String player_position = "Midfielder";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                 String player_team = "France";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                 }
                     }else{
                 if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                            String player_position = "Forward";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                String player_team = "France";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                 }
                 }
                }
                
               
 
        } catch (IOException ex) {
            System.out.println("PARSE MATCH ERROR "+ex.getMessage());
        }
}
    
    public  void argentine(){
            ArrayList<String> nom=new ArrayList();
 
     Document document = null;
     int i =0;
     String numM;
     String age;
     String taille;
     String poids;
     ArrayList<String> NumPull=new ArrayList();

        try {
            document = Jsoup.connect("http://www.sports.fr/football/argentine/effectif.html").get();

            Elements joueurs = document.select("tbody > tr");
          
            for (Element joueur : joueurs) {
                
               
                if (joueur.elementSiblingIndex()<=7){
                if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                 
                     String player_position = "Goalkeeper";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                 String player_team = "Argentine";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                }
                 
                }else if(joueur.elementSiblingIndex()>7 && joueur.elementSiblingIndex()<=21){
                     if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                     String player_position = "Defender";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                 String player_team = "Argentine";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                     }
                 }else if(joueur.elementSiblingIndex()>21 && joueur.elementSiblingIndex()<=36){
                 if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                     String player_position = "Midfielder";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                 String player_team = "Argentine";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                 }
                     }else{
                 if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                     String player_position = "Forward";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
String player_team = "Argentine";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);                 ps.addPlayer(p);
                 }
                 }
                }
                
               
 
        } catch (IOException ex) {
            System.out.println("PARSE MATCH ERROR "+ex.getMessage());
        }
}
    
    public  void brésil(){
            ArrayList<String> nom=new ArrayList();
 
     Document document = null;
     int i =0;
     String numM;
     String age;
     String taille;
     String poids;
     ArrayList<String> NumPull=new ArrayList();

        try {
            document = Jsoup.connect("http://www.sports.fr/football/bresil/effectif.html").get();

            Elements joueurs = document.select("tbody > tr");
          
            for (Element joueur : joueurs) {
                
               
                if (joueur.elementSiblingIndex()<=11){
                if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                 
                     String player_position = "Goalkeeper";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
String player_team = "Brésil";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                }
                 
                }else if(joueur.elementSiblingIndex()>11 && joueur.elementSiblingIndex()<=34){
                     if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                     String player_position = "Defender";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                 String player_team = "Brésil";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                     }
                 }else if(joueur.elementSiblingIndex()>34 && joueur.elementSiblingIndex()<=56){
                 if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                     String player_position = "Midfielder";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                String player_team = "Brésil";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                 }
                     }else{
                 if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                     String player_position = "Forward";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                 String player_team = "Brésil";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                 }
                 } 
                }
                
               
 
        } catch (IOException ex) {
            System.out.println("PARSE MATCH ERROR "+ex.getMessage());
        }
}
    
    
    public  void russie(){
            ArrayList<String> nom=new ArrayList();
 
     Document document = null;
     int i =0;
     String numM;
     String age;
     String taille;
     String poids;
     ArrayList<String> NumPull=new ArrayList();

        try {
            document = Jsoup.connect("http://www.sports.fr/football/russie/effectif.html").get();

            Elements joueurs = document.select("tbody > tr");
          
            for (Element joueur : joueurs) {
                
               
                if (joueur.elementSiblingIndex()<=5){
                if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                 
                     String player_position = "Goalkeeper";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                String player_team = "Russia";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                }
                 
                }else if(joueur.elementSiblingIndex()>5 && joueur.elementSiblingIndex()<=12){
                     if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                     String player_position = "Defender";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                 String player_team = "Russia";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                     }
                 }else if(joueur.elementSiblingIndex()>12 && joueur.elementSiblingIndex()<=22){
                 if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                     String player_position = "Midfielder";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                String player_team = "Russia";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                 }
                     }else{
                 if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                     String player_position = "Forward";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                 String player_team = "Russia";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                 }
                 }
                }
                
               
 
        } catch (IOException ex) {
            System.out.println("PARSE MATCH ERROR "+ex.getMessage());
        }
}
    
     public  void allemagne(){
            ArrayList<String> nom=new ArrayList();
 
     Document document = null;
     int i =0;
     String numM;
     String age;
     String taille;
     String poids;
     ArrayList<String> NumPull=new ArrayList();

        try {
            document = Jsoup.connect("http://www.sports.fr/football/allemagne/effectif.html").get();

            Elements joueurs = document.select("tbody > tr");
          
            for (Element joueur : joueurs) {
                
               
                if (joueur.elementSiblingIndex()<=6){
                if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                 
                     String player_position = "Goalkeeper";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                 String player_team = "Germany";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                }
                 
                }else if(joueur.elementSiblingIndex()>6 && joueur.elementSiblingIndex()<=18){
                     if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                     String player_position = "Defender";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                 String player_team = "Germany";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                     }
                 }else if(joueur.elementSiblingIndex()>18 && joueur.elementSiblingIndex()<=34){
                 if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                     String player_position = "Midfielder";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                 String player_team = "Germany";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                 }
                     }else{
                 if(countWords(joueur.select("td.tc").text())==3 && !joueur.select("td.tl.nowrap").text().isEmpty() && !joueur.select("td > a").text().isEmpty() ){
                     String player_position = "Forward";
                            String player_name = joueur.select("td > a").text();
                            String player_club = joueur.select("td.tl.nowrap").text();
                            String []strArray=joueur.select("td.tc").text().split(" ");
                            int player_tshirt = Integer.parseInt(strArray[0]);
                            int player_age = Integer.parseInt(strArray[1]);
                            String player_height = strArray[3];
                            String player_weight = strArray[4]+strArray[5];
                 
                 String player_team = "Germany";
                            
                 Player p = new Player(player_name, player_age,player_team, player_position, player_club, player_height, player_tshirt, player_weight);
                 ps.addPlayer(p);
                 }
                 }
                }
                
               
 
        } catch (IOException ex) {
            System.out.println("PARSE MATCH ERROR "+ex.getMessage());
        }
}
    
}
