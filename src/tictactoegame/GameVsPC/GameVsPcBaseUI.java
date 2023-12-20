package tictactoegame.GameVsPC;

import tictactoegame.GameVsPC.*;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoegame.MessageController;
import tictactoegame.PlayAgainDialogBase;

public class GameVsPcBaseUI extends AnchorPane {
    
    MessageController message;
    protected final TextField txtfPlayer;
    protected final Label xAsLogoPlayer;
    protected final Label playerScore;
    protected final Label oAsLogoPlayer;
    protected final SplitMenuButton selectlvlSplitMenu;
    protected final MenuItem menuItem;
    protected final MenuItem menuItem0;
    protected final MenuItem menuItem1;
    protected final Lighting lighting;
    protected final Label pcScore;
    protected final Label tieScore;
    protected final Label tie;
    protected final Button btn0;
    protected final Lighting lighting0;
    protected final Button btn1;
    protected final Lighting lighting1;
    protected final Button btn2;
    protected final Lighting lighting2;
    protected final Button btn3;
    protected final Lighting lighting3;
    protected final Button btn4;
    protected final Lighting lighting4;
    protected final Button btn5;
    protected final Lighting lighting5;
    protected final Button btn6;
    protected final Lighting lighting6;
    protected final Button btn7;
    protected final Lighting lighting7;
    protected final Button btn8;
    protected final Lighting lighting8;
    protected final Line line;
    protected final Line line0;
    protected final Line line1;
    protected final Line line2;
    protected final Button btnExit;
    protected final Lighting lighting9;
    protected final Button btnMin;
    protected final Lighting lighting10;
    
    
    private final String[][] board = {{"-", "-", "-"},
                                      {"-", "-", "-"},
                                      {"-", "-", "-"}};
    
    private final Button[] buttons = new Button[9];

    private int player1Score = 0;
    private int player2Score = 0;
    private int drawScore = 0;
    private boolean playerTurn = true;

