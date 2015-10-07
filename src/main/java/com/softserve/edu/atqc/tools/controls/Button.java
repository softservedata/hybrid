package com.softserve.edu.atqc.tools.controls;

public class Button<TComponent> extends LabelClickable<TComponent> implements IButton {

    // implements constructor
    protected Button() {
    }

    // implements static factory

    public static AComponent<IButton> getButton() {
        Button<IButton> instance = new Button<IButton>();
        instance.setTComponent(instance);
        return instance;
    }

    // implements interface

    public void setFocus(){
        getWebElementWrapper().setFocus();
    }

    public void submit(){
        getWebElementWrapper().submit();
    }

}
