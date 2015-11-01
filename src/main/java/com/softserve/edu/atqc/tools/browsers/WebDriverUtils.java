package com.softserve.edu.atqc.tools.browsers;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public final class WebDriverUtils {
    private static volatile WebDriverUtils instance = null;
    //private final ThreadLocal<ABrowser> browsers;
    private final HashMap<Long, ABrowser> browsers;

    private WebDriverUtils() {
        //this.browsers = new ThreadLocal<ABrowser>();
        this.browsers = new HashMap<Long, ABrowser>();
    }

    public static WebDriverUtils get() {
      //  System.out.println("WebDriverUtils_get()");
        return get(BrowserRepository.getDefault());
    }

    public static WebDriverUtils get(ABrowser browser) {
//        System.out.print("**********WebDriverUtils_get(ABrowser) browser is null:");
//        System.out.print(browser == null);
//        System.out.println(" *****Thread ID= " + Thread.currentThread().getId());
        if (instance == null) {
            synchronized (WebDriverUtils.class) {
                if (instance == null) {
                    instance = new WebDriverUtils();
//                    if (browser == null) {
//                        browser = BrowserRepository.getFirefoxByTemporaryProfile();
//                    }
////                    System.out.println("*****Create instance.");
//                    instance.setBrowser(browser);
                }
            }
        }
        if (instance != null) {
            synchronized (WebDriverUtils.class) {
                if ((browser == null)
                        && ((instance.getBrowser() == null)
                                || !instance.getBrowser().isEnabled())) {
                    browser = BrowserRepository.getFirefoxByTemporaryProfile();
                }
                if ((browser != null)
                        && (instance.getBrowser() != null)
                        && instance.getBrowser().isEnabled()
                        && (!instance.getBrowser().getWebDriverName().equals(browser.getWebDriverName()))) {
                    instance.closeTab();
                }
                if ((instance.getBrowser() == null)
                        || ((browser != null)
                                && (!instance.getBrowser().getWebDriverName().equals(browser.getWebDriverName())))
                        || (!instance.getBrowser().isEnabled())) {
//                    System.out.println("Create browser  "
//                            +"\tThread ID= " + Thread.currentThread().getId());
                    instance.setBrowser(browser);
                }
            }
        }
        return instance;
    }

    public static void quitAll() {
        if (instance != null) {
            // for (Long threadId : instance.browsers.keySet()) {
            for (ABrowser browser : instance.browsers.values()) {
                browser.quit();
            }
        }
    }

    private void setBrowser(ABrowser browser) {
        this.browsers.put(Thread.currentThread().getId(), browser);
    }

    private ABrowser getBrowser() {
        return browsers.get(Thread.currentThread().getId());
    }

    public WebDriver getWebDriver() {
        // TODO browser.getWebDriver().manage().window().maximize();
        return getBrowser().getWebDriver();
    }

    // Wrap WebDriver.
    public void loadPage(String url) {
        getWebDriver().get(url);
    }

    public void refreshPage() {
        getWebDriver().navigate().refresh();
    }

    public void closeTab() {
        getBrowser().close();
    }

    public void quit() {
        getBrowser().quit();
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
