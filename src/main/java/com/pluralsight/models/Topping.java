package com.pluralsight.models;

public class Topping {
    private String name;
    private String category;
    private int extra;

    // constructor with topping
    public Topping(String name, String category, int extraCount) {
        this.name = name;
        this.category = category;
        this.extra = extraCount;
    }

    // constructor without extra topping
    public Topping(String name, String category) {
        this(name, category, 0); //No extras so it will be based price
    }

    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public int getExtra() {
        return extra;
    }

    @Override
    public String toString() {
        if (extra > 0) {
            return name + " (" + category + ", extra x" + extra + ")";
        } else {
            return name + " (" + category + ")";
        }
    }
}
