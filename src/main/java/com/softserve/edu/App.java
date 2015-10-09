package com.softserve.edu;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.softserve.edu.atqc.tools.controls.Component;
import com.softserve.edu.atqc.tools.controls.IComponent;
import com.softserve.edu.atqc.tools.controls.ILabel;
import com.softserve.edu.atqc.tools.controls.Label;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException
    {
        System.out.println( "Hello World!" );
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/OMS/login.htm");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        //driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        //System.out.println("executeScript "+
        //        ((JavascriptExecutor)driver).executeScript("return document.readyState"));
        //System.out.println( driver.findElement(By.name("j_username")).isEnabled() );
        Thread.sleep(3000);
        //System.out.println("executeScript "+
        //        ((JavascriptExecutor)driver).executeScript("return $('#main').is(':hidden')"));
        //System.out.println("executeScript "+
        //        ((JavascriptExecutor)driver).executeScript("return document.getElementById('main').style.opacity"));
        //System.out.println("executeScript "+
        //        ((JavascriptExecutor)driver).executeScript("return  $('#main').opacity"));
        System.out.println("executeScript "+
                ((JavascriptExecutor)driver).executeScript("return $('.all')[0].style.opacity == ''"));

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("Proba.png"));
        System.out.println("DONE");
        //IComponent component = Component.getByCssSelector("");
        //component.getContent();
        IComponent component = Component.get().getByXpath("");
        component.getTagName();
        ILabel label =Label.get().getByXpath("");
        //ILabel label =Label.get().getByCssSelector("");
        label.getText();
        }
}
