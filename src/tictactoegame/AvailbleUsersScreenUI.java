package tictactoegame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoegame.MainScreen.MainScreenUI;
import tictactoegame.connection.ClientConnection;
import tictactoegame.connection.Constants;
import tictactoegame.data.DragScreen;
import tictactoegame.data.Player;
import tictactoegame.data.SharedData;

public class AvailbleUsersScreenUI extends AnchorPane {

    protected final Pane pane;
    protected final Label label;
    protected final Pane closePane;
    protected final Label label0;
    protected final Pane minimisePane;
    protected final Label label1;
    protected final ScrollPane scrollPane;
    protected final FlowPane flowPane;
        protected final Button buttonBack;

    ArrayList<Player> players;
    protected final ImageView refreshImg;
    Thread thread;

    public AvailbleUsersScreenUI() {
        players = new ArrayList<Player>();
        ArrayList<String> messages = new ArrayList<>();
        messages.add("getAvailableUsers");
        Gson gson = new GsonBuilder().create();
        String jsonMessage = gson.toJson(messages);
        //printStream.println(jsonMessage);
        ClientConnection.listeningThread.suspend();
        ClientConnection.sendRequest(jsonMessage);
        thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String response = ClientConnection.in.readLine();
                        if(!response.startsWith("[") && response.startsWith("\"")) {
                            response = "["+response;
                        }
                        if(!response.startsWith("[") && !response.startsWith("\"")) {
                            response = "[\""+response;
                        }
                        ArrayList<String> responseList;
                        System.err.println("list" + response);
                        responseList = gson.fromJson(response, ArrayList.class);
                        
                        switch (responseList.get(0)) {
                            case ("AvailableUsers"):

                                java.lang.reflect.Type playerListType = new TypeToken<List<Player>>() {
                                }.getType();
                                players = gson.fromJson(responseList.get(1), playerListType);
                                System.err.println("length " + players.size());
                                break;
                        }

                        Platform.runLater(() -> {
                            for (int i = 0; i < players.size(); i++) {
                                if (players.get(i).getUserName().equals(SharedData.currentPlayer.getUserName())) {
                                    continue;
                                }
                                Pane availableUsersPane = new Pane();
                                Label nameLabel = new Label();
                                Label scoreLabel = new Label();
                                final Hyperlink chalengeNowLink = new Hyperlink();

                                availableUsersPane.setPrefHeight(105.0);
                                availableUsersPane.setPrefWidth(221.0);
                                availableUsersPane.setStyle("-fx-background-color: #EACCD6; -fx-background-radius: 30;");

                                nameLabel.setLayoutX(24.0);
                                nameLabel.setLayoutY(14.0);
                                nameLabel.setPrefHeight(21.0);
                                nameLabel.setPrefWidth(146.0);
                                nameLabel.setText(players.get(i).getUserName());
                                nameLabel.setTextFill(javafx.scene.paint.Color.WHITE);
                                nameLabel.setFont(new Font("Gill Sans MT Bold", 18.0));

                                scoreLabel.setLayoutX(24.0);
                                scoreLabel.setLayoutY(38.0);
                                scoreLabel.setPrefHeight(21.0);
                                scoreLabel.setPrefWidth(146.0);
                                scoreLabel.setText("Score : " + players.get(i).getScore());
                                scoreLabel.setTextFill(javafx.scene.paint.Color.WHITE);
                                scoreLabel.setFont(new Font("Gill Sans MT Bold", 18.0));

                                chalengeNowLink.setLayoutX(24.0);
                                chalengeNowLink.setLayoutY(68.0);
                                chalengeNowLink.setPrefHeight(23.0);
                                chalengeNowLink.setPrefWidth(106.0);
                                chalengeNowLink.setText("Challenge Now");
                                chalengeNowLink.setFont(new Font("Gill Sans MT", 14.0));
                                
                                String userName = players.get(i).getUserName();
                                chalengeNowLink.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                    @Override
                                    public void handle(MouseEvent event) {

                                        chalengeNowLink.setDisable(true);
                                        ArrayList<String> requestMessages = new ArrayList<String>();
                                        requestMessages.add("request");
                                        requestMessages.add(userName);
                                        Gson gson = new GsonBuilder().create();
                                        String requestJson = gson.toJson(requestMessages);
                                        ClientConnection.sendRequest(requestJson);
                                    }

                                });
                                FlowPane.setMargin(availableUsersPane,
                                        new Insets(30.0, 20.0, 0.0, 20.0));

                                availableUsersPane.getChildren()
                                        .add(nameLabel);
                                availableUsersPane.getChildren()
                                        .add(scoreLabel);
                                availableUsersPane.getChildren()
                                        .add(chalengeNowLink);
                                flowPane.getChildren()
                                        .add(availableUsersPane);
                            }
                            scrollPane.setContent(flowPane);
                            stop();
                        ClientConnection.listeningThread.resume();
                        });
                    } catch (IOException ex) {
                        Logger.getLogger(AvailbleUsersScreenUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }

        };
        thread.start();

        pane = new Pane();
        label = new Label();
        closePane = new Pane();
        label0 = new Label();
        minimisePane = new Pane();
        label1 = new Label();
        scrollPane = new ScrollPane();
        flowPane = new FlowPane();
        refreshImg = new ImageView();
                buttonBack = new Button();


        setId("AnchorPane");
        setMaxHeight(600.0);
        setMaxWidth(800.0);
        setPrefHeight(800.0);
        setPrefWidth(800.0);
        getStyleClass().add("backgroundColor");
        getStylesheets().add("/css/style.css");

        pane.setLayoutX(265.0);
        pane.setLayoutY(82.0);
        pane.setPrefHeight(47.0);
        pane.setPrefWidth(259.0);
        pane.setStyle("-fx-background-color: #EACCD6; -fx-background-radius: 30;");

        label.setLayoutX(57.0);
        label.setLayoutY(13.0);
        label.setPrefHeight(21.0);
        label.setPrefWidth(146.0);
        label.setText("Available Users");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Gill Sans MT Bold", 18.0));

        closePane.setLayoutX(729.0);
        closePane.setLayoutY(14.0);
        closePane.setPrefHeight(50.0);
        closePane.setPrefWidth(50.0);
        closePane.setStyle("-fx-background-color: #EACCD6; -fx-background-radius: 30;");

        label0.setLayoutX(10.0);
        label0.setLayoutY(4.0);
        label0.setPrefHeight(21.0);
        label0.setPrefWidth(18.0);
        label0.setText("X");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("Gill Sans MT Bold", 36.0));

        minimisePane.setLayoutX(660.0);
        minimisePane.setLayoutY(14.0);
        minimisePane.setPrefHeight(50.0);
        minimisePane.setPrefWidth(50.0);
        minimisePane.setStyle("-fx-background-color: #EACCD6; -fx-background-radius: 30;");

        label1.setLayoutX(13.0);
        label1.setLayoutY(-28.0);
        label1.setPrefHeight(60.0);
        label1.setPrefWidth(24.0);
        label1.setText("-");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("Gill Sans MT Bold", 72.0));

        scrollPane.setLayoutY(138.0);
        scrollPane.setPrefHeight(460.0);
        scrollPane.setPrefWidth(800.0);
        scrollPane.getStyleClass().add("backgroundColor");
        scrollPane.getStylesheets().add("/tictactoegame/../css/style.css");

        flowPane.setMaxHeight(USE_PREF_SIZE);
        flowPane.setPrefHeight(460.0);
        flowPane.setPrefWidth(800.0);
        flowPane.getStyleClass().add("backgroundColor");
        flowPane.getStylesheets().add("/css/style.css");
        
        refreshImg.setFitHeight(70.0);
        refreshImg.setFitWidth(82.0);
        refreshImg.setLayoutX(550.0);
        refreshImg.setLayoutY(70);
        refreshImg.setPickOnBounds(true);
        refreshImg.setPreserveRatio(true);
        refreshImg.setImage(new Image(getClass().getResource("/images/refresh.png").toExternalForm()));
        refreshImg.setOnMouseClicked((event)->{
            Stage stage = SharedData.getStage();
            Parent root = new AvailbleUsersScreenUI();
            DragScreen.displayScreen(stage,root);
            //Scene scene = new Scene(root);
            //stage.setScene(scene);
            //stage.show();
//            thread.stop();
//            ClientConnection.listeningThread.resume();
        });
        getChildren().add(refreshImg);

        pane.getChildren().add(label);
        getChildren().add(pane);
        closePane.getChildren().add(label0);
        getChildren().add(closePane);
        minimisePane.getChildren().add(label1);
        getChildren().add(minimisePane);

        getChildren().add(scrollPane);
                getChildren().add(buttonBack);


        closePane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Platform.exit();
            }
        });
        minimisePane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) minimisePane.getScene().getWindow();
                stage.setIconified(true);
            }
        });

         buttonBack.setLayoutX(15.0);
        buttonBack.setLayoutY(7.0);
        buttonBack.setMnemonicParsing(false);
        buttonBack.setStyle("-fx-background-color: e8ccd5; -fx-background-radius: 30;");
        buttonBack.setText("<");
        buttonBack.setFont(new Font("Gill Sans MT Bold Italic", 19.0));
        //setTop(pane);
        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Parent root = new MainScreenUI();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });


    }
}
