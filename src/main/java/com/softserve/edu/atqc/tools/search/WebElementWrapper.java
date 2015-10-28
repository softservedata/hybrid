package com.softserve.edu.atqc.tools.search;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.tools.exceptions.GeneralCustomException;

public final class WebElementWrapper {
    private final String INVALID_TAG = "Invalid Tag. Must be <a>";
    private final String TAG_A = "a";
    private final String ATTRIBUTE_HREF = "href";
    private final String ATTRIBUTE_NAME = "name";
    private static WebElement webElement;

    private WebElementWrapper(WebElement webElement) {
        this.webElement = webElement;
    }

    static WebElementWrapper get(WebElement webElement) {
        return new WebElementWrapper(webElement);
    }

    public static WebElementWrapper getVisibleWebElement(ByWrapper byWrapper) {
        return new WebElementWrapper(ContextUtils.get().getVisibleWebElement(byWrapper));
    }

    public static List<WebElementWrapper> getVisibleWebElements(ByWrapper byWrapper) {
        List<WebElementWrapper> webElementWrappers = new ArrayList<WebElementWrapper>();
        for (WebElement webElement : ContextUtils.get().getVisibleWebElements(byWrapper)) {
            webElementWrappers.add(new WebElementWrapper(webElement));
        }
        return webElementWrappers;
    }

    public static WebElementWrapper getPresentWebElement(ByWrapper byWrapper) {
        return new WebElementWrapper(ContextUtils.get().getPresentWebElement(byWrapper));
    }

    static WebElement getWebElement() {
        return webElement;
    }

    // For Implements Interface

    public String getAttribute(String attribute) {
        return getWebElement().getAttribute(attribute);
    }

    public String getAttributeName() {
        return getWebElement().getAttribute(ATTRIBUTE_NAME);
    }

    public String getContent() {
        // TODO Develop getContent with tags
        return getWebElement().getText();
    }

    public String getTagName() {
        return getWebElement().getTagName();
    }

    public String getText() {
        return getWebElement().getText();
    }

    public String getUrl() {
        // TODO Check Tag
        if (getTagName().toLowerCase().equals(TAG_A)) {
            return getWebElement().getAttribute(ATTRIBUTE_HREF);
        } else {
            throw new GeneralCustomException(INVALID_TAG);
        }
    }

    public void clear() {
        click();
        getWebElement().clear();
    }

    public void click() {
        getWebElement().click();
    }

    public boolean isDisplayed() {
        return getWebElement().isDisplayed();
    }

    public boolean isEnabled() {
        return getWebElement().isEnabled();
    }

    public boolean isSelected() {
        return getWebElement().isSelected();
    }

    public void sendKeys(String text) {
        getWebElement().sendKeys(text);
    }

    public void sendKeysClear(String text) {
    	
        clear();
        getWebElement().sendKeys(text);
    }
    public void sendKeysEnter(){
    	getWebElement().sendKeys(Keys.ENTER);
    	
    }

    public void setFocus() {
        // TODO Make Visible
        sendKeys(new String());
    }

    public void submit() {
        getWebElement().submit();
    }

}
