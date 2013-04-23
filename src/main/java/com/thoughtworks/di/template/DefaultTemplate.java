package com.thoughtworks.di.template;

import java.lang.reflect.InvocationTargetException;
import java.security.Provider;

public class DefaultTemplate implements BuildTemplate {
    private final Class<?> clazz;

    public DefaultTemplate(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object getInstance(Object[] constructorParams) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {


        return clazz.newInstance();
    }

}
