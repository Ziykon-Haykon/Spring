package com.takamori.spring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalcHistoryDto {
    private int a;
    private int b;
    private String op;
    private int result;
}