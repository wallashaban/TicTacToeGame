/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.connection;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tictactoegame.data.Request;
import tictactoegame.data.SharedData;
import tictactoegame.dialogs.ExceptionDialog;
import tictactoegame.dialogs.RequestDialogBase;

/**
 *
 * @author anasn
 */
public class Constants {
    // ip, port, DB username, DB pass, etc...
    // public static final CAPITAL
    public static final int PORT= 7777;
    public static final String IP_ADDRESS= "10.145.9.58";
    //public static final String IP_ADDRESS= "127.0.0.1";
    public static final int REGISTER = 1;
    public static final int LOGIN = 2;
    
    public static void showDialog(String message,boolean isServerclosed) {
        Parent parent = new ExceptionDialog(message,isServerclosed);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED); 
        stage.setScene(scene);
        stage.showAndWait();
    }
    
    public static void navigateTo(Pane pane)
    {
        System.err.println("dialog ");
        Parent root = pane;
                Scene scene = new Scene(root);

                //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                SharedData.
                stage.setScene(scene);
                SharedData.stage.show();
    }
    public static void showRequestDialog(String name , Request request) {
        Parent parent = new RequestDialogBase(name,request);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED); 
        stage.setScene(scene);
        stage.showAndWait();
    }
}
