package com.softserve.edu.counters.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.atqc.tools.controls.Button;
import com.softserve.edu.atqc.tools.controls.Component;
import com.softserve.edu.atqc.tools.controls.IButton;
import com.softserve.edu.atqc.tools.controls.IComponent;
import com.softserve.edu.atqc.tools.controls.ITextField;
import com.softserve.edu.atqc.tools.controls.TextField;
import com.softserve.edu.atqc.tools.search.ByWrapper;
import com.softserve.edu.atqc.tools.search.ContextUtils;
import com.softserve.edu.atqc.tools.search.ImplicitWrapper;
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

		private class DropDownList {
			List<WebElement> allOptions;

			public DropDownList() {
				ImplicitWrapper.get().getPresentWebElement(ByWrapper.getByClassName("active-result"));
				allOptions = WebDriverUtils.get().getWebDriver().findElements(By.className("active-result"));
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

		private class FormForEmployeeUIMap {
			public final ITextField firstname;
			public final ITextField lastname;
			public final ITextField middleName;
			public final ITextField phoneNumber;
			public final ITextField email;

			public final ITextField login;

			public final IButton region;
			public final IButton district;
			public final IButton city;
			public final ITextField street;
			public final ITextField building;
			public final ITextField flat;

			public FormForEmployeeUIMap() {

				this.firstname = TextField.get().getById("firstName");
				this.lastname = TextField.get().getById("lastName");
				this.middleName = TextField.get().getById("middleName");
				this.phoneNumber = TextField.get().getById("phone");
				this.email = TextField.get().getById("email");
				this.login = TextField.get().getById("username");

				this.region = Button.get().getByXpath("//form/div[4]/div/div/div[2]/div/div[1]/div[2]/div/a/span");
				this.district = Button.get().getByXpath("//form/div[4]/div/div/div[2]/div/div[2]/div[2]/div/a/span");
				this.city = Button.get().getByXpath("//form/div[4]/div/div/div[2]/div/div[3]/div[2]/div/a/span");
				this.street = TextField.get().getByName("street");
				this.building = TextField.get().getByName("building");
				this.flat = TextField.get().getByName("flat");

			}
		}

		// Elements
		private FormForEmployeeUIMap controls;

		public FormForEmployee() {
			controls = new FormForEmployeeUIMap();
		}

		// PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

		public void setFirstname(String firstname) {
			this.controls.firstname.sendKeysClear(firstname);
		}

		public void setLastname(String lastname) {
			this.controls.lastname.sendKeysClear(lastname);
		}

		public void setMiddleName(String middleName) {
			this.controls.middleName.sendKeysClear(middleName);
		}

		public void setPhoneNumber(String phoneNumber) {
			this.controls.phoneNumber.sendKeysClear(phoneNumber);
		}

		public void setEmail(String email) {
			this.controls.email.sendKeysClear(email);
		}

		public void setLogin(String login) {
			this.controls.login.sendKeysClear(login);
		}

		public void setRegion(String region) {
			this.controls.region.click();
			new DropDownList().chooseElement(region);
		}

		public void setDistrict(String district) {
			ImplicitWrapper.get().isInvisibleWebElement(ByWrapper.getByClassName("active-result"));
			this.controls.district.click();
			new DropDownList().chooseElement(district);
		}

		public void setCity(String sity) {
			ImplicitWrapper.get().isInvisibleWebElement(ByWrapper.getByClassName("active-result"));
			this.controls.city.click();
			new DropDownList().chooseElement(sity);
		}

		// TODO
		public void setStreet(String street) {
			this.controls.street.sendKeysClear(street);
		}

		public void setBuilding(String building) {
			this.controls.building.sendKeysClear(building);
		}

		public void setFlat(String flat) {
			this.controls.flat.sendKeysClear(flat);
		}

	}

	private class AddNewEmployeeForm extends FormForEmployee {

		private class AddNewEmployeeFormUIMap {
			public final ITextField password;
			public final ITextField rePassword;
			public final IButton submit;

			public final IComponent form;

			public AddNewEmployeeFormUIMap() {
				
				this.password = TextField.get().getByName("password");
				this.rePassword = TextField.get().getByName("rePassword");
				this.submit = Button.get().getByXpath("(//button[@type='submit'])[2]");
				form = Component.get().getByXpath("//div[@class='modal-dialog']");
			}
		}

		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

		// Elements
		private AddNewEmployeeFormUIMap controls;

		public AddNewEmployeeForm() {
			controls = new AddNewEmployeeFormUIMap();
		}

		// PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

		public void setPassword(String password) {
			this.controls.password.sendKeysClear(password);
		}

		public void setRePassword(String rePassword) {
			this.controls.rePassword.sendKeysClear(rePassword);
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
			controls.submit.click();
		}
	}

	private class RestoreForm implements FormOnPage {
		public final IButton restore;

		RestoreForm() {
			this.restore = Button.get().getByXpath("/html/body/div[3]/div/div/div[2]/div/div/button");
		}
	}

	private class ChangeEmployeeForm extends FormForEmployee {
		private class ChangeEmployeeFormUIMap {
			public final IButton save;
			public final IButton fire;
			public final IComponent form;

			public ChangeEmployeeFormUIMap() {
				this.save = Button.get().getByXpath("(//button[@type='submit'])[3]");
				this.fire = Button.get().getByPartialLinkText("Звільнити");
				form = Component.get().getByXpath("//div[@class='modal-dialog']");
			}
		}

		// Elements
		private ChangeEmployeeFormUIMap controls;

		public ChangeEmployeeForm() {
			controls = new ChangeEmployeeFormUIMap();
		}
	}

	private class EmployeePageUIMap {
		public final IButton addNewEmployee;
		public final ITextField fieldForSearchLogin;
		public Table table;

		public EmployeePageUIMap() {
			this.addNewEmployee = Button.get().getByXpath("//button[@type='submit']");
			this.fieldForSearchLogin = TextField.get()
					.getByXpath("//tr[@class='ng-table-filters ng-scope']/th[1]//input");
			this.table = new Table();
		}
	}

	// Elements
	private EmployeePageUIMap controls;

	public EmployeePage() {
		controls = new EmployeePageUIMap();
	}

	// PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public void addNewEmployeeClick() {
		controls.addNewEmployee.click();
	}

	public void setFieldForSearchLogin(String login) {
		searchLogin(login);

		ImplicitWrapper.get().isInvisibleWebElement(ByWrapper.getByXPath("(//tr[2]/td[1])"));
		ImplicitWrapper.get().getVisibleWebElement(ByWrapper.getByXPath("(//tr[1]/td[1])"));

		this.controls.table = new Table();
	}

	public IButton getAddNewEmployee() {
		return this.controls.addNewEmployee;
	}

	public ITextField getFieldForSearchLogin() {
		return this.controls.fieldForSearchLogin;
	}

	public String getLoginText(IUser user) {
		return this.controls.table.getRow(user.getLogin()).login.getText();
	}

	public void searchLogin(String login) {
		this.controls.fieldForSearchLogin.clear();
		for (int i = 0; i < login.length(); i++) {
			this.controls.fieldForSearchLogin.sendKeys("" + login.charAt(i));
		}
		// this.fieldForSearchLogin.sendKeys(login);
	}

	public void successAddEmployee(IUser user) {
		addNewEmployeeClick();
		AddNewEmployeeForm addNewEmployeeForm = new AddNewEmployeeForm();
		addNewEmployeeForm.setAddNewEmployeeData(user);
		// TODO
		ContextUtils.get().isStatelessOfWebElement(addNewEmployeeForm.controls.form.getWrapper());
	}

	public void restoreEmployee(IUser user) {
		((RestoreForm) this.controls.table.getRow(user.getLogin()).editClick()).restore.click();
		(new ChangeEmployeeForm()).controls.save.click();
	}

	public void fireEmployee(IUser user) {
		ChangeEmployeeForm changeEmployeeForm = ((ChangeEmployeeForm) this.controls.table.getRow(user.getLogin())
				.editClick());
		changeEmployeeForm.controls.fire.click();
		ContextUtils.get().isStatelessOfWebElement(changeEmployeeForm.controls.form.getWrapper());
		// }
	}

	public void changeLastNameEmployee(IUser changedEmployee) {
		ChangeEmployeeForm changeEmployeeForm = ((ChangeEmployeeForm) this.controls.table
				.getRow(changedEmployee.getLogin()).editClick());
		changeEmployeeForm.setLastname(changedEmployee.getLastname());
		changeEmployeeForm.controls.save.click();
		ContextUtils.get().isStatelessOfWebElement(changeEmployeeForm.controls.form.getWrapper());
	}

	public String getAttributeRow(IUser user) {
		return this.controls.table.getRow(user.getLogin()).row.getAttribute(Attribute.CLASS.toString());
	}

	public String getLoginFromRow(IUser user) {
		return this.controls.table.getRow(user.getLogin()).login.getText();
	}

	public String getRoleFromRow(IUser user) {
		return this.controls.table.getRow(user.getLogin()).role.getText();
	}

	public String getFirstnameFromRow(IUser user) {
		return this.controls.table.getRow(user.getLogin()).firstname.getText();
	}

	public String getLastnameFromRow(IUser user) {
		return this.controls.table.getRow(user.getLogin()).lastname.getText();
	}

	public String getOrganizationFromRow(IUser user) {
		return this.controls.table.getRow(user.getLogin()).organization.getText();
	}

	public String getPhoneNumberFromRow(IUser user) {
		return this.controls.table.getRow(user.getLogin()).phoneNumber.getText();
	}

	public String getWorkInProgressFromRow(IUser user) {
		return this.controls.table.getRow(user.getLogin()).workInProgress.getText();
	}

}
