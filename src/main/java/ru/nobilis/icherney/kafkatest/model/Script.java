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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Script(){};
    public Script(int id, String body){
        this.id = id;
        this.body = body;
    };
}
