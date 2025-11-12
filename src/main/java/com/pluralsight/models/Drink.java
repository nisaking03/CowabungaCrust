package com.pluralsight.models;

public class Drink extends Item {
    private String flavor;

    public Drink(String size, double price, String flavor) {
        super(size, price);
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
        return "Drink - Size: " + size + " | Flavor: " + flavor + " | $" + String.format("%.2f", price);
    }
}
//Display drink size options
//Display drink flavor options
//Allow selection of size and flavor
//Display drink price
//Confirm to add to order or cancel
//Option to add another drink