package com.softserve.edu.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.atqc.tools.controls.Button;
import com.softserve.edu.atqc.tools.controls.IButton;
import com.softserve.edu.atqc.tools.controls.ILabelClickable;
import com.softserve.edu.atqc.tools.controls.ITextField;
import com.softserve.edu.atqc.tools.controls.LabelClickable;
import com.softserve.edu.atqc.tools.controls.TextField;
import com.softserve.edu.atqc.tools.search.KeysWrapper;
import com.softserve.edu.testData.IOrganization;

public class OrganizationPage {

	private class OrganizationForm {
		private class OrganizationFormUIMap{
			private ITextField organizationName;
			private ITextField organizationTypeChoose;
			private ITextField phoneNumber;
			private ITextField email;
			private ITextField maxSizeEpmloyers;
			private ITextField maxTimeForFinishRequestInDays;
			
			private ILabelClickable selectRegionList;
			private ITextField searchRegionList;
			private ILabelClickable selectDistrictList;
			private ITextField searchDistrictlist;
			private ILabelClickable selectCityList;
			private ITextField searchCityList;
			private ITextField street;
			private ITextField house;
			private ITextField flat;
			private IButton submitButton;
			private IButton resetFormButton;
			private IButton cancelButton;
			
			public OrganizationFormUIMap(){
				initOrganizationWebElements();
			}
			public void initOrganizationWebElements(){
				this.organizationName = TextField.get().getByXpath(".//*[@id='name']");
				//TODO Fix get By
				this.organizationTypeChoose = TextField.get().getByXpath(".//*[@id='types']/ul/li/input");
				this.phoneNumber = TextField.get().getById("phoneNumber");
				this.email = TextField.get().getById("email");
				this.maxSizeEpmloyers = TextField.get().getById("capacity");
				this.maxTimeForFinishRequestInDays = TextField.get().getById("processTime");
				this.selectRegionList = LabelClickable.get()
						.getByXpath(".//*[@id='region']/a/span[1]");
			
//				this.searchRegionList = TextField.get()
//						.getByXpath(".//*[@id='region']/div/div/input");
			    
				this.selectDistrictList = LabelClickable.get()
						.getByXpath(".//*[@id='district']/a/span[1]");
			
				this.searchDistrictlist = TextField.get()
						.getByXpath(".//*[@id='district']/div/div/input");
				this.selectCityList = LabelClickable.get()
						.getByXpath(".//*[@id='locality']/a/span[1]");
				this.searchCityList = TextField.get()
						.getByXpath(".//*[@id='locality']/div/div/input");
				this.street = TextField.get().getById("street");
				this.house = TextField.get().getById("building");
				this.flat = TextField.get().getById("flat");
				this.submitButton = Button.get()
						.getByXpath(".//*[@id='organizationForm']/div[5]/div[1]/button[1]");
				this.cancelButton = Button.get()
						.getByXpath(".//*[@id='organizationForm']/div[5]/div[2]/button");
				this.resetFormButton = Button.get()
						.getByXpath(".//*[@id='organizationForm']/div[5]/div[1]/button[2]");
			}
		}
		OrganizationFormUIMap controlsForm;
		public OrganizationForm() {
			this.controlsForm = new OrganizationFormUIMap();
		}

		
        
		public void setOrganizationName(String organizationName) {
			
			this.controlsForm.organizationName.sendKeysClear(organizationName);
		}

		public void setOrganizationTypeChoose(String organizationType) {
			
			this.controlsForm.organizationTypeChoose.sendKeysClear(organizationType);
			this.controlsForm.organizationTypeChoose.sendKeys(Keys.ENTER.toString());
		}

		public void setPhoneNumber(String phoneNumber) {
			
			this.controlsForm.phoneNumber.sendKeysClear(phoneNumber);
		}

		public void setEmail(String email) {
			
			
			this.controlsForm.email.sendKeysClear(email);
			
			
		}

		public void setMaxSizeEpmloyers(String maxSizeEpmloyers) {
			
			
			this.controlsForm.maxSizeEpmloyers.sendKeysClear(maxSizeEpmloyers);
		}

		public void setMaxTimeForFinishRequestInDays(String maxTimeForFinishRequestInDays) {
			
			this.controlsForm.maxTimeForFinishRequestInDays.sendKeysClear(maxTimeForFinishRequestInDays);
		}

