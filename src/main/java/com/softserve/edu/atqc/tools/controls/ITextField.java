package com.softserve.edu.atqc.tools.controls;

import org.openqa.selenium.Keys;

import com.softserve.edu.atqc.tools.search.KeysWrapper;

public interface ITextField extends ILabelClickable {

    void clear();

    void sendKeys(String text);
    
    void sendKeysClear(String text);
    
    void sendKeysEnter();

}
