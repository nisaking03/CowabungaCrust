package com.pluralsight.userinterface;
import com.pluralsight.data.ItemList;
import com.pluralsight.data.Order;
import com.pluralsight.data.ReceiptManager;
import com.pluralsight.models.*;
import java.util.ArrayList;

public class UserInterface {

    public static Order currentOrder;

    public void display() {
        //The application should continue to run until the user chooses to exit.
        System.out.println("""
                ╭ ──────┉─────── • ─────┉────── ╮
                   𝕎𝕖𝕝𝕔𝕠𝕞𝕖 𝕥𝕠 ℂ𝕠𝕨𝕒𝕓𝕦𝕟𝕘𝕒 ℂ𝕣𝕦𝕤𝕥!
                ╰ ──────┉─────¡! • !¡─────┉─────╯
                """);


        String mainMenu = """
                1) New Order
                0) Exit
                """;

        while (true) {
            System.out.print(mainMenu);
            int command = ConsoleHelper.promptForInt("Enter here"); //prompt for menu

            switch (command) {
                case 1 -> newOrder();
                case 0 -> System.exit(0); // Force closes program
                default -> System.out.println("Invalid Entry!"); //Error message
            }
        }
    }

    private void newOrder() {
        currentOrder = new Order();
        String orderMenu = """
                
                1) Add Pizza
                2) Add Drink
                3) Add Garlic Knots
                4) Checkout
                0) Cancel Order - delete the order and go back to the home page
                """;

        while (true) {
            System.out.print(orderMenu);
            int command = ConsoleHelper.promptForInt("Enter here"); //prompt for menu

            switch (command) {
                case 1 -> addPizza();
                case 2 -> addDrink();
                case 3 -> addGarlicKnots();
                case 4 -> checkout();
                case 0 -> {
                    System.out.println("Peace out!"); //exit
                    return;
                }
                default -> System.out.println("Invalid Entry!"); //Error message
            }
        }
    }

    private void addPizza() {
        String pizzaMenu = """
                
                1) Build your own pizza
                2) Look at our signature's
                0) Back
                """;

        System.out.print(pizzaMenu);
        int command = ConsoleHelper.promptForInt("Enter here"); //prompt for menu

        switch (command) {
            case 1 -> buildPizza();
            case 2 -> signaturePizza();
            case 0 -> {return;}
            default -> System.out.println("Invalid Entry!"); //Error message
        }
    }

    private void buildPizza() {
        //Prompts to customize pizza
        Pizza pizza = new Pizza();

        String buildPizzaMenu = """
                
                1) Choose your size
                2) Choose your crust
                3) Choose your toppings
                4) Choose your sauce
                0) All done!
                """;

        while (true) {
            System.out.println(buildPizzaMenu);
            int command = ConsoleHelper.promptForInt("Enter here");

            switch (command) {
                case 1 -> {
                    pizza.size = getPizzaSize();
                    // Set base price after selecting size
                    if (pizza.size != null) {
                        pizza.price = Pizza.getBasePrice(pizza.size);
                    }
                }
                case 2 -> pizza.crustType = getCrustType();
                case 3 -> pizza.toppingType = getToppings();
                case 4 -> pizza.sauceType = getSauce();
                case 0 -> {
                    if (pizza.size != null && pizza.crustType != null && pizza.sauceType != null) {
                        currentOrder.addItem(pizza);System.out.println("\nPizza added to order!");return;
                    } else{
                        System.out.println("\nPlease select size, crust, and sauce before finishing!");
                    }
                }
                default -> System.out.println("Invalid Entry!");
            }
        }
    }

    private String getPizzaSize() {
        String sizePrompt = """
                
                Enter a size:
                 S - 8.50
                 M - 12.00
                 L - 16.50
                """;

        System.out.print(sizePrompt);
        String size = ConsoleHelper.promptForString("Enter here");

        if (size.equalsIgnoreCase("S") || size.equalsIgnoreCase("M") || size.equalsIgnoreCase("L")) {
            return size.toUpperCase();
        } else {
            System.out.println("Invalid size! Please try again.");
            return getPizzaSize();
        }
    }

    private Crust getCrustType() {
        // Has the crust prompt
        String crustPrompt = """
                
                What crust type
                 1) Thin
                 2) Regular
                 3) Thick
                 4) Cauliflower
                """;

        System.out.print(crustPrompt);
        int choice = ConsoleHelper.promptForInt("Enter here");

        Crust crust = null;

        switch (choice) {
            case 1 -> crust = new Crust("Thin", false, 0.00);
            case 2 -> crust = new Crust("Regular", false, 0.00);
            case 3 -> crust = new Crust("Thick", false, 0.00);
            case 4 -> crust = new Crust("Cauliflower", false, 0.00);
            default -> {
                System.out.println("Invalid choice!");
                return getCrustType();
            }
        }

        // NOW ask about stuffed crust
        System.out.println("\nWould you like stuffed crust? (+$2.50)");
        boolean stuffedCrust = ConsoleHelper.promptForString("Enter here (Y/N)").equalsIgnoreCase("y");

        if (stuffedCrust) {
            crust.setExtra(crust.getExtra() + 2.50);
        }
        return crust;
    }

