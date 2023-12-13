package vn.edu.iuh.fit.labweek1.entities;

public enum Grant {
    disable(0),
    enable(1);

    private final int value;

    private Grant(int value) {
        this.value = value;
    }

    public Integer getGrantValue() {
        return value;
    }
}
