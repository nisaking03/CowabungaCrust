package com.pluralsight;

import java.util.ArrayList;

import static com.pluralsight.ItemList.crust;

public class UserInterface {

    private Order currentOrder;

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
            case 0 -> {
                return;
            }
            default -> System.out.println("Invalid Entry!"); //Error message

        }

    } //TODO

    private void buildPizza() {
        //Prompts to customize pizza
//        Pizza pizza = new Pizza("",0,"", "");

        String buildPizzaMenu = """
                
                1) Choose your size
                2) Choose your crust
                3) Choose your toppings
                4) Choose your sauce
                0) Back
                """;

        System.out.println(buildPizzaMenu);
        int command = ConsoleHelper.promptForInt("Enter here");


        switch (command) {
            case 1 -> getPizzaSize();
            case 2 -> getCrustType();
            case 3 -> getToppings();
            case 4 -> getSauce();
            case 0 -> {
                return;
            }
            default -> System.out.println("Invalid Entry!");
        }
    }

    private String getPizzaSize() {
        //Has the size prompt
        String sizePrompt = """
                
                Enter a size:
                 S - 8.50
                 M - 12.00
                 L - 16.50
                """; //connect to pricing
        System.out.print(sizePrompt);
        String size = ConsoleHelper.promptForString("Enter here");

        if (size.equalsIgnoreCase("S") || size.equalsIgnoreCase("M") || size.equalsIgnoreCase("L")) {
            return size.toUpperCase();
        } else if (size.equals("0")) {
            return null;
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
            case 1:
                crust = new Crust("Thin", false, 0.00);
                break;
            case 2:
                crust = new Crust("Regular", false, 0.00);
                break;
            case 3:
                crust = new Crust("Thick", false, 0.00);
                break;
            case 4:
                crust = new Crust("Cauliflower", false, 0.00);
                break;
            default:
                System.out.println("Invalid choice!");
                return getCrustType();
        }

        // NOW ask about stuffed crust
        System.out.println("Would you like stuffed crust? (+$2.50)");
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
            boolean extraMeat = ConsoleHelper.promptForString("Would you like extra meat? (Y/N)").equalsIgnoreCase("y");

            // If yes, set extras to 1, if no set to 0
            int extraCount = extraMeat ? 1 : 0;

            // Create topping object with extras
            Topping meatTopping2 = new Topping(meatName, "meat", extraCount);
            toppings.add(meatTopping2);
        } else if (meatPrompt == 0) {
            return null;
        }

        // CHEESE TOPPING
        String cheeseTopping = """
                
                What cheese?
                1) Mozzarella
                2) Parmesan
                3) Ricotta
                4) Goat Cheese
                5) Buffalo
                0) None
                """;

        System.out.print(cheeseTopping);
        int cheesePrompt = ConsoleHelper.promptForInt("Enter here");

        if (cheesePrompt >= 1 && cheesePrompt <= 5) {
            // Get cheese name from array (subtract 1 because arrays start from 0)
            String cheeseName = ItemList.cheese[cheesePrompt - 1];

            // Ask if they want extra
            boolean extraCheese = ConsoleHelper.promptForString("Would you like extra cheese? (Y/N)").equalsIgnoreCase("y");

            // If yes, set extras to 1, if no set to 0
            int extraCount = extraCheese ? 1 : 0;

            // Create topping object with extras count
            Topping cheeseTopping2 = new Topping(cheeseName, "cheese", extraCount);
            toppings.add(cheeseTopping2); // Add to toppings list
        } else if (cheesePrompt == 0) {
            return null;
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

        if (regTopPrompt >= 1 && regTopPrompt <= 9) {
            String regToppingName = ItemList.regularToppings[regTopPrompt - 1];
            Topping regularTopping = new Topping(regToppingName, "regular");
            toppings.add(regularTopping);

            return toppings;
        } else {
            return null;
        }
    }

    private String getSauce() {
        String sauce = """
                
                What sauce? (Free)
                1) Marinara
                2) Alfredo
                3) Pesto
                4) BBQ
                5) Buffalo
                6) Olive Oil
                0) None
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
            case 0 -> {
                return null;
            }
            default -> System.out.println("Invalid Entry!"); //Error message
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

    //-----------------------------------------------------------------------------


//    private void addGarlicKnots() {
//        boolean running = true;
//        while (running) {
//            System.out.print("Would you like Garlic Knots?\n");
//            char command;
//            command = ConsoleHelper.promptForChar("\nEnter here (Y/N)"); //prompt for menu
//
//            switch (command) {
//                case 'Y':
//                    displayGarlicKnot();
//                    running = false;
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
//    }

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
//        if (currentOrder.isEmpty()) {
//            System.out.println("Your order is empty! Please add items before checking out.");
//            return;
//        }
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