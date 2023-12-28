package tictactoegame.SignUp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoegame.AvailbleUsersScreenUI;
import tictactoegame.Login.LoginDesignUI;
import tictactoegame.connection.ClientConnection;
import tictactoegame.connection.Constants;
import tictactoegame.data.Player;
import tictactoegame.data.SharedData;

import tictactoegame.dialogs.ExceptionDialog;
import tictactoegame.dialogs.AlertDialogBase;
import tictactoegame.dialogs.errorDialogBase;

public class SignUpUI extends Pane {

    protected final Label labelSignUp;
    protected final Label labelsubtitle;
    protected final TextField txtFFullName;
    protected final TextField txtFEmail;
    protected final TextField txtFPasword;
    protected final TextField txtFConfirmPassword;
    protected final Button btnSignUp;
    protected final Label alreadyHaveAccLabel;
    protected final Label letterX;
    protected final Label letterY;
    protected final Button buttonExit;
    protected final Button buttonMinimize;
//    Socket s;
//    DataInputStream dataInputStream;
//    PrintStream printStream;

    public SignUpUI() {

//        try {
//            s = new Socket("127.0.0.1", 7777);
//            dataInputStream = new DataInputStream(s.getInputStream());
//            printStream = new PrintStream(s.getOutputStream());
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
        labelSignUp = new Label();
        labelsubtitle = new Label();
        txtFFullName = new TextField();
        txtFEmail = new TextField();
        txtFPasword = new PasswordField();
        txtFConfirmPassword = new PasswordField();
        btnSignUp = new Button();
        alreadyHaveAccLabel = new Label();
        letterX = new Label();
        letterY = new Label();
        buttonExit = new Button();
        buttonMinimize = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        getStyleClass().add("backgroundColor");
        getStylesheets().add("/css/style.css");

        labelSignUp.setLayoutX(319.0);
        labelSignUp.setLayoutY(35.0);
        labelSignUp.setText("Sign Up");
        labelSignUp.setTextFill(javafx.scene.paint.Color.valueOf("#fcfcfc"));
        labelSignUp.setFont(new Font("Segoe UI Bold", 44.0));

        labelsubtitle.setLayoutX(186.0);
        labelsubtitle.setLayoutY(100.0);
        labelsubtitle.setText("Join our gaming community!");
        labelsubtitle.setTextFill(javafx.scene.paint.Color.WHITE);
        labelsubtitle.setFont(new Font("Segoe UI Bold", 34.0));

        txtFFullName.setAlignment(javafx.geometry.Pos.CENTER);
        txtFFullName.setLayoutX(207.0);
        txtFFullName.setLayoutY(169.0);
        txtFFullName.setMinWidth(400.0);
        txtFFullName.setPrefHeight(54.0);
        txtFFullName.setPrefWidth(70.0);
        txtFFullName.setPromptText("Full Name");
        txtFFullName.setStyle("-fx-background-radius: 20; -fx-background-color: EACCD6; -fx-border-radius: 20; -fx-border-color: #56354A; -fx-border-width: 5;");
        txtFFullName.setFont(new Font("Segoe UI", 24.0));

        txtFEmail.setAlignment(javafx.geometry.Pos.CENTER);
        txtFEmail.setLayoutX(207.0);
        txtFEmail.setLayoutY(246.0);
        txtFEmail.setMinWidth(400.0);
        txtFEmail.setPrefHeight(54.0);
        txtFEmail.setPrefWidth(70.0);
        txtFEmail.setPromptText("Email");
        txtFEmail.setStyle("-fx-background-radius: 20; -fx-background-color: EACCD6; -fx-border-color: #56354A; -fx-border-radius: 20; -fx-border-width: 5;");
        txtFEmail.setFont(new Font("Segoe UI", 24.0));

        txtFPasword.setAlignment(javafx.geometry.Pos.CENTER);
        txtFPasword.setLayoutX(207.0);
        txtFPasword.setLayoutY(327.0);
        txtFPasword.setMinWidth(400.0);
        txtFPasword.setPrefHeight(54.0);
        txtFPasword.setPrefWidth(70.0);
        txtFPasword.setPromptText("Password");
        txtFPasword.setStyle("-fx-background-radius: 20; -fx-background-color: EACCD6; -fx-border-color: #56354A; -fx-border-radius: 20; -fx-border-width: 5;");
        txtFPasword.setFont(new Font("Segoe UI", 24.0));

        txtFConfirmPassword.setAlignment(javafx.geometry.Pos.CENTER);
        txtFConfirmPassword.setLayoutX(207.0);
        txtFConfirmPassword.setLayoutY(404.0);
        txtFConfirmPassword.setMinWidth(400.0);
        txtFConfirmPassword.setPrefHeight(54.0);
        txtFConfirmPassword.setPrefWidth(70.0);
        txtFConfirmPassword.setPromptText("Confirm Password");
        txtFConfirmPassword.setStyle("-fx-background-radius: 20; -fx-background-color: EACCD6; -fx-border-radius: 20; -fx-border-color: #56354A; -fx-border-width: 5;");
        txtFConfirmPassword.setFont(new Font("Segoe UI", 24.0));

        btnSignUp.setLayoutX(349.0);
        btnSignUp.setLayoutY(480.0);
        btnSignUp.setMnemonicParsing(false);
        btnSignUp.setStyle("-fx-background-color: CF8A9B; -fx-border-radius: 20; -fx-background-radius: 20; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        btnSignUp.setText("Sign Up");
        btnSignUp.setTextFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));
        btnSignUp.setFont(new Font("Segoe UI", 24.0));

