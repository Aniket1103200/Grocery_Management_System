package grocery;


public enum DairyProducts {
    MILK(45), CHEESE(250), BUTTER(150), YOGURT(60), CREAM(200);
    
    private final int pricePerUnit;

    DairyProducts(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }
}

