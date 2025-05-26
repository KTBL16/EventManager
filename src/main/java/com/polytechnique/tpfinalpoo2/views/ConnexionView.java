package com.polytechnique.tpfinalpoo2.views;


import com.polytechnique.tpfinalpoo2.controllers.ConnexionController;
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

public class ConnexionView extends Application {

    ConnexionController controller = new ConnexionController();

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

        VBox formContainer = new VBox(15);
        formContainer.setId("form-container");
        formContainer.setPadding(new Insets(30, 30, 30, 30));

        Label title = new Label("EventManager");
        title.getStyleClass().add("label-title");

        Label subtitle = new Label("Connexion");
        subtitle.getStyleClass().add("label-subtitle");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        emailField.getStyleClass().add("input-field");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.getStyleClass().add("input-field");

        Button loginBtn = new Button("Se connecter");
        loginBtn.getStyleClass().add("login-button");

        VBox buttonContainer = new VBox(10, loginBtn);
        buttonContainer.setPadding(new Insets(15, 0, 0, 0));
        buttonContainer.setAlignment(Pos.CENTER);

        Label BtnConnexion = new Label("Pas encore de compte ?\nInscrivez-vous.");
        BtnConnexion.getStyleClass().add("label-register");

        formContainer.getChildren().addAll(title, subtitle, emailField, passwordField, buttonContainer, BtnConnexion);
        formContainer.setAlignment(Pos.CENTER);
        StackPane.setMargin(formContainer, new Insets(60, 40, 60, 40));

        Region background = new Region();
        background.setId("background-region");
        background.setPrefSize(600, 550);

        root.getChildren().addAll(background, formContainer);

        Scene scene = new Scene(root, 600, 550);
        scene.getStylesheets().add(getClass().getResource("/com/polytechnique/tpfinalpoo2/styles/connexion.css").toExternalForm());

        primaryStage.setTitle("Connexion - EventManager");
        primaryStage.setScene(scene);
        primaryStage.show();


        loginBtn.setOnAction(e -> {
            String email = emailField.getText();
            String password = passwordField.getText();
            controller.traiterConnexion(email, password);
        });

        BtnConnexion.setOnMouseClicked(e -> {
            try {
                new InscriptionView().start(primaryStage); // Assure-toi que InscriptionView existe
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

    }






//    public static void main(String[] args) {
//        launch(args);
//    }
}



