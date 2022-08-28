package com.jieqing;

public class Employee {

    private int baseSalary;
    private int hourlyRate;

    public static int numberOfEmployees;

    // Constructor
    public Employee(int baseSalary) {
        this(baseSalary, 0);
    }

    public Employee(int baseSalary, int hourlyRate) {
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
        numberOfEmployees++;
    }

    private void setBaseSalary(int baseSalary) {
        if (baseSalary <= 0)
            throw new IllegalArgumentException("Salary can not be negative number!");
        this.baseSalary = baseSalary;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    private void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int calculateWage() {
        return calculateWage(0);
    }

    public int calculateWage(int extraHours) {
        return baseSalary + getHourlyRate() * extraHours;
    }
}








