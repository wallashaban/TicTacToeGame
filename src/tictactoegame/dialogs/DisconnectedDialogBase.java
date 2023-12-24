package tictactoegame.dialogs;

import java.lang.String;
import java.net.URL;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class DisconnectedDialogBase extends Pane {

    protected final Rectangle rectangle;
    protected final Button btnAccept;
    protected final Label labelRequestMessage;

    public DisconnectedDialogBase() {

        rectangle = new Rectangle();
        btnAccept = new Button();
        labelRequestMessage = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(351.0);
        setPrefWidth(600.0);
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

        btnAccept.setLayoutX(253.0);
        btnAccept.setLayoutY(281.0);
        btnAccept.setMnemonicParsing(false);
        btnAccept.setPrefHeight(39.0);
        btnAccept.setPrefWidth(113.0);
        btnAccept.setStyle("-fx-background-color: CF8A9B; -fx-background-radius: 40; -fx-font-style: Bold;");
        btnAccept.setText("OK");
        btnAccept.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnAccept.setTextFill(javafx.scene.paint.Color.WHITE);
        btnAccept.setFont(new Font("Gill Sans MT Bold Italic", 20.0));

        labelRequestMessage.setLayoutX(139.0);
        labelRequestMessage.setLayoutY(97.0);
        labelRequestMessage.setLineSpacing(1.5);
        labelRequestMessage.setPrefHeight(140.0);
        labelRequestMessage.setPrefWidth(317.0);
        labelRequestMessage.setText("It seems you are disconnected.");
        labelRequestMessage.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        labelRequestMessage.setWrapText(true);
        labelRequestMessage.setFont(new Font("Gill Sans MT", 24.0));
        getStylesheets().add("/tictactoegame/dialogs/BackGround.css");
        getStylesheets().add("/css/style.css");

        getChildren().add(rectangle);
        getChildren().add(btnAccept);
        getChildren().add(labelRequestMessage);

    }
}
