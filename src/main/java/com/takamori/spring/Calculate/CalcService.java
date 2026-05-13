package com.takamori.spring.Calculate;
import org.springframework.stereotype.Service;

@Service
public class CalcService {
    public int calc(int a, int b, String op) {
        return switch (op) {
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    throw new IllegalArgumentException("Division by zero");
                }
                    yield a / b;
            }
            case "+" -> a + b;
            case "-" -> a - b;
            default -> throw new IllegalArgumentException("unknown operator " + op);
        };
    }
}
