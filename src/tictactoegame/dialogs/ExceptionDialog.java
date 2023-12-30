package tictactoegame.dialogs;

import java.lang.String;
import java.net.URL;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tictactoegame.MainScreen.MainScreenUI;
import tictactoegame.data.SharedData;

public class ExceptionDialog extends Pane {

    protected final Rectangle rectangle;
    protected final Button btnAccept;
    protected final Label labelRequestMessage;
    protected final Pane exitBtn;
    protected final Label label;

    public ExceptionDialog(String text,boolean isServerclosed) {

        rectangle = new Rectangle();
        btnAccept = new Button();
        labelRequestMessage = new Label();
        exitBtn = new Pane();
        label = new Label();

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

        labelRequestMessage.setLayoutX(96.0);
        labelRequestMessage.setLayoutY(94.0);
        labelRequestMessage.setLineSpacing(1.5);
        labelRequestMessage.setPrefHeight(146.0);
        labelRequestMessage.setPrefWidth(402.0);
        labelRequestMessage.setText(text);
        labelRequestMessage.setWrapText(true);
        labelRequestMessage.setFont(new Font("Gill Sans MT", 24.0));

        exitBtn.setLayoutX(539.0);
        exitBtn.setLayoutY(14.0);
        exitBtn.setPrefHeight(39.0);
        exitBtn.setPrefWidth(47.0);
        exitBtn.setStyle("-fx-background-radius: 30; -fx-border-radius: 30; -fx-background-color: #e8ccd5;");

        label.setLayoutX(14.0);
        label.setLayoutY(5.0);
        label.setText("X");
        label.setFont(new Font("Gill Sans MT Bold", 24.0));
        getStylesheets().add("/tictactoegame/dialogs/BackGround.css");
        getStylesheets().add("css/style.css");

        getChildren().add(rectangle);
        getChildren().add(btnAccept);
        getChildren().add(labelRequestMessage);
        exitBtn.getChildren().add(label);
        getChildren().add(exitBtn);
        
        exitBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                 Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                 if (isServerclosed) {
                    Parent root = new MainScreenUI();

//                    stage.initStyle(StageStyle.UNDECORATED);
                    SharedData.setStage(stage);
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.show();

                }

                stage.close();
                
            }
        }
        );
        
         btnAccept.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                 Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                 if (isServerclosed) {
                    Parent root = new MainScreenUI();

//                    stage.initStyle(StageStyle.UNDECORATED);
                    Scene scene = new Scene(root);

                    SharedData.stage.setScene(scene);
                    SharedData.stage.show();

                }

                stage.close();
            }
        }
        );

        }
     
    }

