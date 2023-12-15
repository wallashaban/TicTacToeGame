package tictactoegame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RequestDialogBase extends Pane {

    protected final ImageView imageView;
    protected final Rectangle rectangle;
    protected final Button btnAccept;
    protected final Button btnNotNow;
    protected final Label labelRequestMessage;

    public RequestDialogBase() {

        imageView = new ImageView();
        rectangle = new Rectangle();
        btnAccept = new Button();
        btnNotNow = new Button();
        labelRequestMessage = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: ffffff;");
        setPadding(new Insets(15.0));

        imageView.setFitHeight(92.0);
        imageView.setFitWidth(105.0);
        imageView.setLayoutX(14.0);
        imageView.setLayoutY(14.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
//        imageView.setImage(new Image(getClass().getResource("../../images/logo.png").toExternalForm()));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#faf9f6"));
        rectangle.setHeight(200.0);
        rectangle.setLayoutX(86.0);
        rectangle.setLayoutY(114.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setStyle("-fx-arc-width: 40; -fx-arc-height: 40;");
        rectangle.setWidth(451.0);

        btnAccept.setLayoutX(184.0);
        btnAccept.setLayoutY(337.0);
        btnAccept.setMnemonicParsing(false);
        btnAccept.setPrefHeight(39.0);
        btnAccept.setPrefWidth(113.0);
        btnAccept.setStyle("-fx-border-color: D9D9D9; -fx-background-color: ffffff; -fx-font-family: serif; -fx-font-weight: bold; -fx-font-size: 20; -fx-border-radius: 40;");
        btnAccept.setText("Accept");
        btnAccept.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        btnNotNow.setLayoutX(347.0);
        btnNotNow.setLayoutY(337.0);
        btnNotNow.setMnemonicParsing(false);
        btnNotNow.setPrefHeight(39.0);
        btnNotNow.setPrefWidth(113.0);
        btnNotNow.setStyle("-fx-border-color: D9D9D9; -fx-background-color: ffffff; -fx-font-family: serif; -fx-font-weight: bold; -fx-font-size: 20; -fx-border-radius: 40;");
        btnNotNow.setText("Not Now");
        btnNotNow.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        

        labelRequestMessage.setLayoutX(111.0);
        labelRequestMessage.setLayoutY(141.0);
        labelRequestMessage.setLineSpacing(1.5);
        labelRequestMessage.setPrefHeight(146.0);
        labelRequestMessage.setPrefWidth(402.0);
        labelRequestMessage.setStyle("-fx-font-family: serif; -fx-font-size: 20;");
        labelRequestMessage.setText("Ahmed, Anas challenges you to a game of Tic Tac Toe. Ready for the challenge? Click here to accept and play as Player Two!");
        labelRequestMessage.setWrapText(true);

        getChildren().add(imageView);
        getChildren().add(rectangle);
        getChildren().add(btnAccept);
        getChildren().add(btnNotNow);
        getChildren().add(labelRequestMessage);

    }
    
    
}
