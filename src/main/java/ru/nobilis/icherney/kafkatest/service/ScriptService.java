package ru.nobilis.icherney.kafkatest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nobilis.icherney.kafkatest.model.Script;
import ru.nobilis.icherney.kafkatest.repository.ScriptRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ScriptService  {

    private final ScriptRepository scriptRepository;

    @Autowired
    public ScriptService(ScriptRepository scriptRepository) {
        this.scriptRepository = scriptRepository;
    }

    public List<Script> get() {
        return scriptRepository.findAll();
    }

    public Script getById(int id) {
        Optional<Script> script = scriptRepository.findById(id);
        return script.orElse(null);
    }

    public void save(Script script) {
        scriptRepository.save(script);
    }

    public void update(int id, String body) {
        Optional<Script> script = scriptRepository.findById(id);
        script.ifPresent(value -> value.setBody(body));
    }

    public void delete(int id) {
        Optional<Script> script = scriptRepository.findById(id);
        scriptRepository.deleteById(id);
    }
}
