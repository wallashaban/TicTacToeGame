package tictactoegame;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public  class SplashScreen extends AnchorPane {

    protected final Pane pane;
    protected final Label label;
    protected final ImageView imageView;
    protected final Button letsPlaybtn;
    protected final Button button;
    protected final Pane pane0;
    protected final Label label0;
    protected final Pane pane1;
    protected final Label label1;

    public SplashScreen() {

        pane = new Pane();
        label = new Label();
        imageView = new ImageView();
        letsPlaybtn = new Button();
        button = new Button();
        pane0 = new Pane();
        label0 = new Label();
        pane1 = new Pane();
        label1 = new Label();

        setId("AnchorPane");
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        getStyleClass().add("backgroundColor");
        getStylesheets().add("/tictactoegame/../css/style.css");

        pane.setLayoutX(50.0);
        pane.setLayoutY(66.0);
        pane.setPrefHeight(503.0);
        pane.setPrefWidth(700.0);
        pane.setStyle("-fx-background-color: #EACCD6;");

        label.setLayoutX(206.0);
        label.setLayoutY(61.0);
        label.setText("TIC-TAC-TOE");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Gill Sans MT Bold Italic", 48.0));

        imageView.setFitHeight(188.0);
        imageView.setFitWidth(112.0);
        imageView.setLayoutX(301.0);
        imageView.setLayoutY(184.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../images/Layer_1.png").toExternalForm()));

        letsPlaybtn.setLayoutX(287.0);
        letsPlaybtn.setLayoutY(417.0);
        letsPlaybtn.setMnemonicParsing(false);
        letsPlaybtn.setStyle("-fx-background-color: #CF8A9B;");
        letsPlaybtn.setText("Let's Play :)");
        letsPlaybtn.setTextFill(javafx.scene.paint.Color.WHITE);
        letsPlaybtn.setFont(new Font("Segoe UI Bold", 24.0));

        button.setLayoutX(393.0);
        button.setLayoutY(184.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(45.0);
        button.setPrefWidth(91.0);
        button.setStyle("-fx-background-color: #CF8A9B; -fx-background-radius: 30;");
        button.setText("Hi :)");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setFont(new Font("Segoe UI Bold", 24.0));

        pane0.setLayoutX(736.0);
        pane0.setLayoutY(6.0);
        pane0.setPrefHeight(50.0);
        pane0.setPrefWidth(50.0);
        pane0.setStyle("-fx-background-color: #EACCD6; -fx-background-radius: 30;");

        label0.setLayoutX(10.0);
        label0.setLayoutY(4.0);
        label0.setPrefHeight(21.0);
        label0.setPrefWidth(18.0);
        label0.setText("X");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("Gill Sans MT Bold", 36.0));

        pane1.setLayoutX(673.0);
        pane1.setLayoutY(6.0);
        pane1.setPrefHeight(50.0);
        pane1.setPrefWidth(50.0);
        pane1.setStyle("-fx-background-color: #EACCD6; -fx-background-radius: 30;");

        label1.setLayoutX(13.0);
        label1.setLayoutY(-28.0);
        label1.setPrefHeight(60.0);
        label1.setPrefWidth(24.0);
        label1.setText("-");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("Gill Sans MT Bold", 72.0));

        pane.getChildren().add(label);
        pane.getChildren().add(imageView);
        pane.getChildren().add(letsPlaybtn);
        pane.getChildren().add(button);
        getChildren().add(pane);
        pane0.getChildren().add(label0);
        getChildren().add(pane0);
        pane1.getChildren().add(label1);
        getChildren().add(pane1);
        
         letsPlaybtn.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        Parent root = new MainScreenUI();
                        Scene scene = new Scene(root);
         
                        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                        stage.setTitle("Text Editor app");
                        stage.setScene(scene);
                        stage.show();
                    }});
         
         pane0.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        Platform.exit();
                    }});
         
         

    }
}
