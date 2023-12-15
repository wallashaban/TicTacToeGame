/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author ghon
 */
public class Player {

    Point p00 = new Point(0, 0);
    Point p01 = new Point(0, 1);
    Point p02 = new Point(0, 2);
    Point p10 = new Point(1, 0);
    Point p11 = new Point(1, 1);
    Point p12 = new Point(1, 2);
    Point p20 = new Point(2, 0);
    Point p21 = new Point(2, 1);
    Point p22 = new Point(2, 2);

    public LinkedHashMap<Point[], Integer> winningCases = new LinkedHashMap<Point[], Integer>();
    String sign;

    public Player() {
        Point w1[] = {p00, p11, p22};
        winningCases.put(w1, 0);
        Point w2[] = {p02, p11, p20};
        winningCases.put(w2, 0);
        Point w3[] = {p00, p01, p02};
        winningCases.put(w3, 0);
        Point w4[] = {p10, p11, p12};
        winningCases.put(w4, 0);
        Point w5[] = {p20, p21, p22};
        winningCases.put(w5, 0);
        Point w6[] = {p00, p10, p20};
        winningCases.put(w6, 0);
        Point w7[] = {p01, p11, p21};
        winningCases.put(w7, 0);
        Point w8[] = {p02, p12, p22};
        winningCases.put(w8, 0);
    }
public Player(String c){
this();
sign=c;
}
    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
