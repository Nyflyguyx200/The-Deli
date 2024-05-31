package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    // Declare a private instance variable to store the order associated with the receipt
    private Order order;

    // Constructor to initialize the Receipt object with an Order object
    public Receipt(Order order) {
        this.order = order;
    }

    // Method to save the receipt to a file
    public void saveReceipt() {
        // Generate the order details with a timestamp
        String orderDetails = generateOrderDetails();

        // Get the current timestamp
        LocalDateTime now = LocalDateTime.now();

        // Define a formatter to format the timestamp as yyyyMMdd-HHmmss
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

        // Format the current timestamp using the formatter
        String timestamp = now.format(formatter);

        // Construct the file path with the timestamp
        String filePath = timestamp + ".txt";

        // Write the order details to the file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(orderDetails);
            System.out.println("Order receipt saved successfully.");
        } catch (IOException e) {
            // Handle IO exception if occurred during writing to the file
            System.err.println("Error writing receipt: " + e.getMessage());
        }
    }

    // Method to generate the order details
    private String generateOrderDetails() {
        // Get the current timestamp
        LocalDateTime now = LocalDateTime.now();

        // Define a formatter to format the timestamp as yyyyMMdd-HHmmss
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

        // Format the current timestamp using the formatter
        String timestamp = now.format(formatter);

        // Generate the order details including the timestamp and order information
        String details = "Order Timestamp: " + timestamp + "\n" +
                order.toString() + "\n" +
                "------------------------------------------------\n";
        return details;
    }
}

