package com.softserve.edu.atqc.tools.browsers;

import org.openqa.selenium.WebDriver;

abstract class ABrowser {
    protected WebDriver driver = null;

    WebDriver getWebDriver() {
        if (driver != null) {
        return driver;
        } else {
            // TODO Create class Exception + log + report.
            throw new RuntimeException("Driver not Found.");
        }
    }

    String getWebDriverName() {
        return this.getClass().getName();
    }

    void quit() {
        getWebDriver().quit();
        driver = null;
    }

}
