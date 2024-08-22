package ru.nobilis.icherney.kafkatest.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nobilis.icherney.kafkatest.model.Message;
import ru.nobilis.icherney.kafkatest.service.KafkaProducer;

@RestController
public class KafkaController {

    Gson gson = new Gson();
    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {

        kafkaProducer.sendMessage(gson.toJson(message));  //уже объект отправляется
        return ResponseEntity.ok(message);
    }
}