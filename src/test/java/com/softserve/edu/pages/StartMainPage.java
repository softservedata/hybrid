package com.softserve.edu.pages;

import com.softserve.edu.atqc.tools.browsers.ABrowser;
import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.atqc.tools.search.ByWrapper;
import com.softserve.edu.atqc.tools.search.ContextUtils;
import com.softserve.edu.atqc.tools.search.ImplicitWrapper;

public class StartMainPage extends MainPage {

	public StartMainPage() {
		super();
	}

	public static MainPage load(ABrowser browser, String url) {
		// driver = new FirefoxDriver();
		// driver.get(url);s
		ContextUtils.get().addLoadCompleteEvent(new PageLoadComplete());
		//ContextUtils.get().isInvisibleWebElement(ByWrapper.getById("loader-wrapper"));
		WebDriverUtils.get(browser).loadPage(url);
		
		return new StartMainPage();
	}
}
