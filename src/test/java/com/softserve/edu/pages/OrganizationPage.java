package com.softserve.edu.pages;

import java.util.List;
import java.util.function.ToDoubleBiFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.testData.IOrganization;

public class OrganizationPage {

	private class OrganizationForm {
		// private WebDriver driver;
		private WebElement organizationName;
		private WebElement organizationTypeChoose;
		private WebElement phoneNumber;
		private WebElement email;
		private WebElement maxSizeEpmloyers;
		private WebElement maxTimeForFinishRequestInDays;

		private WebElement selectRegionList;
		private WebElement searchRegionList;
		private WebElement selectDistrictList;
		private WebElement searchDistrictlist;
		private WebElement selectCityList;
		private WebElement searchCityList;
		private WebElement street;
		private WebElement house;
		private WebElement flat;
		private WebElement submitButton;
		private WebElement resetFormButton;
		private WebElement cancelButton;

		public OrganizationForm() {
			initOrganizationWebElements();
		}

		public void initOrganizationWebElements() {
			this.organizationName = driver.findElement(By.name("name"));
			this.organizationTypeChoose = driver.findElement(By.className("default"));
			this.phoneNumber = driver.findElement(By.id("phoneNumber"));
			this.email = driver.findElement(By.id("email"));
			this.maxSizeEpmloyers = driver.findElement(By.id("capacity"));
			this.maxTimeForFinishRequestInDays = driver.findElement(By.id("processTime"));

			this.selectRegionList = driver.findElement(By
					.xpath("html/body/div[3]/div/div/div[2]/form/div[3]/div/div/div[2]/div/div[1]/div[2]/div/a/span"));
			this.searchRegionList = driver.findElement(By.xpath(
					"html/body/div[3]/div/div/div[2]/form/div[3]/div/div/div[2]/div/div[1]/div[2]/div/div/div/input"));
			this.selectDistrictList = driver.findElement(By
					.xpath("html/body/div[3]/div/div/div[2]/form/div[3]/div/div/div[2]/div/div[2]/div[2]/div/a/span"));
			this.searchDistrictlist = driver.findElement(By.xpath(
					"html/body/div[3]/div/div/div[2]/form/div[3]/div/div/div[2]/div/div[2]/div[2]/div/div/div/input"));
			this.selectCityList = driver.findElement(By
					.xpath("html/body/div[3]/div/div/div[2]/form/div[3]/div/div/div[2]/div/div[3]/div[2]/div/a/span"));
			this.searchCityList = driver.findElement(By.xpath(
					"html/body/div[3]/div/div/div[2]/form/div[3]/div/div/div[2]/div/div[3]/div[2]/div/div/div/input"));
			this.street = driver.findElement(By.name("street"));
			this.house = driver.findElement(By.name("building"));
			this.flat = driver.findElement(By.name("flat"));
			this.submitButton = driver
					.findElement(By.xpath("html/body/div[3]/div/div/div[2]/form/div[4]/div[1]/button"));
			this.cancelButton = driver
					.findElement(By.xpath("html/body/div[3]/div/div/div[2]/form/div[4]/div[2]/button"));
			this.resetFormButton = driver.findElement(By.xpath("html/body/div[3]/div/div/div[2]/form/div[4]/div[1]/a"));

		}
        
		public void setOrganizationName(String organizationName) {
			this.organizationName.click();
			this.organizationName.clear();
			this.organizationName.sendKeys(organizationName);
		}

		public void setOrganizationTypeChoose(String organizationType) {
			this.organizationTypeChoose.click();

			this.organizationTypeChoose.sendKeys(organizationType);
			this.organizationTypeChoose.sendKeys(Keys.ENTER);
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber.click();
			this.phoneNumber.clear();
			this.phoneNumber.sendKeys(phoneNumber);
		}

		public void setEmail(String email) {
			this.email.click();
			this.email.clear();
			this.email.sendKeys(email);
		}

