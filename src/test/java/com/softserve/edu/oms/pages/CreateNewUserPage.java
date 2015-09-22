package com.softserve.edu.oms.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.oms.data.IUser;

public class CreateNewUserPage {

    public static enum CreateNewUserPageMessages {
        LOGIN_ERROR_IN_USE_TEXT(" already in use"), 
        CREATE_USER_ALL_FIELDS_EMPTY("check all fields for valid data");

        private String field;

        private CreateNewUserPageMessages(String field) {
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

    WebDriver driver;
    WebElement login;
    WebElement firstName;
    WebElement lastName;
    WebElement password;
    WebElement confirmPassword;
    WebElement email;
    WebElement regionID;
    List<WebElement> roleID;
    WebElement create;
    WebElement cancel;
    WebElement nameError;
    WebElement logout;
    Alert alert;

    public CreateNewUserPage(WebDriver driver) {
        this.driver = driver;
        initVisibleWebElements();
    }

    //------------------------------------------------------------------------
    
    private void initVisibleWebElements() {

        this.login = driver.findElement(By.name("login"));
        this.firstName = driver.findElement(By.name("firstName"));
        this.lastName = driver.findElement(By.name("lastName"));
        this.password = driver.findElement(By.name("password"));
        this.confirmPassword = driver.findElement(By.name("confirmPassword"));
        this.email = driver.findElement(By.name("email"));
        this.regionID = driver.findElement(By.name("regionID"));
        this.roleID = driver.findElements(By.name("roleID"));
        this.create = driver
                .findElement(By.xpath("//*[@id='userModel']/input[4]"));
        this.cancel = driver
                .findElement(By.xpath("//*[@id='userModel']/input[5]"));
        this.logout = driver
                .findElement(By.xpath("//a[@href='/OMS/logout.htm']"));
        this.nameError = driver.findElement(By.id("nameError"));

    }

    public AdministrationPage createUser(IUser user) {

        setLogin(user);
        setFirstName(user.getFirstname());
        setLastName(user.getLastname());
        setPassword(user.getPassword());
        setConfirmPassword(user.getPassword());
        setEmail(user.getEmail());
        setRegion(user.getRegion());
        setRole(user.getRole());

        buttonSubmitClick();
        return new AdministrationPage(driver);
    }

    public void setLogin(IUser user) {
        setLoginData(user.getLogin());
    }

    public void setUserLoginInUse(IUser user) {

        setLogin(user);
    }

    public LoginPage logout() {
        logoutClick();
        return new LoginPage(driver);
    }

    public String getUserLoginInUseMessage(IUser user) {

        return getUserLoginInUseMessageString(user.getLogin());

    }

    public String getTextFromAlert() {

        switchToAlert();
        String alertText = getAlert().getText();
        dismisAlert();

        return alertText;

    }

    // ---------------------------------------------------------

    public void switchToAlert() {
        alert = driver.switchTo().alert();
    }

    public void dismisAlert() {
        alert.dismiss();
    }

    public void buttonSubmitClick() {
        this.create.click();

    }
    
    public void logoutClick() {
        this.logout.click();
    }
    

    public void setLoginData(String userLogin) {
        this.login.click();
        this.login.clear();

        this.login.sendKeys(userLogin);

        // this.login.sendKeys("o");
        // this.login.sendKeys("r");
        // this.login.sendKeys("e");
        // this.login.sendKeys("s");
        // this.login.sendKeys("t");
        // (new WebDriverWait(driver, 10))
        // .until(new ExpectedCondition<Boolean>( ) {
        // public Boolean apply(WebDriver d) {
        // return (d.findElement(By.id("nameError"))
        // .getText(
        // ).endsWith(CreateNewUserPageMessages.LOGIN_ERROR_IN_USE_TEXT.toString()));
        // } } );

        this.login.sendKeys(Keys.LEFT);
    }

    public void setFirstName(String userFirstName) {
        this.firstName.click();
        this.firstName.clear();
        this.firstName.sendKeys(userFirstName);
    }

    public void setLastName(String userLastName) {
        this.lastName.click();
        this.lastName.clear();
        this.lastName.sendKeys(userLastName);
    }

    public void setPassword(String userPassword) {
        this.password.click();
        this.password.clear();
        this.password.sendKeys(userPassword);

    }

    public void setConfirmPassword(String userConfirmPassword) {
        this.confirmPassword.click();
        this.confirmPassword.clear();
        this.confirmPassword.sendKeys(userConfirmPassword);
    }

    public void setEmail(String userEmail) {
        this.email.click();
        this.email.clear();
        this.email.sendKeys(userEmail);
        this.email.sendKeys(Keys.LEFT);
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (nameError.getText().startsWith(""));
            }
        });

    }

    public void setRegion(String region) {
        new Select(regionID).selectByVisibleText(region);
    }

    public void setRole(String role) {

        WebElement labelRole = driver
                .findElement(By.xpath("//*[contains(text(), '" + role + "')]"));

        for (WebElement webElement : roleID) {
            if (webElement.getAttribute("id")
                    .equals(labelRole.getAttribute("for"))) {
                webElement.click();
            }
        }

    }

    public String getUserLoginInUseMessageString(String login) {

        return "" + login + CreateNewUserPageMessages.LOGIN_ERROR_IN_USE_TEXT;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogin() {
        return login;
    }

    public void setLogin(WebElement login) {
        this.login = login;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public void setFirstName(WebElement firstName) {
        this.firstName = firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public void setLastName(WebElement lastName) {
        this.lastName = lastName;
    }

    public WebElement getPassword() {
        return password;
    }

    public void setPassword(WebElement password) {
        this.password = password;
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(WebElement confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public WebElement getEmail() {
        return email;
    }

    public void setEmail(WebElement email) {
        this.email = email;
    }

    public WebElement getRegionID() {
        return regionID;
    }

    public void setRegionID(WebElement regionID) {
        this.regionID = regionID;
    }

    public List<WebElement> getRoleID() {
        return roleID;
    }

    public void setRoleID(List<WebElement> roleID) {
        this.roleID = roleID;
    }

    public WebElement getCreate() {
        return create;
    }

    public void setCreate(WebElement create) {
        this.create = create;
    }

    public WebElement getCancel() {
        return cancel;
    }

    public void setCancel(WebElement cancel) {
        this.cancel = cancel;
    }

    public String getNameErrorString() {

        return getNameError().getText();
    }

    public WebElement getNameError() {
        return driver.findElement(By.id("nameError"));
    }

    public WebElement getLogout() {
        return logout;
    }


    public Alert getAlert() {
        return alert;
    }


    
}
