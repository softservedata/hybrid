package com.softserve.edu.oms.pages;

import com.softserve.edu.atqc.tools.controls.ILabel;
import com.softserve.edu.atqc.tools.controls.Label;

public class ValidatorLoginPage extends LoginPage {

    public static enum LoginPageMessages {
        VALIDATOR_TEXT("Your login attempt was not successful, try again.");

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
    
    private class ValidatorLoginPageUIMap {
        public final ILabel validator;

        public ValidatorLoginPageUIMap() {
            this.validator = Label.get().getByXpath("//div[@id='edit']//font");
            //this.validator = Label.get().getByXpath("//font[@color='red']");
        }
    }

    // Elements
    private ValidatorLoginPageUIMap controls;

    public ValidatorLoginPage() {
        this.controls = new ValidatorLoginPageUIMap();
    }

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public ILabel getValidator() {
        return this.controls.validator;
    }

    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public String getValidatorText() {
        return getValidator().getText().trim().substring(0, LoginPageMessages.VALIDATOR_TEXT.getLenght());
    }

}
