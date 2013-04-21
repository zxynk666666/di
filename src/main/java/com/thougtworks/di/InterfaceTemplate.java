package com.thougtworks.di;

public class InterfaceTemplate implements BuildTemplate {
    private final Class<?> impClass;
    private Object singletonInstance;

    public InterfaceTemplate(Class<?> clazz) {
        this.impClass = clazz;
    }

    @Override
    public Object getInstance() throws IllegalAccessException, InstantiationException {

        return this.impClass.newInstance();
    }
}
