package com.thoughtworks.di;

import com.thougtworks.di.Inject;

public class FieldInjectDemo {

    @Inject
    private Service servcie;
    public Service getServcie() {
        return servcie;
    }
}