package com.takamori.spring.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalcRequest {
    @NotNull
    public Integer a;
    @NotNull
    public Integer b;
    @NotNull
    public String op;
}
