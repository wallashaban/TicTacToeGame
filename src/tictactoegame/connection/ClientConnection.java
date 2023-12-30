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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tictactoegame.data.SharedData;
import tictactoegame.AvailableUsersScreen.AvailableUsersScreen;
import tictactoegame.AvailbleUsersScreenUI;
import tictactoegame.LocalGame.GameRoomScreen;
import tictactoegame.MainScreen.MainScreenUI;
import tictactoegame.data.Player;
import tictactoegame.data.Request;

//import tictactoegame.dialogs.NoConnectionDialogBase;
import tictactoegame.dialogs.drawDialogBase;
import tictactoegame.dialogs.AlertDialogBase;
import tictactoegame.dialogs.DisconnectedDialogBase;


/**
 *
 * @author anasn
 */
public class ClientConnection {

    private static Thread thread;
    private static Socket mySocket;
    public static DataInputStream in;
    public static PrintStream out;
    private static ArrayList responceData;
    public static Thread listeningThread;
    public static boolean connect(String IPAddress) {
        boolean isConnected = false;
        try {
            mySocket = new Socket(IPAddress, Constants.PORT);
            in = new DataInputStream(mySocket.getInputStream());
            out = new PrintStream(mySocket.getOutputStream());
            SharedData.setConnectionStatus(true);
            isConnected = true;
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
//            showNoConnectionDialog();
            SharedData.setConnectionStatus(false);
            isConnected = false;
        }
        startListening();
        return isConnected;
    }

    public static void closeConnection() {
        try {
            if(!mySocket.isClosed()){
            listeningThread.stop();
            ArrayList<String> requestArray = new ArrayList<String>();
            requestArray.add("logout");
            Gson gson = new GsonBuilder().create();
            String request = gson.toJson(requestArray);
            sendRequest(request);
            //out.println("logout");
           String msgArray = in.readLine();
//           System.out.println(msgArray);
//            ArrayList<String> messages = gson.fromJson(msgArray, ArrayList.class);
//            String msg = messages.get(0);
            if (msgArray.equals("exit")) {
                in.close();
                out.close();
                mySocket.close();
            }
                System.out.println("Done Closing");
            }
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
        listeningThread = new Thread(() -> {
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
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        showDisconnectedDialog();
                    }
                });
                Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        listeningThread.start();

    }

    public static void handleResponse(String gsonResponse) {
        Gson gson = new GsonBuilder().create();
        ArrayList<String> response;
        if(!(gsonResponse.startsWith("[")))
            gsonResponse = "[" +gsonResponse;
        System.out.println(gsonResponse);
        
        response = gson.fromJson(gsonResponse, ArrayList.class);
        if (response == null) {
            System.out.println("Response is null");
            return;
        }


        String action = response.get(0).trim();
        action = action.replaceAll("\"", "");
        System.out.println("Action is" + action);
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
                    Parent root = new AvailbleUsersScreenUI();
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
        System.out.println("Inside Handle Play Request");
        String name = response.get(1);
        Platform.runLater(()->{
            Request request = new Request();
            response.clear();
            Constants.showRequestDialog(name, request);
            if(request.getResponse()==1)
            {
                response.add("accept");
                response.add(name);
                Gson gson = new GsonBuilder().create();
                String responseJSon = gson.toJson(response);
                sendRequest(responseJSon);   
            }else
            {
                response.add("refuse");
                response.add(name);
                Gson gson = new GsonBuilder().create();
                String responseJSon = gson.toJson(response);
                sendRequest(responseJSon);   
            }
        });
        
    }

    private static void startGame(ArrayList<String> response) {
        Platform.runLater(()->{
            Parent root = new GameRoomScreen();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Text Editor app");
            stage.setScene(scene);
            stage.show();
        });
        
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
        Platform.runLater(()->{
                showAlertDialog(response.get(1)+" refused your request to play. You can request him again or try playing with another player");
            });
    }
} 
