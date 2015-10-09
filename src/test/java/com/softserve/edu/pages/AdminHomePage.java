package com.softserve.edu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminHomePage {
    private WebDriver driver;
	
	private WebElement pageHeader;
	private WebElement leftSideBar;
	private WebElement organizationTabLink;
	private WebElement logoutLink;
	private WebElement logoutDropDown;
	
	
	public AdminHomePage(){
		
		this.pageHeader = driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[1]/div/h1"));
		this.leftSideBar = driver.findElement(By.id("side-menu"));
		this.organizationTabLink = driver.findElement(By.xpath(".//*[@id='side-menu']/li[2]/a"));
		this.logoutLink = driver.findElement(By.xpath(".//*[@id='adminModule']/nav/ul/li/ul/li[2]/div[3]/a"));
		this.logoutDropDown = driver.findElement(By.xpath(".//*[@id='adminModule']/nav/ul/li/a/i[1]"));
	}
	public void organizationTabLinkClick(){
		this.organizationTabLink.click();
	}
	
	public WebElement getPageHeader(){
		return this.pageHeader;
	}
	
	public WebElement getLeftSideBar(){
		return this.leftSideBar;
	}
	
	public String getPageHeaderText(){
		return getPageHeader().getText();
	}
	 public void logOut(){
		 logoutDropDown.click();
		 logoutLink.click();
	 }
	public OrganizationPage gotoOrganizationPage(){
		organizationTabLinkClick();
		return new OrganizationPage(driver);
		
	}
}
