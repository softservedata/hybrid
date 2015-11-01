package com.softserve.edu.atqc.tools.controls;

import com.softserve.edu.atqc.tools.search.ByWrapper;
import com.softserve.edu.atqc.tools.search.WebElementWrapper;

public abstract class AComponent<TComponent> {
    private ByWrapper byWrapper;
    private WebElementWrapper webElementWrapper;
    private TComponent tComponent;

    protected AComponent() {
    }

    public TComponent getById(String id) {
        return get(ByWrapper.getById(id));
    }

    public TComponent getByName(String name) {
        return get(ByWrapper.getByName(name));
    }

    public TComponent getByXpath(String xpath) {
        return get(ByWrapper.getByXPath(xpath));
    }

    public TComponent getByPartialLinkText(String partialLinkText) {
        return get(ByWrapper.getByPartialLinkText(partialLinkText));
    }

    public TComponent getByCssSelector(String cssSelector) {
        return get(ByWrapper.getByCssSelector(cssSelector));
    }

    public TComponent getByTagName(String tagName) {
        return get(ByWrapper.getByTagName(tagName));
    }

    public TComponent getByClassName(String className) {
        return get(ByWrapper.getByClassName(className));
    }
    
    private TComponent get(ByWrapper byWrapper) {
        this.byWrapper = byWrapper;
        this.webElementWrapper = WebElementWrapper.getVisibleWebElement(byWrapper);
        return tComponent;
    }

    // TODO Change strategy Implicit/Explicit and Visible/Present

    // implements getters and setters

    WebElementWrapper getWebElementWrapper() {
        return webElementWrapper;
    }

    ByWrapper getByWrapper() {
        return byWrapper;
    }

    protected void setTComponent(TComponent tComponent) {
        this.tComponent = tComponent;
    }
    
}
