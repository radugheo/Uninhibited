package com.example.uninhibited;

import com.example.uninhibited.controllers.IntroController;
import com.example.uninhibited.core.SceneUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/uninhlibited/intro.fxml"));
        Parent root = loader.load();
        SceneUtil.setMainScene(new Scene(root, 800, 600));
        primaryStage.setTitle("Uninhibited");
        primaryStage.setScene(SceneUtil.getMainScene());
        IntroController introController = loader.getController();
        introController.setPrimaryStage(primaryStage);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}