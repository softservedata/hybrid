package com.softserve.edu.atqc.tools.controls;

import org.openqa.selenium.Keys;

public interface ITextField extends ILabelClickable {

    void clear();

    void sendKeys(String text);
    
    void sendKeys(Keys keys);
    
    void sendKeysClear(String text);

}
