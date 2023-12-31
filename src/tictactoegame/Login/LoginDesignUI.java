package tictactoegame.Login;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoegame.MainScreen.MainScreenUI;
import tictactoegame.SignUp.SignUpUI;
import tictactoegame.connection.ClientConnection;
import tictactoegame.data.Player;
import tictactoegame.data.SharedData;
import tictactoegame.dialogs.AlertDialogBase;

public class LoginDesignUI extends BorderPane {

    protected final FlowPane contentFlowView;
    protected final Label welcomeLabel;
    protected final Label subTitleLabel;
    protected final Label label;
    protected final TextField emailTextField;
    protected final Label label0;
    protected final TextField passwordTextField;
    protected final Button loginButton;
    protected final Label newPlayerQuestionLable;
    protected final FlowPane logoView;
    protected final Label letterX;
    protected final Label letterY;
    protected final Pane pane;
    protected final Button buttonMinimize;
    protected final Button buttonExit;
    protected final Button buttonBack;

    public LoginDesignUI() {

        contentFlowView = new FlowPane();
        welcomeLabel = new Label();
        subTitleLabel = new Label();
        label = new Label();
        emailTextField = new TextField();
        label0 = new Label();
        passwordTextField = new PasswordField();
        loginButton = new Button();
        newPlayerQuestionLable = new Label();
        logoView = new FlowPane();
        letterX = new Label();
        letterY = new Label();
        pane = new Pane();
        buttonMinimize = new Button();
        buttonExit = new Button();
        buttonBack = new Button();


        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: linear-gradient(to bottom, #DBA7B7, #B292AA);");

        BorderPane.setAlignment(contentFlowView, javafx.geometry.Pos.CENTER);
        contentFlowView.setOrientation(javafx.geometry.Orientation.VERTICAL);
        contentFlowView.setPrefHeight(780.0);
        contentFlowView.setPrefWidth(600.0);

        welcomeLabel.setText("Welcome back");
        welcomeLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        welcomeLabel.setFont(new Font("Segoe UI Bold", 40.0));
        FlowPane.setMargin(welcomeLabel, new Insets(0.0, 0.0, 10.0, 0.0));

        subTitleLabel.setText("Login to play online");
        subTitleLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        subTitleLabel.setFont(new Font("Segoe UI Semibold", 25.0));
        subTitleLabel.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));

        label.setText("Email");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Segoe UI Bold", 18.0));
        FlowPane.setMargin(label, new Insets(60.0, 0.0, 0.0, 115.0));

        emailTextField.setAlignment(javafx.geometry.Pos.CENTER);
        emailTextField.setMinWidth(400.0);
        emailTextField.setPrefWidth(70.0);
        emailTextField.setPromptText("Email");
        emailTextField.setStyle("-fx-border-color: #56354A; -fx-background-color: EACCD6; -fx-background-radius: 20; -fx-border-width: 5; -fx-border-radius: 20;");
        emailTextField.setFont(new Font(20.0));
        FlowPane.setMargin(emailTextField, new Insets(10.0, 0.0, 0.0, -60.0));

