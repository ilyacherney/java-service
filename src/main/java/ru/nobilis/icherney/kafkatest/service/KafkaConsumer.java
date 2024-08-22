package ru.nobilis.icherney.kafkatest.service;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.nobilis.icherney.kafkatest.model.Message;
import ru.nobilis.icherney.kafkatest.model.Script;

import java.io.*;
import java.util.Properties;

@Service
public class KafkaConsumer {

    private ScriptService scriptService;

    @Autowired
    public KafkaConsumer(ScriptService scriptService) {this.scriptService = scriptService;}

    //todo eval w/ python
    @KafkaListener (topics = "testtopic", groupId = "test_group")
    public void listen(String msg) {
        System.out.println("Received: " + msg);
//        Script script = scriptService.getById(1);
//        System.out.println("body: " + script.getBody());
//        System.out.println(script.eval(msg));
    }
}
