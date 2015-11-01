package com.softserve.edu.atqc.tools.controls;

abstract class GButton<TComponent> extends GLabelClickable<TComponent> implements IButton {

    // implements constructor
    protected GButton() {
    }

    // implements interface

    public void setFocus(){
        getWebElementWrapper().setFocus();
    }

    public void submit(){
        getWebElementWrapper().submit();
    }

}
