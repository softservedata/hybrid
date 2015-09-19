package com.softserve.edu.counters.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
import com.softserve.edu.counters.pages.CalibratorEmployeeHomePage;
import com.softserve.edu.counters.pages.EmployeePage;
import com.softserve.edu.counters.pages.LoginPage;
import com.softserve.edu.counters.pages.MainPage;
import com.softserve.edu.counters.pages.EmployeePage.ChangeEmployeeForm;
import com.softserve.edu.counters.pages.EmployeePage.RestoreForm;

import wtbox.util.WaitTool;

public class AddNewEmployeeTest {
	WebDriver driver;

	@BeforeClass
	public void oneTimeSetUp() {
		ProfilesIni profileIni = new ProfilesIni();
		FirefoxProfile profile = profileIni.getProfile("default");
		profile.setAcceptUntrustedCertificates(true);
		driver = new FirefoxDriver(profile);

	}

	@DataProvider
	public Object[][] employeeProvider() {
		return new Object[][] {
				{ Urls.LOCAL_HOST.toString(), UserRepository.getCalibratorUser(), UserRepository.getEmployee() }, };
	}

	@Test(dataProvider = "employeeProvider")
	public void addNewEmployee(String url, IUser calibrator, IUser employee) {

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		EmployeePage employeePage = (((new MainPage(driver)).goToLoginPage()).successAdminLogin(calibrator))
				.goToEmployeePage();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		(employeePage.addNewEmployeeClick()).setAddNewEmployeeData(employee);
		employeePage.setFieldForSearchLogin(employee.getLogin());

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		Assert.assertEquals(employeePage.getTable().getRow(employee.getLogin()).getLogin().getText(), employee.getLogin());
		Assert.assertEquals(employeePage.getTable().getRow(employee.getLogin()).getRole().getText(), employee.getRole());
		Assert.assertEquals(employeePage.getTable().getRow(employee.getLogin()).getFirstname().getText(), employee.getFirstname());
		Assert.assertEquals(employeePage.getTable().getRow(employee.getLogin()).getLastname().getText(), employee.getLastname());
		Assert.assertEquals(employeePage.getTable().getRow(employee.getLogin()).getOrganization().getText(), employee.getOrganization());
		Assert.assertEquals(employeePage.getTable().getRow(employee.getLogin()).getPhoneNumber().getText(), employee.getPhoneNumber());
		Assert.assertEquals(employeePage.getTable().getRow(employee.getLogin()).getWorkInProgress().getText(),
				employee.getWorkInProgress());

		CalibratorEmployeeHomePage calibratorEmployeeHomePage = ((employeePage.logout()).goToLoginPage())
				.successCalibratorEmployeeLogin(employee);

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WaitTool.waitForTextPresent(driver, By.xpath("//*[@id='employeeModule']/nav/ul/li/a/label"),
				userNameForLogOut(), 20);
		Assert.assertEquals(calibratorEmployeeHomePage.getNameUser().getText(), userNameForLogOut());

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		calibratorEmployeeHomePage.logout();

	}

	// TODO
	public String userNameForLogOut() {
		return UserRepository.getEmployee().getFirstname() + " " + UserRepository.getEmployee().getLastname() + " "
				+ UserRepository.getEmployee().getMiddleName() + " (" + UserRepository.getEmployee().getLogin() + ")";
	}

	@DataProvider
	public Object[][] changedEmployeeProvider() {
		return new Object[][] { { Urls.LOCAL_HOST.toString(), UserRepository.getCalibratorUser(),
				UserRepository.getEmployee(), UserRepository.getChangedEmployee() }, };
	}

