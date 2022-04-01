package com.tictactoe.entity;

public enum Complexity {

    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard"),
    USER("user");

    private final String complexity;
    Complexity(String complexity) {
        this.complexity = complexity;
    }

    public String getValue() {
        return this.complexity;
    }
}
