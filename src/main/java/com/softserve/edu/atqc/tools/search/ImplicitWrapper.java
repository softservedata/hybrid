package com.softserve.edu.atqc.tools.search;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.atqc.tools.exceptions.ScreenCapturingCustomException;

public class ImplicitWrapper implements IContext {
    private static volatile ImplicitWrapper instance = null;
    private long implicitlyWaitTimeout = 10L;
    
    private ImplicitWrapper() {
    }

    public static ImplicitWrapper get() {
        if (instance == null) {
            synchronized (ImplicitWrapper.class) {
                if (instance == null) {
                    instance = new ImplicitWrapper();
                }
            }
        }
        WebDriverUtils.get().getWebDriver()
            .manage().timeouts().implicitlyWait(instance.implicitlyWaitTimeout, TimeUnit.SECONDS);
        return instance;
    }
    
    public void setImplicitlyWaitTimeout(long implicitlyWaitTimeout) {
        this.implicitlyWaitTimeout = implicitlyWaitTimeout;
        WebDriverUtils.get().getWebDriver()
            .manage().timeouts().implicitlyWait(implicitlyWaitTimeout, TimeUnit.SECONDS);
    }

    public long getImplicitlyWaitTimeout() {
        return this.implicitlyWaitTimeout;
    }

    public WebElement getVisibleWebElement(ByWrapper byWrapper){
        WebElement result = WebDriverUtils.get().getWebDriver().findElement(byWrapper.getBy());
        if (!(result.isDisplayed())) {
            throw new ScreenCapturingCustomException(String.format(ContextUtils.ERROR_NOT_FOUND, byWrapper.getValue()));
        }
        return result;
    }
    
    public List<WebElement> getVisibleWebElements(ByWrapper byWrapper){
        int countInvisibleWebElements = 0;
        List<WebElement> results = WebDriverUtils.get().getWebDriver().findElements(byWrapper.getBy());
        for (WebElement webElement : results) {
            if (!(webElement.isDisplayed())) {
                countInvisibleWebElements++;
            }
        }
        if (countInvisibleWebElements == results.size()) {
            throw new ScreenCapturingCustomException(String.format(ContextUtils.ERROR_NOT_FOUND, byWrapper.getValue()));
        }
        return results;
    }
    
    public WebElement getPresentWebElement(ByWrapper byWrapper){
        return WebDriverUtils.get().getWebDriver().findElement(byWrapper.getBy());
    }
    
    public boolean isInvisibleWebElement(ByWrapper byWrapper){
    	//TODO
    	setImplicitlyWaitTimeout(1);
        boolean isWebElementVisible = true;
        long beginTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - beginTime < ContextUtils.ONE_SECOND * getImplicitlyWaitTimeout()) {
            try {
                WebDriverUtils.get().getWebDriver().findElement(byWrapper.getBy());
                Thread.sleep(ContextUtils.ONE_SECOND / 2);
            } catch (NoSuchElementException e) {
                isWebElementVisible = false;
                break;
            } catch (Exception e) {
                throw new ScreenCapturingCustomException(
                        String.format(ContextUtils.ERROR_STILL_VISIBLE, byWrapper.getValue()));
            }
        }
        setImplicitlyWaitTimeout(implicitlyWaitTimeout);
        return isWebElementVisible;
    }
    
    public boolean isStatelessOfWebElement(WebElementWrapper webElementWrapper){
    	//TODO
    	setImplicitlyWaitTimeout(1);
        boolean isStalenessWebElement = false;
        long beginTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - beginTime < ContextUtils.ONE_SECOND * getImplicitlyWaitTimeout()) {
            try {
                webElementWrapper.isDisplayed();
                Thread.sleep(ContextUtils.ONE_SECOND / 2);
            } catch (StaleElementReferenceException e) {
                isStalenessWebElement = true;
                break;
            } catch (Exception e) {
                throw new ScreenCapturingCustomException(
                        String.format(ContextUtils.ERROR_STILL_VISIBLE,
                                webElementWrapper.getWebElement().getTagName()));
            }
        }
        setImplicitlyWaitTimeout(implicitlyWaitTimeout);
        return isStalenessWebElement;
    }
    
    public boolean isVisibleTitle(String partialTitle){
        boolean isVisibleTitlePage = false;
        long beginTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - beginTime < ContextUtils.ONE_SECOND * getImplicitlyWaitTimeout()) {
        	if (WebDriverUtils.get().getWebDriver().getTitle().toLowerCase().contains(partialTitle.toLowerCase())) {
                isVisibleTitlePage = true;
                break;
            }
            try {
                Thread.sleep(ContextUtils.ONE_SECOND / 2);
            } catch (Exception e) {
                throw new ScreenCapturingCustomException(
                        String.format(ContextUtils.ERROR_TITLE_INVISIBLE, partialTitle));
            }
        }
        return isVisibleTitlePage;
    }
    
    public boolean isVisibleText(ByWrapper byWrapper, String partialTitle){
        boolean isVisibleTitlePage = false;
        long beginTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - beginTime < ContextUtils.ONE_SECOND * getImplicitlyWaitTimeout()) {
//        	WebDriverUtils.get().getWebDriver().findElement(byWrapper.getBy());
//            Thread.sleep(ContextUtils.ONE_SECOND / 2);
        	if (WebDriverUtils.get().getWebDriver().findElement(byWrapper.getBy()).getText().contains(partialTitle)) {
                isVisibleTitlePage = true;
                break;
            }
            try {
                Thread.sleep(ContextUtils.ONE_SECOND / 2);
            } catch (Exception e) {
                throw new ScreenCapturingCustomException(
                        String.format(ContextUtils.ERROR_TITLE_INVISIBLE, partialTitle));
            }
        }
        return isVisibleTitlePage;
    }

}
