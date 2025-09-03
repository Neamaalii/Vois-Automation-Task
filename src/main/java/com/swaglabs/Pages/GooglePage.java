package com.swaglabs.Pages;

import com.swaglabs.Utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import static com.swaglabs.Utils.propertiesUtils.getPropertyValue;


public class GooglePage {
 private final WebDriver driver;

 // ================= Locators =================

 private final By search_for_vodafone =
         By.cssSelector("[name='q']");


 // ================= constructor =================
 public GooglePage(WebDriver driver) {
  this.driver = driver;
 }


 // ================= ACTIONS =================

 //Navigate to Google home page using the URL from properties file.
 @Step("navigate to google page")
 //Navigation
 public void gotourl() {
  String url = getPropertyValue("baseURL");

  LogsUtils.info("Navigating to URL: ", url);

  BrowserActions.Navigate_To_Browser(driver, url);
 }

 //=================Actions=================

 //Enter a search query in Google search box and submit.
 @Step("Search for Vodafone")
 public SearchPage enterSearchText(String searchText) {
  LogsUtils.info("Entering search text: ", searchText);
  ElementActions.SendData(driver, this.search_for_vodafone, searchText);
  driver.findElement(this.search_for_vodafone).sendKeys(Keys.ENTER);
  return new  SearchPage(driver);
 }
}



