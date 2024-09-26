package ru.nobilis.icherney.kafkatest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.nobilis.icherney.kafkatest.model.CalculationRequest;

@Service
public class KafkaConsumerService {

    CalculationHandlerService calculationHandlerService;

    @Autowired
    public KafkaConsumerService (CalculationHandlerService calculationHandlerService){
        this.calculationHandlerService = calculationHandlerService;
    }

    @KafkaListener(topics = "calculation-requests", groupId = "calculation-service")
    public void consume(CalculationRequest calculationRequest) {
        calculationHandlerService.handeCalculationRequest(calculationRequest);
    }
}
