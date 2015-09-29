package com.softserve.edu.counters.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;

public class CalibratorHomePage extends ForLoggedUserPage {

	private WebElement employee;

	public CalibratorHomePage() {
		initVisibleWebElements();
	}
	
	private void initVisibleWebElements() {
		this.employee= WebDriverUtils.get().getWebDriver().findElement(By.linkText("Працівники"));
	}

	public void linkEmployeeClick() {
		this.employee.click();
	}

	public WebElement getEmployee() {
		return this.employee;
	}
	
	public EmployeePage goToEmployeePage() {
		linkEmployeeClick();
		return new EmployeePage();
	}

}
