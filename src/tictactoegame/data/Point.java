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
public class Point {

    int x, y;

    Point() {
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }

    public boolean equals(Point p) {
        if (p.x == x && p.y == y) {
            return true;
        }
        return false;
    }

}
