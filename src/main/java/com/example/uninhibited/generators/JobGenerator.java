package com.example.uninhibited.generators;

import com.example.uninhibited.Job;

import java.lang.reflect.Array;
import java.util.*;

public class JobGenerator {
    private static final Map<String, JobAttributes> JOB_ATTRIBUTES_MAP = new HashMap<>();
    private static final List<String> COMPANY_NAMES = new ArrayList<>();

    static {
        JOB_ATTRIBUTES_MAP.put("Software Engineer", new JobAttributes(80000, "Bachelor's Degree"));
        JOB_ATTRIBUTES_MAP.put("Marketing Manager", new JobAttributes(70000, "Master's Degree"));
        JOB_ATTRIBUTES_MAP.put("Data Analyst", new JobAttributes(60000, "Bachelor's Degree"));
        JOB_ATTRIBUTES_MAP.put("Graphic Designer", new JobAttributes(50000, "Associate Degree"));
        JOB_ATTRIBUTES_MAP.put("Sales Representative", new JobAttributes(45000, "High School Diploma"));
        JOB_ATTRIBUTES_MAP.put("Product Manager", new JobAttributes(90000, "Master's Degree"));
        JOB_ATTRIBUTES_MAP.put("Financial Analyst", new JobAttributes(65000, "Bachelor's Degree"));
        JOB_ATTRIBUTES_MAP.put("Human Resources Manager", new JobAttributes(75000, "Master's Degree"));
        JOB_ATTRIBUTES_MAP.put("Web Developer", new JobAttributes(55000, "Bachelor's Degree"));
        JOB_ATTRIBUTES_MAP.put("Accountant", new JobAttributes(60000, "Bachelor's Degree"));
        JOB_ATTRIBUTES_MAP.put("Operations Manager", new JobAttributes(80000, "Master's Degree"));
        JOB_ATTRIBUTES_MAP.put("Customer Service Representative", new JobAttributes(35000, "High School Diploma"));
        JOB_ATTRIBUTES_MAP.put("Project Manager", new JobAttributes(70000, "Bachelor's Degree"));
        JOB_ATTRIBUTES_MAP.put("Research Scientist", new JobAttributes(85000, "PhD"));
        JOB_ATTRIBUTES_MAP.put("Healthcare Administrator", new JobAttributes(65000, "Master's Degree"));
        JOB_ATTRIBUTES_MAP.put("Journalist", new JobAttributes(45000, "Bachelor's Degree"));
        JOB_ATTRIBUTES_MAP.put("Architect", new JobAttributes(75000, "Bachelor's Degree"));
        JOB_ATTRIBUTES_MAP.put("Electrician", new JobAttributes(50000, "Trade Certification"));
        JOB_ATTRIBUTES_MAP.put("Marketing Coordinator", new JobAttributes(40000, "Bachelor's Degree"));
        JOB_ATTRIBUTES_MAP.put("Lawyer", new JobAttributes(120000, "Law Degree"));
        JOB_ATTRIBUTES_MAP.put("Data Scientist", new JobAttributes(90000, "Master's Degree"));
        JOB_ATTRIBUTES_MAP.put("Chef", new JobAttributes(45000, "Culinary Degree"));
        JOB_ATTRIBUTES_MAP.put("Mechanical Engineer", new JobAttributes(70000, "Bachelor's Degree"));
        JOB_ATTRIBUTES_MAP.put("Social Media Manager", new JobAttributes(55000, "Bachelor's Degree"));
        JOB_ATTRIBUTES_MAP.put("Nurse", new JobAttributes(60000, "Bachelor's Degree"));

        COMPANY_NAMES.add("Google");
        COMPANY_NAMES.add("Facebook");
        COMPANY_NAMES.add("Amazon");
        COMPANY_NAMES.add("Apple");
        COMPANY_NAMES.add("Microsoft");
        COMPANY_NAMES.add("Netflix");
        COMPANY_NAMES.add("J.P. Morgan");
        COMPANY_NAMES.add("IBM");
        COMPANY_NAMES.add("Oracle");
        COMPANY_NAMES.add("Deloitte");
        COMPANY_NAMES.add("Tesla");
        COMPANY_NAMES.add("Walmart");
        COMPANY_NAMES.add("Cisco");
        COMPANY_NAMES.add("Intel");
        COMPANY_NAMES.add("Kaiser Permanente");
        COMPANY_NAMES.add("CNN");
        COMPANY_NAMES.add("Skidmore, Owings & Merrill");
        COMPANY_NAMES.add("Siemens");
        COMPANY_NAMES.add("Procter & Gamble");
        COMPANY_NAMES.add("Baker McKenzie");
        COMPANY_NAMES.add("Marriott International");
        COMPANY_NAMES.add("General Electric");
        COMPANY_NAMES.add("Pfizer");
        COMPANY_NAMES.add("Bloomberg");
        COMPANY_NAMES.add("Ford");
        COMPANY_NAMES.add("Boeing");
    }

    private static class JobAttributes {
        private int baseSalary;
        private String educationLevel;

        public JobAttributes(int baseSalary, String educationLevel) {
            this.baseSalary = baseSalary;
            this.educationLevel = educationLevel;
        }

        public int getBaseSalary() {
            return baseSalary;
        }

        public String getEducationLevel() {
            return educationLevel;
        }
    }

    public static ArrayList<Job> getJobs() {
        Random random = new Random();
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String jobTitle = getRandomJobTitle();
            String companyName = getRandomCompanyName();

            JobAttributes attributes = JOB_ATTRIBUTES_MAP.get(jobTitle);
            int baseSalary = attributes.getBaseSalary();
            String educationLevel = attributes.getEducationLevel();

            int salary = baseSalary + (random.nextInt(baseSalary + 1) - baseSalary/2); // Vary salary by 50%

            jobs.add(new Job(jobTitle, salary, companyName, educationLevel));
        }
        return jobs;
    }

    private static String getRandomJobTitle() {
        List<String> jobTitles = new ArrayList<>(JOB_ATTRIBUTES_MAP.keySet());
        return jobTitles.get(new Random().nextInt(jobTitles.size()));
    }

    private static String getRandomCompanyName() {
        return COMPANY_NAMES.get(new Random().nextInt(COMPANY_NAMES.size()));
    }
}