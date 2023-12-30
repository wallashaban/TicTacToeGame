package tictactoegame.SplashScreen;

import javafx.application.Platform;
import javafx.event.ActionEvent;
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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import tictactoegame.MainScreen.MainScreenUI;
import tictactoegame.connection.ClientConnection;
import tictactoegame.connection.Constants;
import tictactoegame.data.MessageController;
import tictactoegame.dialogs.IPDialogBase;

public class SplashScreen extends AnchorPane {

    protected final Pane pane;
    protected final Label label;
    protected final ImageView imageView;
    protected final Button letsPlaybtn;
    protected final Button button;
    protected final ImageView connectImg;
    protected final Label connectionLabel;
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
        connectImg = new ImageView();
        connectionLabel = new Label();
        pane0 = new Pane();
        label0 = new Label();
        pane1 = new Pane();
        label1 = new Label();

        setId("AnchorPane");
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        getStyleClass().add("backgroundColor");
        getStylesheets().add("/css/style.css");

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
        imageView.setImage(new Image(getClass().getResource("/images/images.png").toExternalForm()));

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

        connectImg.setFitHeight(50.0);
        connectImg.setFitWidth(59.0);
        connectImg.setLayoutX(498.0);
        connectImg.setLayoutY(410.0);
        connectImg.setPickOnBounds(true);
        connectImg.setPreserveRatio(true);
        connectImg.setImage(new Image(getClass().getResource("/images/connection.png").toExternalForm()));

        connectionLabel.setLayoutX(450.0);
        connectionLabel.setLayoutY(465.0);
        connectionLabel.setText("Connect to network..");
        connectionLabel.setTextFill(javafx.scene.paint.Color.valueOf("#5b5757"));
        connectionLabel.setFont(new Font("Segoe UI Bold", 15.0));
        connectionLabel.setVisible(false);
        connectionLabel.setTextAlignment(TextAlignment.CENTER);

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
        pane.getChildren().add(connectImg);
        pane.getChildren().add(connectionLabel);
        getChildren().add(pane);
        pane0.getChildren().add(label0);
        getChildren().add(pane0);
        pane1.getChildren().add(label1);
        getChildren().add(pane1);
        
        letsPlaybtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) { 
                Parent root = new MainScreenUI();
                Scene scene = new Scene(root);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

        pane0.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Platform.exit();
            }
        });
        pane1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) pane1.getScene().getWindow();
                stage.setIconified(true);
            }
        });
        
        connectImg.setOnMouseClicked((event)->{
            MessageController message = new MessageController();
            Parent root = new IPDialogBase(message);
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
            System.out.println("Response is   " +message.getResponse());
            boolean isConnected = false;
            switch(message.getResponse()){
                case -1:
                    isConnected = false;
                    break;
                case 0:
                {
                    String IPAddress = message.getIpAddress();
                    isConnected = ClientConnection.connect(IPAddress);
                    break;
                }
                case 1:
                    isConnected = ClientConnection.connect(Constants.IP_ADDRESS);
                    break;
                case 2:
                    isConnected = ClientConnection.connect("127.0.0.1");
                    break;
            }
            if(isConnected){
                connectionLabel.setTextFill(javafx.scene.paint.Color.valueOf("#00ff00"));
                connectionLabel.setText("Connected Successfully");
            }
            else{
                connectionLabel.setTextFill(javafx.scene.paint.Color.valueOf("#5b5757"));
                connectionLabel.setText("Not Connected \nYou Can still play locally");
            }
            connectionLabel.setVisible(true);
        });
        connectImg.setOnMouseEntered((event)->{
            connectionLabel.setTextFill(javafx.scene.paint.Color.valueOf("#5b5757"));
            connectionLabel.setText("Connect to network..");
            connectionLabel.setVisible(true);
        });
        connectImg.setOnMouseExited((event)->{
            connectionLabel.setVisible(false);
        });

    }
}