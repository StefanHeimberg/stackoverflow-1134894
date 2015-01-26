package com.example.myproject.web.example;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;

@Model
@SessionScoped
public class ExampleSearchBean implements Serializable {
    
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
