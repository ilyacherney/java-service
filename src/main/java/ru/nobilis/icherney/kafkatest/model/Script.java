package ru.nobilis.icherney.kafkatest.model;

import jakarta.persistence.*;
import org.python.core.PyInteger;
import org.python.util.PythonInterpreter;

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

    public int run(int arg1, int arg2) {
        PythonInterpreter pythonInterpreter = new PythonInterpreter();
        pythonInterpreter.set("arg1", new PyInteger(arg1));
        pythonInterpreter.set("arg2", new PyInteger(arg2));
        pythonInterpreter.exec("result = arg1 + arg2");
        PyInteger result = (PyInteger)pythonInterpreter.get("result");
        return result.asInt();
    }

    public Script(){};
    public Script(int id, String name, String body){
        this.id = id;
        this.name = name;
        this.body = body;
    };
}
