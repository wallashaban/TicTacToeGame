/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.data;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author ghon
 */
public class Player {
    private String userName;
    private String password;
    private String email;
    private boolean available;
    private String playerImage;
    private byte[] salt;
    private boolean isPlaying;
    private long score;
   
    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getPlayerImage() {
        return playerImage;
    }

    public boolean isIsPlaying() {
        return isPlaying;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setPlayerImage(String playerImage) {
        this.playerImage = playerImage;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public void setIsPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
  
    public Player(String userName, String password, String email, boolean available, String playerImage) {
        
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.available = available;
        this.playerImage = playerImage;
    }

    public Player() {
    }

    @Override
    public String toString() {
        return "Player{" + "userName=" + userName + ", password=" + password + ", email=" + email + ", available=" + available + ", playerImage=" + playerImage + ", salt=" + salt + '}';
    }

   
   
}
