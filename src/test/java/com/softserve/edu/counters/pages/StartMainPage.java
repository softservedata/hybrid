package com.softserve.edu.counters.pages;

import com.softserve.edu.atqc.tools.browsers.ABrowser;
import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.atqc.tools.search.ContextUtils;

public class StartMainPage extends MainPage {

	private StartMainPage() {
        super();
    }
	
	public static MainPage load(ABrowser browser, String url) {
        ContextUtils.get().addLoadCompleteEvent(new PageLoadComplete());
        WebDriverUtils.get(browser).loadPage(url);
        return new StartMainPage();
    }
	
}
