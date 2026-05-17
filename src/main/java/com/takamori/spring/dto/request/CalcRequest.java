package com.takamori.spring.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalcRequest {
    @NotNull
    private Integer a;
    @NotNull
    private Integer b;
    @NotNull
    private String op;
}
