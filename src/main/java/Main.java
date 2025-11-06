public class Main {
    public static void main(String[] args){

    }
}

//todo -----Main Functionality-----
//Customers can order pizzas in 3 sizes
//(Personal 8", Medium 12", Large 16"). When they order, they choose the type of
//crust that they would like (thin, regular, thick, or cauliflower)

//The customer can then choose their toppings. Toppings are categorized as regular and premium.

//Meats and cheeses are premium toppings, but most other toppings are considered regular.

//Customers can request for extra toppings, but premium toppings come at an
// additional cost. Each pizza can have stuffed crust

//A customer can place an order with 0 or more pizzas on the order. If a customer
//places an order with 0 pizzas, they must purchase garlic knots or a drink.

//When a customer places the order, they should be prompted to customize each
//pizza one at a time.

//A customer should also be able to add drinks and garlic knots to their order.

//Application should display the order details, including the list of pizzas that were ordered with all the toppings
//The screen should also display the total cost of the order.
//When the customer completes the order, the order details should be saved to a receipts folder.
//Each order should have its own receipt file, and it should be named by the date and time that the order was placed
//(yyyyMMdd-hhmmss.txt - i.e. 20230329-121523.txt)


//todo ------Possible Classes/Interfaces-------
//Pizza - Class
//Crust - Interface
//Toppings - Interface
//Cheese - Interface
//Sauce - Interface
//Sides - Interface
//Drink - Class
//Garlic Knots - Class


//todo -------Menu Layout-------

//Home Screen----------------
//Give the user the following options. The application should continue to run until the user chooses to exit.
//§ 1) New Order
//§ 0) Exit - exit the application

//Order Screen---------------
//All entries should show the newest entries first
//o 1) Add Pizza
//o 2) Add Drink
//o 3) Add Garlic Knots
//o 4) Checkout
//o 0) Cancel Order - delete the order and go back to the home page



//todo Add Pizza Screen-----------
//Will walk the user through several options to create the pizza
//o Select your type: //todo Signature pizza or Build your own

//Build Your Own-------------
//o Pizza size: //list sizes
//o Toppings: //list toppings - the user should be able to add extras of each topping
//§ Meat: //list meats
//§ Cheese: //list cheese
//§ Prompt for extra toppings: //list toppings already chosen
//§ Select sauces: //list sauces
//o Would you like the pizza with stuffed crust? //todo boolean

//Signature Pizza------------ //todo has set ingredients/size, can modify from prompts
//o Pick which pizza you'd like:
//o Would you like to modify this pizza? //todo boolean
//todo If yes to Modify-----
//o Pizza size: //list sizes
//o Toppings: //list toppings - the user should be able to add extras of each topping
//§ Meat: //list meats
//§ Cheese: //list cheese
//§ Prompt for extra toppings: //list toppings already chosen
//§ Select sauces: //list sauces
//o Would you like the pizza with stuffed crust? //todo boolean



//todo Add Drink-----------------
//select drink size and flavor



//todo Add Garlic Knots----------
//todo boolean

//todo Checkout------------------
//display the order details and the price



//todo Confirm-------------------
//create the receipt file and go back to the home screen



//todo Cancel--------------------
//delete order and go back to the home screen