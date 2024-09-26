package ru.nobilis.icherney.kafkatest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nobilis.icherney.kafkatest.model.CalculationRequest;
import ru.nobilis.icherney.kafkatest.model.CalculationResponse;

@Service
public class CalculationHandlerService {

    CalculationService calculationService;
    CalculationResponse calculationResponse;
    KafkaProducerService kafkaProducerService;

    @Autowired
    public CalculationHandlerService (CalculationService calculationService, CalculationResponse calculationResponse, KafkaProducerService kafkaProducerService) {
        this.calculationService = calculationService;
        this.calculationResponse = calculationResponse;
    }

    public void handeCalculationRequest(CalculationRequest calculationRequest) {
        int calculationResult = calculationService.calculate(calculationRequest);
        calculationResponse.setResult(calculationResult);
        kafkaProducerService.sendResponse(calculationResponse);
    }
}
