package tictactoegame;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameRoomDesignBase extends BorderPane {

    protected boolean isX = true;
    protected char[][] matrix;  // remove it later
    protected int player1Cases[];
    protected int player2Cases[];
    protected int playerCases[][];
    int[] winnerData;
    final int diagonalLeft = 0;
    final int diagonalRight = 1;
    final int col0 = 2;
    final int col1 = 3;
    final int col2 = 4;
    final int row0 = 5;
    final int row1 = 6;
    final int row2 = 7;
    protected final Label[][] boxArray; // array that hold the 9 labels
    protected final boolean[][] boxEnabled; // array that hold enablle or disable to labels

    ArrayList<Integer> player1Moves;
    ArrayList<Integer> player2Moves;
    int player1ScoreCount = 0;
    int player2ScoreCount = 0;
    int movesCount = 0; // sum of moves 
    MessageController message;
    protected final AnchorPane topAncherPane;
    protected final FlowPane Player1View;

    protected final ImageView menuIcon;
    protected final ImageView player1Image;
    protected final FlowPane player1NameAndScoreView;
    protected final Label player1Name;
    protected final FlowPane scoreAndStarImageView;
    protected Label Player1Score;
    protected final ImageView starImage;
    protected final Label player1Sign;
    protected final FlowPane sessionScore;
    protected final Label player1SessionScore;
    protected final Label dash;
    protected final Label player2SessionScore;
    protected final FlowPane Player2View;
    protected final Label player2Sign;
    protected final FlowPane player2NameAndScoreView;
    protected final Label player2Name;
    protected final FlowPane player2ScoreAndStarView;
    protected Label player2Score;
    protected final ImageView Star2Image;
    protected final ImageView player2Image;
    protected final GridPane gameView;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Label box00;
    protected final Label box22;
    protected final Label box21;
    protected final Label box20;
    protected final Label box10;
    protected final Label box11;
    protected final Label box12;
    protected final Label box01;
    protected final Label box02;

    int currentp1Index;
    int currentp2Index;
    int x;
    int y;

    public GameRoomDesignBase() {
        currentp1Index = 0;
        currentp2Index = 0;

        message = new MessageController();
        matrix = new char[3][3];
        boxArray = new Label[3][3];
        player1Moves = new ArrayList<Integer>();
        player2Moves = new ArrayList<Integer>();
        boxEnabled = new boolean[3][3];
        playerCases = new int[2][8];
        winnerData = new int[2];
        topAncherPane = new AnchorPane();
        Player1View = new FlowPane();
        menuIcon = new ImageView();
        player1Image = new ImageView();
        player1NameAndScoreView = new FlowPane();
        player1Name = new Label();
        scoreAndStarImageView = new FlowPane();
        Player1Score = new Label();
        starImage = new ImageView();
        player1Sign = new Label();
        sessionScore = new FlowPane();
        player1SessionScore = new Label();
        dash = new Label();
        player2SessionScore = new Label();
        Player2View = new FlowPane();
        player2Sign = new Label();
        player2NameAndScoreView = new FlowPane();
        player2Name = new Label();
        player2ScoreAndStarView = new FlowPane();
        player2Score = new Label();
        Star2Image = new ImageView();
        player2Image = new ImageView();
        gameView = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        box00 = new Label();
        box22 = new Label();
        box21 = new Label();
        box20 = new Label();
        box10 = new Label();
        box11 = new Label();
        box12 = new Label();
        box01 = new Label();
        box02 = new Label();
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(1024.0);
        setPrefWidth(1440.0);
        setStyle("-fx-background-color: ffffff;");

        BorderPane.setAlignment(topAncherPane, javafx.geometry.Pos.CENTER);
        topAncherPane.setPrefHeight(140.0);
        topAncherPane.setPrefWidth(1440.0);
        topAncherPane.setStyle("-fx-background-color: fefdfc;");

        AnchorPane.setLeftAnchor(Player1View, 10.0);
        Player1View.setPrefHeight(160.0);
        Player1View.setPrefWidth(556.0);

        menuIcon.setFitHeight(96.0);
        menuIcon.setFitWidth(96.0);
        menuIcon.setPickOnBounds(true);
        menuIcon.setPreserveRatio(true);
//        menuIcon.setImage(new Image(getClass().getResource("images/menu.png").toExternalForm()));

        player1Image.setFitHeight(100.0);
        player1Image.setFitWidth(100.0);
        player1Image.setPickOnBounds(true);
        player1Image.setPreserveRatio(true);
//        player1Image.setImage(new Image(getClass().getResource("images/332116278_1280755552796980_7935683117072368396_n.jpg").toExternalForm()));
        FlowPane.setMargin(player1Image, new Insets(0.0, 0.0, 0.0, 10.0));

        player1NameAndScoreView.setOrientation(javafx.geometry.Orientation.VERTICAL);
        player1NameAndScoreView.setPrefHeight(138.0);
        player1NameAndScoreView.setPrefWidth(293.0);

        player1Name.setText("Ahmed Ghoneim");
        player1Name.setTextFill(javafx.scene.paint.Color.valueOf("#5a5a5a"));
        player1Name.setFont(new Font("Arial Bold", 36.0));
        FlowPane.setMargin(player1Name, new Insets(44.0, 0.0, 0.0, 0.0));

        scoreAndStarImageView.setPrefHeight(52.0);
        scoreAndStarImageView.setPrefWidth(289.0);
        scoreAndStarImageView.setPrefWrapLength(0.0);

        Player1Score.setGraphicTextGap(0.0);
        Player1Score.setText("690");
        Player1Score.setFont(new Font("Arial Black", 24.0));

        starImage.setFitHeight(52.0);
        starImage.setFitWidth(52.0);
        starImage.setPickOnBounds(true);
        starImage.setPreserveRatio(true);
        FlowPane.setMargin(starImage, new Insets(0.0, 0.0, 0.0, 10.0));
//        starImage.setImage(new Image(getClass().getResource("images/1840745.png").toExternalForm()));
        FlowPane.setMargin(player1NameAndScoreView, new Insets(0.0, 0.0, 0.0, 5.0));

        player1Sign.setText("O");
        player1Sign.setTextFill(javafx.scene.paint.Color.valueOf("#eb8fb4"));
        player1Sign.setFont(new Font("Arial Bold", 50.0));

        AnchorPane.setLeftAnchor(sessionScore, 610.0);
        AnchorPane.setRightAnchor(sessionScore, 610.0);
        AnchorPane.setTopAnchor(sessionScore, 0.0);
        sessionScore.setAlignment(javafx.geometry.Pos.CENTER);
        sessionScore.setColumnHalignment(javafx.geometry.HPos.CENTER);
        sessionScore.setHgap(50.0);
        sessionScore.setPrefHeight(122.0);
        sessionScore.setPrefWidth(220.0);

        player1SessionScore.setText("0");
        player1SessionScore.setTextFill(javafx.scene.paint.Color.valueOf("#5a5a5a"));
        player1SessionScore.setFont(new Font("Arial Bold", 50.0));

        dash.setText("-");
        dash.setTextFill(javafx.scene.paint.Color.valueOf("#5a5a5a"));
        dash.setFont(new Font("Arial Bold", 50.0));

        player2SessionScore.setText("0");
        player2SessionScore.setTextFill(javafx.scene.paint.Color.valueOf("#5a5a5a"));
        player2SessionScore.setFont(new Font("Arial Bold", 50.0));

        AnchorPane.setRightAnchor(Player2View, 10.0);
        Player2View.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
        Player2View.setColumnHalignment(javafx.geometry.HPos.RIGHT);
        Player2View.setPrefHeight(132.0);
        Player2View.setPrefWidth(512.0);

        player2Sign.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        player2Sign.setContentDisplay(javafx.scene.control.ContentDisplay.RIGHT);
        player2Sign.setText("X");
        player2Sign.setTextFill(javafx.scene.paint.Color.valueOf("#94cbf0"));
        player2Sign.setFont(new Font("Arial Bold", 50.0));

        player2NameAndScoreView.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
        player2NameAndScoreView.setColumnHalignment(javafx.geometry.HPos.RIGHT);
        player2NameAndScoreView.setOrientation(javafx.geometry.Orientation.VERTICAL);
        player2NameAndScoreView.setPrefHeight(138.0);
        player2NameAndScoreView.setPrefWidth(343.0);

        player2Name.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        player2Name.setPrefHeight(0.0);
        player2Name.setPrefWidth(335.0);
        player2Name.setText("Mohamed Ghoneim");
        player2Name.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        player2Name.setTextFill(javafx.scene.paint.Color.valueOf("#5a5a5a"));
        player2Name.setFont(new Font("Arial Bold", 36.0));
        FlowPane.setMargin(player2Name, new Insets(44.0, 0.0, 0.0, 5.0));

        player2ScoreAndStarView.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
        player2ScoreAndStarView.setColumnHalignment(javafx.geometry.HPos.RIGHT);
        player2ScoreAndStarView.setPrefHeight(52.0);
        player2ScoreAndStarView.setPrefWidth(205.0);
        player2ScoreAndStarView.setPrefWrapLength(0.0);

        player2Score.setGraphicTextGap(0.0);
        player2Score.setPrefHeight(22.0);
        player2Score.setPrefWidth(49.0);
        player2Score.setText("690");
        player2Score.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        player2Score.setFont(new Font("Arial Black", 24.0));

        Star2Image.setFitHeight(52.0);
        Star2Image.setFitWidth(52.0);
        Star2Image.setPickOnBounds(true);
        Star2Image.setPreserveRatio(true);
        FlowPane.setMargin(Star2Image, new Insets(0.0, 0.0, 0.0, 10.0));
//        Star2Image.setImage(new Image(getClass().getResource("images/1840745.png").toExternalForm()));
        FlowPane.setMargin(player2ScoreAndStarView, new Insets(0.0));
        FlowPane.setMargin(player2NameAndScoreView, new Insets(0.0));

        player2Image.setFitHeight(100.0);
        player2Image.setFitWidth(100.0);
        player2Image.setNodeOrientation(javafx.geometry.NodeOrientation.RIGHT_TO_LEFT);
        player2Image.setPickOnBounds(true);
        player2Image.setPreserveRatio(true);
//        player2Image.setImage(new Image(getClass().getResource("images/39467269_2158747357747944_2865808226652258304_n.jpg").toExternalForm()));
        FlowPane.setMargin(player2Image, new Insets(0.0, 0.0, 0.0, 5.0));
        setTop(topAncherPane);

        BorderPane.setAlignment(gameView, javafx.geometry.Pos.CENTER);
        gameView.setAlignment(javafx.geometry.Pos.CENTER);
        gameView.setGridLinesVisible(true);
        gameView.setMaxHeight(800.0);
        gameView.setMaxWidth(800.0);
        gameView.setPrefHeight(800.0);
        gameView.setPrefWidth(800.0);
        gameView.setStyle("-fx-background-color: transparent; -fx-border-color: 111111; -fx-background-radius: 30; -fx-border-radius: 30; -fx-border-width: 10; -fx-border-style: solid; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(box00, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(box00, javafx.geometry.VPos.CENTER);
        box00.setAlignment(javafx.geometry.Pos.CENTER);
        box00.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        box00.setMinHeight(265.0);
        box00.setMinWidth(265.0);
        box00.setText(" ");
        box00.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box00.setFont(new Font("Arial Bold", 100.0));

        boxArray[0][0] = box00;
        boxArray[0][1] = box01;
        boxArray[0][2] = box02;
        boxArray[1][0] = box10;
        boxArray[1][1] = box11;
        boxArray[1][2] = box12;
        boxArray[2][0] = box20;
        boxArray[2][1] = box21;
        boxArray[2][2] = box22;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int finalI = i;
                final int finalJ = j;
                boxEnabled[i][j] = true;

                boxArray[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        if (boxEnabled[finalI][finalJ]) {
                            if (isX) {
                                boxArray[finalI][finalJ].setText("X");
                                player1Moves.add((finalI * 10) + finalJ);

                            } else {
                                boxArray[finalI][finalJ].setText("O");
                                player2Moves.add((finalI * 10) + finalJ);

                            }
                            updateCases(finalI, finalJ);
                            movesCount++;
                            if (movesCount >= 5) {
                                winnerData = checkWinner();
                                if (winnerData[0] == 0) {
                                    player1ScoreCount++;
                                    disableLabels();
                                    //    celebrateWinner(winnerData[1]);
                                    updateScore();
                                    review();

                                } else {
                                    if (winnerData[0] == 1) {
                                        player2ScoreCount++;
                                        disableLabels();
                                        //    celebrateWinner(winnerData[1]);
                                        updateScore();
                                        review();
                                    }
                                }
                            }
                            isX = !isX;
                            boxEnabled[finalI][finalJ] = false;
                        }
                    }
                });
            }
        }

        GridPane.setColumnIndex(box22, 2);
        GridPane.setHalignment(box22, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(box22, 2);
        GridPane.setValignment(box22, javafx.geometry.VPos.CENTER);
        box22.setAlignment(javafx.geometry.Pos.CENTER);
        box22.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        box22.setMinHeight(265.0);
        box22.setMinWidth(265.0);
        box22.setText(" ");
        box22.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box22.setFont(new Font("Arial Bold", 100.0));

        GridPane.setColumnIndex(box21, 1);
        GridPane.setHalignment(box21, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(box21, 2);
        GridPane.setValignment(box21, javafx.geometry.VPos.CENTER);
        box21.setAlignment(javafx.geometry.Pos.CENTER);
        box21.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        box21.setMinHeight(265.0);
        box21.setMinWidth(265.0);
        box21.setText(" ");
        box21.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box21.setFont(new Font("Arial Bold", 100.0));

        GridPane.setHalignment(box20, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(box20, 2);
        GridPane.setValignment(box20, javafx.geometry.VPos.CENTER);
        box20.setAlignment(javafx.geometry.Pos.CENTER);
        box20.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        box20.setMinHeight(265.0);
        box20.setMinWidth(265.0);
        box20.setText(" ");
        box20.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box20.setFont(new Font("Arial Bold", 100.0));

        GridPane.setHalignment(box10, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(box10, 1);
        GridPane.setValignment(box10, javafx.geometry.VPos.CENTER);
        box10.setAlignment(javafx.geometry.Pos.CENTER);
        box10.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        box10.setMinHeight(265.0);
        box10.setMinWidth(265.0);
        box10.setText(" ");
        box10.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box10.setFont(new Font("Arial Bold", 100.0));

        GridPane.setColumnIndex(box11, 1);
        GridPane.setHalignment(box11, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(box11, 1);
        GridPane.setValignment(box11, javafx.geometry.VPos.CENTER);
        box11.setAlignment(javafx.geometry.Pos.CENTER);
        box11.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        box11.setMinHeight(265.0);
        box11.setMinWidth(265.0);
        box11.setText(" ");
        box11.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box11.setFont(new Font("Arial Bold", 100.0));

        GridPane.setColumnIndex(box12, 2);
        GridPane.setHalignment(box12, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(box12, 1);
        GridPane.setValignment(box12, javafx.geometry.VPos.CENTER);
        box12.setAlignment(javafx.geometry.Pos.CENTER);
        box12.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        box12.setMinHeight(265.0);
        box12.setMinWidth(265.0);
        box12.setText(" ");
        box12.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box12.setFont(new Font("Arial Bold", 100.0));

        GridPane.setColumnIndex(box01, 1);
        GridPane.setHalignment(box01, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(box01, javafx.geometry.VPos.CENTER);
        box01.setAlignment(javafx.geometry.Pos.CENTER);
        box01.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        box01.setMinHeight(265.0);
        box01.setMinWidth(265.0);
        box01.setText(" ");
        box01.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box01.setFont(new Font("Arial Bold", 100.0));

        GridPane.setColumnIndex(box02, 2);
        GridPane.setHalignment(box02, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(box02, javafx.geometry.VPos.CENTER);
        box02.setAlignment(javafx.geometry.Pos.CENTER);
        box02.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        box02.setMinHeight(265.0);
        box02.setMinWidth(265.0);
        box02.setText(" ");
        box02.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box02.setFont(new Font("Arial Bold", 100.0));
        setCenter(gameView);

        Player1View.getChildren().add(menuIcon);
        Player1View.getChildren().add(player1Image);
        player1NameAndScoreView.getChildren().add(player1Name);
        scoreAndStarImageView.getChildren().add(Player1Score);
        scoreAndStarImageView.getChildren().add(starImage);
        player1NameAndScoreView.getChildren().add(scoreAndStarImageView);
        Player1View.getChildren().add(player1NameAndScoreView);
        Player1View.getChildren().add(player1Sign);
        topAncherPane.getChildren().add(Player1View);
        sessionScore.getChildren().add(player1SessionScore);
        sessionScore.getChildren().add(dash);
        sessionScore.getChildren().add(player2SessionScore);
        topAncherPane.getChildren().add(sessionScore);
        Player2View.getChildren().add(player2Sign);
        player2NameAndScoreView.getChildren().add(player2Name);
        player2ScoreAndStarView.getChildren().add(player2Score);
        player2ScoreAndStarView.getChildren().add(Star2Image);
        player2NameAndScoreView.getChildren().add(player2ScoreAndStarView);
        Player2View.getChildren().add(player2NameAndScoreView);
        Player2View.getChildren().add(player2Image);
        topAncherPane.getChildren().add(Player2View);
        gameView.getColumnConstraints().add(columnConstraints);
        gameView.getColumnConstraints().add(columnConstraints0);
        gameView.getColumnConstraints().add(columnConstraints1);
        gameView.getRowConstraints().add(rowConstraints);
        gameView.getRowConstraints().add(rowConstraints0);
        gameView.getRowConstraints().add(rowConstraints1);
        gameView.getChildren().add(box00);
        gameView.getChildren().add(box22);
        gameView.getChildren().add(box21);
        gameView.getChildren().add(box20);
        gameView.getChildren().add(box10);
        gameView.getChildren().add(box11);
        gameView.getChildren().add(box12);
        gameView.getChildren().add(box01);
        gameView.getChildren().add(box02);
    }

    void updateCases(int finalI, int finalJ) {
        int x = isX ? 0 : 1;
        if (finalI == finalJ) {
            playerCases[x][diagonalLeft]++;
        }
        if (finalI + finalJ == 2) {
            playerCases[x][diagonalRight]++;
        }
        if (finalI == 0) {
            playerCases[x][row0]++;
        }
        if (finalI == 1) {
            playerCases[x][row1]++;
        }
        if (finalI == 2) {
            playerCases[x][row2]++;
        }
        if (finalJ == 0) {
            playerCases[x][col0]++;
        }
        if (finalJ == 1) {
            playerCases[x][col1]++;
        }
        if (finalJ == 2) {
            playerCases[x][col2]++;
        }
    }

    void updateScore() {
        player1SessionScore.setText(player1ScoreCount + "");
        player2SessionScore.setText(player2ScoreCount + "");
    }

    int[] checkWinner() {
        int winner[] = {-1, 0};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                if (playerCases[i][j] == 3) {
                    winner[0] = i;
                    winner[1] = j;
                    return winner;
                }
            }
        }
        return winner;
    }

    void celebrateWinner(int c) {
        switch (c) {
            case diagonalLeft:
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i == j) {
                            boxArray[i][j].setTextFill(Color.PINK);
                        }
                    }
                }
                break;
            case diagonalRight:
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i + j == 2) {
                            boxArray[i][j].setTextFill(Color.PINK);
                        }
                    }
                }
                break;
            case row0:
                for (int i = 0; i < 3; i++) {
                    boxArray[0][i].setTextFill(Color.PINK);
                }
                break;
            case row1:
                for (int i = 0; i < 3; i++) {
                    boxArray[1][i].setTextFill(Color.PINK);
                }
                break;
            case row2:
                for (int i = 0; i < 3; i++) {
                    boxArray[2][i].setTextFill(Color.PINK);
                }
                break;
            case col0:
                for (int i = 0; i < 3; i++) {
                    boxArray[i][0].setTextFill(Color.PINK);
                }
                break;
            case col1:
                for (int i = 0; i < 3; i++) {
                    boxArray[i][1].setTextFill(Color.PINK);
                }
                break;
            case col2:
                for (int i = 0; i < 3; i++) {
                    boxArray[i][2].setTextFill(Color.PINK);
                }
                break;
            default:
                break;
        }
        showDialog();
        resetGame();
    }

    void disableLabels() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boxEnabled[i][j] = false;
            }
        }

    }

    private void showDialog() {
        message = new MessageController();
        Parent parent = new PlayAgainDialogBase(message);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();

    }

    private void resetGame() {
        switch (message.getResponse()) {
            case 2:
                isX = true;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        boxEnabled[i][j] = true;
                        boxArray[i][j].setText(" ");
                        boxArray[i][j].setTextFill(Color.BLACK);
                    }
                }
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 8; j++) {
                        playerCases[i][j] = 0;
                    }
                }
                break;
            case 1:
                break;
            case 0:

                break;
            default:
                break;
        }
    }

    private void review() {
        isX = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //boxEnabled[i][j] = true;
                boxArray[i][j].setText(" ");
                boxArray[i][j].setTextFill(Color.BLACK);
            }
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
                        if(currentp1Index == player1Moves.size()&&currentp2Index == player2Moves.size()){
                            executor.shutdown();
                        }
                        isX = !isX;
                    }

                });
            }
        };

        executor.scheduleAtFixedRate(r, 1, 1, TimeUnit.SECONDS); // 0 seconds initial delay, 1 second interval
    }
}
