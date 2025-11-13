package com.pluralsight.models;

public class MichelangeloMelt extends Pizza{

    public MichelangeloMelt(){
        super("L", 17.50, new Crust("Thick", true),
                new Sauce("Marinara"));

        this.addTopping(new Topping("Ham", "meat"));
        this.addTopping(new Topping("Bacon", "meat"));

        this.addTopping(new Topping("Mozzarella", "cheese"));
        this.addTopping(new Topping("Parmesan", "cheese"));

        this.addTopping(new Topping("Pineapple", "regularToppings"));
        this.addTopping(new Topping("Olives", "regularToppings"));
        this.addTopping(new Topping("Mushrooms", "regularToppings"));
    }

}