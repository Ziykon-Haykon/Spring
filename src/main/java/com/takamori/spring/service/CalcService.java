package com.takamori.spring.service;

import com.takamori.spring.dto.CalcHistoryDto;
import com.takamori.spring.dto.CalcPatchRequest;
import com.takamori.spring.dto.CalcRequest;
import com.takamori.spring.dto.CalcResponse;

import java.util.List;

public interface CalcService {
    CalcResponse calc(CalcRequest request);
    List<CalcHistoryDto> getHistory();
    CalcHistoryDto getHistoryById(long id);
    void deleteHistory(long id);
    CalcHistoryDto put(CalcRequest request, long id);
    CalcHistoryDto patch(CalcPatchRequest request, long id);
}
