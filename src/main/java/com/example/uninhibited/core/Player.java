package com.example.uninhibited.core;

import javafx.beans.property.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class Player {
    private static Player instance = null;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String nationality;
    private int money;
    private Stats stats;
    private Job job;
    private Education education;
    private ArrayList<Animal> animals;
    private ArrayList<Car> cars;
    private ArrayList<House> houses;
    private DoubleProperty healthProperty;
    private DoubleProperty happinessProperty;
    private DoubleProperty smartsProperty;
    private DoubleProperty looksProperty;
    private final StringProperty educationStatus = new SimpleStringProperty();
    private Player(String firstName_, String lastName_, String gender_, String nationality_, Stats stats_) {
        this.firstName = firstName_;
        this.lastName = lastName_;
        this.gender = gender_;
        this.nationality = nationality_;
        this.stats = stats_;
        this.animals = new ArrayList<Animal>();
        this.cars = new ArrayList<Car>();
        this.houses = new ArrayList<House>();
        this.healthProperty = new SimpleDoubleProperty(stats.getHealth());
        this.happinessProperty = new SimpleDoubleProperty(stats.getHappiness());
        this.smartsProperty = new SimpleDoubleProperty(stats.getSmarts());
        this.looksProperty = new SimpleDoubleProperty(stats.getLooks());
    }
    public DoubleProperty healthProperty() {
        return healthProperty;
    }
    public DoubleProperty happinessProperty() {
        return happinessProperty;
    }
    public DoubleProperty smartsProperty() {
        return smartsProperty;
    }
    public DoubleProperty looksProperty() {
        return looksProperty;
    }
    public StringProperty educationStatusProperty() {
        return educationStatus;
    }
    public String getEducationStatus() {
        return educationStatus.get();
    }
    public void setEducationStatus(String status) {
        this.educationStatus.set(status);
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }
    public void setAge(int age_) {
        this.age = age_;
    }
    public String getGender() {
        return this.gender;
    }
    public void setGender(String gender_) {
        this.gender = gender_;
    }
    public String getNationality() {
        return this.nationality;
    }
    public int getMoney() {
        return this.money;
    }
    public void setMoney(int money_) {
        this.money = money_;
    }
    public Stats getStats() {
        return this.stats;
    }
    public void setStats(Stats stats_) {
        this.stats = stats_;
    }
    public Job getJob() {
        return this.job;
    }
    public void setJob(Job job_) {
        this.job = job_;
    }
    public Education getEducation() {
        return this.education;
    }
    public void setEducation(Education education_) {
        this.education = education_;
    }
    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }
    public void addAnimal(Animal animal_) {
        this.animals.add(animal_);
    }
    public void addCar(Car car_) {
        this.cars.add(car_);
    }
    public ArrayList<Car> getCars() {
        return this.cars;
    }
    public void addHouse(House house_) {
        this.houses.add(house_);
    }
    public ArrayList<House> getHouses() {
        return this.houses;
    }
    public void buyCar(Car car_) {
        this.cars.add(car_);
        this.money -= car_.getPrice();
    }
    public void sellCar(Car car_) {
        this.cars.remove(car_);
        this.money += car_.getPrice();
    }
    public void buyHouse(House house_) {
        this.houses.add(house_);
        this.money -= house_.getPrice();
    }
    public void sellHouse(House house_) {
        this.houses.remove(house_);
        this.money += house_.getPrice();
    }
    public void adoptAnimal(Animal animal_) {
        this.animals.add(animal_);
    }
    public void abandonAnimal(Animal animal_) {
        this.animals.remove(animal_);
    }
    public void modifyStats(){
        Random random = new Random();
        int randomHealthModifier = random.nextInt(5) - 2;
        int randomHappinessModifier = random.nextInt(5) - 2;
        int randomIntelligenceModifier = random.nextInt(5) - 2;
        int randomLooksModifier = random.nextInt(5) - 2;

        this.stats.setHealth(this.stats.getHealth() + randomHealthModifier);
        this.stats.setHappiness(this.stats.getHappiness() + randomHappinessModifier);
        this.stats.setIntelligence(this.stats.getIntelligence() + randomIntelligenceModifier);
        this.stats.setLooks(this.stats.getLooks() + randomLooksModifier);

        if (this.stats.getHealth() > 100){
            this.stats.setHealth(100);
        }
        if (this.stats.getHappiness() > 100){
            this.stats.setHappiness(100);
        }
        if (this.stats.getIntelligence() > 100){
            this.stats.setIntelligence(100);
        }
        if (this.stats.getLooks() > 100){
            this.stats.setLooks(100);
        }
        if (this.stats.getHealth() < 0){
            this.stats.setHealth(0);
        }
        if (this.stats.getHappiness() < 0){
            this.stats.setHappiness(0);
        }
        if (this.stats.getIntelligence() < 0){
            this.stats.setIntelligence(0);
        }
        if (this.stats.getLooks() < 0){
            this.stats.setLooks(0);
        }
        this.healthProperty.set(this.stats.getHealth() + randomHealthModifier);
        this.happinessProperty.set(this.stats.getHappiness() + randomHappinessModifier);
        this.smartsProperty.set(this.stats.getIntelligence() + randomIntelligenceModifier);
        this.looksProperty.set(this.stats.getLooks() + randomLooksModifier);
    }
    public void advanceAge(){
        int currentAge = getInstance().getAge();
        if (currentAge == 0){
            GameState.getInstance().getEventList().add("I was born a " + Player.getInstance().getGender() + " in " + Player.getInstance().getNationality() + ".");
        }
        setAge(getAge() + 1);
        for (Car car : this.cars){
            car.setAge(car.getAge() + 1);
            money -= (car.getMonthlyCost() * 12);
        }
        for (House house : this.houses){
            house.setAge(house.getAge() + 1);
            money -= (house.getMonthlyCost() * 12);
            if (house.getIsRented() == 1){
                money += (house.getMonthlyIncome() * 12);
            }
        }
        for (Animal animal : this.animals){
            animal.setAge(animal.getAge() + 1);
            money -= (animal.getMonthlyCost() * 12);
        }
        if (age > 18){
            money -= ((100 - this.stats.getHealth()) * 12);
        }
        modifyStats();
        GameState.getInstance().getEventList().add("I am now " + currentAge + " years old.");
        if (currentAge == 7) {
            getInstance().setEducationStatus("In School");
            GameState.getInstance().getEventList().add("I started primary school.");
        } else if (currentAge == 11){
            getInstance().setEducationStatus("In School");
            GameState.getInstance().getEventList().add("I started secondary school.");
        }
        else if (currentAge == 15) {
            getInstance().setEducationStatus("Finished School");
            GameState.getInstance().getEventList().add("I finished secondary school.");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Continue Education");
            alert.setHeaderText("Do you want to continue with further high school education?");
            alert.setContentText("Choosing to continue your education may impact your future career and financial options.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK){
                Player.getInstance().setEducationStatus("In High School");
                GameState.getInstance().getEventList().add("You started high school.");
            } else {
                Player.getInstance().setEducationStatus("Finished Education");
                GameState.getInstance().getEventList().add("You decided not to continue education.");
            }
        }
    }
    public static Player getInstance(String firstName_, String lastName_, String gender_, String nationality_, Stats stats_) {
        if(instance == null) {
            instance = new Player(firstName_, lastName_, gender_, nationality_, stats_);
        }
        return instance;
    }
    public static Player getInstance() {
        return instance;
    }
}
