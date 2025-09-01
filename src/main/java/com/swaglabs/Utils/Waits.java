package com.swaglabs.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waits
{
    public static WebElement WaitForElementToBePresent(WebDriver driver , By locator)
    {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 -> driver1.findElement(locator));
    }

    //wait for element to be Visible
    public static WebElement WaitForElementToBeVisible(WebDriver driver , By locator)
    {

        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 ->
                        {
                            WebElement element=WaitForElementToBePresent(driver,locator);
                            return element.isDisplayed() ? element : null ;
                        }
                );
    }
    //gdedaaaaaa
    public static List<WebElement> WaitForElementsToBeVisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> {
                    List<WebElement> elements = driver1.findElements(locator);
                    return elements.stream().anyMatch(WebElement::isDisplayed) ? elements : null;
                });
    }

    //wait for element to be Clickable
    public static WebElement WaitForElementToBeClickable(WebDriver driver , By locator)
    {
        return new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(driver1 ->

                        {
                            WebElement element=WaitForElementToBeVisible(driver,locator);
                            return element.isEnabled() ? element : null ;
                        }

                );
    }
}
