package com.pluralsight;

import java.util.ArrayList;

public class UserInterface {

    public void display() {
        //The application should continue to run until the user chooses to exit.
        System.out.println("Welcome to Cowabunga Crust");


        String mainMenu =
                "1) New Order\n" +
                        "0) Exit\n";


        while (true) {
            System.out.print(mainMenu);
            int command;

            command = ConsoleHelper.promptForInt("Enter here"); //prompt for menu

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
        String orderMenu =
                "1) Add Pizza\n" +
                        "2) Add Drink\n" +
                        "3) Add Garlic Knots\n" +
                        "4) Checkout\n" +
                        "0) Cancel Order - delete the order and go back to the home page\n";


        while (true) {
            System.out.print(orderMenu);
            int command;

            command = ConsoleHelper.promptForInt("Enter here"); //prompt for menu

            switch (command) {
                case 1:
                    addPizza();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addGarlicKnots();
                    break;
                case 4:
                    checkout();
                    break;
                case 0: //exit
                    return;
                default:
                    System.out.println("Invalid Entry!"); //Error message
                    break;

            }
        }
    }

    //-----------------------------------------------------------------------------

    private void addPizza() {
        String pizzaMenu =
                "1) Build your own pizza\n" +
                        "2) Look at our signature's\n" +
                        "0) Cancel Order - delete the order and go back to the home page\n";


        while (true) {
            System.out.print(pizzaMenu);
            int command;

            command = ConsoleHelper.promptForInt("Enter here"); //prompt for menu

            switch (command) {
                case 1:
                    buildPizza();
                    break;
                case 2:
                    signaturePizza();
                    break;
                case 0: //exit
                    return;
                default:
                    System.out.println("Invalid Entry!"); //Error message
                    break;

            }
        }
    } //TODO

    private void buildPizza() {
        //Prompts to customize pizza

        String sizePrompt = ConsoleHelper.promptForString("Enter a size (S, M, L)");
        //Pizza size

//        char listToppingPrompt = ConsoleHelper.promptForChar("List toppings? (Y or N)");
//
//        if(listToppingPrompt == 'Y'){
//            //List the toppings
//            //ask what topping you want
//        }
//        else if (listToppingPrompt == 'N'){
//            //What toppings you want
//        }
//        else{}
        boolean running = true;
        while (running) {
            System.out.print("Would you like to list toppings?");
            char command;
            command = ConsoleHelper.promptForChar("Enter here"); //prompt for menu

            switch (command) {
                case 'Y':
                    toppingList();
                    running = false;
                    //turn into array list
                    break;
                case 'N':
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Entry!"); //Error message
                    break;

            }
        }

        String toppingPrompt = ConsoleHelper.promptForString("What toppings would you like");

        //Meat

        ArrayList<String>Meats = ["bacon","ham"];

        if(toppingPrompt.equalsIgnoreCase("meat")){
            System.out.println(Meats);
        }

        String extrasPrompt = ConsoleHelper.promptForString("Would you like to add more?"); //todo boolean
        //§ Prompt for extra toppings: //list toppings already chosen
        //§ Select sauces: //list sauces
        //o Would you like the pizza with stuffed crust? //todo boolean
        //TODO

    }



    private void toppingList() {
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