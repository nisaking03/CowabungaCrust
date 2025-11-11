package com.pluralsight.models;

public abstract class Item {
    public String size;
    public double price;

    public Item(String size, double price) {
        this.size = size;
        this.price = price;
    }

    public Item(){};

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculatePrice();

    @Override
    public String toString() {
        return String.format("%s | $%.2f", size, price);
    }

}
