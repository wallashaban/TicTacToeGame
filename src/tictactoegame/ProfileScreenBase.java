package tictactoegame;

import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

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
    protected final ImageView imgLogo;

    public ProfileScreenBase() {

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
        imgLogo = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: ffffff;");

        anchorPane.setLayoutX(141.0);
        anchorPane.setLayoutY(1.0);
        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(398.0);
        anchorPane.setPrefWidth(470.0);
        anchorPane.setStyle("-fx-background-color: ffffff;");

        textYourProfile.setLayoutY(65.0);
        textYourProfile.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textYourProfile.setStrokeWidth(0.0);
        textYourProfile.setStyle("-fx-font-family: serif;");
        textYourProfile.setText("Your Profile");
        textYourProfile.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        textYourProfile.setWrappingWidth(185.10205078125);
        textYourProfile.setFont(new Font(31.0));

        textYourProfile.setEffect(dropShadow);

        imgAvatar.setFitHeight(98.0);
        imgAvatar.setFitWidth(121.0);
        imgAvatar.setLayoutX(262.0);
        imgAvatar.setLayoutY(31.0);
        imgAvatar.setPickOnBounds(true);
        imgAvatar.setPreserveRatio(true);
//        imgAvatar.setImage(new Image(getClass().getResource("../../images/avatar.jpg").toExternalForm()));

        labelScore.setLayoutX(35.0);
        labelScore.setLayoutY(304.0);
        labelScore.setStyle("-fx-font-family: serif; -fx-font-size: 20;");
        labelScore.setText("Score");

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#faf9f6"));
        rectangle.setHeight(43.0);
        rectangle.setLayoutX(86.0);
        rectangle.setLayoutY(168.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#aea9a9"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setStyle("-fx-arc-width: 20; -fx-arc-height: 20;");
        rectangle.setWidth(225.0);

        labelEmail.setLayoutX(35.0);
        labelEmail.setLayoutY(227.0);
        labelEmail.setStyle("-fx-font-family: serif; -fx-font-size: 20;");
        labelEmail.setText("Email");

        labelUsername.setLayoutX(35.0);
        labelUsername.setLayoutY(147.0);
        labelUsername.setStyle("-fx-font-family: serif; -fx-font-size: 20;");
        labelUsername.setText("Username");

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#faf9f6"));
        rectangle0.setHeight(43.0);
        rectangle0.setLayoutX(86.0);
        rectangle0.setLayoutY(248.0);
        rectangle0.setStroke(javafx.scene.paint.Color.valueOf("#aea9a9"));
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setStyle("-fx-arc-width: 20; -fx-arc-height: 20;");
        rectangle0.setWidth(225.0);

        rectangle1.setArcHeight(5.0);
        rectangle1.setArcWidth(5.0);
        rectangle1.setFill(javafx.scene.paint.Color.valueOf("#faf9f6"));
        rectangle1.setHeight(43.0);
        rectangle1.setLayoutX(86.0);
        rectangle1.setLayoutY(325.0);
        rectangle1.setStroke(javafx.scene.paint.Color.valueOf("#aea9a9"));
        rectangle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle1.setStyle("-fx-arc-width: 20; -fx-arc-height: 20;");
        rectangle1.setWidth(225.0);

        textUsername.setLayoutX(102.0);
        textUsername.setLayoutY(196.0);
        textUsername.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textUsername.setStrokeWidth(0.0);
        textUsername.setStyle("-fx-font-family: serif; -fx-font-size: 20;");
        textUsername.setText(SharedData.currentPlayer.getUserName());
        textUsername.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        textUsername.setWrappingWidth(193.00000393390656);

        textEmail.setLayoutX(115.0);
        textEmail.setLayoutY(276.0);
        textEmail.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textEmail.setStrokeWidth(0.0);
        textEmail.setStyle("-fx-font-family: serif; -fx-font-size: 20;");
        textEmail.setText(SharedData.currentPlayer.getEmail());
        textEmail.setWrappingWidth(185.10204702615738);

        textScore.setLayoutX(111.0);
        textScore.setLayoutY(353.0);
        textScore.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textScore.setStrokeWidth(0.0);
        textScore.setStyle("-fx-font-family: serif; -fx-font-size: 20;");
        textScore.setText(SharedData.currentPlayer.getScore()+"");
        textScore.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        textScore.setWrappingWidth(174.00000393390656);

        imgLogo.setFitHeight(114.0);
        imgLogo.setFitWidth(128.0);
        imgLogo.setLayoutX(14.0);
        imgLogo.setLayoutY(14.0);
        imgLogo.setPickOnBounds(true);
        imgLogo.setPreserveRatio(true);
       imgLogo.setImage(new Image(getClass().getResource("/images/logo.png").toExternalForm()));

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
        getChildren().add(imgLogo);

    }
}
