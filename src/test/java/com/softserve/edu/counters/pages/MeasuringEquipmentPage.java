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
import com.softserve.edu.atqc.tools.search.ContextUtils;
import com.softserve.edu.counters.data.equipment.IEquipment;

public class MeasuringEquipmentPage extends ForLoggedUserPage {

	private class Table {

		private class Row {
			public final WebElement row;
			public final WebElement id;
			public final WebElement deviceName;
			public final WebElement deviceType;
			public final WebElement deviceManufacturer;
			public final WebElement deviceVerificationInterval;
			public final WebElement edit;
			public final WebElement remove;

			Row(WebElement row) {
				this.row = row;
				List<WebElement> elements = row.findElements(By.tagName("td"));
				this.id = elements.get(0);
				this.deviceName = elements.get(1);
				this.deviceType = elements.get(2);
				this.deviceManufacturer = elements.get(3);
				this.deviceVerificationInterval = elements.get(4);
				List<WebElement> actions = row.findElements(By.tagName("img"));
				this.edit = actions.get(0);
				this.remove = actions.get(1);

			}

			public ChangeMeasuringEquipmentForm editClick() {
				edit.click();
				return new ChangeMeasuringEquipmentForm();
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

		public Row getRow(String name) {
			for (Row row : rows) {
				if (row.deviceName.getText().equals(name))
					return row;
			}
			return null;
		}

	}

	private abstract class MeasuringEquipmentForm {

		private class MeasuringEquipmentFormUIMap {
			public final ITextField deviceName;
			public final ITextField deviceType;
			public final ITextField deviceManufacturer;
			public final ITextField deviceVerificationInterval;

			public MeasuringEquipmentFormUIMap() {
				this.deviceName = TextField.get().getById("name");
				this.deviceType = TextField.get().getById("deviceType");
				this.deviceManufacturer = TextField.get().getById("manufacturer");
				this.deviceVerificationInterval = TextField.get().getById("verificationInterval");
			}
		}
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

		// Elements
		private MeasuringEquipmentFormUIMap controls;

		public MeasuringEquipmentForm() {
			controls = new MeasuringEquipmentFormUIMap();
		}

		public void setDeviceName(String name) {
			this.controls.deviceName.clear();
			this.controls.deviceName.click();
			this.controls.deviceName.sendKeys(name);
		}

		public void setDeviceType(String type) {
			this.controls.deviceType.clear();
			this.controls.deviceType.click();
			this.controls.deviceType.sendKeys(type);
		}

		public void setDeviceManufacturer(String manufacturer) {
			this.controls.deviceManufacturer.clear();
			this.controls.deviceManufacturer.click();
			this.controls.deviceManufacturer.sendKeys(manufacturer);
		}

		public void setDeviceVerificationInterval(String verificationInterval) {
			this.controls.deviceVerificationInterval.clear();
			this.controls.deviceVerificationInterval.click();
			this.controls.deviceVerificationInterval.sendKeys(verificationInterval);
		}

	}

	private class AddMeasuringEquipmentForm extends MeasuringEquipmentForm {

		private class AddMeasuringEquipmentFormUIMap {

			public final IButton submit;
		//	public final IComponent form;

			public AddMeasuringEquipmentFormUIMap() {
				this.submit = Button.get().getByXpath("(//button[@type='submit'])[2]");
		//		this.form = Component.get().getByXpath("//div[@class='modal-dialog']");
			}
		}
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

		// Elements
		private AddMeasuringEquipmentFormUIMap controls;

		public AddMeasuringEquipmentForm() {
			controls = new AddMeasuringEquipmentFormUIMap();
		}

		public AgreeWithAddEquipmentForm setAddNewEquipmentData(IEquipment equipment) {
			setDeviceName(equipment.getName());
			setDeviceType(equipment.getType());
			setDeviceManufacturer(equipment.getManufacturer());
			setDeviceVerificationInterval(equipment.getVerificationInterval());
			controls.submit.click();
			return new AgreeWithAddEquipmentForm();
		}

	}

	private class ChangeMeasuringEquipmentForm extends MeasuringEquipmentForm {

		private class ChangeMeasuringEquipmentFormUIMap {

