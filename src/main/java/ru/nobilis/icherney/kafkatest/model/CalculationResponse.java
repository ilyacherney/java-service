package ru.nobilis.icherney.kafkatest.model;

import lombok.Getter;

public class CalculationResponse {
    @Getter
    private final int result;

    public CalculationResponse(int result) {
        this.result = result;
    }
}
