package com.softserve.edu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.atqc.tools.controls.Button;
import com.softserve.edu.atqc.tools.controls.IButton;
import com.softserve.edu.atqc.tools.controls.ITextField;
import com.softserve.edu.atqc.tools.controls.TextField;
import com.softserve.edu.atqc.tools.search.ImplicitWrapper;
import com.softserve.edu.testData.IUsers;
import com.softserve.edu.testData.User;

public class LoginPage {

	private class LoginPageUIMap {
		private ITextField login;
		private ITextField password;
		private IButton submitLoginButton;
    public LoginPageUIMap(){
    	this.login = TextField.get().getByXpath(".//*[@id='loginTable']/tbody/tr[1]/td[2]/input"); 
    	this.password = TextField.get().getById("inputPassword");
    	this.submitLoginButton = Button.get().getByClassName("btn");
      }
	}
    LoginPageUIMap controls;
	public LoginPage() {
		this.controls = new LoginPageUIMap();
	}

	public void setUsername(String login) {
		this.controls.login.sendKeysClear(login);
	}

	public void setPassword(String password) {
		this.controls.password.sendKeysClear(password);

	}

	public void submitLoginButtonClick() {
		this.controls.submitLoginButton.click();
	}

	public ITextField getUsername() {
		return this.controls.login;
	}

	public ITextField getPassword() {
		return this.controls.password;
	}

	public IButton getLoginSubmitButton() {
		return this.controls.submitLoginButton;
	}

	private void setLoginData(IUsers user) {
		setUsername(user.getLogin());
		setPassword(user.getPassword());
		submitLoginButtonClick();
	}

	public AdminHomePage successAdminLogin(IUsers adminUser) {
		setLoginData(adminUser);
		
		// Return a new page object representing the destination.
		return new AdminHomePage();
	}

}
