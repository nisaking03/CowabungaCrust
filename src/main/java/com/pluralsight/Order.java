package com.pluralsight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    //List of order items
    private List<Item> items;
    private LocalDateTime date;


    //CONSTRUCTOR
    public Order(List<Item> items, LocalDateTime date) {
        this.items = items;
        this.date = date;
    }

    public Order() {
        this.items = new ArrayList<>();
        this.date = LocalDateTime.now();
    }



    //GETTERS AND SETTERS
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

    //Add products to order.
    public void addItem(Item item){
        items.add(item);
    }

    //Get the total of all the items.
    public double calculateTotal(){
        return items.stream().mapToDouble(items -> items.getPrice()).sum();
    }

    //VALID ORDER?
    public boolean isValidOrder(){

        //boolean variable that checks if our List of items has a instanceof a Pizza
        boolean hasPizza = items.stream().anyMatch(item -> item instanceof Pizza);
            boolean hasGarlicKnots = items.stream().anyMatch(item -> item instanceof GarlicKnots);
        boolean hasDrink = items.stream().anyMatch(item -> item instanceof Drink);

        //If statements that will determine if our order has a sandwich or not.
        if(hasPizza){

            return true;

        } else if (hasGarlicKnots || hasDrink) {
            return true;
        }else {
            return false;
            //add chips or drink
        }
    }

    @Override
    public String toString() {
        return "DATE & TIME: " + date + "|" +"\n" + "Items purchased: " + items + "|";


    }

}
