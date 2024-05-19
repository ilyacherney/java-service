package ru.nobilis.icherney.kafkatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import ru.nobilis.icherney.kafkatest.model.Script;
import ru.nobilis.icherney.kafkatest.repo.ScriptRepo;

@SpringBootApplication
public class KafkaTestApplication {
    public final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaTestApplication(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaTestApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner() {
//        return args -> {
//            kafkaTemplate.send("testtopic", "123123123");
//        };
//    }

//    @Bean
//    CommandLineRunner commandLineRunner (ScriptRepo scriptRepo) {
//        return args -> {
//            Script script = new Script(2,"wrld");
//            scriptRepo.save(script);
//        };
//    }

}
