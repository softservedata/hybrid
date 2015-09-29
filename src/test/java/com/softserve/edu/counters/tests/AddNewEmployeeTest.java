package com.softserve.edu.counters.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.counters.data.IUser;
import com.softserve.edu.counters.data.UrlRepository.Urls;
import com.softserve.edu.counters.data.UserRepository;
import com.softserve.edu.counters.pages.CalibratorEmployeeHomePage;
import com.softserve.edu.counters.pages.EmployeePage;
import com.softserve.edu.counters.pages.LoginPage;
import com.softserve.edu.counters.pages.MainPage;

public class AddNewEmployeeTest {

	@DataProvider
	public Object[][] employeeProvider() {
		return new Object[][] {
				{ Urls.LOCAL_HOST.toString(), UserRepository.getCalibratorUser(), UserRepository.getEmployee() }, };
	}

	 @Test(dataProvider = "employeeProvider")
	public void addNewEmployee(String url, IUser calibrator, final IUser employee) {
		WebDriverUtils.get().loadPage(url);
		WebDriverUtils.get().getWebDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		EmployeePage employeePage = (((new MainPage()).goToLoginPage()).successAdminLogin(calibrator))
				.goToEmployeePage();
		employeePage.successAddEmployee(employee);

		WebDriverUtils.get().getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		(new WebDriverWait(WebDriverUtils.get().getWebDriver(), 10))
				.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal-dialog']")));
		WebDriverUtils.get().getWebDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		employeePage.setFieldForSearchLogin(employee.getLogin());
		Assert.assertEquals(employeePage.getLoginFromRow(employee), employee.getLogin());
		Assert.assertEquals(employeePage.getRoleFromRow(employee), employee.getRole());
		Assert.assertEquals(employeePage.getFirstnameFromRow(employee), employee.getFirstname());
		Assert.assertEquals(employeePage.getLastnameFromRow(employee), employee.getLastname());
		Assert.assertEquals(employeePage.getOrganizationFromRow(employee), employee.getOrganization());
		Assert.assertEquals(employeePage.getPhoneNumberFromRow(employee), employee.getPhoneNumber());
		Assert.assertEquals(employeePage.getWorkInProgressFromRow(employee), employee.getWorkInProgress());

		final CalibratorEmployeeHomePage calibratorEmployeeHomePage = ((employeePage.logout()).goToLoginPage())
				.successCalibratorEmployeeLogin(employee);

		WebDriverUtils.get().getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		(new WebDriverWait(WebDriverUtils.get().getWebDriver(), 10)).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver d) {
				return calibratorEmployeeHomePage.getNameUser().getText().indexOf(employee.getLogin()) >= 0;
			}
		});
		(new WebDriverWait(WebDriverUtils.get().getWebDriver(), 10))
				.until(ExpectedConditions.elementToBeClickable(calibratorEmployeeHomePage.getNameUser()));
		WebDriverUtils.get().getWebDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		calibratorEmployeeHomePage.logout();

	}

	@DataProvider
	public Object[][] changedEmployeeProvider() {
		return new Object[][] { { Urls.LOCAL_HOST.toString(), UserRepository.getCalibratorUser(),
				UserRepository.getEmployee(), UserRepository.getChangedEmployee() }, };
	}

	 @Test(dataProvider = "changedEmployeeProvider")
	public void changeNewEmployee(String url, IUser calibrator, IUser employee, IUser changedEmployee) {
		WebDriverUtils.get().loadPage(url);
		WebDriverUtils.get().getWebDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		EmployeePage employeePage = (((new MainPage()).goToLoginPage()).successAdminLogin(calibrator))
				.goToEmployeePage();
		employeePage.setFieldForSearchLogin(employee.getLogin());
		employeePage.changeLastNameEmployee(changedEmployee);

		WebDriverUtils.get().getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		(new WebDriverWait(WebDriverUtils.get().getWebDriver(), 10))
				.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));
		WebDriverUtils.get().getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		employeePage.setFieldForSearchLogin(changedEmployee.getLogin());
		Assert.assertEquals(employeePage.getLoginFromRow(employee), changedEmployee.getLogin());
		Assert.assertEquals(employeePage.getRoleFromRow(employee), changedEmployee.getRole());
		Assert.assertEquals(employeePage.getFirstnameFromRow(employee), changedEmployee.getFirstname());
		Assert.assertEquals(employeePage.getLastnameFromRow(employee), changedEmployee.getLastname());
		Assert.assertEquals(employeePage.getOrganizationFromRow(employee), changedEmployee.getOrganization());
		Assert.assertEquals(employeePage.getPhoneNumberFromRow(employee), changedEmployee.getPhoneNumber());
		Assert.assertEquals(employeePage.getWorkInProgressFromRow(employee), changedEmployee.getWorkInProgress());

		employeePage.logout();
	}

	@Test(dataProvider = "employeeProvider")
	public void fireEmployee(String url, IUser calibrator, IUser employee) {
		WebDriverUtils.get().loadPage(url);
		WebDriverUtils.get().getWebDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		EmployeePage employeePage = (((new MainPage()).goToLoginPage()).successAdminLogin(calibrator))
				.goToEmployeePage();
		employeePage.setFieldForSearchLogin(employee.getLogin());
		employeePage.fireEmployee(employee);

		WebDriverUtils.get().getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		(new WebDriverWait(WebDriverUtils.get().getWebDriver(), 10))
				.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));
		WebDriverUtils.get().getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		employeePage.setFieldForSearchLogin(employee.getLogin());

		Assert.assertEquals(employeePage.getAttributeRow(employee), EmployeePage.ROW_IS_NOT_VISIBLE);

		LoginPage loginPage = employeePage.logout().goToLoginPage().unSuccesfulLogin(employee);
		Assert.assertTrue(loginPage.getIncorrectLoginMessage().isEnabled());
		// post-condition
		employeePage = loginPage.successAdminLogin(calibrator).goToEmployeePage();
		employeePage.setFieldForSearchLogin(employee.getLogin());
		employeePage.restoreEmployee(employee);
		employeePage.logout();
	}

}
