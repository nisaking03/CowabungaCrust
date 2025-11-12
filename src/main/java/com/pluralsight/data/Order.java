package com.pluralsight.data;

import com.pluralsight.models.Pizza;
import com.pluralsight.models.Drink;
import com.pluralsight.models.GarlicKnots;
import com.pluralsight.models.Item;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    public List<Item> items;
    private LocalDateTime date;

    public Order(List<Item> items, LocalDateTime date) {
        this.items = items;
        this.date = date;
    }

    public Order() {
        this.items = new ArrayList<>();
        this.date = LocalDateTime.now();
    }

        public List<Item> getItems() {
        return items;
    }

        public void setItems(List<Item> items) {
        this.items = items;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    //Makes the date a better format
    public String getPrettyDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        return date.format(formatter);
    }

    //Add products to order.
    public void addItem(Item item){
        items.add(item);
    }

    //Get the total of all the items.
    public double calculateTotal(){
        return items.stream().mapToDouble(items -> items.getPrice()).sum();
    }

    //Sees if it is a valid order
    public boolean isValidOrder(){

        //checks if our List of items has an instanceof a Pizza
        boolean hasPizza = items.stream().anyMatch(item -> item instanceof Pizza);
        boolean hasGarlicKnots = items.stream().anyMatch(item -> item instanceof GarlicKnots);
        boolean hasDrink = items.stream().anyMatch(item -> item instanceof Drink);

        //See if it has a pizza or not.
        if(hasPizza){
            return true;
        } else if (hasGarlicKnots || hasDrink) {
            return true;
        }else {
            return false;
            //add garlic knots or drink
        }
    }
}