		public void selectRegionFromList(String region) {
			this.controlsForm.selectRegionList.click();
			this.controlsForm.searchRegionList.click();
			this.controlsForm.searchRegionList.sendKeys(region);
			this.controlsForm.searchRegionList.sendKeys(Keys.ENTER.toString());
			
		}

		public void selectDistrictFromList(String district) throws InterruptedException {
			
			this.controlsForm.selectDistrictList.click();
			this.controlsForm.searchDistrictlist.click();
			this.controlsForm.searchDistrictlist.sendKeys(district);
			this.controlsForm.searchDistrictlist.sendKeys(Keys.ENTER.toString());
		}

		public void selectCityFromList(String city) {
			this.controlsForm.selectCityList.click();
			this.controlsForm.searchCityList.click();
			this.controlsForm.searchCityList.sendKeys(city);
			this.controlsForm.searchCityList.sendKeys(Keys.ENTER.toString());
		}

		public void setStreetInForm(String street) {
			
			this.controlsForm.street.sendKeysClear(street);
		}

		public void setHouseInForm(String house) {
			
			this.controlsForm.house.sendKeysClear(house);
		}

		public void setFlatInForm(String flat) {
			
			this.controlsForm.flat.sendKeys(flat);
		}

		public void submitButtonClick() {
			this.controlsForm.submitButton.click();
		}

		public void resetButtonClick() {
			this.controlsForm.resetFormButton.click();
		}

		public void cancelButtonClick() {
			this.controlsForm.cancelButton.click();
		}

		public ITextField getOrganizationName() {
			return this.controlsForm.organizationName;
		}

		public ITextField getOrganizationTypeChoose() {
			return this.controlsForm.organizationTypeChoose;
		}

		public ITextField getPhoneNumber() {
			return this.controlsForm.phoneNumber;
		}

		public ITextField getEmail() {
			return this.controlsForm.email;
		}

		public ITextField getMaxSizeEpmloyers() {
			return this.controlsForm.maxSizeEpmloyers;
		}

		public ITextField getMaxTimeForFinishRequestInDays() {
			return this.controlsForm.maxTimeForFinishRequestInDays;
		}

		public ILabelClickable getSelectRegionList() {
			return this.controlsForm.selectRegionList;
		}

		public ITextField getSearchRegionList() {
			 getSelectRegionList().click();
			 return TextField.get()
						.getByXpath(".//*[@id='region']/div/div/input");
			//return this.controlsForm.searchRegionList;
		}

		public ILabelClickable getSelectDistrictList() {
			return this.controlsForm.selectDistrictList;
		}

		public ITextField getSearchDistrictlist() {
			return this.controlsForm.searchDistrictlist;
		}
		public ILabelClickable getSelectCityList() {
			return this.controlsForm.selectCityList;
		}
		public ITextField getStreet() {
			return this.controlsForm.street;
		}

		public ITextField getHouse() {
			return this.controlsForm.house;
		}

		public ITextField getFlat() {
			return this.controlsForm.flat;
		}

		public IButton getSubmitButton() {
			return this.controlsForm.submitButton;
		}

		public IButton getResetFormButton() {
			return this.controlsForm.resetFormButton;
		}

		public IButton getCancelButton() {
			return this.controlsForm.cancelButton;
		}

	}

	public  class AddNewOrganizationForm extends OrganizationForm {
		private class AddNewOrganizationFormUIMap{
			private ITextField adminName;
			private ITextField adminLastName;
			private ITextField adminSureName;
			private ITextField loginForSystemAdmin;
			private ITextField passwordForSystemAdmin;
			private ITextField confirmPasswordForSystemAdmin;
			
			public AddNewOrganizationFormUIMap(){
				this.adminName = TextField.get().getById("firstName");
				this.adminLastName = TextField.get().getByName("lastName");	
				this.adminSureName = TextField.get().getById("middleName");
				this.loginForSystemAdmin = TextField.get().getById("username");
				this.passwordForSystemAdmin = TextField.get().getByName("password");
				this.confirmPasswordForSystemAdmin = TextField.get().getByName("rePassword");
			}
		}
		
        AddNewOrganizationFormUIMap controlsFormAdd;
		public  AddNewOrganizationForm() {
                this.controlsFormAdd = new AddNewOrganizationFormUIMap();
			
		}

		public void setAdminFirstName(String firstname){
			this.controlsFormAdd.adminName.sendKeysClear(firstname);
		}

		public void setAdminLastName(String lastname){
			this.controlsFormAdd.adminLastName.sendKeysClear(lastname);
		}
		public void setAdminSureName(String surename){
			this.controlsFormAdd.adminSureName.sendKeysClear(surename);
		}
		
