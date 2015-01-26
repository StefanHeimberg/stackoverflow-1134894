package com.example.myproject.web.support.cdi;

import java.util.Iterator;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;

public class CdiUtil {

    @SuppressWarnings("unchecked")
    public static <T> T lookup(final Class<T> clazz) {
        final BeanManager bm = CDI.current().getBeanManager();
        final Iterator<Bean<?>> iter = bm.getBeans(clazz).iterator();
        if (!iter.hasNext()) {
            throw new IllegalStateException("CDI BeanManager cannot find an instance of requested type " + clazz.getName());
        }
        final Bean<T> bean = (Bean<T>) iter.next();
        final CreationalContext<T> ctx = bm.createCreationalContext(bean);
        return (T) bm.getReference(bean, clazz, ctx);
    }

    private CdiUtil() {
    }

}
