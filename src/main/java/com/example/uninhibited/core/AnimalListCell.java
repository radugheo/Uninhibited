package com.example.uninhibited.core;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

import java.util.Optional;

public class AnimalListCell extends ListCell<Animal> {
    HBox hbox = new HBox();
    Label label = new Label();
    Pane pane = new Pane();
    Button buttonDetails = new Button("Details");
    Button buttonAbandon = new Button("Abandon");

    public AnimalListCell() {
        super();
        hbox.getChildren().addAll(label, pane, buttonDetails, buttonAbandon);
        HBox.setHgrow(pane, Priority.ALWAYS);
        buttonDetails.setOnAction(event -> showDetails(getItem()));
        buttonAbandon.setOnAction(event -> abandonAnimal(getItem()));
    }

    @Override
    protected void updateItem(Animal animal, boolean empty) {
        super.updateItem(animal, empty);
        setText(null);  // No text in label of super class
        if (empty) {
            setGraphic(null);
        } else {
            label.setText(animal != null ? animal.getName() : "<null>");
            setGraphic(hbox);
        }
    }

    private void showDetails(Animal animal) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(animal.getName());
        alert.setHeaderText(animal.getName());
        alert.setContentText(animal.toString());

        alert.showAndWait();
    }
    private void abandonAnimal(Animal animal) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(animal.getName());
        alert.setHeaderText(animal.getName());
        alert.setContentText("Do you want to abandon " + animal.getName() + ", the " + animal.getType() + "?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Player.getInstance().abandonAnimal(animal);
            getListView().getItems().remove(animal);
        }
    }
}