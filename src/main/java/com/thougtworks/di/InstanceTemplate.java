package com.thougtworks.di;

public class InstanceTemplate implements BuildTemplate {
    private final Object instances;

    public InstanceTemplate(Object instance) {
        this.instances = instance;
    }

    @Override
    public Object getInstance() {
        return this.instances;
    }
}
