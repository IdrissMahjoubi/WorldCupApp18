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
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.esprit.Service.ServiceGame;
import com.esprit.Entities.Game;
import java.util.ArrayList;

/**
 *
 * @author sana
 */
public class ShowSingle {

    Form f;
    SpanLabel lb;
    private Resources theme;

    public ShowSingle(int id) {
        
        f = new Form();
        ServiceGame serviceGame =new ServiceGame();
        Game game=new Game();
                game=serviceGame.getSingleGame(id);
        Label lb = new Label(game.toString());
           f.add(lb);
            
                

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
