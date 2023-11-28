package backend.enums;

public enum ProductStatus {
    ACTIVE(1),
    TERMINATED(-1),
    IN_ACTIVE(0);
    private final int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
