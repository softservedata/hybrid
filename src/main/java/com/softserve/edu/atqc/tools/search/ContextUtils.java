package com.softserve.edu.atqc.tools.search;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.atqc.tools.exceptions.GeneralCustomException;

public final class ContextUtils {
    public static final long ONE_SECOND = 1000L;
	public static final String ERROR_NOT_FOUND = "WebElement(s) was not found %s";
	public static final String ERROR_STILL_VISIBLE = "WebElement is Still Visible %s";
    public static final String ERROR_TITLE_INVISIBLE = "Title Invisible %s";
    public static final String ERROR_LOAD_FAILED = "Web Page Load Failed";
	private static volatile ContextUtils instance = null;
    private List<IObserveLoad> observeLoad; 
	private IContext context;

	private ContextUtils() {
        this.observeLoad = new ArrayList<IObserveLoad>();
	    this.context = ContextRepository.getExplicitWrapper();
	}

	public static ContextUtils get() {
		if (instance == null) {
			synchronized (ContextUtils.class) {
				if (instance == null) {
					instance = new ContextUtils();
				}
			}
		}
		return instance;
	}

	// Set Strategy.
    public ContextUtils setContext(IContext context) {
        synchronized (ContextUtils.class) {
            this.context = context;
        }
        return this;
    }

    public ContextUtils setImplicitWrapper() {
        return setContext(ContextRepository.getImplicitWrapper());
    }

    public ContextUtils setExplicitWrapper() {
        return setContext(ContextRepository.getExplicitWrapper());
    }

    /**
	 * An expectation for checking that an element is present on the DOM of a
	 * page and visible.
	 */
    WebElement getVisibleWebElement(ByWrapper byWrapper) {
		return context.getVisibleWebElement(byWrapper);
	}

	/**
	 * An expectation for checking that all elements present on the web page
	 * that match the locator are visible.
	 */
	List<WebElement> getVisibleWebElements(ByWrapper byWrapper) {
        return context.getVisibleWebElements(byWrapper);
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a
	 * page. This does not necessarily mean that the element is visible.
	 */
	WebElement getPresentWebElement(ByWrapper byWrapper) {
        return context.getPresentWebElement(byWrapper);
    }

	/**
	 * An expectation for checking that an element is either invisible or not
	 * present on the DOM.
	 */
	public boolean isInvisibleWebElement(ByWrapper byWrapper) {
	    return context.isInvisibleWebElement(byWrapper);
	}

	/**
	 * Wait until an element is no longer attached to the DOM.
	 * Do not mix implicit and explicit waits.
	 */
    public boolean isStalenessOfWebElement(WebElementWrapper webElementWrapper) {
        return context.isStatelessOfWebElement(webElementWrapper);
    }

	Select getVisibleSelectWebElement(ByWrapper byWrapper) {
		return new Select(getVisibleWebElement(byWrapper));
	}

	Select getVisibleSelectWebElement(WebElementWrapper webElementWrapper) {
		return new Select(webElementWrapper.getWebElement());
	}

	Select getPresentSelectWebElement(ByWrapper byWrapper) {
		return new Select(getPresentWebElement(byWrapper));
	}

	Select getPresentSelectWebElement(WebElementWrapper webElementWrapper) {
		return new Select(webElementWrapper.getWebElement());
	}

    public boolean isVisibleTitle(String partialTitle) {
        return context.isVisibleTitle(partialTitle);
    }

    public void addLoadCompleteEvent(IObserveLoad observeLoad){
        this.observeLoad.add(observeLoad);
    }

    public void deleteLoadCompleteEvents(){
        this.observeLoad.clear();
    }

    public boolean isLoadComplete() {
        int countLoadCompletePages = 0;
        long beginTime;
        for (IObserveLoad currentObserveLoad : this.observeLoad) {
            beginTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - beginTime < ONE_SECOND
                    * ImplicitWrapper.get().getImplicitlyWaitTimeout()) {
                if (currentObserveLoad.loadComplete()) {
                    countLoadCompletePages++;
                    break;
                }
                try {
                    Thread.sleep(ContextUtils.ONE_SECOND / 2);
                } catch (Exception e) {
                    throw new GeneralCustomException(String.format(ContextUtils.ERROR_LOAD_FAILED,
                            WebDriverUtils.get().getWebDriver().getCurrentUrl()));
                }
            }
        }
        if (countLoadCompletePages != this.observeLoad.size()) {
            throw new GeneralCustomException(
                    String.format(ContextUtils.ERROR_LOAD_FAILED, WebDriverUtils.get().getWebDriver().getCurrentUrl()));
        }
        return countLoadCompletePages == this.observeLoad.size();
    }

}
