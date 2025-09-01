package com.swaglabs.Pages;

import com.swaglabs.Utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.swaglabs.Utils.propertiesUtils.getPropertyValue;


public class SearchPage
{
 //Locators
 private final WebDriver driver;

 private final By firstRelatedSection =
         By.xpath("//span[@aria-level=\"2\"] //following::div/a[@class='ngTNl ggLgoc']");


 //constructor
 public SearchPage(WebDriver driver) {
  this.driver = driver;
 }

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
