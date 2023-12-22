/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.data;

/**
 *
 * @author s
 */
public class Person {
    String userName;
    int id;
    String email;
    String imgPath;
    int score;

    public Person(String username, int id, String email, String imgPath, int playerScore) {
        this.userName = username;
        this.id = id;
        this.email = email;
        this.imgPath = imgPath;
        this.score = playerScore;
    }

    public Person() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
    
}
