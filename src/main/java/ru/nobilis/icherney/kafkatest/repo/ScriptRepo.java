package ru.nobilis.icherney.kafkatest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nobilis.icherney.kafkatest.model.Script;

public interface ScriptRepo extends JpaRepository <Script, Integer> {
}
