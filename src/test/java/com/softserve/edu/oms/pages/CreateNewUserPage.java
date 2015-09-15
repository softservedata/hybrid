package com.softserve.edu.oms.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.oms.data.IUser;


public class CreateNewUserPage {

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

    public CreateNewUserPage(WebDriver driver) {
        this.driver = driver;
        login = driver.findElement(By.name("login"));
        firstName = driver.findElement(By.name("firstName"));
        lastName = driver.findElement(By.name("lastName"));
        password = driver.findElement(By.name("password"));
        confirmPassword = driver.findElement(By.name("confirmPassword"));
        email = driver.findElement(By.name("email"));
        regionID = driver.findElement(By.name("regionID"));
        roleID = driver.findElements(By.name("roleID"));
        create = driver.findElement(By.xpath("//*[@id='userModel']/input[4]"));
        cancel = driver.findElement(By.xpath("//*[@id='userModel']/input[5]"));
        nameError = driver.findElement(By.id("nameError"));
    }

    public AdministrationPage createUser(IUser user) {

        setLogin(user.getLogin());
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

    public void buttonSubmitClick() {
        this.create.click();

    }

    public void setLogin(String userLogin) {
        this.login.click();
        this.login.clear();
        this.login.sendKeys(userLogin);
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

    public WebElement getNameError() {
        return nameError;
    }

    public void setNameError(WebElement nameError) {
        this.nameError = nameError;
    }

    
    
    
}