    public GameVsPcBaseUI() {

        txtfPlayer = new TextField();
        xAsLogoPlayer = new Label();
        playerScore = new Label();
        oAsLogoPlayer = new Label();
        selectlvlSplitMenu = new SplitMenuButton();
        menuItem = new MenuItem();
        menuItem0 = new MenuItem();
        menuItem1 = new MenuItem();
        lighting = new Lighting();
        pcScore = new Label();
        tieScore = new Label();
        tie = new Label();
        btn0 = new Button();
        lighting0 = new Lighting();
        btn1 = new Button();
        lighting1 = new Lighting();
        btn2 = new Button();
        lighting2 = new Lighting();
        btn3 = new Button();
        lighting3 = new Lighting();
        btn4 = new Button();
        lighting4 = new Lighting();
        btn5 = new Button();
        lighting5 = new Lighting();
        btn6 = new Button();
        lighting6 = new Lighting();
        btn7 = new Button();
        lighting7 = new Lighting();
        btn8 = new Button();
        lighting8 = new Lighting();
        line = new Line();
        line0 = new Line();
        line1 = new Line();
        line2 = new Line();
        btnExit = new Button();
        lighting9 = new Lighting();
        btnMin = new Button();
        lighting10 = new Lighting();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        getStyleClass().add("backgroundColor");
        getStylesheets().add("/tictactoegame/GameVsPC/BackGround.css");

        txtfPlayer.setLayoutX(46.0);
        txtfPlayer.setLayoutY(91.0);
        txtfPlayer.setPrefHeight(31.0);
        txtfPlayer.setPrefWidth(148.0);
        txtfPlayer.setPromptText("Enter Your Name!");

        xAsLogoPlayer.setLayoutX(14.0);
        xAsLogoPlayer.setLayoutY(76.0);
        xAsLogoPlayer.setPrefHeight(53.0);
        xAsLogoPlayer.setPrefWidth(20.0);
        xAsLogoPlayer.setText("X");
        xAsLogoPlayer.setTextFill(javafx.scene.paint.Color.valueOf("#8a559b"));
        xAsLogoPlayer.setFont(new Font("Serif Regular", 36.0));

        playerScore.setLayoutX(196.0);
        playerScore.setLayoutY(89.0);
        playerScore.setPrefHeight(35.0);
        playerScore.setPrefWidth(53.0);
        playerScore.setText("   0");
        playerScore.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerScore.setFont(new Font("System Bold", 24.0));

        oAsLogoPlayer.setLayoutX(756.0);
        oAsLogoPlayer.setLayoutY(78.0);
        oAsLogoPlayer.setPrefHeight(53.0);
        oAsLogoPlayer.setPrefWidth(30.0);
        oAsLogoPlayer.setText("O");
        oAsLogoPlayer.setTextFill(javafx.scene.paint.Color.valueOf("#db4f7e"));
        oAsLogoPlayer.setFont(new Font("Serif Regular", 36.0));

        selectlvlSplitMenu.setLayoutX(638.0);
        selectlvlSplitMenu.setLayoutY(91.0);
        selectlvlSplitMenu.setMnemonicParsing(false);
        selectlvlSplitMenu.setPrefHeight(31.0);
        selectlvlSplitMenu.setPrefWidth(109.0);
        selectlvlSplitMenu.setText("Select lvl");

        menuItem.setMnemonicParsing(false);
        menuItem.setText("Easy");

        menuItem0.setMnemonicParsing(false);
        menuItem0.setText("Medium");

        menuItem1.setMnemonicParsing(false);
        menuItem1.setText("Hard");
        selectlvlSplitMenu.setFont(new Font("System Bold", 14.0));

        lighting.setDiffuseConstant(1.46);
        lighting.setSpecularConstant(0.2);
        lighting.setSpecularExponent(0.0);
        lighting.setSurfaceScale(0.0);
        selectlvlSplitMenu.setEffect(lighting);

        pcScore.setLayoutX(578.0);
        pcScore.setLayoutY(89.0);
        pcScore.setPrefHeight(35.0);
        pcScore.setPrefWidth(59.0);
        pcScore.setText("  0");
        pcScore.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        pcScore.setFont(new Font("System Bold", 24.0));

        tieScore.setLayoutX(381.0);
        tieScore.setLayoutY(85.0);
        tieScore.setPrefHeight(31.0);
        tieScore.setPrefWidth(44.0);
        tieScore.setText("0");
        tieScore.setFont(new Font("System Bold", 24.0));

        tie.setLayoutX(373.0);
        tie.setLayoutY(48.0);
        tie.setPrefHeight(31.0);
        tie.setPrefWidth(44.0);
        tie.setText("Tie");
        tie.setTextFill(javafx.scene.paint.Color.WHITE);
        tie.setFont(new Font("Segoe UI Bold Italic", 24.0));

        btn0.setCancelButton(true);
        btn0.setLayoutX(151.0);
        btn0.setLayoutY(167.0);
        btn0.setMinHeight(130.0);
        btn0.setMinWidth(170.0);
        btn0.setMnemonicParsing(false);
        btn0.setText("-");

        lighting0.setDiffuseConstant(1.53);
        lighting0.setSpecularConstant(2.0);
        lighting0.setSpecularExponent(19.02);
        lighting0.setSurfaceScale(0.0);
        btn0.setEffect(lighting0);
        btn0.setFont(new Font("System Bold Italic", 48.0));

        btn1.setCancelButton(true);
        btn1.setLayoutX(321.0);
        btn1.setLayoutY(167.0);
        btn1.setMinHeight(130.0);
        btn1.setMinWidth(170.0);
        btn1.setMnemonicParsing(false);
        btn1.setText("-");

        lighting1.setDiffuseConstant(1.53);
        lighting1.setSpecularConstant(2.0);
        lighting1.setSpecularExponent(19.02);
        lighting1.setSurfaceScale(0.0);
        btn1.setEffect(lighting1);
        btn1.setFont(new Font("System Bold Italic", 48.0));

        btn2.setCancelButton(true);
        btn2.setLayoutX(491.0);
        btn2.setLayoutY(167.0);
        btn2.setMinHeight(130.0);
        btn2.setMinWidth(170.0);
        btn2.setMnemonicParsing(false);
        btn2.setText("-");

        lighting2.setDiffuseConstant(1.53);
        lighting2.setSpecularConstant(2.0);
        lighting2.setSpecularExponent(19.02);
        lighting2.setSurfaceScale(0.0);
        btn2.setEffect(lighting2);
        btn2.setFont(new Font("System Bold Italic", 48.0));

        btn3.setCancelButton(true);
        btn3.setLayoutX(151.0);
        btn3.setLayoutY(298.0);
        btn3.setMinHeight(130.0);
        btn3.setMinWidth(170.0);
        btn3.setMnemonicParsing(false);
        btn3.setText("-");

        lighting3.setDiffuseConstant(1.53);
        lighting3.setSpecularConstant(2.0);
        lighting3.setSpecularExponent(19.02);
        lighting3.setSurfaceScale(0.0);
        btn3.setEffect(lighting3);
        btn3.setFont(new Font("System Bold Italic", 48.0));

        btn4.setCancelButton(true);
        btn4.setLayoutX(321.0);
        btn4.setLayoutY(298.0);
        btn4.setMinHeight(130.0);
        btn4.setMinWidth(170.0);
        btn4.setMnemonicParsing(false);
        btn4.setText("-");

        lighting4.setDiffuseConstant(1.53);
        lighting4.setSpecularConstant(2.0);
        lighting4.setSpecularExponent(19.02);
        lighting4.setSurfaceScale(0.0);
        btn4.setEffect(lighting4);
        btn4.setFont(new Font("System Bold Italic", 48.0));

        btn5.setCancelButton(true);
        btn5.setLayoutX(491.0);
        btn5.setLayoutY(298.0);
        btn5.setMinHeight(130.0);
        btn5.setMinWidth(170.0);
        btn5.setMnemonicParsing(false);
        btn5.setText("-");

        lighting5.setDiffuseConstant(1.53);
        lighting5.setSpecularConstant(2.0);
        lighting5.setSpecularExponent(19.02);
        lighting5.setSurfaceScale(0.0);
        btn5.setEffect(lighting5);
        btn5.setFont(new Font("System Bold Italic", 48.0));

        btn6.setCancelButton(true);
        btn6.setLayoutX(151.0);
        btn6.setLayoutY(429.0);
        btn6.setMinHeight(130.0);
        btn6.setMinWidth(170.0);
        btn6.setMnemonicParsing(false);
        btn6.setText("-");

        lighting6.setDiffuseConstant(1.53);
        lighting6.setSpecularConstant(2.0);
        lighting6.setSpecularExponent(19.02);
        lighting6.setSurfaceScale(0.0);
        btn6.setEffect(lighting6);
        btn6.setFont(new Font("System Bold Italic", 48.0));

        btn7.setCancelButton(true);
        btn7.setLayoutX(321.0);
        btn7.setLayoutY(429.0);
        btn7.setMinHeight(130.0);
        btn7.setMinWidth(170.0);
        btn7.setMnemonicParsing(false);
        btn7.setText("-");

        lighting7.setDiffuseConstant(1.53);
        lighting7.setSpecularConstant(2.0);
        lighting7.setSpecularExponent(19.02);
        lighting7.setSurfaceScale(0.0);
        btn7.setEffect(lighting7);
        btn7.setFont(new Font("System Bold Italic", 48.0));

        btn8.setCancelButton(true);
        btn8.setLayoutX(491.0);
        btn8.setLayoutY(429.0);
        btn8.setMinHeight(130.0);
        btn8.setMinWidth(170.0);
        btn8.setMnemonicParsing(false);
        btn8.setText("-");

        lighting8.setDiffuseConstant(1.53);
        lighting8.setSpecularConstant(2.0);
        lighting8.setSpecularExponent(19.02);
        lighting8.setSurfaceScale(0.0);
        btn8.setEffect(lighting8);
        btn8.setFont(new Font("System Bold Italic", 48.0));

        line.setEndX(261.0);
        line.setLayoutX(400.0);
        line.setLayoutY(298.0);
        line.setStartX(-249.0);
        line.setStroke(javafx.scene.paint.Color.WHITE);
        line.setStrokeWidth(2.0);

        line0.setEndX(261.0);
        line0.setLayoutX(400.0);
        line0.setLayoutY(428.0);
        line0.setStartX(-249.0);
        line0.setStroke(javafx.scene.paint.Color.WHITE);
        line0.setStrokeWidth(2.0);

        line1.setEndX(-89.0);
        line1.setEndY(-141.0);
        line1.setLayoutX(410.0);
        line1.setLayoutY(308.0);
        line1.setStartX(-89.0);
        line1.setStartY(249.0);
        line1.setStroke(javafx.scene.paint.Color.WHITE);
        line1.setStrokeWidth(2.0);

        line2.setEndX(-89.0);
        line2.setEndY(-141.0);
        line2.setLayoutX(580.0);
        line2.setLayoutY(309.0);
        line2.setStartX(-89.0);
        line2.setStartY(249.0);
        line2.setStroke(javafx.scene.paint.Color.WHITE);
        line2.setStrokeWidth(2.0);

        btnExit.setCancelButton(true);
        btnExit.setLayoutX(747.0);
        btnExit.setLayoutY(14.0);
        btnExit.setMinHeight(35.0);
        btnExit.setMinWidth(36.0);
        btnExit.setMnemonicParsing(false);
        btnExit.setPrefHeight(35.0);
        btnExit.setPrefWidth(36.0);
        btnExit.setStyle("-fx-background-radius: 30;");
        btnExit.setText("X");

        lighting9.setDiffuseConstant(1.53);
        lighting9.setSpecularConstant(2.0);
        lighting9.setSpecularExponent(19.02);
        lighting9.setSurfaceScale(0.0);
        btnExit.setEffect(lighting9);
        btnExit.setFont(new Font("System Bold Italic", 18.0));

        btnMin.setCancelButton(true);
        btnMin.setLayoutX(702.0);
        btnMin.setLayoutY(14.0);
        btnMin.setMinHeight(35.0);
        btnMin.setMinWidth(36.0);
        btnMin.setMnemonicParsing(false);
        btnMin.setPrefHeight(35.0);
        btnMin.setPrefWidth(36.0);
        btnMin.setStyle("-fx-background-radius: 30;");
        btnMin.setText("-");

        lighting10.setDiffuseConstant(1.53);
        lighting10.setSpecularConstant(2.0);
        lighting10.setSpecularExponent(19.02);
        lighting10.setSurfaceScale(0.0);
        btnMin.setEffect(lighting10);
        btnMin.setFont(new Font("System Bold Italic", 18.0));

        getChildren().add(txtfPlayer);
        getChildren().add(xAsLogoPlayer);
        getChildren().add(playerScore);
        getChildren().add(oAsLogoPlayer);
        selectlvlSplitMenu.getItems().add(menuItem);
        selectlvlSplitMenu.getItems().add(menuItem0);
        selectlvlSplitMenu.getItems().add(menuItem1);
        getChildren().add(selectlvlSplitMenu);
        getChildren().add(pcScore);
        getChildren().add(tieScore);
        getChildren().add(tie);
        getChildren().add(btn0);
        getChildren().add(btn1);
        getChildren().add(btn2);
        getChildren().add(btn3);
        getChildren().add(btn4);
        getChildren().add(btn5);
        getChildren().add(btn6);
        getChildren().add(btn7);
        getChildren().add(btn8);
        getChildren().add(line);
        getChildren().add(line0);
        getChildren().add(line1);
        getChildren().add(line2);
        getChildren().add(btnExit);
        getChildren().add(btnMin);
        
        buttons[0] = btn0;
        buttons[1] = btn1;
        buttons[2] = btn2;
        buttons[3] = btn3;
        buttons[4] = btn4;
        buttons[5] = btn5;
        buttons[6] = btn6;
        buttons[7] = btn7;
        buttons[8] = btn8;
        
        btnExit.setOnAction((ActionEvent event) -> {System.exit(0);});
        
        btnMin.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) btnMin.getScene().getWindow();
            stage.setIconified(true);
        });
        
        playGame();
    }
    
        // Logic of plaing against PC ->
    private void playGame() {
        resetBoard();
        player1Score = 0;
        player2Score = 0;
        drawScore = 0;
        updateScores();
        playerTurn = true;

        for (int i = 0; i < 9; i++) {
            int index = i;
            buttons[i].setOnAction((ActionEvent event) -> onButtonClick(index));
        }
        /*
        splitMenuButton.setOnAction((event) -> {
            // TODO bougs here <<<>>> difficulty level is selected
        });
         */
    }

    
    private void onButtonClick(int index) {
        if(txtfPlayer.getText().length() > 3) {
            if (playerTurn && board[index / 3][index % 3].equals("-")) {
                buttons[index].setText("X");
                board[index / 3][index % 3] = "X";
                playerTurn = false;

                if (checkWin("X")) {
                    player1Score++;
                    updateScores();
                    resetBoard();
                } else if (isBoardFull()) {
                    drawScore++;
                    draw();
                    updateScores();
                    resetBoard();
                } else {
                    computerMove();
                }
            }
        } else {
            AlertDialog.showErrorMessage("Error: Please enter a name with at least 3 characters.", "Input Error");
        }
    }

    private void computerMove() {
        Random random = new Random();
        int row, col;

        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!board[row][col].equals("-"));

        buttons[row * 3 + col].setText("O");
        board[row][col] = "O";
        playerTurn = true;

        if (checkWin("O")) {
            player2Score++;
            updateScores();
            resetBoard();
        } else if (isBoardFull()) {
            drawScore++;
            updateScores();
            draw();
            resetBoard();
        }
    }

    private boolean checkWin(String player) {
        boolean state = false;
        for (int i = 0; i < 3; i++) {
            // check rows
            if (board[i][0].equals(player)
                    && board[i][1].equals(player)
                    && board[i][2].equals(player)) {

                highlightWinningCells(player, i * 3 + 0, i * 3 + 1, i * 3 + 2);
                char playerChar = player.charAt(0);

                showDialog(playerChar);
                state = true;
                break;
            } //             check columns
            else if (board[0][i].equals(player)
                    && board[1][i].equals(player)
                    && board[2][i].equals(player)) {

                highlightWinningCells(player, i + (3 * 0), i + (3 * +1), i + (3 * 2));
                char playerChar = player.charAt(0);

                showDialog(playerChar);
                state = true;
                break;
            }
        }
//         check diagnaols
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            highlightWinningCells(player, 0, 4, 8);

            char playerChar = player.charAt(0);
            showDialog(playerChar);
            state = true;
        } else if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            highlightWinningCells(player, 2, 4, 6);
           
            char playerChar = player.charAt(0);
            showDialog(playerChar);

            state = true;
        }
        
        return state;
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

    private void showDialog(char winner) {
        message = new MessageController();
        message.setWinner(winner);
        Parent parent = new PlayAgainDialogBase(message);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }

    void draw() {
        showDialog('D');
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void updateScores() {
        playerScore.setText("" + player1Score);
        pcScore.setText(player2Score + "");
        tieScore.setText("" + drawScore);
    }

    private void resetBoard() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("-");
            buttons[i].setStyle("-fx-font: bold 36.0 'System';");
            playerTurn = true;
            int row = i / 3;
            int col = i % 3;
            board[row][col] = "-";
        }
    }  
    
    private void replay() {
        // ToDo <<<>>> Bougs here anos
    }
}