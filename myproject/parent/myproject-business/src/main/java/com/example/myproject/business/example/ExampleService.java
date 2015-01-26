package com.example.myproject.business.example;

import com.example.myproject.persistence.Example;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;

@Stateless
@LocalBean
public class ExampleService implements ExampleServiceRemote {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public Example findById(@NotNull final Long id) throws ExampleNotFoundException {
        final Example example = em.find(Example.class, id);
        if(null == example) {
            throw new ExampleNotFoundException("Example not found for id " + id);
        }
        return example;
    }
    
}
