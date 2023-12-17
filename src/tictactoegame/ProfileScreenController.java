/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author s
 */
public class ProfileScreenController implements Initializable {

    @FXML
    private Text textYourProfile;
    @FXML
    private ImageView imgAvatar;
    @FXML
    private Label labelScore;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelUsername;
    @FXML
    private Text textUsername;
    @FXML
    private Text textEmail;
    @FXML
    private Text textScore;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File file = new File("src/logo.png");
        Image image = new Image(file.toURI().toString());
        imgAvatar = new ImageView(image);
    }    
}
