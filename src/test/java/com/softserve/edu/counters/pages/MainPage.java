package com.softserve.edu.counters.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;

public class MainPage {

	private WebElement logIn;

	public MainPage() {
		initVisibleWebElements();
	}

	private void initVisibleWebElements() {
		this.logIn = WebDriverUtils.get().getWebDriver().findElement(By.linkText("Увійти"));
	}

	public void linkLogInClick() {
		logIn.click();
	}

	public WebElement getLogIn() {
		return this.logIn;
	}

	public LoginPage goToLoginPage() {
		linkLogInClick();
		return new LoginPage();
	}

}
