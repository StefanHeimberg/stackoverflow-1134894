package com.example.myproject.common;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ToStringBuilder {

    private final Object obj;
    private final Map<String, Object> attributes;

    public ToStringBuilder(Object obj) {
        this.obj = obj;
        this.attributes = new LinkedHashMap<>();
    }

    public ToStringBuilder add(String name, Object value) {
        attributes.put(name, value);
        return this;
    }

    public String build() {
        final StringBuilder sb = new StringBuilder();
        if (null != obj) {
            sb.append(obj.getClass().getSimpleName());
        }
        sb.append("{");
        final Iterator<Entry<String, Object>> it = attributes.entrySet().iterator();
        while (it.hasNext()) {
            final Entry<String, Object> entry = it.next();
            sb.append(MessageFormat.format("{0}={1}", entry.getKey(), entry.getValue()));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
    
}