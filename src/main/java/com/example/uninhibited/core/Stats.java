package com.example.uninhibited.core;

public class Stats {
    private static Stats instance = null;
    private int health;
    private int happiness;
    private int smarts;
    private int looks;
    private Stats(int health_, int happiness_, int smarts_, int looks_){
        this.health = health_;
        this.happiness = happiness_;
        this.smarts = smarts_;
        this.looks = looks_;
    }
    private Stats(Stats stats_) {
        this.health = stats_.health;
        this.happiness = stats_.happiness;
        this.smarts = stats_.smarts;
        this.looks = stats_.looks;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getHappiness() {
        return happiness;
    }
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }
    public int getIntelligence() {
        return smarts;
    }
    public void setIntelligence(int intelligence) {
        this.smarts = intelligence;
    }
    public int getLooks() {
        return looks;
    }
    public void setLooks(int looks) {
        this.looks = looks;
    }

    public int getSmarts() {
        return smarts;
    }
    public static Stats getInstance(int health_, int happiness_, int smarts_, int looks_) {
        if (instance == null) {
            instance = new Stats(health_, happiness_, smarts_, looks_);
        }
        return instance;
    }
    public static Stats getInstance() {
        return instance;
    }
}
