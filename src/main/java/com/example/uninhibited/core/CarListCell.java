package com.example.uninhibited.core;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class CarListCell extends ListCell<Car> {
    HBox hbox = new HBox();
    Label label = new Label();
    Pane pane = new Pane();
    Button buttonDetails = new Button("Details");
    Button buttonSell = new Button("Sell");

    public CarListCell() {
        super();
        hbox.getChildren().addAll(label, pane, buttonDetails, buttonSell);
        HBox.setHgrow(pane, Priority.ALWAYS);
        buttonDetails.setOnAction(event -> showDetails(getItem()));
        buttonSell.setOnAction(event -> sellCar(getItem()));
    }

    @Override
    protected void updateItem(Car car, boolean empty) {
        super.updateItem(car, empty);
        setText(null);  // No text in label of super class
        if (empty) {
            setGraphic(null);
        } else {
            label.setText(car != null ? car.getName() : "<null>");
            setGraphic(hbox);
        }
    }

    private void showDetails(Car car) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(car.getName());
        alert.setHeaderText(car.getName());
        alert.setContentText(car.toString());

        alert.showAndWait();
    }
    private void sellCar(Car car) {
        Player.getInstance().sellCar(car);
        getListView().getItems().remove(car);
    }
}