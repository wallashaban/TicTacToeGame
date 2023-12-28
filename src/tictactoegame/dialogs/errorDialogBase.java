package tictactoegame.dialogs;

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

public  class errorDialogBase extends Pane {

    protected final ImageView imageView;
    protected final Rectangle rectangle;
    protected final Button canselBtn;
    protected final Label requestMessageLabel;
    protected final Button okBtn;
   
    public errorDialogBase(String text) {

        imageView = new ImageView();
        rectangle = new Rectangle();
        canselBtn = new Button();
        requestMessageLabel = new Label();
        okBtn = new Button();

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
        imageView.setImage(new Image(getClass().getResource("/images/logo.png").toExternalForm()));

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

        canselBtn.setLayoutX(381.0);
        canselBtn.setLayoutY(184.0);
        canselBtn.setMnemonicParsing(false);
        canselBtn.setPrefHeight(39.0);
        canselBtn.setPrefWidth(113.0);
        canselBtn.setStyle("-fx-border-color: D9D9D9; -fx-background-color: ffffff; -fx-font-family: serif; -fx-font-weight: bold; -fx-font-size: 20; -fx-border-radius: 40;");
        canselBtn.setText("Cansel");
        canselBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        requestMessageLabel.setLayoutX(174.0);
        requestMessageLabel.setLayoutY(89.0);
        requestMessageLabel.setLineSpacing(1.5);
        requestMessageLabel.setPrefHeight(61.0);
        requestMessageLabel.setPrefWidth(263.0);
        requestMessageLabel.setStyle("-fx-font-family: serif; -fx-font-size: 20;");
        requestMessageLabel.setText(text);
        requestMessageLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        requestMessageLabel.setWrapText(true);

        okBtn.setLayoutX(99.0);
        okBtn.setLayoutY(184.0);
        okBtn.setMnemonicParsing(false);
        okBtn.setPrefHeight(39.0);
        okBtn.setPrefWidth(113.0);
        okBtn.setStyle("-fx-border-color: D9D9D9; -fx-background-color: ffffff; -fx-font-family: serif; -fx-font-weight: bold; -fx-font-size: 20; -fx-border-radius: 40;");
        okBtn.setText("OK");
        okBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        getChildren().add(imageView);
        getChildren().add(rectangle);
        getChildren().add(canselBtn);
        getChildren().add(requestMessageLabel);
        getChildren().add(okBtn);
         okBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
        });
         
         canselBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
        });

    }
}
