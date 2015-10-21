package com.softserve.edu.oms.pages;

import com.softserve.edu.atqc.tools.controls.Button;
import com.softserve.edu.atqc.tools.controls.IButton;
import com.softserve.edu.atqc.tools.controls.ITextField;
import com.softserve.edu.atqc.tools.controls.TextField;
import com.softserve.edu.oms.data.IUser;

public class LoginPage {

    private class LoginPageUIMap {
        public final ITextField username;
        public final ITextField password;
        public final IButton submit;

        public LoginPageUIMap() {
            this.username = TextField.get().getByName("j_username");
            this.password = TextField.get().getByName("j_password");
            this.submit = Button.get().getByName("submit");
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Elements
    private LoginPageUIMap controls;

    public LoginPage() {
        controls = new LoginPageUIMap();
    }

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void setUsername(String username) {
        this.controls.username.sendKeysClear(username);
    }
    
    public void setPassword(String password) {
        this.controls.password.sendKeysClear(password);
    }

    public void buttonSubmitClick() {
        this.controls.submit.click();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    public ITextField getUsername() {
        return this.controls.username;
    }

    public ITextField getPassword() {
        return this.controls.password;
    }

    public IButton getSubmit() {
        return this.controls.submit;
    }

    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    private void setLoginData(IUser user) {
        setUsername(user.getLogin());
        setPassword(user.getPassword());
        buttonSubmitClick();
    }

    public HomePage successLogin(IUser user) {
        setLoginData(user);
        // Return a new page object representing the destination.
        return new HomePage();
    }

    public AdminHomePage successAdminLogin(IUser adminUser) {
        setLoginData(adminUser);
        // Return a new page object representing the destination.
        return new AdminHomePage();
    }

    public CustomerHomePage successCustomerLogin(IUser customerUser) {
        setLoginData(customerUser);
        // Return a new page object representing the destination.
        return new CustomerHomePage();
    }

    public ValidatorLoginPage unSuccesfulLogin(IUser invalidUser) {
        setLoginData(invalidUser);
        return new ValidatorLoginPage(); // return this;
    }

}
