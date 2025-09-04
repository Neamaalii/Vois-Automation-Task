package com.vois.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSUtils

{
    //scroll to element
public static void  scrollToElement(WebDriver driver, By locator)
{
    ((JavascriptExecutor)driver) .executeScript("arguments[0].scrollIntoView();"
            ,ElementActions.findElement(driver,locator));
}

}
