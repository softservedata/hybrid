package com.softserve.edu.atqc.tools.controls;

public class Link<TComponent> extends LabelClickable<TComponent> implements ILink {

    // implements constructor
    protected Link() {
    }

    // implements static factory

    public static AComponent<ILink> getLink() {
        Link<ILink> instance = new Link<ILink>();
        instance.setTComponent(instance);
        return instance;
    }

    // implements interface

    public String getUrl() {
        return getWebElementWrapper().getUrl();
    }

}
