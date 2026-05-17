package com.takamori.spring.controller;

import com.takamori.spring.dto.request.CalcPatchRequest;
import com.takamori.spring.dto.request.CalcRequest;
import com.takamori.spring.dto.response.CalcResponse;
import com.takamori.spring.service.CalcService;
import com.takamori.spring.dto.response.CalcHistoryDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calc")
public class CalcController {
    private final CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping("/text")
    public String returnText(@RequestParam String text) {
        return text;
    }

    @PostMapping("/calc")
    public CalcResponse calculate(@RequestBody @Valid CalcRequest request) {
        return calcService.calc(request);
    }

    @GetMapping("/history")
    public List<CalcHistoryDto> getHistory() {
        return calcService.getHistory();
    }

    @GetMapping("/history/{id}")
    public CalcHistoryDto getHistoryById(@PathVariable("id") Long id) {
        return calcService.getHistoryById(id);
    }

    @DeleteMapping("/history/{id}")
    public void deleteHistoryById(@PathVariable("id") Long id) {
        calcService.deleteHistory(id);
    }

    @PutMapping("history/{id}")
    public CalcHistoryDto putValueHistory(@PathVariable Long id,@RequestBody CalcRequest request) {
        return calcService.put(request, id);
    }

    @PatchMapping("history/{id}")
    public CalcHistoryDto patch(@PathVariable Long id, @RequestBody CalcPatchRequest request) {
        return calcService.patch(request, id);
    }
}