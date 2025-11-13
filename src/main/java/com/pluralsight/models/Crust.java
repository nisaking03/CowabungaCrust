package com.pluralsight.models;

public class Crust {
    private String name;
    private boolean isStuffed;
    private double extra;


    public Crust(String name, boolean isStuffed, double extra) {
        this.name = name;
        this.isStuffed = isStuffed;
        this.extra = extra;
    }

    public String getName() {
        return name;
    }


    public boolean isStuffed() {
        return isStuffed;
    }

    public double getExtra() {
        return extra;
    }

    public void setExtra(double extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return name + (isStuffed ? "(Stuffed Crust)" : "" );

    }
}
