package com.example;

import com.thougtworks.di.annotation.ImplementedBy;

@ImplementedBy(ServiceImpl.class)
public interface Service {
    String execute();
}
