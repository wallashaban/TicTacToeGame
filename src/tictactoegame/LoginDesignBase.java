package tictactoegame;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

public class LoginDesignBase extends BorderPane {

    protected final FlowPane contentFlowView;
    protected final Label welcomeLabel;
    protected final Label subTitleLabel;
    protected final TextField emailTextField;
    protected final TextField passwordTextField;
    protected final Button loginButton;
    protected final Label newPlayerQuestionLable;
    protected final Label signUpQuestionLabel;
    protected final FlowPane logoView;
    protected final Label letterX;
    protected final Label letterY;

    public LoginDesignBase() {

        contentFlowView = new FlowPane();
        welcomeLabel = new Label();
        subTitleLabel = new Label();
        emailTextField = new TextField();
        passwordTextField = new TextField();
        loginButton = new Button();
        newPlayerQuestionLable = new Label();
        signUpQuestionLabel = new Label();
        logoView = new FlowPane();
        letterX = new Label();
        letterY = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(800.0);
        setPrefWidth(1000.0);
        setStyle("-fx-background-color: ffffff;");

        BorderPane.setAlignment(contentFlowView, javafx.geometry.Pos.CENTER);
        contentFlowView.setOrientation(javafx.geometry.Orientation.VERTICAL);
        contentFlowView.setPrefHeight(780.0);
        contentFlowView.setPrefWidth(719.0);
        contentFlowView.setVgap(20.0);

        welcomeLabel.setText("Welcome back");
        welcomeLabel.setTextFill(javafx.scene.paint.Color.valueOf("#5a5a5a"));
        welcomeLabel.setFont(new Font("Candara Bold", 59.0));
        FlowPane.setMargin(welcomeLabel, new Insets(0.0));

        subTitleLabel.setText("Login to play online");
        subTitleLabel.setTextFill(javafx.scene.paint.Color.valueOf("#5a5a5a"));
        subTitleLabel.setFont(new Font("Arial Bold Italic", 30.0));
        subTitleLabel.setPadding(new Insets(0.0, 0.0, 0.0, 40.0));

        emailTextField.setAlignment(javafx.geometry.Pos.CENTER);
        emailTextField.setPromptText("Email");
        emailTextField.setStyle("-fx-border-color: 000000; -fx-background-radius: 30; -fx-border-width: 5; -fx-border-radius: 30; boar: ;");
        emailTextField.setFont(new Font(30.0));
        FlowPane.setMargin(emailTextField, new Insets(100.0, 0.0, 0.0, 0.0));

        passwordTextField.setAlignment(javafx.geometry.Pos.CENTER);
        passwordTextField.setPromptText("Password");
        passwordTextField.setStyle("-fx-border-color: 000000; -fx-background-radius: 30; -fx-border-width: 5; -fx-border-radius: 30; boar: ;");
        passwordTextField.setFont(new Font(30.0));
        FlowPane.setMargin(passwordTextField, new Insets(35.0, 0.0, 0.0, 0.0));

        loginButton.setAlignment(javafx.geometry.Pos.CENTER);
        loginButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        loginButton.setMnemonicParsing(false);
        loginButton.setStyle("-fx-background-color: fefdfc; -fx-border-color: 111111; -fx-background-radius: 20; -fx-border-width: 5; -fx-border-radius: 20; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        loginButton.setText("Login");
        loginButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        loginButton.setFont(new Font("Arial Bold", 30.0));
        FlowPane.setMargin(loginButton, new Insets(40.0, 0.0, 0.0, 125.0));

        newPlayerQuestionLable.setText("New Player?");
        newPlayerQuestionLable.setTextFill(javafx.scene.paint.Color.valueOf("#94cbf0"));
        newPlayerQuestionLable.setUnderline(true);
        newPlayerQuestionLable.setFont(new Font(18.0));
        FlowPane.setMargin(newPlayerQuestionLable, new Insets(0.0, 0.0, 0.0, 145.0));

        signUpQuestionLabel.setText("Sign UP!");
        signUpQuestionLabel.setTextFill(javafx.scene.paint.Color.valueOf("#94cbf0"));
        signUpQuestionLabel.setFont(new Font(18.0));
        FlowPane.setMargin(signUpQuestionLabel, new Insets(-10.0, 0.0, 0.0, 155.0));
        BorderPane.setMargin(contentFlowView, new Insets(20.0, 0.0, 0.0, 0.0));
        setCenter(contentFlowView);

        BorderPane.setAlignment(logoView, javafx.geometry.Pos.CENTER);
        logoView.setHgap(15.0);
        logoView.setPrefHeight(780.0);
        logoView.setPrefWidth(303.0);

        letterX.setRotate(10.0);
        letterX.setText("X");
        letterX.setTextFill(javafx.scene.paint.Color.valueOf("#94cbf0"));
        letterX.setFont(new Font("Arial Bold", 96.0));
        letterX.setPadding(new Insets(0.0, 0.0, 0.0, 10.0));

        letterY.setRotate(-5.0);
        letterY.setText("O");
        letterY.setTextFill(javafx.scene.paint.Color.valueOf("#eb8fb4"));
        letterY.setFont(new Font("Arial Bold", 80.0));
        BorderPane.setMargin(logoView, new Insets(20.0, 0.0, 0.0, 20.0));
        setLeft(logoView);

        contentFlowView.getChildren().add(welcomeLabel);
        contentFlowView.getChildren().add(subTitleLabel);
        contentFlowView.getChildren().add(emailTextField);
        contentFlowView.getChildren().add(passwordTextField);
        contentFlowView.getChildren().add(loginButton);
        contentFlowView.getChildren().add(newPlayerQuestionLable);
        contentFlowView.getChildren().add(signUpQuestionLabel);
        logoView.getChildren().add(letterX);
        logoView.getChildren().add(letterY);

    }
}
