package ru.nobilis.icherney.kafkatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class CalcServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalcServiceApplication.class, args);
    }
}
