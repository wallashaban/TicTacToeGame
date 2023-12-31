package tictactoegame.old;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoegame.data.Player;

public  class AvailableUsersScreen extends Pane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final Pane pane0;
    protected final Label label;
    protected final Pane pane1;
    protected final Label label0;
    protected final Hyperlink hyperlink;
    protected final Pane pane2;
    protected final Label label1;
    protected final Hyperlink hyperlink0;
    protected final Button button;
            ArrayList<Player> avaliablePlayerList;


    public AvailableUsersScreen(Stage stage) {

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

        pane = new Pane();
        imageView = new ImageView();
        pane0 = new Pane();
        label = new Label();
        pane1 = new Pane();
        label0 = new Label();
        hyperlink = new Hyperlink();
        pane2 = new Pane();
        label1 = new Label();
        hyperlink0 = new Hyperlink();
        button = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #FFFFFF;");

        pane.setLayoutX(7.0);
        pane.setLayoutY(14.0);
        pane.setPrefHeight(155.0);
        pane.setPrefWidth(152.0);

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(168.0);
        imageView.setLayoutX(7.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/images/xo.png").toExternalForm()));

        pane0.setLayoutX(201.0);
        pane0.setLayoutY(134.0);
        pane0.setPrefHeight(54.0);
        pane0.setPrefWidth(225.0);
        pane0.setStyle("-fx-background-color: #FAF9F6; -fx-background-radius: 30 30 30 30;");

        label.setLayoutX(27.0);
        label.setLayoutY(10.0);
        label.setText("Available Users");
        label.setFont(new Font("System Bold", 24.0));

        pane1.setLayoutX(14.0);
        pane1.setLayoutY(226.0);
        pane1.setPrefHeight(73.0);
        pane1.setPrefWidth(240.0);
        pane1.setStyle("-fx-background-color: #94CBF0; -fx-background-radius: 25 25 25 25;");

        label0.setLayoutX(14.0);
        label0.setLayoutY(9.0);
        label0.setText("Walaa Shaaban");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font(24.0));

        hyperlink.setLayoutX(14.0);
        hyperlink.setLayoutY(44.0);
        hyperlink.setPrefHeight(23.0);
        hyperlink.setPrefWidth(114.0);
        hyperlink.setStyle("-fx-border-color: transparent;");
        hyperlink.setText("Challenge Now");
        hyperlink.setTextFill(javafx.scene.paint.Color.valueOf("#eb8fb4"));
        hyperlink.setFont(new Font("System Bold", 14.0));

        pane2.setLayoutX(337.0);
        pane2.setLayoutY(226.0);
        pane2.setPrefHeight(73.0);
        pane2.setPrefWidth(240.0);
        pane2.setStyle("-fx-background-color: #EB8FB4; -fx-background-radius: 25 25 25 25;");

        label1.setLayoutX(14.0);
        label1.setLayoutY(9.0);
        label1.setText("Tasneem Ibrahim");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font(24.0));

        hyperlink0.setLayoutX(14.0);
        hyperlink0.setLayoutY(44.0);
        hyperlink0.setPrefHeight(23.0);
        hyperlink0.setPrefWidth(114.0);
        hyperlink0.setText("Challenge Now");
        hyperlink0.setFont(new Font("System Bold", 14.0));

        button.setLayoutX(268.0);
        button.setLayoutY(327.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(25.0);
        button.setPrefWidth(82.0);
        button.setStyle("-fx-background-color: #D9D9D9; -fx-background-radius: 10 10 10 10;");
        button.setText("Back");
        button.setFont(new Font("System Bold", 18.0));

        pane.getChildren().add(imageView);
        getChildren().add(pane);
        pane0.getChildren().add(label);
        getChildren().add(pane0);
        pane1.getChildren().add(label0);
        pane1.getChildren().add(hyperlink);
        getChildren().add(pane1);
        pane2.getChildren().add(label1);
        pane2.getChildren().add(hyperlink0);
        getChildren().add(pane2);
        getChildren().add(button);
        
        button.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        Parent root = new MainScreen();
                        Scene scene = new Scene(root);
         
                        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                        stage.setTitle("Text Editor app");
                        stage.setScene(scene);
                        stage.show();
                    }});
        
        hyperlink.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        Parent root = new GameRoomDesignBase(stage);
                        Scene scene = new Scene(root);
         
                        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                        stage.setTitle("Text Editor app");
                        stage.setScene(scene);
                        stage.show();
                    }});
        
        

    }
}
