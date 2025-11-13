package com.pluralsight.models;

public class Crust {
    private String name;
    private boolean isStuffed;



    public Crust(String name, boolean isStuffed) {
        this.name = name;
        this.isStuffed = isStuffed;
    }

    public String getName() {
        return name;
    }

    public boolean isStuffed() {
        return isStuffed;
    }

    @Override
    public String toString() {
        return name + (isStuffed ? "(Stuffed Crust)" : "" );

    }
}
