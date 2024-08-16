package grocery;



public enum Vegetables {
    TOMATO(40), CUCUMBER(30), FENUGREEK(20), CORIANDER(15), CARROT(40);
    
    private final int pricePerUnit;

    Vegetables(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }
}

