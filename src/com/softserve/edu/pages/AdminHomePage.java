package com.softserve.edu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminHomePage extends HomePage {
    //
    private WebElement administration;

    public AdminHomePage(WebDriver driver) {
        super(driver);
        // Init Web Elements.
        //this.administration = driver.findElement(By.xpath("//a[text()='Administration']"));
        this.administration = driver.findElement(By.partialLinkText("Administration"));
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
        return new AdministrationPage(driver);
    }    
    
}
