package tictactoegame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.Pair;

public class HistoryScreen extends AnchorPane {

    protected final FlowPane historyPane;
//    protected final Pane availableUsersPane;
//    protected final Label nameLabel;
//    protected final Hyperlink showLink;
//    protected final Pane pane;
//    protected final Label dateLabel;

    protected final Pane pane2;
    protected final Label label;
    protected final Pane closePane;
    protected final Label label0;
    protected final Pane minimisePane;
    protected final Label label1;

    public HistoryScreen() {
        readData();

        historyPane = new FlowPane();
        pane2 = new Pane();
        label = new Label();
        closePane = new Pane();
        label0 = new Label();
        minimisePane = new Pane();
        label1 = new Label();
        for (Map.Entry<String, Pair<String, ArrayList<Integer>>> entry : SharedData.gameReplay.allMoves.entrySet()) {
            Pane availableUsersPane;
            Label nameLabel;
            Hyperlink showLink;
            final Pane pane;
            final Label dateLabel;
            availableUsersPane = new Pane();
            nameLabel = new Label();
            showLink = new Hyperlink();
            pane = new Pane();
            dateLabel = new Label();

            setId("AnchorPane");
            setMaxHeight(600.0);
            setMaxWidth(800.0);
            setPrefHeight(800.0);
            setPrefWidth(800.0);
            getStyleClass().add("backgroundColor");
            getStylesheets().add("/css/style.css");

            historyPane.setLayoutX(1.0);
            historyPane.setLayoutY(185.0);
            historyPane.setPrefHeight(349.0);
            historyPane.setPrefWidth(800.0);

            availableUsersPane.setPrefHeight(98.0);
            availableUsersPane.setPrefWidth(330.0);
            availableUsersPane.setStyle("-fx-background-color: #EACCD6; -fx-background-radius: 30;");

            nameLabel.setLayoutX(24.0);
            nameLabel.setLayoutY(14.0);
            nameLabel.setPrefHeight(21.0);
            nameLabel.setPrefWidth(300.0);
            nameLabel.setText("You and "+entry.getValue().getKey());
            nameLabel.setTextFill(javafx.scene.paint.Color.WHITE);
            nameLabel.setFont(new Font("Gill Sans MT Bold", 18.0));

            showLink.setLayoutX(24.0);
            showLink.setLayoutY(70.0);
            showLink.setPrefHeight(24.0);
            showLink.setPrefWidth(129.0);
            showLink.setText("Show Game Replay");
            showLink.setFont(new Font("Gill Sans MT", 14.0));

            pane.setLayoutX(183.0);
            pane.setLayoutY(9.0);
            pane.setPrefHeight(32.0);
            pane.setPrefWidth(62.0);
            pane.setStyle("-fx-background-color: freen;");

            dateLabel.setLayoutX(24.0);
            dateLabel.setLayoutY(44.0);
            dateLabel.setPrefHeight(21.0);
            dateLabel.setPrefWidth(300.0);
            dateLabel.setText(entry.getKey());
            dateLabel.setTextFill(javafx.scene.paint.Color.WHITE);
            dateLabel.setFont(new Font("Gill Sans MT Bold", 18.0));
            FlowPane.setMargin(availableUsersPane, new Insets(30.0, 10.0, 0.0, 40.0));
            availableUsersPane.getChildren().add(nameLabel);
            availableUsersPane.getChildren().add(showLink);
            availableUsersPane.getChildren().add(pane);
            availableUsersPane.getChildren().add(dateLabel);
            historyPane.getChildren().add(availableUsersPane);
        }

        pane2.setLayoutX(265.0);
        pane2.setLayoutY(82.0);
        pane2.setPrefHeight(47.0);
        pane2.setPrefWidth(259.0);
        pane2.setStyle("-fx-background-color: #EACCD6; -fx-background-radius: 30;");

        label.setLayoutX(81.0);
        label.setLayoutY(13.0);
        label.setPrefHeight(21.0);
        label.setPrefWidth(146.0);
        label.setText("Your History");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Gill Sans MT Bold", 18.0));

        closePane.setLayoutX(729.0);
        closePane.setLayoutY(14.0);
        closePane.setPrefHeight(50.0);
        closePane.setPrefWidth(50.0);
        closePane.setStyle("-fx-background-color: #EACCD6; -fx-background-radius: 30;");

        label0.setLayoutX(10.0);
        label0.setLayoutY(4.0);
        label0.setPrefHeight(21.0);
        label0.setPrefWidth(18.0);
        label0.setText("X");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("Gill Sans MT Bold", 36.0));

        minimisePane.setLayoutX(660.0);
        minimisePane.setLayoutY(14.0);
        minimisePane.setPrefHeight(50.0);
        minimisePane.setPrefWidth(50.0);
        minimisePane.setStyle("-fx-background-color: #EACCD6; -fx-background-radius: 30;");

        label1.setLayoutX(13.0);
        label1.setLayoutY(-28.0);
        label1.setPrefHeight(60.0);
        label1.setPrefWidth(24.0);
        label1.setText("-");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("Gill Sans MT Bold", 72.0));

        getChildren().add(historyPane);
        pane2.getChildren().add(label);
        getChildren().add(pane2);
        closePane.getChildren().add(label0);
        getChildren().add(closePane);
        minimisePane.getChildren().add(label1);
        getChildren().add(minimisePane);

    }

    private void readData() {
        try {
            String filePath = "E:/java/TicTacToeGame/src/files/ali.txt";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            String name = new String();
            String date = new String();
            GameReplay gameReplay;
            Map<String, Pair<String, ArrayList<Integer>>> allMoves = new TreeMap<>();
            while ((line = reader.readLine()) != null) {
                ArrayList<Integer> moves = new ArrayList<>();

                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    moves.add(Integer.parseInt(st.nextToken()));
                }
                line = reader.readLine();
                date = line;

                line = reader.readLine();
                name = line;
                Pair<String, ArrayList<Integer>> pair = new Pair<>(name, moves);
                allMoves.put(date, pair);
            }
            System.out.println("Sorted Map by Key:");
            for (Map.Entry<String, Pair<String, ArrayList<Integer>>> entry : allMoves.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            SharedData.gameReplay = new GameReplay(allMoves);
            //String game=  gameReplay.toString();
            //System.out.print(game);
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
