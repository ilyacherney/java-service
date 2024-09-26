package ru.nobilis.icherney.kafkatest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "Script")
@Table(name =  "scripts")
public class Script {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "body")
    private String body;
    @Column(name = "name")
    private String name;

    public Script(){};
    public Script(int id, String name, String body){
        this.id = id;
        this.name = name;
        this.body = body;
    };
}
