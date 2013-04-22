package com.thougtworks.di;

import com.thougtworks.di.annotation.Inject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    private final Binder binder;

    public Injector(Module module) {
        binder = module.getBinder();
    }

    public static Injector createInjector() {
        return new Injector(new Module() {
            @Override
            public void configure(Binder binder) {
            }
        });
    }

    public static Injector createInjector(Module module) {
        return new Injector(module);
    }

    public Object getInstance(Class<?> clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        return binder.getInstance(clazz);
    }

    private boolean hasConstructorAnnotation(Class<?> clazz) throws NoSuchMethodException {
        Constructor<?> constructor = clazz.getConstructor();
        return constructor.isAnnotationPresent(Inject.class);
    }
}
