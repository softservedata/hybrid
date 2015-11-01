package com.softserve.edu.counters.pages;

import com.softserve.edu.atqc.tools.controls.ILabel;
import com.softserve.edu.atqc.tools.controls.Label;


public class LoginPageValidator extends LoginPage{
	
	  public static enum LoginPageMessages {
	        VALIDATOR_TEXT("Не вдалось залогуватись, перевірте коректність введених даних");

	        private String field;

	        private LoginPageMessages(String field) {
	            this.field = field;
	        }

	        public int getLenght() {
	            return this.field.length();
	        }

	        @Override
	        public String toString() {
	            return this.field;
	        }
	    }

	    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	    
	    private class LoginPageValidatorUIMap {
	        public final ILabel validator;

	        public LoginPageValidatorUIMap() {
	            this.validator = Label.get().getById("incorrectLoginMessage");
	        }
	    }

	    // Elements
	    private LoginPageValidatorUIMap controls;

	    public LoginPageValidator() {
	        this.controls = new LoginPageValidatorUIMap();
	    }

	    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	    public ILabel getValidator() {
	        return this.controls.validator;
	    }

	    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	    public String getValidatorText() {
	    	return getValidator().getText();
	    }
}
