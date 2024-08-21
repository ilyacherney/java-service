package ru.nobilis.icherney.kafkatest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nobilis.icherney.kafkatest.model.Message;
import ru.nobilis.icherney.kafkatest.service.KafkaProducer;

@RestController
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        kafkaProducer.sendMessage(message.toString());
        return ResponseEntity.ok(message);
    }
}