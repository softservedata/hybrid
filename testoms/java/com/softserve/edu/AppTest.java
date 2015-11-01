package com.softserve.edu;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {
    // WebDriver driver = new FirefoxDriver();

    @Test
    public void testApp() {
        // Calendar calendar;
        System.out.println("AppTest testApp() thread id=" + Thread.currentThread().getId());
        System.out.println("Var=" + System.getProperty("surefire.reports.directory"));
        Assert.assertTrue(true);
    }

    @Test
    public void testApp2() {
        System.out.println("AppTest testApp2() thread id=" + Thread.currentThread().getId());
    }

}
