package com.softserve.edu.atqc.tools.verifications;

import com.softserve.edu.atqc.tools.controls.ILabel;

public final class LabelCriteria implements ILabelCriteriaNext {
	private final String DOES_NOT_MATCH = "Values doesn't match. Expected Result %s ActualResult %s";
	private final String IT_IS_NOT_VISIBLE = "Label it's not visible";
	private ILabel label;

	private LabelCriteria(ILabel label) {
		this.label = label;
	}

	public static ILabelCriteria get(ILabel label) {
		return new LabelCriteria(label);
	}

	public ILabelCriteriaNext valueMatch(String expectedResult) {
	    AssertWrapper.get().verify(label.getText().equals(expectedResult),
				String.format(DOES_NOT_MATCH, expectedResult, label.getText()));
		return this;
	}

	public ILabelCriteriaNext valueStartsWith(String expectedResult) {
	    AssertWrapper.get().verify(label.getText().startsWith(expectedResult),
				String.format(DOES_NOT_MATCH, expectedResult, label.getText()));
		return this;
	}

	public ILabelCriteriaNext valueByPartialText(String expectedResult) {
	    AssertWrapper.get().verify(label.getText().contains(expectedResult),
				String.format(DOES_NOT_MATCH, expectedResult, label.getText()));
		return this;
	}

	public ILabelCriteriaNext isVisible() {
	    AssertWrapper.get().verify(label.isDisplayed(), IT_IS_NOT_VISIBLE);
		return this;
	}

    public AssertWrapper next() {
        return AssertWrapper.get();
    }

}
