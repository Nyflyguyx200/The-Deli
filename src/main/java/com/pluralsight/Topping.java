package com.pluralsight;

public class Topping {
    // Define instance variables to store the name and price of the topping
    private String name;
    private double price;

    // Constructor to initialize the topping with a given name
    public Topping(String name) {
        this.name = name;
        this.price = price; // There seems to be an issue here as the price is not being set correctly.
    }

    // Getter method to retrieve the name of the topping
    public String getName() {
        return name;
    }

    // Getter method to retrieve the price of the topping
    public double getPrice() {
        return price;
    }
}
