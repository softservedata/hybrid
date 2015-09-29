package com.softserve.edu.counters.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.counters.data.AttributeRepository.Attribute;
import com.softserve.edu.counters.data.IUser;

public class EmployeePage extends ForLoggedUserPage {
	public static final String ROW_IS_NOT_VISIBLE = "ng-scope incorrect";
	public static final String ROW_IS_VISIBLE = "ng-scope";

	private class Table {

		private class Row {
			public final WebElement row;
			public final WebElement login;
			public final WebElement role;
			public final WebElement firstname;
			public final WebElement lastname;
			public final WebElement organization;
			public final WebElement phoneNumber;
			public final WebElement workInProgress;
			public final WebElement edit;

			Row(WebElement row) {
				this.row = row;
				List<WebElement> elements = row.findElements(By.tagName("td"));
				this.login = elements.get(0);
				this.role = elements.get(1);
				this.firstname = elements.get(2);
				this.lastname = elements.get(3);
				this.organization = elements.get(4);
				this.phoneNumber = elements.get(5);
				this.workInProgress = elements.get(6);
				this.edit = elements.get(7).findElement(By.tagName("button"));
			}

			public FormOnPage editClick() {
				edit.click();
				if (row.getAttribute(Attribute.CLASS.toString()).equals(ROW_IS_NOT_VISIBLE))
					return new RestoreForm();
				else
					return new ChangeEmployeeForm();
			}
		}

		private List<Row> rows = new ArrayList<Row>();

		public Table() {
			this.initVisibleRows();
		}

		private void initVisibleRows() {
			List<WebElement> listRows = WebDriverUtils.get().getWebDriver().findElements(By.xpath("//tbody//tr"));
			for (WebElement row : listRows) {
				rows.add(new Row(row));
			}
		}

		public Row getRow(String login) {
			for (Row row : rows) {
				if (row.login.getText().equals(login))
					return row;
			}
			return null;
		}

	}

	private interface FormOnPage {
	}

	private abstract class FormForEmployee implements FormOnPage {

		public final WebElement firstname;
		public final WebElement lastname;
		public final WebElement middleName;
		public final WebElement phoneNumber;
		public final WebElement email;

		public final WebElement login;

		public final WebElement region;
		public final WebElement regionSearch;
		public final WebElement district;
		public final WebElement districtSearch;
		public final WebElement city;
		public final WebElement citySearch;
		public final WebElement street;
		public final WebElement building;
		public final WebElement flat;

		FormForEmployee() {
			this.firstname = WebDriverUtils.get().getWebDriver().findElement(By.id("firstName"));
			this.lastname = WebDriverUtils.get().getWebDriver().findElement(By.id("lastName"));
			this.middleName = WebDriverUtils.get().getWebDriver().findElement(By.id("middleName"));
			this.phoneNumber = WebDriverUtils.get().getWebDriver().findElement(By.id("phone"));
			this.email = WebDriverUtils.get().getWebDriver().findElement(By.id("email"));
			this.login = WebDriverUtils.get().getWebDriver().findElement(By.id("username"));
			this.region = WebDriverUtils.get().getWebDriver()
					.findElement(By.xpath("//form/div[4]/div/div/div[2]/div/div[1]/div[2]/div/a/span"));
			this.regionSearch = WebDriverUtils.get().getWebDriver()
					.findElement(By.xpath("//form/div[4]/div/div/div[2]/div/div[1]/div[2]/div/div/div/input"));
			this.district = WebDriverUtils.get().getWebDriver()
					.findElement(By.xpath("//form/div[4]/div/div/div[2]/div/div[2]/div[2]/div/a/span"));
			this.districtSearch = WebDriverUtils.get().getWebDriver()
					.findElement(By.xpath("//form/div[4]/div/div/div[2]/div/div[2]/div[2]/div/div/div/input"));
			this.city = WebDriverUtils.get().getWebDriver()
					.findElement(By.xpath("//form/div[4]/div/div/div[2]/div/div[3]/div[2]/div/a/span"));
			this.citySearch = WebDriverUtils.get().getWebDriver()
					.findElement(By.xpath("//form/div[4]/div/div/div[2]/div/div[3]/div[2]/div/div/div/input"));
			this.street = WebDriverUtils.get().getWebDriver().findElement(By.name("street"));
			this.building = WebDriverUtils.get().getWebDriver().findElement(By.name("building"));
			this.flat = WebDriverUtils.get().getWebDriver().findElement(By.name("flat"));
		}

