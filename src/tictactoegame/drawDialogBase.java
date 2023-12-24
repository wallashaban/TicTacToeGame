package tictactoegame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class drawDialogBase extends Pane {

    protected final Button btnReplay;
    protected final Button btnNotNow;
    protected final Button btnPlayAgain;
    protected final Button buttonMinimize;
    protected final Text text;

    public drawDialogBase(MessageController message) {

        btnReplay = new Button();
        btnNotNow = new Button();
        btnPlayAgain = new Button();
        buttonMinimize = new Button();
        text = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(525.0);
        setPrefWidth(587.0);
        getStyleClass().add("backgroundColor");
        getStylesheets().add("/css/style.css");
        setPadding(new Insets(15.0));

        btnReplay.setLayoutX(80.0);
        btnReplay.setLayoutY(273.0);
        btnReplay.setMnemonicParsing(false);
        btnReplay.setPrefHeight(39.0);
        btnReplay.setPrefWidth(131.0);
        btnReplay.setStyle("-fx-background-color: CF8A9B; -fx-background-radius: 40;");
        btnReplay.setText("Replay");
        btnReplay.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnReplay.setTextFill(javafx.scene.paint.Color.WHITE);
        btnReplay.setFont(new Font("Gill Sans MT Bold", 20.0));
        btnReplay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                message.setResponse(1);
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
        });

        btnNotNow.setLayoutX(388.0);
        btnNotNow.setLayoutY(273.0);
        btnNotNow.setMnemonicParsing(false);
        btnNotNow.setPrefHeight(40.0);
        btnNotNow.setPrefWidth(119.0);
        btnNotNow.setStyle("-fx-background-color: CF8A9B; -fx-background-radius: 40;");
        btnNotNow.setText("Not Now");
        btnNotNow.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnNotNow.setTextFill(javafx.scene.paint.Color.WHITE);
        btnNotNow.setFont(new Font("Gill Sans MT Bold", 20.0));
        btnNotNow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                message.setResponse(0);
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
        });

        btnPlayAgain.setLayoutX(234.0);
        btnPlayAgain.setLayoutY(273.0);
        btnPlayAgain.setMnemonicParsing(false);
        btnPlayAgain.setPrefHeight(39.0);
        btnPlayAgain.setPrefWidth(131.0);
        btnPlayAgain.setStyle("-fx-background-color: CF8A9B; -fx-background-radius: 40;");
        btnPlayAgain.setText("Play Again");
        btnPlayAgain.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnPlayAgain.setTextFill(javafx.scene.paint.Color.WHITE);
        btnPlayAgain.setFont(new Font("Gill Sans MT Bold", 20.0));
         btnPlayAgain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                message.setResponse(2);
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
        });

        buttonMinimize.setLayoutX(545.0);
        buttonMinimize.setLayoutY(12.0);
        buttonMinimize.setMnemonicParsing(false);
        buttonMinimize.setPrefHeight(23.0);
        buttonMinimize.setPrefWidth(26.0);
        buttonMinimize.setStyle("-fx-background-radius: 30; -fx-background-color: e8ccd5;");
        buttonMinimize.setText("-");
        buttonMinimize.setFont(new Font("Gill Sans MT Bold Italic", 18.0));
        buttonMinimize.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) buttonMinimize.getScene().getWindow();
            stage.setIconified(true);
        });

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(17.0);
        text.setLayoutY(203.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Draw!! No one won the game");
        text.setFont(new Font("Segoe UI", 33.0));
        char c = message.getWinner();
        if( c == 'D'){
            text.setText("Draw!! No one won the game");
        }
        else if(c == 'R'){
            text.setText("Replay is Done!");
        }

        getChildren().add(btnReplay);
        getChildren().add(btnNotNow);
        getChildren().add(btnPlayAgain);
        getChildren().add(buttonMinimize);
        getChildren().add(text);

    }
}
