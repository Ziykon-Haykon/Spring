package com.takamori.spring.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalcPatchRequest {
    private Integer a;
    private Integer b;
    private String op;
}
