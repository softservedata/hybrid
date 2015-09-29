package com.softserve.edu.oms.pages;

import com.softserve.edu.atqc.tools.browsers.ABrowser;
import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;

public class StartLoginPage extends LoginPage {

    private StartLoginPage() {
        super();
    }

    public static LoginPage load(ABrowser browser, String url) {
        // driver = new FirefoxDriver();
        // driver.get(url);
        WebDriverUtils.get(browser).loadPage(url);
        return new LoginPage();
    }
}