package com.example.uninhibited.controllers;

import com.example.uninhibited.core.DbFunctions;
import com.example.uninhibited.core.Player;
import com.example.uninhibited.core.Stats;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Random;

public class IntroController extends GenericController {
    @FXML
    private TextField nameInput;
    @FXML
    private TextField genderInput;
    @FXML
    private ComboBox<String> birthCountryInput;
    public void initialize() {
        ObservableList<String> countries = FXCollections.observableArrayList("Romaina", "Hungary", "Bulgaria", "Moldova", "Serbia", "Ukraine", "Russia", "Belarus", "Poland", "Czechia", "Slovakia", "Slovenia", "Croatia", "Bosnia and Herzegovina", "Montenegro", "Albania", "North Macedonia", "Kosovo", "Greece", "Turkey", "Austria", "Germany", "Switzerland", "France", "Belgium", "Netherlands", "Luxembourg", "United Kingdom", "Ireland", "Denmark", "Norway", "Sweden", "Finland", "Estonia", "Latvia", "Lithuania", "Spain", "Portugal", "Italy", "Malta", "Cyprus");
        birthCountryInput.setItems(countries);
    }
    @FXML
    public void onStartButtonClick(ActionEvent event) throws IOException {
        String name = nameInput.getText();
        String gender = genderInput.getText();
        String birthCountry = birthCountryInput.getValue();
        Random random = new Random();
        int randomHealth = random.nextInt(101);
        int randomHappiness = random.nextInt(101);
        int randomIntelligence = random.nextInt(101);
        int randomLooks = random.nextInt(101);
        Stats stats = Stats.getInstance(randomHealth, randomHappiness, randomIntelligence, randomLooks);
        Player.getInstance(name, gender, birthCountry, Stats.getInstance());
        Player.getInstance().setMoney(100000);

        DbFunctions.populateDatabase();
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/uninhibited/homepage.fxml"));
        mainScene.setRoot(homeRoot);
        MainController mainController = new MainController();
        mainController.setMainScene(mainScene);
    }
}