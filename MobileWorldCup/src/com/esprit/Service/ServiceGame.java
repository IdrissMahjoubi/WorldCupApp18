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
import com.esprit.Entities.Game;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sana
 */

public class ServiceGame implements Match_inteface{

    

    public ArrayList<Game> getListOfGames()  {
        ArrayList<Game> listGames = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        
        
        
        con.setUrl("http://localhost/IdrissProject/web/app_dev.php/api/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
            //    listGames = getListOfGames(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> games;
                    games = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    
                    System.out.println("ROOOOTT !!!!!!!!:" +games.get("root"));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) games.get("root");

                    for (Map<String, Object> obj : list) {
                        Game game = new Game();
                        float id = Float.parseFloat(obj.get("gameId").toString());
                        
                        game.setMatch_id((int) id);
                       // game.setDate_match(obj.get("game_date").toString());
                        game.setGameKind(obj.get("gameKind").toString());
                      /*  game.setMatchNumber(obj.get("game_matchnumber").toString());
                        game.setReferee(obj.get("game_referee").toString());
                        game.setStadium(obj.get("game_stadium").toString());
                        game.setTeam1(obj.get("game_winnerteam").toString());
                        game.setTeam1Score(obj.get("game_winnerteamscore").toString());
                        game.setTeam2(obj.get("game_lossteam").toString());
                        game.setTeam2Score(obj.get("game_lossteamscore").toString());
                        game.setTime(obj.get("game_time").toString());
                        game.setVenue(obj.get("game_venue").toString());*/

                        listGames.add(game);

                    }
                } catch (IOException ex) {
                    System.out.println("ERROR HERE !!!");
                    Log.e(ex);
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listGames;
    }

}
