package com.softserve.edu.atqc.tools.browsers;

import org.openqa.selenium.WebDriver;

public abstract class ABrowser {
    private final String BROWSER_CLOSED = "Browser was Closed.";
    protected WebDriver driver = null;

    WebDriver getWebDriver() {
        if (driver != null) {
        return driver;
        } else {
            // TODO Create class Exception + log + report.
            throw new RuntimeException(BROWSER_CLOSED);
        }
    }

    String getWebDriverName() {
        return this.getClass().getName();
    }

    boolean isEnabled() {
        return driver != null;
    }
    
    void close() {
        getWebDriver().close();
        driver = null;
    }

    void quit() {
        getWebDriver().quit();
        driver = null;
    }

}
