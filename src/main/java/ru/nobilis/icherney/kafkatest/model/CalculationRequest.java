package ru.nobilis.icherney.kafkatest.model;

import lombok.Getter;

public class CalculationRequest {
    @Getter
    private String name;
    @Getter
    private int arg1;
    @Getter
    private int arg2;

    @Override
    public String toString() {
        return "CalculationRequest{" +
                "name='" + name + '\'' +
                ", arg1=" + arg1 +
                ", arg2=" + arg2 +
                '}';
    }
}