			public final IButton change;
			public final IComponent form;

			public ChangeMeasuringEquipmentFormUIMap() {
				this.change = Button.get().getByXpath("/html/body/div[3]/div/div/div[2]/form/div[5]/div[1]/button");
				this.form = Component.get().getByXpath("//div[@class='modal-dialog']");
			}
		}
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

		// Elements
		private ChangeMeasuringEquipmentFormUIMap controls;

		public ChangeMeasuringEquipmentForm() {
			controls = new ChangeMeasuringEquipmentFormUIMap();
		}

	}

	private class AgreeWithAddEquipmentForm {
		private class AgreeWithAddEquipmentFormUIMap {
			public final IButton agree;
		//	public final IComponent form;

			public AgreeWithAddEquipmentFormUIMap() {
				this.agree = Button.get().getByXpath("//body/div[3]/div/div/div[2]/button");
			//	this.form = Component.get().getByXpath("modal-dialog modal-md");
			//	modal-dialog modal-md

			}
		}
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

		// Elements
		private AgreeWithAddEquipmentFormUIMap controls;

		public AgreeWithAddEquipmentForm() {
			controls = new AgreeWithAddEquipmentFormUIMap();
		}

	}

	private class MeasuringEquipmentPageUIMap {
		public final IButton addNewEquipment;
		public final ITextField fieldForSearchName;
		public Table table;

		public MeasuringEquipmentPageUIMap() {
			this.addNewEquipment = Button.get().getByXpath("//button[@type='submit']");
			this.fieldForSearchName = TextField.get().getByTagName("input");
			this.table = new Table();
		}
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Elements
	private MeasuringEquipmentPageUIMap controls;

	public MeasuringEquipmentPage() {
		controls = new MeasuringEquipmentPageUIMap();
	}

	// PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public void addNewEquipmentClick() {
		controls.addNewEquipment.click();
	}

	// Buisnes--------------------------------------------------------------
	public void successAddEquipment(IEquipment equipment) {
	addNewEquipmentClick();
//		AgreeWithAddEquipmentForm agreeWithAddEquipmentForm = new AddMeasuringEquipmentForm()
//				.setAddNewEquipmentData(equipment);
//		agreeWithAddEquipmentForm.controls.agree.click();
//		ContextUtils.get().isStatelessOfWebElement(agreeWithAddEquipmentForm.controls.form.getWrapper());
		 (new AddMeasuringEquipmentForm()).setAddNewEquipmentData(equipment).controls.agree.click();
	}

	public void searchName(String name) {
		this.controls.fieldForSearchName.clear();
		this.controls.fieldForSearchName.click();
		this.controls.fieldForSearchName.sendKeys(name);
		this.controls.table = new Table();
	}

	public String getNameFromRow(IEquipment equipment) {
		return this.controls.table.getRow(equipment.getName()).deviceName.getText();
	}

	public String getTypeFromRow(IEquipment equipment) {
		return this.controls.table.getRow(equipment.getName()).deviceType.getText();
	}

	public String getManufacturerFromRow(IEquipment equipment) {
		return this.controls.table.getRow(equipment.getName()).deviceManufacturer.getText();
	}

	public String getVerificationIntervalFromRow(IEquipment equipment) {
		return this.controls.table.getRow(equipment.getName()).deviceVerificationInterval.getText();
	}

	public void deleteEquipment(IEquipment equipment) {
		this.controls.table.getRow(equipment.getName()).remove.click();
	}

	public void successChangeManufacturerEquipment(IEquipment equipment) {
		ChangeMeasuringEquipmentForm changeMeasuringEquipmentForm = this.controls.table.getRow(equipment.getName())
				.editClick();
		changeMeasuringEquipmentForm.setDeviceManufacturer(equipment.getManufacturer());
		changeMeasuringEquipmentForm.controls.change.click();
		ContextUtils.get().isStatelessOfWebElement(changeMeasuringEquipmentForm.controls.form.getWrapper());
	}

	public boolean isRowExist(IEquipment equipment) {
		if (this.controls.table.getRow(equipment.getName()) == null) {
			return false;
		}
		return true;
	}

}
