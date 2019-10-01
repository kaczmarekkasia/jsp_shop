package model;

public enum TaxType {
    PRODUCT (0.23),
    SERVICE(0.8);

    private final double value;

    TaxType(double value) {
       this.value = value;
    }
}
