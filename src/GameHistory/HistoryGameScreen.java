package GameHistory;

import ClientGame.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoegame.HistoryScreen;
import tictactoegame.MainScreen.MainScreenUI;
import tictactoegame.connection.ClientConnection;
import tictactoegame.connection.Constants;
import tictactoegame.data.Move;
import tictactoegame.gameReview;

public class HistoryGameScreen extends AnchorPane {
     private  int currentp1Index;
    private  int currentp2Index;
    private  int x;
    private  int y;
    private  boolean isX;

    private final Button[] buttons = new Button[9];
    private char currentPlayerSymbol = 'z';
    protected final Button[][] boxArray;
    final int col0 = 2;
    final int col1 = 3;
    final int col2 = 4;
    final int row0 = 5;
    final int row1 = 6;
    final int row2 = 7;
    final int diagonalLeft = 0;
    final int diagonalRight = 1;
    int i;
    int j;

    protected final Button btnExit;
    protected final Button btnMin;
    protected final Label txtPlay1Name;
    protected final Label txtPlay2Name;
    protected final Label txtplayer2Type;
    protected final Label txtplayer1Type;
    protected final Label txtTie;
    protected final Label txtTieScore;
    protected final Label txtPlay1Score;
    protected final Label txtPlay2Score;
    protected final Button btn1;
    protected final Button btn2;
    protected final Button btn3;
    protected final Button btn4;
    protected final Button btn5;
    protected final Button btn6;
    protected final Button btn7;
    protected final Button btn8;
    protected final Button btn9;
    protected final Line line;
    protected final Line line0;
    protected final Line line1;
    protected final Line line2;
    protected final ImageView backImgae;
    protected final ImageView backImgae1;
    protected final ImageView backImgae11;
    protected final Label txtPlayr1TotalScore;
    protected final Label txtPlayr2TotalScore;
    protected final ImageView imgPlayer2;
    protected final ImageView imgPlayer1;
        protected final Button buttonBack;


    private int player1Score = 0;
    private int player2Score = 0;
    private int tieScore = 0;

