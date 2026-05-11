package com.takamori.spring;

import com.takamori.spring.Calculate.CalcRequest;
import com.takamori.spring.Calculate.CalcResponse;
import com.takamori.spring.Calculate.CalcService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
}