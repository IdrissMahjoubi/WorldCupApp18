/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.view;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.esprit.Service.ServiceGame;
import com.esprit.Entities.Game;
import javafx.scene.control.DatePicker;

/**
 *
 * @author sana
 */
public class HomeGame {

    Form f;

    Picker gameDate;
    TextField referee;
    Picker time;
    TextField Team1Score;
    TextField Team2Score;
    TextField gameKind; 
    TextField Team1;
    TextField Team2;
    TextField Venue;
    TextField Stadium;
    TextField MatchNumber;
    Button ShowButton;

    public HomeGame() {
        f = new Form("home");
        Container container = new Container(BoxLayout.y());
        ShowButton=new Button("Show All Games");
        container.add(ShowButton);
        f.add(container);
       
        ShowButton.addActionListener((e)->{
        ShowGame a=new ShowGame();
        a.getF().show();
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }





    
    

}
