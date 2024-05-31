# The Deli 

## Description
The Deli is a Java application designed to streamline the ordering process at a deli. It allows customers to create new orders, customize sandwiches with various toppings, add drinks, chips, and proceed to checkout.

## Usage
1. Run the mainApp.java file to start the application.
2. Select "New Order" to create a new order.
3. Follow the prompts to add items to your order, customize them as desired.
4. Proceed to checkout to confirm your order and save the receipt.

## Features
- **Create New Order**: Start a new order session.
- **Customize Sandwiches**: Choose bread type, size, toppings, and extras.
- **Add Drinks and Chips**: Select from a variety of options.
- **Checkout**: Confirm your order and save the receipt.

## Screenshots

<img width="959" alt="Capstone2" src="https://github.com/Nyflyguyx200/The-Deli/assets/114933451/ebb60270-e05a-417f-ae09-d96429c3defa">
<img width="959" alt="Capstone2(7)" src="https://github.com/Nyflyguyx200/The-Deli/assets/114933451/e8abb56f-ec4b-4b5c-b4ce-dd45d2496d39">
<img width="959" alt="Capstone2(6)" src="https://github.com/Nyflyguyx200/The-Deli/assets/114933451/e1a4f74f-126c-4e56-b02a-12e5edcd9118">
<img width="959" alt="Capstone2(5)" src="https://github.com/Nyflyguyx200/The-Deli/assets/114933451/337e953e-d5f3-4ea6-af7c-a32fc692d6ba">
<img width="959" alt="Capstone2(4)" src="https://github.com/Nyflyguyx200/The-Deli/assets/114933451/0d83d4d6-6c52-4333-aa3f-e50c67e91a82">
<img width="959" alt="Capstone2(3)" src="https://github.com/Nyflyguyx200/The-Deli/assets/114933451/52c8e30d-62c8-4b17-9819-d8959d97432d">
<img width="953" alt="Capstone2(2)" src="https://github.com/Nyflyguyx200/The-Deli/assets/114933451/77019ba6-193c-495c-afee-5226e96f7b5d">
<img width="893" alt="Capstone2(1)" src="https://github.com/Nyflyguyx200/The-Deli/assets/114933451/9bd1b894-6983-4900-9381-50751ed05a9e">


## One Piece of Interesting Code
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

This approach is interesting because it demonstrates a common optimization technique for string manipulation in Java, showcasing how to build complex string representations efficiently.
    

