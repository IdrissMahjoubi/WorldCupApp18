/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;
import com.esprit.Service.ServiceGame;
import com.esprit.Entities.Game;
import javafx.scene.control.DatePicker;

/**
 *
 * @author sana
 */
public class HomeGame extends BaseForm{

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

    public HomeGame(Resources res) {
        f = new Form("home");
        super.addSideMenu(res);
        Container container = new Container(BoxLayout.y());
        ShowButton=new Button("Show All Games");
        container.add(ShowButton);
        f.add(container);
       
        ShowButton.addActionListener((e)->{
        new ShowGame(res).show();
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }





    
    

}
