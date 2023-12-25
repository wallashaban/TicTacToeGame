/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.stage.Stage;
import tictactoegame.data.SharedData;
import tictactoegame.AvailableUsersScreen.AvailableUsersScreen;
import tictactoegame.AvailbleUsersScreenUI;
import tictactoegame.data.Player;
import tictactoegame.dialogs.DisconnectedDialogBase;
import tictactoegame.dialogs.NoConnectionDialogBase;
import tictactoegame.dialogs.drawDialogBase;

/**
 *
 * @author anasn
 */
public class ClientConnection {

    private static Socket mySocket;
    private static DataInputStream in;
    private static PrintStream out;
    private static ArrayList responceData;
    public static void connect() {
        try {
            mySocket = new Socket(Constants.IP_ADDRESS, Constants.PORT);
            in = new DataInputStream(mySocket.getInputStream());
            out = new PrintStream(mySocket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
            showNoConnectionDialog();
        }
        startListening();
    }

    public static void closeConnection() {
        try {
            in.close();
            out.close();
            mySocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void sendRequest(String gson) {
        if (out != null) {
            out.println(gson);
        }
    }

    public static void startListening() {
        new Thread(() -> {
            try {
                while (mySocket != null && !(mySocket.isClosed()) && in != null) {
                    String gsonResponse = in.readLine();
                    handleResponse(gsonResponse);
                }
            } catch (IOException ex) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        showDisconnectedDialog();
                    }
                });
                Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }

    public static void handleResponse(String gsonResponse) {
        Gson gson = new GsonBuilder().create();
        ArrayList<String> response;
        response = gson.fromJson(gsonResponse, ArrayList.class);
        if (response == null) {
            System.out.println("Response is null");
            return;
        }

        String action = response.get(0);
        switch (action) {
            case "signup":
                System.err.println("signupresponse switch case");
                signUp(response);
                break;
            case "login":
                login(response);
                break;
            case "request":
                handlePlayRequest(response);
                break;
            case "startGame":
                startGame(response);
                break;
//            case 5:
//                //TODO updateBoard();
//                break;
//            case 6:
//                //TODO logout();
//                break;
//            case 7:
//                // TODO save();
//                break;
//            case 8:
//                //TODO finish();
//                break;
//            case 9:
//                //TODO updateScore();
//                break;
//            case 10:
//                // TODO sendMessage();
//                break;
        }
    }

    private static void signUp(ArrayList<String> response) {
        System.out.println("signupresponse");
        if (response.get(1).equals("Success")) {
            System.out.print("logined");
            Platform.runLater(() -> {

                Stage stage = SharedData.getStage();
                Parent root = new AvailbleUsersScreenUI();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            });
        } else {
            System.out.println("signupresponse else");
        }
        System.out.println("signupresponse after");
    }

    private static void login(ArrayList<String> response) {
        if (response.get(1).equals("Success")) {
            System.out.println("Login Successfully");
            Gson gson = new GsonBuilder().create();
            Player player = gson.fromJson(response.get(2), Player.class);
            if (player != null) {
                SharedData.setCurrentPlayer(player);
                System.out.println(player.toString());
                Stage stage = SharedData.getStage();
                Parent root = new AvailableUsersScreen();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } else {
            System.out.println("Login Failed");
            System.out.println(response.get(1));
        }
    }

    private static void handlePlayRequest(ArrayList<String> response) {
        //show request dialog and wait for response to send it to server
    }

    private static void startGame(ArrayList<String> response) {
        //navigate to online game screen
    }

    private static void showNoConnectionDialog() {
        Parent parent = new NoConnectionDialogBase();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }

    private static void showDisconnectedDialog() {
        Parent parent = new DisconnectedDialogBase();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
}
