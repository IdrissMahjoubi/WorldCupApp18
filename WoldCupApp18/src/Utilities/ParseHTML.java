/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import Entities.Match;
import Services.Match_services;

/**
 *
 * @author apple
 */
public class ParseHTML {

    static LocalDate date;
    static String Time;
    static String WinnerTeam;
    static String LooserTeam;
    static int MatchNumber;
    static String Group;
    static String Stadium;
    static String Venue;
    static Match_services match_services = Match_services.getInstance();
    static Document doc = null;
    static String Referee;


    public ParseHTML() {

    }

    public static void ParseMatch() {

        try {
            doc = Jsoup.connect("http://www.fifa.com/worldcup/matches/index.html").get();

            Elements matchs = doc.select(".clear-grid > .mu");
            for (Element match : matchs) {
//DATE
                //get Fulldate from selected element convert to String then Get Date of Day
                String stringDate = match.select(".mu-i-datetime").text().substring(0, 11);
                //Convert String to Date
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
                date = LocalDate.parse(stringDate, formatter);
                
//TIME
                Time = match.select(".mu-i-datetime").text().substring(14, 19);
//MATCH NUMBER
                String MatchNumberString = match.select(".mu-i-matchnum").text().substring(6);
                MatchNumber = Integer.parseInt(MatchNumberString);
//GROUP
                Group = match.select(".mu-i-group").text();
//STAIUM
                Stadium = match.select(".mu-i-stadium").text();
//VENUE
                Venue = match.select(".mu-i-venue").text();
//winnerTeam
                WinnerTeam= match.select(".home .t-nText").text();
//looserteam
                LooserTeam= match.select(".away .t-nText").text();
                
                        
            /*  System.out.println(WinnerTeam+" VS "+LooserTeam);
                System.out.println("**************************");
                System.out.println(date);
                System.out.println("**************************");
                System.out.println(Time);
                System.out.println("**************************");
                System.out.println(MatchNumber);
                System.out.println("**************************");
                System.out.println(Group);
                System.out.println("**************************");
                System.out.println(Stadium);
                System.out.println("**************************");
                System.out.println(Venue);
                System.out.println("**************************");*/
        java.sql.Date dateS =java.sql.Date.valueOf(date);
        Match M=new Match(dateS,"unknown",Time,0,0,Group, WinnerTeam, LooserTeam, Venue, Stadium, MatchNumber);
       
         match_services.createMatch(M);
            }

        } catch (IOException ex) {
            System.out.println("PARSE MATCH ERROR");
        }


    }
    
    public static ArrayList ParseReferee()
    {
        ArrayList Refs=new ArrayList();
        try {
            doc = Jsoup.connect("http://www.totalsportek.com/football/fifa-world-cup-referees/").get();
            Elements referees = doc.select(".even > td");
            for (Element referee : referees) {
            if(!referee.select("strong").text().isEmpty())
                {
            Refs.add(referee.select("strong").text());
                }
            }
            } catch (IOException ex) {
            System.out.println("PARSE REFEREE ERROR");
        }
        return Refs;
    }
}
