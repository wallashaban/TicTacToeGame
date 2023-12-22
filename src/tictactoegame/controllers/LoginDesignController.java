/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

/**
 * FXML Controller class
 *
 * @author ghon
 */
public class LoginDesignController implements Initializable {

    @FXML
    private BorderPane borderView;
    @FXML
    private FlowPane logoView;
    @FXML
    private Label letterX;
    @FXML
    private Label letterY;
    @FXML
    private FlowPane contentFlowView;
    @FXML
    private Label welcomeLabel;
    @FXML
    private Label subTitleLabel;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button loginButton;
    @FXML
    private Label newPlayerQuestionLable;
    @FXML
    private Label signUpQuestionLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
