/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.codename1.uikit.cleanmodern.BaseForm;
import com.esprit.Entities.Game;
import com.esprit.Entities.Team;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javafx.scene.control.Alert;

/**
 *
 * @author sana
 */

public class ServiceGame implements Match_inteface {

    
        public ArrayList<Game> getListOfGames() {
        ArrayList<Game> listGames = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/IdrissProject/web/app_dev.php/api/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> games = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) games.get("root");

                    for (Map<String, Object> obj : list) {
                        Game game = new Game();
                        float id = Float.parseFloat(obj.get("gameId").toString());
                        game.setMatch_id((int) id);

                      Map<String,Object> results= (Map<String,Object>)obj.get("gameDate");
                      Double a=(Double)results.get("timestamp");
                      Date d=new Date((long)(a*1000));
                      
                      game.setDate_match(d.toString().substring(0,10));
                        game.setGameKind(obj.get("gameKind").toString());
                        game.setMatchNumber(obj.get("gameMatchnumber").toString());
                        game.setReferee(obj.get("gameReferee").toString());
                        game.setStadium(obj.get("gameStadium").toString());
                        game.setTeam1(obj.get("gameWinnerteam").toString());
                        game.setTeam1Score(obj.get("gameWinnerteamscore").toString());
                        game.setTeam2(obj.get("gameLossteam").toString());
                        game.setTeam2Score(obj.get("gameLossteamscore").toString());
                        game.setTime(obj.get("gameTime").toString());
                        game.setVenue(obj.get("gameVenue").toString());

                        System.out.println(d.toString());
                        listGames.add(game);

                    }
                } catch (IOException ex) {
                    System.out.println("Error Parsing Json Data "+ex.getMessage());
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listGames;
    }
        
      public Game getSingleGame(int id) {
       // ArrayList<Game> listGames = new ArrayList<>();
       Game game = new Game(); 
       ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/IdrissProject/web/app_dev.php/api/single/"+id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> games = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));


                        float id = Float.parseFloat(games.get("gameId").toString());
                        game.setMatch_id((int) id);

                      Map<String,Object> results= (Map<String,Object>)games.get("gameDate");
                      Double a=(Double)results.get("timestamp");
                      Date d=new Date((long)(a*1000));
                      
                      game.setDate_match(d.toString().substring(0,10));
                      
                        game.setGameKind(games.get("gameKind").toString());
                        game.setMatchNumber(games.get("gameMatchnumber").toString());
                        game.setReferee(games.get("gameReferee").toString());
                        game.setStadium(games.get("gameStadium").toString());
                        game.setTeam1(games.get("gameWinnerteam").toString());
                        game.setTeam1Score(games.get("gameWinnerteamscore").toString());
                        game.setTeam2(games.get("gameLossteam").toString());
                        game.setTeam2Score(games.get("gameLossteamscore").toString());
                        game.setTime(games.get("gameTime").toString());
                        game.setVenue(games.get("gameVenue").toString());

                } catch (IOException ex) {
                    System.out.println("Error Parsing Json Data "+ex.getMessage());
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return game;
    }

      
}
