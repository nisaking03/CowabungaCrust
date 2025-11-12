package com.pluralsight.models;

public class Sauce {
    private String sauceName;
    private double saucePrice;

    public Sauce(String name, double saucePrice) {
        this.sauceName = name;
        this.saucePrice = saucePrice;
    }

    public String getSauceName() {
        return sauceName;
    }

    public void setSauceName(String name) {
        this.sauceName = name;
    }

    public double getSaucePrice() {
        return saucePrice;
    }

    public void setSaucePrice(double saucePrice) {
        this.saucePrice = saucePrice;
    }

    @Override
    public String toString() {
        return "Sauce " + sauceName;
    }
}
