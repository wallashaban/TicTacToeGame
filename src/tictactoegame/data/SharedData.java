/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.data;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.stage.Stage;
import tictactoegame.GameReplay;

/**
 *
 * @author Dr.Wlaa
 */
public class SharedData {
    public static Player currentPlayer;
    public static boolean connectionStatus;
    public static Socket socket;
    public static Stage stage;
    public static ArrayList<Player> availablePlayers;
    public static GameReplay gameReplay;
    HashMap<String, String> StringData;
    HashMap<String, Integer> IntData;

    public SharedData() {
        StringData = new HashMap<String, String>();
        IntData = new HashMap<String, Integer>();
    }

    public static boolean isConnectionStatus() {
        return connectionStatus;
    }

    public static void setConnectionStatus(boolean connectionStatus) {
        SharedData.connectionStatus = connectionStatus;
    }

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player currentPlayer) {
        SharedData.currentPlayer = currentPlayer;
    }

    public static Socket getSocket() {
        return socket;
    }

    public static void setSocket(Socket socket) {
        SharedData.socket = socket;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        SharedData.stage = stage;
    }
    
    
    public void putString(String key, String value){
        StringData.put(key, value);
    }
    public String getString(String key){
        return StringData.get(key);
    }
    public void putInt(String key, Integer value){
        IntData.put(key, value);
    }
    public Integer getInt(String key){
        return IntData.get(key);
    }
}