    private ArrayList<Topping> getToppings() {
        ArrayList<Topping> toppings = new ArrayList<>();

        // MEAT TOPPING
        String meatTopping = """
                
                What meat topping?
                1) Pepperoni
                2) Sausage
                3) Ham
                4) Bacon
                5) Chicken
                6) Meatball
                0) None
                """;

        System.out.print(meatTopping);
        int meatPrompt = ConsoleHelper.promptForInt("Enter here");

        if (meatPrompt >= 1 && meatPrompt <= 6) {
            // Get meat name from array (subtract 1 because arrays start from 0)
            String meatName = ItemList.meats[meatPrompt - 1];

            // Ask if they want extra
            boolean extraMeat = ConsoleHelper.promptForString("\nWould you like extra meat? (Y/N)").equalsIgnoreCase("y");

            // If yes, set extras to 1, if no set to 0
            int extraCount = extraMeat ? 1 : 0;

            // Create topping object with extras
            Topping meatOption = new Topping(meatName, "meat", extraCount);
            toppings.add(meatOption);

        } else if (meatPrompt == 0) {
            return toppings;
        }

        // CHEESE TOPPING
        String cheeseTopping = """
                
                What cheese?
                1) Mozzarella
                2) Parmesan
                3) Ricotta
                4) Goat Cheese
                5) Buffalo
                """;

        System.out.print(cheeseTopping);
        int cheesePrompt = ConsoleHelper.promptForInt("Enter here");

        if (cheesePrompt >= 1 && cheesePrompt <= 5) {
            // Get cheese name from array (subtract 1 because arrays start from 0)
            String cheeseName = ItemList.cheese[cheesePrompt - 1];

            // Ask if they want extra
            boolean extraCheese = ConsoleHelper.promptForString("\nWould you like extra cheese? (Y/N)").equalsIgnoreCase("y");

            // If yes, set extras to 1, if no set to 0
            int extraCount = extraCheese ? 1 : 0;

            // Create topping object with extras count
            Topping cheeseTopping2 = new Topping(cheeseName, "cheese", extraCount);
            toppings.add(cheeseTopping2); // Add to toppings list

        } else if (cheesePrompt == 0) {
            return toppings;
        }

        // REGULAR TOPPINGS
        String regTopping = """
                
                What other toppings? (Free)
                1) Onions
                2) Mushrooms
                3) Bell Peppers
                4) Olives
                5) Tomatoes
                6) Spinach
                7) Basil
                8) Pineapple
                9) Anchovies
                0) None
                """;

        System.out.print(regTopping);
        int regTopPrompt = ConsoleHelper.promptForInt("Enter here");

        if (regTopPrompt >= 1 && regTopPrompt <= ItemList.regularToppings.length) {
            String regToppingName = ItemList.regularToppings[regTopPrompt - 1];
            Topping regularTopping = new Topping(regToppingName, "regular");
            toppings.add(regularTopping);

        } else if (regTopPrompt == 0) {
            return toppings;
        }

        return toppings;
    }

    private Sauce getSauce() {
        String sauceList = """
                
                What sauce? (Free)
                1) Marinara
                2) Alfredo
                3) Pesto
                4) BBQ
                5) Buffalo
                6) Olive Oil
                """;

        System.out.print(sauceList);
        int choice = ConsoleHelper.promptForInt("Enter here");

        Sauce sauce = null;

        switch (choice) {
            case 1 -> sauce = new Sauce("Marinara", 0.00);
            case 2 -> sauce = new Sauce("Alfredo", 0.00);
            case 3 -> sauce = new Sauce("Pesto", 0.00);
            case 4 -> sauce = new Sauce("BBQ", 0.00);
            case 5 -> sauce = new Sauce("Buffalo", 0.00);
            case 6 -> sauce = new Sauce("Olive Oil", 0.00);
            default -> {
                System.out.println("\nInvalid choice!");
                return getSauce();
            }
        }
        return sauce;
    }

