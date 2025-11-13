package com.pluralsight.models;

public class DonnieTechSupreme extends Pizza{

    public DonnieTechSupreme(){
        super("M", 16.50, new Crust("Regular", false),
                new Sauce("Pesto"));

        this.addTopping(new Topping("Chicken", "meat"));
        this.addTopping(new Topping("Meatball", "meat"));

        this.addTopping(new Topping("Ricotta", "cheese"));
        this.addTopping(new Topping("Goat Cheese", "cheese"));

        this.addTopping(new Topping("Spinach", "regularToppings"));
        this.addTopping(new Topping("Basil", "regularToppings"));
        this.addTopping(new Topping("Tomatoes", "regularToppings"));
    }
}