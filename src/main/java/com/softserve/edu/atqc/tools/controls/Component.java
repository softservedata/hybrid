package com.softserve.edu.atqc.tools.controls;

public final class Component extends GComponent<IComponent> {

    // implements constructor
    private Component(){
    } 

    // implements static factory

    public static AComponent<IComponent> get() {
        Component instance = new Component();
        instance.setTComponent(instance);
        return instance;
    }

}
