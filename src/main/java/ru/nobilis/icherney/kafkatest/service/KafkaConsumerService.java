package ru.nobilis.icherney.kafkatest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.nobilis.icherney.kafkatest.model.CalculationRequest;
import ru.nobilis.icherney.kafkatest.model.Script;

@Service
public class KafkaConsumerService {

    private final ScriptService scriptService;

    @Autowired
    public KafkaConsumerService (CalculationService calculationService, ScriptService scriptService, KafkaTemplate<String, String> kafkaTemplate){
        this.scriptService = scriptService;
    }

    @KafkaListener (topics = "calculation-request", groupId = "group-1")
    public void listen(CalculationRequest calculationRequest) {
        Script script = scriptService.getById(calculationRequest.getId());
    }
}
