package com.thoughtworks.di;

import com.thougtworks.di.ImplementedBy;

@ImplementedBy(ServiceImpl.class)
public interface Service {
    String execute();
}
