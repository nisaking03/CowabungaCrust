# Cowabunga Crust (Capstone 2)

A Teenage Mutant Ninja Turtle themed Java-based console application for ordering pizza, garlic knots, and drinks. Built to demonstrate object-oriented programming principles including inheritance and polymorphism.

## Features

- **Interactive Menu System** — Navigate through hierarchical menus with proper error handling
- **Custom Pizza Builder** — Choose size, crust, toppings, and sauce to create your own pizza
- **Signature Pizzas** — Pre-made pizza options with customization available
- **Dynamic Pricing** — Prices calculate based on size and topping selections
- **Order Management** — Add multiple items, view order summary, and calculate totals
- **Receipt Generation** — Saves completed orders to text files in a receipt/ folder
- **Input Validation** — Handles invalid inputs gracefully with re-prompts

## Project Structure
<img width="1279" height="881" alt="Screenshot 2025-11-13 175528" src="https://github.com/user-attachments/assets/d3dff0d0-5a23-4de2-bbd7-65304100c2e2" />

## Order Menu
<img width="577" height="351" alt="Screenshot 2025-11-13 184250" src="https://github.com/user-attachments/assets/f9f4ba8b-6f76-4333-ba72-c6db6bd5cb83" />

Once in an order, you can:

1) Add Pizza — Build custom or choose signature
2) Add Drink — Pick size and flavor
3) Add Garlic Knots — Choose 16 or 32 count
4) Checkout — Review and confirm order
0) Cancel Order — Return to main menu

# Building a Custom Pizza
<img width="256" height="266" alt="Screenshot 2025-11-13 184632" src="https://github.com/user-attachments/assets/069f489b-06d7-41ec-b439-7ce1a8d78d30" />

- Choose size (S, M, or L)
- Choose crust type (Thin, Regular, Thick, Cauliflower)
- Choose meat toppings (optional extras available)
- Choose cheese toppings (optional extras available)
- Choose regular toppings (free!)
- Choose sauce
- Confirm completion

# Signature Pizzas
<img width="711" height="545" alt="Screenshot 2025-11-13 184758" src="https://github.com/user-attachments/assets/7a40e533-83fe-4ed3-abdf-656940638b31" />

- Michelangelo Melt ($17.50) — L, Thick, Marinara
- Leo's Leader Pie ($16.00) — L, Thick, Marinara
- Raph's Rage Slice ($16.50) — L, Thick, Buffalo
- Donnie's Tech Supreme ($16.50) — M, Regular, Pesto

All can be customized after selection.

# Checkout
<img width="519" height="290" alt="Screenshot 2025-11-13 184913" src="https://github.com/user-attachments/assets/0ee556d0-d08f-4537-b68e-9ae22c508a74" />

- Review all items in your order
- See itemized breakdown
- View total price
- Confirm to save receipt or cancel

## Key Classes

### Item (Abstract)
Purpose: Base class for all orderable items. Ensures all items can calculate their own price.

### Pizza
Purpose: Complex pricing logic. Calculates price based on size, crust, and toppings.

### Drink
Purpose: Simple implementation. Returns fixed price based on size.

### Order
Purpose: Manages collection of items. Validates orders and calculates totals using polymorphism.

### Topping, Sauce, Crust
Supporting classes that compose into Pizza. Handle categorization and extras tracking.

# Learning Outcomes

This project demonstrates:
## Object-Oriented Principles
- Inheritance — Pizza, Drink, GarlicKnots all extend Item
- Polymorphism — Same getPrice() call, different behaviors
- Abstraction — Item is abstract; concrete classes implement
- Encapsulation — Private fields with public getters/setters

## Java Features
- Abstract Classes — Item base class
- ArrayLists — Dynamic collections of toppings and items
- Switch Expressions — Menu navigation
- Streams — Order.calculateTotal() uses streams
- File I/O — Receipt generation and saving
- Scanner — Console input handling
- Static Variables — Shared currentOrder across methods

# Struggles & Solutions (From Development)
<img width="759" height="585" alt="Screenshot 2025-11-13 185043" src="https://github.com/user-attachments/assets/e0000276-99f0-46c6-963e-f5f211330872" />
<img width="757" height="578" alt="Screenshot 2025-11-13 185059" src="https://github.com/user-attachments/assets/a6855d10-db63-48a9-883e-2b8f1098e077" />
<img width="573" height="469" alt="Screenshot 2025-11-13 185113" src="https://github.com/user-attachments/assets/eb083662-ee69-42b7-8293-6929561935e5" />

**Struggle #1**: Price Calculations
- Problem: Pizza pricing is complex and varies by size and toppings
- Solution: Break into separate methods (getMeatPrice(), getCheesePrice())

**Struggle #2**: Different Item Types
- Problem: Pizza, Drink, and GarlicKnots are different but similar
- Solution: Abstract base class Item with polymorphic calculatePrice()

**Struggle #3**: Managing Current Order
- Problem: All menu methods need access to the same order
- Solution: Static currentOrder variable (appropriate for this single-user console app)

# Problem-Solving
- Hierarchical Menus — Using return statements for proper flow
- Complex Pricing — Breaking calculations into methods
- Error Handling — Validating inputs and re-prompting

# Potential Improvements

- Unit tests for pricing calculations
- Using interfaces for pricing methods used throughout
