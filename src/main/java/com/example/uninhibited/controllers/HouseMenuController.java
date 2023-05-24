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

public class HouseMenuController{
    @FXML
    private RadioButton allHousesButton;
    @FXML
    private RadioButton yourHousesButton;
    @FXML
    private ToggleGroup houseToggleGroup = new ToggleGroup();
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    @FXML
    public void initialize() {
        allHousesButton.setToggleGroup(houseToggleGroup);
        yourHousesButton.setToggleGroup(houseToggleGroup);
    }

    public void handleRadioButtonSelection() {
        ArrayList<House> houses;
        if (allHousesButton.isSelected()) {
            houses = DbFunctions.selectHouses("houses");
            showAllHousesList(houses);
        } else if (yourHousesButton.isSelected()) {
            houses = Player.getInstance().getHouses();
            showPlayerHousesList(houses);
        } else {
            return;
        }
    }

    private void showAllHousesList(ArrayList<House> houses) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/uninhibited/all_houses.fxml"));
            Parent homeRoot = loader.load();
            SceneUtil.getMainScene().setRoot(homeRoot);
            AllHousesController allHousesController = loader.getController();
            allHousesController.setPrimaryStage(primaryStage);
            allHousesController.setHouses(houses);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showPlayerHousesList(ArrayList<House> houses) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/uninhibited/player_houses.fxml"));
            Parent homeRoot = loader.load();
            SceneUtil.getMainScene().setRoot(homeRoot);
            PlayerHousesController playerHousesController = loader.getController();
            playerHousesController.setPrimaryStage(primaryStage);
            playerHousesController.setCars(houses);
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