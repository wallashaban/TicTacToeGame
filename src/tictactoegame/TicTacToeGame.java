/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;
import GameHistory.HistoryGameScreen;

import tictactoegame.data.SharedData;
import tictactoegame.SplashScreen.SplashScreen;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import tictactoegame.connection.ClientConnection;
/**
 *
 * @author Dr.Wlaa
 */
public class TicTacToeGame extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = new SplashScreen();

//        stage.initStyle(StageStyle.UNDECORATED); 
        SharedData.setStage(stage);
        Scene scene = new Scene(root);
         
        stage.setScene(scene);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        
        
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                    ClientConnection.closeConnection();
                    Platform.exit();
            }
        });
        
   
    }

    @Override
    public void stop() throws Exception {
    ClientConnection.closeConnection();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        
        launch(args);
    }
    
}
