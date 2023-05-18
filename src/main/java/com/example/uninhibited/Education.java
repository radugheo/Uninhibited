package com.example.uninhibited;

public class Education {
    private String name;
    private int cost;
    private int duration;
    private int type;
    public Education(String name_, int cost_, int duration_, int type_){
        this.name = name_;
        this.cost = cost_;
        this.duration = duration_;
        this.type = type_;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getDuration() {
        return duration;
    }

    public int getType() {
        return type;
    }
}
