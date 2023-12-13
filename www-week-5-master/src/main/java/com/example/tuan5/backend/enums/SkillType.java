package com.example.tuan5.backend.enums;


public enum SkillType {
    UNSPECIFIC(0),

    TECHNICAL_SKILL(1),

    SOFT_SKILL(2);

    private final int value;
    SkillType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
