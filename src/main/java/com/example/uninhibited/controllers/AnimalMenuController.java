package com.example.uninhibited.controllers;

import com.example.uninhibited.core.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AnimalMenuController {
    @FXML
    private RadioButton allAnimalsButton;
    @FXML
    private RadioButton yourAnimalsButton;
    @FXML
    private ToggleGroup animalsToggleGroup = new ToggleGroup();
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    @FXML
    public void initialize() {
        allAnimalsButton.setToggleGroup(animalsToggleGroup);
        yourAnimalsButton.setToggleGroup(animalsToggleGroup);
    }

    public void handleRadioButtonSelection() {
        ArrayList<Animal> animals;

        if (allAnimalsButton.isSelected()) {
            animals = DbFunctions.selectAnimals("animals");
            showAllAnimalsList(animals);
        } else if (yourAnimalsButton.isSelected()) {
            animals = Player.getInstance().getAnimals();
            showPlayerAnimalsList(animals);
        } else {
            return;
        }
    }

    private void showAllAnimalsList(ArrayList<Animal> animals) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/uninhibited/all_animals.fxml"));
            Parent homeRoot = loader.load();
            SceneUtil.getMainScene().setRoot(homeRoot);
            AllAnimalsController allAnimalsController = loader.getController();
            allAnimalsController.setPrimaryStage(primaryStage);
            allAnimalsController.setAnimals(animals);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showPlayerAnimalsList(ArrayList<Animal> animals) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/uninhibited/player_animals.fxml"));
            Parent homeRoot = loader.load();
            SceneUtil.getMainScene().setRoot(homeRoot);
            PlayerAnimalsController playerAnimalsController = loader.getController();
            playerAnimalsController.setPrimaryStage(primaryStage);
            playerAnimalsController.setAnimals(animals);
        } catch (IOException e) {
            e.printStackTrace();
        }
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