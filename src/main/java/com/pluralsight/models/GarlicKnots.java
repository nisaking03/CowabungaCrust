package com.pluralsight.models;

public class GarlicKnots extends Item {

    public GarlicKnots(String size) {
        super(size, getGarlicKnotPrice(size));
    }

    public static double getGarlicKnotPrice(String size) {
        switch (size) {
            case "16":
                return 1.50;
            case "32":
                return 3.00;
            default:
                return 0;
        }
    }

    @Override
    public double calculatePrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Garlic Knots - Count: " + size + " | $" + String.format("%.2f", calculatePrice());
    }
}
