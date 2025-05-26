package com.polytechnique.tpfinalpoo2.views.vParticipant;


// ConcertDetailsView.java
import com.polytechnique.tpfinalpoo2.views.ConnexionView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class InfoConcertsView extends Application {

    private boolean isInscrit = false; // à adapter selon l'utilisateur et le concert
    private String concertName = "NomConcert1";

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(40));
        root.setStyle("-fx-background-color: white;");

        Label title = new Label("Info : " + concertName);
        title.getStyleClass().add("label-title");
        BorderPane.setAlignment(title, Pos.TOP_CENTER);
        root.setTop(title);

        VBox infoSection = new VBox(10);
        infoSection.setAlignment(Pos.CENTER_LEFT);
        infoSection.setPadding(new Insets(20));

        Label dateLabel = new Label("Date : 15 Juin 2025");
        Label lieuLabel = new Label("Lieu : Salle de Concert A");
        Label artistesLabel = new Label("Artistes : Artiste 1, Artiste 2");

        infoSection.getChildren().addAll(dateLabel, lieuLabel, artistesLabel);
        root.setCenter(infoSection);

        // Bas : boutons
        HBox buttons = new HBox(20);
        buttons.setPadding(new Insets(20));
        buttons.setAlignment(Pos.BOTTOM_CENTER);

        Button retourButton = new Button("Retour");
        retourButton.getStyleClass().add("login-button");
        retourButton.setOnAction(e -> {
            try {
                new ConcertsView().start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Button actionButton = new Button(isInscrit ? "Se désinscrire" : "S'inscrire");
        actionButton.getStyleClass().add(isInscrit ? "inscrit-button" : "login-button");
        actionButton.setOnAction(e -> {
            isInscrit = !isInscrit;
            actionButton.setText(isInscrit ? "Se désinscrire" : "S'inscrire");
            actionButton.getStyleClass().clear();
            actionButton.getStyleClass().add(isInscrit ? "inscrit-button" : "login-button");
        });

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        buttons.getChildren().addAll(retourButton, spacer, actionButton);
        root.setBottom(buttons);

        Scene scene = new Scene(root, 600, 550);
        scene.getStylesheets().add(getClass().getResource("/com/polytechnique/tpfinalpoo2/styles/pconcert.css").toExternalForm());

        primaryStage.setTitle("Détails du Concert");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
