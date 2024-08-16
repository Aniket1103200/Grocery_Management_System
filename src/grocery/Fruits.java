package grocery;



public enum Fruits {
    APPLE(100), BANANA(20), ORANGE(50), MANGO(80), GRAPES(90);
    
    private final int pricePerUnit;

    Fruits(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }
}

