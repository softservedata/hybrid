package com.softserve.edu.atqc.tools.verifications;

public interface ITextFieldCriteria {

    ITextFieldCriteriaNext attributeMatch(String attribute, String expectedResult);

    ITextFieldCriteriaNext valueMatch(String expectedResult);

    ITextFieldCriteriaNext valueStartsWith(String expectedResult);

    ITextFieldCriteriaNext valueByPartialText(String expectedResult);

    ITextFieldCriteriaNext isVisible();

}
