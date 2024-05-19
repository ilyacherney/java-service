package ru.nobilis.icherney.kafkatest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nobilis.icherney.kafkatest.model.Script;
import ru.nobilis.icherney.kafkatest.repo.ScriptRepo;
import java.util.List;
import java.util.Optional;

@Service
public class ScriptService  {

    private final ScriptRepo scriptRepo;

    @Autowired
    public ScriptService(ScriptRepo scriptRepo) {
        this.scriptRepo = scriptRepo;
    }

    public List<Script> get() {
        return scriptRepo.findAll();
    }

    public void post(Script script) {
        scriptRepo.save(script);
    }

    public void update(int id, String body) {
        Optional<Script> script = scriptRepo.findById(id);
        if (script.isPresent()) {
            script.get().setBody(body);
        }
    }

    public void delete(int id) {
        Optional<Script> script = scriptRepo.findById(id);
        scriptRepo.delete(script.get());
    }
}
