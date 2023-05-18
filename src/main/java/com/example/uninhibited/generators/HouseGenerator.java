package com.example.uninhibited.generators;

import com.example.uninhibited.House;

import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.min;

public class HouseGenerator {
    private static final Map<String, HouseAttributes> HOUSE_ATTRIBUTES_MAP = new HashMap<>();

    static {
        HOUSE_ATTRIBUTES_MAP.put("Cozy Cottage", new HouseAttributes(150000, 10, 100, 1200, 2, 1000));
        HOUSE_ATTRIBUTES_MAP.put("Modern Apartment", new HouseAttributes(200000, 5, 90, 800, 1, 1500));
        HOUSE_ATTRIBUTES_MAP.put("Suburban Home", new HouseAttributes(300000, 15, 78, 2000, 4, 3000));
        HOUSE_ATTRIBUTES_MAP.put("Luxury Villa", new HouseAttributes(1000000, 2, 98, 4000, 6, 12000));
        HOUSE_ATTRIBUTES_MAP.put("Country Farmhouse", new HouseAttributes(400000, 20, 100, 12500, 3, 900));
        // Add more houses and their attributes here for variety
    }

    private static class HouseAttributes {
        private int price;
        private int age;
        private int health;
        private int size;
        private int rooms;
        private int monthlyIncome;

        public HouseAttributes(int price, int age, int health, int size, int rooms, int monthlyIncome) {
            this.price = price;
            this.age = age;
            this.health = health;
            this.size = size;
            this.rooms = rooms;
            this.monthlyIncome = monthlyIncome;
        }

        public int getPrice() {
            return price;
        }

        public int getAge() {
            return age;
        }

        public int getHealth() {
            return health;
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

    public static ArrayList<House> getHouses() {
        Random random = new Random();
        ArrayList<House> houses = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            String houseName = getRandomHouseName();
            HouseAttributes attributes = HOUSE_ATTRIBUTES_MAP.get(houseName);

            int age = random.nextInt(21);  // Random age between 0 and 20 (inclusive)
            int health = min(100, attributes.getHealth() + random.nextInt(21) - 10);
            int price = attributes.getPrice() - age * 100 + health * 10;
            int size = attributes.getSize() + random.nextInt(1001) - 500;
            int rooms = attributes.getRooms() + random.nextInt(5) - 2;
            int monthlyCost = price / 2000 + rooms * 100 + size / 1000;
            int monthlyIncome = attributes.getMonthlyIncome() + random.nextInt(1001) - 500;
            houses.add(new House(houseName, price, age, health, monthlyCost, size, rooms, monthlyIncome));
        }
        return houses;
    }

    private static String getRandomHouseName() {
        List<String> houseNames = new ArrayList<>(HOUSE_ATTRIBUTES_MAP.keySet());
        Random random = new Random();
        return houseNames.get(random.nextInt(houseNames.size()));
    }
}
