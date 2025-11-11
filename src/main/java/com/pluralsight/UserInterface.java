package com.pluralsight;

public class UserInterface {

    public void display() {
        //The application should continue to run until the user chooses to exit.
        System.out.println("Welcome to Cowabunga Crust");
        String mainMenu = """
                    1) New Order
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

    //-----------------------------------------------------------------------------

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

        System.out.println("Would you like stuffed crust?");
        boolean stuffedCrust = ConsoleHelper.promptForString("Enter here (Y/N)").equalsIgnoreCase("y");


        //--------------------------------------------------------------------------------------------------------


        String meatTopping = """
                What meat topping?
                1) Pepperoni
                2) Sausage
                3) Ham
                4) Bacon
                5) Chicken
                6) Meatball
                """;

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

        System.out.println("Would you like extra meat?");
        boolean extraMeat = ConsoleHelper.promptForString("Enter here (Y/N)").equalsIgnoreCase("y");
        //calsulate meat price here


        //-----------------------------------------------------------------------------


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

        switch (cheesePrompt) {
            case 1 -> {
                String cheese1 = ItemList.cheese[0];
            }
            case 2 -> {
                String cheese2 = ItemList.cheese[1];
            }
            case 3 -> {
                String cheese3 = ItemList.cheese[2];
            }
            case 4 -> {
                String cheese4 = ItemList.cheese[3];
            }
            case 5 -> {
                String cheese5 = ItemList.cheese[4];
            }
            default -> System.out.println("Invalid Entry!"); //Error message
        }

        System.out.println("Would you like extra cheese?");
        boolean extraCheese = ConsoleHelper.promptForString("Enter here (Y/N)").equalsIgnoreCase("y");
        //calsulate meat price here


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
                9) Anchovies
                """;

        System.out.print(regTopping);
        int regTopPrompt = ConsoleHelper.promptForInt("Enter here");

        switch (regTopPrompt) {
            case 1 -> {
                String reg1 = ItemList.regularToppings[0];
            }
            case 2 -> {
                String reg2 = ItemList.regularToppings[1];
            }
            case 3 -> {
                String reg3 = ItemList.regularToppings[2];
            }
            case 4 -> {
                String reg4 = ItemList.regularToppings[3];
            }
            case 5 -> {
                String reg5 = ItemList.regularToppings[4];
            }
            case 6 -> {
                String reg6 = ItemList.regularToppings[5];
            }
            case 7 -> {
                String reg7 = ItemList.regularToppings[6];
            }
            case 8 -> {
                String reg8 = ItemList.regularToppings[7];
            }
            case 9 -> {
                String reg9 = ItemList.regularToppings[8];
            }
            default -> System.out.println("Invalid Entry!"); //Error message
        }
        //add extra


        //-------------------------------------------------------------------


        String sauce = """
                What sauce? (Free)
               1) Marinara
               2) Alfredo
               3) Pesto
               4) BBQ
               5) Buffalo
               6) Olive Oil
               """;

        System.out.print(sauce);
        int saucePrompt = ConsoleHelper.promptForInt("Enter here");

        switch (saucePrompt) {
            case 1 -> {
                String sauce1 = ItemList.sauces[0];
            }
            case 2 -> {
                String sauce2 = ItemList.sauces[1];
            }
            case 3 -> {
                String sauce3 = ItemList.sauces[2];
            }
            case 4 -> {
                String sauce4 = ItemList.sauces[3];
            }
            case 5 -> {
                String sauce5 = ItemList.sauces[4];
            }
            case 6 -> {
                String sauce6 = ItemList.sauces[5];
            }
            default -> System.out.println("Invalid Entry!"); //Error message
        }
        //add extra


        //---------------------------------------------------------------------



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


    private void addGarlicKnots() {
        System.out.println("Would you like Garlic Knots?");

        boolean running = true;
        while (running) {
            System.out.print("Would you like Garlic Knots?");
            char command;
            command = ConsoleHelper.promptForChar("Enter here (Y/N)"); //prompt for menu

            switch (command) {
                case 'Y':
                    displayGarlicKnot();
                    running = false;
                    break;
                case 'N':
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Entry!"); //Error message
                    break;

            }
        }
    }

    private void displayGarlicKnot(){
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
                String sauce1 = ItemList.garlicKnots[0];
            }
            case 2 -> {
                String sauce2 = ItemList.garlicKnots[1];
            }
            case 0 -> {
                return;
            }
            default -> System.out.println("Invalid Entry!");
    }

    private void addDrink() {
        String drinkPrompt = """
                        1) Add Pizza
                        2) Add Drink
                        3) Add Garlic Knots
                        4) Checkout
                        0) Cancel Order - delete the order and go back to the home page
                        """;
    }

    private void checkout() {
        if (order.isEmpty()) {
            System.out.println("Your order is empty! Please add items before checking out.");
            return;
        }
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