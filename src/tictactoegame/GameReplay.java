/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author Dr.Wlaa
 */
public class GameReplay {

    @Override
    public String toString() {
        return "GameReplay{" + "allMoves=" + allMoves + '}';
    }


    public GameReplay(Map<String, Pair<String, ArrayList<Integer>>> allMoves) {
        this.allMoves = allMoves;
    }
    Map<String, Pair<String, ArrayList<Integer>>> allMoves;
    
}
