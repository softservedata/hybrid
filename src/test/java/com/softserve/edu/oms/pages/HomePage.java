package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    protected WebDriver driver;
    //
    private WebElement firstname;
    private WebElement lastname;
    private WebElement role;
    private WebElement logout;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        // Init Web Elements.
        this.firstname = driver.findElement(By.xpath("//td[text()='First name']/following-sibling::td"));
        this.lastname = driver.findElement(By.xpath("//td[text()='Last name']/following-sibling::td"));
        this.role = driver.findElement(By.xpath("//td[text()='Role']/following-sibling::td"));
        //this.administration = driver.findElement(By.xpath("//a[text()='Administration']"));
        this.logout = driver.findElement(By.xpath("//a[@href='/OMS/logout.htm']"));
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void logoutClick() {
        this.logout.click();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public WebElement getFirstname() {
        return this.firstname;
    }

    public WebElement getLastname() {
        return this.lastname;
    }

    public WebElement getRole() {
        return this.role;
    }

    public WebElement getLogout() {
        return this.logout;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public String getFirstnameText() {
        return this.firstname.getText();
    }

    public String getLastnameText() {
        return this.lastname.getText();
    }

    public String getRoleText() {
        return this.role.getText();
    }

    public LoginPage logout() {
        logoutClick();
        return new LoginPage(driver);
    }
    
}
