package com.takamori.spring.mapper;

import com.takamori.spring.dto.CalcHistoryDto;
import com.takamori.spring.entity.CalcHistory;

public class CalcHistoryMapper {
    public static CalcHistoryDto toDto(CalcHistory history) {
        CalcHistoryDto dto = new CalcHistoryDto();

        dto.setResult(history.getResult());
        dto.setA(history.getA());
        dto.setB(history.getB());
        dto.setOp(history.getOp());

        return dto;
    }
}
