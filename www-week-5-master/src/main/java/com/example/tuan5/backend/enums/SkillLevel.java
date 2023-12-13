package com.example.tuan5.backend.enums;

public enum SkillLevel {
    MASTER(0),
    BEGIN(1),
    ADVANCED(2),
    PROFESSIONAL(3),
    IMTERMEDIATE(4);

    private final int numValue;

    private SkillLevel(int numValue){
        this.numValue = numValue;
    }
    public int getNumValue(){
        return this.numValue;
    }
    public static SkillLevel getSkillLevel(int skillNum){
        return switch (skillNum) {
            case 0 -> SkillLevel.MASTER;
            case 1 -> SkillLevel.BEGIN;
            case 2 -> SkillLevel.ADVANCED;
            case 3 -> SkillLevel.PROFESSIONAL;
            default -> SkillLevel.IMTERMEDIATE;
        };
    }
}