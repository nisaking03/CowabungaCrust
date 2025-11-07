package com.pluralsight;

import java.util.ArrayList;

public class Pizza extends Item{
    //will all be arraylists
    private String crustType; // thin, regular, thick, cauliflower
    private ArrayList<Topping> toppingType; //includes sauces

    public Pizza(String size, double price, String crustType, ArrayList<Topping> toppingType) {
        super(size, price);
        this.crustType = crustType;
        this.toppingType = toppingType;
        this.toppingType = new ArrayList<>();
    }

    public String getCrustType() {
        return crustType;
    }

    public ArrayList<Topping> getToppingType() {
        return toppingType;
    }
}
