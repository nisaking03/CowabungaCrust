package com.pluralsight;

public abstract class Item {
    protected String size;
    protected double price;

    public Item(String size, double price) {
        this.size = size;
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s | $%.2f", size, price);
    }

}
