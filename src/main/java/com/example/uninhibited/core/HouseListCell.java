package com.example.uninhibited.core;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

import java.util.Optional;

public class HouseListCell extends ListCell<House> {
    HBox hbox = new HBox();
    Label label = new Label();
    Pane pane = new Pane();
    Button buttonDetails = new Button("Details");
    Button buttonRent = new Button("Rent");
    Button buttonSell = new Button("Sell");

    public HouseListCell() {
        super();
        hbox.getChildren().addAll(label, pane, buttonDetails, buttonRent, buttonSell);
        HBox.setHgrow(pane, Priority.ALWAYS);
        buttonDetails.setOnAction(event -> showDetails(getItem()));
        buttonRent.setOnAction(event -> rentHouse(getItem()));
        buttonSell.setOnAction(event -> sellHouse(getItem()));
    }

    @Override
    protected void updateItem(House house, boolean empty) {
        super.updateItem(house, empty);
        setText(null);  // No text in label of super class
        if (empty) {
            setGraphic(null);
        } else {
            label.setText(house != null ? house.getName() : "<null>");
            setGraphic(hbox);
        }
    }

    private void showDetails(House house) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(house.getName());
        alert.setHeaderText(house.getName());
        alert.setContentText(house.toString());

        alert.showAndWait();
    }
    private void sellHouse(House house) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(house.getName());
        alert.setHeaderText(house.getName());
        alert.setContentText("Do you want to sell this house for " + GameState.getInstance().formatMoney(house.getPrice()) + "€?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Player.getInstance().sellHouse(house);
            getListView().getItems().remove(house);
        }
    }
    private void rentHouse(House house) {
        if (house.getIsRented() == 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(house.getName());
            alert.setHeaderText(house.getName());
            alert.setContentText("This house is already rented!");

            alert.showAndWait();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(house.getName());
        alert.setHeaderText(house.getName());
        alert.setContentText("Do you want to offer this house for rent for " + GameState.getInstance().formatMoney(house.getMonthlyIncome()) + "€/month?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Player.getInstance().getHouses().get(getListView().getItems().indexOf(house)).setIsRented(1);
        }
    }
}