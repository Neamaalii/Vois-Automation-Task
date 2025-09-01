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


public class GooglePage {
 //Locators
 private final WebDriver driver;
 private final By search_for_vodafone =
         By.cssSelector("[name='q']");
 private final By firstRelatedSection =
         By.xpath("//span[@aria-level=\"2\"] //following::div/a[@class='ngTNl ggLgoc']");
 private final By secondRelatedSection =
         By.xpath("//div[@class='b_rs' and .//h2[contains(., 'Related searches for') and strong[text()='Vodafone']]]");

 private final By firstRelatedSectionContainer = By.xpath("//div[@data-priority='2'][1]/div[@class='richrsrailsugwrapper']");
 private List<WebElement> firstSectionItems;


 //constructor
 public GooglePage(WebDriver driver) {
  this.driver = driver;
 }


 // ================= ACTIONS =================

 @Step("navigate to google page")
 //Navigation
 public void gotourl() {
  String url = getPropertyValue("baseURL");

  LogsUtils.info("Navigating to URL: ", url);

  BrowserActions.Navigate_To_Browser(driver, url);
 }

 //Actions
 @Step("Search for Vodafone")
 public SearchPage enterSearchText(String searchText) {
  //driver.findElement(By.cssSelector("div#SIvCob a[dir=\"ltr\"]")).click();
  // wait for search box to be visible
  WebElement searchBox = Waits.WaitForElementToBeVisible(driver, this.search_for_vodafone);

  LogsUtils.info("Entering search text: ", searchText);

  ElementActions.SendData(driver, this.search_for_vodafone, searchText);
  driver.findElement(this.search_for_vodafone).sendKeys(Keys.ENTER);
  return new  SearchPage(driver);
 }
}



