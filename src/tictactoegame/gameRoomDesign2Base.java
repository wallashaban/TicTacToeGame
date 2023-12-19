package tictactoegame;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public abstract class gameRoomDesign2Base extends BorderPane {

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
    protected final AnchorPane sessionScore;
    protected final Label player1SessionScore;
    protected final Label dash;
    protected final Label player2SessionScore;
    protected final FlowPane Player2View;
    protected final Label player2Sign;
    protected final FlowPane player2NameAndScoreView;
    protected final Label player2NameAndScoreView0;
    protected final FlowPane player2ScoreAndStarView;
    protected final ImageView Star2Image;
    protected final Label player2Score;
    protected final ImageView imageView;
    protected final GridPane gameView;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Label box00;
    protected final Label box10;
    protected final Label box20;
    protected final Label box01;
    protected final Label box11;
    protected final Label box21;
    protected final Label box02;
    protected final Label box12;
    protected final Label box22;

    public gameRoomDesign2Base() {

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
        sessionScore = new AnchorPane();
        player1SessionScore = new Label();
        dash = new Label();
        player2SessionScore = new Label();
        Player2View = new FlowPane();
        player2Sign = new Label();
        player2NameAndScoreView = new FlowPane();
        player2NameAndScoreView0 = new Label();
        player2ScoreAndStarView = new FlowPane();
        Star2Image = new ImageView();
        player2Score = new Label();
        imageView = new ImageView();
        gameView = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        box00 = new Label();
        box10 = new Label();
        box20 = new Label();
        box01 = new Label();
        box11 = new Label();
        box21 = new Label();
        box02 = new Label();
        box12 = new Label();
        box22 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: linear-gradient(to bottom, #DBA7B7, #B292AA);");

        BorderPane.setAlignment(topAncherPane, javafx.geometry.Pos.CENTER);
        topAncherPane.setMaxHeight(100.0);
        topAncherPane.setPrefHeight(100.0);
        topAncherPane.setPrefWidth(800.0);

        AnchorPane.setLeftAnchor(Player1View, 0.0);
        AnchorPane.setRightAnchor(Player1View, 493.0);
        Player1View.setPrefHeight(114.0);
        Player1View.setPrefWidth(310.0);

        menuIcon.setFitHeight(50.0);
        menuIcon.setFitWidth(50.0);
        menuIcon.setPickOnBounds(true);
        menuIcon.setPreserveRatio(true);
        menuIcon.setImage(new Image(getClass().getResource("../../images/menu.png").toExternalForm()));
        FlowPane.setMargin(menuIcon, new Insets(20.0, 0.0, 0.0, 10.0));

        player1Image.setFitHeight(60.0);
        player1Image.setFitWidth(60.0);
        player1Image.setPickOnBounds(true);
        player1Image.setPreserveRatio(true);
        player1Image.setImage(new Image(getClass().getResource("../../../../332116278_1280755552796980_7935683117072368396_n.jpg").toExternalForm()));
        FlowPane.setMargin(player1Image, new Insets(15.0, 0.0, 0.0, 10.0));

        player1NameAndScoreView.setMaxHeight(100.0);
        player1NameAndScoreView.setOrientation(javafx.geometry.Orientation.VERTICAL);
        player1NameAndScoreView.setPrefHeight(87.0);
        player1NameAndScoreView.setPrefWidth(144.0);
        player1NameAndScoreView.setPrefWrapLength(100.0);

        player1Name.setMinHeight(38.0);
        player1Name.setPrefHeight(38.0);
        player1Name.setPrefWidth(145.0);
        player1Name.setText("Ahmed Ghoneim");
        player1Name.setTextFill(javafx.scene.paint.Color.WHITE);
        player1Name.setFont(new Font("SansSerif Bold", 18.0));
        FlowPane.setMargin(player1Name, new Insets(20.0, 0.0, 0.0, 0.0));

        scoreAndStarImageView.setPrefHeight(25.0);
        scoreAndStarImageView.setPrefWidth(122.0);

        Player1Score.setText("690");
        Player1Score.setTextFill(javafx.scene.paint.Color.WHITE);
        Player1Score.setFont(new Font(16.0));

        starImage.setFitHeight(25.0);
        starImage.setFitWidth(25.0);
        starImage.setPickOnBounds(true);
        starImage.setPreserveRatio(true);
        starImage.setImage(new Image(getClass().getResource("../../images/1840745.png").toExternalForm()));
        FlowPane.setMargin(player1NameAndScoreView, new Insets(0.0, 0.0, 0.0, 5.0));

        player1Sign.setText("X");
        player1Sign.setTextFill(javafx.scene.paint.Color.valueOf("#8a559b"));
        player1Sign.setFont(new Font("Arial Black", 18.0));
        FlowPane.setMargin(player1Sign, new Insets(0.0));
        player1Sign.setPadding(new Insets(0.0, 0.0, 0.0, 12.0));

        AnchorPane.setLeftAnchor(sessionScore, 300.0);
        AnchorPane.setRightAnchor(sessionScore, 300.0);
        AnchorPane.setTopAnchor(sessionScore, 20.0);
        sessionScore.setLayoutX(306.0);
        sessionScore.setPrefHeight(70.0);
        sessionScore.setPrefWidth(197.0);

        AnchorPane.setLeftAnchor(player1SessionScore, 50.0);
        player1SessionScore.setText("0");
        player1SessionScore.setTextFill(javafx.scene.paint.Color.valueOf("#56354a"));
        player1SessionScore.setFont(new Font("Segoe UI Bold", 30.0));

        AnchorPane.setLeftAnchor(dash, 90.0);
        AnchorPane.setRightAnchor(dash, 90.0);
        AnchorPane.setTopAnchor(dash, -10.0);
        dash.setText("-");
        dash.setTextFill(javafx.scene.paint.Color.valueOf("#56354a"));
        dash.setFont(new Font("Segoe UI Bold", 40.0));

        AnchorPane.setRightAnchor(player2SessionScore, 50.0);
        player2SessionScore.setText("1");
        player2SessionScore.setTextFill(javafx.scene.paint.Color.valueOf("#56354a"));
        player2SessionScore.setFont(new Font("Segoe UI Bold", 30.0));

        AnchorPane.setLeftAnchor(Player2View, 489.0);
        AnchorPane.setRightAnchor(Player2View, 0.0);
        Player2View.setLayoutX(489.0);
        Player2View.setPrefHeight(114.0);
        Player2View.setPrefWidth(311.0);

        player2Sign.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        player2Sign.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        player2Sign.setText("O");
        player2Sign.setTextFill(javafx.scene.paint.Color.valueOf("#db4f7e"));
        player2Sign.setFont(new Font("Arial Black", 18.0));
        FlowPane.setMargin(player2Sign, new Insets(0.0));
        player2Sign.setPadding(new Insets(0.0, 10.0, 0.0, 0.0));

        player2NameAndScoreView.setMaxHeight(100.0);
        player2NameAndScoreView.setOrientation(javafx.geometry.Orientation.VERTICAL);
        player2NameAndScoreView.setPrefHeight(85.0);
        player2NameAndScoreView.setPrefWidth(159.0);
        player2NameAndScoreView.setPrefWrapLength(100.0);

        player2NameAndScoreView0.setMinHeight(31.0);
        player2NameAndScoreView0.setNodeOrientation(javafx.geometry.NodeOrientation.RIGHT_TO_LEFT);
        player2NameAndScoreView0.setPrefHeight(44.0);
        player2NameAndScoreView0.setPrefWidth(154.0);
        player2NameAndScoreView0.setText("Mohamed Ghoneim");
        player2NameAndScoreView0.setTextFill(javafx.scene.paint.Color.WHITE);
        player2NameAndScoreView0.setFont(new Font("SansSerif Bold", 16.0));
        FlowPane.setMargin(player2NameAndScoreView0, new Insets(15.0, 0.0, 0.0, 0.0));

        player2ScoreAndStarView.setNodeOrientation(javafx.geometry.NodeOrientation.RIGHT_TO_LEFT);
        player2ScoreAndStarView.setPrefHeight(13.0);
        player2ScoreAndStarView.setPrefWidth(154.0);

        Star2Image.setFitHeight(25.0);
        Star2Image.setFitWidth(25.0);
        Star2Image.setPickOnBounds(true);
        Star2Image.setPreserveRatio(true);
        Star2Image.setImage(new Image(getClass().getResource("../../images/1840745.png").toExternalForm()));

        player2Score.setText("690");
        player2Score.setTextFill(javafx.scene.paint.Color.WHITE);
        player2Score.setFont(new Font(16.0));
        FlowPane.setMargin(player2NameAndScoreView, new Insets(0.0, 5.0, 0.0, 0.0));

        imageView.setFitHeight(60.0);
        imageView.setFitWidth(60.0);
        imageView.setNodeOrientation(javafx.geometry.NodeOrientation.RIGHT_TO_LEFT);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../../images/39467269_2158747357747944_2865808226652258304_n.jpg").toExternalForm()));
        FlowPane.setMargin(imageView, new Insets(10.0, 0.0, 0.0, 0.0));
        setTop(topAncherPane);

        BorderPane.setAlignment(gameView, javafx.geometry.Pos.CENTER);
        gameView.setGridLinesVisible(true);
        gameView.setMaxHeight(450.0);
        gameView.setMaxWidth(450.0);
        gameView.setPrefHeight(500.0);
        gameView.setPrefWidth(500.0);
        gameView.setStyle("-fx-background-color: #EACCD6; -fx-border-color: #56354A; -fx-border-radius: 20; -fx-background-radius: 20; -fx-border-width: 7; -fx-border-style: solid; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");

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

        box00.setAlignment(javafx.geometry.Pos.CENTER);
        box00.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        box00.setPrefHeight(150.0);
        box00.setPrefWidth(150.0);
        box00.setText("X");
        box00.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box00.setTextFill(javafx.scene.paint.Color.valueOf("#8a559b"));
        box00.setFont(new Font("Arial Bold", 80.0));

        GridPane.setRowIndex(box10, 1);
        box10.setAlignment(javafx.geometry.Pos.CENTER);
        box10.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        box10.setPrefHeight(150.0);
        box10.setPrefWidth(150.0);
        box10.setText("O");
        box10.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box10.setTextFill(javafx.scene.paint.Color.valueOf("#db4f7e"));
        box10.setFont(new Font("Arial Bold", 80.0));

        GridPane.setRowIndex(box20, 2);
        box20.setAlignment(javafx.geometry.Pos.CENTER);
        box20.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        box20.setPrefHeight(150.0);
        box20.setPrefWidth(150.0);
        box20.setText("X");
        box20.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box20.setTextFill(javafx.scene.paint.Color.valueOf("#8a559b"));
        box20.setFont(new Font("Arial Bold", 80.0));

        GridPane.setColumnIndex(box01, 1);
        box01.setAlignment(javafx.geometry.Pos.CENTER);
        box01.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        box01.setPrefHeight(150.0);
        box01.setPrefWidth(150.0);
        box01.setText("O");
        box01.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box01.setTextFill(javafx.scene.paint.Color.valueOf("#db4f7e"));
        box01.setFont(new Font("Arial Bold", 80.0));

        GridPane.setColumnIndex(box11, 1);
        GridPane.setRowIndex(box11, 1);
        box11.setAlignment(javafx.geometry.Pos.CENTER);
        box11.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        box11.setPrefHeight(150.0);
        box11.setPrefWidth(150.0);
        box11.setText("X");
        box11.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box11.setTextFill(javafx.scene.paint.Color.valueOf("#8a559b"));
        box11.setFont(new Font("Arial Bold", 80.0));

        GridPane.setColumnIndex(box21, 1);
        GridPane.setRowIndex(box21, 2);
        box21.setAlignment(javafx.geometry.Pos.CENTER);
        box21.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        box21.setPrefHeight(150.0);
        box21.setPrefWidth(150.0);
        box21.setText("O");
        box21.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box21.setTextFill(javafx.scene.paint.Color.valueOf("#db4f7e"));
        box21.setFont(new Font("Arial Bold", 80.0));

        GridPane.setColumnIndex(box02, 2);
        box02.setAlignment(javafx.geometry.Pos.CENTER);
        box02.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        box02.setPrefHeight(150.0);
        box02.setPrefWidth(150.0);
        box02.setText("O");
        box02.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box02.setTextFill(javafx.scene.paint.Color.valueOf("#db4f7e"));
        box02.setFont(new Font("Arial Bold", 80.0));

        GridPane.setColumnIndex(box12, 2);
        GridPane.setRowIndex(box12, 1);
        box12.setAlignment(javafx.geometry.Pos.CENTER);
        box12.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        box12.setPrefHeight(150.0);
        box12.setPrefWidth(150.0);
        box12.setText("X");
        box12.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box12.setTextFill(javafx.scene.paint.Color.valueOf("#8a559b"));
        box12.setFont(new Font("Arial Bold", 80.0));

        GridPane.setColumnIndex(box22, 2);
        GridPane.setRowIndex(box22, 2);
        box22.setAlignment(javafx.geometry.Pos.CENTER);
        box22.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        box22.setPrefHeight(150.0);
        box22.setPrefWidth(150.0);
        box22.setText("X");
        box22.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box22.setTextFill(javafx.scene.paint.Color.valueOf("#8a559b"));
        box22.setFont(new Font("Arial Bold", 80.0));
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
        player2NameAndScoreView.getChildren().add(player2NameAndScoreView0);
        player2ScoreAndStarView.getChildren().add(Star2Image);
        player2ScoreAndStarView.getChildren().add(player2Score);
        player2NameAndScoreView.getChildren().add(player2ScoreAndStarView);
        Player2View.getChildren().add(player2NameAndScoreView);
        Player2View.getChildren().add(imageView);
        topAncherPane.getChildren().add(Player2View);
        gameView.getColumnConstraints().add(columnConstraints);
        gameView.getColumnConstraints().add(columnConstraints0);
        gameView.getColumnConstraints().add(columnConstraints1);
        gameView.getRowConstraints().add(rowConstraints);
        gameView.getRowConstraints().add(rowConstraints0);
        gameView.getRowConstraints().add(rowConstraints1);
        gameView.getChildren().add(box00);
        gameView.getChildren().add(box10);
        gameView.getChildren().add(box20);
        gameView.getChildren().add(box01);
        gameView.getChildren().add(box11);
        gameView.getChildren().add(box21);
        gameView.getChildren().add(box02);
        gameView.getChildren().add(box12);
        gameView.getChildren().add(box22);

    }
}
