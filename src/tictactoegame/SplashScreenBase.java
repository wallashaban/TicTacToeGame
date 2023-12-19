package tictactoegame;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.plaf.RootPaneUI;

public  class SplashScreenBase extends Pane {

    protected final Label label;
    protected final ImageView imageView;
    private StackPane rootPane;
    public SplashScreenBase() {
        rootPane = new StackPane();
        new Thread(){
            @Override
            public void run() {
                try {
                   Thread.sleep(3000);
                    Platform.runLater(new Runnable(){
                       @Override
                       public void run() {
                           Parent root = new MainScreen();
                        Scene scene = new Scene(root);
         
                        Stage stage = new Stage();
                        
                        stage.setTitle("Text Editor app");
                        stage.setScene(scene);
                        stage.show();
                        rootPane.getScene().getWindow().hide();
                       }
                   });
                    
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            
        }.start();
        label = new Label();
        imageView = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        label.setLayoutX(165.0);
        label.setLayoutY(271.0);
        label.setText("Unlock a world of gaming excitement!");
        label.setFont(new Font("System Bold", 15.0));

        imageView.setFitHeight(200.0);
        imageView.setFitWidth(248.0);
        imageView.setLayoutX(176.0);
        imageView.setLayoutY(44.0);
        imageView.setImage(new Image(getClass().getResource("/images/xo.png").toExternalForm()));
        
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        Parent root = new MainScreen();
                        Scene scene = new Scene(root);
         
                        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                        stage.setTitle("Text Editor app");
                        stage.setScene(scene);
                        stage.show();
                    }});

        getChildren().add(label);
        getChildren().add(imageView);

    }
}
