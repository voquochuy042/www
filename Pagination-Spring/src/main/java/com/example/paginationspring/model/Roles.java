package com.example.paginationspring.model;

import lombok.Data;
import lombok.Getter;

@Getter
public enum Roles {
    ADMINISTRATION(1),
    STAFF(2),
    MANAGER(3),
    EXECUTIVE(4);
    private final int value;
    Roles(int value) {
        this.value = value;
    }
}
