package com.softserve.edu.counters.pages;

import com.softserve.edu.atqc.tools.controls.Button;
import com.softserve.edu.atqc.tools.controls.IButton;
import com.softserve.edu.atqc.tools.controls.ITextField;
import com.softserve.edu.atqc.tools.controls.TextField;
import com.softserve.edu.counters.data.IUser;

public class LoginPage {
	
	private class LoginPageUIMap {
        public final  ITextField login;
        public final  ITextField password;
        public final  IButton submit;

        public LoginPageUIMap() {
        	this.login = TextField.get().getByXpath("//input[@type='text']");
        	this.password = TextField.get().getById("inputPassword");
            this.submit = Button.get().getByTagName("button");
        }
    }
	
	 // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Elements
    private LoginPageUIMap controls;

    public LoginPage() {
        controls = new LoginPageUIMap();
    }

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void setLogin(String login) {
        this.controls.login.click();
        this.controls.login.clear();
        this.controls.login.sendKeys(login);
    }
    
    public void setPassword(String password) {
        this.controls.password.click();
        this.controls.password.clear();
        this.controls.password.sendKeys(password);
    }

    public void buttonSubmitClick() {
        this.controls.submit.click();
    }
    
    public ITextField getLogin() {
        return this.controls.login;
    }

    public ITextField getPassword() {
        return this.controls.password;
    }

    public IButton getSubmit() {
        return this.controls.submit;
    }
    
    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    private void setLoginData(IUser user) {
        setLogin(user.getLogin());
        setPassword(user.getPassword());
        buttonSubmitClick();
    }
    
    public CalibratorHomePage successAdminLogin(IUser calibratorUser) {
        setLoginData(calibratorUser);
        return new CalibratorHomePage();
    }
    
    public CalibratorEmployeeHomePage successCalibratorEmployeeLogin(IUser calibratorUser) {
        setLoginData(calibratorUser);
        return new CalibratorEmployeeHomePage();
    }

    public LoginPageValidator unSuccesfulLogin(IUser invalidUser) {
        setLoginData(invalidUser);
        return new LoginPageValidator();
    }
    
    
}
