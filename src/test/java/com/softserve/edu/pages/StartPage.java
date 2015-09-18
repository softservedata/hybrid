package com.softserve.edu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class StartPage {
	private WebDriver driver;
	private WebElement logIn;
	
	public StartPage(WebDriver driver){
		this.driver = driver;
		this.logIn = driver.findElement(By.partialLinkText("”в≥йти"));
		
	}
    public void logInButtonClick(){
    	this.logIn.click();
    }
    public LoginPage gotoLoginPage(){
    	logInButtonClick();
    	return new LoginPage(driver);
    }
}
