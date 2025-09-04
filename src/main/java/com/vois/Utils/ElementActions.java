package com.vois.Utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions
{


    //find-element
    public static WebElement findElement(WebDriver driver , By locators)
    {
        return driver.findElement(locators);
    }
    @Step("sending data : {data} to the element {locator}")

    public static void SendData(WebDriver driver , By locator , String data)
    {
        //wait  - Scroll - sendKey
        Waits.WaitForElementToBeVisible(driver,locator);
        JSUtils.scrollToElement(driver,locator);
        findElement(driver,locator).sendKeys(data);
        LogsUtils.info("Data is :" , data , "in the field : " ,locator.toString());
    }

    public static void ClickElement(WebDriver driver , By locator )
    {
        Waits.WaitForElementToBeClickable(driver,locator);
        JSUtils.scrollToElement(driver, locator);
        findElement(driver,locator).click();
    }

}
