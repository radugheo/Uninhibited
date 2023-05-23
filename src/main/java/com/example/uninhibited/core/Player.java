package com.example.uninhibited.core;

import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    private static Player instance = null;
    private String name;
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
    private final IntegerProperty ageProperty = new SimpleIntegerProperty();
    private final StringProperty nameProperty = new SimpleStringProperty();
    private final StringProperty nationalityProperty = new SimpleStringProperty();
    private final IntegerProperty moneyProperty = new SimpleIntegerProperty();

    private Player(String name_, String gender_, String nationality_, Stats stats_) {
        this.name = name_;
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
    public void setAgeProperty(int age_) {
        this.ageProperty.set(age_);
    }
    public void setNameProperty(String name_) {
        this.nameProperty.set(name_);
    }
    public void setNationalityProperty(String nationality_){
        this.nationalityProperty.set(nationality_);
    }
    public void setMoneyProperty(int money_) {
        this.moneyProperty.set(money_);
    }
    public IntegerProperty ageProperty() {
        return ageProperty;
    }

    public StringProperty nameProperty() {
        return nameProperty;
    }

    public StringProperty nationalityProperty() {
        return nationalityProperty;
    }

    public IntegerProperty moneyProperty() {
        return moneyProperty;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name_) {
        this.name = name_;
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
    public void modifyStats(){
        Random random = new Random();
        int randomHealthModifier = random.nextInt(11) - 5;
        int randomHappinessModifier = random.nextInt(11) - 5;
        int randomIntelligenceModifier = random.nextInt(11) - 5;
        int randomLooksModifier = random.nextInt(11) - 5;

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
    }
    public void advanceAge(){
        this.age++;
        for (Car car : this.cars){
            car.setAge(car.getAge() + 1);
        }
        for (House house : this.houses){
            house.setAge(house.getAge() + 1);
        }
        modifyStats();
    }
    public static Player getInstance(String name_, String gender_, String nationality_, Stats stats_) {
        if(instance == null) {
            instance = new Player(name_, gender_, nationality_, stats_);
            Player.getInstance().setNameProperty(name_);
            Player.getInstance().setNationalityProperty(nationality_);
        }
        return instance;
    }
    public static Player getInstance() {
        return instance;
    }
}
