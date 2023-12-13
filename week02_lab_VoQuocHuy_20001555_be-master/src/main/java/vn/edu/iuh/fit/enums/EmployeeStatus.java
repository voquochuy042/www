package vn.edu.iuh.fit.enums;

public enum EmployeeStatus {
    ACTIVE(1),//dang lam
    ON_LEAVE(0),//nghi tam thoi
    TERMINATED(-1);// nghi luon

    EmployeeStatus(int i) {
    }
}
