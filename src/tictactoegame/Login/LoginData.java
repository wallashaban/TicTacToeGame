/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.Login;

/**
 *
 * @author s
 */
public class LoginData {
    String email;
    String password;

    public LoginData(String Name, String password) {
        this.email = Name;
        this.password = password;
    }

    public LoginData() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
