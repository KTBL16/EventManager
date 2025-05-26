package com.polytechnique.tpfinalpoo2.views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AccueilView extends Application {

    private String nomUtilisateur = "Jean Dupont"; // Remplace par le vrai nom dynamique

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: white;");

        // Titre en haut
        Label title = new Label("Welcome " + nomUtilisateur);
        title.getStyleClass().add("label-title");

        VBox titleBox = new VBox(title);
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setPadding(new Insets(30, 0, 10, 0));
        root.setTop(titleBox);

        // Boutons des options au centre
        VBox optionsBox = new VBox(20);
        optionsBox.setAlignment(Pos.CENTER);

        Button devenirOrgBtn = new Button("Devenir organisateur");
        Button inscritsBtn = new Button("Evènement auxquels vous êtes inscrits");
        Button listeEvtBtn = new Button("Liste des Evènements");

        for (Button btn : new Button[]{devenirOrgBtn, inscritsBtn, listeEvtBtn}) {
            btn.setPrefWidth(380); // Avant 300
            btn.setPrefHeight(50); // Ajouté pour hauteur
            btn.getStyleClass().add("white-orange-shadow");
        }


        optionsBox.getChildren().addAll(devenirOrgBtn, inscritsBtn, listeEvtBtn);
        root.setCenter(optionsBox);

        // Bouton supprimer en bas à gauche
        Button deleteAccountBtn = new Button("Supprimer son compte");
        deleteAccountBtn.getStyleClass().add("delete-button");

        VBox bottomBox = new VBox(deleteAccountBtn);
        bottomBox.setAlignment(Pos.BOTTOM_LEFT);
        bottomBox.setPadding(new Insets(20));
        root.setBottom(bottomBox);

        Scene scene = new Scene(root, 600, 550);
        scene.getStylesheets().add(getClass().getResource("/com/polytechnique/tpfinalpoo2/styles/accueil.css").toExternalForm());

        primaryStage.setTitle("Page d'Accueil");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

