package com.softserve.edu.counters.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.tools.browsers.ABrowser;
import com.softserve.edu.atqc.tools.browsers.BrowserRepository;
import com.softserve.edu.atqc.tools.verifications.AssertWrapper;
import com.softserve.edu.counters.data.IUser;
import com.softserve.edu.counters.data.UrlRepository.Urls;
import com.softserve.edu.counters.data.UserRepository;
import com.softserve.edu.counters.data.equipment.EquipmentRepository;
import com.softserve.edu.counters.data.equipment.IEquipment;
import com.softserve.edu.counters.pages.MeasuringEquipmentPage;
import com.softserve.edu.counters.pages.StartMainPage;

public class MeasuringEquipmentTest {

	@DataProvider
	public Object[][] equipmentProvider() {
		return new Object[][] {
				{ BrowserRepository.getDefault(), Urls.LOCAL_HOST.toString(), UserRepository.getCalibratorUser(), EquipmentRepository.getEquipment() }, };
	}

	@Test(dataProvider = "equipmentProvider")
	public void addEquipment(ABrowser browser, String url, IUser calibratorUser, IEquipment equipment) {

		MeasuringEquipmentPage measuringEquipmentPage = StartMainPage.load(browser, url).goToLoginPage()
				.successAdminLogin(calibratorUser).goToMeasuringEquipmentsPage();
		measuringEquipmentPage.successAddEquipment(equipment);
		measuringEquipmentPage.searchName(equipment.getName());
		
		AssertWrapper.get()
		.forElement(measuringEquipmentPage.getNameFromRow(equipment))
		.valueMatch(equipment.getName())
		.next()
		.forElement(measuringEquipmentPage.getTypeFromRow(equipment))
		.valueMatch(equipment.getType())
		.next()
		.forElement(measuringEquipmentPage.getManufacturerFromRow(equipment))
		.valueMatch(equipment.getManufacturer())
		.next()
		.forElement(measuringEquipmentPage.getVerificationIntervalFromRow(equipment))
		.valueMatch(equipment.getVerificationInterval());
		
		measuringEquipmentPage.deleteEquipment(equipment);
		measuringEquipmentPage.logout();
		
		AssertWrapper.get().check();
	}
	
	@DataProvider
	public Object[][] changedEquipmentProvider() {
		return new Object[][] {
				{ BrowserRepository.getDefault(), Urls.LOCAL_HOST.toString(), UserRepository.getCalibratorUser(), EquipmentRepository.getEquipment(), EquipmentRepository.getChangedEquipment() }, };
	}

	//@Test(dataProvider = "changedEquipmentProvider")
	public void checkCalibratorLogin(ABrowser browser, String url, IUser calibratorUser, IEquipment equipment, IEquipment changedEquipment) {

		MeasuringEquipmentPage measuringEquipmentPage = StartMainPage.load(browser, url).goToLoginPage()
				.successAdminLogin(calibratorUser).goToMeasuringEquipmentsPage();
		measuringEquipmentPage.successAddEquipment(equipment);
		measuringEquipmentPage.searchName(equipment.getName());
		measuringEquipmentPage.successChangeManufacturerEquipment(changedEquipment);
		measuringEquipmentPage.searchName(changedEquipment.getName());
		
		AssertWrapper.get()
		.forElement(measuringEquipmentPage.getNameFromRow(changedEquipment))
		.valueMatch(changedEquipment.getName())
		.next()
		.forElement(measuringEquipmentPage.getTypeFromRow(changedEquipment))
		.valueMatch(changedEquipment.getType())
		.next()
		.forElement(measuringEquipmentPage.getManufacturerFromRow(changedEquipment))
		.valueMatch(changedEquipment.getManufacturer())
		.next()
		.forElement(measuringEquipmentPage.getVerificationIntervalFromRow(changedEquipment))
		.valueMatch(changedEquipment.getVerificationInterval());
		
		measuringEquipmentPage.deleteEquipment(changedEquipment);
		measuringEquipmentPage.logout();
		
		AssertWrapper.get().check();
	}
	
	@Test(dataProvider = "equipmentProvider")
		public void deleteEquipment(ABrowser browser, String url, IUser calibratorUser, IEquipment equipment) {

			MeasuringEquipmentPage measuringEquipmentPage = StartMainPage.load(browser, url).goToLoginPage()
					.successAdminLogin(calibratorUser).goToMeasuringEquipmentsPage();
			measuringEquipmentPage.successAddEquipment(equipment);
			measuringEquipmentPage.searchName(equipment.getName());			
			measuringEquipmentPage.deleteEquipment(equipment);
			measuringEquipmentPage.searchName(equipment.getName());
			
			AssertWrapper.get()
			.verify(measuringEquipmentPage.isRowExist(equipment));
			
			measuringEquipmentPage.logout();
			
			AssertWrapper.get().check();
		}

}
