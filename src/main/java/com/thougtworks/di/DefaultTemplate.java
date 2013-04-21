package com.thougtworks.di;

public class DefaultTemplate implements BuildTemplate {
    private final Class<?> clazz;

    public DefaultTemplate(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object getInstance() throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }
}
