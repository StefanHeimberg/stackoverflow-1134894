package com.example.myproject.web.support.i18n;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;

public class MessageFactory {
    
    public static FacesMessage getMessage(Severity severity, String key, Object... objects) {
        final String summaryKey = key;
        final String summary = MessageBundle.get(summaryKey, objects);

        final String detailKey = key + "_detail";
        final String detail = MessageBundle.get(detailKey, objects);
        
        return new FacesMessage(severity, summary, detail);
    }
    
    public static FacesMessage error(String key) {
        return error(key, null);
    }
    
    public static FacesMessage error(String key, String detail) {
        return getMessage(FacesMessage.SEVERITY_ERROR, key, detail);
    }
    
    public static FacesMessage fatal(String key) {
        return fatal(key, null);
    }
    
    public static FacesMessage fatal(String key, String detail) {
        return getMessage(FacesMessage.SEVERITY_FATAL, key, detail);
    }
    
    public static FacesMessage info(String key) {
        return info(key, null);
    }
    
    public static FacesMessage info(String key, String detail) {
        return getMessage(FacesMessage.SEVERITY_INFO, key, detail);
    }
    
    public static FacesMessage warn(String key) {
        return warn(key, null);
    }
    
    public static FacesMessage warn(String key, String detail) {
        return getMessage(FacesMessage.SEVERITY_WARN, key, detail);
    }

    private MessageFactory() {
    }
    
}
