package com.softserve.edu.atqc.tools.browsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public final class WebDriverUtils {
    private static volatile WebDriverUtils instance = null;
    private ABrowser browser;
    // TODO Move to Search Classes
    private long implicitlyWaitTimeout = 20L;

    private WebDriverUtils(ABrowser browser) {
        this.browser = browser;
    }

    public static WebDriverUtils get() {
        if (instance == null) {
            synchronized (WebDriverUtils.class) {
                if (instance == null) {
                    instance = new WebDriverUtils(BrowserRepository.getFirefoxByTemporaryProfile());
                }
            }
        }
        return instance;
    }

    public static WebDriverUtils get(ABrowser browser) {
        if (instance != null) {
            synchronized (WebDriverUtils.class) {
                if (instance != null) {
                    if (!instance.browser.getWebDriverName().equals(browser.getWebDriverName())) {
                        instance.quit();
                        instance = null;
                    }
                }
            }
        }
        if (instance == null) {
            synchronized (WebDriverUtils.class) {
                if (instance == null) {
                    instance = new WebDriverUtils(browser);
                }
            }
        }
        return instance;
    }

    public WebDriver getWebDriver() {
        // TODO Move to Search Classes
        browser.getWebDriver().manage().timeouts().implicitlyWait(getImplicitlyWaitTimeout(), TimeUnit.SECONDS);
        //browser.getWebDriver().manage().window().maximize();
        //
        return browser.getWebDriver();
    }

    // TODO Move to Search Classes
    void setImplicitlyWaitTimeout(long implicitlyWaitTimeout) {
        browser.getWebDriver().manage().timeouts().implicitlyWait(implicitlyWaitTimeout, TimeUnit.SECONDS);
    }

    // TODO Move to Search Classes
    public long getImplicitlyWaitTimeout() {
        return implicitlyWaitTimeout;
    }

    // Wrap WebDriver.
    public void loadPage(String url) {
        getWebDriver().get(url);
    }

    public void refreshPage() {
        getWebDriver().navigate().refresh();
    }

    public void closeTab() {
        browser.getWebDriver().close();
    }

    public void quit() {
        browser.quit();
    }

    public void forwardPage() {
        // TODO Use try
        getWebDriver().navigate().forward();
    }

    public void previousPage() {
        // TODO Use try
        getWebDriver().navigate().back();
    }

    public String getCurrentUrl() {
        return getWebDriver().getCurrentUrl();
    }

}