    private boolean isInitialPlayer = false;
    private boolean playerTurn;
  ArrayList<Integer> player1Moves;
    ArrayList<Integer> player2Moves;
    public HistoryGameScreen(ArrayList<Integer> playerMoves) {

        btnExit = new Button();
        btnMin = new Button();
        txtPlay1Name = new Label();
        txtPlay2Name = new Label();
        txtplayer2Type = new Label();
        txtplayer1Type = new Label();
        txtTie = new Label();
        txtTieScore = new Label();
        txtPlay1Score = new Label();
        txtPlay2Score = new Label();
        btn1 = new Button();
        btn2 = new Button();
        btn3 = new Button();
        btn4 = new Button();
        btn5 = new Button();
        btn6 = new Button();
        btn7 = new Button();
        btn8 = new Button();
        btn9 = new Button();
        boxArray = new Button[3][3];
         player1Moves = new ArrayList<>();
          player2Moves = new ArrayList<>();

        boxArray[0][0] = btn1;
        boxArray[0][1] = btn2;
        boxArray[0][2] = btn3;
        boxArray[1][0] = btn4;
        boxArray[1][1] = btn5;
        boxArray[1][2] = btn6;
        boxArray[2][0] = btn7;
        boxArray[2][1] = btn8;
        boxArray[2][2] = btn9;
        line = new Line();
        line0 = new Line();
        line1 = new Line();
        line2 = new Line();
        backImgae = new ImageView();
        backImgae1 = new ImageView();
        backImgae11 = new ImageView();
        txtPlayr1TotalScore = new Label();
        txtPlayr2TotalScore = new Label();
        imgPlayer2 = new ImageView();
        imgPlayer1 = new ImageView();
                buttonBack = new Button();

        setId("AnchorPane");
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        getStyleClass().add("backgroundColor");
        getStylesheets().add("/ClientGame/BackGround.css");

        btnExit.setLayoutX(753.0);
        btnExit.setLayoutY(11.0);
        btnExit.setMnemonicParsing(false);
        btnExit.setStyle("-fx-background-color: EACCD6; -fx-background-radius: 20;");
        btnExit.setText("X");
        btnExit.setFont(new Font("System Bold", 18.0));

        btnMin.setLayoutX(714.0);
        btnMin.setLayoutY(11.0);
        btnMin.setMnemonicParsing(false);
        btnMin.setStyle("-fx-background-color: EACCD6; -fx-background-radius: 20;");
        btnMin.setText("-");
        btnMin.setFont(new Font("System Bold", 18.0));
        
         buttonBack.setLayoutX(15.0);
        buttonBack.setLayoutY(7.0);
        buttonBack.setMnemonicParsing(false);
        buttonBack.setStyle("-fx-background-color: e8ccd5; -fx-background-radius: 30;");
        buttonBack.setText("<");
        buttonBack.setFont(new Font("Gill Sans MT Bold Italic", 19.0));
       // setTop(pane);
        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Parent root = new HistoryScreen();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });

        txtPlay1Name.setLayoutX(648.0);
        txtPlay1Name.setLayoutY(91.0);
        txtPlay1Name.setPrefHeight(22.0);
        txtPlay1Name.setPrefWidth(111.0);
        txtPlay1Name.setText("             Tom");
        txtPlay1Name.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        txtPlay1Name.setFont(new Font("Impact", 18.0));

        txtPlay2Name.setLayoutX(51.0);
        txtPlay2Name.setLayoutY(91.0);
        txtPlay2Name.setText("            jerry");
        txtPlay2Name.setFont(new Font("Impact", 18.0));

        txtplayer2Type.setLayoutX(28.0);
        txtplayer2Type.setLayoutY(80.0);
        txtplayer2Type.setText("x");
        txtplayer2Type.setTextFill(javafx.scene.paint.Color.valueOf("#8a559b"));
        txtplayer2Type.setFont(new Font("Impact", 36.0));

        txtplayer1Type.setLayoutX(763.0);
        txtplayer1Type.setLayoutY(80.0);
        txtplayer1Type.setText("O");
        txtplayer1Type.setTextFill(javafx.scene.paint.Color.valueOf("#db4f7e"));
        txtplayer1Type.setFont(new Font("Impact", 36.0));

        txtTie.setLayoutX(391.0);
        txtTie.setLayoutY(46.0);
        txtTie.setText("Tie");
        txtTie.setTextFill(javafx.scene.paint.Color.WHITE);
        txtTie.setFont(new Font("Impact", 24.0));

        txtTieScore.setLayoutX(400.0);
        txtTieScore.setLayoutY(81.0);
        txtTieScore.setText("0");
        txtTieScore.setTextFill(javafx.scene.paint.Color.WHITE);
        txtTieScore.setFont(new Font("Impact", 24.0));

        txtPlay1Score.setLayoutX(618.0);
        txtPlay1Score.setLayoutY(88.0);
        txtPlay1Score.setText("0");
        txtPlay1Score.setTextFill(javafx.scene.paint.Color.WHITE);
        txtPlay1Score.setFont(new Font("Impact", 24.0));

        txtPlay2Score.setLayoutX(168.0);
        txtPlay2Score.setLayoutY(88.0);
        txtPlay2Score.setText("0");
        txtPlay2Score.setTextFill(javafx.scene.paint.Color.WHITE);
        txtPlay2Score.setFont(new Font("Impact", 24.0));

        btn1.setLayoutX(148.0);
        btn1.setLayoutY(171.0);
        btn1.setMnemonicParsing(false);
        btn1.setPrefHeight(116.0);
        btn1.setPrefWidth(174.0);
        btn1.setStyle("-fx-background-color: EACCD6; -fx-background-radius: 7;");
        btn1.setText(" ");
        btn1.setFont(new Font("System Bold Italic", 36.0));

        btn2.setLayoutX(326.0);
        btn2.setLayoutY(171.0);
        btn2.setMnemonicParsing(false);
        btn2.setPrefHeight(116.0);
        btn2.setPrefWidth(174.0);
        btn2.setStyle("-fx-background-color: EACCD6; -fx-background-radius: 7;");
        btn2.setText(" ");
        btn2.setFont(new Font("System Bold Italic", 36.0));

        btn3.setLayoutX(502.0);
        btn3.setLayoutY(171.0);
        btn3.setMnemonicParsing(false);
        btn3.setPrefHeight(116.0);
        btn3.setPrefWidth(174.0);
        btn3.setStyle("-fx-background-color: EACCD6; -fx-background-radius: 7;");
        btn3.setText(" ");
        btn3.setFont(new Font("System Bold Italic", 36.0));

        btn4.setLayoutX(148.0);
        btn4.setLayoutY(292.0);
        btn4.setMnemonicParsing(false);
        btn4.setPrefHeight(116.0);
        btn4.setPrefWidth(174.0);
        btn4.setStyle("-fx-background-color: EACCD6; -fx-background-radius: 7;");
        btn4.setText(" ");
        btn4.setFont(new Font("System Bold Italic", 36.0));

        btn5.setLayoutX(326.0);
        btn5.setLayoutY(292.0);
        btn5.setMnemonicParsing(false);
        btn5.setPrefHeight(116.0);
        btn5.setPrefWidth(174.0);
        btn5.setStyle("-fx-background-color: EACCD6; -fx-background-radius: 7;");
        btn5.setText(" ");
        btn5.setFont(new Font("System Bold Italic", 36.0));

        btn6.setLayoutX(503.0);
        btn6.setLayoutY(292.0);
        btn6.setMnemonicParsing(false);
        btn6.setPrefHeight(116.0);
        btn6.setPrefWidth(174.0);
        btn6.setStyle("-fx-background-color: EACCD6; -fx-background-radius: 7;");
        btn6.setText(" ");
        btn6.setFont(new Font("System Bold Italic", 36.0));

        btn7.setLayoutX(148.0);
        btn7.setLayoutY(413.0);
        btn7.setMnemonicParsing(false);
        btn7.setPrefHeight(116.0);
        btn7.setPrefWidth(174.0);
        btn7.setStyle("-fx-background-color: EACCD6; -fx-background-radius: 7;");
        btn7.setText(" ");
        btn7.setFont(new Font("System Bold Italic", 36.0));

        btn8.setLayoutX(325.0);
        btn8.setLayoutY(413.0);
        btn8.setMnemonicParsing(false);
        btn8.setPrefHeight(116.0);
        btn8.setPrefWidth(174.0);
        btn8.setStyle("-fx-background-color: EACCD6; -fx-background-radius: 7;");
        btn8.setText(" ");
        btn8.setFont(new Font("System Bold Italic", 36.0));

        btn9.setLayoutX(503.0);
        btn9.setLayoutY(413.0);
        btn9.setMnemonicParsing(false);
        btn9.setPrefHeight(116.0);
        btn9.setPrefWidth(174.0);
        btn9.setStyle("-fx-background-color: EACCD6; -fx-background-radius: 7;");
        btn9.setText(" ");
        btn9.setFont(new Font("System Bold Italic", 36.0));

        line.setEndX(-100.0);
        line.setEndY(358.0);
        line.setLayoutX(424.0);
        line.setLayoutY(171.0);
        line.setStartX(-100.0);
        line.setStroke(javafx.scene.paint.Color.WHITE);
        line.setStrokeWidth(3.0);

        line0.setEndX(-100.0);
        line0.setEndY(356.0);
        line0.setLayoutX(600.0);
        line0.setLayoutY(173.0);
        line0.setStartX(-100.0);
        line0.setStroke(javafx.scene.paint.Color.WHITE);
        line0.setStrokeWidth(3.0);

        line1.setEndX(65.0);
        line1.setEndY(111.0);
        line1.setLayoutX(610.0);
        line1.setLayoutY(179.0);
        line1.setStartX(-459.0);
        line1.setStartY(111.0);
        line1.setStroke(javafx.scene.paint.Color.WHITE);
        line1.setStrokeWidth(3.0);

        line2.setEndX(66.0);
        line2.setEndY(111.0);
        line2.setLayoutX(610.0);
        line2.setLayoutY(300.0);
        line2.setStartX(-459.0);
        line2.setStartY(111.0);
        line2.setStroke(javafx.scene.paint.Color.WHITE);
        line2.setStrokeWidth(3.0);

        backImgae.setFitHeight(45.0);
        backImgae.setFitWidth(62.0);
        backImgae.setLayoutX(22.0);
        backImgae.setLayoutY(14.0);
        backImgae.setPickOnBounds(true);
        backImgae.setPreserveRatio(true);
        backImgae.setImage(new Image(getClass().getResource("/images/left.png").toExternalForm()));

        backImgae1.setFitHeight(29.0);
        backImgae1.setFitWidth(30.0);
        backImgae1.setLayoutX(127.0);
        backImgae1.setLayoutY(117.0);
        backImgae1.setPickOnBounds(true);
        backImgae1.setPreserveRatio(true);
        backImgae1.setImage(new Image(getClass().getResource("/images/1840745.png").toExternalForm()));

        backImgae11.setFitHeight(29.0);
        backImgae11.setFitWidth(30.0);
        backImgae11.setLayoutX(648.0);
        backImgae11.setLayoutY(117.0);
        backImgae11.setPickOnBounds(true);
        backImgae11.setPreserveRatio(true);
        backImgae11.setImage(new Image(getClass().getResource("/images/1840745.png").toExternalForm()));

        txtPlayr1TotalScore.setLayoutX(692.0);
        txtPlayr1TotalScore.setLayoutY(117.0);
        txtPlayr1TotalScore.setText("7777");
        txtPlayr1TotalScore.setTextFill(javafx.scene.paint.Color.WHITE);
        txtPlayr1TotalScore.setFont(new Font("Cambria Bold", 24.0));

        txtPlayr2TotalScore.setLayoutX(67.0);
        txtPlayr2TotalScore.setLayoutY(117.0);
        txtPlayr2TotalScore.setText("7777");
        txtPlayr2TotalScore.setTextFill(javafx.scene.paint.Color.WHITE);
        txtPlayr2TotalScore.setFont(new Font("Cambria Bold", 24.0));

        imgPlayer2.setFitHeight(106.0);
        imgPlayer2.setFitWidth(94.0);
        imgPlayer2.setLayoutX(188.0);
        imgPlayer2.setLayoutY(49.0);
        imgPlayer2.setPickOnBounds(true);
        imgPlayer2.setPreserveRatio(true);
        imgPlayer2.setImage(new Image(getClass().getResource("/images/klipartz.com.png").toExternalForm()));

        imgPlayer1.setFitHeight(106.0);
        imgPlayer1.setFitWidth(94.0);
        imgPlayer1.setLayoutX(516.0);
        imgPlayer1.setLayoutY(49.0);
        imgPlayer1.setPickOnBounds(true);
        imgPlayer1.setPreserveRatio(true);
        imgPlayer1.setImage(new Image(getClass().getResource("/images/Tom.png").toExternalForm()));

        getChildren().add(btnExit);
        getChildren().add(btnMin);
        getChildren().add(txtPlay1Name);
        getChildren().add(txtPlay2Name);
        getChildren().add(txtplayer2Type);
        getChildren().add(txtplayer1Type);
        getChildren().add(txtTie);
        getChildren().add(txtTieScore);
        getChildren().add(txtPlay1Score);
        getChildren().add(txtPlay2Score);
        getChildren().add(btn1);
        getChildren().add(btn2);
        getChildren().add(btn3);
        getChildren().add(btn4);
        getChildren().add(btn5);
        getChildren().add(btn6);
        getChildren().add(btn7);
        getChildren().add(btn8);
        getChildren().add(btn9);
        getChildren().add(line);
        getChildren().add(line0);
        getChildren().add(line1);
        getChildren().add(line2);
    //    getChildren().add(backImgae);
        getChildren().add(backImgae1);
        getChildren().add(backImgae11);
        getChildren().add(txtPlayr1TotalScore);
        getChildren().add(txtPlayr2TotalScore);
        getChildren().add(imgPlayer2);
        getChildren().add(imgPlayer1);
        getChildren().add(buttonBack);

        buttons[0] = btn1;
        buttons[1] = btn2;
        buttons[2] = btn3;
        buttons[3] = btn4;
        buttons[4] = btn5;
        buttons[5] = btn6;
        buttons[6] = btn7;
        buttons[7] = btn8;
        buttons[8] = btn9;
        
       review(playerMoves);
       
        btnExit.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });

        btnMin.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) btnMin.getScene().getWindow();
            stage.setIconified(true);
        });

    }
     private void review(ArrayList<Integer> playerMoves) {
        System.out.println("we are inside review");
        isX = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //boxEnabled[i][j] = true;
                boxArray[i][j].setText(" ");
                boxArray[i][j].setTextFill(javafx.scene.paint.Color.valueOf("#8a559b"));
            }
        }
        

          for(int k=0;k<playerMoves.size();k+=2){
          player1Moves.add(playerMoves.get(k));
          }
          for(int k=1;k<playerMoves.size();k+=2){
          player2Moves.add(playerMoves.get(k));
          }
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // Schedule the task to run every second

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
                                // Stop the executor when the array is fully iterated
                                //   executor.shutdown();
                            }
                        }
                        if (currentp1Index == player1Moves.size() && currentp2Index == player2Moves.size()) {
                            executor.shutdown();
                            //showDrawDialog('R');
                        }
                        isX = !isX;
                    }

                });
            }
        };

        executor.scheduleAtFixedRate(r, 1, 1, TimeUnit.SECONDS); // 0 seconds initial delay, 1 second interval
    }
}
