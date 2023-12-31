/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import javafx.util.Pair;
import tictactoegame.GameReplay;

/**
 *
 * @author Dr.Wlaa
 */
public class HistoryFile {

    public BufferedWriter getWriter() {
        return writer;
    }

    public void setWriter(BufferedWriter writer) {
        this.writer = writer;
    }
   private BufferedWriter writer;
     public void createFile(String filePath) {
        // String filePath = "E:/java/TicTacToeGame/src/files/file.txt";

        try {
            // Create the file
            Files.createFile(Paths.get(filePath));
            System.out.println("File created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error creating the file: " + e.getMessage());
        }
    }

    public void saveToFile(String filePath,Player player,String moves) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true)));
            System.out.println("lines");
            writer.write(moves);
            writer.newLine();
            Date d = new Date();
            writer.write(d.toString());
            writer.newLine();
            writer.write(player.getUserName());
            writer.newLine();
            writer.close();
            System.out.println("Text appended successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
     public void readData() {
        try {
            String filePath = "src/files/ahmed.txt";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            String name = new String();
            String date = new String();
            GameReplay gameReplay;
            Map<String, Pair<String, ArrayList<Integer>>> allMoves = new TreeMap<>();
            while ((line = reader.readLine()) != null) {
                ArrayList<Integer> moves = new ArrayList<>();

                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    moves.add(Integer.parseInt(st.nextToken()));
                }
                line = reader.readLine();
                date = line;

                line = reader.readLine();
                name = line;
                Pair<String, ArrayList<Integer>> pair = new Pair<>(name, moves);
                allMoves.put(date, pair);
            }
            System.out.println("Sorted Map by Key:");
            for (Map.Entry<String, Pair<String, ArrayList<Integer>>> entry : allMoves.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            SharedData.gameReplay = new GameReplay(allMoves);
            //String game=  gameReplay.toString();
            //System.out.print(game);
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
}
