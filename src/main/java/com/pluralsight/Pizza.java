package com.pluralsight;

import java.util.ArrayList;


public class Pizza extends Item {
    private Crust crustType; // Now uses Crust object instead of String
    private ArrayList<Topping> toppingType; //includes sauces

    public Pizza(String size, double price, Crust crustType, ArrayList<Topping> toppingType) {
        super(size, price);
        this.crustType = crustType;
        this.toppingType = new ArrayList<>();
    }

    public Crust getCrust() {
        return crustType;
    }

    public void setCrust(Crust crust) {
        this.crustType = crust;
    }

    public ArrayList<Topping> getToppingType() {
        return toppingType;
    }

    // Returns base price on each size
    public static double getBasePrice(String size) {
        switch (size) {
            case "S":
                return 8.50;
            case "M":
                return 12.00;
            case "L":
                return 16.50;
            default:
                return 0;
        }
    }

    public void addTopping(Topping topping) {
        toppingType.add(topping);
    }

    //------------------All Calculations for Toppings + Crust

    public double getMeatPrice(String size, int extraMeat) {
        double basePrice = 0;
        double extraPrice = 0;

        switch (size) {
            case "S":
                basePrice = 1.00;
                extraPrice = 0.50;
                break;
            case "M":
                basePrice = 2.00;
                extraPrice = 1.00;
                break;
            case "L":
                basePrice = 3.00;
                extraPrice = 1.50;
                break;
            default:
                return 0.0;
        }
        return basePrice + (extraPrice * extraMeat);
    }

    public double getCheesePrice(String size, int extraCheese) {
        double basePrice = 0;
        double extraPrice = 0;

        switch (size) {
            case "S":
                basePrice = 0.75;
                extraPrice = 0.30;
                break;
            case "M":
                basePrice = 1.50;
                extraPrice = 0.60;
                break;
            case "L":
                basePrice = 2.25;
                extraPrice = 0.90;
                break;
            default:
                return 0.0;
        }
        return basePrice + (extraPrice * extraCheese);
    }

    @Override
    public double calculatePrice() {
        double total = price;

        for (Topping t : toppingType) {
            String category = t.getCategory(); // meat, cheese, reg toppings, sauce

            switch (category.toLowerCase()) {
                case "meat":
                    total += getMeatPrice(size, t.getExtra());
                    break;
                case "cheese":
                    total += getCheesePrice(size, t.getExtra());
                    break;
            }
        }

        // Add the crust extra cost (handles both crust type and stuffed crust pricing)
        total += crustType.getExtra();

        return total;
    }

    @Override
    public String toString() {
        return "Pizza - " +
                size + "| " +
                crustType +
                "| Toppings: " + toppingType;
    }

}


