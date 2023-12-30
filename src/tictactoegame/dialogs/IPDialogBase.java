package tictactoegame.dialogs;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoegame.connection.Constants;
import tictactoegame.data.MessageController;

public class IPDialogBase extends Pane {

    protected final Rectangle rectangle;
    protected final Label labelTitle;
    protected final Rectangle rectangle0;
    protected final RadioButton radioManual;
    protected final TextField textIP;
    protected final Rectangle rectangle1;
    protected final RadioButton radioDefault;
    protected final Rectangle rectangle2;
    protected final RadioButton radioLocal;
    protected final Button btnConnect;
    protected final Button btnCancel;
    protected final Label labelAlert;

    public IPDialogBase(MessageController message) {

        rectangle = new Rectangle();
        labelTitle = new Label();
        rectangle0 = new Rectangle();
        radioManual = new RadioButton();
        textIP = new TextField();
        rectangle1 = new Rectangle();
        radioDefault = new RadioButton();
        rectangle2 = new Rectangle();
        radioLocal = new RadioButton();
        btnConnect = new Button();
        btnCancel = new Button();
        labelAlert = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(351.0);
        setPrefWidth(600.0);
        getStyleClass().add("backgroundColor");
        getStylesheets().add("/tictactoegame/dialogs/BackGround.css");

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#e8ccd5"));
        rectangle.setHeight(56.0);
        rectangle.setLayoutX(70.0);
        rectangle.setLayoutY(17.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setStyle("-fx-arc-width: 40; -fx-arc-height: 40;");
        rectangle.setWidth(460.0);

        labelTitle.setLayoutX(104.0);
        labelTitle.setLayoutY(22.0);
        labelTitle.setLineSpacing(1.5);
        labelTitle.setPrefHeight(47.0);
        labelTitle.setPrefWidth(393.0);
        labelTitle.setText("Configure IP Address of server");
        labelTitle.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        labelTitle.setWrapText(true);
        labelTitle.setFont(new Font("Segoe UI Bold", 27.0));

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#e8ccd5"));
        rectangle0.setHeight(40.0);
        rectangle0.setLayoutX(86.0);
        rectangle0.setLayoutY(80.0);
        rectangle0.setStroke(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setStyle("-fx-arc-width: 40; -fx-arc-height: 40;");
        rectangle0.setWidth(306.0);

        radioManual.setLayoutX(91.0);
        radioManual.setLayoutY(84.0);
        radioManual.setMnemonicParsing(false);
        radioManual.setText("Manually Add IP:");
        radioManual.setFont(new Font("Segoe UI", 24.0));

        textIP.setLayoutX(92.0);
        textIP.setLayoutY(129.0);
        textIP.setPrefHeight(40.0);
        textIP.setPrefWidth(415.0);
        textIP.setStyle("-fx-background-radius: 20;");

        rectangle1.setArcHeight(5.0);
        rectangle1.setArcWidth(5.0);
        rectangle1.setFill(javafx.scene.paint.Color.valueOf("#e8ccd5"));
        rectangle1.setHeight(40.0);
        rectangle1.setLayoutX(85.0);
        rectangle1.setLayoutY(184.0);
        rectangle1.setStroke(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        rectangle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle1.setStyle("-fx-arc-width: 40; -fx-arc-height: 40;");
        rectangle1.setWidth(431.0);

        radioDefault.setLayoutX(90.0);
        radioDefault.setLayoutY(188.0);
        radioDefault.setMnemonicParsing(false);
        radioDefault.setPrefHeight(32.0);
        radioDefault.setPrefWidth(425.0);
        radioDefault.setText("Connect to Server at '"+ Constants.IP_ADDRESS +"'");
        radioDefault.setFont(new Font("Segoe UI", 24.0));

        rectangle2.setArcHeight(5.0);
        rectangle2.setArcWidth(5.0);
        rectangle2.setFill(javafx.scene.paint.Color.valueOf("#e8ccd5"));
        rectangle2.setHeight(40.0);
        rectangle2.setLayoutX(85.0);
        rectangle2.setLayoutY(235.0);
        rectangle2.setStroke(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        rectangle2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle2.setStyle("-fx-arc-width: 40; -fx-arc-height: 40;");
        rectangle2.setWidth(431.0);

        radioLocal.setLayoutX(90.0);
        radioLocal.setLayoutY(239.0);
        radioLocal.setMnemonicParsing(false);
        radioLocal.setText("Connect to Localhost '127.0.0.1'");
        radioLocal.setFont(new Font("Segoe UI", 24.0));
        
        labelAlert.setLayoutX(400.0);
        labelAlert.setLayoutY(74.0);
        labelAlert.setLineSpacing(1.5);
        labelAlert.setPrefHeight(47.0);
        labelAlert.setPrefWidth(393.0);
        labelAlert.setText("IP Address is not valid");
        labelAlert.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        labelAlert.setWrapText(true);
        labelAlert.setTextFill(javafx.scene.paint.Color.valueOf("#ff0000"));
        labelAlert.setFont(new Font("Gill Sans MT Bold Italic", 20.0));

        btnConnect.setLayoutX(138.0);
        btnConnect.setLayoutY(298.0);
        btnConnect.setMnemonicParsing(false);
        btnConnect.setPrefHeight(39.0);
        btnConnect.setPrefWidth(113.0);
        btnConnect.setStyle("-fx-background-color: CF8A9B; -fx-background-radius: 40; -fx-font-style: Bold;");
        btnConnect.setText("Connect");
        btnConnect.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnConnect.setTextFill(javafx.scene.paint.Color.WHITE);
        btnConnect.setFont(new Font("Gill Sans MT Bold Italic", 20.0));

        btnCancel.setLayoutX(326.0);
        btnCancel.setLayoutY(298.0);
        btnCancel.setMnemonicParsing(false);
        btnCancel.setPrefHeight(39.0);
        btnCancel.setPrefWidth(113.0);
        btnCancel.setStyle("-fx-background-color: CF8A9B; -fx-background-radius: 40; -fx-font-style: Bold;");
        btnCancel.setText("Cancel");
        btnCancel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnCancel.setTextFill(javafx.scene.paint.Color.WHITE);
        btnCancel.setFont(new Font("Gill Sans MT Bold Italic", 20.0));
        btnCancel.setOnAction((event)->{
            message.setResponse(-1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            
        });
        getChildren().add(rectangle);
        getChildren().add(labelTitle);
        getChildren().add(rectangle0);
        getChildren().add(radioManual);
        getChildren().add(textIP);
        getChildren().add(rectangle1);
        getChildren().add(radioDefault);
        getChildren().add(rectangle2);
        getChildren().add(radioLocal);
        getChildren().add(labelAlert);
        getChildren().add(btnConnect);
        getChildren().add(btnCancel);
        labelAlert.setVisible(false);
        ToggleGroup toggleGroup = new ToggleGroup();
        radioManual.setToggleGroup(toggleGroup);
        radioDefault.setToggleGroup(toggleGroup);
        radioLocal.setToggleGroup(toggleGroup);
        toggleGroup.selectedToggleProperty().addListener((observable, oldVal, newVal)->{
            if(newVal.equals(radioManual)){
                textIP.setEditable(true);
            }
            else{
                textIP.setEditable(false);
            }
        });
        
        btnConnect.setOnAction((event)->{
            Toggle selected = toggleGroup.getSelectedToggle();
            if(selected.equals(radioManual)){
                String ip = textIP.getText();
                if(validateIP(ip)){
                    message.setIpAddress(ip);
                    message.setResponse(0);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.close();
                }
                else{
                    labelAlert.setVisible(true);
                }
            }
            else if(selected.equals(radioDefault)){
                message.setResponse(1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
            else if(selected.equals(radioLocal)){
                message.setResponse(2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
            
        });
    }
    private boolean validateIP(String ip){
        String[] array = ip.split("\\.");
        if(array.length !=4){
            System.out.println("More than 4" + array.length);
            return false;
        }
        else{
            for(int i =0; i<4; i++){
                try{
                    Integer x = Integer.parseInt(array[i]);
                    if(x>255){
                        System.out.println("Greater than 255");
                        return false;
                    } 
                }catch(Exception e){
                    System.out.println("not integer");
                    return false;
                }  
            }
            System.out.println("All is good");
            return true;
        }
    }
}
