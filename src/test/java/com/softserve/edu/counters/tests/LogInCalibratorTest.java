package com.softserve.edu.counters.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.counters.data.IUser;
import com.softserve.edu.counters.data.UrlRepository.Urls;
import com.softserve.edu.counters.data.UserRepository;
import com.softserve.edu.counters.pages.CalibratorHomePage;
import com.softserve.edu.counters.pages.LoginPage;
import com.softserve.edu.counters.pages.MainPage;

public class LogInCalibratorTest {

	@DataProvider
	public Object[][] calibratorProvider() {
		return new Object[][] { { Urls.LOCAL_HOST.toString(), UserRepository.getCalibratorUser() }, };
	}
	
	@Test(dataProvider = "calibratorProvider")
	public void checkCalibratorLogin(String url, IUser calibratorUser) {
		WebDriverUtils.get().loadPage(url);
		WebDriverUtils.get().getWebDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		CalibratorHomePage calibratorHomePage = ((new MainPage())
				.goToLoginPage())
				.successAdminLogin(calibratorUser);
		Assert.assertTrue(calibratorHomePage.getNameUser().getText().indexOf(calibratorUser.getLogin()) >= 0);
		calibratorHomePage.logout();
	}

	@DataProvider
	public Object[][] invalidProvider() {
		return new Object[][] { { Urls.LOCAL_HOST.toString(), UserRepository.getInvalidUser() }, };
	}
	
	@Test(dataProvider = "invalidProvider")
	public void checkNotCalibratorLogin(String url, IUser invalidUser) {
		WebDriverUtils.get().loadPage(url);
		WebDriverUtils.get().getWebDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		LoginPage loginPage = (new MainPage()).goToLoginPage().unSuccesfulLogin(invalidUser);
		Assert.assertTrue(loginPage.getIncorrectLoginMessage().isEnabled());
	}

}
