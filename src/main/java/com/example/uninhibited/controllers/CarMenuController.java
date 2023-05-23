package com.example.uninhibited.controllers;

import com.example.uninhibited.core.Car;
import com.example.uninhibited.core.DbFunctions;
import com.example.uninhibited.core.Player;
import com.example.uninhibited.core.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CarMenuController{
    @FXML
    private RadioButton allCarsButton;
    @FXML
    private RadioButton yourCarsButton;
    @FXML
    private ToggleGroup carToggleGroup = new ToggleGroup();
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    @FXML
    public void initialize() {
        allCarsButton.setToggleGroup(carToggleGroup);
        yourCarsButton.setToggleGroup(carToggleGroup);
    }

    public void handleRadioButtonSelection() {
        ArrayList<Car> cars;

        if (allCarsButton.isSelected()) {
            cars = DbFunctions.selectCars("Cars");
            showAllCarsList(cars);
        } else if (yourCarsButton.isSelected()) {
            cars = Player.getInstance().getCars();
            showPlayerCarsList(cars);
        } else {
            return;
        }
    }

    private void showAllCarsList(ArrayList<Car> cars) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/uninhibited/all_cars.fxml"));
            Parent homeRoot = loader.load();
            SceneUtil.getMainScene().setRoot(homeRoot);
            AllCarsController allCarsController = loader.getController();
            allCarsController.setPrimaryStage(primaryStage);
            allCarsController.setCars(cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showPlayerCarsList(ArrayList<Car> cars) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/uninhibited/player_cars.fxml"));
            Parent homeRoot = loader.load();
            SceneUtil.getMainScene().setRoot(homeRoot);
            PlayerCarsController playerCarsController = loader.getController();
            playerCarsController.setPrimaryStage(primaryStage);
            playerCarsController.setCars(cars);
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