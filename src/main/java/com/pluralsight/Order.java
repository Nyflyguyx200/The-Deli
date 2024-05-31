package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    // Declare a list to store the order items
    private List<OrderItem> items;

    // Constructor to initialize the order with an empty list of items
    public Order() {
        this.items = new ArrayList<>();
    }

    // Method to add a sandwich to the order
    public void addSandwich(Sandwich sandwich) {
        // Add the sandwich to the list of items
        items.add(sandwich);
    }

    // Method to add a drink to the order
    public void addDrink(Drink drink) {
        // Add the drink to the list of items
        items.add(drink);
    }

    // Method to add chips to the order
    public void addChip(Chip chip) {
        // Add the chips to the list of items
        items.add(chip);
    }

    // Method to calculate and return the total price of the order
    public double getTotalPrice() {
        // Initialize a variable to store the total price
        double total = 0;
        // Iterate through each item in the order
        for (OrderItem item : items) {
            // Add the price of the item to the total
            total += item.getPrice();
        }
        // Return the total price of the order
        return total;
    }

    // Override the toString() method to provide a string representation of the order
    @Override
    public String toString() {
        // Create a StringBuilder to build the string representation of the order
        StringBuilder orderDetails = new StringBuilder();

        // Iterate through each item in the order
        for (OrderItem item : items) {
            // Append the details of the item, including its name and price, to the orderDetails StringBuilder
            orderDetails.append(item).append(": $").append(item.getPrice()).append("\n");
        }
        // Append the total price of the order to the orderDetails StringBuilder
        orderDetails.append("Total Price: $").append(getTotalPrice());

        // Return the string representation of the order
        return orderDetails.toString();
    }
}
