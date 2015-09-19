package com.softserve.edu.counters.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.counters.data.IUser;
import com.softserve.edu.counters.data.UserRepository;
import com.softserve.edu.counters.data.UrlRepository.Urls;
import com.softserve.edu.counters.pages.CalibratorHomePage;
import com.softserve.edu.counters.pages.LoginPage;
import com.softserve.edu.counters.pages.MainPage;

public class LogInCalibratorTest {

	WebDriver driver;

	@BeforeClass
	public void oneTimeSetUp() {
		ProfilesIni profileIni = new ProfilesIni();
		FirefoxProfile profile = profileIni.getProfile("default");
		profile.setAcceptUntrustedCertificates(true);
		driver = new FirefoxDriver(profile);

	}

	@DataProvider
	public Object[][] calibratorProvider() {
		return new Object[][] { { Urls.LOCAL_HOST.toString(), UserRepository.getCalibratorUser() }, };
	}

	@Test(dataProvider = "calibratorProvider")
	public void checkCalibratorLogin(String url, IUser calibratorUser) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CalibratorHomePage calibratorHomePage = ((new MainPage(driver)).goToLoginPage())
				.successAdminLogin(calibratorUser);
		Assert.assertEquals(calibratorHomePage.getNameUser().getText(), // -----------------------
				"(" + calibratorUser.getLogin() + ")");
		calibratorHomePage.logout();

	}

	@DataProvider
	public Object[][] invalidProvider() {
		return new Object[][] { { Urls.LOCAL_HOST.toString(), UserRepository.getInvalidUser() }, };
	}

	@Test(dataProvider = "calibratorProvider")
	public void checkNotCalibratorLogin(String url, IUser invalidUser) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoginPage loginPage = (new MainPage(driver)).goToLoginPage().unSuccesfulLogin(invalidUser);
		Assert.assertTrue(loginPage.getIncorrectLoginMessage().isEnabled());
	}

}
