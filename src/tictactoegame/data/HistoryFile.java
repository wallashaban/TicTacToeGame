/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

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

    public void saveToFile(Player player) {
        try {
            System.out.println("lines");
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
    
}
