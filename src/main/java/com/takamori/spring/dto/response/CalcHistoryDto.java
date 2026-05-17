package com.takamori.spring.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalcHistoryDto {
    private Long id;
    private Integer a;
    private Integer b;
    private String op;
    private Integer result;
}