package com.pluralsight.models;

public class MichelangeloMelt extends Pizza{

    public MichelangeloMelt(String choice){
        super("L", 17.50, new Crust("Thick", true), new Sauce("Marinara"));

    }

}


//        "Stuffed Crust",                      // Crust (new option!)
//        "L",                                  // Size
//        "Ham, Bacon",                         // Meats
//        "Mozzarella, Parmesan",               // Cheese
//        "Marinara",                           // Sauce
//        "Pineapple, Olives, Mushrooms",       // Regular Toppings
//        "The ultimate pizza-party masterpiece! Cowabunga, dude!" // Description
