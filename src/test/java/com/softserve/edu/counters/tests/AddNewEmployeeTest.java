package com.softserve.edu.counters.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.tools.browsers.ABrowser;
import com.softserve.edu.atqc.tools.browsers.BrowserRepository;
import com.softserve.edu.atqc.tools.search.ByWrapper;
import com.softserve.edu.atqc.tools.search.ImplicitWrapper;
import com.softserve.edu.atqc.tools.verifications.AssertWrapper;
import com.softserve.edu.counters.data.IUser;
import com.softserve.edu.counters.data.UrlRepository.Urls;
import com.softserve.edu.counters.data.UserRepository;
import com.softserve.edu.counters.pages.CalibratorEmployeeHomePage;
import com.softserve.edu.counters.pages.EmployeePage;
import com.softserve.edu.counters.pages.LoginPageValidator;
import com.softserve.edu.counters.pages.LoginPageValidator.LoginPageMessages;
import com.softserve.edu.counters.pages.StartMainPage;

public class AddNewEmployeeTest {

	@DataProvider
	public Object[][] employeeProvider() {
		return new Object[][] { { BrowserRepository.getDefault(), Urls.LOCAL_HOST.toString(),
				UserRepository.getCalibratorUser(), UserRepository.getEmployee() }, };
	}

	@Test(dataProvider = "employeeProvider")
	public void addNewEmployee(ABrowser browser, String url, IUser calibrator, final IUser employee) {

		EmployeePage employeePage = StartMainPage.load(browser, url).goToLoginPage().successAdminLogin(calibrator)
				.goToEmployeePage();
		employeePage.successAddEmployee(employee);

		employeePage.setFieldForSearchLogin(employee.getLogin());

		AssertWrapper.get().forElement(employeePage.getLoginFromRow(employee)).valueMatch(employee.getLogin()).next()
				.forElement(employeePage.getRoleFromRow(employee)).valueMatch(employee.getRole()).next()
				.forElement(employeePage.getFirstnameFromRow(employee)).valueMatch(employee.getFirstname()).next()
				.forElement(employeePage.getLastnameFromRow(employee)).valueMatch(employee.getLastname()).next()
				.forElement(employeePage.getOrganizationFromRow(employee)).valueMatch(employee.getOrganization()).next()
				.forElement(employeePage.getPhoneNumberFromRow(employee)).valueMatch(employee.getPhoneNumber()).next()
				.forElement(employeePage.getWorkInProgressFromRow(employee)).valueMatch(employee.getWorkInProgress());
		CalibratorEmployeeHomePage calibratorEmployeeHomePage = ((employeePage.logout()).goToLoginPage())
				.successCalibratorEmployeeLogin(employee);
//		 ImplicitWrapper.get().isVisibleText(ByWrapper.getByXPath("//a[@class='dropdown-toggle']/label"),
//		 employee.getLogin());
		ImplicitWrapper.get().isVisibleText(calibratorEmployeeHomePage.getNameUserByWrapper(),
				employee.getLogin());
		calibratorEmployeeHomePage.logout();
		AssertWrapper.get().check();

	}

	@DataProvider
	public Object[][] changedEmployeeProvider() {
		return new Object[][] {
				{ BrowserRepository.getDefault(), Urls.LOCAL_HOST.toString(), UserRepository.getCalibratorUser(),
						UserRepository.getEmployee(), UserRepository.getChangedEmployee() }, };
	}

	@Test(dataProvider = "changedEmployeeProvider")
	public void changeNewEmployee(ABrowser browser, String url, IUser calibrator, IUser employee,
			IUser changedEmployee) {

		EmployeePage employeePage = StartMainPage.load(browser, url).goToLoginPage().successAdminLogin(calibrator)
				.goToEmployeePage();
		employeePage.setFieldForSearchLogin(employee.getLogin());
		employeePage.changeLastNameEmployee(changedEmployee);

		employeePage.setFieldForSearchLogin(employee.getLogin());

		AssertWrapper.get().forElement(employeePage.getLoginFromRow(changedEmployee))
				.valueMatch(changedEmployee.getLogin()).next().forElement(employeePage.getRoleFromRow(changedEmployee))
				.valueMatch(changedEmployee.getRole()).next()
				.forElement(employeePage.getFirstnameFromRow(changedEmployee))
				.valueMatch(changedEmployee.getFirstname()).next()
				.forElement(employeePage.getLastnameFromRow(changedEmployee)).valueMatch(changedEmployee.getLastname())
				.next().forElement(employeePage.getOrganizationFromRow(changedEmployee))
				.valueMatch(changedEmployee.getOrganization()).next()
				.forElement(employeePage.getPhoneNumberFromRow(changedEmployee))
				.valueMatch(changedEmployee.getPhoneNumber()).next()
				.forElement(employeePage.getWorkInProgressFromRow(changedEmployee))
				.valueMatch(changedEmployee.getWorkInProgress());

		employeePage.logout();
		AssertWrapper.get().check();
	}

	//
	@Test(dataProvider = "employeeProvider")
	public void fireEmployee(ABrowser browser, String url, IUser calibrator, IUser employee) {

		EmployeePage employeePage = StartMainPage.load(browser, url).goToLoginPage().successAdminLogin(calibrator)
				.goToEmployeePage();
		employeePage.setFieldForSearchLogin(employee.getLogin());
		employeePage.fireEmployee(employee);

		employeePage.setFieldForSearchLogin(employee.getLogin());

		AssertWrapper.get().forElement(employeePage.getAttributeRow(employee))
				.valueMatch(EmployeePage.ROW_IS_NOT_VISIBLE);

		LoginPageValidator loginPageValidator = employeePage.logout().goToLoginPage().unSuccesfulLogin(employee);

		AssertWrapper.get().forElement(loginPageValidator.getValidatorText())
				.valueMatch(LoginPageMessages.VALIDATOR_TEXT.toString());

		employeePage = loginPageValidator.successAdminLogin(calibrator).goToEmployeePage();
		employeePage.setFieldForSearchLogin(employee.getLogin());
		employeePage.restoreEmployee(employee);
		employeePage.logout();
		AssertWrapper.get().check();
	}

}
