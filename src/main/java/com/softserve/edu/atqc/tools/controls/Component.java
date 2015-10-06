package com.softserve.edu.atqc.tools.controls;

import com.softserve.edu.atqc.tools.search.ByWrapper;
import com.softserve.edu.atqc.tools.search.ContextUtils;
import com.softserve.edu.atqc.tools.search.WebElementWrapper;

public class Component implements IComponent {
	private WebElementWrapper webElementWrapper;
	private ByWrapper byWrapper;

	// implements constructor

	Component(WebElementWrapper webElementWrapper, ByWrapper byWrapper) {
		this.webElementWrapper = webElementWrapper;
		this.byWrapper = byWrapper;
	}

	// implements static factory

	static IComponent getByControl(WebElementWrapper webElementWrapper,
	        ByWrapper byWrapper) {
        return new Component(webElementWrapper, byWrapper);
    }

	public static IComponent getById(String id) {
		return get(ByWrapper.getById(id));
	}

	public static IComponent getByName(String name) {
		return get(ByWrapper.getByName(name));
	}

	public static IComponent getByXpath(String xpath) {
		return get(ByWrapper.getByXPath(xpath));
	}

	public static IComponent getByCssSelector(String cssSelector) {
		return get(ByWrapper.getByCssSelector(cssSelector));
	}

	public static IComponent getByTagName(String tagName) {
		return get(ByWrapper.getByTagName(tagName));
	}

	static IComponent get(ByWrapper byWrapper) {
		// TODO Change strategy Visible/Present
		return getByControl(WebElementWrapper.getVisibleWebElement(byWrapper),
		        byWrapper);
	}

	// implements getters

	WebElementWrapper getWebElementWrapper() {
		return webElementWrapper;
	}

	ByWrapper getByWrapper() {
		return byWrapper;
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

	// public boolean isInvisible();

	public boolean isSelected() {
		return getWebElementWrapper().isSelected();
	}

	public boolean isStatelessOf() {
		return ContextUtils.get().isStatelessOfWebElement(getWebElementWrapper());
	}

}
