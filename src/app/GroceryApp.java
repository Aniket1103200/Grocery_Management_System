package app;



import java.util.Scanner;

import exception.InvalidOperationException;
import grocerymanagement.GroceryManagerUtils;

public class GroceryApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                System.out.println("Welcome to the Grocery Management System");
                System.out.println("1) See Grocery");
                System.out.println("2) Add to Cart");
                System.out.println("3) Place Order");
                System.out.println("4) Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                try {
                    switch (choice) {
                        case 1 -> GroceryManagerUtils.showGrocery();
                        case 2 -> {
                            System.out.print("Enter category (VEGETABLES, FRUITS, DAIRY_PRODUCTS): ");
                            String category = scanner.next();
                            System.out.print("Enter item name: ");
                            String itemName = scanner.next().toUpperCase();
                            System.out.print("Enter quantity: ");
                            int quantity = scanner.nextInt();
                            GroceryManagerUtils.addToCart(category, itemName, quantity);
                        }
                        case 3 -> GroceryManagerUtils.placeOrder();
                        case 4 -> running = false;
                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                } catch (InvalidOperationException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

