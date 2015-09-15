package com.softserve.edu;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {
    // WebDriver driver = new FirefoxDriver();

    @Test
    public void testApp() {
        // Calendar calendar;
        System.out.println("RUN TEST");
        System.out.println("Var=" + System.getProperty("surefire.reports.directory"));
        Assert.assertTrue(true);
    }
}
