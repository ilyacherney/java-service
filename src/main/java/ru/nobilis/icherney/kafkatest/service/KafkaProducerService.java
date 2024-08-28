package ru.nobilis.icherney.kafkatest.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.nobilis.icherney.kafkatest.model.CalculationRequest;

@Service
public class KafkaProducerService {

    private KafkaTemplate<String, CalculationRequest> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, CalculationRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(CalculationRequest data, String topic) {
        System.out.println("KafkaProducer.sendMessage: " + data);
        Message<CalculationRequest> message = MessageBuilder
                .withPayload(data)
                        .setHeader(KafkaHeaders.TOPIC, topic)
                                .build();
        kafkaTemplate.send(message);
    }
}