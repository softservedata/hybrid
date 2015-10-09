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

    public void sendKeysClear(String text) {
        getWebElementWrapper().sendKeysClear(text);
    }
    
    public void sendKeysControl(Keys keys){
    	getWebElementWrapper().sendKeysControl(keys);
    }
}
