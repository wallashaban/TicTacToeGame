package tictactoegame.MainScreen;

import ClientGame.ClientGameScreenBase;
import tictactoegame.Login.LoginDesignUI;
import tictactoegame.ProfileScreen.ProfileScreenBase;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tictactoegame.AvailableUsersScreen.AvailableUsersScreen;
import tictactoegame.AvailbleUsersScreenUI;
import tictactoegame.GameVsPC.GameVsPcBaseUI;
import tictactoegame.HistoryScreen;
import tictactoegame.LocalGame.GameRoomScreen;
import tictactoegame.connection.ClientConnection;
import tictactoegame.connection.Constants;
import tictactoegame.data.DragScreen;
import tictactoegame.data.MessageController;
import tictactoegame.data.Player;
import tictactoegame.data.SharedData;
import tictactoegame.dialogs.IPDialogBase;

public class MainScreenUI extends AnchorPane {

    protected final BorderPane borderPane;
    protected final Pane onlinePane;
    protected final ImageView imageView;
    protected final Label label;
    protected final Pane computerPane;
    protected final Label label0;
    protected final ImageView imageView0;
    protected final Pane localPane;
    protected final ImageView imageView1;
    protected final Label label1;
    protected final ImageView imageView2;
    protected final Pane pane;
    protected final Label label2;
    protected final Pane pane0;
     protected final Label menuText;
    protected final Pane menuPane;
   // protected final ImageView menuImageView;
    protected final Pane closePane;
    protected final Label label3;
    protected final Pane minimizePane;
    protected final Label label4;
    protected final Pane pane1;
    protected final ImageView refreshImg;
    protected final Label connectionLabel;

