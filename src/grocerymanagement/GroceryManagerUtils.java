package grocerymanagement;



import grocery.*;
import validation.InputValidator;
import exception.InvalidOperationException;

import java.util.HashMap;
import java.util.Map;

public class GroceryManagerUtils {

    private static Map<String, Integer> cart = new HashMap<>();

    public static void showGrocery() {
        System.out.println("Available Vegetables:");
        for (Vegetables vegetable : Vegetables.values()) {
            System.out.println(vegetable.name() + " - ₹" + vegetable.getPricePerUnit() + " per unit");
        }

        System.out.println("\nAvailable Fruits:");
        for (Fruits fruit : Fruits.values()) {
            System.out.println(fruit.name() + " - ₹" + fruit.getPricePerUnit() + " per unit");
        }

        System.out.println("\nAvailable Dairy Products:");
        for (DairyProducts dairy : DairyProducts.values()) {
            System.out.println(dairy.name() + " - ₹" + dairy.getPricePerUnit() + " per unit");
        }
    }

    public static void addToCart(String categoryInput, String itemName, int quantity)
            throws InvalidOperationException {

        Category category = InputValidator.validateCategory(categoryInput);
        quantity = InputValidator.validateQuantity(quantity);

        int price;
        switch (category) {
            case VEGETABLES -> price = Vegetables.valueOf(itemName).getPricePerUnit();
            case FRUITS -> price = Fruits.valueOf(itemName).getPricePerUnit();
            case DAIRY_PRODUCTS -> price = DairyProducts.valueOf(itemName).getPricePerUnit();
            default -> throw new InvalidOperationException("Invalid category. Please try again.");
        }

        cart.put(itemName, cart.getOrDefault(itemName, 0) + quantity);
        System.out.println("Added to cart: " + itemName + " (x" + quantity + ") - ₹" + price * quantity);
    }

    public static void placeOrder() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Please add items to the cart before placing an order.");
            return;
        }

        int totalCost = 0;
        System.out.println("Your Cart:");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();
            int pricePerUnit = getPrice(item);
            int cost = pricePerUnit * quantity;
            totalCost += cost;
            System.out.println(item + " (x" + quantity + ") - ₹" + cost);
        }

        System.out.println("Total Cost: ₹" + totalCost);
        cart.clear();
        System.out.println("Order placed successfully. Thank you!");
    }

    private static int getPrice(String item) {
        try {
            return Vegetables.valueOf(item).getPricePerUnit();
        } catch (IllegalArgumentException e) {
            try {
                return Fruits.valueOf(item).getPricePerUnit();
            } catch (IllegalArgumentException ex) {
                return DairyProducts.valueOf(item).getPricePerUnit();
            }
        }
    }
}

