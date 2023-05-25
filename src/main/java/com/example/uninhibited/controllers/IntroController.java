package com.example.uninhibited.controllers;

import com.example.uninhibited.core.DbFunctions;
import com.example.uninhibited.core.Player;
import com.example.uninhibited.core.SceneUtil;
import com.example.uninhibited.core.Stats;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class IntroController{
    @FXML
    private TextField firstNameInput;
    @FXML
    private TextField lastNameInput;
    @FXML
    private ComboBox<String> genderInput;
    @FXML
    private ComboBox<String> birthCountryInput;
    private Stage primaryStage;
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    private String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        } else {
            return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }
    }
    public void initialize() {
        ObservableList<String> countries = FXCollections.observableArrayList("Romania", "Hungary", "Bulgaria", "Moldova", "Serbia", "Ukraine", "Russia", "Belarus", "Poland", "Czechia", "Slovakia", "Slovenia", "Croatia", "Bosnia and Herzegovina", "Montenegro", "Albania", "North Macedonia", "Kosovo", "Greece", "Turkey", "Austria", "Germany", "Switzerland", "France", "Belgium", "Netherlands", "Luxembourg", "United Kingdom", "Ireland", "Denmark", "Norway", "Sweden", "Finland", "Estonia", "Latvia", "Lithuania", "Spain", "Portugal", "Italy", "Malta", "Cyprus");
        birthCountryInput.setItems(countries);
        ObservableList<String> genders = FXCollections.observableArrayList("Male", "Female");
        genderInput.setItems(genders);
    }
    @FXML
    public void onStartButtonClick(ActionEvent event) throws IOException {
        String firstName = capitalizeFirstLetter(firstNameInput.getText());
        String lastName = capitalizeFirstLetter(lastNameInput.getText());
        String gender = genderInput.getValue();
        String birthCountry = birthCountryInput.getValue();
        if (firstName.isEmpty() || lastName.isEmpty() || gender.isEmpty() || birthCountry == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all the fields.");
            alert.showAndWait();
            return;
        }
        Random random = new Random();
        int randomHealth = random.nextInt(101);
        int randomHappiness = random.nextInt(101);
        int randomIntelligence = random.nextInt(101);
        int randomLooks = random.nextInt(101);
        Stats stats = Stats.getInstance(randomHealth, randomHappiness, randomIntelligence, randomLooks);
        Player.getInstance(firstName, lastName, gender, birthCountry, Stats.getInstance());
        Player.getInstance().setMoney(10000000);
        Player.getInstance().setAge(0);

        DbFunctions.populateDatabase();
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