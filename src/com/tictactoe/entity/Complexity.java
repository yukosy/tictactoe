package com.tictactoe.entity;

import java.util.HashMap;
import java.util.Map;

public enum Complexity {

    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard"),
    USER("user");

    private final String complexity;

    private static final Map<String, Complexity> BY_COMPLEXITY = new HashMap<>();

    static {
        for (Complexity e: values()) {
            BY_COMPLEXITY.put(e.complexity, e);
        }
    }

    public static Complexity getComplexity(String complexity) {
        return BY_COMPLEXITY.get(complexity);
    }

    Complexity(String complexity) {
        this.complexity = complexity;
    }

    public String getValue() {
        return this.complexity;
    }
}