    private void signaturePizza() {
        //Lists pizza's


        //Prompt for any wanted changes
        System.out.println("Would you like to change anything?");


        //Prompts for changes
        String sizePrompt = ConsoleHelper.promptForString("Enter a size (S, M, L)");
        //Pizza size

        String toppingPrompt = ConsoleHelper.promptForString("List toppings?");
        //o Toppings: //list toppings - the user should be able to add extras of each topping
        //§ Meat: //list meats
        //§ Cheese: //list cheese

        String extrasPrompt = ConsoleHelper.promptForString("Would you like to add more?"); //todo boolean
        //§ Prompt for extra toppings: //list toppings already chosen
        //§ Select sauces: //list sauces
        //o Would you like the pizza with stuffed crust? //todo boolean
    } //TODO

    private void addGarlicKnots() {
        String garlicCountPrompt = """
                
                What count would you like?
                1) 16 count
                2) 32 count
                0) Back
                """;

        System.out.print(garlicCountPrompt);
        int garlicPrompt = ConsoleHelper.promptForInt("Enter here");

        switch (garlicPrompt) {
            case 1 -> {
                // Actually create the object and add to order
                String size = ItemList.garlicKnots[0];  // "16"
                double price = GarlicKnots.getGarlicKnotPrice(size);

                GarlicKnots knots = new GarlicKnots(size, price);
                currentOrder.addItem(knots);

                System.out.println("\nGarlic knots (16 count) added to order!");
            }
            case 2 -> {
                // Actually create the object and add to order
                String size = ItemList.garlicKnots[1];  // "32"
                double price = GarlicKnots.getGarlicKnotPrice(size);

                GarlicKnots knots = new GarlicKnots(size, price);
                currentOrder.addItem(knots);

                System.out.println("\nGarlic knots (32 count) added to order!");
            }
            case 0 -> {
                return;
            }
            default -> System.out.println("\nInvalid Entry!");
        }
    }

    private void addDrink() {
        // Prompt for drink size first
        String drinkSizePrompt = """
            
            What size?
            S - $2.00
            M - $2.50
            L - $3.00
            0) Back
            """;

        System.out.print(drinkSizePrompt);
        String sizeChoice = ConsoleHelper.promptForString("Enter here");

        String drinkSize;

        if (sizeChoice.equalsIgnoreCase("S") || sizeChoice.equalsIgnoreCase("M") ||
                sizeChoice.equalsIgnoreCase("L")) {
            drinkSize = sizeChoice.toUpperCase();

        } else if (sizeChoice.equalsIgnoreCase("0")) {
            return;

        } else {
            System.out.println("\nInvalid choice!");
            addDrink();
            return;
        }

        // Now show flavor options
        String flavorPrompt = """
            
            What flavor?
            1) Coke
            2) Pepsi
            3) Sprite
            4) Fanta
            5) Dr Pepper
            6) Lemonade
            7) Iced Tea
            8) Water
            0) Back
            """;

        System.out.print(flavorPrompt);
        int flavorChoice = ConsoleHelper.promptForInt("Enter here");

        if (flavorChoice < 1 || flavorChoice > ItemList.drinkFlavors.length) {
            if (flavorChoice == 0) {
                return;
            }
            System.out.println("\nInvalid choice!");
            addDrink();
            return;
        }

        String drinkFlavor = ItemList.drinkFlavors[flavorChoice - 1];
        Drink drink = new Drink(drinkSize, Drink.getDrinkPrice(drinkSize), drinkFlavor);

        currentOrder.addItem(drink);
        System.out.println("\nDrink added to order!");
    }

    private void checkout() {
        if (!currentOrder.isValidOrder()) {
            System.out.println("\nInvalid order! You must have at least a pizza, or garlic knots/drink.");
            return;
        }

        // Display order summary
        System.out.println(
                "\n━━━━━━━━━━━━━━━━━━━━ ORDER SUMMARY ━━━━━━━━━━━━━━━━━━━━" +
                "\nDate/Time: " + currentOrder.getPrettyDate());

        System.out.println("\nItems:");
        // Counts off and numbers items bought
        for (int i = 0; i < currentOrder.getItems().size(); i++) {
            System.out.println((i + 1) + ") " + currentOrder.getItems().get(i));
        }

        double total = currentOrder.calculateTotal();
        System.out.println(
                "\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" +
                "\nTotal: $" + String.format("%.2f", total) +
                "\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        // Ask for confirmation
        String confirm = ConsoleHelper.promptForString("Confirm order? (Y/N)");

        if (confirm.equalsIgnoreCase("y")) {
            System.out.println("\nOrder confirmed!");
            // Create receipt folder and save receipt
            new ReceiptManager().ensureReceiptFolderExists();
            ReceiptManager.saveReceipt(currentOrder);
            System.out.println("Receipt saved. Returning to home screen...\n");
            display();
        } else {
            System.out.println("Order cancelled. Returning to order menu...\n");
        }
    }
}