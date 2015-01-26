package com.example.myproject.web.support.i18n;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class I18nBean implements Serializable {
    
    private Locale locale;
    private final Set<Locale> availableLocales = new HashSet<>();
    
    @PostConstruct
    public void init() {
        final FacesContext context = FacesContext.getCurrentInstance();
        final Application application = context.getApplication();
        
        final Locale defaultLocale = application.getViewHandler().calculateLocale(context);
        locale = defaultLocale;
        
        availableLocales.clear();
        availableLocales.add(defaultLocale);
        
        final Iterator<Locale> it = application.getSupportedLocales();
        while(it.hasNext()) {
            availableLocales.add(it.next());
        }
    }

    public Locale getLocale() {
        return locale;
    }
    
    public String getLanguage() {
        return locale.getLanguage();
    }

    public void setLocale(Locale locale) {
        final FacesContext context = FacesContext.getCurrentInstance();
        final Application application = context.getApplication();
        
        final Locale newLocale;
        if(!availableLocales.contains(locale)) {
            newLocale = application.getDefaultLocale();
        } else {
            newLocale = locale;
        }
        
        context.getViewRoot().setLocale(newLocale);
        this.locale = newLocale;
    }
    
    public List<Locale> getAvailableLocales() {
        // ui:repeate / ui:dataTable etc... unterstützen kein Set. daher wird hier
        // wieder in eine List transformiert.
        return new ArrayList<>(availableLocales);
    }
    
}