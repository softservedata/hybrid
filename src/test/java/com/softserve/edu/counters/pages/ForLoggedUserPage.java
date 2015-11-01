package com.softserve.edu.counters.pages;

import com.softserve.edu.atqc.tools.controls.Button;
import com.softserve.edu.atqc.tools.controls.IButton;
import com.softserve.edu.atqc.tools.search.ByWrapper;
import com.softserve.edu.atqc.tools.search.WebElementWrapper;

public class ForLoggedUserPage {

	private class DropDownList {

		private class DropDownListUIMap {
			public final IButton logOut;

			public DropDownListUIMap() {
				this.logOut = Button.get().getByPartialLinkText("Вилогуватись");
			}
		}

		private DropDownListUIMap controls;

		protected DropDownList() {
			this.controls = new DropDownListUIMap();
		}

	}

	private class ForLoggedUserPageUIMap {
		public final IButton nameUser;
		//TODO
	//	public ByWrapper nameUserWrapper;

		public ForLoggedUserPageUIMap() {
			this.nameUser = Button.get().getByXpath("//a[@class='dropdown-toggle']/label");
		//	this.nameUserWrapper = ByWrapper.getByXPath("//a[@class='dropdown-toggle']/label");
		}
	}

	private DropDownList dropDownList;

	// Elements
	private ForLoggedUserPageUIMap controls;

	protected ForLoggedUserPage() {
		this.controls = new ForLoggedUserPageUIMap();
	}

	// PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public void nameUserClick() {
		this.controls.nameUser.click();
		this.dropDownList = new DropDownList();
	}

	public IButton getNameUser() {
		return this.controls.nameUser;
	}

	// business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public String getNameUserText() {
		return this.controls.nameUser.getText();
	}
	
	public WebElementWrapper getNameUserWrapper() {
		return this.controls.nameUser.getWrapper();
	}
	
	public ByWrapper getNameUserByWrapper() {
		return this.controls.nameUser.getByWrapperOfElement();
	}
	
	public MainPage logout() {
		nameUserClick();
		dropDownList.controls.logOut.click();
		return new MainPage();
	}

}
