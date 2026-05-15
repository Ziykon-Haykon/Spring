package com.takamori.spring;

import com.takamori.spring.Calculate.CalcRequest;
import com.takamori.spring.Calculate.CalcResponse;
import com.takamori.spring.Calculate.CalcService;
import com.takamori.spring.dto.CalcHistoryDto;
import com.takamori.spring.entity.CalcHistory;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    private final CalcService calcService;

    public MainController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping("/text")
    public String returnText(@RequestParam String text) {
        return text;
    }

    @PostMapping("/calc")
    public CalcResponse calculate(@RequestBody @Valid CalcRequest request) {
        int result = calcService.calc(request.a, request.b, request.op);
        var response = new CalcResponse();
        response.result = result;
        return response;
    }

    @GetMapping("/history")
    public List<CalcHistoryDto> getHistory() {
        return calcService.getHistory();
    }

    @GetMapping("/history/{id}")
    public CalcHistoryDto getHistoryById(@PathVariable("id") Long id) {
        return calcService.getHistoryById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHistoryById(@PathVariable("id") Long id) {
        calcService.deleteHistory(id);
    }
}