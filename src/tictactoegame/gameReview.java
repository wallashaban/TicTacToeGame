/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private static int currentp1Index;
    private static int currentp2Index;
    private static int x;
    private static int y;
    private static boolean isX;
              

      public static void review(GameRoomScreen gameRoomScreen,Label[][] boxArray ,ArrayList<Integer> player1Moves,ArrayList<Integer> player2Moves) {
        System.out.println("we are inside review");
        isX = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //boxEnabled[i][j] = true;
                boxArray[i][j].setText(" ");
                boxArray[i][j].setTextFill(javafx.scene.paint.Color.valueOf("#8a559b"));
            }
        }
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // Schedule the task to run every second
        while(true){
        Runnable r = new Runnable() {
            @Override
            public void run() {
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
                        if (currentp1Index == player1Moves.size() && currentp2Index == player2Moves.size()) {
                            executor.shutdown();
                            //showDrawDialog('R');
                            gameRoomScreen.showDialog('X');
                            gameRoomScreen.resetGame();
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
