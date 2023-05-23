package com.example.uninhibited.core;

public class Job {
    private String name;
    private int salary;
    private String company;
    private String educationLevel;
    public Job(String name_, int salary_, String company_, String educationLevel_){
        this.name = name_;
        this.salary = salary_;
        this.company = company_;
        this.educationLevel = educationLevel_;
    }
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }
    public String getCompany() {
        return company;
    }
    public String getEducationLevel() {
        return educationLevel;
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", company='" + company + '\'' +
                ", educationLevel='" + educationLevel + '\'' +
                '}';
    }
}
