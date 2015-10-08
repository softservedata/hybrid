package com.softserve.edu.oms.pages;

import com.softserve.edu.atqc.tools.controls.ILabel;
import com.softserve.edu.atqc.tools.controls.ILink;
import com.softserve.edu.atqc.tools.controls.Label;
import com.softserve.edu.atqc.tools.controls.Link;

public class HomePage {

    private class HomePageUIMap {
        public final ILabel firstname;
        public final ILabel lastname;
        public final ILabel role;
        public final ILink logout;

        public HomePageUIMap() {
            this.firstname = Label.get()
                    .getByXpath("//tbody/tr/td[text( )='First name']/following-sibling::td");
            this.lastname = Label.get()
                    .getByXpath("//tbody/tr/td[text( )='Last name']/following-sibling::td");
            this.role = Label.get()
                    .getByXpath("//tbody/tr/td[text( )='Role']/following-sibling::td");
            this.logout = Link.get()
                    .getByXpath("//a[@href='/OMS/logout.htm']");
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Elements
    private HomePageUIMap controls;

    protected HomePage() {
        this.controls = new HomePageUIMap();
    }

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void logoutClick() {
        this.controls.logout.click();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public ILabel getFirstname() {
        return this.controls.firstname;
    }

    public ILabel getLastname() {
        return this.controls.lastname;
    }

    public ILabel getRole() {
        return this.controls.role;
    }

    public ILink getLogout() {
        return this.controls.logout;
    }

    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public String getFirstnameText() {
        return getFirstname().getText();
    }

    public String getLastnameText() {
        return getLastname().getText();
    }

    public String getRoleText() {
        return getRole().getText();
    }

    public LoginPage logout() {
        logoutClick();
        return new LoginPage();
    }
    
}
