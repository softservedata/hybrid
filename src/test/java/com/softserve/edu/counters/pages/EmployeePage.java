package com.softserve.edu.counters.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.counters.data.IUser;
import com.softserve.edu.counters.data.UserRepository;

import wtbox.util.WaitTool;

public class EmployeePage extends ForLoggedUserPage {

	public class Row {
		private WebElement row;
		private WebElement login;
		private WebElement role;
		private WebElement firstname;
		private WebElement lastname;
		private WebElement organization;
		private WebElement phoneNumber;
		private WebElement workInProgress;
		private WebElement edit;

		public Row(WebElement row) {
			this.row = row;
			List<WebElement> elements = row.findElements(By.xpath("//td"));
			System.out.println(elements);
			this.login = elements.get(0);
			this.role = elements.get(1);
			this.firstname = elements.get(2);
			this.lastname = elements.get(3);
			this.organization = elements.get(4);
			this.phoneNumber = elements.get(5);
			this.workInProgress = elements.get(6);
			//this.edit = elements.get(7).findElement(By.xpath("//button"));
			//TODO
			this.edit = row.findElement(By.xpath("(//td[8]/button)"));
	
		}

		public Form editClick() {
			// TODO
			edit.click();
			if (this.getRow().getAttribute("class").equals("ng-scope incorrect"))
				return new RestoreForm();
			else
				return new ChangeEmployeeForm();
		}

		public WebElement getRow() {
			return this.row;
		}

		public WebElement getLogin() {
			return this.login;
		}

		public WebElement getRole() {
			return this.role;
		}

		public WebElement getFirstname() {
			return this.firstname;
		}

		public WebElement getLastname() {
			return this.lastname;
		}

		public WebElement getOrganization() {
			return this.organization;
		}

		public WebElement getPhoneNumber() {
			return this.phoneNumber;
		}

		public WebElement getWorkInProgress() {
			return this.workInProgress;
		}

		public WebElement getEdit() {
			return this.edit;
		}

	}

	public class Table {////////////// ???????????????????????????????

		List<Row> rows = new ArrayList<Row>();

		public Table() {
			List<WebElement> list = driver.findElements(By.xpath("//tbody//tr"));
			for (WebElement webElement : list) {
				System.out.println(webElement.getText());
				rows.add(new Row(webElement));
			}

		}

		public Row getRow(String login) {
			for (Row row : rows) {
				if (row.getLogin().getText().equals(login))
				return row;
			}
			// TODO
			return null;
		}

	}

	interface Form {
	}

	public abstract class FormForEmployee implements Form {

		private class DropDownList {
			List<WebElement> allOptions;

			public DropDownList() {
				(new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("active-result")));
				allOptions = driver.findElements(By.className("active-result"));
			}

			public void chooseElement(String element) {
				for (WebElement option : allOptions) {
					if (option.getText().equals(element)) {
						option.click();
						break;
					}
				}
			}
		}

		private WebElement firstname;
		private WebElement lastname;
		private WebElement middleName;
		private WebElement phoneNumber;
		private WebElement email;

		private WebElement login;

		private WebElement region;
		private WebElement district;
		private WebElement sity;
		private WebElement street;
		private WebElement building;
		private WebElement flat;

		public FormForEmployee() {
			this.firstname = driver.findElement(By.id("firstName"));
			this.lastname = driver.findElement(By.id("lastName"));
			this.middleName = driver.findElement(By.id("middleName"));
			this.phoneNumber = driver.findElement(By.id("phone"));
			this.email = driver.findElement(By.id("email"));
			this.login = driver.findElement(By.id("username"));
			this.region = driver.findElement(By.xpath("//form/div[4]/div/div/div[2]/div/div[1]/div[2]/div/a/span"));
			this.district = driver.findElement(By.xpath("//form/div[4]/div/div/div[2]/div/div[2]/div[2]/div/a/span"));
			this.sity = driver.findElement(By.xpath("//form/div[4]/div/div/div[2]/div/div[3]/div[2]/div/a/span"));
			this.street = driver.findElement(By.name("street"));
			this.building = driver.findElement(By.name("building"));
			this.flat = driver.findElement(By.name("flat"));
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
			new DropDownList().chooseElement(region);
		}

