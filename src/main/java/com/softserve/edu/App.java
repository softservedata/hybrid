package com.softserve.edu;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.softserve.edu.atqc.tools.controls.ITextField;
import com.softserve.edu.atqc.tools.controls.TextField;
import com.softserve.edu.atqc.tools.search.KeysWrapper;


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
        driver.get("www.google.com.ua");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        //driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        //System.out.println("executeScript "+
        //        ((JavascriptExecutor)driver).executeScript("return document.readyState"));
        //System.out.println( driver.findElement(By.name("j_username")).isEnabled() );
        
        //System.out.println("executeScript "+
        //        ((JavascriptExecutor)driver).executeScript("return $('#main').is(':hidden')"));
        //System.out.println("executeScript "+
        //        ((JavascriptExecutor)driver).executeScript("return document.getElementById('main').style.opacity"));
        //System.out.println("executeScript "+
        //        ((JavascriptExecutor)driver).executeScript("return  $('#main').opacity"));
//        System.out.println("executeScript "+
//                ((JavascriptExecutor)driver).executeScript("return $('.all')[0].style.opacity == ''"));
//
//        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(srcFile, new File("Proba.png"));
//        System.out.println("DONE");
//        //IComponent component = Component.getByCssSelector("");
//        //component.getContent();
//        IComponent component = Component.get().getByXpath("");
//        component.getTagName();
//        ILabel label =Label.get().getByXpath("");
        //ILabel label =Label.get().getByCssSelector("");
       // label.getText();
        ITextField foo = TextField.get().getByName("q"); //= driver.findElement(By.name("q"));
        WebElement foo1 = driver.findElement(By.className(""));
        foo1.sendKeys("");
        foo.sendKeys("");
        foo.sendKeysEnter();
        }
}
