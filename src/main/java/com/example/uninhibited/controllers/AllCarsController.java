package com.example.uninhibited.controllers;

import com.example.uninhibited.core.Car;
import com.example.uninhibited.core.Player;
import com.example.uninhibited.core.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AllCarsController{
    @FXML
    private ListView<Car> listView;
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    @FXML
    public void initialize() {
        listView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Car currentItemSelected = listView.getSelectionModel().getSelectedItem();
                if(currentItemSelected != null) {
                    if (Player.getInstance().getMoney() < currentItemSelected.getPrice()) {
                        System.out.println("You don't have enough money to buy this car!");
                        return;
                    } else{
                        System.out.println("You've just bought a " + currentItemSelected.getName() + "!");
                        Player.getInstance().buyCar(currentItemSelected);
                        listView.getItems().remove(currentItemSelected);
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

    public void setCars(ArrayList<Car> cars) {
        this.listView.getItems().addAll(cars);
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