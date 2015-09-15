package com.softserve.edu.oms.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.data.UrlRepository.Urls;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.LoginPage;
import com.softserve.edu.oms.pages.LoginPage.LoginPageMessages;

public class LoginAdminTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

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
        driver.get(url);
        //
        //LoginPage loginpage = new LoginPage(driver);
        // Test Steps.
        // loginpage =
        // loginpage.unSuccesfulLogin(UserRepository.getInvalidUser());
        //AdminHomePage adminhomepage = loginpage.successAdminLogin(adminUser);
        AdminHomePage adminhomepage = (new LoginPage(driver)).successAdminLogin(adminUser);
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
        driver.get(url);
        LoginPage loginpage = new LoginPage(driver);
        // loginpage.getValidator(); // Bad Code.
        // Test Steps.
        loginpage = loginpage.unSuccesfulLogin(invalidUser);
        // Checking.
        Assert.assertEquals(LoginPageMessages.VALIDATOR_TEXT.toString(), loginpage.getValidatorText());
        // Return to previous state.
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
