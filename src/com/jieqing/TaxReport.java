package com.jieqing;

public class TaxReport {

    private TaxCalculator calculator;

    // Constructor Injection
    public TaxReport(TaxCalculator calculator) {
        this.calculator = calculator;
    }

    public void show() {
        double tax = calculator.calculateTax();
        System.out.println(tax);
    }
}
