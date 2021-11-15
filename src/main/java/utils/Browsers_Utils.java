package utils;

import org.bouncycastle.util.Iterable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class Browsers_Utils {

    //we will create our reusable methods related with browser
    // inside the Browser_Utils class


    /*
    Method that accepts three parameters - WebElement, Value, MethodName
    SelectByVisibleText
     */
    public static void selectBy(WebElement element,String value, String methodName) {
        Select select = new Select(element);
        //methodName can be text, index, value
        switch (methodName) {
            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available. Select text, value or index for method name");
        }
    }


    // this method will get the text
    public static String getText(WebElement element){
        return element.getText().trim();
    }


    //it will switch window to given target title
    public static void switchByTitle(WebDriver driver, String title){
        Set<String> ids = driver.getWindowHandles();
        for (String id:ids
             ) {
            driver.switchTo().window(id);
            if(driver.getTitle().contains(title)){
                break;
            }
        }
    }


    // it will close all the windows if it is not equal to given window title
    public static void closeWindowByTitle (WebDriver driver , String title){
        Set<String> ids = driver.getWindowHandles();
        for (String id:ids
        ) {
            driver.switchTo().window(id);
            if(!driver.getTitle().equals(title)) {
                driver.close();
            }
        }
    }


    //this method will scroll window to web element
    public static void scrollToView(WebDriver driver, WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("argument[0].scrollIntoView(true)",element);
    }


    //implement the method that switch the window by its url
    public static void  switchWindowByUrl (WebDriver driver, String url){
        Set<String> ids = driver.getWindowHandles();
        for (String id:ids
        ) {
            driver.switchTo().window(id);
            if(!driver.getCurrentUrl().equals(url)) {
                driver.switchTo().window(url);
            }
        }
    }



    }







