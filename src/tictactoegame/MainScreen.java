package tictactoegame;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public  class MainScreen extends Pane {

    protected final Pane onlinePane;
    protected final ImageView imageView;
    protected final Label label;
    protected final Pane computerPane;
    protected final ImageView imageView0;
    protected final Label label0;
    protected final Pane localPane;
    protected final ImageView imageView1;
    protected final Label label1;
    protected final Pane pane;
    protected final Button exitBtn;
    protected final Pane pane0;
    protected final Label label2;
    protected final Pane pane1;

    public MainScreen() {

        onlinePane = new Pane();
        imageView = new ImageView();
        label = new Label();
        computerPane = new Pane();
        imageView0 = new ImageView();
        label0 = new Label();
        localPane = new Pane();
        imageView1 = new ImageView();
        label1 = new Label();
        pane = new Pane();
        exitBtn = new Button();
        pane0 = new Pane();
        label2 = new Label();
        pane1 = new Pane();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(426.0);
        setPrefWidth(687.0);
        setStyle("-fx-background-color: #FFFFFF;");

        onlinePane.setLayoutX(30.0);
        onlinePane.setLayoutY(100.0);
        onlinePane.setPrefHeight(200.0);
        onlinePane.setPrefWidth(200.0);
        onlinePane.setStyle("-fx-background-color: #EB8FB4; -fx-background-radius: 18 18 18 18;");

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(181.0);
        imageView.setLayoutX(25.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../../images/�����.png").toExternalForm()));

        label.setLayoutX(63.0);
        label.setLayoutY(158.0);
        label.setText("Online");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("System Bold", 24.0));

        computerPane.setLayoutX(250.0);
        computerPane.setLayoutY(100.0);
        computerPane.setPrefHeight(200.0);
        computerPane.setPrefWidth(200.0);
        computerPane.setStyle("-fx-background-color: #D9D9D9; -fx-background-radius: 18 18 18 18;");

        imageView0.setFitHeight(150.0);
        imageView0.setFitWidth(181.0);
        imageView0.setLayoutX(25.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("../../images/�����.png").toExternalForm()));

        label0.setLayoutX(44.0);
        label0.setLayoutY(158.0);
        label0.setText("Computer");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("System Bold", 24.0));

        localPane.setLayoutX(466.0);
        localPane.setLayoutY(100.0);
        localPane.setPrefHeight(200.0);
        localPane.setPrefWidth(200.0);
        localPane.setStyle("-fx-background-color: #94CBF0; -fx-background-radius: 18 18 18 18;");

        imageView1.setFitHeight(150.0);
        imageView1.setFitWidth(181.0);
        imageView1.setLayoutX(25.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("../../images/�����.png").toExternalForm()));

        label1.setLayoutX(71.0);
        label1.setLayoutY(151.0);
        label1.setText("Local");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("System Bold", 24.0));

        pane.setLayoutX(250.0);
        pane.setLayoutY(331.0);
        pane.setPrefHeight(73.0);
        pane.setPrefWidth(200.0);

        exitBtn.setLayoutX(30.0);
        exitBtn.setLayoutY(11.0);
        exitBtn.setMnemonicParsing(false);
        exitBtn.setPrefHeight(51.0);
        exitBtn.setPrefWidth(150.0);
        exitBtn.setStyle("-fx-background-color: #D9D9D9; -fx-background-radius: 10 10 10 10;");
        exitBtn.setText("EXIT");
        exitBtn.setFont(new Font("System Bold", 24.0));

        pane0.setLayoutX(7.0);
        pane0.setLayoutY(8.0);
        pane0.setPrefHeight(82.0);
        pane0.setPrefWidth(200.0);

        label2.setLayoutX(14.0);
        label2.setLayoutY(14.0);
        label2.setText("Choose Game");
        label2.setFont(new Font("System Bold", 24.0));

        pane1.setLayoutX(13.0);
        pane1.setLayoutY(48.0);
        pane1.setPrefHeight(11.0);
        pane1.setPrefWidth(127.0);
        pane1.setStyle("-fx-background-color: #94CBF0; -fx-background-radius: 10 10 10 10;");

        onlinePane.getChildren().add(imageView);
        onlinePane.getChildren().add(label);
        getChildren().add(onlinePane);
        computerPane.getChildren().add(imageView0);
        computerPane.getChildren().add(label0);
        getChildren().add(computerPane);
        localPane.getChildren().add(imageView1);
        localPane.getChildren().add(label1);
        getChildren().add(localPane);
        pane.getChildren().add(exitBtn);
        getChildren().add(pane);
        pane0.getChildren().add(label2);
        pane0.getChildren().add(pane1);
        getChildren().add(pane0);

    }
}
