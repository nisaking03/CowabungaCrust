package com.pluralsight;

import javax.xml.namespace.QName;

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
