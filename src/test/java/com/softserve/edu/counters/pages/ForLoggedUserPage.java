package com.softserve.edu.counters.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;

public class ForLoggedUserPage {

	private class DropDownList {
		public final WebElement logOut;

		public DropDownList() {
			this.logOut = WebDriverUtils.get().getWebDriver().findElement(By.linkText("Вилогуватись"));
		}
	}

	private WebElement nameUser;
	private DropDownList dropDownList;

	public ForLoggedUserPage() {
		initVisibleWebElements();
	}

	private void initVisibleWebElements() {
		this.nameUser = WebDriverUtils.get().getWebDriver()
				.findElement(By.xpath("//a[@class='dropdown-toggle']/label"));
	}

	public void nameUserClick() {
		this.nameUser.click();
		this.dropDownList = new DropDownList();
	}

	public WebElement getNameUser() {
		return this.nameUser;
	}

	public MainPage logout() {
		nameUserClick();
		dropDownList.logOut.click();
		return new MainPage();
	}

}
