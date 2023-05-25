package com.example.uninhibited.controllers;

import com.example.uninhibited.core.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class PlayerAnimalsController{
    @FXML
    private ListView<Animal> listView;
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    @FXML
    public void initialize() {
        listView.setCellFactory(animalListView -> new AnimalListCell());
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.listView.getItems().addAll(animals);
    }

    @FXML
    public void onBackButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/uninhibited/homepage.fxml"));
            Parent homeRoot = loader.load();
            SceneUtil.getMainScene().setRoot(homeRoot);
            MainController mainController = loader.getController();
            mainController.setPrimaryStage(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}