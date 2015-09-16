package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;

public class CustomerHomePage extends HomePage {
    //
    private WebElement ordering;

    public CustomerHomePage() {
        super();
        // Init Web Elements.
        this.ordering = WebDriverUtils.get().getWebDriver().findElement(By.partialLinkText("Ordering"));
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
        return new OrderingPage();
    }    

}
