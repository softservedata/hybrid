package com.softserve.edu.atqc.tools.verifications;

public final class TextCriteria {
    private final String DOES_NOT_MATCH = "Values do not match. Expected Result: %s ActualResult: %s";
    private String text;

    private TextCriteria(String text) {
        this.text = text;
    }

    public static TextCriteria get(String text) {
        return new TextCriteria(text);
    }

    public TextCriteria valueMatch(String expectedResult) {
        AssertWrapper.get().verify(text.equals(expectedResult),
                String.format(DOES_NOT_MATCH, expectedResult, text));
        return this;
    }

    public TextCriteria valueMatch(Integer expectedResult) {
        AssertWrapper.get().verify(text.equals(expectedResult.toString()),
                String.format(DOES_NOT_MATCH, expectedResult, text));
        return this;
    }

    public TextCriteria valueStartsWith(String expectedResult) {
        AssertWrapper.get().verify(text.startsWith(expectedResult),
                String.format(DOES_NOT_MATCH, expectedResult, text));
        return this;
    }

    public TextCriteria valueByPartialText(String expectedResult) {
        AssertWrapper.get().verify(text.contains(expectedResult),
                String.format(DOES_NOT_MATCH, expectedResult, text));
        return this;
    }

    public AssertWrapper next() {
        return AssertWrapper.get();
    }

}
