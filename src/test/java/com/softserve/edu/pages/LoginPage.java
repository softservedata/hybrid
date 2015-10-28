package com.softserve.edu.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.atqc.tools.controls.Button;
import com.softserve.edu.atqc.tools.controls.IButton;
import com.softserve.edu.atqc.tools.controls.ITextField;
import com.softserve.edu.atqc.tools.controls.TextField;

import com.softserve.edu.testData.IUsers;


public class LoginPage {

	private class LoginPageUIMap {
		public final ITextField login;
		public final ITextField password;
		public final IButton submitLoginButton;
    public LoginPageUIMap(){
    	this.login = TextField.get().getByXpath("//input[@ng-model='loginForm.username']"); 
    	this.password = TextField.get().getById("inputPassword");
    	this.submitLoginButton = Button.get().getByClassName("btn");
    //System.out.println("*********Hello");
    	//login.sendKeys("Hello");
    	
    	TextField.get().getByXpath("//input[@ng-model='loginForm.username']").sendKeys(Keys.ARROW_LEFT.toString());
//    	TextField.get().getById("inputPassword").sendKeys("********");
    }
	}
    LoginPageUIMap controls;
	public LoginPage() {
		this.controls = new LoginPageUIMap();
	}

	public void setUsername(String login) {
		System.out.println("+++++++++++++++Send keys " +login);
		getUsername().clear();
		
		//this.controls.login.sendKeys(login);
//		WebDriverUtils.get().getWebDriver().findElement(By.xpath(".//*[@id='loginTable']/tbody/tr[1]/td[2]/input")).sendKeys(login);
        TextField.get().getByXpath(".//*[@id='loginTable']/tbody/tr[1]/td[2]/input").sendKeys(login); 
		
		//ITextField textField = TextField.get().getByXpath(".//*[@id='loginTable']/tbody/tr[1]/td[2]/input");
		//textField.sendKeys(login);
		System.out.println("+++++++++++++++Send done ");
		
	}

	public void setPassword(String password) {
		//getPassword().sendKeys(password);
		TextField.get().getById("inputPassword").sendKeys(password);

	}

	public void submitLoginButtonClick() {
		Button.get().getByClassName("btn").click();
		//getLoginSubmitButton().click();
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