	/**
	 * Check edit employee
	 */
	// @Test(dataProvider = "changedEmployeeProvider")
	public void changeNewEmployee(String url, IUser calibrator, IUser employee, IUser changedEmployee) {

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		EmployeePage employeePage = (((new MainPage(driver)).goToLoginPage()).successAdminLogin(calibrator))
				.goToEmployeePage();

		employeePage.setFieldForSearchLogin(employee.getLogin());
		// TODO
		ChangeEmployeeForm changeEmployeeForm = (ChangeEmployeeForm) employeePage.getTable().getRow(employee.getLogin()).editClick();
		changeEmployeeForm.setLastname(changedEmployee.getLastname());
		changeEmployeeForm.saveClick();
		employeePage.setFieldForSearchLogin(changedEmployee.getLogin());

		Assert.assertEquals(employeePage.getTable().getRow(employee.getLogin()).getLogin().getText(), changedEmployee.getLogin());
		Assert.assertEquals(employeePage.getTable().getRow(employee.getLogin()).getRole().getText(), changedEmployee.getRole());
		Assert.assertEquals(employeePage.getTable().getRow(employee.getLogin()).getFirstname().getText(), changedEmployee.getFirstname());
		Assert.assertEquals(employeePage.getTable().getRow(employee.getLogin()).getLastname().getText(), changedEmployee.getLastname());
		Assert.assertEquals(employeePage.getTable().getRow(employee.getLogin()).getOrganization().getText(),
				changedEmployee.getOrganization());
		Assert.assertEquals(employeePage.getTable().getRow(employee.getLogin()).getPhoneNumber().getText(),
				changedEmployee.getPhoneNumber());
		Assert.assertEquals(employeePage.getTable().getRow(employee.getLogin()).getWorkInProgress().getText(),
				changedEmployee.getWorkInProgress());

		employeePage.logout();
	}

	/**
	 * Check fire employee
	 */
	// @Test(dataProvider = "employeeProvider")
	public void fireEmployee(String url, IUser calibrator, IUser employee) {

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		EmployeePage employeePage = (((new MainPage(driver)).goToLoginPage()).successAdminLogin(calibrator))
				.goToEmployeePage();

		employeePage.setFieldForSearchLogin(employee.getLogin());
		// TODO
		ChangeEmployeeForm changeEmployeeForm = (ChangeEmployeeForm) employeePage.getTable().getRow(employee.getLogin()).editClick();
		changeEmployeeForm.fireClick();
		employeePage.setFieldForSearchLogin(employee.getLogin());
		Assert.assertEquals(employeePage.getTable().getRow(employee.getLogin()).getRow().getAttribute("class"), "ng-scope incorrect");
		LoginPage loginPage = employeePage.logout().goToLoginPage().unSuccesfulLogin(employee);
		Assert.assertTrue(loginPage.getIncorrectLoginMessage().isEnabled());

	}

	 //TODO
	// @Test(dataProvider = "employeeProvider")
	public void restoreEmployee(String url, IUser calibrator, IUser employee) {

		driver.get(Urls.LOCAL_HOST.toString());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		EmployeePage employeePage = (((new MainPage(driver)).goToLoginPage()).successAdminLogin(calibrator))
				.goToEmployeePage();

		employeePage.setFieldForSearchLogin(employee.getLogin());

		RestoreForm restoreForm = (RestoreForm) employeePage.getTable().getRow(employee.getLogin()).editClick();
		restoreForm.restoreClick().saveClick();

		employeePage.setFieldForSearchLogin(employee.getLogin());
		Assert.assertEquals(employeePage.getTable().getRow(employee.getLogin()).getRow().getAttribute("class"), "ng-scope");

		CalibratorEmployeeHomePage calibratorEmployeeHomePage = employeePage.logout().goToLoginPage()
				.successCalibratorEmployeeLogin(employee);

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WaitTool.waitForTextPresent(driver, By.xpath("//*[@id='employeeModule']/nav/ul/li/a/label"),
				userNameForLogOut(), 20);
		Assert.assertEquals(calibratorEmployeeHomePage.getNameUser().getText(), userNameForLogOut());

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		calibratorEmployeeHomePage.logout();

	}

}
