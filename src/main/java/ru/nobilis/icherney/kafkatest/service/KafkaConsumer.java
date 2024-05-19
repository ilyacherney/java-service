package ru.nobilis.icherney.kafkatest.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener (topics = "testtopic2", groupId = "test_group")
    public void listen(String msg) {
        System.out.println("Received: " + msg);
    }
}
