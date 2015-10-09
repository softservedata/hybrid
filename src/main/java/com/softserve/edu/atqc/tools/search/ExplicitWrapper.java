package com.softserve.edu.atqc.tools.search;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.atqc.tools.browsers.WebDriverUtils;
import com.softserve.edu.atqc.tools.exceptions.ScreenCapturingCustomException;

public class ExplicitWrapper implements IContext {
    private static volatile ExplicitWrapper instance = null;
    private long explicitlyWaitTimeout = 10L;
    
    private ExplicitWrapper() {
    }

    public static ExplicitWrapper get() {
        if (instance == null) {
            synchronized (ExplicitWrapper.class) {
                if (instance == null) {
                    instance = new ExplicitWrapper();
                }
            }
        }
        WebDriverUtils.get().getWebDriver()
            .manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
        return instance;
    }

    public void setExplicitlyWaitTimeout(long explicitlyWaitTimeout) {
        this.explicitlyWaitTimeout = explicitlyWaitTimeout;
        WebDriverUtils.get().getWebDriver()
            .manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
    }

    public long getExplicitlyWaitTimeout() {
        return this.explicitlyWaitTimeout;
    }
    
    public WebElement getVisibleWebElement(ByWrapper byWrapper){
        WebElement webElement = null;
        try {
            webElement = new WebDriverWait(
                    WebDriverUtils.get().getWebDriver(),
                        getExplicitlyWaitTimeout())
                .until(ExpectedConditions
                    .visibilityOfElementLocated(byWrapper.getBy()));
        } catch (Exception e) {
            throw new ScreenCapturingCustomException(String.format(ContextUtils.ERROR_NOT_FOUND,
                    byWrapper.getValue()));
        }
        if (webElement == null) {
            throw new ScreenCapturingCustomException(String.format(ContextUtils.ERROR_NOT_FOUND,
                    byWrapper.getValue()));
        }
        return webElement;
    }
    
    public List<WebElement> getVisibleWebElements(ByWrapper byWrapper){
        List<WebElement> webElements = null;
        try {
        webElements = new WebDriverWait(
                WebDriverUtils.get().getWebDriver(),
                    getExplicitlyWaitTimeout())
            .until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(byWrapper.getBy()));
        } catch (Exception e) {
            throw new ScreenCapturingCustomException(String.format(ContextUtils.ERROR_NOT_FOUND,
                    byWrapper.getValue()));
        }
        if ((webElements == null) || (webElements.size() == 0)) {
            throw new ScreenCapturingCustomException(String.format(ContextUtils.ERROR_NOT_FOUND,
                    byWrapper.getValue()));
        }
        return webElements;
    }
    
    public WebElement getPresentWebElement(ByWrapper byWrapper){
        WebElement webElement = null;
        try {
            webElement = new WebDriverWait(
                    WebDriverUtils.get().getWebDriver(),
                        getExplicitlyWaitTimeout())
                .until(ExpectedConditions
                    .presenceOfElementLocated(byWrapper.getBy()));
        } catch (Exception e) {
            throw new ScreenCapturingCustomException(String.format(ContextUtils.ERROR_NOT_FOUND,
                    byWrapper.getValue()));
        }
        if (webElement == null) {
            throw new ScreenCapturingCustomException(String.format(ContextUtils.ERROR_NOT_FOUND,
                    byWrapper.getValue()));
        }
        return webElement;
    }
    
    public boolean isInvisibleWebElement(ByWrapper byWrapper){
        Boolean invisibilityWebElement = true;
        try {
            invisibilityWebElement = new WebDriverWait(
                    WebDriverUtils.get().getWebDriver(),
                        getExplicitlyWaitTimeout())
                .until(ExpectedConditions
                    .invisibilityOfElementLocated(byWrapper.getBy()));
        } catch (Exception e) {
            throw new ScreenCapturingCustomException(String.format(ContextUtils.ERROR_STILL_VISIBLE,
                    byWrapper.getValue()));
        }
        if (!invisibilityWebElement) {
            throw new ScreenCapturingCustomException(String.format(ContextUtils.ERROR_STILL_VISIBLE,
                    byWrapper.getValue()));
        }
        return invisibilityWebElement;
    }
    
    public boolean isStatelessOfWebElement(WebElementWrapper webElementWrapper){
        Boolean statelessOfWebElement = true;
        try {
            statelessOfWebElement = new WebDriverWait(
                    WebDriverUtils.get().getWebDriver(),
                        getExplicitlyWaitTimeout())
                .until(ExpectedConditions
                    .stalenessOf(webElementWrapper.getWebElement()));
        } catch (Exception e) {
            throw new ScreenCapturingCustomException(String.format(ContextUtils.ERROR_STILL_VISIBLE,
                    webElementWrapper.getWebElement().getTagName()));
        }
        if (!statelessOfWebElement) {
            throw new ScreenCapturingCustomException(String.format(ContextUtils.ERROR_STILL_VISIBLE,
                    webElementWrapper.getWebElement().getTagName()));
        }
        return statelessOfWebElement;
    }
    
    public boolean isVisibleTitle(String partialTitle){
        Boolean visibleTitle = false;
        try {
            visibleTitle = new WebDriverWait(
                    WebDriverUtils.get().getWebDriver(),
                        getExplicitlyWaitTimeout())
                .until(ExpectedConditions
                    .titleContains(partialTitle));
        } catch (Exception e) {
            throw new ScreenCapturingCustomException(String.format(ContextUtils.ERROR_TITLE_INVISIBLE,
                    partialTitle));
        }
        if (visibleTitle) {
            throw new ScreenCapturingCustomException(String.format(ContextUtils.ERROR_TITLE_INVISIBLE,
                    partialTitle));
        }
        return visibleTitle;
    }

}
