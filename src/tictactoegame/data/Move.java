/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.data;

/**
 *
 * @author ghon
 */
public class Move {
    private char sign;
    private int box;
    private int gameState;
    public Move(){}
    public Move(char sign,int box){
        this.sign=sign;
        this.box=box;
    }
     public Move(char sign,int box,int gameState){
        this.sign=sign;
        this.box=box;
        this.gameState=gameState;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }
    
}
