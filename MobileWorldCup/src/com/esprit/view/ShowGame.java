/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.view;

import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.esprit.Service.ServiceGame;
import com.esprit.Entities.Game;
import java.util.ArrayList;

/**
 *
 * @author sana
 */
public class ShowGame {

    Form f;
    SpanLabel lb;
    private Resources theme;

    public ShowGame() {
        
        f = new Form();
        ServiceGame serviceGame =new ServiceGame();
        ArrayList<Game> list=serviceGame.getListOfGames();
        
        Container listGames = new Container(BoxLayout.y());
        listGames.setScrollable(true);
        for (Game game: list)
        {
            MultiButton mb = new MultiButton(game.getTeam1()+" VS "+game.getTeam2());
            mb.setTextLine2("more Details..");
            mb.addActionListener((e)->{
                
        ShowSingle single=new ShowSingle(game.getMatch_id());
        single.getF().show();
        });
            listGames.add(mb);
            
        }        
        f.add(listGames);

          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeGame h=new HomeGame();
          h.getF().show();
          });
          
    }
    

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
