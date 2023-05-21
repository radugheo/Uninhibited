package com.example.uninhibited.core;

public class Animal {
    private String name;
    private String type;
    private int age;
    private int monthlyCost;
    private int health;
    public Animal(String name_, String type_, int age_, int cost_, int health_){
        this.name = name_;
        this.type = type_;
        this.age = age_;
        this.monthlyCost = cost_;
        this.health = health_;
    }
}
