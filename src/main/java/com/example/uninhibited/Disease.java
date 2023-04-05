package com.example.uninhibited;

public class Disease {
    private String name;
    private int severity;
    private int duration;
    private int monthlyCost;
    private int cureChance;
    public Disease(String name_, int severity_, int duration_, int cost_, int cureChance_){
        this.name = name_;
        this.severity = severity_;
        this.duration = duration_;
        this.monthlyCost = cost_;
        this.cureChance = cureChance_;
    }
}
