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

public class PlayAgainDialogBase extends Pane {

    protected final ImageView imageView;
    protected final Rectangle rectangle;
    protected final Button btnReplay;
    protected final Button btnNotNow;
    protected final Label labelRequestMessage;
    protected final Button btnOk;

    public PlayAgainDialogBase(Response response) {

        imageView = new ImageView();
        rectangle = new Rectangle();
        btnReplay = new Button();
        btnNotNow = new Button();
        labelRequestMessage = new Label();
        btnOk = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(244.0);
        setPrefWidth(587.0);
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
        rectangle.setHeight(101.0);
        rectangle.setLayoutX(88.0);
        rectangle.setLayoutY(69.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setStyle("-fx-arc-width: 40; -fx-arc-height: 40;");
        rectangle.setWidth(412.0);

        btnReplay.setLayoutX(74.0);
        btnReplay.setLayoutY(184.0);
        btnReplay.setMnemonicParsing(false);
        btnReplay.setPrefHeight(39.0);
        btnReplay.setPrefWidth(127.0);
        btnReplay.setStyle("-fx-border-color: D9D9D9; -fx-background-color: ffffff; -fx-font-family: serif; -fx-font-weight: bold; -fx-font-size: 20; -fx-border-radius: 40;");
        btnReplay.setText("Replay");
        btnReplay.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnReplay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                response.setResponse(1);
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
        });

        btnNotNow.setLayoutX(381.0);
        btnNotNow.setLayoutY(184.0);
        btnNotNow.setMnemonicParsing(false);
        btnNotNow.setPrefHeight(39.0);
        btnNotNow.setPrefWidth(113.0);
        btnNotNow.setStyle("-fx-border-color: D9D9D9; -fx-background-color: ffffff; -fx-font-family: serif; -fx-font-weight: bold; -fx-font-size: 20; -fx-border-radius: 40;");
        btnNotNow.setText("Not Now");
        btnNotNow.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnNotNow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                response.setResponse(0);
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
        });

        labelRequestMessage.setLayoutX(174.0);
        labelRequestMessage.setLayoutY(89.0);
        labelRequestMessage.setLineSpacing(1.5);
        labelRequestMessage.setPrefHeight(61.0);
        labelRequestMessage.setPrefWidth(263.0);
        labelRequestMessage.setStyle("-fx-font-family: serif; -fx-font-size: 20;");
        labelRequestMessage.setText("Congratulations X!! Do you want to play again? ");
        labelRequestMessage.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        labelRequestMessage.setWrapText(true);

        btnOk.setLayoutX(237.0);
        btnOk.setLayoutY(184.0);
        btnOk.setMnemonicParsing(false);
        btnOk.setPrefHeight(39.0);
        btnOk.setPrefWidth(113.0);
        btnOk.setStyle("-fx-border-color: D9D9D9; -fx-background-color: ffffff; -fx-font-family: serif; -fx-font-weight: bold; -fx-font-size: 20; -fx-border-radius: 40;");
        btnOk.setText("OK");
        btnOk.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnOk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                response.setResponse(2);
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
        });

        getChildren().add(imageView);
        getChildren().add(rectangle);
        getChildren().add(btnReplay);
        getChildren().add(btnNotNow);
        getChildren().add(labelRequestMessage);
        getChildren().add(btnOk);

    }
}
