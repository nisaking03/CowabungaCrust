package com.pluralsight.data;


import com.pluralsight.models.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptManager {

    private static final String RECEIPT_FOLDER = "receipt";

    public void ensureReceiptFolderExists() {
        File file = new File(RECEIPT_FOLDER);
        if (file.exists()) {
            System.out.println("Folder exists... writing file!");
        } else {
            file.mkdir();
        }
    }

    private static void writeReceiptContent(BufferedWriter bw, Order order) throws IOException {
        bw.write("================================\n");
        bw.write("      Cowabunga Crust\n");
        bw.write("================================\n\n");

        // Order info
        bw.write("Order ID: " + order.getOrderId() + "\n");
        bw.write("Date/Time: " + order.getPrettyDate() + "\n");
        bw.write("--------------------------------\n\n");

        // Items ordered
        bw.write("ITEMS ORDERED:\n");
        bw.write("--------------------------------\n");

        for (Item item : order.getItems()) {
            if (item instanceof Pizza) {
                writePizzaDetails(bw, (Pizza) item);
            } else if (item instanceof GarlicKnots) {
                writeGarlicKnotsDetails(bw, (GarlicKnots) item);
            } else if (item instanceof Drink) {
                writeDrinkDetails(bw, (Drink) item);
            }
        }

        bw.write("\n--------------------------------\n");
        bw.write(String.format("TOTAL: $%.2f\n", order.calculateTotal()));
        bw.write("================================\n");
        bw.write("Thank you for your order!\n");
        bw.write("================================\n");
    }

    // Creates file name for each receipt and saves it----------------------------------------------------
    public static void saveReceipt(Order order) {
        String fileName = order.getOrderId() + ".txt";
        String filePath = RECEIPT_FOLDER + File.separator + fileName;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            writeReceiptContent(bw, order);
            System.out.println("Receipt saved successfully to: " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving receipt to file: " + e.getMessage());
        }
    }

    // Makes item details for display---------------------------------------------------------------------
    private static void writePizzaDetails(BufferedWriter bw, Pizza pizza) throws IOException {
        bw.write("PIZZA (Size: " + pizza.getSize() + ")\n");
        bw.write("  Crust: " + pizza.getCrust().getName() + "\n");
        //Shows if crust is stuffed or not and adds the extra price
        if (pizza.getCrust().isStuffed()) {
            bw.write("  Stuffed Crust: Yes (+$" + String.format("%.2f", pizza.getCrust().getExtra()) + ")\n");
        }
        bw.write("  Sauce: " + pizza.getSauceType().getSauceName() + "\n");

        // Separate toppings by category
        boolean hasMeat = false;
        boolean hasCheese = false;
        boolean hasRegular = false;

        // Write meat toppings
        for (Topping t : pizza.getToppingType()) {
            if (t.getCategory().equalsIgnoreCase("meat")) {
                if (!hasMeat) {
                    bw.write("  Meats:\n");
                    hasMeat = true;
                }
                bw.write("    - " + formatToppingName(t) + "\n");
            }
        }

        // Write cheese toppings
        for (Topping t : pizza.getToppingType()) {
            if (t.getCategory().equalsIgnoreCase("cheese")) {
                if (!hasCheese) {
                    bw.write("  Cheese:\n");
                    hasCheese = true;
                }
                bw.write("    - " + formatToppingName(t) + "\n");
            }
        }

        // Write regular toppings
        for (Topping t : pizza.getToppingType()) {
            if (t.getCategory().equalsIgnoreCase("regular")) {
                if (!hasRegular) {
                    bw.write("  Toppings:\n");
                    hasRegular = true;
                }
                bw.write("    - " + t.getName() + "\n");
            }
        }

        bw.write(String.format("  Price: $%.2f\n\n", pizza.calculatePrice()));
    }

    private static void writeGarlicKnotsDetails(BufferedWriter bw, GarlicKnots knots) throws IOException {
        bw.write("GARLIC KNOTS (Count: " + knots.getSize() + ")\n");
        bw.write(String.format("  Price: $%.2f\n\n", knots.calculatePrice()));
    }

    private static void writeDrinkDetails(BufferedWriter bw, Drink drink) throws IOException {
        bw.write("DRINK\n");
        bw.write("  Size: " + drink.getSize() + "\n");
        bw.write("  Flavor: " + drink.getFlavor() + "\n");
        bw.write(String.format("  Price: $%.2f\n\n", drink.calculatePrice()));
    }

    private static String formatToppingName(Topping t) {
        if (t.getExtra() > 0) {
            return t.getName() + " (Extra x" + t.getExtra() + ")";
        }
        return t.getName();
    }
}