		public void setFirstname(String firstname) {
			this.firstname.click();
			this.firstname.clear();
			this.firstname.sendKeys(firstname);
		}

		public void setLastname(String lastname) {
			this.lastname.clear();
			this.lastname.click();
			this.lastname.sendKeys(lastname);
		}

		public void setMiddleName(String middleName) {
			this.middleName.clear();
			this.middleName.click();
			this.middleName.sendKeys(middleName);
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber.clear();
			this.phoneNumber.click();
			this.phoneNumber.sendKeys(phoneNumber);
		}

		public void setEmail(String email) {
			this.email.clear();
			this.email.click();
			this.email.sendKeys(email);
		}

		public void setLogin(String login) {
			this.login.clear();
			this.login.click();
			this.login.sendKeys(login);
		}

		public void setRegion(String region) {
			this.region.click();
			this.regionSearch.sendKeys(region);
			this.regionSearch.sendKeys(Keys.ENTER);
		}

		public void setDistrict(String district) {
			// // 
			WebDriverUtils.get().getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			(new WebDriverWait(WebDriverUtils.get().getWebDriver(), 10))
			.until(ExpectedConditions.invisibilityOfElementLocated(By.className("active-result")));
			this.district.click();
			(new WebDriverWait(WebDriverUtils.get().getWebDriver(), 10))
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("active-result")));
			this.districtSearch.sendKeys(district);
			this.districtSearch.sendKeys(Keys.ENTER);
		}

		public void setCity(String city) {
			// ///
			WebDriverUtils.get().getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			(new WebDriverWait(WebDriverUtils.get().getWebDriver(), 10))
			.until(ExpectedConditions.invisibilityOfElementLocated(By.className("active-result")));
			this.city.click();
			(new WebDriverWait(WebDriverUtils.get().getWebDriver(), 10))
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("active-result")));
			this.citySearch.sendKeys(city);
			this.citySearch.sendKeys(Keys.ENTER);
		}

		public void setStreet(String street) {
			this.street.clear();
			this.street.click();
			this.street.sendKeys(street);
		}

		public void setBuilding(String building) {
			this.building.clear();
			this.building.click();
			this.building.sendKeys(building);
		}

		public void setFlat(String flat) {
			this.flat.clear();
			this.flat.click();
			this.flat.sendKeys(flat);
		}

	}

	private class AddNewEmployeeForm extends FormForEmployee {

		public final WebElement password;
		public final WebElement rePassword;
		public final WebElement submit;

		AddNewEmployeeForm() {
			this.password = WebDriverUtils.get().getWebDriver().findElement(By.name("password"));
			this.rePassword = WebDriverUtils.get().getWebDriver().findElement(By.name("rePassword"));
			this.submit = WebDriverUtils.get().getWebDriver().findElement(By.xpath("(//button[@type='submit'])[2]"));
		}

		public void setPassword(String password) {
			this.password.clear();
			this.password.click();
			this.password.sendKeys(password);
		}

		public void setRePassword(String rePassword) {
			this.rePassword.clear();
			this.rePassword.click();
			this.rePassword.sendKeys(rePassword);
		}

		public void setAddNewEmployeeData(IUser user) {
			setFirstname(user.getFirstname());
			setLastname(user.getLastname());
			setMiddleName(user.getMiddleName());
			setPhoneNumber(user.getPhoneNumber());
			setEmail(user.getEmail());
			setLogin(user.getLogin());
			setPassword(user.getPassword());
			setRePassword(user.getPassword());
			setRegion(user.getRegion());
			setDistrict(user.getDistrict());
			setCity(user.getCity());
			setStreet(user.getStreet());
			setBuilding(user.getBuilding());
			setFlat(user.getFlat());
			submit.click();
		}
	}

	private class RestoreForm implements FormOnPage {
		public final WebElement restore;

		RestoreForm() {
			this.restore = WebDriverUtils.get().getWebDriver()
					.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div/button"));
		}
	}

	private class ChangeEmployeeForm extends FormForEmployee {

		public final WebElement save;
		public final WebElement fire;

		ChangeEmployeeForm() {
			this.save = WebDriverUtils.get().getWebDriver().findElement(By.xpath("(//button[@type='submit'])[3]"));
			this.fire = WebDriverUtils.get().getWebDriver().findElement(By.linkText("Звільнити"));
		}

	}

	private WebElement addNewEmployee;
	private WebElement fieldForSearchLogin;
	private Table table;

	public EmployeePage() {
		initVisibleWebElements();
	}

	private void initVisibleWebElements() {
		this.addNewEmployee = WebDriverUtils.get().getWebDriver().findElement(By.xpath("//button[@type='submit']"));
		this.fieldForSearchLogin = WebDriverUtils.get().getWebDriver()
				.findElement(By.xpath("//tr[@class='ng-table-filters ng-scope']/th[1]//input"));
		this.table = new Table();
	}

	public void addNewEmployeeClick() {
		this.addNewEmployee = WebDriverUtils.get().getWebDriver().findElement(By.xpath("//button[@type='submit']"));
		addNewEmployee.click();
	}

	public void setFieldForSearchLogin(String login) {
		searchLogin(login);
		
		WebDriverUtils.get().getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		(new WebDriverWait(WebDriverUtils.get().getWebDriver(), 10))
				.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//tr[2]/td[1])")));
		(new WebDriverWait(WebDriverUtils.get().getWebDriver(), 10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr[1]/td[1])")));
		WebDriverUtils.get().getWebDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		this.table = new Table();
	}

	public WebElement getAddNewEmployee() {
		return this.addNewEmployee;
	}

	public WebElement getFieldForSearchLogin() {
		return this.fieldForSearchLogin;
	}

//	private Table getTable() {
//		return this.table;
//	}

	public String getLoginText(IUser user) {
		return this.table.getRow(user.getLogin()).login.getText();
	}

	public void searchLogin(String login) {
		this.fieldForSearchLogin.clear();
		for (int i = 0; i < login.length(); i++) {
			this.fieldForSearchLogin.sendKeys("" + login.charAt(i));
		}
		// this.fieldForSearchLogin.sendKeys(login);
	}

	public void successAddEmployee(IUser user) {
		addNewEmployeeClick();
		(new AddNewEmployeeForm()).setAddNewEmployeeData(user);
	}

	public void restoreEmployee(IUser user) {
		((RestoreForm) this.table.getRow(user.getLogin()).editClick()).restore.click();
		(new ChangeEmployeeForm()).save.click();
	}

	public void fireEmployee(IUser user) {
		((ChangeEmployeeForm) this.table.getRow(user.getLogin()).editClick()).fire.click();
	}

	public void changeLastNameEmployee(IUser changedEmployee) {
		ChangeEmployeeForm changeEmployeeForm = ((ChangeEmployeeForm) this.table.getRow(changedEmployee.getLogin())
				.editClick());
		changeEmployeeForm.setLastname(changedEmployee.getLastname());
		changeEmployeeForm.save.click();
	}

	public String getAttributeRow(IUser user) {
		return this.table.getRow(user.getLogin()).row.getAttribute(Attribute.CLASS.toString());
	}

	public String getLoginFromRow(IUser user) {
		return this.table.getRow(user.getLogin()).login.getText();
	}

	public String getRoleFromRow(IUser user) {
		return this.table.getRow(user.getLogin()).role.getText();
	}

	public String getFirstnameFromRow(IUser user) {
		return this.table.getRow(user.getLogin()).firstname.getText();
	}

	public String getLastnameFromRow(IUser user) {
		return this.table.getRow(user.getLogin()).lastname.getText();
	}

	public String getOrganizationFromRow(IUser user) {
		return this.table.getRow(user.getLogin()).organization.getText();
	}

	public String getPhoneNumberFromRow(IUser user) {
		return this.table.getRow(user.getLogin()).phoneNumber.getText();
	}

	public String getWorkInProgressFromRow(IUser user) {
		return this.table.getRow(user.getLogin()).workInProgress.getText();
	}

}
