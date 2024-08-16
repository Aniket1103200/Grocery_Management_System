package validation;



import grocery.Category;
import exception.InvalidOperationException;

public class InputValidator {
    public static Category validateCategory(String categoryInput) throws InvalidOperationException {
        try {
            return Category.valueOf(categoryInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidOperationException("Invalid category. Please try again.");
        }
    }

    public static int validateQuantity(int quantity) throws InvalidOperationException {
        if (quantity <= 0) {
            throw new InvalidOperationException("Quantity should be positive. Please try again.");
        }
        return quantity;
    }
}

