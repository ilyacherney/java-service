package ru.nobilis.icherney.kafkatest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nobilis.icherney.kafkatest.model.Message;
import ru.nobilis.icherney.kafkatest.service.KafkaProducer;

@RestController
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/send")
    public Message sendMessage(@RequestParam("message") String message) {
        return new Message(message);
    }
}