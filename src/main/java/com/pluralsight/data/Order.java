package com.pluralsight.data;

import com.pluralsight.models.Pizza;
import com.pluralsight.models.Drink;
import com.pluralsight.models.GarlicKnots;
import com.pluralsight.models.Item;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private List<Item> items;
    private LocalDateTime date;

    public Order() {
        this.orderId = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        this.items = new ArrayList<>();
        this.date = LocalDateTime.now();
    }

    public String getOrderId() {
        return orderId;
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
    public String getPrettyDate() {
        return date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm"));
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
