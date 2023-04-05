package com.example.uninhibited;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onStartButtonClick() {
        GameEngine game = new GameEngine();
        game.gameFlow();
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}