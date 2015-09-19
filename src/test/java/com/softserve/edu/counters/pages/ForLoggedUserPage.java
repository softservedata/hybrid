package com.softserve.edu.counters.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForLoggedUserPage {
	protected WebDriver driver;

	private WebElement nameUser;
	private DropDownList dropDownList;

	public ForLoggedUserPage(WebDriver driver) {
		this.driver = driver;
		this.nameUser = driver.findElement(By.xpath("//a[@class='dropdown-toggle']/label"));
	}
	
	public class DropDownList { ///??????
		
		private WebElement logOut;

		public DropDownList() {
			this.logOut = driver.findElement(By.linkText("Вилогуватись"));
		}
		
		public void linkLogOutClick() {
			this.logOut.click();
		}
		///////////&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		public WebElement getLogOut() {
			return this.logOut;
		}
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
		dropDownList.linkLogOutClick();
		return new MainPage(driver);
	}
}
