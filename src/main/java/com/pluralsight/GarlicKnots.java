package com.pluralsight;

public class GarlicKnots extends Item{
    public GarlicKnots(String size, double price) {
        super(size, price);
    }

    @Override
    public double calculatePrice() {
        return 0;
    }

}
