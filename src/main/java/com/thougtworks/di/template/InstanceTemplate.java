package com.thougtworks.di.template;

public class InstanceTemplate implements BuildTemplate {
    private final Object instances;

    public InstanceTemplate(Object instance) {
        this.instances = instance;
    }

    @Override
    public Object getInstance(Object[] constructorParams) {
        return this.instances;
    }
}
