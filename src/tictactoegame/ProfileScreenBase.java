package tictactoegame;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProfileScreenBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final Text textYourProfile;
    protected final DropShadow dropShadow;
    protected final ImageView imgAvatar;
    protected final Label labelScore;
    protected final Rectangle rectangle;
    protected final Label labelEmail;
    protected final Label labelUsername;
    protected final Rectangle rectangle0;
    protected final Rectangle rectangle1;
    protected final Text textUsername;
    protected final Text textEmail;
    protected final Text textScore;
    protected final Button buttonExit;
    protected final Button buttonMinimize;

    public ProfileScreenBase(Person person) {

        anchorPane = new AnchorPane();
        textYourProfile = new Text();
        dropShadow = new DropShadow();
        imgAvatar = new ImageView();
        labelScore = new Label();
        rectangle = new Rectangle();
        labelEmail = new Label();
        labelUsername = new Label();
        rectangle0 = new Rectangle();
        rectangle1 = new Rectangle();
        textUsername = new Text();
        textEmail = new Text();
        textScore = new Text();
        buttonExit = new Button();
        buttonMinimize = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        getStyleClass().add("backgroundColor");
        getStylesheets().add("/tictactoegame/BackGround.css");

        anchorPane.setLayoutX(50.0);
        anchorPane.setLayoutY(45.0);
        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(525.0);
        anchorPane.setPrefWidth(591.0);
        anchorPane.getStyleClass().add("backgroundColor");
        anchorPane.getStylesheets().add("/tictactoegame/BackGround.css");

        textYourProfile.setFill(javafx.scene.paint.Color.WHITE);
        textYourProfile.setLayoutX(23.0);
        textYourProfile.setLayoutY(85.0);
        textYourProfile.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textYourProfile.setStrokeWidth(0.0);
        textYourProfile.setText("Your Profile");
        textYourProfile.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        textYourProfile.setWrappingWidth(256.10205078125);
        textYourProfile.setFont(new Font("Segoe UI", 48.0));

        textYourProfile.setEffect(dropShadow);

        imgAvatar.setFitHeight(146.0);
        imgAvatar.setFitWidth(114.0);
        imgAvatar.setLayoutX(444.0);
        imgAvatar.setLayoutY(8.0);
        imgAvatar.setPickOnBounds(true);
        imgAvatar.setPreserveRatio(true);
        imgAvatar.setImage(new Image(getClass().getResource("/images/monster.png").toExternalForm()));

        labelScore.setLayoutX(109.0);
        labelScore.setLayoutY(369.0);
        labelScore.setText("Score");
        labelScore.setTextFill(javafx.scene.paint.Color.WHITE);
        labelScore.setFont(new Font("Segoe UI", 34.0));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#e8ccd5"));
        rectangle.setHeight(43.0);
        rectangle.setLayoutX(191.0);
        rectangle.setLayoutY(200.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#aea9a9"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setStyle("-fx-arc-width: 20; -fx-arc-height: 20;");
        rectangle.setWidth(450.0);

        labelEmail.setLayoutX(108.0);
        labelEmail.setLayoutY(263.0);
        labelEmail.setText("Email");
        labelEmail.setTextFill(javafx.scene.paint.Color.WHITE);
        labelEmail.setFont(new Font("Segoe UI", 34.0));

        labelUsername.setLayoutX(91.0);
        labelUsername.setLayoutY(160.0);
        labelUsername.setText("Username");
        labelUsername.setTextFill(javafx.scene.paint.Color.WHITE);
        labelUsername.setFont(new Font("Segoe UI", 34.0));

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#e8ccd5"));
        rectangle0.setHeight(43.0);
        rectangle0.setLayoutX(190.0);
        rectangle0.setLayoutY(303.0);
        rectangle0.setStroke(javafx.scene.paint.Color.valueOf("#aea9a9"));
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setStyle("-fx-arc-width: 20; -fx-arc-height: 20;");
        rectangle0.setWidth(450.0);

        rectangle1.setArcHeight(5.0);
        rectangle1.setArcWidth(5.0);
        rectangle1.setFill(javafx.scene.paint.Color.valueOf("#e8ccd5"));
        rectangle1.setHeight(43.0);
        rectangle1.setLayoutX(188.0);
        rectangle1.setLayoutY(401.0);
        rectangle1.setStroke(javafx.scene.paint.Color.valueOf("#aea9a9"));
        rectangle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle1.setStyle("-fx-arc-width: 20; -fx-arc-height: 20;");
        rectangle1.setWidth(450.0);

        textUsername.setLayoutX(280.0);
        textUsername.setLayoutY(232.0);
        textUsername.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textUsername.setStrokeWidth(0.0);
        textUsername.setText("Fordo");
        textUsername.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        textUsername.setWrappingWidth(265.00000393390656);
        textUsername.setFont(new Font("Segoe UI", 34.0));

        textEmail.setLayoutX(280.0);
        textEmail.setLayoutY(335.0);
        textEmail.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textEmail.setStrokeWidth(0.0);
        textEmail.setText("frodo@gmail.com");
        textEmail.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        textEmail.setWrappingWidth(284.9999874830246);
        textEmail.setFont(new Font("Segoe UI", 34.0));

        textScore.setLayoutX(280.0);
        textScore.setLayoutY(433.0);
        textScore.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textScore.setStrokeWidth(0.0);
        textScore.setText("25000");
        textScore.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        textScore.setWrappingWidth(264.9999976158142);
        textScore.setFont(new Font("Segoe UI", 34.0));

        buttonExit.setLayoutX(750.0);
        buttonExit.setLayoutY(14.0);
        buttonExit.setMnemonicParsing(false);
        buttonExit.setStyle("-fx-background-radius: 30; -fx-background-color: e8ccd5;");
        buttonExit.setText("X");
        buttonExit.setFont(new Font("Gill Sans MT Bold Italic", 19.0));
        buttonExit.setOnAction((e)-> {Platform.exit();});

        buttonMinimize.setLayoutX(709.0);
        buttonMinimize.setLayoutY(14.0);
        buttonMinimize.setMnemonicParsing(false);
        buttonMinimize.setPrefHeight(17.0);
        buttonMinimize.setPrefWidth(31.0);
        buttonMinimize.setStyle("-fx-background-radius: 30; -fx-background-color: e8ccd5;");
        buttonMinimize.setText("-");
        buttonMinimize.setFont(new Font("Gill Sans MT", 19.0));
        buttonMinimize.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) buttonMinimize.getScene().getWindow();
            stage.setIconified(true);
        });

        anchorPane.getChildren().add(textYourProfile);
        anchorPane.getChildren().add(imgAvatar);
        anchorPane.getChildren().add(labelScore);
        anchorPane.getChildren().add(rectangle);
        anchorPane.getChildren().add(labelEmail);
        anchorPane.getChildren().add(labelUsername);
        anchorPane.getChildren().add(rectangle0);
        anchorPane.getChildren().add(rectangle1);
        anchorPane.getChildren().add(textUsername);
        anchorPane.getChildren().add(textEmail);
        anchorPane.getChildren().add(textScore);
        getChildren().add(anchorPane);
        //getChildren().add(imgLogo);
        

        
        // Work
        String myScore = String.valueOf(person.score);
        
        textUsername.setText(person.userName);
        textEmail.setText(person.email);
        textScore.setText(myScore);
    }
}