		public void setDistrict(String district) {
			// TODO
			(new WebDriverWait(driver, 2)).until(ExpectedConditions
					.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("active-result"))));
			///
			this.district.click();
			new DropDownList().chooseElement(district);
		}

		public void setSity(String sity) {
			///
			(new WebDriverWait(driver, 2)).until(ExpectedConditions
					.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("active-result"))));
			///

			this.sity.click();
			new DropDownList().chooseElement(sity);
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

		////////////////////////////////////

		public WebElement getFirstname() {
			return this.firstname;
		}

		public WebElement getLastname() {
			return this.lastname;
		}

		public WebElement getMiddleName() {
			return this.middleName;
		}

		public WebElement getPhoneNumber() {
			return this.phoneNumber;
		}

		public WebElement getEmail() {
			return this.email;
		}

		public WebElement getLogin() {
			return this.login;
		}

		public WebElement getRegion() {
			return this.region;
		}

		public WebElement getDistrict() {
			return this.district;
		}

		public WebElement getSity() {
			return this.sity;
		}

		public WebElement getStreet() {
			return this.street;
		}

		public WebElement getBuilding() {
			return this.building;
		}

		public WebElement getFlat() {
			return this.flat;
		}

	}

	public class AddNewEmployeeForm extends FormForEmployee {

		private WebElement password;
		private WebElement rePassword;

		private WebElement submit;

		public AddNewEmployeeForm() {

			this.password = driver.findElement(By.name("password"));
			this.rePassword = driver.findElement(By.name("rePassword"));
			this.submit = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
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

		public void submitClick() {
			this.submit.click();
		}

		public WebElement getPassword() {
			return this.password;
		}

		public WebElement getRePassword() {
			return this.rePassword;
		}

		public WebElement getSubmit() {
			return this.submit;
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
			setSity(user.getSity());
			setStreet(user.getStreet());
			setBuilding(user.getBuilding());
			setFlat(user.getFlat());
			submitClick();
		}
	}

	public class RestoreForm implements Form {
		private WebElement restore;

		public RestoreForm() {
			this.restore = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div/button"));
		}

		public ChangeEmployeeForm restoreClick() {
			this.restore.click();
			return new ChangeEmployeeForm();
		}

		public WebElement getRestore() {
			return this.restore;
		}

	}

	public class ChangeEmployeeForm extends FormForEmployee {

		private WebElement generateNewPassword;
		private WebElement save;
		private WebElement fire;
		private WebElement close;

		public ChangeEmployeeForm() {

			this.generateNewPassword = driver.findElement(By.xpath("//form/div[3]/div[2]/div[3]/div[2]/button"));
			this.save = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
			this.fire = driver.findElement(By.linkText("Звільнити"));
			this.close = driver.findElement(By.xpath("//form/div[5]/div[2]/button"));
		}

		public void generateNewPasswordClick() {
			this.generateNewPassword.click();
		}

		public void saveClick() {
			this.save.click();
		}

		public void fireClick() {
			this.fire.click();
		}

		public void closeClick() {
			this.close.click();
		}

		public WebElement getGenerateNewPassword() {
			return this.generateNewPassword;
		}

		public WebElement getSave() {
			return this.save;
		}

		public WebElement getFire() {
			return this.fire;
		}

		public WebElement getClose() {
			return this.close;
		}

	}

	private WebElement addNewEmployee;
	private WebElement fieldForSearchLogin;
	private Table table;

	public EmployeePage(WebDriver driver) {
		super(driver);
		this.addNewEmployee = driver.findElement(By.xpath("//button[@type='submit']"));
		this.fieldForSearchLogin = driver
				.findElement(By.xpath("//tr[@class='ng-table-filters ng-scope']/th[1]//input"));
		this.table = new Table();
	}

	public AddNewEmployeeForm addNewEmployeeClick() {
		addNewEmployee.click();
		return new AddNewEmployeeForm();
	}

	public void setFieldForSearchLogin(String login) {
		searchLogin(login);
		// --------------------------------------------------------------------------------------------
		WaitTool.waitForElementPresent(driver, By.xpath("(//tr[1]/td[1])"), 20);
		WaitTool.waitForTextPresent(driver, By.xpath("(//tr[1]/td[1])"), UserRepository.getEmployee().getLogin(), 20);
		// --------------------------------------------------------------------------------------------
		
		this.table = new Table();
	}

	public WebElement getAddNewEmployee() {
		return this.addNewEmployee;
	}

	public WebElement getFieldForSearchLogin() {
		return this.fieldForSearchLogin;
	}

	public Table getTable() {
		return this.table;
	}

	public void searchLogin(String login) {
		this.fieldForSearchLogin.clear();
		for (int i = 0; i < login.length(); i++) {
			this.fieldForSearchLogin.sendKeys("" + login.charAt(i));
		}
		// this.fieldForSearchLogin.sendKeys(login);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////

}
