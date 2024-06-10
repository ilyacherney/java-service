package ru.nobilis.icherney.kafkatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nobilis.icherney.kafkatest.model.Script;

public interface ScriptRepository extends JpaRepository <Script, Integer> {
}
