package com.softserve.edu.oms.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UrlRepository.Urls;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.LoginPage;
import com.softserve.edu.oms.pages.LoginPage.LoginPageMessages;

public class LoginAdminTest {

    @DataProvider
    public Object[][] adminProvider() {
        return new Object[][] {
            { Urls.LOCAL_HOST.toString(), UserRepository.getAdminUser() },
            { Urls.LOCAL_HOST.toString(), UserRepository.getAdminUserYura() },
        };
    }

    @Test(dataProvider = "adminProvider")
    public void checkAdministratorLogin(String url, IUser adminUser) {
        // Preconditions.
        // WebDriver driver = new FirefoxDriver();
        WebDriverUtils.get().loadPage(url);
        //
        //LoginPage loginpage = new LoginPage(driver);
        // Test Steps.
        // loginpage =
        // loginpage.unSuccesfulLogin(UserRepository.getInvalidUser());
        //AdminHomePage adminhomepage = loginpage.successAdminLogin(adminUser);
        AdminHomePage adminhomepage = (new LoginPage()).successAdminLogin(adminUser);
        // Checking.
        Assert.assertEquals(adminUser.getFirstname(), adminhomepage.getFirstnameText());
        Assert.assertEquals(adminUser.getLastname(), adminhomepage.getLastnameText());
        Assert.assertEquals(adminUser.getRole(), adminhomepage.getRoleText());
        // Return to previous state.
        adminhomepage.logout();
    }

    @DataProvider
    public Object[][] invalidProvider() {
        return new Object[][] { {
                Urls.LOCAL_HOST.toString(),
                UserRepository.getInvalidUser() },
        };
    }

    @Test(dataProvider = "invalidProvider")
    public void checkInvalidLogin(String url, IUser invalidUser) {
        // Preconditions.
        // WebDriver driver = new FirefoxDriver();
        WebDriverUtils.get().loadPage(url);
        LoginPage loginpage = new LoginPage();
        // loginpage.getValidator(); // Bad Code.
        // Test Steps.
        loginpage = loginpage.unSuccesfulLogin(invalidUser);
        // Checking.
        Assert.assertEquals(LoginPageMessages.VALIDATOR_TEXT.toString(), loginpage.getValidatorText());
        // Return to previous state.
    }

    @AfterClass
    public void tearDown() {
        WebDriverUtils.get().getWebDriver().quit();
    }

}
