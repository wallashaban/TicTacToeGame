package tictactoegame;

import java.util.Iterator;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
import javafx.scene.text.Font;

public class gameRoomDesignBase extends BorderPane {

    public static final int PLAYER1 = 1;
    public static final int PLAYER2 = 2;
    Player player1;
    Player player2;

    private int currentPlayer;

    protected final AnchorPane topAncherPane;
    protected final FlowPane Player1View;
    protected final ImageView menuIcon;
    protected final ImageView player1Image;
    protected final FlowPane player1NameAndScoreView;
    protected final Label player1Name;
    protected final FlowPane scoreAndStarImageView;
    protected final Label Player1Score;
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
    protected final Label player2Score;
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

    public gameRoomDesignBase() {

        currentPlayer = PLAYER1;
        player1 = new Player("x");
        player2 = new Player("o");

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
        //   menuIcon.setImage(new Image(getClass().getResource("images/menu.png").toExternalForm()));

        player1Image.setFitHeight(100.0);
        player1Image.setFitWidth(100.0);
        player1Image.setPickOnBounds(true);
        player1Image.setPreserveRatio(true);
        //  player1Image.setImage(new Image(getClass().getResource("images/332116278_1280755552796980_7935683117072368396_n.jpg").toExternalForm()));
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
        // starImage.setImage(new Image(getClass().getResource("images/1840745.png").toExternalForm()));
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

        player2SessionScore.setText("1");
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
        //Star2Image.setImage(new Image(getClass().getResource("images/1840745.png").toExternalForm()));
        FlowPane.setMargin(player2ScoreAndStarView, new Insets(0.0));
        FlowPane.setMargin(player2NameAndScoreView, new Insets(0.0));

        player2Image.setFitHeight(100.0);
        player2Image.setFitWidth(100.0);
        player2Image.setNodeOrientation(javafx.geometry.NodeOrientation.RIGHT_TO_LEFT);
        player2Image.setPickOnBounds(true);
        player2Image.setPreserveRatio(true);
        //player2Image.setImage(new Image(getClass().getResource("images/39467269_2158747357747944_2865808226652258304_n.jpg").toExternalForm()));
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
        box00.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (currentPlayer == PLAYER1) {
                    box00.setText(player1.getSign());
                    Iterator<Point[]> iter = player1.winningCases.keySet().iterator();
                    int i = 1;
                    int currentvalue;
                    while (iter.hasNext()) {
                        if (i == 1 || i == 3 || i == 6) {
                            Point[] curr = iter.next();
                            player2.winningCases.remove(curr);
                            currentvalue = player1.winningCases.get(curr);
                            if (currentvalue == 2) {
                                int sessionscr = Integer.parseInt(player1SessionScore.getText());
                                player1SessionScore.setText(Integer.toString(++sessionscr));
                            }
                            player1.winningCases.put(curr, ++currentvalue);
                        }
                        i++;
                    }
                } else {
                    box00.setText(player2.getSign());
                    Iterator<Point[]> iter = player2.winningCases.keySet().iterator();
                    int i = 1;
                    int currentvalue;
                    while (iter.hasNext()) {
                        if (i == 1 || i == 3 || i == 6) {
                            Point[] curr = iter.next();
                            player1.winningCases.remove(curr);
                            currentvalue = player2.winningCases.get(curr);
                            if (currentvalue == 2) {
                                int sessionscr = Integer.parseInt(player2SessionScore.getText());
                                player2SessionScore.setText(Integer.toString(++sessionscr));
                            }
                            player2.winningCases.put(curr, ++currentvalue);
                            i++;
                        }
                    }
                }
                if (currentPlayer == PLAYER1) {
                    currentPlayer = PLAYER2;
                } else {
                    currentPlayer = PLAYER1;
                }
            }
        });

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
        box22.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (currentPlayer == PLAYER1) {
                    box22.setText(player1.getSign());
                    Iterator<Point[]> iter = player1.winningCases.keySet().iterator();
                    int i = 1;
                    int currentvalue;
                    while (iter.hasNext()) {
                        if (i == 1 || i == 5 || i == 7) {
                            Point[] curr = iter.next();
                            player2.winningCases.remove(curr);
                            currentvalue = player1.winningCases.get(curr);
                            if (currentvalue == 2) {
                                int sessionscr = Integer.parseInt(player1SessionScore.getText());
                                player1SessionScore.setText(Integer.toString(++sessionscr));
                            }
                            player1.winningCases.put(curr, ++currentvalue);
                        }
                        i++;
                    }
                } else {
                    box22.setText(player2.getSign());
                    Iterator<Point[]> iter = player2.winningCases.keySet().iterator();
                    int i = 1;
                    int currentvalue;
                    while (iter.hasNext()) {
                        if (i == 1 || i == 5 || i == 7) {
                            Point[] curr = iter.next();
                            player1.winningCases.remove(curr);
                            currentvalue = player2.winningCases.get(curr);
                            if (currentvalue == 2) {
                                int sessionscr = Integer.parseInt(player2SessionScore.getText());
                                player2SessionScore.setText(Integer.toString(++sessionscr));
                            }
                            player2.winningCases.put(curr, ++currentvalue);
                        }
                        i++;
                    }
                }
                if (currentPlayer == PLAYER1) {
                    currentPlayer = PLAYER2;
                } else {
                    currentPlayer = PLAYER1;
                }
            }
        });

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
        box21.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (currentPlayer == PLAYER1) {
                    box21.setText(player1.getSign());
                    Iterator<Point[]> iter = player1.winningCases.keySet().iterator();
                    int i = 1;
                    int currentvalue;
                    while (iter.hasNext()) {
                        if (i == 4 || i == 8) {
                            Point[] curr = iter.next();
                            player2.winningCases.remove(curr);
                            currentvalue = player1.winningCases.get(curr);
                            if (currentvalue == 2) {
                                int sessionscr = Integer.parseInt(player1SessionScore.getText());
                                player1SessionScore.setText(Integer.toString(++sessionscr));
                            }
                            player1.winningCases.put(curr, ++currentvalue);
                        }
                        i++;
                    }
                } else {
                    box21.setText(player2.getSign());
                    Iterator<Point[]> iter = player2.winningCases.keySet().iterator();
                    int i = 1;
                    int currentvalue;
                    while (iter.hasNext()) {
                        if (i == 4 || i == 8) {
                            Point[] curr = iter.next();
                            player1.winningCases.remove(curr);
                            currentvalue = player2.winningCases.get(curr);
                            if (currentvalue == 2) {
                                int sessionscr = Integer.parseInt(player2SessionScore.getText());
                                player2SessionScore.setText(Integer.toString(++sessionscr));
                            }
                            player2.winningCases.put(curr, ++currentvalue);
                        }
                        i++;
                    }
                }
                if (currentPlayer == PLAYER1) {
                    currentPlayer = PLAYER2;
                } else {
                    currentPlayer = PLAYER1;
                }
            }
        });

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
        box20.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (currentPlayer == PLAYER1) {
                    box20.setText(player1.getSign());
                    Iterator<Point[]> iter = player1.winningCases.keySet().iterator();
                    int i = 1;
                    int currentvalue;
                    while (iter.hasNext()) {
                        if (i == 2 || i == 5 || i == 6) {
                            Point[] curr = iter.next();
                            player2.winningCases.remove(curr);
                            currentvalue = player1.winningCases.get(curr);
                            if (currentvalue == 2) {
                                int sessionscr = Integer.parseInt(player1SessionScore.getText());
                                player1SessionScore.setText(Integer.toString(++sessionscr));
                            }
                            player1.winningCases.put(curr, ++currentvalue);
                        }
                        i++;
                    }
                } else {
                    box20.setText(player2.getSign());
                    Iterator<Point[]> iter = player2.winningCases.keySet().iterator();
                    int i = 1;
                    int currentvalue;
                    while (iter.hasNext()) {
                        if (i == 2 || i == 5 || i == 6) {
                            Point[] curr = iter.next();
                            player1.winningCases.remove(curr);
                            currentvalue = player2.winningCases.get(curr);
                            if (currentvalue == 2) {
                                int sessionscr = Integer.parseInt(player2SessionScore.getText());
                                player2SessionScore.setText(Integer.toString(++sessionscr));
                            }
                            player2.winningCases.put(curr, ++currentvalue);
                        }
                        i++;
                    }
                }
                if (currentPlayer == PLAYER1) {
                    currentPlayer = PLAYER2;
                } else {
                    currentPlayer = PLAYER1;
                }
            }
        });

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
        box10.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (currentPlayer == PLAYER1) {
                    box10.setText(player1.getSign());
                    Iterator<Point[]> iter = player1.winningCases.keySet().iterator();
                    int i = 1;
                    int currentvalue;
                    while (iter.hasNext()) {
                        if (i == 4 || i == 6) {
                            Point[] curr = iter.next();
                            player2.winningCases.remove(curr);
                            currentvalue = player1.winningCases.get(curr);
                            if (currentvalue == 2) {
                                int sessionscr = Integer.parseInt(player1SessionScore.getText());
                                player1SessionScore.setText(Integer.toString(++sessionscr));
                            }
                            player1.winningCases.put(curr, ++currentvalue);
                        }
                        i++;
                    }
                } else {
                    box10.setText(player2.getSign());
                    Iterator<Point[]> iter = player2.winningCases.keySet().iterator();
                    int i = 1;
                    int currentvalue;
                    while (iter.hasNext()) {
                        if (i == 4 || i == 6) {
                            Point[] curr = iter.next();
                            player1.winningCases.remove(curr);
                            currentvalue = player2.winningCases.get(curr);
                            if (currentvalue == 2) {
                                int sessionscr = Integer.parseInt(player2SessionScore.getText());
                                player2SessionScore.setText(Integer.toString(++sessionscr));
                            }
                            player2.winningCases.put(curr, ++currentvalue);
                        }
                        i++;
                    }
                }
                if (currentPlayer == PLAYER1) {
                    currentPlayer = PLAYER2;
                } else {
                    currentPlayer = PLAYER1;
                }
            }
        });

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
        box11.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (currentPlayer == PLAYER1) {
                    box11.setText(player1.getSign());
                    Iterator<Point[]> iter = player1.winningCases.keySet().iterator();
                    int i = 1;
                    int currentvalue;
                    while (iter.hasNext()) {
                        if (i == 1 || i == 2 || i == 4 || i == 7) {
                            Point[] curr = iter.next();
                            player2.winningCases.remove(curr);
                            currentvalue = player1.winningCases.get(curr);
                            if (currentvalue == 2) {
                                int sessionscr = Integer.parseInt(player1SessionScore.getText());
                                player1SessionScore.setText(Integer.toString(++sessionscr));
                            }
                            player1.winningCases.put(curr, ++currentvalue);
                        }
                        i++;
                    }
                } else {
                    box11.setText(player2.getSign());
                    Iterator<Point[]> iter = player2.winningCases.keySet().iterator();
                    int i = 1;
                    int currentvalue;
                    while (iter.hasNext()) {
                        if (i == 1 || i == 2 || i == 4 || i == 7) {
                            Point[] curr = iter.next();
                            player1.winningCases.remove(curr);
                            currentvalue = player2.winningCases.get(curr);
                            if (currentvalue == 2) {
                                int sessionscr = Integer.parseInt(player2SessionScore.getText());
                                player2SessionScore.setText(Integer.toString(++sessionscr));
                            }
                            player2.winningCases.put(curr, ++currentvalue);
                        }
                        i++;
                    }
                }
                if (currentPlayer == PLAYER1) {
                    currentPlayer = PLAYER2;
                } else {
                    currentPlayer = PLAYER1;
                }
            }
        });
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
        box12.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (currentPlayer == PLAYER1) {
                    box12.setText(player1.getSign());
                    Iterator<Point[]> iter = player1.winningCases.keySet().iterator();
                    int i = 1;
                    int currentvalue;
                    while (iter.hasNext()) {
                        if (i == 4 || i == 8) {
                            Point[] curr = iter.next();
                            player2.winningCases.remove(curr);
                            currentvalue = player1.winningCases.get(curr);
                            if (currentvalue == 2) {
                                int sessionscr = Integer.parseInt(player1SessionScore.getText());
                                player1SessionScore.setText(Integer.toString(++sessionscr));
                            }
                            player1.winningCases.put(curr, ++currentvalue);
                        }
                        i++;
                    }
                } else {
                    box12.setText(player2.getSign());
                    Iterator<Point[]> iter = player2.winningCases.keySet().iterator();
                    int i = 1;
                    int currentvalue;
                    while (iter.hasNext()) {
                        if (i == 4 || i == 8) {
                            Point[] curr = iter.next();
                            player1.winningCases.remove(curr);
                            currentvalue = player2.winningCases.get(curr);
                            if (currentvalue == 2) {
                                int sessionscr = Integer.parseInt(player2SessionScore.getText());
                                player2SessionScore.setText(Integer.toString(++sessionscr));
                            }
                            player2.winningCases.put(curr, ++currentvalue);
                        }
                        i++;
                    }
                }
                if (currentPlayer == PLAYER1) {
                    currentPlayer = PLAYER2;
                } else {
                    currentPlayer = PLAYER1;
                }
            }
        });

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
        box01.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (currentPlayer == PLAYER1) {
                    box01.setText(player1.getSign());
                    Iterator<Point[]> iter = player1.winningCases.keySet().iterator();
                    int i = 1;
                    int currentvalue;
                    while (iter.hasNext()) {
                        if (i == 3 || i == 7) {
                            Point[] curr = iter.next();
                            player2.winningCases.remove(curr);
                            currentvalue = player1.winningCases.get(curr);
                            if (currentvalue == 2) {
                                int sessionscr = Integer.parseInt(player1SessionScore.getText());
                                player1SessionScore.setText(Integer.toString(++sessionscr));
                            }
                            player1.winningCases.put(curr, ++currentvalue);
                        }
                        i++;
                    }
                } else {
                    box01.setText(player2.getSign());
                    Iterator<Point[]> iter = player2.winningCases.keySet().iterator();
                    int i = 1;
                    int currentvalue;
                    while (iter.hasNext()) {
                        if (i == 3 || i == 7) {
                            Point[] curr = iter.next();
                            player1.winningCases.remove(curr);
                            currentvalue = player2.winningCases.get(curr);
                            if (currentvalue == 2) {
                                int sessionscr = Integer.parseInt(player2SessionScore.getText());
                                player2SessionScore.setText(Integer.toString(++sessionscr));
                            }
                            player2.winningCases.put(curr, ++currentvalue);
                        }
                        i++;
                    }
                }
                if (currentPlayer == PLAYER1) {
                    currentPlayer = PLAYER2;
                } else {
                    currentPlayer = PLAYER1;
                }
            }
        });

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
        box02.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("enter box02");
                if (currentPlayer == PLAYER1) {
                    box02.setText(player1.getSign());
                    Iterator<Point[]> iter = player1.winningCases.keySet().iterator();
                    int i = 1;
                    int currentvalue;
                    while (iter.hasNext()) {
                        if (i == 2 || i == 3 || i == 8) {
                            Point[] curr = iter.next();
                            player2.winningCases.remove(curr);
                            currentvalue = player1.winningCases.get(curr);
                            if (currentvalue == 2) {
                                int sessionscr = Integer.parseInt(player1SessionScore.getText());
                                player1SessionScore.setText(Integer.toString(++sessionscr));
                            }
                            player1.winningCases.put(curr, ++currentvalue);
                        }
                        i++;
                    }
                } else {
                    box02.setText(player2.getSign());
                    Iterator<Point[]> iter = player2.winningCases.keySet().iterator();
                    int i = 1;
                    int currentvalue;
                    while (iter.hasNext()) {
                        if (i == 2 || i == 3 || i == 8) {
                            System.out.println(i);
                            Point[] curr = iter.next();
                            player1.winningCases.remove(curr);
                            currentvalue = player2.winningCases.get(curr);
                            if (currentvalue == 2) {
                                int sessionscr = Integer.parseInt(player2SessionScore.getText());
                                player2SessionScore.setText(Integer.toString(++sessionscr));
                            }
                            player2.winningCases.put(curr, ++currentvalue);
                        }
                        i++;
                    }
                }
                if (currentPlayer == PLAYER1) {
                    currentPlayer = PLAYER2;
                } else {
                    currentPlayer = PLAYER1;
                }
                System.out.println("exit box02");
            }
        });
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
}
