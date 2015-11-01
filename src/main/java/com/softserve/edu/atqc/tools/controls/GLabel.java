package com.softserve.edu.atqc.tools.controls;

abstract class GLabel<TComponent> extends GComponent<TComponent> implements ILabel {

    // implements constructor
    protected GLabel() {
    }

    // implements interface

    public String getText() {
        return getWebElementWrapper().getText();
    }

}
