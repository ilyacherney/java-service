package ru.nobilis.icherney.kafkatest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.nobilis.icherney.kafkatest.model.CalculationRequest;
import ru.nobilis.icherney.kafkatest.model.Script;

@Service
public class KafkaConsumer {

    @Autowired
    ScriptService scriptService;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener (topics = "calculation-request", groupId = "group-1")
    public void listen(CalculationRequest calculationRequest) {
        System.out.println("KafkaConsumer.listen: " + calculationRequest);
        System.out.println("calculationRequest.getArg1: " + calculationRequest.getArg1());

        Script script = scriptService.getById(1); //todo: getByName
        int result = script.run(calculationRequest.getArg1(), calculationRequest.getArg2());
        System.out.println("Result: " + result);
    }
}
