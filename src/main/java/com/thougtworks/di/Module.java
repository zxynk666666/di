package com.thougtworks.di;

public abstract class Module {


    private Binder binder;

    protected Module() {
        Binder binder = new Binder();
        this.binder = binder;
        this.configure(this.binder);

    }

    public abstract void configure(Binder binder);

    public Binder getBinder() {
        return binder;
    }
}
