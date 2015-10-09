package com.softserve.edu.atqc.tools.search;

import org.openqa.selenium.By;

public final class ByWrapper {
	private By by;
	private String value;

	private ByWrapper(By by, String value) {
		this.by = by;
		this.value = value;
	}

	public static ByWrapper getById(String id) {
		return new ByWrapper(new By.ById(id), id);
	}

	public static ByWrapper getByName(String name) {
		return new ByWrapper(new By.ByName(name), name);
	}

	public static ByWrapper getByXPath(String xpath) {
		return new ByWrapper(new By.ByXPath(xpath), xpath);
	}

	public static ByWrapper getByPartialLinkText(String partialLinkText) {
		return new ByWrapper(new By.ByPartialLinkText(partialLinkText),
				partialLinkText);
	}

	public static ByWrapper getByCssSelector(String cssSelector) {
		return new ByWrapper(new By.ByCssSelector(cssSelector),
				cssSelector);
	}

	public static ByWrapper getByTagName(String tagName) {
		return new ByWrapper(new By.ByTagName(tagName), tagName);
	}

	By getBy() {
		return by;
	}

	public String getValue() {
		return value;
	}

}
