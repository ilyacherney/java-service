package ru.nobilis.icherney.kafkatest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Service;
import ru.nobilis.icherney.kafkatest.model.CalculationRequest;

import java.util.Arrays;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private ObjectMapper objectMapper;


    public void sendCalculationRequest(CalculationRequest calculationRequest) throws JsonProcessingException {
        String jsonString = objectMapper.writeValueAsString(calculationRequest);
        kafkaTemplate.send("calculation-request", jsonString);
    }

    public void sendCalculationResponse(CalculationRequest calculationRequest) {
//        kafkaTemplate.send("calculation-request", gson.toJson(calculationRequest));
    }
}