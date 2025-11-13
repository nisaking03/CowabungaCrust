package com.pluralsight.models;

public class LeoLeaderPie extends Pizza{

    public LeoLeaderPie(){
        super("L", 16.00, new Crust("Thick", false),
                new Sauce("Marinara"));
        this.addTopping(new Topping("Pepperoni", "meat"));
        this.addTopping(new Topping("Sausage", "meat"));

        this.addTopping(new Topping("Mozzarella", "cheese"));

        this.addTopping(new Topping("Onions", "regularToppings"));
        this.addTopping(new Topping("Bell Peppers", "regularToppings"));
        this.addTopping(new Topping("Basil", "regularToppings"));
    }
}