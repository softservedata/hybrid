package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.oms.data.IUser;

public class LoginPage {

    public static enum LoginPageMessages {
        VALIDATOR_TEXT("Your login attempt was not successful, try again.");

        private String field;

        private LoginPageMessages(String field) {
            this.field = field;
        }

        public int getLenght() {
            return this.field.length();
        }

        @Override
        public String toString() {
            return this.field;
        }
    }

    private WebElement username;
    private WebElement password;
    private WebElement submit;

    public LoginPage() {
        // Init Web Elements.
        //this.username = driver.findElement(By.name("j_username"));
        //this.password = driver.findElement(By.name("j_password"));
        //this.submit = driver.findElement(By.name("submit"));
        initVisibleWebElements();
    }

    private void initVisibleWebElements() {
        // Init Web Elements.
        this.username = WebDriverUtils.get().getWebDriver().findElement(By.name("j_username"));
        this.password = WebDriverUtils.get().getWebDriver().findElement(By.name("j_password"));
        this.submit = WebDriverUtils.get().getWebDriver().findElement(By.name("submit"));
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void setUsername(String username) {
        this.username.click();
        this.username.clear();
        this.username.sendKeys(username);
    }
    
    public void setPassword(String password) {
        this.password.click();
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void buttonSubmitClick() {
        this.submit.click();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    public WebElement getUsername() {
        return this.username;
    }

    public WebElement getPassword() {
        return this.password;
    }

    public WebElement getSubmit() {
        return this.submit;
    }

    // Bad Code.
    public WebElement getValidator() {
        return WebDriverUtils.get().getWebDriver().findElement(By.xpath("//font[@color='red']"));
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public String getValidatorText() {
        return getValidator().getText().trim().substring(0, LoginPageMessages.VALIDATOR_TEXT.getLenght());
    }
    
    private void setLoginData(IUser user) {
        setUsername(user.getLogin());
        setPassword(user.getPassword());
        buttonSubmitClick();
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

    public LoginPage unSuccesfulLogin(IUser invalidUser) {
        setLoginData(invalidUser);
        return new LoginPage(); // return this;
    }
    
}
