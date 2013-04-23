package com.thoughtworks.di.template;

public class InterfaceTemplate implements BuildTemplate {
    private final Class<?> impClass;
    private Object singletonInstance;

    public InterfaceTemplate(Class<?> clazz) {
        this.impClass = clazz;
    }

    @Override
    public Object getInstance(Object[] constructorParams) throws IllegalAccessException, InstantiationException {

        return this.impClass.newInstance();
    }
}