        alreadyHaveAccLabel.setLayoutX(271.0);
        alreadyHaveAccLabel.setLayoutY(547.0);
        alreadyHaveAccLabel.setText("Already Have Account? Login");
        alreadyHaveAccLabel.setUnderline(true);
        alreadyHaveAccLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        alreadyHaveAccLabel.setFont(new Font("Segoe UI", 20.0));
        alreadyHaveAccLabel.setOnMouseClicked((e) -> {
            Parent root = new LoginDesignUI();
            Scene scene = new Scene(root);
            Stage stage = SharedData.getStage();
            stage.setScene(scene);
            stage.show();
        });

        letterX.setLayoutX(23.0);
        letterX.setLayoutY(19.0);
        letterX.setRotate(10.0);
        letterX.setText("X");
        letterX.setTextFill(javafx.scene.paint.Color.valueOf("#8a559b"));
        letterX.setFont(new Font("Arial Bold", 96.0));
        letterX.setPadding(new Insets(0.0, 0.0, 0.0, 10.0));

        letterY.setLayoutX(110.0);
        letterY.setLayoutY(29.0);
        letterY.setText("O");
        letterY.setTextFill(javafx.scene.paint.Color.valueOf("#db4f7e"));
        letterY.setFont(new Font("Arial Bold", 80.0));

        buttonExit.setLayoutX(747.0);
        buttonExit.setLayoutY(11.0);
        buttonExit.setMnemonicParsing(false);
        buttonExit.setStyle("-fx-background-color: e8ccd5; -fx-background-radius: 30;");
        buttonExit.setText("X");
        buttonExit.setFont(new Font("Gill Sans MT Bold Italic", 19.0));
        buttonExit.setOnAction((e) -> {
            Platform.exit();
        });

        buttonMinimize.setLayoutX(707.0);
        buttonMinimize.setLayoutY(11.0);
        buttonMinimize.setMnemonicParsing(false);
        buttonMinimize.setPrefHeight(24.0);
        buttonMinimize.setPrefWidth(29.0);
        buttonMinimize.setStyle("-fx-background-color: e8ccd5; -fx-background-radius: 30;");
        buttonMinimize.setText("-");
        buttonMinimize.setFont(new Font("Gill Sans MT Bold Italic", 19.0));
        buttonMinimize.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) buttonMinimize.getScene().getWindow();
            stage.setIconified(true);
        });

        getChildren().add(labelSignUp);
        getChildren().add(labelsubtitle);
        getChildren().add(txtFFullName);
        getChildren().add(txtFEmail);
        getChildren().add(txtFPasword);
        getChildren().add(txtFConfirmPassword);
        getChildren().add(btnSignUp);
        getChildren().add(alreadyHaveAccLabel);
        getChildren().add(letterX);
        getChildren().add(letterY);
        getChildren().add(buttonExit);
        getChildren().add(buttonMinimize);

        btnSignUp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handleSignupCases();
            }
        });

    }

    private void handleSignupCases() {
        if (txtFFullName.getText().length() < 3) {
            Constants.showDialog("Please enter your name properly...");
        } else {
            if (txtFEmail.getText().length() < 3) {
                Constants.showDialog("Please enter your email properly...");
            } else {
                if (!(txtFEmail.getText().contains("@")) || !(txtFEmail.getText().contains("."))) {
                            Constants.showDialog("You should add (.) and @ in your email");
                        } else {
                if (txtFPasword.getText().length() < 3) {
                    Constants.showDialog("Please enter your password properly...");
                } else {
                    
                    if (!(txtFConfirmPassword.getText().equals( txtFPasword.getText()))) {
                        Constants.showDialog("Your password and confirm password should be the same...");
                    } else {
                            signUpUser();
                    }}
                }

            }
        }
    }

    
     private void showDialog(String message) {
        Parent parent = new errorDialogBase(message);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
     
     private void signUpUser() {
        Player player = new Player(txtFFullName.getText(), txtFPasword.getText(),
                txtFEmail.getText(), true, null);
        SharedData.currentPlayer = player;
        Gson gson = new GsonBuilder().create();
        String signupMessage = gson.toJson(player);
        ArrayList<String> response = new ArrayList<>();
        response.add("signup");
        response.add(signupMessage);
        String responseJson = gson.toJson(response);
        System.err.println(signupMessage);
        ClientConnection.sendRequest(responseJson);
    }
    private boolean validateEmail(String email){
        String regex = "@";
        String regex2 = ".";
        StringTokenizer stringTokenizer1 = new StringTokenizer(email, regex);
        StringTokenizer stringTokenizer2 = new StringTokenizer(email, regex2);
        stringTokenizer1.nextToken();
        stringTokenizer2.nextToken();
        if(stringTokenizer1.hasMoreTokens()){
            if(stringTokenizer2.hasMoreTokens())
                return true;
            else
                return false;
        }
        else
             return false;
    }
    
    private void showAlertDialog(String message) {
        Parent parent = new AlertDialogBase(message);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
     
//    private  void handleSigupResponse(String signUpResponse)
//    {
//        try {
//            printStream.println(signUpResponse);
//            System.out.println("first print");
//            String signUpStatus = dataInputStream.readLine(); // thread
//            Gson gson = new GsonBuilder().create();
//            ArrayList< String>messages = gson.fromJson(signUpStatus, ArrayList.class);
//                        System.out.println("first response");
//            String response = messages.get(0);
//            switch(response)
//            {
//                case("signup"):
//                    if(messages.get(1)=="success")
//                    {
//                        System.out.print("logined");
//                        Stage stage = new Stage();
//                            Parent root = new AvailbleUsersScreenUI();
//                            Scene scene = new Scene(root);
//
//                            stage.setTitle("Text Editor app");
//                            stage.setScene(scene);
//                            stage.show();
//                    }else{
//                        
//                    }
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
}
