package com.softserve.edu.atqc.tools.controls;

public final class Link extends GLink<ILink> {

    // implements constructor
    private Link() {
    }

    // implements static factory

    public static AComponent<ILink> get() {
        Link instance = new Link();
        instance.setTComponent(instance);
        return instance;
    }

}
