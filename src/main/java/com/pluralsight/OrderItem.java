package com.pluralsight;

public abstract class OrderItem {
    // Declare protected instance variables to store the name and price of the order item
    protected String name;
    protected double price;

    // Constructor to initialize the OrderItem with a name and price
    public OrderItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Method to get the price of the order item
    public double getPrice() {
        return price;
    }

    // Override the toString() method to return a string representation of the order item
    @Override
    public String toString() {
        return name + ": $" + price;
    }
}
