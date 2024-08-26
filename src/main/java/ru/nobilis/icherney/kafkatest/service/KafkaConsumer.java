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
    private KafkaTemplate<String, String> kafkaTemplate;

    //todo KafkaConsumerConfig?
    @KafkaListener (topics = "calculation-request", groupId = "group-1")
    public void listen(CalculationRequest calculationRequest) {
        System.out.println("KafkaConsumer.listen: " + calculationRequest);
    }
}
