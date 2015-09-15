package com.softserve.edu.oms.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class AdministrationPage {

    public static enum FieldFilter {
        ALL_COLUMNS("All Columns"), FIRST_NAME("First Name"), LAST_NAME(
                "Last Name"), ROLE("Role"), LOGIN_NAME("Login Name");

        private String field;

        private FieldFilter(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }

    public static enum Condition {
        EQUALS("equals"), NOT_EQUALS_TO("not equals to"), STARTS_WITH(
                "starts with"), CONTAINS("contains"), DOES_NOT_CONTAIN(
                        "does not contain");

        private String field;

        private Condition(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }

    private class AdministrationPageUIMapAjax {
        public final WebElement usersFound;
        public final WebElement firstName;

        public final WebElement lastName;
        public final WebElement login;
        public final WebElement edit;
        public final WebElement delete;

        public AdministrationPageUIMapAjax() {
            this.usersFound = driver.findElement(By.id("usersFound"));
            if (Integer.parseInt(usersFound.getText()) > 0) {
                this.firstName = driver
                        .findElement(By.xpath("//tbody/tr[1]/td[1]"));
                this.lastName = driver
                        .findElement(By.xpath("//tbody/tr[1]/td[2]"));
                this.login = driver
                        .findElement(By.xpath("//tbody/tr[1]/td[3]"));
                this.edit = driver
                        .findElement(By.xpath("//tbody/tr[1]/td[6]/a"));
                this.delete = driver
                        .findElement(By.xpath("//tbody/tr[1]/td[7]/a"));
            } else {
                this.firstName = driver
                        .findElement(By.xpath("//thead/tr[1]/th[1]/a"));
                this.lastName = driver
                        .findElement(By.xpath("//thead/tr[1]/th[2]/a"));
                this.login = driver
                        .findElement(By.xpath("//thead/tr[1]/th[3]/a"));
                this.edit = driver.findElement(By.xpath("//thead/tr[1]/th[6]"));
                this.delete = driver
                        .findElement(By.xpath("//thead/tr[1]/th[7]"));

            }
        }

        public AdministrationPageUIMapAjax(String login) {
            this.usersFound = driver.findElement(By.id("usersFound"));
            //
            this.login = driver.findElement(
                    By.xpath("//tbody//td[3][text()='" + login + "']"));
            this.lastName = driver
                    .findElement(By.xpath("//tbody//td[3][text()='" + login
                            + "']/preceding-sibling::td[1]"));
            this.firstName = driver
                    .findElement(By.xpath("//tbody//td[3][text()='" + login
                            + "']/preceding-sibling::td[2]"));
            this.edit = driver.findElement(By.xpath("//tbody//td[3][text()='"
                    + login + "']/following-sibling::td[3]/a"));
            this.delete = driver.findElement(By.xpath("//tbody//td[3][text()='"
                    + login + "']/following-sibling::td[4]/a"));
        }           
    }

    private WebDriver driver;

    private WebElement createNewUser;

    private WebElement selectField;
    private WebElement selectCondition;
    private WebElement searchValue;
    private WebElement search;
    private WebElement logout;

    private AdministrationPageUIMapAjax controlsAjax;

    public AdministrationPage(WebDriver driver) {
        this.driver = driver;

        controlsAjax = new AdministrationPageUIMapAjax();
        initVisibleWebElements();
    }

    public void initVisibleWebElements() {
        this.createNewUser = driver.findElement(By.linkText("Create New User"));

        this.selectField = driver.findElement(By.name("selectField"));
        this.selectCondition = driver.findElement(By.name("selectCondition"));
        this.searchValue = driver.findElement(By.name("searchValue"));
        this.search = driver.findElement(By.name("search"));       
        this.logout = driver
                .findElement(By.xpath("//a[@href='/OMS/logout.htm']"));
    }

    // business
    // ------------------------------------------------------------------------------------------------//

    public AdministrationPage searchByLoginParameters(FieldFilter fieldFilter,
            Condition condition, String text) {

        setFieldFilter(fieldFilter.toString());
        setCondition(condition.toString());
        setTextinSearchField(text);
        searchCick();

        return new AdministrationPage(driver);

    }

    public CreateNewUserPage gotoCreateNewUserPage() {
        createNewUserCick();
        return new CreateNewUserPage(driver);
    }

    public LoginPage logout() {
        logoutClick();
        return new LoginPage(driver);
    }

    // functional
    // -----------------------------------------------

    public void setFieldFilter(String fieldFilter) {
        new Select(selectField).selectByVisibleText(fieldFilter);
    }

    public void setCondition(String condition) {
        new Select(selectCondition).selectByVisibleText(condition);
    }

    public void searchCick() {
        search.click();
    }

    public void setTextinSearchField(String text) {
        searchValue.click();
        searchValue.clear();
        searchValue.sendKeys(text);
    }

    public void logoutClick() {
        this.logout.click();
    }

    public void createNewUserCick() {
        this.createNewUser.click();
    }
    
//    public void clickDeleteUser(){
//        controlsAjax.delete.click();
//    }
//    
//    public AdministrationPage deleteUser(){
//        
//        
//        clickDeleteUser();
//        
//        driver.switchTo().alert().accept();
//        
//        return new AdministrationPage(driver);
//    }
    // ---------------------------------------------------------------------

    public String getNumberOfFoundUserString() {
        return getNumberOfFoundUser().getText();
    }

    public WebElement getNumberOfFoundUser() {
        return controlsAjax.usersFound;
    }

    public WebElement getCreateNewUser() {
        return createNewUser;
    }

    public WebElement getSelectField() {
        return selectField;
    }

    public WebElement getSelectCondition() {
        return selectCondition;
    }

    public WebElement getSearchValue() {
        return searchValue;
    }

    public WebElement getSearch() {
        return search;
    }

    public WebElement getLogout() {
        return logout;
    }
    
   
    public WebElement getFirstName() {
        return controlsAjax.firstName;
    }

    public WebElement getLastName() {
        return controlsAjax.lastName;
    }

    public WebElement getLogin() {
        return controlsAjax.login;
    }

    public WebElement getEdit() {
        return controlsAjax.edit;
    }

    public WebElement getDelete() {
        return controlsAjax.delete;
    }
    
    public String getFirstNameString() {
        return getFirstName().getText().trim();
    }
    
    public String getLastNameString(){
        return getLastName().getText().trim();
    }
    
    public String getLoginString(){
        return getLogin().getText().trim();
    }
    
}
