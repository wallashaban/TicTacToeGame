/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

/**
 *
 * @author s
 */
class MessageController{
        int response;
        char winner;

        public void setResponse(int res) {
            this.response = res;
        }

        public int getResponse() {
            return response;
        }

        public char getWinner() {
            return winner;
        }

        public void setWinner(char winner) {
            this.winner = winner;
        }

}