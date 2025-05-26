package com.polytechnique.tpfinalpoo2.views.vParticipant;



// ConcertsView.java
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class ConcertsView extends Application {

    private List<String> inscrits = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(15);
        root.setPadding(new Insets(40));
        root.setAlignment(Pos.TOP_CENTER);
        root.setStyle("-fx-background-color: white;");

        Label title = new Label("Concerts");
        title.getStyleClass().add("label-title");

        VBox concertList = new VBox(10);
        concertList.setAlignment(Pos.CENTER);

        String[] concerts = {"NomConcert1", "NomConcert2", "NomConcert3", "", "", ""};

        for (String concert : concerts) {
            HBox concertRow = new HBox(20);
            concertRow.setAlignment(Pos.CENTER_LEFT);
            concertRow.setPadding(new Insets(5));
            concertRow.setPrefWidth(500);
            concertRow.setStyle("-fx-background-color: #EEEEEE;");

            Label concertName = new Label(concert);
            concertName.setPrefWidth(350);
            if (!concert.isBlank()) {
                concertName.setOnMouseClicked((MouseEvent e) -> {
                    // Naviguer vers la page de détails du concert
                });
            }

            Button actionButton = new Button();
            if (concert.isBlank()) {
                concertName.setText("");
                actionButton.setVisible(false);
            } else if (inscrits.contains(concert)) {
                actionButton.setText("Inscrits");
                actionButton.getStyleClass().add("inscrit-button");
            } else {
                actionButton.setText("S'inscrire");
                actionButton.getStyleClass().add("login-button");
            }

            actionButton.setOnAction(e -> {
                if (inscrits.contains(concert)) {
                    inscrits.remove(concert);
                    actionButton.setText("S'inscrire");
                    actionButton.getStyleClass().remove("inscrit-button");
                    actionButton.getStyleClass().add("login-button");
                } else {
                    inscrits.add(concert);
                    actionButton.setText("Inscrits");
                    actionButton.getStyleClass().remove("login-button");
                    actionButton.getStyleClass().add("inscrit-button");
                }
            });

            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);

            concertRow.getChildren().addAll(concertName, spacer, actionButton);
            concertList.getChildren().add(concertRow);
        }

        Button retourButton = new Button("Retour");
        retourButton.getStyleClass().add("login-button");
        retourButton.setOnAction(e -> {
            // Naviguer vers la page d'accueil
        });

        VBox bottomContainer = new VBox(retourButton);
        bottomContainer.setAlignment(Pos.BOTTOM_LEFT);
        bottomContainer.setPadding(new Insets(50, 0, 0, 20));

        root.getChildren().addAll(title, concertList, bottomContainer);

        Scene scene = new Scene(root, 600, 550);
        scene.getStylesheets().add(getClass().getResource("/com/polytechnique/tpfinalpoo2/styles/pconcert.css").toExternalForm());

        primaryStage.setTitle("Liste des Concerts");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


