package com.softserve.edu.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.softserve.edu.data.UrlRepository.Urls;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.pages.AdminHomePage;
import com.softserve.edu.pages.LoginPage;

public class LoginAdminTest {
    WebDriver driver = new FirefoxDriver();

    @Test
    public void checkAdministratorLogin() {
        // Preconditions.
        // WebDriver driver = new FirefoxDriver();
        driver.get(Urls.LOCAL_HOST.toString());
        //
        LoginPage loginpage = new LoginPage(driver);
        // Test Steps.
        // loginpage =
        // loginpage.unSuccesfulLogin(UserRepository.getInvalidUser());
        AdminHomePage adminhomepage = loginpage.successAdminLogin(UserRepository.getAdminUser());
        // Checking.
        Assert.assertEquals(UserRepository.getAdminUser().getFirstname(),
                adminhomepage.getLoginedFirstname());
        Assert.assertEquals(UserRepository.getAdminUser().getLastname(),
                adminhomepage.getLoginedLastname());
        Assert.assertEquals(UserRepository.getAdminUser().getRole(), adminhomepage.getLoginedRole());
        // Return to previous state.
        adminhomepage.logout();
    }

    @Test
    public void checkInvalidLogin() {
        // Preconditions.
        // WebDriver driver = new FirefoxDriver();
        driver.get(Urls.LOCAL_HOST.toString());
        LoginPage loginpage = new LoginPage(driver);
        // Test Steps.
         loginpage =loginpage.unSuccesfulLogin(UserRepository.getInvalidUser());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
