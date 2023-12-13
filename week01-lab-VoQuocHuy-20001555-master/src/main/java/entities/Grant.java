package entities;

public enum Grant {
    DIASABLE(0), ENABLE(1);
    private final int code;

    Grant(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    public static Grant fromCode(int code) throws IllegalAccessException {
        for (Grant grant: Grant.values()) {
            if (grant.getCode() == code){
                return grant;
            }
        }
        throw new IllegalAccessException("Invalid AccountStatus code: "+ code);
    }
}
