package com.example.myproject.web.support.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessageBundle {
    
    private static final String KEY_NOT_FOUND_PATTERN = "???{0}???";
    
    public static String get(String key, Object... objects) {
        final FacesContext context = FacesContext.getCurrentInstance();
        String bundleName = context.getApplication().getMessageBundle();
        if(null == bundleName) {
            bundleName = FacesMessage.FACES_MESSAGES;
        }
        final Locale locale = context.getViewRoot().getLocale();
        final ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale);
        try {
            if(null == objects) {
                return bundle.getString(key);
            } else {
                return MessageFormat.format(bundle.getString(key), objects);
            }
        } catch(MissingResourceException ex) {
            return MessageFormat.format(KEY_NOT_FOUND_PATTERN, key);
        }
    }

    private MessageBundle() {
    }
    
}
