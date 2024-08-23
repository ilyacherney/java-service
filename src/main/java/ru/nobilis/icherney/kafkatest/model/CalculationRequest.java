package ru.nobilis.icherney.kafkatest.model;

import lombok.Getter;

public class CalculationRequest {
    @Getter
    private String name;
    @Getter
    private int arg1;
    @Getter
    private int arg2;
}
