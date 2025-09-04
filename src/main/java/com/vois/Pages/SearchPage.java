package com.vois.Pages;

import com.vois.Utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class SearchPage
{
 private final WebDriver driver;

 //=================Locators=================

 private final By firstRelatedSection =
         By.xpath("//span[@aria-level=\"2\"] //following::div/a[@class='ngTNl ggLgoc']");


 //=================constructor =================
 public SearchPage(WebDriver driver) {
  this.driver = driver;
 }



 //=================Actions=================

 // * Verify that all elements in the first related section contain the expected text.

 @Step("verify That Section Contains Vodafone")
 public SearchPage verifyThatSectionContainsVodafone(String expectedText)
 {
  for (WebElement element: driver.findElements(firstRelatedSection))
  {
    String flag = element.getText();
   LogsUtils.info("text: " + flag );
   Assert.assertTrue(flag.toLowerCase().contains(expectedText));
  }
  return this;
 }


}
