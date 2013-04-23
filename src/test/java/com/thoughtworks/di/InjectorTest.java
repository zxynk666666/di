package com.thoughtworks.di;

import com.thoughtworks.di.example.*;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class InjectorTest {

    @Test
    public void shouldBindInterfaceToImplementation() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Injector inj=  Injector.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Hello.class).to(HelloImp.class);
            }
        });
        Hello hi = (Hello) inj.getInstance(Hello.class);
        assertEquals(hi.sayHi(), "Hi");
    }

    @Test
    public void shouldBindSubClassToSuperClass() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Injector inj=  Injector.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(SuperClass.class).to(SubClass.class);
            }
        });

        SuperClass superClass = (SuperClass) inj.getInstance(SuperClass.class);
        assertEquals(superClass.sayHello(), "Hello");
    }

    @Test
    public void shouldBindClassToANewInstance() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Injector inj = Injector.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Hello.class).toInstance(new HelloImp());
            }
        });

        Hello hi = (Hello) inj.getInstance(Hello.class);
        assertThat(hi.sayHi(), is("Hi"));
    }

    @Test
    public void shouldBindClassToProvider() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Injector inj = Injector.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Hello.class).toProvider(new Provider<Hello>() {
                    @Override
                    public Hello get() {
                        return new HelloImp();
                    }
                });
            }
        });

        Hello hi = (Hello) inj.getInstance(Hello.class);
        assertThat(hi.sayHi(), is("Hi"));
    }

    @Test
    public void shouldBindInterfaceToImplementationWithScope() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Injector inj=  Injector.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Hello.class).to(HelloImp.class).in(Scopes.SINGLETON);
            }
        });
        Hello hi1 = (Hello) inj.getInstance(Hello.class);
        Hello hi2 = (Hello) inj.getInstance(Hello.class);
        assertEquals(hi1.hashCode(), hi2.hashCode());
    }

    @Test
    public void shouldBindInterfaceToImplementationByAnnotation() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Injector inj=  Injector.createInjector();
        Service service = (Service) inj.getInstance(Service.class);
        assertEquals(service.execute(), "Hi");
    }

    @Test
    public void shouldSupportFieldInject() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        FieldInjectDemo demo = (FieldInjectDemo) Injector.createInjector().getInstance(FieldInjectDemo.class);

        assertEquals(demo.getServcie().execute(), "Hi");
    }

}
