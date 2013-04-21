package com.thougtworks.di;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Binder {
    private Scopes scope = Scopes.NO_SCOPE;
    private HashMap<Class<?> , Object> buildTemplate = new HashMap();
    private Class<?> srcClass;
    private HashMap singletonInstances = new HashMap();

    public Binder bind(Class<?> clazz) {
        srcClass = clazz;
        return this;
    }

    public Binder in(Scopes scope) {
        this.scope = scope;
        return this;
    }

    public Binder to(Class<?> clazz) {
        buildTemplate.put(srcClass, new InterfaceTemplate(clazz));
        return this;
    }

    public Binder toProvider(Provider<?> provider) {
        buildTemplate.put(srcClass, new InstanceTemplate(provider.get()));
        return this;
    }

    public Binder toInstance(Object instance) {
        buildTemplate.put(srcClass, new InstanceTemplate(instance));
        return this;
    }

    private void fieldInject(Class<?> clazz, Object result) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        for(Field f : clazz.getDeclaredFields()) {
            Inject inj = f.getAnnotation(Inject.class);
            if(inj != null) {
                f.setAccessible(true);
                f.set(result, getInstance(f.getType()));
            }
        }
    }

    public Object getInstance(Class<?> clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        BuildTemplate template = getBuildTemplate(clazz);

        if (scope == Scopes.NO_SCOPE || singletonInstances.get(clazz) == null) {
            singletonInstances.put(clazz, template.getInstance());
        }

        fieldInject(clazz, singletonInstances.get(clazz));

        return singletonInstances.get(clazz);
    }

    private BuildTemplate getBuildTemplate(Class<?> clazz) {
        if (clazz.getAnnotation(ImplementedBy.class) != null) {
            return new ImplementedByAnnotationTemplate(clazz);
        } else if (buildTemplate.get(clazz) != null) {
            return (BuildTemplate) buildTemplate.get(clazz);
        } else {
            return new DefaultTemplate(clazz);
        }
    }
}
