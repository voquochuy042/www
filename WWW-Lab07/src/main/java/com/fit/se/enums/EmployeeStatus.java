package com.fit.se.enums;

import lombok.Getter;

@Getter
public enum EmployeeStatus {
    ACTIVE(1),
    IN_ACTIVE(0),
    TERMINATED(-1);
    private final int value;

    EmployeeStatus(int value) {
        this.value = value;
    }

}
