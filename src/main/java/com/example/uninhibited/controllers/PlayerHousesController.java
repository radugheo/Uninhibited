package com.example.uninhibited.controllers;

import com.example.uninhibited.core.CarListCell;
import com.example.uninhibited.core.House;
import com.example.uninhibited.core.HouseListCell;
import com.example.uninhibited.core.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class PlayerHousesController{
    @FXML
    private ListView<House> listView;
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    @FXML
    public void initialize() {
        listView.setCellFactory(carListView -> new HouseListCell());
    }

    public void setCars(ArrayList<House> houses) {
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