package com.example.uninhibited;

public abstract class Property {
    protected String name;
    protected int price;
    protected int age;
    protected int health;
    protected int monthlyCost;
    public Property(String name_, int price_, int age_, int health_, int monthlyCost_){
        this.name = name_;
        this.price = price_;
        this.age = age_;
        this.health = health_;
        this.monthlyCost = monthlyCost_;
    }
    public abstract int estimatePrice();
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age_) {
        this.age = age_;
    }
    public int getHealth() {
        return health;
    }
    public int getMonthlyCost() {
        return monthlyCost;
    }

}
