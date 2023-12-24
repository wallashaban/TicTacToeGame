package ClientGame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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
import tictactoegame.connection.ClientConnection;
import tictactoegame.connection.Constants;
import tictactoegame.data.MessageController;
import tictactoegame.dialogs.PlayAgainDialogBase;
import tictactoegame.data.Move;

public class ClientGameScreenBase extends AnchorPane {

    private final Button[] buttons = new Button[9];
    Socket mySocket;
    DataInputStream in;
    PrintStream out;
    MessageController message;
    Move move; // need to handle get move from server 
    char t;
            Gson gson;
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

    private int player1Score = 0;
    private int player2Score = 0;
    private int tieScore = 0;
    private boolean playerTurn = true;
    private char playerSymbol = ' ';
    public ClientConnection connection = new ClientConnection();

    public ClientGameScreenBase() {

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
        getChildren().add(backImgae);
        getChildren().add(backImgae1);
        getChildren().add(backImgae11);
        getChildren().add(txtPlayr1TotalScore);
        getChildren().add(txtPlayr2TotalScore);
        getChildren().add(imgPlayer2);
        getChildren().add(imgPlayer1);

        buttons[0] = btn1;
        buttons[1] = btn2;
        buttons[2] = btn3;
        buttons[3] = btn4;
        buttons[4] = btn5;
        buttons[5] = btn6;
        buttons[6] = btn7;
        buttons[7] = btn8;
        buttons[8] = btn9;

        btnExit.setOnAction((ActionEvent event) -> {
            System.exit(0);
        }); // lmbada

        btnMin.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) btnMin.getScene().getWindow();
            stage.setIconified(true);
        });
        // btn bac
        // box(1 - 12 "10 = win" "11 = draw" "12 = lose")                   <<<<><><>>>>
        //and sign( X , O) // in case 10,11,12 will send sign (d or w or l) <<<<><><>>>>
        //I`m independ on input only avilable place
        //connection.connect();
        
        connect();
        
        out.println("after Conne");

        gson = new GsonBuilder().create();
        String msg;
        try {
            System.out.println("before msg");
            msg = in.readLine();
            System.out.println("after");

            Move m = gson.fromJson(msg, Move.class);
            
            if (m.getBox() == 0) {
                t = m.getSign();
                System.out.println("Player Sign is <><><><><> " + t);
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientGameScreenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        playGame();
    }

    private void playGame() {
        // resetBoard();
        player1Score = 0;
        player2Score = 0;
        tieScore = 0;       // drawScore
        updateScores();
        
        //playerSymbol = 'X'; // TODO<><><>Bougs
        
        playerTurn = true;

        for (int i = 0; i < 9; i++) {
            int index = i;
            buttons[i].setOnAction((ActionEvent event) -> onButtonClick(index));
        }
    }

       private void onButtonClick(int index) {
        if (playerTurn && buttons[index].getText() == " ") {
            if(t == 'x'){
                t = '0';
            buttons[index].setText("x");
            playerTurn = false;
            Move platerMove = new Move('x', index);
            Gson gson = new Gson();
            String moveJson = gson.toJson(platerMove);
            out.println(moveJson);
            } else {
                t = 'x';
                Move receivedMove = receiveFromServerMovementsAndStates();
               // Move movement = receiveFromServerMovementsAndStates();
                    switch (receivedMove.getSign()) {
                        case 'w':
                            showDialog('w');
                            break;
                        case 'l':
                            showDialog('l');
                            break;
                        case 'd':
                            showDialog('d');
                            break;
                        default:
                            buttons[receivedMove.getBox()].setText(receivedMove.getSign() + "");
                            playerTurn = true;
                            break;
                    }
            }
        }
    }
    
//    private void onButtonClick(int index, PrintStream out) {
//        if (playerTurn && buttons[index].getText() == " ") {
//            buttons[index].setText("x");
//            playerTurn = false;
//            //char myChar = playerSymbol;
//            //String symbol = String.valueOf(myChar);
//            //out.write(index); // send Move and recive Move
//            //out.flush(); // sent imediately
//            Move platerMove = new Move('x', index);
//            Gson gson = new Gson();
//            String moveJson = gson.toJson(platerMove);
//            connection.out.println(moveJson);
//
////            Gson gson = new Gson();
////            ArrayList jsonRequest = new ArrayList();
////            jsonRequest.add("update");
////            jsonRequest.add(platerMove);
//            //String gsonRequest = gson.toJson(jsonRequest);
//            
//            //connection.out.println(gsonRequest);
//            Move receivedMove = receiveFromServerMovementsAndStates();
//            Move movement = receiveFromServerMovementsAndStates();
//            switch (movement.getSign()) {
//                case 'w':
//                    showDialog('w');
//                    break;
//                case 'l':
//                    showDialog('l');
//                    break;
//                case 'd':
//                    showDialog('d');
//                    break;
//                default:
//                    //int move = in.readInt();
////                    Move opponeantMove = receiveFromServerMovementsAndStates();
//                    buttons[receivedMove.getBox()].setText(receivedMove.getSign() + "");
//                    playerTurn = true;
//                    break;
//                //}                //}
//            }
//        }
//    }

    private void updateScores() {
        txtPlay1Score.setText("" + player1Score);
        txtPlay2Score.setText(player2Score + "");
        btn9.setStyle("-fx-background-color: EACCD6; -fx-background-radius: 7;");
        txtTieScore.setText("" + tieScore);
    }

    private void highlightWinningCells(String player, int firstButton, int secondButton, int thirdButton) {
        String style = "-fx-text-fill: ";

        if (player.equals("X")) {
            style += "blue; -fx-font-weight: bold;";
        } else if (player.equals("O")) {
            style += "red; -fx-font-weight: bold;";
        }

        buttons[firstButton].setStyle(style);
        buttons[secondButton].setStyle(style);
        buttons[thirdButton].setStyle(style);
    }

    public int read() {
        return 0;
    }

    // ToDo <<<>>>
    public void sendToServerMovements() {
    }

    // ToDo <<<>>>
    public Move receiveFromServerMovementsAndStates() {
        try {
            //int code = in.readInt();
            //char sign = in.readChar();
            String receivedJson = in.readLine();
            
            return gson.fromJson(receivedJson, Move.class);
            //return new Move(sign, code);
        } catch (IOException e) {
            e.printStackTrace(); // case of a closed connection
            return null;
        }
    }

    private void showDialog(int code) {
        String result;
        switch (code) {
            case 10:
                result = "Winner";
                break;
            case 11:
                result = "Draw";
                break;
            case 12:
                result = "Loser"; // we need to handl dialog for loser <<<>>> TODO Bougs here
                break;
            default:
                result = "Unknown Result";
                break;
        }

        message = new MessageController();
        message.setWinner(result.charAt(0)); // Assuming the first character represents the result
        Parent parent = new PlayAgainDialogBase(message);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }

    public void connect() {
        try {
            System.out.println("test out");
            mySocket = new Socket(Constants.IP_ADDRESS, Constants.PORT);
            System.out.println("test1");
            in = new DataInputStream(mySocket.getInputStream());
            out = new PrintStream(mySocket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
//            showNoConnectionDialog();
        }
        //  startListening();
    }

    public void startListening() {
        new Thread(() -> {
            try {
                while (mySocket != null && !(mySocket.isClosed()) && in != null) {
                    String gsonResponse = in.readLine();
                    Gson gson = new GsonBuilder().create();
                    Move move = gson.fromJson(gsonResponse, Move.class);
//                    handleResponse(gsonResponse);
                }
            } catch (IOException ex) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
//                                showDisconnectedDialog();
                    }
                });
                Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }
    
}
