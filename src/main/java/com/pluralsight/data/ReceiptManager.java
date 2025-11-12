package com.pluralsight.data;


import com.pluralsight.models.Drink;
import com.pluralsight.models.GarlicKnots;
import com.pluralsight.models.Item;
import com.pluralsight.models.Pizza;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static com.pluralsight.userinterface.UserInterface.*;

public class ReceiptManager {

    // creating file name for each receipt
    public static void  saveReceipt(Order order) {

        String fileName = order.getOrderId() + ".txt"; // 20251112-145612.txt
        String filePath = "receipt" + File.separator + fileName;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(String.valueOf(currentOrder));
        }
        catch (IOException e) {
            System.out.println("Error saving receipt to file" + e.getMessage());
        }
    }


//    private static void receiptDisplay(BufferedWriter bw, Order order) throws IOException{
//            StringBuilder receipt = new StringBuilder();
//
//        bw.write("------------------------");
//        bw.write("     Order receipt");
//        bw.write(currentOrder.getPrettyDate());
//
//
//
//
//        boolean hasPizza = false;
//        for (Item item : order.getItems()) {
//            if (item instanceof Pizza) {
//                if (!hasPizza) {
//                    receipt.append("Pizza:\n");
//                    receipt.append("----------------");
//                    hasPizza = true;
//                }
//                receipt.append(String.format("  %s $%.2f\n", , Pizza.)
//            }
//        }

    private static  void receiptContent(BufferedWriter bw, Order order) throws IOException {
        bw.write("================================");
        bw.write("        Cowabunga Crust         ");
        bw.write("================================");

        // order info
        bw.write("Order ID: " + order.getOrderId());
        bw.write("Date/Time: " + order.getPrettyDate());
        bw.write("--------------------------------");

        // item selected
        bw.write("--------------------------------");
        bw.write("Item Ordered");
        bw.write("--------------------------------");

        for (Item item : order.getItems()) {
            if (item instanceof Pizza) {
                // method helper to format with perameters
            }
            if (item instanceof GarlicKnots) {
                // method helper to format with perameters
            }
            if (item instanceof Drink) {
                // method helper to format with parameter
            }
        }
    }

    private static void pizzaDetails(BufferedWriter bw, Pizza pizza) {
    
    }

}
