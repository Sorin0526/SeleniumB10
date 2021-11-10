package utils;

import org.bouncycastle.util.Iterable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Browsers_Utils {

    //we will create our reusable methods related with browser
    // inside the Browser_Utils class

    /*
    Method that accepts three parameters - WebElement, Value, MethodName
    SelectByVisibleText
     */

    public static void selectBy(WebElement element,String value, String methodName){
        Select select= new Select(element);
        //methodName can be text, index, value
        switch (methodName){
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



}





