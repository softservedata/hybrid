package com.softserve.edu.counters.pages;

import com.softserve.edu.atqc.tools.controls.Button;
import com.softserve.edu.atqc.tools.controls.IButton;

public class MainPage {
	
	private class MainPageUIMap {
        public final IButton logIn;

        public MainPageUIMap() {
            this.logIn = Button.get().getByPartialLinkText("Увійти");
        }
    }
	
	 // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Elements
    private MainPageUIMap controls;

    public MainPage() {
        controls = new MainPageUIMap();
    }

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public void linkLogInClick() {
		this.controls.logIn.click();
	}

	public IButton getLogIn() {
		return this.controls.logIn;
	}

    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public LoginPage goToLoginPage() {
		linkLogInClick();
		return new LoginPage();
	}

}
