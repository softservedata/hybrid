package com.softserve.edu.atqc.tools.controls;

import org.openqa.selenium.Keys;

abstract class GTextField<TComponent> extends GLabelClickable<TComponent>implements ITextField {

    // implements constructor
    protected GTextField() {
    }

    // implements interface

    public void clear() {
        getWebElementWrapper().clear();
    }

    public void sendKeys(String text) {
        getWebElementWrapper().sendKeys(text);
    }
    public void sendKeys(Keys keys) {
        getWebElementWrapper().sendKeys(keys);
    }

    public void sendKeysClear(String text) {
        getWebElementWrapper().sendKeysClear(text);
    }
    
    

}
