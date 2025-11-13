package com.pluralsight.models;

public class Drink extends Item {
    private String flavor;

    public Drink(String size, String flavor) {
        super(size, getDrinkPrice(size));
        this.flavor = flavor;
    }

    public static double getDrinkPrice(String size) {
        switch (size) {
            case "S":
                return 2.00;
            case "M":
                return 2.50;
            case "L":
                return 3.00;
            default:
                return 0;
        }
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public double calculatePrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Drink - Size: " + size + " | Flavor: " + flavor + " | $" + String.format("%.2f", calculatePrice());
    }
}