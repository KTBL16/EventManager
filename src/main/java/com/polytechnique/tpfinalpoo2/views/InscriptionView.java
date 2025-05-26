package com.polytechnique.tpfinalpoo2.views;

import com.polytechnique.tpfinalpoo2.controllers.ConnexionController;
import com.polytechnique.tpfinalpoo2.controllers.InscriptionController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class InscriptionView extends Application {

    InscriptionController controller = new InscriptionController();

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

        VBox formContainer = new VBox(15);
        formContainer.setId("form-container");
        formContainer.setPadding(new Insets(30, 30, 30, 30));

        Label title = new Label("EventManager");
        title.getStyleClass().add("label-title");

        Label subtitle = new Label("Inscription");
        subtitle.getStyleClass().add("label-subtitle");

        TextField nomField = new TextField();
        nomField.setPromptText("Nom");
        nomField.getStyleClass().add("input-field");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        emailField.getStyleClass().add("input-field");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.getStyleClass().add("input-field");

        Button loginBtn = new Button("S'inscrire");
        loginBtn.getStyleClass().add("login-button");

        VBox buttonContainer = new VBox(10, loginBtn);
        buttonContainer.setPadding(new Insets(15, 0, 0, 0));
        buttonContainer.setAlignment(Pos.CENTER);

        Label BtnInscription = new Label("Déjà un compte ?\nConnectez-vous.");
        BtnInscription.getStyleClass().add("label-register");

        formContainer.getChildren().addAll(title, subtitle, nomField, emailField, passwordField, buttonContainer, BtnInscription);
        formContainer.setAlignment(Pos.CENTER);
        StackPane.setMargin(formContainer, new Insets(60, 40, 60, 40));

        Region background = new Region();
        background.setId("background-region");
        background.setPrefSize(600, 550);

        root.getChildren().addAll(background, formContainer);

        Scene scene = new Scene(root, 600, 550);
        scene.getStylesheets().add(getClass().getResource("/com/polytechnique/tpfinalpoo2/styles/connexion.css").toExternalForm());

        primaryStage.setTitle("Inscription - EventManager");
        primaryStage.setScene(scene);
        primaryStage.show();


        loginBtn.setOnAction(e -> {
            String nom = nomField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            controller.traiterInscription(nom, email, password);
        });

        BtnInscription.setOnMouseClicked(e -> {
            try {
                new ConnexionView().start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

    }






//    public static void main(String[] args) {
//        launch(args);
//    }
}
