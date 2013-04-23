package com.thoughtworks.di.example;

import com.thoughtworks.di.annotation.Inject;

public class FieldInjectDemo {

    @Inject
    private Service servcie;
    public Service getServcie() {
        return servcie;
    }
}