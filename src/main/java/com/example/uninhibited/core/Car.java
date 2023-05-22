package com.example.uninhibited.core;

public class Car extends Property implements Comparable<Car>{
    private int power;
    private String color;
    private int speed;
    public Car(String name_, int price_, int age_, int health_, int monthlyCost_, int power_, String color_, int speed_){
        super(name_, price_, age_, health_, monthlyCost_);
        this.power = power_;
        this.color = color_;
        this.speed = speed_;
    }
    @Override
    public int compareTo(Car otherCar) {
        return Integer.compare(this.price, otherCar.price);
    }
    @Override
    public int estimatePrice(){
        return this.price - this.age * 500 + this.health * 10 + this.power + this.speed;
    }
    public int getPower() {
        return power;
    }
    public String getColor() {
        return color;
    }
    public int getSpeed() {
        return speed;
    }

    public String formatPriceAsMoneyWithComma(){
        String priceAsString = Integer.toString(this.price);
        String priceWithComma = "";
        int counter = 0;
        for(int i = priceAsString.length() - 1; i >= 0; i--){
            if(counter == 3){
                priceWithComma = priceAsString.charAt(i) + "," + priceWithComma;
                counter = 0;
            }else{
                priceWithComma = priceAsString.charAt(i) + priceWithComma;
            }
            counter++;
        }
        return priceWithComma;
    }
    @Override
    public String toString() {
        return color + " " + name + ", " + formatPriceAsMoneyWithComma() + "€, " + age + "yo, " + health + "hp, " + monthlyCost + "€/mo, " + power + "kw, " + speed + "km/h";
    }
}
