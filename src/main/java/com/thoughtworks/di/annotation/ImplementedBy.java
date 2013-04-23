package com.thoughtworks.di.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ImplementedBy {
    Class<?> value();
}
