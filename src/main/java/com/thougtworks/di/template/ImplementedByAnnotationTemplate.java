package com.thougtworks.di.template;

import com.thougtworks.di.annotation.ImplementedBy;

public class ImplementedByAnnotationTemplate implements BuildTemplate {
    private final Class<?> clazz;

    public ImplementedByAnnotationTemplate(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object getInstance(Object[] constructorParams) throws IllegalAccessException, InstantiationException {
        return this.clazz.getAnnotation(ImplementedBy.class).value().newInstance();
    }

}