        label0.setText("Password");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("Segoe UI Bold", 18.0));
        FlowPane.setMargin(label0, new Insets(20.0, 0.0, 0.0, 100.0));

        passwordTextField.setAlignment(javafx.geometry.Pos.CENTER);
        passwordTextField.setPromptText("password");
        passwordTextField.setStyle("-fx-border-color: #56354A; -fx-background-color: EACCD6; -fx-background-radius: 20; -fx-border-width: 5; -fx-border-radius: 20;");
        passwordTextField.setFont(new Font(20.0));
        passwordTextField.setOpaqueInsets(new Insets(0.0));
        FlowPane.setMargin(passwordTextField, new Insets(10.0, 0.0, 0.0, -60.0));

        loginButton.setAlignment(javafx.geometry.Pos.CENTER);
        loginButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        loginButton.setMnemonicParsing(false);
        loginButton.setStyle("-fx-background-color: #CF8A9B; -fx-border-color: #CF8A9B; -fx-background-radius: 10; -fx-border-width: 5; -fx-border-radius: 20; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        loginButton.setText("Login");
        loginButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        loginButton.setTextFill(javafx.scene.paint.Color.WHITE);
        loginButton.setFont(new Font("Arial Bold", 25.0));
        FlowPane.setMargin(loginButton, new Insets(60.0, 0.0, 10.0, 90.0));
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String email = emailTextField.getText();
                String password = passwordTextField.getText();
                if(email.length() < 1){
                    showAlertDialog("Please Enter Your Email");
                }
                else if (password.length() < 1){
                    showAlertDialog("Please Enter Your Password");
                }
                else if (! validateEmail(email)){
                    showAlertDialog("Please Enter Valid Email Address");
                }
                else{
                    Player player = new Player(null, password, email, true, null);
                    Gson gson = new GsonBuilder().create();
                    String jsonMessage = gson.toJson(player);
                    ArrayList<String> requestArray = new ArrayList<String>();
                    requestArray.add("login");
                    requestArray.add(jsonMessage);
                    String request = gson.toJson(requestArray);
                    ClientConnection.sendRequest(request);
                }
            }
        });

        newPlayerQuestionLable.setText("New Player?  Sign UP");
        newPlayerQuestionLable.setUnderline(true);
        newPlayerQuestionLable.setTextFill(javafx.scene.paint.Color.WHITE);
        newPlayerQuestionLable.setFont(new Font(18.0));
        FlowPane.setMargin(newPlayerQuestionLable, new Insets(10.0, 0.0, 0.0, 55.0));
        BorderPane.setMargin(contentFlowView, new Insets(20.0, 0.0, 0.0, 0.0));
        setCenter(contentFlowView);
        newPlayerQuestionLable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root = new SignUpUI();
                Scene scene = new Scene(root);
                Stage stage = SharedData.getStage();
                stage.setScene(scene);
                stage.show();
            }
        });

        BorderPane.setAlignment(logoView, javafx.geometry.Pos.CENTER);
        logoView.setHgap(15.0);
        logoView.setPrefHeight(580.0);
        logoView.setPrefWidth(256.0);

        letterX.setRotate(10.0);
        letterX.setText("X");
        letterX.setTextFill(javafx.scene.paint.Color.valueOf("#8a559b"));
        letterX.setFont(new Font("Arial Bold", 96.0));
        letterX.setPadding(new Insets(0.0, 0.0, 0.0, 10.0));

        letterY.setRotate(-5.0);
        letterY.setText("O");
        letterY.setTextFill(javafx.scene.paint.Color.valueOf("#db4f7e"));
        letterY.setFont(new Font("Arial Bold", 80.0));
        BorderPane.setMargin(logoView, new Insets(20.0, 0.0, 0.0, 20.0));
        setLeft(logoView);

        BorderPane.setAlignment(pane, javafx.geometry.Pos.CENTER);
        pane.setPrefWidth(200.0);

        buttonMinimize.setLayoutX(705.0);
        buttonMinimize.setLayoutY(7.0);
        buttonMinimize.setMnemonicParsing(false);
        buttonMinimize.setStyle("-fx-background-color: e8ccd5; -fx-background-radius: 30;");
        buttonMinimize.setText("-");
        buttonMinimize.setFont(new Font("Gill Sans MT Bold Italic", 19.0));
        buttonMinimize.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) buttonMinimize.getScene().getWindow();
            stage.setIconified(true);
        });

        buttonExit.setLayoutX(744.0);
        buttonExit.setLayoutY(7.0);
        buttonExit.setMnemonicParsing(false);
        buttonExit.setStyle("-fx-background-color: e8ccd5; -fx-background-radius: 30;");
        buttonExit.setText("X");
        buttonExit.setFont(new Font("Gill Sans MT Bold Italic", 19.0));
        setTop(pane);
        buttonExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        buttonBack.setLayoutX(15.0);
        buttonBack.setLayoutY(7.0);
        buttonBack.setMnemonicParsing(false);
        buttonBack.setStyle("-fx-background-color: e8ccd5; -fx-background-radius: 30;");
        buttonBack.setText("<");
        buttonBack.setFont(new Font("Gill Sans MT Bold Italic", 19.0));
        setTop(pane);
        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Parent root = new MainScreenUI();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });

        contentFlowView.getChildren().add(welcomeLabel);
        contentFlowView.getChildren().add(subTitleLabel);
        contentFlowView.getChildren().add(label);
        contentFlowView.getChildren().add(emailTextField);
        contentFlowView.getChildren().add(label0);
        contentFlowView.getChildren().add(passwordTextField);
        contentFlowView.getChildren().add(loginButton);
        contentFlowView.getChildren().add(newPlayerQuestionLable);
        logoView.getChildren().add(letterX);
        logoView.getChildren().add(letterY);
        pane.getChildren().add(buttonMinimize);
        pane.getChildren().add(buttonExit);
        pane.getChildren().add(buttonBack);


    }
    private void showAlertDialog(String message) {
        Parent parent = new AlertDialogBase(message);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
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
}
