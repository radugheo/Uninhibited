package com.example.uninhibited;

import com.example.uninhibited.controllers.IntroController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/uninhibited/intro.fxml"));
        Parent root = loader.load();

        IntroController controller = loader.getController();
        Scene scene = new Scene(root, 800, 600);
        controller.setMainScene(scene);

        primaryStage.setTitle("Uninhibited");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}