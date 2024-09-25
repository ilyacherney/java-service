package ru.nobilis.icherney.kafkatest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nobilis.icherney.kafkatest.model.CalculationRequest;
import ru.nobilis.icherney.kafkatest.model.Script;
import ru.nobilis.icherney.kafkatest.service.KafkaProducerService;
import ru.nobilis.icherney.kafkatest.service.ScriptService;

import java.util.List;

@RestController
@RequestMapping("/api/script")
public class ScriptController {

    private final ScriptService scriptService;

    @Autowired
    public ScriptController(ScriptService scriptService) { this.scriptService = scriptService; }

    @GetMapping("/{id}")
    public Script getScript(@PathVariable int id) { return scriptService.getById(id); }

    @GetMapping()
    public List<Script> getScripts() { return scriptService.get(); }

    @PostMapping()
    public void saveScript(@RequestBody Script script) { scriptService.save(script); }

    @PutMapping()
    public void updateScript(@RequestParam int id, String body) { scriptService.update(id, body); }

    @DeleteMapping ()
    public void deleteScript(@RequestParam int id) { scriptService.delete(id); }


}
