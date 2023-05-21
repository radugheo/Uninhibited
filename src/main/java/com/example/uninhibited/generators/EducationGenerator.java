package com.example.uninhibited.generators;

import com.example.uninhibited.core.Education;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EducationGenerator {
    private static final Map<String, Integer> EDUCATION_ATTRIBUTES_MAP = new HashMap<>();

    static {
        EDUCATION_ATTRIBUTES_MAP.put("High School Diploma", 0);
        EDUCATION_ATTRIBUTES_MAP.put("Trade Certification", 1);
        EDUCATION_ATTRIBUTES_MAP.put("Culinary Degree", 2);
        EDUCATION_ATTRIBUTES_MAP.put("Bachelor's Degree", 3);
        EDUCATION_ATTRIBUTES_MAP.put("Associate Degree", 4);
        EDUCATION_ATTRIBUTES_MAP.put("Master's Degree", 5);
        EDUCATION_ATTRIBUTES_MAP.put("PhD", 6);
        EDUCATION_ATTRIBUTES_MAP.put("Law Degree", 7);
    }

    public static ArrayList<Education> getEducations() {
        Random random = new Random();
        ArrayList<Education> education = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String name = getRandomEducationName();
            int cost = random.nextInt(10000) + 5000; // Random cost between $5000 and $15000
            int duration = random.nextInt(4) + 1; // Random duration between 1 and 4 years
            int type = EDUCATION_ATTRIBUTES_MAP.get(name);

            education.add(new Education(name, cost, duration, type));
        }
        return education;
    }

    private static String getRandomEducationName() {
        Random random = new Random();
        int index = random.nextInt(EDUCATION_ATTRIBUTES_MAP.size());
        return (String) EDUCATION_ATTRIBUTES_MAP.keySet().toArray()[index];
    }
}
