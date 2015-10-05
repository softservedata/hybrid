package com.softserve.edu.atqc.tools.browsers;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser extends ABrowser {

    FirefoxBrowser() {
        this.driver = new FirefoxDriver();
        System.out.println("FirefoxBrowser  "
                +"\tThread ID= " + Thread.currentThread().getId());

    }

}
