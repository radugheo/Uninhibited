package com.example.uninhibited.core;

public class House extends Property{
    private int size;
    private int rooms;
    private int monthlyIncome;
    public House(String name_, int price_, int age_, int health_, int monthlyCost_, int size_, int rooms_, int monthlyIncome_){
        super(name_, price_, age_, health_, monthlyCost_);
        this.size = size_;
        this.rooms = rooms_;
        this.monthlyIncome = monthlyIncome_;
    }
    @Override
    public int estimatePrice(){
        return this.price - this.age * 100 + this.health * 10 + this.size * 100 + this.rooms * 1000;
    }
    public int getSize() {
        return size;
    }
    public int getRooms() {
        return rooms;
    }
    public int getMonthlyIncome() {
        return monthlyIncome;
    }

}
