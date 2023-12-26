/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoegame.data.SharedData;
import tictactoegame.AvailableUsersScreen.AvailableUsersScreen;
import tictactoegame.AvailbleUsersScreenUI;
import tictactoegame.data.Player;
import tictactoegame.dialogs.DisconnectedDialogBase;
import tictactoegame.dialogs.AlertDialogBase;
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
        SharedData.setConnectionStatus(true);
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
            case "AvailableUsers":
                updateAvailableUsers(response);
                break;
            case "refuse":
                requestRefused(response);
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
        } else if(response.get(1).equals("Duplicate Username")) {
            Platform.runLater(()->{
                showAlertDialog("This Username already exists in another account.");
            });
        }
        else if(response.get(1).equals("Duplicate Email")){
            Platform.runLater(()->{
                showAlertDialog("This Email already exists in another account.\n If it's yours, you can log in");
            });
        }
        else if(response.get(1).equals("Failure")){
            Platform.runLater(()->{
                showAlertDialog("Registration Failed.. Please Try Again");
            });
        }
        System.out.println("signupresponse after");
    }

    private static void login(ArrayList<String> response) {
        if (response.get(1).equals("Success")) {
//            System.out.println("Login Successfully");
            Gson gson = new GsonBuilder().create();
            Player player = gson.fromJson(response.get(2), Player.class);
            if (player != null) {
                SharedData.setCurrentPlayer(player);
                Platform.runLater(()->{
                    Stage stage = SharedData.getStage();
                    Parent root = new AvailableUsersScreen();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                });
            }
        } else {
            Platform.runLater(()->{
                showAlertDialog("Login Failed. Please check your email and password and try again");
            });
        }
    }

    private static void handlePlayRequest(ArrayList<String> response) {
        //show request dialog and wait for response to send it to server
    }

    private static void startGame(ArrayList<String> response) {
        //navigate to online game screen
    }

    private static void showNoConnectionDialog() {
        String message = "Couldn't Connect to Server. Please check your conncection and try again.";
        Parent parent = new AlertDialogBase(message);
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
    private static void updateAvailableUsers(ArrayList<String> response){
        System.out.println(response.get(0));
        Gson gson = new GsonBuilder().create();
        String jsonArrayOFPlayers = response.get(1);
        ArrayList<Player> availablePlayers = gson.fromJson(jsonArrayOFPlayers, ArrayList.class);
        SharedData.availablePlayers = availablePlayers;
        System.out.println("Available Players: "+ SharedData.availablePlayers.toString());
    }
    private static void showAlertDialog(String message) {
            Parent parent = new AlertDialogBase(message);
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();
        }
    private static void requestRefused(ArrayList<String> response){
        //Show dialog that sayas request is refuse
        //return to available users screen
        Platform.runLater(()->{
                showAlertDialog(response.get(1)+" refused your request to play. You can request him again or try playing with another player");
            });
    }
} 
