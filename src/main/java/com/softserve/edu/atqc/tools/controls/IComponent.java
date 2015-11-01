package com.softserve.edu.atqc.tools.controls;

import com.softserve.edu.atqc.tools.search.ByWrapper;
import com.softserve.edu.atqc.tools.search.WebElementWrapper;

public interface IComponent {
 
    String getAttribute(String attribute);

    String getAttributeName();

    String getContent();

    String getTagName();

    boolean isDisplayed();

    boolean isEnabled();

    boolean isSelected();

    boolean isStatelessOf();
    
    public WebElementWrapper getWrapper();
    
    public ByWrapper getByWrapperOfElement();
    
 //   public WebElementWrapper getWebElementWrapper();

}
