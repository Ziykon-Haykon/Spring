package com.takamori.spring.service;

import com.takamori.spring.dto.response.CalcHistoryDto;
import com.takamori.spring.dto.request.CalcPatchRequest;
import com.takamori.spring.dto.request.CalcRequest;
import com.takamori.spring.dto.response.CalcResponse;

import java.util.List;

public interface CalcService {
    CalcResponse calc(CalcRequest request);
    List<CalcHistoryDto> getHistory();
    CalcHistoryDto getHistoryById(long id);
    void deleteHistory(long id);
    CalcHistoryDto put(CalcRequest request, long id);
    CalcHistoryDto patch(CalcPatchRequest request, long id);
}
