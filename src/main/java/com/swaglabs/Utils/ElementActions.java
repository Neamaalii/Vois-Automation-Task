package com.swaglabs.Utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions
{

    @Step("sending data : {data} to the element {locator}")

    public static void SendData(WebDriver driver , By locator , String data)
    {
        //wait  - Scroll - sendkey
        Waits.WaitForElementToBeVisible(driver,locator);
        JSUtils.scrollToElement(driver,locator);
        findelement(driver,locator).sendKeys(data);
        LogsUtils.info("Data is :" , data , "in the field : " ,locator.toString());
    }

    public static void ClickElement(WebDriver driver , By locator )
    {
        Waits.WaitForElementToBeVisible(driver,locator);
        JSUtils.scrollToElement(driver, locator);
        findelement(driver,locator).click();
    }

    public static String get_text(WebDriver driver , By locator)
    {
        Waits.WaitForElementToBeVisible(driver, locator);
        JSUtils.scrollToElement(driver, locator);
        return findelement(driver,locator).getText();
    }
//find-element
    public static WebElement findelement(WebDriver driver , By locators)
    {
        return driver.findElement(locators);
    }


}
