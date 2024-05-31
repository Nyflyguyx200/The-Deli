package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mainApp {
    private static Scanner scanner = new Scanner(System.in);

    // Lists to store different types of toppings
    private static final ArrayList<String> MEAT_TOPPINGS = new ArrayList<>();
    private static final ArrayList<String> CHEESE_TOPPINGS = new ArrayList<>();
    private static final ArrayList<String> OTHER_TOPPINGS = new ArrayList<>();
    private static final ArrayList<String> SAUCES = new ArrayList<>();

    // Static initialization block to populate the topping lists
    static {
        // Populate meat toppings
        MEAT_TOPPINGS.add("steak");
        MEAT_TOPPINGS.add("ham");
        MEAT_TOPPINGS.add("salami");
        MEAT_TOPPINGS.add("roast beef");
        MEAT_TOPPINGS.add("chicken");
        MEAT_TOPPINGS.add("bacon");

        // Populate cheese toppings
        CHEESE_TOPPINGS.add("cheddar");
        CHEESE_TOPPINGS.add("provolone");
        CHEESE_TOPPINGS.add("swiss");
        CHEESE_TOPPINGS.add("american");

        // Populate other toppings
        OTHER_TOPPINGS.add("lettuce");
        OTHER_TOPPINGS.add("peppers");
        OTHER_TOPPINGS.add("onions");
        OTHER_TOPPINGS.add("tomatoes");
        OTHER_TOPPINGS.add("jalapenos");
        OTHER_TOPPINGS.add("cucumbers");
        OTHER_TOPPINGS.add("pickles");
        OTHER_TOPPINGS.add("guacamole");
        OTHER_TOPPINGS.add("mushrooms");

        // Populate sauces
        SAUCES.add("mayo");
        SAUCES.add("mustard");
        SAUCES.add("ketchup");
        SAUCES.add("ranch");
        SAUCES.add("thousand islands");
        SAUCES.add("vinaigrette");
    }

    public static void main(String[] args) {
    //control the main loop
    boolean running = true;

    // Main loop of the application
    while (running) {
        // Display the welcome message and menu options
        System.out.println("---------Welcome to the Deli!---------");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.print("Enter choice: ");

        // Read user input
        int choice = Integer.parseInt(scanner.nextLine());

        // Process user choice
        switch (choice) {
            case 1:
                createNewOrder(); // Create a new order
                break;
            case 0:
                running = false; // Exit the application
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }
}

    private static void createNewOrder() {
        // Create a new Order object to hold the items of the order
        Order order = new Order();
        // Flag to control the ordering process
        boolean ordering = true;

        // Loop to interactively add items to the order
        while (ordering) {
            // Display the menu options for adding items
            System.out.println();
            System.out.println("Here are the options you can select.");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Enter choice: ");
            // Read the user's choice
            int choice = Integer.parseInt(scanner.nextLine());

            // Process the user's choice
            switch (choice) {
                case 1:
                    addSandwich(order); // Add a sandwich to the order
                    break;
                case 2:
                    addDrink(order); // Add a drink to the order
                    break;
                case 3:
                    addChips(order); // Add chips to the order
                    break;
                case 4:
                    checkout(order); // Proceed to checkout
                    ordering = false; // Exit the ordering loop
                    break;
                case 0:
                    ordering = false; // Cancel the order and exit the ordering loop
                    break;
                default:
                    System.out.println("Invalid choice, please try again."); // Display error message for invalid input
            }
        }
    }

    private static void addSandwich(Order order) {
        // Prompt the user to select the bread type
        System.out.println("Select your bread: (white, wheat, rye, wrap)");

        // Read the user's choice for the bread type
        System.out.print("Enter choice: ");
        String breadType = scanner.nextLine();

        // Prompt the user to select the size of the sandwich
        System.out.println("Select your size: (4\", 8\", 12\")");

        // Read the user's choice for the sandwich size
        System.out.print("Enter choice: ");
        String size = scanner.nextLine();

        // Ask the user if they want the sandwich toasted
        System.out.print("Would you like the sandwich toasted? (yes/no): ");
        // Read the user's choice for toasting preference
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        // Create a new Sandwich object with the specified properties
        Sandwich sandwich = new Sandwich(size, breadType, toasted);

        // Add Meat toppings
        // Add initial meat toppings to the sandwich
        addToppings(sandwich, MEAT_TOPPINGS, "Meat");

// Prompt the user if they want extra meat
        System.out.print("Would you like extra meat? (yes/no): ");
        boolean extraMeat = scanner.nextLine().equalsIgnoreCase("yes");

// If the user wants extra meat, add it to the sandwich
        if (extraMeat) {
            addToppings(sandwich, MEAT_TOPPINGS, "Extra Meat");

            // Calculate additional cost for extra meat based on sandwich size
            double extraMeatCost = 0.0;
            switch (size) {
                case "4\"":
                    extraMeatCost = 0.50;
                    break;
                case "8\"":
                    extraMeatCost = 1.00;
                    break;
                case "12\"":
                    extraMeatCost = 1.50;
                    break;
                default:
                    System.out.println("Invalid sandwich size. Extra meat cost not added.");
            }
            // Update the total price of the sandwich to include the extra meat cost
            sandwich.setPrice(sandwich.getPrice() + extraMeatCost);
        }

// Add cheese toppings to the sandwich
        addToppings(sandwich, CHEESE_TOPPINGS, "Cheese");

// Prompt the user if they want extra cheese
        System.out.print("Would you like extra cheese? (yes/no): ");
        boolean extraCheese = scanner.nextLine().equalsIgnoreCase("yes");

// If the user wants extra cheese, add it to the sandwich
        if (extraCheese) {
            addToppings(sandwich, CHEESE_TOPPINGS, "Extra Cheese");

            // Calculate additional cost for extra cheese based on sandwich size
            double extraCheeseCost = 0.0;
            switch (size) {
                case "4\"":
                    extraCheeseCost = 0.50;
                    break;
                case "8\"":
                    extraCheeseCost = 1.00;
                    break;
                case "12\"":
                    extraCheeseCost = 1.50;
                    break;
                default:
                    System.out.println("Invalid sandwich size. Extra cheese cost not added.");
            }
            // Update the total price of the sandwich to include the extra cheese cost
            sandwich.setPrice(sandwich.getPrice() + extraCheeseCost);
        }

        // Add toppings to the sandwich from the OTHER_TOPPINGS list
        addToppings(sandwich, OTHER_TOPPINGS, "Other toppings");

// Add sauces to the sandwich from the SAUCES list
        addToppings(sandwich, SAUCES, "Sauces");

// Add the completed sandwich to the order
        order.addSandwich(sandwich);
    }

    // Method to add toppings to a sandwich
    private static void addToppings(Sandwich sandwich, List<String> availableToppings, String category) {
        // Flag to control the loop for adding toppings
        boolean addingToppings = true;
        while (addingToppings) {
            // Prompt the user to add a topping for the specified category
            System.out.println("Add a " + category + " topping (type 'done' when finished): ");
            // Display available toppings for the specified category
            for (String topping : availableToppings) {
                System.out.println("- " + topping);
            }
            // Prompt the user to enter their choice
            System.out.print("Enter choice: ");
            String toppingName = scanner.nextLine();
            // If the user is done adding toppings, exit the loop
            if (toppingName.equalsIgnoreCase("done")) {
                addingToppings = false;
            }
            // If the entered topping is valid, add it to the sandwich
            else if (availableToppings.contains(toppingName)) {
                sandwich.addTopping(new Topping(toppingName));
            }
            // If the entered topping is invalid, prompt the user to try again
            else {
                System.out.println("Invalid topping, please try again.");
            }
        }
    }

    // Method to add a drink to the order
    private static void addDrink(Order order) {
        // Prompt the user to select drink size
        System.out.println("Select drink size: (Small, Medium, Large)");
        System.out.print("Enter choice: ");
        String size = scanner.nextLine();
        // Prompt the user to select drink flavor
        System.out.println("Select drink flavor: (Cola, Lemonade, Orange)");
        System.out.print("Enter choice: ");
        String type = scanner.nextLine();

        // Add the selected drink to the order
        order.addDrink(new Drink(size, type));
    }

    // Method to add chips to the order
    private static void addChips(Order order) {
        // Prompt the user to select chip type
        System.out.println("Select chip type: (Small, Medium, Large)");
        System.out.print("Enter choice: ");
        String type = scanner.nextLine();

        // Add the selected chips to the order
        order.addChip(new Chip(type));
    }

    // Method to proceed to-checkout and finalize the order
    private static void checkout(Order order) {
        // Display the order details to the user
        System.out.println(order);
        // Prompt the user to confirm the order
        System.out.print("Confirm order? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            // If the user confirms, save the receipt and notify the user
            new Receipt(order).saveReceipt();
            System.out.println("Order confirmed and saved!");
        } else {
            // If the user cancels, notify the user
            System.out.println("Order cancelled.");
        }
    }
}
