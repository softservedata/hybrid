package com.softserve.edu.counters.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.counters.data.IUser;

public class LoginPage {
	
    private WebElement login;
    private WebElement password;
    private WebElement submit;
    private WebElement incorrectLoginMessage;

    public LoginPage() {
    	initVisibleWebElements();
    }
    
    private void initVisibleWebElements() {
    	this.login = WebDriverUtils.get().getWebDriver().findElement(By.xpath("//input[@type='text']"));
        this.password = WebDriverUtils.get().getWebDriver().findElement(By.xpath("//input[@type='password']"));
        this.submit = WebDriverUtils.get().getWebDriver().findElement(By.tagName("button"));
        this.incorrectLoginMessage = WebDriverUtils.get().getWebDriver().findElement(By.id("incorrectLoginMessage"));
    }

    public void setLogin(String login) {
        this.login.click();
        this.login.clear();
        this.login.sendKeys(login);
    }
    
    public void setPassword(String password) {
        this.password.click();
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void buttonSubmitClick() {
        this.submit.click();
    }
    
    public WebElement getLogin() {
        return this.login;
    }

    public WebElement getPassword() {
        return this.password;
    }

    public WebElement getSubmit() {
        return this.submit;
    }
    
    public WebElement getIncorrectLoginMessage() {
        return this.incorrectLoginMessage;
    }
    
    private void setLoginData(IUser user) {
        setLogin(user.getLogin());
        setPassword(user.getPassword());
        buttonSubmitClick();
    }
    
    public CalibratorHomePage successAdminLogin(IUser calibratorUser) {
        setLoginData(calibratorUser);
        return new CalibratorHomePage();
    }
    
    public CalibratorEmployeeHomePage successCalibratorEmployeeLogin(IUser calibratorUser) {
        setLoginData(calibratorUser);
        return new CalibratorEmployeeHomePage();
    }

    public LoginPage unSuccesfulLogin(IUser invalidUser) {
        setLoginData(invalidUser);
        return this;
    }
    
    
}
