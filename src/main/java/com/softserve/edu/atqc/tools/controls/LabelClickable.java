package com.softserve.edu.atqc.tools.controls;

public final class LabelClickable extends GLabelClickable<ILabelClickable> {

    // implements constructor
    private LabelClickable() {
    }

    // implements static factory

    public static AComponent<ILabelClickable> get() {
        LabelClickable instance = new LabelClickable();
        instance.setTComponent(instance);
        return instance;
    }

}
