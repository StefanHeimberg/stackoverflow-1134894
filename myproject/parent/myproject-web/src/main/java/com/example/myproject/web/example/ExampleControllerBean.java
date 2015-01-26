package com.example.myproject.web.example;

import com.example.myproject.business.example.ExampleNotFoundException;
import com.example.myproject.business.example.ExampleService;
import com.example.myproject.persistence.Example;
import com.example.myproject.web.support.Controller;
import com.example.myproject.web.support.Outcomes;
import com.example.myproject.web.support.i18n.MessageFactory;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Controller
public class ExampleControllerBean {

    private static final Logger LOG = Logger.getLogger(ExampleControllerBean.class.getName());

    private static final String MESSAGE_EXAMPLE_NOT_FOUND = "ExampleControllerBean.MESSAGE_EXAMPLE_NOT_FOUND";
    
    @Inject
    private ExampleService exampleService;
    
    @Inject
    private ExampleSearchBean exampleSearchBean;
    
    @Inject
    private ExampleDetailBean exampleDetailBean;
    
    public String search() {
        final Long id = exampleSearchBean.getId();
        try {
            final Example result = exampleService.findById(id);
            exampleDetailBean.setExample(result);
            return Outcomes.SUCCESS;
        } catch (ExampleNotFoundException ex) {
            final FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, MessageFactory.getMessage(FacesMessage.SEVERITY_ERROR, MESSAGE_EXAMPLE_NOT_FOUND, id));
            return Outcomes.SAME;
        }
    }
    
}
