package com.softserve.edu.atqc.tools.controls;

//public class Labels implements ILabel {

public final class Labels extends GLabel<ILabel> {

	private Labels() {
	}

	public static AComponent<ILabel> get() {
		Labels instance = new Labels();
		instance.setTComponent(instance);
		return instance;
	}

}
