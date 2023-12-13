package com.example.demo.enums;

public enum Type {
    BEGINNER(0),
    INTERMEDIATE(1),
    MASTER(2);

    private final int typeNum;

    private Type(int typeNum){
        this.typeNum = typeNum;
    }
    public int getTypeNum(){
        return this.typeNum;
    }
    public static Type getSkillType(int typeNum) {
        switch (typeNum) {
            case 0:
                return Type.BEGINNER;
            case 1:
                return Type.INTERMEDIATE;
            case 2:
                return Type.MASTER;
            default:
                return Type.BEGINNER;
        }
    }
}
