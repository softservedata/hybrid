package com.softserve.edu.counters.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalibratorHomePage extends ForLoggedUserPage {

	private WebElement employee;

	public CalibratorHomePage(WebDriver driver) {
		
		super(driver);
		this.employee= driver.findElement(By.linkText("Працівники"));
	}

	public void linkEmployeeClick() {
		this.employee.click();
	}

	public WebElement getEmployee() {
		return this.employee;
	}
	
	//--------------------------------------------------------------------
	
	public EmployeePage goToEmployeePage() {
		linkEmployeeClick();;
		return new EmployeePage(driver);
	}
	

}
