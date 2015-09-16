package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;

public class AdminHomePage extends HomePage {
    //
    private WebElement administration;

    public AdminHomePage() {
        super();
        // Init Web Elements.
        //this.administration = driver.findElement(By.xpath("//a[text()='Administration']"));
        this.administration = WebDriverUtils.get().getWebDriver().findElement(By.partialLinkText("Administration"));
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    public void administrationClick() {
        this.administration.click();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public WebElement getAdministration() {
        return this.administration;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public AdministrationPage gotoAdministrationPage() {
        administrationClick();
        return new AdministrationPage();
    }    
    
}
