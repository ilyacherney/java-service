package ru.nobilis.icherney.kafkatest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.nobilis.icherney.kafkatest.model.Script;

@Service
public class KafkaConsumer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    ScriptService scriptService;
//    @Autowired
//    JsonDeserializer jsonDeserializer;

    //todo KafkaConsumerConfig?
    @KafkaListener (topics = "calculation-request", groupId = "group-1")
    public void listen(String calculationRequest) {
        System.out.println("KafkaListener: " + calculationRequest);
        Script script = scriptService.getById(1); //todo remove hardcode


//        CalculationRequest deserializerdCalculationRequest = jsonDeserializer.
//        System.out.println("deserialized: " + deserializerdCalculationRequest.getArg1() + " " + deserializerdCalculationRequest.getArg2());
//        int result = script.run(deserializerdCalculationRequest.getArg1(), deserializerdCalculationRequest.getArg2());
//        CalculationResponse calculationResponse = new CalculationResponse(result);
//        System.out.println(calculationResponse);
    }
}