    public MainScreenUI() {

        borderPane = new BorderPane();
        onlinePane = new Pane();
        imageView = new ImageView();
        label = new Label();
        computerPane = new Pane();
        label0 = new Label();
        imageView0 = new ImageView();
        localPane = new Pane();
        imageView1 = new ImageView();
        label1 = new Label();
        imageView2 = new ImageView();
        pane = new Pane();
        label2 = new Label();
        pane0 = new Pane();
        menuText = new Label();
        menuPane = new Pane();
       // menuImageView = new ImageView();
        closePane = new Pane();
        label3 = new Label();
        minimizePane = new Pane();
        label4 = new Label();
        pane1 = new Pane();
        refreshImg = new ImageView();
        connectionLabel = new Label();

        setId("AnchorPane");
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        getStyleClass().add("backgroundColor");
        getStylesheets().add("/css/style.css");

        borderPane.setLayoutX(1.0);
        borderPane.setLayoutY(1.0);
        borderPane.setPrefHeight(600.0);
        borderPane.setPrefWidth(800.0);

        BorderPane.setAlignment(onlinePane, javafx.geometry.Pos.CENTER);
        onlinePane.setMaxHeight(250.0);
        onlinePane.setMaxWidth(220.0);
        onlinePane.setPrefHeight(220.0);
        onlinePane.setPrefWidth(220.0);
        onlinePane.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 30; -fx-border-radius: 30;");
        BorderPane.setMargin(onlinePane, new Insets(50.0, 20.0, 100.0, 20.0));

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(23.0);
        imageView.setLayoutY(14.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/images/avatar.jpg").toExternalForm()));

        label.setLayoutX(75.0);
        label.setLayoutY(208.0);
        label.setPrefHeight(17.0);
        label.setPrefWidth(70.0);
        label.setText("Online");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#dba7b7"));
        label.setFont(new Font("Gill Sans MT", 24.0));
        borderPane.setLeft(onlinePane);

        BorderPane.setAlignment(computerPane, javafx.geometry.Pos.CENTER);
        computerPane.setMaxHeight(250.0);
        computerPane.setMaxWidth(220.0);
        computerPane.setPrefHeight(250.0);
        computerPane.setPrefWidth(220.0);
        computerPane.setStyle("-fx-background-color: #FFFFFF; -fx-border-radius: 30; -fx-background-radius: 30;");
        BorderPane.setMargin(computerPane, new Insets(50.0, 20.0, 100.0, 20.0));

        label0.setLayoutX(63.0);
        label0.setLayoutY(208.0);
        label0.setPrefHeight(29.0);
        label0.setPrefWidth(107.0);
        label0.setText("Computer");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#dba7b7"));
        label0.setFont(new Font("Gill Sans MT", 24.0));

        imageView0.setFitHeight(150.0);
        imageView0.setFitWidth(200.0);
        imageView0.setLayoutX(37.0);
        imageView0.setLayoutY(28.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/images/avatar.jpg").toExternalForm()));
        borderPane.setCenter(computerPane);

        BorderPane.setAlignment(localPane, javafx.geometry.Pos.CENTER);
        localPane.setMaxHeight(250.0);
        localPane.setMaxWidth(220.0);
        localPane.setPrefHeight(250.0);
        localPane.setPrefWidth(220.0);
        localPane.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30; -fx-border-radius: 30;");
        BorderPane.setMargin(localPane, new Insets(50.0, 20.0, 100.0, 20.0));

        imageView1.setFitHeight(150.0);
        imageView1.setFitWidth(200.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);

        label1.setLayoutX(86.0);
        label1.setLayoutY(205.0);
        label1.setPrefHeight(21.0);
        label1.setPrefWidth(95.0);
        label1.setText("Local");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#dba7b7"));
        label1.setFont(new Font("Gill Sans MT", 24.0));

        imageView2.setFitHeight(150.0);
        imageView2.setFitWidth(200.0);
        imageView2.setLayoutX(35.0);
        imageView2.setLayoutY(30.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("/images/avatar.jpg").toExternalForm()));
        borderPane.setRight(localPane);

        BorderPane.setAlignment(pane, javafx.geometry.Pos.CENTER);
        pane.setMaxHeight(100.0);
        pane.setPrefHeight(200.0);
        pane.setPrefWidth(200.0);

        label2.setLayoutX(340.0);
        label2.setLayoutY(40.0);
        label2.setPrefHeight(21.0);
        label2.setPrefWidth(135.0);
        label2.setStyle("-fx-background-color: transparent;");
        label2.setText("Choose Game");
        label2.setTextFill(javafx.scene.paint.Color.WHITE);
        label2.setFont(new Font("Gill Sans MT Bold", 18.0));

        pane0.setLayoutX(340.0);
        pane0.setLayoutY(65.0);
        pane0.setPrefHeight(14.0);
        pane0.setPrefWidth(95.0);
        pane0.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 30;");
        
        //////////////////////////////////////
        menuText.setLayoutX(10.0);
        menuText.setLayoutY(40.0);
        menuText.setPrefHeight(21.0);
        menuText.setPrefWidth(135.0);
        menuText.setStyle("-fx-background-color: transparent;");
        menuText.setText("History");
        menuText.setTextFill(javafx.scene.paint.Color.WHITE);
        menuText.setFont(new Font("Gill Sans MT Bold", 18.0));

        menuPane.setLayoutX(10.0);
        menuPane.setLayoutY(65.0);
        menuPane.setPrefHeight(14.0);
        menuPane.setPrefWidth(45.0);
        menuPane.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 30;");
//////////////////////////////////////////

//        menuImageView.setFitHeight(51.0);
//        menuImageView.setFitWidth(43.0);
//        menuImageView.setLayoutX(14.0);
//        menuImageView.setLayoutY(39.0);
//        menuImageView.setPickOnBounds(true);
//        menuImageView.setPreserveRatio(true);
//        menuImageView.setImage(new Image(getClass().getResource("/images/menu.jpg").toExternalForm()));

        closePane.setLayoutX(736.0);
        closePane.setLayoutY(10.0);
        closePane.setPrefHeight(50.0);
        closePane.setPrefWidth(50.0);
        closePane.setStyle("-fx-background-color: #EACCD6; -fx-background-radius: 30;");

        label3.setLayoutX(15.0);
        label3.setLayoutY(11.0);
        label3.setText("X");
        label3.setTextFill(javafx.scene.paint.Color.WHITE);
        label3.setFont(new Font("Gill Sans MT Bold", 24.0));

        minimizePane.setLayoutX(670.0);
        minimizePane.setLayoutY(10.0);
        minimizePane.setPrefHeight(50.0);
        minimizePane.setPrefWidth(50.0);
        minimizePane.setStyle("-fx-background-color: #EACCD6; -fx-background-radius: 30;");

        label4.setLayoutX(683.0);
        label4.setLayoutY(-13.0);
        label4.setText("-");
        label4.setTextFill(javafx.scene.paint.Color.WHITE);
        label4.setFont(new Font("Gill Sans MT Bold", 72.0));
        borderPane.setTop(pane);

        BorderPane.setAlignment(pane1, javafx.geometry.Pos.CENTER);
        pane1.setPrefHeight(68.0);
        pane1.setPrefWidth(818.0);

        refreshImg.setFitHeight(70.0);
        refreshImg.setFitWidth(82.0);
        refreshImg.setLayoutX(70.0);
        refreshImg.setLayoutY(-20.0);
        refreshImg.setPickOnBounds(true);
        refreshImg.setPreserveRatio(true);
        refreshImg.setImage(new Image(getClass().getResource("/images/refresh.png").toExternalForm()));

        connectionLabel.setLayoutX(181.0);
        connectionLabel.setLayoutY(5.0);
        connectionLabel.setText("Refresh Connection...");
        connectionLabel.setTextFill(javafx.scene.paint.Color.valueOf("#5b5757"));
        connectionLabel.setFont(new Font("Segoe UI Bold", 15.0));
        borderPane.setBottom(pane1);
        connectionLabel.setVisible(false);
        connectionLabel.setTextAlignment(TextAlignment.CENTER);

        onlinePane.getChildren().add(imageView);
        onlinePane.getChildren().add(label);
        computerPane.getChildren().add(label0);
        computerPane.getChildren().add(imageView0);
        localPane.getChildren().add(imageView1);
        localPane.getChildren().add(label1);
        localPane.getChildren().add(imageView2);
        pane.getChildren().add(label2);
        pane.getChildren().add(pane0);
        pane.getChildren().add(menuText);
        pane.getChildren().add(menuPane);
        closePane.getChildren().add(label3);
        pane.getChildren().add(closePane);
        pane.getChildren().add(minimizePane);
        pane.getChildren().add(label4);
        pane1.getChildren().add(refreshImg);
        pane1.getChildren().add(connectionLabel);
        getChildren().add(borderPane);
        
        computerPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Parent root = new GameVsPcBaseUI();
                //Scene scene = new Scene(root);
                //stage.setScene(scene);
                //stage.initStyle(StageStyle.UNDECORATED); 
                DragScreen.displayScreen(stage,root);
                //stage.show();
            }
        });
        localPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Parent root = new GameRoomScreen();
                //Scene scene = new Scene(root);
                //stage.setScene(scene);
                //stage.initStyle(StageStyle.UNDECORATED); 
                DragScreen.displayScreen(stage,root);
                //stage.show();
            }
        });
        onlinePane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = SharedData.getStage();
                Parent root;
                if(SharedData.getCurrentPlayer() == null){
                    root = new LoginDesignUI();
                }
                else{
                    root = new AvailbleUsersScreenUI();
                }
                //Scene scene = new Scene(root);
                //stage.setScene(scene);
                //stage.initStyle(StageStyle.UNDECORATED); 
                DragScreen.displayScreen(stage,root);
                //stage.show();
            }
        });

        menuText.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root = new HistoryScreen();
                //Scene scene = new Scene(root);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                //stage.setScene(scene);
                //stage.initStyle(StageStyle.UNDECORATED); 
                DragScreen.displayScreen(stage,root);
                //stage.show();
            }
        });

        closePane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
              //  ClientConnection.closeConnection();
                Platform.exit();
            }
        });
        minimizePane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) minimizePane.getScene().getWindow();
                stage.setIconified(true);
            }
        });
        
        refreshImg.setOnMouseClicked((event)->{
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
                onlinePane.setDisable(false);
                ///menuImageView.setDisable(false);
                connectionLabel.setTextFill(javafx.scene.paint.Color.valueOf("#00ff00"));
                connectionLabel.setText("Connected Successfully");
            }
            else{
                onlinePane.setDisable(true);
               // menuImageView.setDisable(true);
                connectionLabel.setTextFill(javafx.scene.paint.Color.valueOf("#5b5757"));
                connectionLabel.setText("Not Connected \nYou Can still play locally");
            }
            connectionLabel.setVisible(true);
        });
        refreshImg.setOnMouseEntered((event)->{
            connectionLabel.setTextFill(javafx.scene.paint.Color.valueOf("#5b5757"));
            connectionLabel.setText("Refresh Connection...");
            connectionLabel.setVisible(true);
        });
        refreshImg.setOnMouseExited((event)->{
            connectionLabel.setVisible(false);
        });
        
        onlinePane.setDisable(!(SharedData.isConnectionStatus()));
       // menuImageView.setDisable(!(SharedData.isConnectionStatus()));
        refreshImg.setVisible(!(SharedData.isConnectionStatus()));
    }
}
