package com.softserve.edu.pages;

import org.openqa.selenium.JavascriptExecutor;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.atqc.tools.search.IObserveLoad;

public final class PageLoadComplete implements IObserveLoad {
    private final String IS_PAGE_VISIBLE = "return $('.all')[0].style.opacity == ''";

    public boolean loadComplete(){
        return (boolean)((JavascriptExecutor)WebDriverUtils.get().getWebDriver())
                .executeScript(IS_PAGE_VISIBLE);
    }
    
}
