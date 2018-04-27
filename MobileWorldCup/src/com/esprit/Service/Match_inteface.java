/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import javafx.collections.ObservableList;
import com.esprit.Entities.Game;

/**
 *
 * @author apple
 */
public interface Match_inteface {

    public void createMatch(Game M);

    public ObservableList getAMatch();

    public ObservableList getAllMatchs();
    
    boolean deleteMatch(int id);

    public Game getMatchbyId(int id);

    public void updateMatch(Game p);
    
    public void updateReferee(String referee,int Id);

    public void EmptyMatch();
}
