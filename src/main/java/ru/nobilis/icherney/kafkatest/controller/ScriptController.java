package ru.nobilis.icherney.kafkatest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nobilis.icherney.kafkatest.model.Script;
import ru.nobilis.icherney.kafkatest.service.ScriptService;

@RestController
public class ScriptController {

    private ScriptService scriptService;

    @Autowired
    public ScriptController(ScriptService scriptService) {this.scriptService = scriptService;}

    @GetMapping("/scripts")
    public Script getScript(@RequestParam int id) {return scriptService.getById(id);}

    @PostMapping("/scripts")
    public void saveScript(@RequestBody Script script) {
        scriptService.save(script);
    } //requestparam->requestbody

    @PutMapping("/scripts")
    public void updateScript(@RequestParam int id, String body) {scriptService.update(id, body);}

    @DeleteMapping ("/scripts")
    public void deleteScript(@RequestParam int id) {scriptService.delete(id);};
}
