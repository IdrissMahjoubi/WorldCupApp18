/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.view;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.esprit.Service.ServiceGame;
import com.esprit.Entities.Game;

/**
 *
 * @author sana
 */
public class HomeGame {

    Form f;
    TextField tnom;
    TextField tetat;
    Button btnajout,btnaff;

    public HomeGame() {
        f = new Form("home");
        tnom = new TextField();
        tetat = new TextField();
        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
        f.add(tnom);
        f.add(tetat);
        f.add(btnajout);
        f.add(btnaff);
        btnajout.addActionListener((e) -> {
            ServiceGame ser = new ServiceGame();
            Game t = new Game(0, tnom.getText(), tetat.getText());
            ser.ajoutTask(t);
            

        });
        btnaff.addActionListener((e)->{
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

    public TextField getTnom() {
        return tnom;
    }

    public void setTnom(TextField tnom) {
        this.tnom = tnom;
    }

}
