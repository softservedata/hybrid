package com.softserve.edu.atqc.tools.verifications;

import com.softserve.edu.atqc.tools.controls.ILink;

public final class LinkCriteria implements ILinkCriteriaNext {
	private final String DOES_NOT_MATCH = "Values doesn't match. Expected Result %s ActualResult %s";
	private final String IT_IS_NOT_VISIBLE = "Link it's not visible";
	private ILink link;

	private LinkCriteria(ILink link) {
		this.link = link;
	}

	public static ILinkCriteria get(ILink link) {
		return new LinkCriteria(link);
	}

	public ILinkCriteriaNext urlMatch(String expectedResult) {
	    AssertWrapper.get().verify(link.getUrl().equals(expectedResult),
				String.format(DOES_NOT_MATCH, expectedResult, link.getUrl()));
		return this;
	}

	public ILinkCriteriaNext valueMatch(String expectedResult) {
	    AssertWrapper.get().verify(link.getText().equals(expectedResult),
				String.format(DOES_NOT_MATCH, expectedResult, link.getText()));
		return this;
	}

	public ILinkCriteriaNext valueStartsWith(String expectedResult) {
	    AssertWrapper.get().verify(link.getText().startsWith(expectedResult),
				String.format(DOES_NOT_MATCH, expectedResult, link.getText()));
		return this;
	}

	public ILinkCriteriaNext valueByPartialText(String expectedResult) {
	    AssertWrapper.get().verify(link.getText().contains(expectedResult),
				String.format(DOES_NOT_MATCH, expectedResult, link.getText()));
		return this;
	}

	public ILinkCriteriaNext  isVisible() {
	    AssertWrapper.get().verify(link.isDisplayed(), IT_IS_NOT_VISIBLE);
		return this;
	}

    public AssertWrapper next() {
        return AssertWrapper.get();
    }

}
