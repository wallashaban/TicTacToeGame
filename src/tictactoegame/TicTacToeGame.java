/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tictactoegame.GameVsPC.GameVsPcBaseUI;
/**
 *
 * @author Dr.Wlaa
 */
public class TicTacToeGame extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = new SplashScreen();// FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        //Parent root = new GameVsPcBaseUI();

        

        
       // Parent root = FXMLLoader.load(getClass().getResource("GameRoomDesign.fxml"));
//         BorderPane rootb = new BorderPane();
//        gameRoomDesignBase teb= new gameRoomDesignBase();
//        rootb.getChildren().add(teb);
//        Scene scene = new Scene(rootb, 720, 720);
//        Scene scene = new Scene(rootb, 720, 720);
//         BorderPane rootb = new BorderPane();
//        GameRoomDesignBase teb= new GameRoomDesignBase();
//        rootb.getChildren().add(teb);
        Scene scene = new Scene(root);

        stage.initStyle(StageStyle.UNDECORATED); 
        stage.setTitle("Text Editor app");
         
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
