package com.swaglabs.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtils

{
public static void  scrollToElement(WebDriver driver, By locator)
{
    ((JavascriptExecutor)driver) .executeScript("arguments[0].scrollIntoView();"
            ,ElementActions.findelement(driver,locator));
}

    // make visible method
    public static void makeAllVisible(WebDriver driver, WebElement container)
    {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].querySelectorAll('.richrsrailsuggestion').forEach(function(el) {" +
                        "   el.style.display='block';" +
                        "   el.style.height='auto';" +
                        "   el.style.overflow='visible';" +
                        "   el.style.pointerEvents='auto';" +
                        "});",
                container
        );
    }
}
