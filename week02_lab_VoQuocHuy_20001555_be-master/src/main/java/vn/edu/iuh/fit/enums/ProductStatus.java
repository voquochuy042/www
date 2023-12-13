package vn.edu.iuh.fit.enums;

public enum ProductStatus {
    ACTIVE(0), INACTIVE(1), DISCONTINUED(2);
    private int i;
    ProductStatus(int i) {
    }

    public Integer getStatus() {
        return i;
    }
}
