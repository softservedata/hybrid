package com.softserve.edu.oms.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UrlRepository.Urls;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.AdministrationPage.Condition;
import com.softserve.edu.oms.pages.AdministrationPage.FieldFilter;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.pages.CreateNewUserPage.CreateNewUserPageMessages;
import com.softserve.edu.oms.pages.HomePage;
import com.softserve.edu.oms.pages.LoginPage;

public class AdminTests {

    WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }

    @DataProvider
    public Object[][] adminProviderEmptyFields() {
        return new Object[][] { { Urls.LOCAL_HOST.toString(),
                UserRepository.getAdminUser() }, };
    }

    @Test(dataProvider = "adminProviderEmptyFields")
    public void checkAlertEmptyFieldCreateUser(String url, IUser admin) {

        driver.get(url);
        //
        LoginPage loginpage = new LoginPage(driver);
        // Test Steps.

        AdminHomePage adminhomepage = loginpage.successAdminLogin(admin);
        AdministrationPage administrationPage = adminhomepage
                .gotoAdministrationPage();

        CreateNewUserPage createNewUserPage = administrationPage
                .gotoCreateNewUserPage();

        createNewUserPage.buttonSubmitClick();

        Assert.assertEquals(
                CreateNewUserPageMessages.CREATE_USER_ALL_FIELDS_EMPTY
                        .toString(),
                createNewUserPage.getTextFromAlert());
        
        createNewUserPage.logout();

    }

    @DataProvider
    public Object[][] adminProviderUserInUse() {
        return new Object[][] { { Urls.LOCAL_HOST.toString(),
                UserRepository.getAdminUser(), UserRepository.getUser() }, };
    }

   // @Test(dataProvider = "adminProviderUserInUse")
    public void checkCreatingUserLoginInUse(String url, IUser admin,
            IUser user) {

        driver.get(url);
        //
        LoginPage loginpage = new LoginPage(driver);
        // Test Steps.

        AdminHomePage adminhomepage = loginpage.successAdminLogin(admin);
        AdministrationPage administrationPage = adminhomepage
                .gotoAdministrationPage();

        CreateNewUserPage createNewUserPage = administrationPage
                .gotoCreateNewUserPage();

        createNewUserPage.setUserLoginInUse(user);

        Assert.assertEquals(createNewUserPage.getUserLoginInUseMessage(user),
                createNewUserPage.getNameErrorString());

    }

    @DataProvider
    public Object[][] adminProvider0() {
        return new Object[][] { { Urls.LOCAL_HOST.toString(),
                UserRepository.getAdminUser(), FieldFilter.LOGIN_NAME,
                Condition.EQUALS, UserRepository.getUser(), } };
    }

    // @Test(dataProvider = "adminProvider0")
    public void checkFoundNumberUsers(String url, IUser admin,
            FieldFilter fieldFilter, Condition condition, IUser user,
            String numUser) {

        driver.get(url);

        //
        LoginPage loginpage = new LoginPage(driver);
        // Test Steps.
        AdminHomePage adminhomepage = loginpage.successAdminLogin(admin);
        AdministrationPage administrationPage = adminhomepage
                .gotoAdministrationPage();

        administrationPage = administrationPage.searchByLoginParameters(
                fieldFilter, condition, user.getLogin());

        Assert.assertEquals("1",
                administrationPage.getNumberOfFoundUserString());

        administrationPage.logout();
    }

    @DataProvider
    public Object[][] adminProvider1() {
        return new Object[][] { { Urls.LOCAL_HOST.toString(),
                UserRepository.getAdminUser(), FieldFilter.LOGIN_NAME,
                Condition.EQUALS, UserRepository.getUser() } };
    }

    // @Test(dataProvider = "adminProvider1")
    public void checkSearchUserByLogin(String url, IUser admin,
            FieldFilter fieldFilter, Condition condition, IUser user) {

        driver.get(url);

        //
        LoginPage loginpage = new LoginPage(driver);
        // Test Steps.
        AdminHomePage adminhomepage = loginpage.successAdminLogin(admin);
        AdministrationPage administrationPage = adminhomepage
                .gotoAdministrationPage();

        administrationPage = administrationPage.searchByLoginParameters(
                fieldFilter, condition, user.getLogin());

        Assert.assertEquals(administrationPage.getFirstNameString(),
                user.getFirstname());
        Assert.assertEquals(administrationPage.getLastNameString(),
                user.getLastname());
        Assert.assertEquals(administrationPage.getLoginString(),
                user.getLogin());

        administrationPage.logout();

    }

    @DataProvider
    public Object[][] adminProvider2() {
        return new Object[][] { { Urls.LOCAL_HOST.toString(),
                UserRepository.getAdminUser(), UserRepository.getNewUser() }, };
    }

    // @Test(dataProvider = "adminProvider2")
    public void checkCreatingUser(String url, IUser admin, IUser newUser) {

        driver.get(url);

        LoginPage loginpage = new LoginPage(driver);
        // Test Steps.

        AdminHomePage adminhomepage = loginpage.successAdminLogin(admin);
        AdministrationPage administrationPage = adminhomepage
                .gotoAdministrationPage();

        CreateNewUserPage createNewUserPage = administrationPage
                .gotoCreateNewUserPage();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        administrationPage = createNewUserPage.createUser(newUser);
        loginpage = administrationPage.logout();

        HomePage userHomePage = loginpage.successUserLogin(newUser);

        Assert.assertEquals(newUser.getFirstname(),
                userHomePage.getFirstnameText());
        Assert.assertEquals(newUser.getLastname(),
                userHomePage.getLastnameText());
        Assert.assertEquals(newUser.getRole(), userHomePage.getRoleText());

        userHomePage.logout();

    }

    void gotoAdminHomePage() {

    }

    @DataProvider
    public Object[][] adminProvider3() {
        return new Object[][] {
                { Urls.LOCAL_HOST.toString(), UserRepository.getAdminUser(),
                        FieldFilter.LOGIN_NAME, Condition.EQUALS } };
    }

    // @Test(dataProvider = "adminProvider3")
    public void checkCreateReport(String url, IUser admin,
            FieldFilter fieldFilter, Condition condition) {

        FirefoxProfile firefoxProfile = new FirefoxProfile();
        setProperty(firefoxProfile);

        driver = new FirefoxDriver(firefoxProfile);

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        //
        LoginPage loginpage = new LoginPage(driver);
        // Test Steps.
        AdminHomePage adminhomepage = loginpage.successAdminLogin(admin);
        adminhomepage.gotoAdministrationPage();

        driver.findElement(By.partialLinkText("create report")).click();
        driver.findElement(By.partialLinkText("(Save report)")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        driver.findElement(By.id("download")).click();

        // administrationPage.logout();
    }

    public void setProperty(FirefoxProfile firefoxProfile) {

        // Set profile to accept untrusted certificates
        firefoxProfile.setAcceptUntrustedCertificates(true);

        // Set profile to not assumet certificate issuer is untrusted
        firefoxProfile.setAssumeUntrustedCertificateIssuer(false);

        // Set download location and file types
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference(
                "browser.download.manager.showWhenStarting", false);
        firefoxProfile.setPreference("browser.download.dir", "D:\\tmp");
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/pdf,application/csv,application/vnd.ms-excel");

        // Set to false so popup not displayed when download finished.
        firefoxProfile.setPreference(
                "browser.download.manager.showAlertOnComplete", false);

        firefoxProfile.setPreference(
                "browser.download.manager.showAlertOnComplete", false);
        firefoxProfile.setPreference(
                "browser.download.manager.showWhenStartinge", false);
        // firefoxProfile.setPreference("browser.download.panel.shown", false);
        // firefoxProfile.setPreference("browser.download.useToolkitUI", true);
        // firefoxProfile.setPreference(
        // "plugin.disable_full_page_plugin_for_types",
        // "application/pdf,application/vnd.adobe.xfdf,application/vnd.fdf,application/vnd.adobe.xdp+xml");
        // Set this to true to disable the pdf opening
        // firefoxProfile.setPreference("pdfjs.disabled", true);

    }
}
