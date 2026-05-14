package com.takamori.spring.Calculate;
import com.takamori.spring.dto.CalcHistoryDto;
import com.takamori.spring.entity.CalcHistory;
import com.takamori.spring.repository.CalcHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcService {
    private final CalcHistoryRepository repository;
    CalcHistoryDto historyDto = new CalcHistoryDto();

    public CalcService(CalcHistoryRepository repository) {
        this.repository = repository;
    }

    public int calc(int a, int b, String op) {
        int result = switch (op) {
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
        var history = new CalcHistory();

        historyDto.setB(b);
        historyDto.setA(a);
        historyDto.setOp(op);
        historyDto.setResult(result);
        history.setA(a);
        history.setB(b);
        history.setOp(op);
        history.setResult(result);

        repository.save(history);
        return result;
    }

    public CalcHistoryDto getHistory() {
        return historyDto;
    }
}