		public void setMaxSizeEpmloyers(String maxSizeEpmloyers) {
			this.maxSizeEpmloyers.clear();
			this.maxSizeEpmloyers.click();
			this.maxSizeEpmloyers.sendKeys(maxSizeEpmloyers);
		}

		public void setMaxTimeForFinishRequestInDays(String maxTimeForFinishRequestInDays) {
			this.maxTimeForFinishRequestInDays.clear();
			this.maxTimeForFinishRequestInDays.click();
			this.maxTimeForFinishRequestInDays.sendKeys(maxTimeForFinishRequestInDays);
		}

		public void selectRegionFromList(String region) {
			this.selectRegionList.click();
			this.searchRegionList.click();
			this.searchRegionList.sendKeys(region);
			this.searchRegionList.sendKeys(Keys.ENTER);
		}

		public void selectDistrictFromList(String district) {
			this.selectDistrictList.click();
			this.searchDistrictlist.click();
			this.searchDistrictlist.sendKeys(district);
			this.searchDistrictlist.sendKeys(Keys.ENTER);
		}

		public void selectCityFromList(String city) {
			this.selectCityList.click();
			this.searchCityList.click();
			this.searchCityList.sendKeys(city);
			this.searchCityList.sendKeys(Keys.ENTER);
		}

		public void setStreetInForm(String street) {
			this.street.clear();
			this.street.click();
			this.street.sendKeys(street);
		}

		public void setHouseInForm(String house) {
			this.house.clear();
			this.house.click();
			this.house.sendKeys(house);
		}

		public void setFlatInForm(String flat) {
			this.flat.clear();
			this.flat.click();
			this.flat.sendKeys(flat);
		}

		public void submitButtonClick() {
			this.submitButton.click();
		}

		public void resetButtonClick() {
			this.resetFormButton.click();
		}

		public void cancelButtonClick() {
			this.cancelButton.click();
		}

		public WebElement getOrganizationName() {
			return this.organizationName;
		}

		public WebElement getOrganizationTypeChoose() {
			return this.organizationTypeChoose;
		}

		public WebElement getPhoneNumber() {
			return this.phoneNumber;
		}

		public WebElement getEmail() {
			return this.email;
		}

		public WebElement getMaxSizeEpmloyers() {
			return this.maxSizeEpmloyers;
		}

		public WebElement getMaxTimeForFinishRequestInDays() {
			return this.maxTimeForFinishRequestInDays;
		}

		public WebElement getSelectRegionList() {
			return this.selectRegionList;
		}

		public WebElement getSearchRegionList() {
			return this.searchRegionList;
		}

		public WebElement getSelectDistrictList() {
			return this.selectDistrictList;
		}

		public WebElement getSearchDistrictlist() {
			return this.searchDistrictlist;
		}

		public WebElement getStreet() {
			return this.street;
		}

		public WebElement getHouse() {
			return this.house;
		}

		public WebElement getFlat() {
			return this.flat;
		}

		public WebElement getSubmitButton() {
			return this.submitButton;
		}

		public WebElement getResetFormButton() {
			return this.resetFormButton;
		}

		public WebElement getCancelButton() {
			return this.cancelButton;
		}

	}

	private  class AddNewOrganizationForm extends OrganizationForm {
		private WebElement loginForSystemAdmin;
		private WebElement passwordForSystemAdmin;
		private WebElement confirmPasswordForSystemAdmin;

		public  AddNewOrganizationForm() {

			initWebElements();
		}

		public void initWebElements() {
			this.loginForSystemAdmin = driver.findElement(By.id("username"));
			this.passwordForSystemAdmin = driver.findElement(By.name("password"));
			this.confirmPasswordForSystemAdmin = driver.findElement(By.name("rePassword"));
		}

		public void setLoginForSystemAdmin(String loginForSystemAdmin) {
			this.loginForSystemAdmin.click();
			this.loginForSystemAdmin.clear();
			this.loginForSystemAdmin.sendKeys(loginForSystemAdmin);
		}

