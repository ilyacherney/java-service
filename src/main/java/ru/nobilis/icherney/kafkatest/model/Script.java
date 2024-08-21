package ru.nobilis.icherney.kafkatest.model;

import jakarta.persistence.*;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String eval(String s) {
        return s + " evaluated.";
    }

    public Script(){};
    public Script(int id, String name, String body){
        this.id = id;
        this.name = name;
        this.body = body;
    };
}
