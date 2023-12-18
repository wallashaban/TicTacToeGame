package tictactoegame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SignUpBase extends Pane {

    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final Label label;
    protected final TextField txtFFullName;
    protected final TextField txtFEmail;
    protected final TextField txtFPasword;
    protected final TextField txtFConfirmPassword;
    protected final Button btnSignUp;
    protected final Button btnAlreadyHaveAcc;
    protected final ImageView imageView1;
    Socket s;
    DataInputStream dataInputStream;
    PrintStream printStream;

    public SignUpBase() {
        try {
            s = new Socket("127.0.0.1", 7777);
            dataInputStream = new DataInputStream(s.getInputStream());
            printStream = new PrintStream(s.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        imageView = new ImageView();
        imageView0 = new ImageView();
        label = new Label();
        txtFFullName = new TextField();
        txtFEmail = new TextField();
        txtFPasword = new TextField();
        txtFConfirmPassword = new TextField();
        btnSignUp = new Button();
        btnAlreadyHaveAcc = new Button();
        imageView1 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(23.0);
        imageView.setFitWidth(94.0);
        imageView.setLayoutX(141.0);
        imageView.setLayoutY(26.0);
        imageView.setImage(new Image(getClass().getResource("/images/xo.png").toExternalForm()));

        imageView0.setFitHeight(124.0);
        imageView0.setFitWidth(104.0);
        imageView0.setLayoutX(14.0);
        imageView0.setLayoutY(26.0);
        imageView0.setImage(new Image(getClass().getResource("/images/xo.png").toExternalForm()));

        label.setLayoutX(141.0);
        label.setLayoutY(49.0);
        label.setText("Join our gaming community!");
        label.setFont(new Font("System Bold", 15.0));

        txtFFullName.setLayoutX(207.0);
        txtFFullName.setLayoutY(123.0);
        txtFFullName.setPromptText("Full Name");

        txtFEmail.setLayoutX(207.0);
        txtFEmail.setLayoutY(165.0);
        txtFEmail.setPromptText("Email");

        txtFPasword.setLayoutX(207.0);
        txtFPasword.setLayoutY(206.0);
        txtFPasword.setPromptText("Password");

        txtFConfirmPassword.setLayoutX(207.0);
        txtFConfirmPassword.setLayoutY(247.0);
        txtFConfirmPassword.setPromptText("Confirm Password");

        btnSignUp.setLayoutX(264.0);
        btnSignUp.setLayoutY(290.0);
        btnSignUp.setMnemonicParsing(false);
        btnSignUp.setText("Sign Up");

        btnAlreadyHaveAcc.setLayoutX(204.0);
        btnAlreadyHaveAcc.setLayoutY(338.0);
        btnAlreadyHaveAcc.setMnemonicParsing(false);
        btnAlreadyHaveAcc.setText("Already have an account? ");

        imageView1.setFitHeight(43.0);
        imageView1.setFitWidth(57.0);
        imageView1.setLayoutX(279.0);
        imageView1.setLayoutY(74.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("/images/avatar.jpg").toExternalForm()));

        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(label);
        getChildren().add(txtFFullName);
        getChildren().add(txtFEmail);
        getChildren().add(txtFPasword);
        getChildren().add(txtFConfirmPassword);
        getChildren().add(btnSignUp);
        getChildren().add(btnAlreadyHaveAcc);
        getChildren().add(imageView1);

        btnAlreadyHaveAcc.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root = new LoginDesignBase();
                Scene scene = new Scene(root);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Text Editor app");
                stage.setScene(scene);
                stage.show();
            }
        });

        btnSignUp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("name" + txtFFullName.getText());
                if (txtFFullName.getText().length() < 1) {
                    showDialog("Please enter your name...");
                } else {
                    if (txtFEmail.getText().length() < 1) {
                        showDialog("Please enter your email...");
                    } else {
                        if (txtFPasword.getText().length() < 1) {
                            showDialog("Please enter your password...");
                        } else {
                            // System.out.println("id "+Player.setId());
                            Player player = new Player(txtFFullName.getText(), txtFPasword.getText(),
                                    txtFEmail.getText(), true, null);
                            SharedData.currentPlayer = player;
                            Gson gson = new GsonBuilder().create();
                            printStream.println(gson.toJson(player));
                            // System.out.println(gson.toJson(player));
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            Parent root = new AvailableUsersScreen(stage);
                            Scene scene = new Scene(root);

                            stage.setTitle("Text Editor app");
                            stage.setScene(scene);
                            stage.show();
                        }

                    }
                }
            }
        }
        );

        // initiaizing socket , datainput and output
//        new Thread(){
//            @Override
//            public void run() {
//                while(true)
//                {
//                    
//                }
//            }
//            
//        }.start();
    }

    private void showDialog(String message) {
//        message = new MessageController();
//        message.setWinner(winner);
        Parent parent = new errorDialogBase(message);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
}
