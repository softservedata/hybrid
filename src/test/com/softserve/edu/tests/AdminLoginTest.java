package com.softserve.edu.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.softserve.edu.pages.AdminHomePage;
import com.softserve.edu.pages.LoginPage;
import com.softserve.edu.pages.StartPage;
import com.softserve.edu.testData.UrlRepository;
import com.softserve.edu.testData.UrlRepository.Urls;
import com.softserve.edu.testData.UserRepository;

public class AdminLoginTest {
WebDriver driver = new FirefoxDriver();

@Test
public void AdministratorLogin(){
	driver.get(Urls.LOCAL_HOST.toString());
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	StartPage startPage = new StartPage(driver);
	LoginPage loginPage = startPage.gotoLoginPage();
	AdminHomePage adminHomePage = loginPage.successAdminLogin(UserRepository.getAdminUser());
	
	Assert.assertEquals(true, adminHomePage.getPageHeader().isDisplayed());
	
	
}
@AfterClass
public void tearDown(){
	driver.quit();
}
}
