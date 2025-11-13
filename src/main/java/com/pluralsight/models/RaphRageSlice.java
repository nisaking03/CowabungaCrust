package com.pluralsight.models;

public class RaphRageSlice extends Pizza{

    public RaphRageSlice(){
        super("L", 16.50, new Crust("Thick", false),
                new Sauce("Buffalo"));

        this.addTopping(new Topping("Pepperoni", "meat"));
        this.addTopping(new Topping("Sausage", "meat"));
        this.addTopping(new Topping("Bacon", "meat"));

        this.addTopping(new Topping("Buffalo", "cheese"));

        this.addTopping(new Topping("Onions", "meat"));
        this.addTopping(new Topping("Bell Peppers", "meat"));
    }
}