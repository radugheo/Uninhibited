package com.example.uninhibited.core;

public class Animal {
    private String name;
    private String type;
    private int age;
    private int monthlyCost;
    private int health;
    public Animal(String type_, int age_, int cost_, int health_){
        this.type = type_;
        this.age = age_;
        this.monthlyCost = cost_;
        this.health = health_;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getAge() {
        return age;
    }
    public int getMonthlyCost() {
        return monthlyCost;
    }
    public int getHealth() {
        return health;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return type + ", Age: " + age + ", Monthly Cost: " + monthlyCost + ", Health: " + health + "hp";
    }
}
