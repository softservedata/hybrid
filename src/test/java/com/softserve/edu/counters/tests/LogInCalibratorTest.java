package com.softserve.edu.counters.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.tools.browsers.ABrowser;
import com.softserve.edu.atqc.tools.browsers.BrowserRepository;
import com.softserve.edu.atqc.tools.verifications.AssertWrapper;
import com.softserve.edu.counters.data.IUser;
import com.softserve.edu.counters.data.UrlRepository.Urls;
import com.softserve.edu.counters.data.UserRepository;
import com.softserve.edu.counters.pages.CalibratorHomePage;
import com.softserve.edu.counters.pages.LoginPageValidator;
import com.softserve.edu.counters.pages.LoginPageValidator.LoginPageMessages;
import com.softserve.edu.counters.pages.StartMainPage;

public class LogInCalibratorTest {

	@DataProvider
	public Object[][] calibratorProvider() {
		return new Object[][] {
				{ BrowserRepository.getDefault(), Urls.LOCAL_HOST.toString(), UserRepository.getCalibratorUser() }, };
	}

	@Test(dataProvider = "calibratorProvider")
	public void checkCalibratorLogin(ABrowser browser, String url, IUser calibratorUser) {

		CalibratorHomePage calibratorHomePage = StartMainPage.load(browser, url).goToLoginPage()
				.successAdminLogin(calibratorUser);
		AssertWrapper.get().forElement(calibratorHomePage.getNameUserText())
				.valueByPartialText(calibratorUser.getLogin());

		calibratorHomePage.logout();
		AssertWrapper.get().check();
	}

	@DataProvider
	public Object[][] invalidProvider() {
		return new Object[][] {
				{ BrowserRepository.getDefault(), Urls.LOCAL_HOST.toString(), UserRepository.getInvalidUser() }, };
	}

	@Test(dataProvider = "invalidProvider")
	public void checkNotCalibratorLogin(ABrowser browser, String url, IUser invalidUser) {

		LoginPageValidator loginPageValidator = StartMainPage.load(browser, url).goToLoginPage()
				.unSuccesfulLogin(invalidUser);
		AssertWrapper.get().forElement(loginPageValidator.getValidatorText())
				.valueMatch(LoginPageMessages.VALIDATOR_TEXT.toString());
		AssertWrapper.get().check();
	}

}
