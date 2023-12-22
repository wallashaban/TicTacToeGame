package tictactoegame.availableUsers;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tictactoegame.LocalGame.GameRoomScreen;
import tictactoegame.data.Player;
import tictactoegame.data.SharedData;

public class AvailableUsersScreen extends AnchorPane {

    protected final FlowPane flowPane;
    protected final Pane availableUsersPane;
    protected final Label nameLabel;
    protected final Hyperlink chalengeNowLink;
    protected final Pane pane;
    protected final Pane pane0;
    protected final Label label;
    protected final Hyperlink hyperlink;
    protected final Pane pane1;
    protected final Label label0;
    protected final Hyperlink hyperlink0;
    protected final Pane pane2;
    protected final Label label1;
    protected final Pane closePane;
    protected final Label label2;
    protected final Pane minimisePane;
    protected final Label label3;
    ArrayList<Player> avaliablePlayerList;
    public AvailableUsersScreen() {
        
            try {
                System.out.println("client up and running");
                Socket socket = new Socket("127.0.0.1", 7777);
                        System.out.println("in app after connection");

                DataInputStream ear = new DataInputStream(socket.getInputStream());
                PrintStream mouth = new PrintStream(socket.getOutputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());


             //   mouth.println("i am the client who are you?");
                mouth.println("i want all avaliable users");
           
//            try {
//                                    System.out.println("before ois");
//
//                                                System.out.println("after ois");
//
//                //Player ptest = (Player)ois.readObject();
//                System.out.println("after read object");
//                System.out.println(ptest.toString());
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(AvailableUsersScreen.class.getName()).log(Level.SEVERE, null, ex);
//            }
           /* for(int i=0;i<avaliablePlayerList.size();i++){
                System.out.println(avaliablePlayerList.get(i).username);
            }*/
           
        } catch (IOException e) {
        }

        flowPane = new FlowPane();
        availableUsersPane = new Pane();
        nameLabel = new Label();
        chalengeNowLink = new Hyperlink();
        pane = new Pane();
        pane0 = new Pane();
        label = new Label();
        hyperlink = new Hyperlink();
        pane1 = new Pane();
        label0 = new Label();
        hyperlink0 = new Hyperlink();
        pane2 = new Pane();
        label1 = new Label();
        closePane = new Pane();
        label2 = new Label();
        minimisePane = new Pane();
        label3 = new Label();

        setId("AnchorPane");
        setMaxHeight(600.0);
        setMaxWidth(800.0);
        setPrefHeight(800.0);
        setPrefWidth(800.0);
        getStyleClass().add("backgroundColor");
        getStylesheets().add("/css/style.css");

        flowPane.setLayoutX(1.0);
        flowPane.setLayoutY(185.0);
        flowPane.setPrefHeight(349.0);
        flowPane.setPrefWidth(800.0);

        availableUsersPane.setPrefHeight(85.0);
        availableUsersPane.setPrefWidth(221.0);
        availableUsersPane.setStyle("-fx-background-color: #EACCD6; -fx-background-radius: 30;");

        nameLabel.setLayoutX(24.0);
        nameLabel.setLayoutY(14.0);
        nameLabel.setPrefHeight(21.0);
        nameLabel.setPrefWidth(146.0);
        nameLabel.setText("Walaa Shaaban");
        nameLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        nameLabel.setFont(new Font("Gill Sans MT Bold", 18.0));

        chalengeNowLink.setLayoutX(24.0);
        chalengeNowLink.setLayoutY(48.0);
        chalengeNowLink.setPrefHeight(23.0);
        chalengeNowLink.setPrefWidth(106.0);
        chalengeNowLink.setText("Challenge Now");
        chalengeNowLink.setFont(new Font("Gill Sans MT", 14.0));

        pane.setLayoutX(183.0);
        pane.setLayoutY(9.0);
        pane.setPrefHeight(32.0);
        pane.setPrefWidth(62.0);
        pane.setStyle("-fx-background-color: freen;");
        FlowPane.setMargin(availableUsersPane, new Insets(30.0, 10.0, 0.0, 40.0));

        pane0.setLayoutX(30.0);
        pane0.setLayoutY(10.0);
        pane0.setPrefHeight(85.0);
        pane0.setPrefWidth(221.0);
        pane0.setStyle("-fx-background-color: #EACCD6; -fx-background-radius: 30;");

        label.setLayoutX(24.0);
        label.setLayoutY(14.0);
        label.setPrefHeight(21.0);
        label.setPrefWidth(146.0);
        label.setText("Walaa Shaaban");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Gill Sans MT Bold", 18.0));

        hyperlink.setLayoutX(24.0);
        hyperlink.setLayoutY(48.0);
        hyperlink.setPrefHeight(23.0);
        hyperlink.setPrefWidth(106.0);
        hyperlink.setText("Challenge Now");
        hyperlink.setFont(new Font("Gill Sans MT", 14.0));
        FlowPane.setMargin(pane0, new Insets(30.0, 10.0, 0.0, 10.0));

        pane1.setLayoutX(309.0);
        pane1.setLayoutY(10.0);
        pane1.setPrefHeight(85.0);
        pane1.setPrefWidth(221.0);
        pane1.setStyle("-fx-background-color: #EACCD6; -fx-background-radius: 30;");

        label0.setLayoutX(24.0);
        label0.setLayoutY(14.0);
        label0.setPrefHeight(21.0);
        label0.setPrefWidth(146.0);
        label0.setText("Walaa Shaaban");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("Gill Sans MT Bold", 18.0));

