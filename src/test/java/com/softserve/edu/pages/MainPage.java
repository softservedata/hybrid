package com.softserve.edu.pages;

import com.softserve.edu.atqc.tools.controls.ILink;
import com.softserve.edu.atqc.tools.controls.Link;
import com.softserve.edu.atqc.tools.search.ContextUtils;

public class MainPage {

	private class MainPageUIMap {
		public final ILink logIn;

		public MainPageUIMap() {
			this.logIn = Link.get().getByPartialLinkText("Увійти");
		}

	}

	public MainPageUIMap controls;

	public MainPage() {

		this.controls = new MainPageUIMap();

	}

	public void logInButtonClick() {
		
		this.controls.logIn.click();
	}

	public LoginPage gotoLoginPage() throws Exception {
		//Thread.sleep(3);
		logInButtonClick();
		return new LoginPage();
	}
}
