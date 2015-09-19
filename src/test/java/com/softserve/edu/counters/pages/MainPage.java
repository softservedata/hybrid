package com.softserve.edu.counters.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	
	private WebDriver driver;
	private WebElement logIn;

	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		this.logIn = driver.findElement(By.linkText("”в≥йти"));
	}
	
	public void linkLogInClick() {
		logIn.click();
	}
	
	public WebElement getLogIn() {
		return this.logIn;
	}
	
	public LoginPage goToLoginPage() {
		linkLogInClick();
		return new LoginPage(driver);
	}

}
