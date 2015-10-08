package com.softserve.edu.atqc.tools.controls;

public final class Button extends GButton<IButton> {

    // implements constructor
    private Button() {
    }

    // implements static factory

    public static AComponent<IButton> get() {
        Button instance = new Button();
        instance.setTComponent(instance);
        return instance;
    }

}
