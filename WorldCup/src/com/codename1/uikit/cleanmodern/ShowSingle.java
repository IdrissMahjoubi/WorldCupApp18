/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;
import com.esprit.Service.ServiceGame;
import com.esprit.Entities.Game;
import java.util.ArrayList;

/**
 *
 * @author apple
 */
public class ShowSingle extends BaseForm {

    Form f;
    SpanLabel lb;
    private Resources theme;

    public ShowSingle(Resources res, int id) {
        
super("Single Game", BoxLayout.y());

        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Show Single");
        getContentPane().setScrollVisible(false);
        
        super.addSideMenu(res);
        
        tb.addSearchCommand(e -> {});
        
        
        Image img = res.getImage("profile-background.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);


        
        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                    GridLayout.encloseIn(3, 
                            
                            FlowLayout.encloseCenter(
                            )
                    )
                )
        ));

        Container SingleGames = new Container(BoxLayout.y());
        SingleGames.setScrollable(true);
          
         ServiceGame serviceGame =new ServiceGame();
         Game game=serviceGame.getSingleGame(id);
        
            TextField gameNumber = new TextField(game.getMatchNumber().substring(0,2));
            TextField TeamOne = new TextField(game.getTeam1());
            TextField TeamTwo = new TextField(game.getTeam2());
            TextField gameKind = new TextField(game.getGameKind());
            TextField gameVenue = new TextField(game.getVenue());
            TextField gameDate = new TextField(game.getDate_match());
            TextField gameTime = new TextField(game.getTime());
            TextField Team1Score = new TextField(game.getTeam1Score().substring(0,1));
            TextField Team2Score = new TextField(game.getTeam2Score().substring(0,1));
            TextField gameReferee = new TextField(game.getReferee());
            TextField gameStadium = new TextField(game.getStadium());

            gameNumber.setEditable(false);
            TeamOne.setEditable(false);
            TeamTwo.setEditable(false);
            gameKind.setEditable(false);
            gameVenue.setEditable(false);
            gameTime.setEditable(false);
            gameDate.setEditable(false);
            Team1Score.setEditable(false);
            Team2Score.setEditable(false);
            gameReferee.setEditable(false);
            gameStadium.setEditable(false);

             gameNumber.setUIID("TextFieldBlack");
             TeamOne.setUIID("TextFieldBlack"); 
             TeamTwo.setUIID("TextFieldBlack"); 
             gameKind.setUIID("TextFieldBlack"); 
             gameVenue.setUIID("TextFieldBlack"); 
             gameDate.setUIID("TextFieldBlack"); 
             gameTime.setUIID("TextFieldBlack"); 
             Team1Score.setUIID("TextFieldBlack"); 
             Team2Score.setUIID("TextFieldBlack"); 
             gameReferee.setUIID("TextFieldBlack"); 
             gameStadium.setUIID("TextFieldBlack"); 
            
            addStringValue("Game Home Team Score:",Team1Score);
            addStringValue("Game Away Team Score:", Team2Score);
            addStringValue("Game Number:", gameNumber);
            addStringValue("Game Home Team:", TeamOne);
            addStringValue("Game Away Team:", TeamTwo);
            addStringValue("Game Kind:", gameKind);
            addStringValue("Game Venue:", gameVenue);
            addStringValue("Game Stadium:", gameStadium);
            addStringValue("Game Date:", gameDate);
            addStringValue("Game Time:", gameTime);
            addStringValue("Game Referee:", gameReferee);




            
            
            add(SingleGames);

       
    }
   
    
   
    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));
    }



    

 

}
