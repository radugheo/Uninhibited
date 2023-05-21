package com.example.uninhibited.core;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.ArrayList;

public class Person {
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

    public Person(String name_, String gender_, String nationality_, Stats stats_) {
        this.name = name_;
        this.gender = gender_;
        this.nationality = nationality_;
        this.stats = new Stats(stats_);
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
}
