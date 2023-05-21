package com.example.uninhibited.generators;

import com.example.uninhibited.core.Car;

import java.util.*;

public class CarGenerator {
    private static final Map<String, CarAttributes> CAR_ATTRIBUTES_MAP = new HashMap<>();

    static {
        CAR_ATTRIBUTES_MAP.put("Mazda 3", new CarAttributes(20000, 180, 120));
        CAR_ATTRIBUTES_MAP.put("Toyota Camry", new CarAttributes(25000, 170, 110));
        CAR_ATTRIBUTES_MAP.put("Honda Civic", new CarAttributes(22000, 190, 115));
        CAR_ATTRIBUTES_MAP.put("Ford Mustang", new CarAttributes(50000, 300, 250));
        CAR_ATTRIBUTES_MAP.put("Chevrolet Corvette", new CarAttributes(70000, 350, 300));
        CAR_ATTRIBUTES_MAP.put("BMW 3 Series", new CarAttributes(40000, 190, 150));
        CAR_ATTRIBUTES_MAP.put("Mercedes-Benz C-Class", new CarAttributes(45000, 190, 140));
        CAR_ATTRIBUTES_MAP.put("Audi A4", new CarAttributes(42000, 190, 130));
        CAR_ATTRIBUTES_MAP.put("Volkswagen Golf", new CarAttributes(18000, 180, 90));
        CAR_ATTRIBUTES_MAP.put("Subaru Impreza", new CarAttributes(23000, 180, 100));
        CAR_ATTRIBUTES_MAP.put("Tesla Model S", new CarAttributes(80000, 300, 300));
        CAR_ATTRIBUTES_MAP.put("Porsche 911", new CarAttributes(90000, 320, 350));
        CAR_ATTRIBUTES_MAP.put("Lamborghini Huracan", new CarAttributes(250000, 350, 600));
        CAR_ATTRIBUTES_MAP.put("Ferrari 488 GTB", new CarAttributes(300000, 330, 660));
        CAR_ATTRIBUTES_MAP.put("Bugatti Veyron", new CarAttributes(1500000, 407, 1000));
        CAR_ATTRIBUTES_MAP.put("McLaren P1", new CarAttributes(1300000, 350, 903));
        CAR_ATTRIBUTES_MAP.put("Jaguar F-Type", new CarAttributes(60000, 300, 340));
        CAR_ATTRIBUTES_MAP.put("Lexus RX", new CarAttributes(45000, 190, 290));
        CAR_ATTRIBUTES_MAP.put("Land Rover Range Rover", new CarAttributes(90000, 220, 400));
        CAR_ATTRIBUTES_MAP.put("Volvo XC60", new CarAttributes(50000, 190, 250));
        CAR_ATTRIBUTES_MAP.put("Nissan GT-R", new CarAttributes(110000, 320, 570));
        CAR_ATTRIBUTES_MAP.put("Subaru WRX STI", new CarAttributes(35000, 195, 310));
        CAR_ATTRIBUTES_MAP.put("Chevrolet Camaro", new CarAttributes(35000, 180, 335));
        CAR_ATTRIBUTES_MAP.put("Ford Focus", new CarAttributes(18000, 180, 160));
        CAR_ATTRIBUTES_MAP.put("Hyundai Sonata", new CarAttributes(22000, 170, 180));
        CAR_ATTRIBUTES_MAP.put("Kia Sportage", new CarAttributes(25000, 180, 170));
        CAR_ATTRIBUTES_MAP.put("Renault Megane", new CarAttributes(23000, 180, 130));
        CAR_ATTRIBUTES_MAP.put("Peugeot 308", new CarAttributes(21000, 170, 120));
        CAR_ATTRIBUTES_MAP.put("Aston Martin DB11", new CarAttributes(200000, 320, 600));
        CAR_ATTRIBUTES_MAP.put("Bentley Continental GT", new CarAttributes(250000, 320, 635));
        CAR_ATTRIBUTES_MAP.put("Rolls-Royce Phantom", new CarAttributes(450000, 240, 563));
        CAR_ATTRIBUTES_MAP.put("Acura NSX", new CarAttributes(160000, 307, 573));
        // Add more cars and their attributes here for variety
    }

    private static class CarAttributes {
        private int price;
        private int speed;
        private int power;

        public CarAttributes(int price, int speed, int power) {
            this.price = price;
            this.speed = speed;
            this.power = power;
        }

        public int getPrice() {
            return price;
        }

        public int getSpeed() {
            return speed;
        }

        public int getPower() {
            return power;
        }
    }

    public static ArrayList<Car> getCars() {
        Random random = new Random();
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            String carName = getRandomCarName();
            CarAttributes attributes = CAR_ATTRIBUTES_MAP.get(carName);

            int price = attributes.getPrice();
            int age = random.nextInt(6);  // Random age between 0 and 5 (inclusive)
            int health = age == 0 ? 100 : 50 + random.nextInt(51);  // 100 if new, else random between 50 and 100
            int monthlyCost = 200 + random.nextInt(800);  // Random monthly cost between 200 and 1000
            int power = attributes.getPower();
            String color = getRandomCarColor();
            int speed = attributes.getSpeed();
            cars.add(new Car(carName, price, age, health, monthlyCost, power, color, speed));
        }
        return cars;
    }

    private static String getRandomCarName() {
        List<String> carNames = new ArrayList<>(CAR_ATTRIBUTES_MAP.keySet());
        Random random = new Random();
        return carNames.get(random.nextInt(carNames.size()));
    }

    private static String getRandomCarColor() {
        String[] carColors = {"Red", "Blue", "Black", "White", "Silver", "Gray", "Green", "Yellow", "Orange", "Purple"};
        Random random = new Random();
        return carColors[random.nextInt(carColors.length)];
    }
}