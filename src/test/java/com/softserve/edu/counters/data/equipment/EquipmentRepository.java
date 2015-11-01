package com.softserve.edu.counters.data.equipment;

public class EquipmentRepository {

	public static IEquipment getEquipment() {
		return Equipment.get()
				.setName("Bosch152")
				.setType("WATER")
				.setManufacturer("Pusto")
				.setVerificationInterval("65")
				.build();
	}
	
	public static IEquipment getChangedEquipment() {
		return Equipment.get()
				.setName("Bosch152")
				.setType("WATER")
				.setManufacturer("Rivne")
				.setVerificationInterval("65")
				.build();
	}

}
