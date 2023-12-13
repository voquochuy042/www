package entities;

public enum Status {
    ACTIVE(1),
    DEACTIVE(0),
    DELETE(-1);
    private int code;

    Status(int code) {
        this.code = code;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
    public static Status fromCode(int code) throws IllegalAccessException {
        for (Status status: Status.values()) {
            if (status.getCode() == code){
                return status;
            }
        }
        throw new IllegalAccessException("Invalid AccountStatus code: "+ code);
    }
}
