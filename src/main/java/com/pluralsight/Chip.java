package com.pluralsight;

public class Chip extends OrderItem {
    // Declare a private instance variable to store the type of chip
    private String type;

    // Constructor for creating a Chip object with a specified type
    public Chip(String type) {
        // Call the constructor of the superclass (OrderItem) with "Chip" as the item type and $1.50 as the default price
        super("Chip", 1.50);
        // Initialize the type of chip
        this.type = type;
    }

    // Method to get the price of the chip
    public double getPrice() {
        // Return the fixed price of $1.50 for the chip
        return 1.50;
    }

    // Override the toString() method to provide a string representation of the Chip object
    @Override
    public String toString() {
        // Return a string representation including the type of chip
        return "Chip(" +
                "type='" + type + '\'' +
                ')';
    }
}
