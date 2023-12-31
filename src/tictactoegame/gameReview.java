/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import GameHistory.HistoryGameScreen;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import tictactoegame.LocalGame.GameRoomScreen;
import tictactoegame.data.MessageController;
import tictactoegame.dialogs.drawDialogBase;


/**
 *
 * @author ghon
 */
public class gameReview {
    private  int currentp1Index;
    private  int currentp2Index;
    private  int x;
    private  int y;
    private  boolean isX;
              

      public void review(HistoryGameScreen historyGameScreen,Button[][] boxArray ,ArrayList<Integer> playerMoves) {
          
          ArrayList<Integer> player1Moves = new ArrayList<>();
                    ArrayList<Integer> player2Moves = new ArrayList<>();

          for(int k=0;k<playerMoves.size();k+=2){
          player1Moves.add(playerMoves.get(k));
          }
          for(int k=1;k<playerMoves.size();k+=2){
          player2Moves.add(playerMoves.get(k));
          }
        System.out.println("we are inside review");
        isX = true;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                //boxEnabled[i][j] = true;
//                boxArray[i][j].setText(" ");
//                boxArray[i][j].setTextFill(javafx.scene.paint.Color.valueOf("#8a559b"));
//            }
//        }
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // Schedule the task to run every second
        while(true){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                        System.out.println("we are inside review");
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (isX) {
                            if (currentp1Index < player1Moves.size()) {
                                x = player1Moves.get(currentp1Index);
                                boxArray[x / 10][x % 10].setText("X");
                                currentp1Index++;
                            } else {
                                // Stop the executor when the array is fully iterated
                                //  executor.shutdown();
                            }
                        } else {
                            if (currentp2Index < player2Moves.size()) {
                                y = player2Moves.get(currentp2Index);
                                boxArray[y / 10][y % 10].setText("O");

                                currentp2Index++;
                            } else {
                            }
                        }
                        if (currentp1Index == playerMoves.size() && currentp2Index == playerMoves.size()) {
                            executor.shutdown();
                            //showDrawDialog('R');
                    //        gameRoomScreen.showDialog('X');
                      //      gameRoomScreen.resetGame();
                        }
                        isX = !isX;
                    }

                });
            }
        };

        executor.scheduleAtFixedRate(r, 1, 1, TimeUnit.SECONDS); // 0 seconds initial delay, 1 second interval
    }
      }
       private static void showDrawDialog(char c) {
       MessageController message = new MessageController();
        message.setWinner(c);
        Parent parent = new drawDialogBase(message);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
}
