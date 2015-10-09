package com.softserve.edu.atqc.tools.controls;

import org.openqa.selenium.Keys;

public interface ITextField extends ILabelClickable {

    void clear();

    void sendKeys(String text);
    
    void sendKeysClear(String text);
    
    void sendKeysControl(Keys keys);

}
