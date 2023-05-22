package com.example.uninhibited.controllers;

import com.example.uninhibited.core.Car;
import com.example.uninhibited.core.DbFunctions;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CarMenuController extends GenericController{
    @FXML
    private RadioButton allCarsButton;
    @FXML
    private RadioButton yourCarsButton;

    @FXML
    public void initialize() {
        // Add any necessary initialization code here.
    }

    public void handleRadioButtonSelection() {
        ArrayList<Car> cars;

        if (allCarsButton.isSelected()) {
            cars = DbFunctions.selectCars("Cars");
        } else if (yourCarsButton.isSelected()) {
            cars = DbFunctions.selectCars("YourCars");
        } else {
            return; // No selection made, do nothing
        }

        showCarsList(cars);
    }

    private void showCarsList(ArrayList<Car> cars) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/uninhibited/all_cars.fxml"));
            Parent root = loader.load();

            AllCarsController allCarsController = loader.getController();
            allCarsController.setCars(cars);

            Stage stage = (Stage) allCarsButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}