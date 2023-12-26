/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.connection;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tictactoegame.dialogs.ExceptionDialog;

/**
 *
 * @author anasn
 */
public class Constants {
    // ip, port, DB username, DB pass, etc...
    // public static final CAPITAL
    public static final int PORT= 7777;
    public static final String IP_ADDRESS= "127.0.0.1";
    
    public static final int REGISTER = 1;
    public static final int LOGIN = 2;
    
    public static void showDialog(String message) {
        Parent parent = new ExceptionDialog(message);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED); 
        stage.setScene(scene);
        stage.showAndWait();
    }
}
