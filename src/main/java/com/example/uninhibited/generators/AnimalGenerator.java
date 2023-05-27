package com.example.uninhibited.generators;

import com.example.uninhibited.core.Animal;

import java.util.*;

import static java.lang.Math.min;

public class AnimalGenerator {
    private static final Map<String, AnimalAttributes> ANIMAL_ATTRIBUTES_MAP = new HashMap<>();

    static {
        ANIMAL_ATTRIBUTES_MAP.put("Cat", new AnimalAttributes("Cat", 5, 50, 90));
        ANIMAL_ATTRIBUTES_MAP.put("Dog", new AnimalAttributes("Dog", 7, 80, 95));
        ANIMAL_ATTRIBUTES_MAP.put("Bird", new AnimalAttributes("Bird", 2, 20, 80));
        ANIMAL_ATTRIBUTES_MAP.put("Fish", new AnimalAttributes("Fish", 1, 10, 70));
        ANIMAL_ATTRIBUTES_MAP.put("Cow", new AnimalAttributes("Cow", 10, 30, 85));
        ANIMAL_ATTRIBUTES_MAP.put("Lion", new AnimalAttributes("Lion", 8, 500, 90));
        ANIMAL_ATTRIBUTES_MAP.put("Elephant", new AnimalAttributes("Elephant", 15, 1000, 85));
        ANIMAL_ATTRIBUTES_MAP.put("Giraffe", new AnimalAttributes("Giraffe", 10, 400, 95));
        ANIMAL_ATTRIBUTES_MAP.put("Penguin", new AnimalAttributes("Penguin", 3, 30, 80));
        ANIMAL_ATTRIBUTES_MAP.put("Snake", new AnimalAttributes("Snake", 6, 50, 75));
        // Add more animals and their attributes here for variety
    }

    private static class AnimalAttributes {
        private String name;
        private String type;
        private int age;
        private int monthlyCost;
        private int health;

        public AnimalAttributes(String type, int age, int monthlyCost, int health) {
            this.type = type;
            this.age = age;
            this.monthlyCost = monthlyCost;
            this.health = health;
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
    }

    public static ArrayList<Animal> getAnimals() {
        Random random = new Random();
        ArrayList<Animal> animals = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            String animalName = getRandomAnimalName();
            AnimalAttributes attributes = ANIMAL_ATTRIBUTES_MAP.get(animalName);

            int age = attributes.getAge() + random.nextInt(11);
            int health = min(100, attributes.getHealth() + random.nextInt(21) - 10);
            int monthlyCost = attributes.getMonthlyCost() + random.nextInt(51) - 25;
            animals.add(new Animal(attributes.getType(), age, monthlyCost, health));
        }
        return animals;
    }

    private static String getRandomAnimalName() {
        List<String> animalNames = new ArrayList<>(ANIMAL_ATTRIBUTES_MAP.keySet());
        Random random = new Random();
        return animalNames.get(random.nextInt(animalNames.size()));
    }
}