		public void setLoginForSystemAdmin(String loginForSystemAdmin) {
			this.controlsFormAdd.loginForSystemAdmin.sendKeysClear(loginForSystemAdmin);
		}

		public void setPasswordForSystemAdmin(String passwordForSystemAdmin) {
			
			this.controlsFormAdd.passwordForSystemAdmin.sendKeysClear(passwordForSystemAdmin);
		}

		public void setConfirmPasswordForSystemAdmin(String confirmPasswordForSystemAdmin) {
			
			this.controlsFormAdd.confirmPasswordForSystemAdmin.sendKeysClear(confirmPasswordForSystemAdmin);
		}

		
		
		public ITextField getAdminFirstName(){
			return this.controlsFormAdd.adminName;
		}
		public ITextField getAdminLastName(){
			return this.controlsFormAdd.adminLastName;
		}
		public ITextField getAdminSureName(){
			return this.controlsFormAdd.adminSureName;
		}
		public ITextField getLoginForSystemAdmin() {
			return this.controlsFormAdd.loginForSystemAdmin;
		}

		public ITextField getPasswordForSystemAdmin() {
			return this.controlsFormAdd.passwordForSystemAdmin;
		}

		public ITextField getConfirmPasswordForSystemAdmin() {
			return this.controlsFormAdd.confirmPasswordForSystemAdmin;
		}

		private void setOrganizationData(IOrganization organization) throws InterruptedException {
			
			setOrganizationName(organization.getOrganizationName());
			setOrganizationTypeChoose(organization.getOrganizationTypeChoose());
			setPhoneNumber(organization.getPhoneNumber());
			
			setEmail(organization.getEmail());
			setMaxSizeEpmloyers(organization.getMaxSizeEpmloyers());
			setMaxTimeForFinishRequestInDays(organization.getMaxTimeForFinishRequestInDays());
			setAdminFirstName(organization.getAdminFirstName());
			setAdminLastName(organization.getAdminLastName());
			setAdminSureName(organization.getAdminSureName());
			setLoginForSystemAdmin(organization.getLoginForSystemAdmin());
			setPasswordForSystemAdmin(organization.getPasswordForSystemAdmin());
			setConfirmPasswordForSystemAdmin(organization.getConfirmPasswordForSystemAdmin());
			selectRegionFromList(organization.getSearchRegionList());
			
			selectDistrictFromList(organization.getSearchDistrictlist());
			
			selectCityFromList(organization.getSearchCityList());
			setStreetInForm(organization.getStreet());
			setHouseInForm(organization.getHouse());
			setFlatInForm(organization.getFlat());
			submitButtonClick();
		}
		public OrganizationPage successAddOrganization(IOrganization newOrg) throws InterruptedException {
			//addNewOrganizationClick();
			//AddNewOrganizationForm newOrganization = new AddNewOrganizationForm();
			//newOrganization.setOrganizationData(newOrg);
			setOrganizationData(newOrg);
			return new OrganizationPage();
		}

	}

	private class OrganizationTable {
		private List<WebElement> nameRows;
		private List<WebElement> allNameRows;
		private List<WebElement> paginationsButtons;
		private WebElement pagButton;

		OrganizationTable() {
			
		}

//		public void initTableElements() {
//			this.nameRows = driver.findElements(By.xpath(".//*[@id='organizationsTable']/tbody/tr/td[2]"));
//			this.paginationsButtons = driver
//					.findElements(By.xpath(".//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[3]/div/ul/li/a"));
//			this.pagButton = driver
//					.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div/div/div[2]/div[3]/div/ul/li[5]/a"));
//		}

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
    
	private class OrganizationPageUIMap{
		
		private IButton addOrganizationButton;
		public OrganizationPageUIMap(){
			this.addOrganizationButton = Button.get().getByXpath(".//*[@id='page-wrapper']/div[2]/div/button");
		}
	}
	
    OrganizationPageUIMap organizationPageControls; 
	public OrganizationPage() {
		this.organizationPageControls = new OrganizationPageUIMap();
	
	}

	

	public void addOrganizationButtonClick() {
		this.organizationPageControls.addOrganizationButton.click();
	}

	public AddNewOrganizationForm addNewOrganizationClick() {
		addOrganizationButtonClick();
		return new OrganizationPage.AddNewOrganizationForm();
	}

	

	
}