        hyperlink0.setLayoutX(24.0);
        hyperlink0.setLayoutY(48.0);
        hyperlink0.setPrefHeight(23.0);
        hyperlink0.setPrefWidth(106.0);
        hyperlink0.setText("Challenge Now");
        hyperlink0.setFont(new Font("Gill Sans MT", 14.0));
        FlowPane.setMargin(pane1, new Insets(30.0, 10.0, 0.0, 10.0));

        pane2.setLayoutX(265.0);
        pane2.setLayoutY(82.0);
        pane2.setPrefHeight(47.0);
        pane2.setPrefWidth(259.0);
        pane2.setStyle("-fx-background-color: #EACCD6; -fx-background-radius: 30;");

        label1.setLayoutX(57.0);
        label1.setLayoutY(13.0);
        label1.setPrefHeight(21.0);
        label1.setPrefWidth(146.0);
        label1.setText("Available Users");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("Gill Sans MT Bold", 18.0));

        closePane.setLayoutX(729.0);
        closePane.setLayoutY(14.0);
        closePane.setPrefHeight(50.0);
        closePane.setPrefWidth(50.0);
        closePane.setStyle("-fx-background-color: #EACCD6; -fx-background-radius: 30;");

        label2.setLayoutX(10.0);
        label2.setLayoutY(4.0);
        label2.setPrefHeight(21.0);
        label2.setPrefWidth(18.0);
        label2.setText("X");
        label2.setTextFill(javafx.scene.paint.Color.WHITE);
        label2.setFont(new Font("Gill Sans MT Bold", 36.0));

        minimisePane.setLayoutX(660.0);
        minimisePane.setLayoutY(14.0);
        minimisePane.setPrefHeight(50.0);
        minimisePane.setPrefWidth(50.0);
        minimisePane.setStyle("-fx-background-color: #EACCD6; -fx-background-radius: 30;");

        label3.setLayoutX(13.0);
        label3.setLayoutY(-28.0);
        label3.setPrefHeight(60.0);
        label3.setPrefWidth(24.0);
        label3.setText("-");
        label3.setTextFill(javafx.scene.paint.Color.WHITE);
        label3.setFont(new Font("Gill Sans MT Bold", 72.0));

        availableUsersPane.getChildren().add(nameLabel);
        availableUsersPane.getChildren().add(chalengeNowLink);
        availableUsersPane.getChildren().add(pane);
        flowPane.getChildren().add(availableUsersPane);
        pane0.getChildren().add(label);
        pane0.getChildren().add(hyperlink);
        flowPane.getChildren().add(pane0);
        pane1.getChildren().add(label0);
        pane1.getChildren().add(hyperlink0);
        flowPane.getChildren().add(pane1);
        getChildren().add(flowPane);
        pane2.getChildren().add(label1);
        getChildren().add(pane2);
        closePane.getChildren().add(label2);
        getChildren().add(closePane);
        minimisePane.getChildren().add(label3);
        getChildren().add(minimisePane);

        hyperlink.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        Parent root = new GameRoomScreen();
                        Scene scene = new Scene(root);
         
                        Stage stage = SharedData.getStage();
                        stage.setScene(scene);
                        stage.show();
                    }});
        
    }
}
