package com.softserve.edu.atqc.tools.controls;

public class TextField<TComponent> extends LabelClickable<TComponent> implements ITextField {

    // implements constructor
    protected TextField() {
    }

    // implements static factory

    public static AComponent<ITextField> getTextField() {
        TextField<ITextField> instance = new TextField<ITextField>();
        instance.setTComponent(instance);
        return instance;
    }

    // implements interface

    public void clear() {
        getWebElementWrapper().clear();
    }

    public void sendKeys(String text) {
        getWebElementWrapper().sendKeys(text);
    }

}
