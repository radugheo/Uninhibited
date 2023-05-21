package com.example.uninhibited.controllers;

import com.example.uninhibited.core.Person;
import com.example.uninhibited.core.Stats;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

public class MainController {
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
    private StackPane healthBarPane;

    @FXML
    private Rectangle healthBarBackground;

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

    private Person player;

    public void initialize() {
        player = new Person("Player", "Boy", "Romanian", new Stats(98, 56, 10, 23));
        playerNameAge.setText(player.getName() + ", " + player.getAge() + " yo");
        playerNationality.setText(player.getNationality());

        initializeBar(healthBarForeground, player.healthProperty());
        initializeBar(happinessBarForeground, player.happinessProperty());
        initializeBar(smartsBarForeground, player.smartsProperty());
        initializeBar(looksBarForeground, player.looksProperty());
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
    public void onCarsButtonClick() {
        // TODO: Go to the cars screen
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
//        player.ageUp();
        // TODO: Update UI to reflect the player's new age
    }
}