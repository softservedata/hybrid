package com.softserve.edu.atqc.tools.controls;

abstract class GTextField<TComponent> extends GLabelClickable<TComponent>implements ITextField {

    // implements constructor
    protected GTextField() {
    }

    // implements interface

    public void clear() {
        getWebElementWrapper().clear();
    }

    public void sendKeys(String text) {
        getWebElementWrapper().sendKeys(text);
    }

    public void sendKeysClear(String text) {
        getWebElementWrapper().sendKeysClear(text);
    }

}
