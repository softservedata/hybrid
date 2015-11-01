package com.softserve.edu.counters.data.equipment;

interface IName {
	IType setName(String name);
}

interface IType {
	IManufacturer setType(String type);
}

interface IManufacturer {
	IVerificationInterval setManufacturer(String manufacturer);
}

interface IVerificationInterval {
	IBuild setVerificationInterval(String verificationInterval);
}

interface IBuild {
	IEquipment build();
}

public class Equipment implements IEquipment, IName, IType, IManufacturer, IVerificationInterval, IBuild {

	String name;
	String type;
	String manufacturer;
	String verificationInterval;

	private Equipment() {
	}

	public static IName get() {
		return new Equipment();
	}

	@Override
	public IType setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public IManufacturer setType(String type) {
		this.type = type;
		return this;
	}

	@Override
	public IVerificationInterval setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
		return this;
	}

	@Override
	public IBuild setVerificationInterval(String verificationInterval) {
		this.verificationInterval = verificationInterval;
		return this;
	}

	@Override
	public IEquipment build() {
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getManufacturer() {
		return manufacturer;
	}

	@Override
	public String getVerificationInterval() {
		return verificationInterval;
	}

}

// }
