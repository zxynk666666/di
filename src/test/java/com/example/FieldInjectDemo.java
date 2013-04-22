package com.example;

import com.example.*;
import com.thougtworks.di.annotation.Inject;

public class FieldInjectDemo {

    @Inject
    private Service servcie;
    public Service getServcie() {
        return servcie;
    }
}