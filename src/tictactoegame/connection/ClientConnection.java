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
import tictactoegame.data.Player;


/**
 *
 * @author anasn
 */
public class ClientConnection {    
    Socket mySocket;
    DataInputStream in;
    PrintStream out;
    ArrayList responceData;
    
    protected final Dialog<String> noConnectionDialog;
    protected final Dialog<String> disconnectedDialog;
    
    public ClientConnection(){
        noConnectionDialog = new Dialog<String>();
        noConnectionDialog.setTitle("No Connection");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        noConnectionDialog.setContentText("Couldn't Connect to Server.\nPlease make sure server is connected and try again.");
        noConnectionDialog.getDialogPane().getButtonTypes().add(type);
        disconnectedDialog = new Dialog<String>();
        disconnectedDialog.setTitle("No Connection");
        disconnectedDialog.setContentText("It seems you are disconnected.");
        disconnectedDialog.getDialogPane().getButtonTypes().add(type);

    }

    public void connect() {
        try {
            mySocket = new Socket(Constants.IP_ADDRESS, Constants.PORT);
            in = new DataInputStream(mySocket.getInputStream());
            out = new PrintStream(mySocket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
            noConnectionDialog.showAndWait();
        }
        startListening();
    }

    public void closeConnection() {
        try {
            in.close();
            out.close();
            mySocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendRequest(String gson) {
        if(out != null)
            out.println(gson);
    }

    public void startListening() {
        new Thread(() -> {
            try {
                while (mySocket != null && !(mySocket.isClosed()) && in !=null) {
                    String gsonResponse = in.readLine();
                    handleResponse(gsonResponse);
                }
            } catch (IOException ex) {
                Platform.runLater(new Runnable(){
                            @Override
                            public void run(){
                                disconnectedDialog.showAndWait();
                            }
                        });
                Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }
    
    public void handleResponse(String gsonResponse) {
        Gson gson = new GsonBuilder().create();
        ArrayList<String> response;
        response = gson.fromJson(gsonResponse, ArrayList.class);
        if(response == null){
            System.out.println("Response is null");
            return;
        }
            
        String action = response.get(0);
        switch (action){
            case "register":
                register();
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
    
    private void register() {

    }
    
    private void login(ArrayList<String> response) {
        if(response.get(1).equals("Success")){
            System.out.println("Login Successfully");
            Gson gson = new GsonBuilder().create();
            Player player = gson.fromJson(response.get(2), Player.class);
            if(player != null){
                SharedData.setCurrentPlayer(player);
                System.out.println(player.toString());
                Stage stage = SharedData.getStage();
                Parent root = new AvailableUsersScreen();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
        else{
            System.out.println("Login Failed");
            System.out.println(response.get(1));
        }
    }
    
    private void handlePlayRequest(ArrayList<String> response){
        //show request dialog and wait for response to send it to server
    }
    
    private void startGame(ArrayList<String> response){
        //navigate to online game screen
    }
} 

