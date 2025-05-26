package com.polytechnique.tpfinalpoo2.views.vParticipant;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DevOrganisateurView extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        root.setPadding(new Insets(20));  // 2 cm margin = ~20px
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #E95700, #F98642, white);");

        VBox container = new VBox(15);
        container.setPadding(new Insets(25));
        container.setAlignment(Pos.TOP_CENTER);
        container.setMaxWidth(350);
        container.setStyle("""
            -fx-background-color: white;
            -fx-background-radius: 15;
            -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.25), 10, 0.0, 2, 2);
        """);

        Label title = new Label("Devenir organisateur");
        title.getStyleClass().add("label-title");

        TextField nameField = new TextField();
        nameField.setPromptText("Nom");
        nameField.getStyleClass().add("input-field");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        emailField.getStyleClass().add("input-field");

        TextArea domainArea = new TextArea();
        domainArea.setPromptText("Vos domaines d’actions");
        domainArea.setPrefRowCount(4);
        domainArea.getStyleClass().add("input-area");

        Label validationMessage = new Label("");
        validationMessage.getStyleClass().add("validation-label");

        Button retourButton = new Button("Retour");
        retourButton.getStyleClass().add("login-button");

        Button submitButton = new Button("Soumettre");
        submitButton.getStyleClass().add("login-button");
        submitButton.setOnAction(e -> {
            validationMessage.setText("Demande envoyée avec succès.");
        });

        HBox buttons = new HBox(20);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(retourButton, submitButton);
        VBox.setMargin(buttons, new Insets(40, 0, 10, 0));

        container.getChildren().addAll(title, nameField, emailField, domainArea, validationMessage, buttons);
        root.getChildren().add(container);

        Scene scene = new Scene(root, 600, 550);
        scene.getStylesheets().add(getClass().getResource("/com/polytechnique/tpfinalpoo2/styles/devenirorg.css").toExternalForm());

        primaryStage.setTitle("Devenir Organisateur");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


