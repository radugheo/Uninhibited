package com.example.uninhibited.controllers;

import com.example.uninhibited.core.GameState;
import com.example.uninhibited.core.Player;
import com.example.uninhibited.core.SceneUtil;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController{
    @FXML
    public Button animalsButton;
    @FXML
    private Label playerNameAge;
    @FXML
    private Label playerNationality;
    @FXML
    private Label playerMoney;
    @FXML
    private StackPane healthBarPane;
    @FXML
    private Rectangle healthBarForeground;
    @FXML
    private Rectangle happinessBarForeground;
    @FXML
    private Rectangle smartsBarForeground;
    @FXML
    private Rectangle looksBarForeground;
    @FXML
    private ListView<String> eventListView;
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void initialize() {
        eventListView.setItems(GameState.getInstance().getEventList());
        GameState.getInstance().getEventList().addListener((ListChangeListener<String>) change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    Platform.runLater(() -> eventListView.scrollTo(change.getList().size() - 1));
                }
            }
        });
        displayText();
    }
    private void initializeBar(Rectangle bar, DoubleProperty property) {
        bar.widthProperty().bind(healthBarPane.widthProperty());
        bar.fillProperty().bind(
                Bindings.createObjectBinding(() -> {
                    double progress = property.get() / 100.0;
                    if (progress == 0){
                        return new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                                new Stop(0, Color.BLACK),
                                new Stop(1, Color.BLACK));
                    }
                    else if (progress == 1){
                        return new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                                new Stop(0, Color.GREEN),
                                new Stop(1, Color.GREEN));
                    }
                    else {
                        return new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                                new Stop(0, Color.GREEN),
                                new Stop(progress, Color.GREEN),
                                new Stop(progress, Color.BLACK),
                                new Stop(1, Color.BLACK));
                    }
                }, property)
        );
    }

    @FXML
    public void onCarsButtonClick() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/uninhibited/cars_menu.fxml"));
            Parent homeRoot = loader.load();
            SceneUtil.getMainScene().setRoot(homeRoot);
            CarMenuController carMenuController = loader.getController();
            carMenuController.setPrimaryStage(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onHousesButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/uninhibited/houses_menu.fxml"));
            Parent homeRoot = loader.load();
            SceneUtil.getMainScene().setRoot(homeRoot);
            HouseMenuController houseMenuController = loader.getController();
            houseMenuController.setPrimaryStage(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onAgeUpButtonClick() {
        Player.getInstance().advanceAge();
        displayText();
    }
    @FXML
    public void onJobsButtonClick() {
        // TODO: Go to the jobs screen
    }
    @FXML
    public void onEducationButtonClick() {
        // TODO: Go to the education screen
    }
    @FXML
    public void onProfileButtonClick() {
        // TODO: Go to the profile screen
    }
    @FXML
    public void onAnimalsButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/uninhibited/animals_menu.fxml"));
            Parent homeRoot = loader.load();
            SceneUtil.getMainScene().setRoot(homeRoot);
            AnimalMenuController animalMenuController = loader.getController();
            animalMenuController.setPrimaryStage(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void displayText(){
        playerNameAge.setText(Player.getInstance().getFirstName() + " " + Player.getInstance().getLastName() + ", " + Player.getInstance().getAge() + " yo");
        playerNationality.setText(Player.getInstance().getNationality());
        playerMoney.setText("€" + GameState.getInstance().formatMoney(Player.getInstance().getMoney()));
        initializeBar(healthBarForeground, Player.getInstance().healthProperty());
        initializeBar(happinessBarForeground, Player.getInstance().happinessProperty());
        initializeBar(smartsBarForeground, Player.getInstance().smartsProperty());
        initializeBar(looksBarForeground, Player.getInstance().looksProperty());
    }
}