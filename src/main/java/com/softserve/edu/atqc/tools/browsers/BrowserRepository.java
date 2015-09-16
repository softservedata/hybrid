package com.softserve.edu.atqc.tools.browsers;

public final class BrowserRepository {

    private BrowserRepository() {
    }

    public static ABrowser getFirefoxByTemporaryProfile() {
        return new FirefoxBrowser();
    }

    public static ABrowser getChromeByTemporaryProfile() {
        return new ChromeBrowser();
    }

}
