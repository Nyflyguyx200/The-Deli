package com.pluralsight;

public class Drink extends OrderItem {
    // Declare private instance variables to store the size and flavor of the drink
    private String size;
    private String flavor;

    // Constructor for creating a Drink object with a specified size and flavor
    public Drink(String size, String flavor) {
        // Call the constructor of the superclass (OrderItem) with a formatted string including the size and flavor and the price returned by the getDrinkPrice() method
        super("Drink (" + size + " " + flavor + ")", getDrinkPrice(size));
        // Initialize the size and flavor of the drink
        this.size = size;
        this.flavor = flavor;
    }

    // Static method to calculate and return the price of the drink based on its size
    private static double getDrinkPrice(String size) {
        // Use a switch statement to determine the price based on the size of the drink
        switch (size) {
            case "Small":
                return 2.00;
            case "Medium":
                return 2.50;
            case "Large":
                return 3.00;
            // Handle the case when the size is not recognized by printing an error message and setting the price to 0.0
            default:
                System.out.println("Invalid drink size. Setting price to 0.0");
                return 0.0;
        }
    }

    // Override the toString() method to provide a string representation of the Drink object
    @Override
    public String toString() {
        // Return a string representation including the size, flavor, and price of the drink
        return "Drink: Size=" + size + ", Flavor=" + flavor + ", Price=" + getPrice();
    }
}

