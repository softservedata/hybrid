package com.softserve.edu.counters.pages;

import com.softserve.edu.atqc.tools.controls.Button;
import com.softserve.edu.atqc.tools.controls.IButton;

public class CalibratorHomePage extends ForLoggedUserPage {
	
	private class CalibratorHomePageUIMap {
        public final IButton employee;
        public final IButton measuringEquipments;

        public CalibratorHomePageUIMap() {
        	this.employee = Button.get().getByPartialLinkText("Працівники");
        	this.measuringEquipments = Button.get().getByPartialLinkText("Довідник засобів вимірювальної техніки (вимірювальна лабораторія)");
        }
    }
	
	 // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Elements
    private CalibratorHomePageUIMap controls;

    public CalibratorHomePage() {
        controls = new CalibratorHomePageUIMap();
    }

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public void linkEmployeeClick() {
		this.controls.employee.click();
	}

	public IButton getEmployee() {
		return this.controls.employee;
	}
	
	public void linkMeasuringEquipmentsClick() {
		this.controls.measuringEquipments.click();
	}

	public IButton getMeasuringEquipments() {
		return this.controls.measuringEquipments;
	}
	
	// business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public EmployeePage goToEmployeePage() {
		linkEmployeeClick();
		return new EmployeePage();
	}
	
	public MeasuringEquipmentPage goToMeasuringEquipmentsPage() {
		linkMeasuringEquipmentsClick();
		return new MeasuringEquipmentPage();
	}

}
