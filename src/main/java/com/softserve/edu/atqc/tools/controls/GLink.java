package com.softserve.edu.atqc.tools.controls;

abstract class GLink<TComponent> extends GLabelClickable<TComponent> implements ILink {

    // implements constructor
    protected GLink() {
    }

    // implements interface

    public String getUrl() {
        return getWebElementWrapper().getUrl();
    }

}
