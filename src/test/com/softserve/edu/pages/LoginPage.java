package com.softserve.edu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.testData.IUsers;
import com.softserve.edu.testData.User;

public class LoginPage {
	private WebDriver driver;
	private WebElement login;
	private WebElement password;
	private WebElement submitLoginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

		this.login = driver.findElement(By.xpath(".//*[@id='loginTable']/tbody/tr[1]/td[2]/input"));
		this.password = driver.findElement(By.id("inputPassword"));
		this.submitLoginButton = driver.findElement(By.className("btn"));

	}

	public void setUsername(String login) {
		this.login.click();
		this.login.sendKeys(login);
	}
    
	public void setPassword(String password){
		this.password.click();
		this.password.sendKeys(password);
		
	}
	public void submitLoginButtonClick(){
		this.submitLoginButton.click();
	}
	
	public WebElement getUsername(){
		return this.login;
	}
	public WebElement getPassword(){
		return this.password;
	}
	
	public WebElement getLoginSubmitButton(){
		return this.submitLoginButton;
	}
	
	private void setLoginData(IUsers user){
		setUsername(user.getLogin());
		setPassword(user.getPassword());
		submitLoginButtonClick();
	}
	public AdminHomePage successAdminLogin(IUsers adminUser) {
        setLoginData(adminUser);
        // Return a new page object representing the destination.
        return new AdminHomePage(driver);
    }
	
	
	
	
}
