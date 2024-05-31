package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends OrderItem {
    // Define instance variables to store the size, bread type, toppings, and toasted status of the sandwich
    private String size;
    private String breadType;
    private List<Topping> toppings;
    private boolean toasted;

    // Constructor to initialize the Sandwich with size, bread type, and toasted status
    public Sandwich(String size, String breadType, boolean toasted) {
        // Call the superclass constructor with a formatted name including size, bread type, and toasted status, and the base price based on size
        super("Sandwich (" + size + " " + breadType + (toasted ? " toasted" : " not toasted") + ")", getBasePrice(size));
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
    }

    // Method to add a topping to the sandwich
    public void addTopping(Topping topping) {
        toppings.add(topping);
        // Update the price of the sandwich by adding the price of the topping
        this.price += topping.getPrice();
    }

    // Static method to get the base price of the sandwich based on its size
    private static double getBasePrice(String size) {
        switch (size) {
            case "4\"":
                return 5.50;
            case "8\"":
                return 7.00;
            case "12\"":
                return 8.50;
            default:
                System.out.println("Invalid sandwich size. Setting price to 0.0");
                return 0.0;
        }
    }

    // Method to set the price of the sandwich
    public void setPrice(double price) {
        this.price = price;
    }

    // Override the toString() method to return a string representation of the sandwich, including toppings
    @Override
    public String toString() {
        StringBuilder sandwichDetails = new StringBuilder(super.toString());
        sandwichDetails.append(" with ");
        // Iterate through each topping and append its name to the sandwichDetails StringBuilder
        for (int i = 0; i < toppings.size(); i++) {
            sandwichDetails.append(toppings.get(i).getName());
            // Add a comma if there are more toppings
            if (i < toppings.size() - 1) {
                sandwichDetails.append(", ");
            }
        }
        return sandwichDetails.toString();
    }
}