		public void setPasswordForSystemAdmin(String passwordForSystemAdmin) {
			this.passwordForSystemAdmin.clear();
			this.passwordForSystemAdmin.click();
			this.passwordForSystemAdmin.sendKeys(passwordForSystemAdmin);
		}

		public void setConfirmPasswordForSystemAdmin(String confirmPasswordForSystemAdmin) {
			this.confirmPasswordForSystemAdmin.clear();
			this.confirmPasswordForSystemAdmin.click();
			this.confirmPasswordForSystemAdmin.sendKeys(confirmPasswordForSystemAdmin);
		}

		public WebElement getLoginForSystemAdmin() {
			return this.loginForSystemAdmin;
		}

		public WebElement getPasswordForSystemAdmin() {
			return this.passwordForSystemAdmin;
		}

		public WebElement getConfirmPasswordForSystemAdmin() {
			return this.confirmPasswordForSystemAdmin;
		}

		private void setOrganizationData(IOrganization organization) {
			setOrganizationName(organization.getOrganizationName());
			setOrganizationTypeChoose(organization.getOrganizationTypeChoose());
			setPhoneNumber(organization.getPhoneNumber());
			setEmail(organization.getEmail());
			setMaxSizeEpmloyers(organization.getMaxSizeEpmloyers());
			setMaxTimeForFinishRequestInDays(organization.getMaxTimeForFinishRequestInDays());
			setLoginForSystemAdmin(organization.getLoginForSystemAdmin());
			setPasswordForSystemAdmin(organization.getPasswordForSystemAdmin());
			setConfirmPasswordForSystemAdmin(organization.getConfirmPasswordForSystemAdmin());
			selectRegionFromList(organization.getSearchRegionList());
			selectDistrictFromList(organization.getSearchDistrictlist());
			setStreetInForm(organization.getStreet());
			setHouseInForm(organization.getHouse());
			setFlatInForm(organization.getFlat());
			submitButtonClick();
		}

	}

	private class OrganizationTable {
		private List<WebElement> nameRows;
		private List<WebElement> allNameRows;
		private List<WebElement> paginationsButtons;
		private WebElement pagButton;

		OrganizationTable() {
			initTableElements();
		}

		public void initTableElements() {
			this.nameRows = driver.findElements(By.xpath(".//*[@id='organizationsTable']/tbody/tr/td[2]"));
			this.paginationsButtons = driver
					.findElements(By.xpath(".//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[3]/div/ul/li/a"));
			this.pagButton = driver
					.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[3]/div/ul/li[5]/a"));
		}

		// TODO pagination
//		public void pagNextButtonClick() {
//			if (pagButton.isEnabled()) {
//				pagButton.click();
//			} else {
//
//			}
//		}
//
//		public List<WebElement> getNameRows() {
//			return nameRows;
//		}
//
//		public List<WebElement> getAllNamesRows() {
//			allNameRows.addAll(getNameRows());
//			return allNameRows;
//		}
//
//		public OrganizationTable clickOnPaginationsButton() {
//
//			for (int i = 3; i <= paginationsButtons.size() - 2; i++) {
//				pagNextButtonClick();
//				return new OrganizationPage.OrganizationTable();
//			}
//			return new OrganizationPage.OrganizationTable();
//		}
		// -------------------------------------------------------------------
	}

	private WebDriver driver;
	private WebElement addOrganizationButton;

	public OrganizationPage(WebDriver driver) {
		this.driver = driver;
		initOrganizationPageElements();
	}

	public void initOrganizationPageElements() {
		this.addOrganizationButton = driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/button"));
	}

	public void addOrganizationButtonClick() {
		this.addOrganizationButton.click();
	}

	public AddNewOrganizationForm addNewOrganizationClick() {
		addOrganizationButtonClick();
		return new OrganizationPage.AddNewOrganizationForm();
	}

	public OrganizationPage successAddOrganization(IOrganization newOrg) {
		addNewOrganizationClick();
		AddNewOrganizationForm newOrganization = new AddNewOrganizationForm();
		newOrganization.setOrganizationData(newOrg);
		return new OrganizationPage(driver);
	}

	
}
