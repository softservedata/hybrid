package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerHomePage extends HomePage {
    //
    private WebElement ordering;

    public CustomerHomePage(WebDriver driver) {
        super(driver);
        // Init Web Elements.
        this.ordering = driver.findElement(By.partialLinkText("Ordering"));
    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    public void orderingClick() {
        this.ordering.click();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public WebElement getOrdering() {
        return this.ordering;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public OrderingPage gotoOrderingPage() {
        orderingClick();
        return new OrderingPage(driver);
    }    

}
