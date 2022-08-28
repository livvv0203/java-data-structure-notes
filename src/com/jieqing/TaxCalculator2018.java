package com.jieqing;

public class TaxCalculator2018 implements TaxCalculator {

    private double taxableIncome;

    public TaxCalculator2018(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    @Override
    /**
     * This is the implementation that we declared in the interface
     */
    public double calculateTax() {
        return taxableIncome * 0.4;
    }
}









