package com.softserve.edu.atqc.tools.browsers;

import org.openqa.selenium.chrome.ChromeDriver;

import com.softserve.edu.atqc.tools.browsers.BrowserPathRepository.BrowserPath;

public class ChromeBrowser extends ABrowser {
    private final String CHROME_PROPERTY = "webdriver.chrome.driver";

    ChromeBrowser() {
        init();
        this.driver = new ChromeDriver();
    }

    private void init() {
        System.setProperty(CHROME_PROPERTY, BrowserPath.CHROME_PATH.toString());
    }

}
