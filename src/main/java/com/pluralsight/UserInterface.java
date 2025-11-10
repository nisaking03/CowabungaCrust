package com.pluralsight;

import java.util.ArrayList;

public class UserInterface {

    public void display() {
        //The application should continue to run until the user chooses to exit.
        System.out.println("Welcome to Cowabunga Crust");
        String mainMenu = """
                    1) New Order" +
                    0) Exit
                    """;


        while (true) {
            System.out.print(mainMenu);
            int command = ConsoleHelper.promptForInt("Enter here"); //prompt for menu

            switch (command) {
                case 1:
                    newOrder();
                    break;
                case 0: //exit
                    return;
                default:
                    System.out.println("Invalid Entry!"); //Error message
                    break;

            }
        }
    }

    private void newOrder() {
        String orderMenu = """
                        1) Add Pizza
                        2) Add Drink
                        3) Add Garlic Knots
                        4) Checkout
                        0) Cancel Order - delete the order and go back to the home page\n""";


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

    //-----------------------------------------------------------------------------

    private void addPizza() {
        String pizzaMenu = """
                        1) Build your own pizza
                        2) Look at our signature's
                        0) Back
                        """;

        while (true) {
            System.out.print(pizzaMenu);
            int command = ConsoleHelper.promptForInt("Enter here"); //prompt for menu

            switch (command) {
                case 1 -> buildPizza();
                case 2 -> signaturePizza();
                case 0 -> {return;}
                default -> System.out.println("Invalid Entry!"); //Error message

            }
        }
    } //TODO

    private void buildPizza() {
        //Prompts to customize pizza

        String sizePrompt ="""
        Enter a size:
         S - 8.50
         M - 12.00
         L - 16.50
        """; //connect to pricing
        System.out.println(sizePrompt);
        String size = ConsoleHelper.promptForString("Enter here");
        Pizza.getBasePrice(size);


        //---------------------------------------------------------------


        String crustType ="""
               What crust type
                1) Thin
                2) Regular
                3) Thick
                4) Cauliflower
               """;

        System.out.print(crustType);
        int crustPrompt = ConsoleHelper.promptForInt("Enter here"); //prompt for menu

        switch (crustPrompt) {
            case 1 -> {
                String crust1 = ItemList.crust[0];
            }
            case 2 -> {
                String crust2 = ItemList.crust[1];
            }
            case 3 -> {
                String crust3 = ItemList.crust[2];
            }
            case 4 -> {
                String crust4 = ItemList.crust[3];
            }
            default -> System.out.println("Invalid Entry!"); //Error message
        }

        String stuffedCrustPrompt = "Would you like stuffed crust?"; //connect to pricing
        System.out.println(stuffedCrustPrompt);
        boolean stuffedCrust = ConsoleHelper.promptForString("Enter here (Y/N)").equalsIgnoreCase("y");


        //--------------------------------------------------------------------------------------------------------


        String meatTopping = """
                What meat topping?
                1) Pepperoni
                2) Sausage
                3) Ham
                4) Bacon
                5) Chicken
                6) Meatball""";

        System.out.print(meatTopping);
        int meatPrompt = ConsoleHelper.promptForInt("Enter here");

        switch (meatPrompt) {
            case 1 -> {
                String meat1 = ItemList.meats[0];
            }
            case 2 -> {
                String meat2 = ItemList.meats[1];
            }
            case 3 -> {
                String meat3 = ItemList.meats[2];
            }
            case 4 -> {
                String meat4 = ItemList.meats[3];
            }
            case 5 -> {
                String meat5 = ItemList.meats[4];
            }
            case 6 -> {
                String meat6 = ItemList.meats[5];
            }
            default -> System.out.println("Invalid Entry!"); //Error message
        }

        String extraMeatPrompt = "Would you like extra meat?"; //connect to pricing
        System.out.println(extraMeatPrompt);
        boolean extraMeat = ConsoleHelper.promptForString("Enter here (Y/N)").equalsIgnoreCase("y");
        //calsulate meat price here


        //-----------------------------------------------------------------------------


        String cheeseTopping = """
                What cheese?
                1) Mozzarella
                2) Parmesan
                3) Ricotta
                4) Goat Cheese
                5) Buffalo""";

        System.out.print(cheeseTopping);
        int cheesePrompt = ConsoleHelper.promptForInt("Enter here");


        //------------------------------------------------------------------


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
                9) Anchovies""";

        System.out.print(regTopping);
        int regTopPrompt = ConsoleHelper.promptForInt("Enter here");


        //-------------------------------------------------------------------


        String sauce = """
                What sauce? (Free)
               1) Marinara
               2) Alfredo
               3) Pesto
               4) BBQ
               5) Buffalo
               6) Olive Oil""";

        System.out.print(sauce);
        int saucePrompt = ConsoleHelper.promptForInt("Enter here");


        //---------------------------------------------------------------------

//        boolean running = true;
//        while (running) {
//            System.out.print("Would you like to list toppings?");
//            char command;
//            command = ConsoleHelper.promptForChar(" (Y/N)"); //prompt for menu
//
//            switch (command) {
//                case 'Y':
//                    displayToppingList();
//                    running = false;
//                    //turn into array list
//                    break;
//                case 'N':
//                    running = false;
//                    break;
//                default:
//                    System.out.println("Invalid Entry!"); //Error message
//                    break;
//
//            }
//        }

//        String toppingPrompt = ConsoleHelper.promptForString("What toppings would you like");


//        String extrasPrompt = ConsoleHelper.promptForString("Would you like to add more?"); //todo boolean
//        //§ Prompt for extra toppings: //list toppings already chosen
//        //§ Select sauces: //list sauces
//        //o Would you like the pizza with stuffed crust? //todo boolean
//        //TODO

    }

    //• Add Pizza - the add pizza screen will walk the user through several
    //options to create the pizza
    //o Select your type:
    //o Pizza size:
    //o Toppings: - the user should be able to add extras of each topping
    //§ Meat:
    //§ Cheese:
    //§ Other toppings:
    //§ Select sauces:
    //o Would you like the pizza with stuffed crust?

    private void displayToppingList() {
        // Access the static array from ItemList.java
        System.out.println("\n--- This is the real meat ---");

        // for 6 meats we have, loop through them all and put thim into a
        // seperate string called meat

        // ------ MEATS
        for (String meat : ItemList.meats) {
            System.out.println(meat);
        }

        // ------ CHEESE
        System.out.println("\n--- This is the real cheese ---");
        for (String cheese : ItemList.cheese) {
            System.out.println(cheese);
        }

        // ------ REG TOPS
        System.out.println("\n--- This is the basic ahh toppings ---");
        for (String regularToppings : ItemList.regularToppings) {
            System.out.println(regularToppings);
        }


        // ------ SAUCES
        System.out.println("\n--- IF it ain't marinara, get outta here ---");
        for (String sauces : ItemList.sauces) {
            System.out.println(sauces);
        }



        //run array list
        return;
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

    //-----------------------------------------------------------------------------

    private void addDrink() {

    }

    private void addGarlicKnots() {

    }

    private void checkout() {

    }
}

//When a customer places the order, they should be prompted to customize each
//pizza one at a time.

//A customer should also be able to add drinks and garlic knots to their order.

//Application should display the order details, including the list of pizzas that were ordered with all the toppings
//The screen should also display the total cost of the order.
//When the customer completes the order, the order details should be saved to a receipts folder.
//Each order should have its own receipt file, and it should be named by the date and time that the order was placed
//(yyyyMMdd-hhmmss.txt - i.e. 20230329-121523.txt)





//Toppings(collection) -> arraylist<Cheese>, arrayList<Meat>, arrayList<>