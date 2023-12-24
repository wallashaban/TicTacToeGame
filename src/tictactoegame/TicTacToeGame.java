/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Pair;

/**
 *
 * @author Dr.Wlaa
 */
public class TicTacToeGame extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = new SplashScreen();// FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        

        
       // Parent root = FXMLLoader.load(getClass().getResource("GameRoomDesign.fxml"));
//         BorderPane rootb = new BorderPane();
//        gameRoomDesignBase teb= new gameRoomDesignBase();
//        rootb.getChildren().add(teb);
//        Scene scene = new Scene(rootb, 720, 720);
//        Scene scene = new Scene(rootb, 720, 720);
//         BorderPane rootb = new BorderPane();
//        GameRoomDesignBase teb= new GameRoomDesignBase();
//        rootb.getChildren().add(teb);
          Scene scene = new Scene(root);

        stage.initStyle(StageStyle.UNDECORATED); 
        stage.setTitle("Text Editor app");
         
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        
        launch(args);
        

    }
    
}
