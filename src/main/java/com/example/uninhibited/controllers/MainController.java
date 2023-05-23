package com.example.uninhibited.controllers;

import com.example.uninhibited.core.Player;
import com.example.uninhibited.core.SceneUtil;
import com.example.uninhibited.core.Stats;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class MainController{
    @FXML
    private Button carsButton;
    @FXML
    private Button housesButton;
    @FXML
    private Button jobsButton;
    @FXML
    private Button educationButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button ageUpButton;
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
    private StackPane happinessBarPane;

    @FXML
    private Rectangle happinessBarBackground;

    @FXML
    private Rectangle happinessBarForeground;

    @FXML
    private StackPane smartsBarPane;

    @FXML
    private Rectangle smartsBarBackground;

    @FXML
    private Rectangle smartsBarForeground;

    @FXML
    private StackPane looksBarPane;

    @FXML
    private Rectangle looksBarBackground;

    @FXML
    private Rectangle looksBarForeground;
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void initialize() {
        playerNameAge.setText(Player.getInstance().getName() + ", " + Player.getInstance().getAge() + " yo");
        playerNationality.setText(Player.getInstance().getNationality());
        playerMoney.setText("€" + Player.getInstance().getMoney());
        initializeBar(healthBarForeground, Player.getInstance().healthProperty());
        initializeBar(happinessBarForeground, Player.getInstance().happinessProperty());
        initializeBar(smartsBarForeground, Player.getInstance().smartsProperty());
        initializeBar(looksBarForeground, Player.getInstance().looksProperty());
    }
    private void initializeBar(Rectangle bar, DoubleProperty property) {
        bar.widthProperty().bind(healthBarPane.widthProperty());
        bar.fillProperty().bind(
                Bindings.createObjectBinding(() -> {
                    double progress = property.get() / 100.0;
                    return new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                            new Stop(0, Color.GREEN),
                            new Stop(progress, Color.GREEN),
                            new Stop(progress, Color.BLACK),
                            new Stop(1, Color.BLACK));
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
        // TODO: Go to the houses screen
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
    public void onAgeUpButtonClick() {
        Player.getInstance().advanceAge();
        System.out.println(Player.getInstance().getAge());
    }
}