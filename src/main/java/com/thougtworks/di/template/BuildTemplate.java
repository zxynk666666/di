package com.thougtworks.di.template;

import java.lang.reflect.InvocationTargetException;

public interface BuildTemplate {
    Object getInstance(Object[] constructorParams) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;
}
