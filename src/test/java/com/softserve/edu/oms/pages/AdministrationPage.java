package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.atqc.tools.controls.ILabel;
import com.softserve.edu.atqc.tools.controls.ILink;
import com.softserve.edu.atqc.tools.controls.ITextField;
import com.softserve.edu.atqc.tools.controls.Label;
import com.softserve.edu.atqc.tools.controls.Link;
import com.softserve.edu.atqc.tools.controls.TextField;
import com.softserve.edu.oms.data.IUser;

public class AdministrationPage {

    public static enum AdministrationPageFields {
        ALL_COLUMNS("All Columns"),
        FIRST_NAME("First Name"),
        LAST_NAME("Last Name"),
        ROLE("Role"),
        LOGIN_NAME("Login Name");
        private String field;

        private AdministrationPageFields(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }

    public static enum AdministrationPageConditions {
        EQUALS("equals"),
        NOT_EQUALS_TO("not equals to"),
        STARTS_WITH("starts with"),
        CONTAINS("contains"),
        DOES_NOT_CONTAIN("does not contain");
        private String field;

        private AdministrationPageConditions(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }

    private class AdministrationPageUIMap {
        public final ILink createNewUser;
        //public final ISelect field;
        //public final ISelect condition;
        public final ITextField searchField;
        public final ILink logout;

        public AdministrationPageUIMap() {
            this.searchField = TextField.get().getById("searchField");
            //this.field = Select.getById("field");
            //this.condition = Select.getById("condition");
            this.createNewUser = Link.get().getByPartialLinkText("Create New User");
            this.logout = Link.get().getByXpath("//a[@href='/OMS/logout.htm']");
        }
    }

    private class AdministrationPageUIMapTable {
        public final ILabel usersFound;
        public final ILabel firstname;
        public final ILabel lastname;
        public final ILabel login;
        public final ILink delete;

        public AdministrationPageUIMapTable() {
            // TODO if Load Table Complete
            this.usersFound = Label.get().getById("usersFound");
            if (Integer.parseInt(usersFound.getText()) > 0) {
                this.firstname = Label.get().getByXpath("//tbody/tr[1]/td[1]");
                this.lastname = Label.get().getByXpath("//tbody/tr[1]/td[2]");
                this.login = Label.get().getByXpath("//tbody/tr[1]/td[3]");
                this.delete = Link.get().getByXpath("//tbody/tr[1]/td[7]/a");
            } else {
                this.firstname = Label.get().getByXpath("//thead/tr[1]/th[1]");
                this.lastname = Label.get().getByXpath("//thead/tr[1]/th[2]");
                this.login = Label.get().getByXpath("//thead/tr[1]/th[3]");
                this.delete = Link.get().getByXpath("//thead/tr[1]/th[1]");
            }
        }

        public AdministrationPageUIMapTable(String login) {
            // TODO if Load Table Complete
            this.usersFound = Label.get().getById("usersFound");
            //
            this.login = Label.get().getByXpath("//tbody//td[3][text()='" + login + "']");
            this.lastname = Label.get().getByXpath("//tbody//td[3][text()='" + login + "']/preceding-sibling::td[1]");
            this.firstname = Label.get().getByXpath("//tbody//td[3][text()='" + login + "']/preceding-sibling::td[2]");
            this.delete = Link.get().getByXpath("//tbody//td[3][text()='" + login + "']/following-sibling::td[4]/a");
        }

    }

    // Elements
    private AdministrationPageUIMap controls;
    // AJAX Elements
    private AdministrationPageUIMapTable controlsTable;
    // Alert Elements
    //private IAlertLight controlsAlert = null;

    public AdministrationPage() {
        controls = new AdministrationPageUIMap();
        controlsTable = new AdministrationPageUIMapTable();
    }

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // getters controls

    public ILink getCreateNewUser() {
        return this.controls.createNewUser;
    }

//    public ISelect getField() {
//        return this.controls.field;
//    }

//    public ISelect getCondition() {
//        return this.controls.condition;
//    }

    public ITextField getSearchField() {
        return this.controls.searchField;
    }

    public ILink getLogout() {
        return this.controls.logout;
    }

    // getters controlsTable

    public ILabel getUsersFound() {
        return this.controlsTable.usersFound;
    }

    public ILabel getFirstname() {
        return this.controlsTable.firstname;
    }

    public ILabel getLastname() {
        return this.controlsTable.lastname;
    }

    public ILabel getLogin() {
        return this.controlsTable.login;
    }

    public ILink getDelete() {
        return this.controlsTable.delete;
    }

    // getters controlsAlert

    //public IAlert getAlert() {
    //  if (this.controlsAlert != null) {
    //  return this.controlsAlert;
    //  }
    //}

    // setters controls

    public void createNewUserClick() {
        this.controls.createNewUser.click();
    }

    public void selectColumnFields(AdministrationPageFields field) {
        //this.controls.field.selectByVisibleText(field.toString());
        new Select(WebDriverUtils.get().getWebDriver().findElement(By.id("field")))
            .selectByVisibleText(field.toString());
    }

    public void selectMatchConditions(AdministrationPageConditions condition) {
        //this.controls.condition.selectByVisibleText(condition.toString());
        new Select(WebDriverUtils.get().getWebDriver().findElement(By.id("condition")))
            .selectByVisibleText(condition.toString());
    }

    public void searchFieldClear() {
        this.controls.searchField.clear();
    }

    public void searchFieldClick() {
        this.controls.searchField.click();
    }
    
    public void searchFieldSendKeys(String text) {
        this.controls.searchField.sendKeys(text);
    }

    public void logoutClick() {
        this.controls.logout.click();
    }
    
    // setters controlsTable

    public void resetTable() {
        if (this.controlsTable.firstname.isStatelessOf()) {
            controlsTable = new AdministrationPageUIMapTable();
        }
    }
    
    public void resetTable(String login) {
        if (this.controlsTable.firstname.isStatelessOf()) {
            controlsTable = new AdministrationPageUIMapTable(login);
        }
    }

    public void deleteClick() {
        this.controlsTable.delete.click();
        // this.controlsAlert = new Alert();
    }

    // setters controlsAlert

    public void alertAccept() {
//      if (this.controlsAlert != null) {
//      this.controlsAlert.click();
//      this.controlsAlert = null;
//        controls = new AdministrationPageUIMap();
//        controlsAjax = new AdministrationPageUIMapAjax();
//  }
        WebDriverUtils.get().getWebDriver().switchTo().alert().dismiss();
    }

    public void alertDismiss() {
//      if (this.controlsAlert != null) {
//          this.controlsAlert.click();
//          this.controlsAlert = null;
//      }
    }   

    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public CreateNewUserPage gotoCreateNewUserPage() {
        createNewUserClick();
        return new CreateNewUserPage();
    }

    public void searchByLoginName(AdministrationPageFields field,
            AdministrationPageConditions condition, IUser user) {
        selectColumnFields(field);
        selectMatchConditions(condition);
        searchFieldSendKeys(user.getLogin());
        // Initialize Table Elements
        resetTable(user.getLogin());
    }

    public void deleteByLoginName(IUser user) {
        searchByLoginName(AdministrationPageFields.LOGIN_NAME,
                AdministrationPageConditions.STARTS_WITH, user);
        deleteClick();
        // TODO Develop AlertWrapper
        alertAccept();
        // TODO Because alert().dismiss()
        // resetTable();
    }

    public LoginPage logout() {
        logoutClick();
        return new LoginPage();
    }

}
