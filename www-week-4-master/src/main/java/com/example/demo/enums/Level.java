package com.example.demo.enums;

public enum Level {
    JUNIOR(0),
    MIDDLE(1),
    SENIOR(2);
    private final int level;
    private Level(int level){
        this.level = level;
    }

    public int getLevelNumber(){
        return this.level;
    }
    public static Level getSkillLevel(int level){
        return switch (level){
            case 0 -> Level.JUNIOR;
            case 1 -> Level.MIDDLE;
            case 2 -> Level.SENIOR;
            default -> Level.JUNIOR;
        };
    }

}
