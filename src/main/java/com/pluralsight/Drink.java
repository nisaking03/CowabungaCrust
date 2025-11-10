package com.pluralsight;

public class Drink extends Item{
    private String flavor;

    public Drink(String size, double price, String flavor) {
        super(size, price);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public double calculatePrice() {
        return 0;
    }
}
//Display drink size options
//Display drink flavor options
//Allow selection of size and flavor
//Display drink price
//Confirm to add to order or cancel
//Option to add another drink