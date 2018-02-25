/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import javafx.collections.ObservableList;
import Entities.Match;

/**
 *
 * @author apple
 */
public interface Match_inteface {

    public void createMatch(Match M);

    public ObservableList getAMatch();

    public ObservableList getAllMatchs();
    
    boolean deleteMatch(int id);

    public Match getMatchbyId(int id);

    public void updateMatch(Match p);
    
    public void updateReferee(String referee,int Id);

    public void EmptyMatch();
}
