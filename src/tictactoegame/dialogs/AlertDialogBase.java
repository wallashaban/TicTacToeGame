package tictactoegame.dialogs;

import java.lang.String;
import java.net.URL;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AlertDialogBase extends Pane {

    protected final Rectangle rectangle;
    protected final Button btnOk;
    protected final Label labelRequestMessage;

    public AlertDialogBase(String message) {

        rectangle = new Rectangle();
        btnOk = new Button();
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

        btnOk.setLayoutX(253.0);
        btnOk.setLayoutY(281.0);
        btnOk.setMnemonicParsing(false);
        btnOk.setPrefHeight(39.0);
        btnOk.setPrefWidth(113.0);
        btnOk.setStyle("-fx-background-color: CF8A9B; -fx-background-radius: 40; -fx-font-style: Bold;");
        btnOk.setText("OK");
        btnOk.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnOk.setTextFill(javafx.scene.paint.Color.WHITE);
        btnOk.setFont(new Font("Gill Sans MT Bold Italic", 20.0));

        labelRequestMessage.setLayoutX(96.0);
        labelRequestMessage.setLayoutY(94.0);
        labelRequestMessage.setLineSpacing(1.5);
        labelRequestMessage.setPrefHeight(146.0);
        labelRequestMessage.setPrefWidth(402.0);
        labelRequestMessage.setText(message);
        labelRequestMessage.setWrapText(true);
        labelRequestMessage.setFont(new Font("Gill Sans MT", 24.0));
        getStylesheets().add("/tictactoegame/dialogs/BackGround.css");
        getStylesheets().add("/css/style.css");

        getChildren().add(rectangle);
        getChildren().add(btnOk);
        getChildren().add(labelRequestMessage);
        
        btnOk.setOnAction((event)->{
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        });

    }
}
