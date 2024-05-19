package ru.nobilis.icherney.kafkatest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nobilis.icherney.kafkatest.model.Script;
import ru.nobilis.icherney.kafkatest.service.ScriptService;

import java.util.List;

@RestController
public class ScriptController {

    private ScriptService scriptService;

    @Autowired
    public ScriptController(ScriptService scriptService) {this.scriptService = scriptService;}

    @GetMapping("/scripts")
    public List<Script> getScripts() {return scriptService.get();}

    @PostMapping("/scripts")
    public void postScript(@RequestParam int id, String body) {scriptService.post(new Script(id, body));}

    @PutMapping("/scripts")
    public void updateScript(@RequestParam int id, String body) {scriptService.update(id, body);}

    @DeleteMapping ("/scripts")
    public void deleteScript(@RequestParam int id) {scriptService.delete(id);};
}
