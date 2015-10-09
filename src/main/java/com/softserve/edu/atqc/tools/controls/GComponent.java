package com.softserve.edu.atqc.tools.controls;

import com.softserve.edu.atqc.tools.search.ContextUtils;

abstract class GComponent<TComponent> extends AComponent<TComponent> implements IComponent {

	// implements constructor

    protected GComponent() {
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
