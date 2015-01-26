package com.example.myproject.business.example;

import com.example.myproject.persistence.Example;
import javax.ejb.Remote;
import javax.validation.constraints.NotNull;

@Remote
public interface ExampleServiceRemote {
    
    public static final String JNDI_NAME = "java:global/example-application/example-business/ExampleService!com.example.myproject.business.ExampleServiceRemote";
    
    Example findById(@NotNull Long id) throws ExampleNotFoundException;
    
}
