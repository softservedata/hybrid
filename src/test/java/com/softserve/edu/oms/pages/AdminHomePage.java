package com.softserve.edu.oms.pages;

import com.softserve.edu.atqc.tools.controls.ILink;
import com.softserve.edu.atqc.tools.controls.Link;

public class AdminHomePage extends HomePage {
    
    private class AdminHomePageUIMap {
        public final ILink administration;

        public AdminHomePageUIMap() {
            this.administration = Link.get()
                    .getByPartialLinkText("Administration");
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Elements
    private AdminHomePageUIMap controls;

    public AdminHomePage() {
        super();
        this.controls = new AdminHomePageUIMap();
    }

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void administrationClick() {
        this.controls.administration.click();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public ILink getAdministration() {
        return this.controls.administration;
    }

    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public AdministrationPage gotoAdministrationPage() {
        administrationClick();
        return new AdministrationPage();
    }    
    
}
