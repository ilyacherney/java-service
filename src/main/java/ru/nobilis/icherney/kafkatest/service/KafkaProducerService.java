package ru.nobilis.icherney.kafkatest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.nobilis.icherney.kafkatest.model.CalculationResponse;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, CalculationResponse> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, CalculationResponse> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendResponse(CalculationResponse calculationResponse) {
        kafkaTemplate.send("calculation-responses", calculationResponse);
    }
}