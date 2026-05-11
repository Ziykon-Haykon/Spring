package com.takamori.spring.Calculate;

import jakarta.validation.constraints.NotNull;

public class CalcRequest {
    @NotNull
    public Integer a;
    @NotNull
    public Integer b;
    @NotNull
    public String op;
}
