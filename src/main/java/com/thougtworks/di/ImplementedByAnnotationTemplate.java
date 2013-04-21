package com.thougtworks.di;

public class ImplementedByAnnotationTemplate implements BuildTemplate {
    private final Class<?> clazz;

    public ImplementedByAnnotationTemplate(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object getInstance() throws IllegalAccessException, InstantiationException {
        return this.clazz.getAnnotation(ImplementedBy.class).value().newInstance();
    }
}
