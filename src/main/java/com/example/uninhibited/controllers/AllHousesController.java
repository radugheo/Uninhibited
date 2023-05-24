package com.example.uninhibited.controllers;

import com.example.uninhibited.core.GameState;
import com.example.uninhibited.core.House;
import com.example.uninhibited.core.Player;
import com.example.uninhibited.core.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class AllHousesController{
    @FXML
    private ListView<House> listView;
    private Stage primaryStage;
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    @FXML
    public void initialize() {
        listView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                House currentItemSelected = listView.getSelectionModel().getSelectedItem();
                if(currentItemSelected != null) {
                    if (Player.getInstance().getMoney() < currentItemSelected.getPrice()) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle(currentItemSelected.getName());
                        alert.setHeaderText(currentItemSelected.getName());
                        alert.setContentText("You don't have enough money to buy this house!");
                        alert.showAndWait();
                        GameState.getInstance().getEventList().add("I wanted to buy a " + currentItemSelected.getName() + " but I didn't have enough money.");
                        return;
                    } else{
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle(currentItemSelected.getName());
                        alert.setHeaderText(currentItemSelected.getName());
                        alert.setContentText("Do you want to buy this house for " + GameState.getInstance().formatMoney(currentItemSelected.getPrice()) + "€?");

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.isPresent() && result.get() == ButtonType.OK) {
                            Player.getInstance().buyHouse(currentItemSelected);
                            listView.getItems().remove(currentItemSelected);
                            GameState.getInstance().getEventList().add("I bought a " + currentItemSelected.getName() + " for " + GameState.getInstance().formatMoney(currentItemSelected.getPrice()) + "€.");
                        }
                        return;
                    }
                }
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
        });
    }

    public void setHouses(ArrayList<House> houses) {
        this.listView.getItems().addAll(houses);
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