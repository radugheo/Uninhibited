package com.example.uninhibited.controllers;

import com.example.uninhibited.core.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class AllAnimalsController{
    @FXML
    private ListView<Animal> listView;
    private Stage primaryStage;
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    @FXML
    public void initialize() {
        listView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Animal currentItemSelected = listView.getSelectionModel().getSelectedItem();
                if(currentItemSelected != null) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle(currentItemSelected.getName());
                    alert.setHeaderText(currentItemSelected.getName());
                    alert.setContentText("Do you want to adopt this animal?");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        TextInputDialog dialog = new TextInputDialog("Enter the name of your pet");
                        dialog.setTitle("Animal Name");
                        dialog.setHeaderText("Enter a name for your new pet");
                        Optional<String> nameResult = dialog.showAndWait();
                        if (nameResult.isPresent()) {
                            String animalName = nameResult.get();
                            currentItemSelected.setName(animalName);
                            Player.getInstance().adoptAnimal(currentItemSelected);
                            listView.getItems().remove(currentItemSelected);
                            GameState.getInstance().getEventList().add("I adopted a " + currentItemSelected.getType() + " named " + animalName + ".");
                        }
                    }
                    return;
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
    public void setAnimals(ArrayList<Animal> animals) {
        this.listView.getItems().addAll(animals);
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