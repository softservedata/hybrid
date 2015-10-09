package com.softserve.edu.atqc.tools.controls;

public interface ITextField extends ILabelClickable {

    void clear();

    void sendKeys(String text);
    
    void sendKeysClear(String text);

}
