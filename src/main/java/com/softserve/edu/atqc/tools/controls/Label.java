package com.softserve.edu.atqc.tools.controls;

public final class Label extends GLabel<ILabel> {

    // implements constructor
    private Label() {
    }

    // implements static factory

    public static AComponent<ILabel> get() {
        Label instance = new Label();
        instance.setTComponent(instance);
        return instance;
    }

}