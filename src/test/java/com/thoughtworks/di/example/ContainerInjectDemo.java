package com.thoughtworks.di.example;

public class ContainerInjectDemo {
    private Service service;

    public ContainerInjectDemo(Service service) {
        this.service = service;
    }
    public Service getService() {
        return service;
    }

}
