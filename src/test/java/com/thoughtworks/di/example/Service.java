package com.thoughtworks.di.example;

import com.thoughtworks.di.annotation.ImplementedBy;

@ImplementedBy(ServiceImpl.class)
public interface Service {
    String execute();
}
