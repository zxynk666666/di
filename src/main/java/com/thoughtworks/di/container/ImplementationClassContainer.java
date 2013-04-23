package com.thoughtworks.di.container;

public class ImplementationClassContainer {
    private Class<?> srcClass;
    private Class<?> impClass;

    public void setSrcClass(Class<?> srcClass) {
        this.srcClass = srcClass;
    }

    public Class<?> getSrcClass() {
        return srcClass;
    }

    public void setImpClass(Class<?> impClass) {
        this.impClass = impClass;
    }

    public Class<?> getImpClass() {
        return impClass;
    }
}
