package com.softserve.edu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.data.IUser;

public class LoginPage {
    private WebDriver driver;
    //
    private WebElement username;
    private WebElement password;
    private WebElement submit;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // Init Web Elements.
        this.username = driver.findElement(By.name("j_username"));
        this.password = driver.findElement(By.name("j_password"));
        this.submit = driver.findElement(By.name("submit"));
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void setUsername(String username) {
        this.username.click();
        this.username.clear();
        this.username.sendKeys(username);
    }
    
    public void setPassword(String password) {
        this.password.click();
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void buttonSubmitClick() {
        this.submit.click();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    public WebElement getUsername() {
        return this.username;
    }

    public WebElement getPassword() {
        return this.password;
    }

    public WebElement getSubmit() {
        return this.submit;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private void setLoginData(IUser user) {
        setUsername(user.getLogin());
        setPassword(user.getPassword());
        buttonSubmitClick();
    }

    public AdminHomePage successAdminLogin(IUser adminUser) {
        setLoginData(adminUser);
        // Return a new page object representing the destination.
        return new AdminHomePage(driver);
    }

    public CustomerHomePage successCustomerLogin(IUser customerUser) {
        setLoginData(customerUser);
        // Return a new page object representing the destination.
        return new CustomerHomePage(driver);
    }

    public LoginPage unSuccesfulLogin(IUser invalidUser) {
        setLoginData(invalidUser);
        return new LoginPage(driver); // return this;
    }
    
}
