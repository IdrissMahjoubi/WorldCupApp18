/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.view;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
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
  
    public ShowGame() {
        
        f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
        ServiceGame serviceTask=new ServiceGame();
        ArrayList<Game> lis=serviceTask.getList2();
        lb.setText(lis.toString());
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
