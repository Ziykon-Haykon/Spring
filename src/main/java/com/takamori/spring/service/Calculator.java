package com.takamori.spring.service;

public class Calculator {
    public int calculate(int a, int b, String op) {
        return switch (op) {
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {throw new IllegalArgumentException("Division by zero");}
                yield a / b;
            }
            case "+" -> a + b;
            case "-" -> a - b;
            default -> throw new IllegalArgumentException("unknown operator " + b);
        };
    }
}
