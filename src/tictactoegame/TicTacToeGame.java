/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Dr.Wlaa
 */
public class TicTacToeGame extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = new GameRoomDesignBase();// FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        
       // Parent root = FXMLLoader.load(getClass().getResource("GameRoomDesign.fxml"));
//         BorderPane rootb = new BorderPane();
//        GameRoomDesignBase teb= new GameRoomDesignBase();
//        rootb.getChildren().add(teb);
        Scene scene = new Scene(root);
         
        stage.setTitle("Text Editor app");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
