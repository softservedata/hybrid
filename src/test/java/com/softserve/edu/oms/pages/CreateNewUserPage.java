package com.softserve.edu.oms.pages;

import org.openqa.selenium.Keys;

import com.softserve.edu.atqc.tools.controls.Button;
import com.softserve.edu.atqc.tools.controls.IButton;
import com.softserve.edu.atqc.tools.controls.ILink;
import com.softserve.edu.atqc.tools.controls.ITextField;
import com.softserve.edu.atqc.tools.controls.Label;
import com.softserve.edu.atqc.tools.controls.Link;
import com.softserve.edu.atqc.tools.controls.TextField;
import com.softserve.edu.oms.data.IUser;

public class CreateNewUserPage {

    public static enum RegionID {
        EAST("East"),
        NORTH("North"),
        SOUTH("South"),
        WEST("West");
        private String regionID;

        private RegionID(String regionID) {
            this.regionID = regionID;
        }

        @Override
        public String toString() {
            return regionID;
        }
    }

    public static enum RoleID {
        ADMINISTRATOR("Administrator"),
        CUSTOMER("Customer"),
        MERCHANDISER("Merchandiser"),
        SUPERVISOR("Supervisor");
        private String roleID;

        private RoleID(String roleID) {
            this.roleID = roleID;
        }

        @Override
        public String toString() {
            return roleID;
        }
    }

    private class CreateNewUserPageUIMap {
        public final ILink logout;
        public final ITextField login;
        public final ITextField firstname;
        public final ITextField lastname;
        public final ITextField password;
        public final ITextField confirmPassword;
        public final ITextField email;
        //private final ISelect region;
        //private final IRadioButtonGroup role;
        public final IButton create;
        public final IButton cancel;

        public CreateNewUserPageUIMap() {
            this.logout = Link.get().getByXpath("//a[@href='/OMS/logout.htm']");
            this.login = TextField.get().getById("login");
            this.firstname = TextField.get().getById("firstName");
            this.lastname = TextField.get().getById("lastName");
            this.password = TextField.get().getById("password");
            this.confirmPassword = TextField.get().getById("confirmPassword");
            this.email = TextField.get().getById("email");
            //this.region = Select.getById("regionID");
//            this.role = RadioButtonGroup.get()
//                    .addFirst(RadioButtonLight.get().addRadioButton(RadioButton.getById("roleID1"))
//                            .addLabel(Label.getByXpath("//label[text()='Administrator']")).build())
//                    .addNext(RadioButtonLight.get().addRadioButton(RadioButton.getById("roleID2"))
//                            .addLabel(Label.getByXpath("//label[text()='Customer']")).build())
//                    .addNext(RadioButtonLight.get().addRadioButton(RadioButton.getById("roleID3"))
//                            .addLabel(Label.getByXpath("//label[text()='Merchandiser']")).build())
//                    .addNext(RadioButtonLight.get().addRadioButton(RadioButton.getById("roleID4"))
//                            .addLabel(Label.getByXpath("//label[text()='Supervisor']")).build())
//                    .build();
            this.create = Button.get().getByXpath("//input[@value='Create']");
            this.cancel = Button.get().getByXpath("//input[@value='Cancel']");
        }

        public boolean isDisableValidators() {
            boolean isValidatorInvisible = true;
            isValidatorInvisible = isValidatorInvisible && Label.get().isInvisibleWebElementById("emailError");
            // TODO Add All Validators.
            return isValidatorInvisible;
        }

    }

    // Elements
    private CreateNewUserPageUIMap controls;
    // Alert Elements
    //private IAlertLight controlsAlertLight;

    public CreateNewUserPage() {
        controls = new CreateNewUserPageUIMap();
        //controlsAlertLight = AlertLight.getWithScreen();
    }

    
    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void setLogin(String login) {
        this.controls.login.sendKeys(login);
    }

    public void setFirstname(String firstname) {
        this.controls.firstname.sendKeys(firstname);
    }

    public void setLastname(String lastname) {
        this.controls.lastname.sendKeys(lastname);
    }

    public void setPassword(String password) {
        this.controls.password.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        this.controls.confirmPassword.sendKeys(confirmPassword);
    }

    public void setEmail(String email) {
        this.controls.email.sendKeys(email);
        // TODO Wrap Keys
        this.controls.email.sendKeys(Keys.ARROW_RIGHT.toString());
    }

//    public void setRegion(RegionID region) {
//        controls.region.selectByText(region.toString());
//    }

//    public void setRole(RoleID role) {
//        controls.role.selectByPartialText(role.toString());
//    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public ITextField getLogin() {
        return this.controls.login;
    }

    public ITextField getFirstname() {
        return this.controls.firstname;
    }

    public ITextField getLastname() {
        return this.controls.lastname;
    }

    public ITextField getPassword() {
        return this.controls.password;
    }

    public ITextField getConfirmPassword() {
        return this.controls.confirmPassword;
    }

    public ITextField getEmail() {
        return this.controls.email;
    }

    // public ISelect getRegion();
    // public IRadioButtonGroup getRole(); 

//    public IAlert getAlert() {
//        return controlsAlertLight;
//    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // TODO
    RegionID getRegionByPartialText(IUser user) {
    //private RegionID getRegionByPartialText(IUser user) {
        RegionID regionID = RegionID.EAST;
        for (RegionID region : RegionID.values()) {
            if ((region.toString().indexOf(user.getRegion()) >= 0)
                    || (user.getRegion().indexOf(region.toString()) >= 0)) {
                regionID = region;
                break;
            }
        }
        return regionID;
    }

    // TODO
    RoleID getRoleByPartialText(IUser user) {
    //private RoleID getRoleByPartialText(IUser user) {
        RoleID roleID = RoleID.CUSTOMER;
        for (RoleID role : RoleID.values()) {
            if ((role.toString().indexOf(user.getRole()) >= 0) || (user.getRole().indexOf(role.toString()) >= 0)) {
                roleID = role;
                break;
            }
        }
        return roleID;
    }

    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public AdministrationPage createNewUser(IUser user) {
        setLogin(user.getLogin());
        setFirstname(user.getFirstname());
        setLastname(user.getLastname());
        setPassword(user.getPassword());
        setConfirmPassword(user.getPassword());
        setEmail(user.getEmail());
        //setRegion(getRegionByPartialText(user));
        //setRole(getRoleByPartialText(user));
        if (controls.isDisableValidators()) {
            controls.create.click();
        } else {
            // TODO Logs User Cannot be Created
            controls.cancel.click();
            // TODO throw Exception Test Failed
        }
        return new AdministrationPage();
    }

    public LoginPage logout() {
        controls.logout.click();
        // controlsAlertLight.alertAccept();
        return new LoginPage();
    }

}