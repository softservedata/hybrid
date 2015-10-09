package com.softserve.edu.atqc.tools.controls;

public interface IComponent {
 
    String getAttribute(String attribute);

    String getAttributeName();

    String getContent();

    String getTagName();

    boolean isDisplayed();

    boolean isEnabled();

    boolean isSelected();

    boolean isStatelessOf();

}
