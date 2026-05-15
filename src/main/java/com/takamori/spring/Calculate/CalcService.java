package com.takamori.spring.Calculate;
import com.takamori.spring.dto.CalcHistoryDto;
import com.takamori.spring.entity.CalcHistory;
import com.takamori.spring.mapper.CalcHistoryMapper;
import com.takamori.spring.repository.CalcHistoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalcService {
    private final CalcHistoryRepository repository;

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

        history.setA(a);
        history.setB(b);
        history.setOp(op);
        history.setResult(result);

        repository.save(history);
        return result;
    }

    public List<CalcHistoryDto> getHistory() {
        List<CalcHistory> histories = repository.findAll();
        return histories.stream().map(CalcHistoryMapper::toDto).toList();
    }

    public CalcHistoryDto getHistoryById(long id) {
        var history = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "History not found"));
        return CalcHistoryMapper.toDto(history);
    }
}
