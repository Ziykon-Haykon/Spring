package com.takamori.spring.service.impl;
import com.takamori.spring.dto.request.CalcPatchRequest;
import com.takamori.spring.dto.request.CalcRequest;
import com.takamori.spring.dto.response.CalcHistoryDto;
import com.takamori.spring.dto.response.CalcResponse;
import com.takamori.spring.entity.CalcHistory;
import com.takamori.spring.mapper.CalcHistoryMapper;
import com.takamori.spring.repository.CalcHistoryRepository;
import com.takamori.spring.service.CalcService;
import com.takamori.spring.service.Calculator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CalcServiceImpl implements CalcService {
    private final CalcHistoryRepository repository;
    private final Calculator calculate = new Calculator();
    private final CalcHistoryMapper mapper;

    public CalcServiceImpl(CalcHistoryRepository repository, CalcHistoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public CalcResponse calc(CalcRequest request) {
        var result = calculate.calculate(request.getA(), request.getB(), request.getOp());

        CalcHistory history = new CalcHistory();
        history.setA(request.getA());
        history.setB(request.getB());
        history.setOp(request.getOp());
        history.setResult(result);

        repository.save(history);

        CalcResponse response = new CalcResponse();
        response.setResult(result);

        return response;
    }

    public List<CalcHistoryDto> getHistory() {
        List<CalcHistory> histories = repository.findAll();
        return histories.stream().map(mapper::toDto).toList();
    }

    public CalcHistoryDto getHistoryById(long id) {
        var history = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "History not found"));
        return mapper.toDto(history);
    }

    public void deleteHistory(long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "History not found"
            );
        }
        repository.deleteById(id);
    }

    public CalcHistoryDto put(CalcRequest request, long id) {
        var history = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "History not found"));
        history.setA(request.getA());
        history.setB(request.getB());
        history.setOp(request.getOp());
        history.setResult(calculate.calculate(request.getA(), request.getB(), request.getOp()));
        var saved = repository.save(history);
        return mapper.toDto(saved);
    }

    public CalcHistoryDto patch(CalcPatchRequest request, long id) {
        var history = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "History not found"));
        if (request.getA() != null) {
            history.setA(request.getA());
        }
        if (request.getB() != null) {
            history.setB(request.getB());
        }
        if (request.getOp() != null) {
            history.setOp(request.getOp());
            history.setResult(calculate.calculate(history.getA(), history.getB(), history.getOp()));
        }
        if (request.getA() != null || request.getB() != null) {
            history.setResult(calculate.calculate(history.getA(), history.getB(), history.getOp()));
        }
        return mapper.toDto(history);
     }
}
