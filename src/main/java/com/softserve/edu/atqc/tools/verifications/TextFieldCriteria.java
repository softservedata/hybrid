package com.softserve.edu.atqc.tools.verifications;

import com.softserve.edu.atqc.tools.controls.ITextField;

public final class TextFieldCriteria implements ITextFieldCriteriaNext {
    private final String DOES_NOT_MATCH = "Values doesn't match. Expected Result %s ActualResult %s";
    private final String IT_IS_NOT_VISIBLE = "TextInput it's not visible";
    private ITextField textField;

    private TextFieldCriteria(ITextField textField) {
        this.textField = textField;
    }

    public static ITextFieldCriteria get(ITextField textField) {
        return new TextFieldCriteria(textField);
    }

    public ITextFieldCriteriaNext attributeMatch(String attribute, String expectedResult) {
        AssertWrapper.get().verify(textField.getAttribute(attribute).equals(expectedResult),
                String.format(DOES_NOT_MATCH, expectedResult, textField.getAttribute(attribute)));
        return this;
    }

    public ITextFieldCriteriaNext valueMatch(String expectedResult) {
        AssertWrapper.get().verify(textField.getText().equals(expectedResult),
                String.format(DOES_NOT_MATCH, expectedResult, textField.getText()));
        return this;
    }

    public ITextFieldCriteriaNext valueStartsWith(String expectedResult) {
        AssertWrapper.get().verify(textField.getText().startsWith(expectedResult),
                String.format(DOES_NOT_MATCH, expectedResult, textField.getText()));
        return this;
    }

    public ITextFieldCriteriaNext valueByPartialText(String expectedResult) {
        AssertWrapper.get().verify(textField.getText().contains(expectedResult),
                String.format(DOES_NOT_MATCH, expectedResult, textField.getText()));
        return this;
    }

    public ITextFieldCriteriaNext isVisible() {
        AssertWrapper.get().verify(textField.isDisplayed(), IT_IS_NOT_VISIBLE);
        return this;
    }

    public AssertWrapper next() {
        return AssertWrapper.get();
    }

}
