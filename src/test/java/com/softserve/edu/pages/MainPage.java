package com.softserve.edu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;


public class MainPage {
	private WebDriver driver;
	private WebElement logIn;
	
	public MainPage(){
		
		this.logIn = WebDriverUtils.get().getWebDriver().findElement(By.partialLinkText("Увійти"));
		
	}
    public void logInButtonClick(){
    	this.logIn.click();
    }
    public LoginPage gotoLoginPage(){
    	logInButtonClick();
    	return new LoginPage();
    }
}
