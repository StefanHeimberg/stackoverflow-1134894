package com.example.myproject.web.example;

import com.example.myproject.persistence.Example;
import javax.enterprise.inject.Model;
import javax.validation.constraints.NotNull;

@Model
public class ExampleDetailBean {
    
    private Example example;
    
    public Example getExample() {
        return example;
    }

    void setExample(@NotNull final Example example) {
        this.example = example;
    }
    
}
