package com.example.uninhibited.controllers;

import com.example.uninhibited.core.Car;
import com.example.uninhibited.core.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AllCarsController extends GenericController {
    @FXML
    private ListView<Car> listView;

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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/uninhibited/homepage.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                MainController mainController = loader.getController();

                Stage stage = (Stage) listView.getScene().getWindow();
                stage.setScene(new Scene(root, 800, 600));
                stage.show();
            }
        });
    }
    public void setCars(ArrayList<Car> cars) {
        this.listView.getItems().addAll(cars);
    }

    private void buyCar(Car car) {
        // Handle the buying operation
        System.out.println("You've just bought a " + car + "!");
    }
}