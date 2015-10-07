package com.softserve.edu.atqc.tools.controls;

public class Label<TComponent> extends Component<TComponent> implements ILabel {

    // implements constructor
    protected Label() {
    }

    // implements static factory

    public static AComponent<ILabel> getLabel() {
        Label<ILabel> instance = new Label<ILabel>();
        instance.setTComponent(instance);
        return instance;
    }

    // implements interface

    public String getText() {
        return getWebElementWrapper().getText();
    }

}
