package com.softserve.edu.atqc.tools.controls;

public class LabelClickable<TComponent> extends Label<TComponent> implements ILabelClickable {

    // implements constructor
    protected LabelClickable() {
    }

    // implements static factory

    public static AComponent<ILabelClickable> getLabelClickable() {
        LabelClickable<ILabelClickable> instance = new LabelClickable<ILabelClickable>();
        instance.setTComponent(instance);
        return instance;
    }

    // implements interface

    public void click(){
        getWebElementWrapper().click();
    }
    
}
