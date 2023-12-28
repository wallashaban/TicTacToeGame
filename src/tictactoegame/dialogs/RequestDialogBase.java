package tictactoegame.dialogs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoegame.data.Request;
import tictactoegame.data.SharedData;

public class RequestDialogBase extends Pane {

    protected final Rectangle rectangle;
    protected final Button btnAccept;
    protected final Button btnNotNow;
    protected final Label labelRequestMessage;
    protected final Button buttonMinimize;

    public RequestDialogBase(String name, Request request) {

        rectangle = new Rectangle();
        btnAccept = new Button();
        btnNotNow = new Button();
        labelRequestMessage = new Label();
        buttonMinimize = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(351.0);
        setPrefWidth(600.0);
        getStyleClass().add("backgroundColor");
        getStylesheets().add("/tictactoegame/BackGround.css");
        setPadding(new Insets(15.0));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#e8ccd5"));
        rectangle.setHeight(200.0);
        rectangle.setLayoutX(72.0);
        rectangle.setLayoutY(67.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setStyle("-fx-arc-width: 40; -fx-arc-height: 40;");
        rectangle.setWidth(451.0);

        btnAccept.setLayoutX(156.0);
        btnAccept.setLayoutY(283.0);
        btnAccept.setMnemonicParsing(false);
        btnAccept.setPrefHeight(39.0);
        btnAccept.setPrefWidth(113.0);
        btnAccept.setStyle("-fx-background-color: CF8A9B; -fx-background-radius: 40; -fx-font-style: Bold;");
        btnAccept.setText("Accept");
        btnAccept.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnAccept.setTextFill(javafx.scene.paint.Color.WHITE);
        btnAccept.setFont(new Font("Segoe UI", 20.0));

        btnNotNow.setLayoutX(338.0);
        btnNotNow.setLayoutY(283.0);
        btnNotNow.setMnemonicParsing(false);
        btnNotNow.setPrefHeight(40.0);
        btnNotNow.setPrefWidth(121.0);
        btnNotNow.setStyle("-fx-background-color: CF8A9B; -fx-background-radius: 40;");
        btnNotNow.setText("Not Now");
        btnNotNow.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnNotNow.setTextFill(javafx.scene.paint.Color.WHITE);
        btnNotNow.setFont(new Font("Segoe UI", 20.0));

        labelRequestMessage.setLayoutX(96.0);
        labelRequestMessage.setLayoutY(94.0);
        labelRequestMessage.setLineSpacing(1.5);
        labelRequestMessage.setPrefHeight(146.0);
        labelRequestMessage.setPrefWidth(402.0);
        labelRequestMessage.setText(SharedData.currentPlayer.getUserName() + ", " + name + " challenges you to a game of Tic Tac Toe. Ready for the challenge? Click here to accept and play as Player Two!");
        labelRequestMessage.setWrapText(true);
        labelRequestMessage.setFont(new Font("Segoe UI", 24.0));

        buttonMinimize.setLayoutX(549.0);
        buttonMinimize.setLayoutY(14.0);
        buttonMinimize.setMnemonicParsing(false);
        buttonMinimize.setStyle("-fx-background-radius: 30; -fx-background-color: e8ccd5;");
        buttonMinimize.setText("-");
        buttonMinimize.setFont(new Font("Segoe UI Bold Italic", 16.0));
        buttonMinimize.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) buttonMinimize.getScene().getWindow();
            stage.setIconified(true);
        });

        getChildren().add(rectangle);
        getChildren().add(btnAccept);
        getChildren().add(btnNotNow);
        getChildren().add(labelRequestMessage);
        getChildren().add(buttonMinimize);

        btnAccept.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                request.setResponse(1);
            }
        });
         btnNotNow.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                request.setResponse(0);
            }
        });
    }
}
