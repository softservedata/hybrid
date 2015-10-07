package com.softserve.edu.atqc.tools.controls;

import com.softserve.edu.atqc.tools.search.ContextUtils;

public class Component<TComponent> extends AComponent<TComponent> implements IComponent {

	// implements constructor
	protected Component() {
	}

	// implements static factory

    public static AComponent<IComponent> get() {
        Component<IComponent> instance = new Component<IComponent>();
        instance.setTComponent(instance);
        return instance;
    }
        
	// implements interface

	public String getAttribute(String attribute) {
		return getWebElementWrapper().getAttribute(attribute);
	}

	public String getAttributeName() {
		return getWebElementWrapper().getAttributeName();
	}

	public String getContent() {
		return getWebElementWrapper().getContent();
	}

	public String getTagName() {
		return getWebElementWrapper().getTagName();
	}

	public boolean isDisplayed() {
		return getWebElementWrapper().isDisplayed();
	}

	public boolean isEnabled() {
		return getWebElementWrapper().isEnabled();
	}

	// TODO public boolean isInvisible();

	public boolean isSelected() {
		return getWebElementWrapper().isSelected();
	}

	public boolean isStatelessOf() {
		return ContextUtils.get().isStatelessOfWebElement(getWebElementWrapper());
	}

}
