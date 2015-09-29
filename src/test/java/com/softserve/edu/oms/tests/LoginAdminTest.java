package com.softserve.edu.oms.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.tools.browsers.ABrowser;
import com.softserve.edu.atqc.tools.browsers.BrowserRepository;
import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.atqc.tools.loggers.LoggerRepository;
import com.softserve.edu.atqc.tools.loggers.LoggerWrapper;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UrlRepository.Urls;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.LoginPage;
import com.softserve.edu.oms.pages.LoginPage.LoginPageMessages;
import com.softserve.edu.oms.pages.StartLoginPage;

public class LoginAdminTest {

    @DataProvider(parallel = true)
    public Object[][] adminProvider() {
        return new Object[][] {
            { BrowserRepository.getFirefoxByTemporaryProfile(),
                    Urls.LOCAL_HOST.toString(), UserRepository.getAdminUser() },
            { BrowserRepository.getFirefoxByTemporaryProfile(),
                    Urls.LOCAL_HOST.toString(), UserRepository.getAdminUserYura() },
        };
    }

    @Test(dataProvider = "adminProvider")
    public void checkAdministratorLogin(ABrowser browser, String url, IUser adminUser) {
        LoggerWrapper.get().setLogger(LoggerRepository.getLog4jLogger()).infoLog("Thread ID= " + Thread.currentThread().getId()
                + "  User is " + adminUser.getLogin());
        System.out.println("\t+++Thread ID= " + Thread.currentThread().getId()
                + "  User is " + adminUser.getLogin());
        // Preconditions.
        // WebDriver driver = new FirefoxDriver();
        // old
        //WebDriverUtils.get().loadPage(url);
        //
        //LoginPage loginpage = new LoginPage(driver);
        // Test Steps.
        // loginpage =
        // loginpage.unSuccesfulLogin(UserRepository.getInvalidUser());
        //AdminHomePage adminhomepage = loginpage.successAdminLogin(adminUser);
        // old
        //AdminHomePage adminhomepage = (new LoginPage()).successAdminLogin(adminUser);
        AdminHomePage adminhomepage = StartLoginPage.load(browser, url).successAdminLogin(adminUser);
        // Checking.
        Assert.assertEquals(adminUser.getFirstname(), adminhomepage.getFirstnameText());
        Assert.assertEquals(adminUser.getLastname(), adminhomepage.getLastnameText());
        Assert.assertEquals(adminUser.getRole(), adminhomepage.getRoleText());
        // Return to previous state.
        adminhomepage.logout();
        System.out.println("TEST DONE \t+++Thread ID= " + Thread.currentThread().getId());
    }

    @DataProvider
    public Object[][] invalidProvider() {
        return new Object[][] { {
                BrowserRepository.getFirefoxByTemporaryProfile(),
                Urls.LOCAL_HOST.toString(),
                UserRepository.getInvalidUser() },
        };
    }

    @Test(dataProvider = "invalidProvider")
    public void checkInvalidLogin(ABrowser browser, String url, IUser invalidUser) {
        // Preconditions.
        // WebDriver driver = new FirefoxDriver();
        // old
        // WebDriverUtils.get().loadPage(url);
        // old
        // LoginPage loginpage = new LoginPage();
        LoginPage loginpage = StartLoginPage.load(browser, url);
        // loginpage.getValidator(); // Bad Code.
        // Test Steps.
        loginpage = loginpage.unSuccesfulLogin(invalidUser);
        // Checking.
        Assert.assertEquals(LoginPageMessages.VALIDATOR_TEXT.toString(), loginpage.getValidatorText());
        // Return to previous state.
        //WebDriverUtils.get().quit();
    }

    @AfterClass
    public void tearDown() {
        System.out.println("\t+++QUIT Thread ID= " + Thread.currentThread().getId());
        // TODO Remove WebDriverUtils from test file
        WebDriverUtils.quitAll();
    }

}
