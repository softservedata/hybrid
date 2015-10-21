package com.softserve.edu.oms.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.tools.browsers.ABrowser;
import com.softserve.edu.atqc.tools.browsers.BrowserRepository;
import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.atqc.tools.verifications.AssertWrapper;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UrlRepository.Urls;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.AdministrationPage.AdministrationPageConditions;
import com.softserve.edu.oms.pages.AdministrationPage.AdministrationPageFields;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.pages.HomePage;
import com.softserve.edu.oms.pages.StartLoginPage;

public final class FindTest {

    @DataProvider//(parallel = true)
    public Object[][] existUsers() {
        return new Object[][] {
            { BrowserRepository.getDefault(),
                    Urls.LOCAL_HOST.toString(), UserRepository.getAdminUser() },
        };
    }

    //@Test(dataProvider = "existUsers")
    public void checkExistUsersFind(ABrowser browser, String url, IUser existUser) {
        // PreCondition
        AdministrationPage administrationPage = StartLoginPage.load(browser, url) 
                .successAdminLogin(UserRepository.getAdminUser())
                .gotoAdministrationPage();
        // Test Operation
        administrationPage.searchByLoginName(AdministrationPageFields.LOGIN_NAME,
                AdministrationPageConditions.EQUALS, existUser);
        // Save Actual Result. Preparation for Checking
        AssertWrapper.get()
                .forElement(administrationPage.getFirstname().getText())
                    .valueMatch(existUser.getFirstname())
                    .next()
                .forElement(administrationPage.getLogin().getText())
                    .valueMatch(existUser.getLogin());
        // Return to Previous State
        administrationPage.logout();
        // Checking
        AssertWrapper.get().check();
    }

    @DataProvider//(parallel = true)
    public Object[][] newUsers() {
        return new Object[][] {
            { BrowserRepository.getDefault(),
                    Urls.LOCAL_HOST.toString(), UserRepository.getNewUser() },
        };
    }

    @Test(dataProvider = "newUsers")
    public void checkNewUserCreate(ABrowser browser, String url, IUser newUser) {
        // PreCondition
        CreateNewUserPage createNewUserPage = StartLoginPage.load(browser, url)
                .successAdminLogin(UserRepository.getAdminUser())
                .gotoAdministrationPage()
                .gotoCreateNewUserPage();
        // Test Operation
        AdministrationPage administrationPage = createNewUserPage
                .createNewUser(newUser);
        administrationPage.searchByLoginName(AdministrationPageFields.LOGIN_NAME,
                AdministrationPageConditions.EQUALS, newUser);
        // Save Actual Result. Preparation for Checking
        AssertWrapper.get()
                .forElement(administrationPage.getFirstname().getText())
                    .valueMatch(newUser.getFirstname())
                    .next()
                .forElement(administrationPage.getLogin().getText())
                    .valueMatch(newUser.getLogin());
        // Test Operation
        HomePage homePage = administrationPage.logout()
                .successLogin(newUser);
        // Save Actual Result. Preparation for Checking
        AssertWrapper.get()
                .forElement(homePage.getFirstname().getText())
                    .valueMatch(newUser.getFirstname())
                    .next()
                .forElement(homePage.getLastname().getText())
                    .valueMatch(newUser.getLastname())
                    .next()
                .forElement(homePage.getRole().getText())
                    .valueMatch(newUser.getRole());
        // Test Operation
        administrationPage = homePage.logout()
                .successAdminLogin(UserRepository.getAdminUser())
                .gotoAdministrationPage();
        // Return to Previous State
        administrationPage.deleteByLoginName(newUser);
        // Save Actual Result. Preparation for Checking
//        AssertWrapper.get()
//                .forElement(administrationPage.getAlert())
//                .valueMatchInLastMessage(
//                        MessageRepository.AdministrationPageNotes.ALERT_DELETE_MESSAGE
//                                .toString());
        administrationPage.logout();
        // Checking
        AssertWrapper.get().check();
    }

    @AfterClass
    public void tearDown() {
        WebDriverUtils.quitAll();
    }

}
