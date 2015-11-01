package com.softserve.edu.atqc.tools.search;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface IContext {
    
    WebElement getVisibleWebElement(ByWrapper byWrapper);
    
    List<WebElement> getVisibleWebElements(ByWrapper byWrapper);
    
    WebElement getPresentWebElement(ByWrapper byWrapper);
    
    public boolean isInvisibleWebElement(ByWrapper byWrapper);
    
    boolean isStatelessOfWebElement(WebElementWrapper webElementWrapper);
    
    boolean isVisibleTitle(String partialTitle);

}
