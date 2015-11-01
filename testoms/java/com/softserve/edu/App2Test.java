package com.softserve.edu;

import org.testng.annotations.Test;

public class App2Test {
    // WebDriver driver = new FirefoxDriver();

    @Test
    public void testApp() {
        System.out.println("App2Test testApp() thread id=" + Thread.currentThread().getId());
    }

    @Test
    public void testApp2() {
        System.out.println("App2Test testApp2() thread id=" + Thread.currentThread().getId());
    }

}
