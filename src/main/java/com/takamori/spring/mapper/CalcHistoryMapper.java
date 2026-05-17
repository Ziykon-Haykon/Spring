package com.takamori.spring.mapper;

import com.takamori.spring.dto.request.CalcRequest;
import com.takamori.spring.dto.response.CalcHistoryDto;
import com.takamori.spring.entity.CalcHistory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CalcHistoryMapper {
    CalcHistoryDto toDto(CalcHistory history);
    List<CalcHistoryDto> toDtoList(List<CalcHistory> histories);
    CalcHistory toEntity(CalcRequest request);
}
