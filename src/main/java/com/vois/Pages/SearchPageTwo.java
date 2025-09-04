package com.vois.Pages;

import com.vois.Utils.ElementActions;
import com.vois.Utils.LogsUtils;
import com.vois.Utils.Validation;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class SearchPageTwo
{
 private final WebDriver driver;

 //=================Locators=================


 private By clickonsecondpage=By.xpath("//a[@aria-label='Page 2']");
 private By searchResultsSecondPage= By.xpath("//a /h3");

 private By clickonthirdpage=By.xpath("//a[@aria-label='Page 3']");
 private By searchResultsThirdPage= By.xpath("//a /h3");




 //=================constructor =================
 public SearchPageTwo(WebDriver driver)
 {
  this.driver = driver;
 }


 // ================= ACTIONS =================

 //click on page number 2

 public void goToSecondPage()
 {
  LogsUtils.info("click on the 2 page ");

  // Scroll to the page 2 link
  ElementActions.ClickElement(driver,clickonsecondpage);
 }

 //click on page number 3

 public void goToThirdPage()
 {
  LogsUtils.info("click on the 3 page ");

  // Scroll to the page 3 link
  ElementActions.ClickElement(driver,clickonthirdpage);

 }


 @Step("Count the number of results displayed on the second page")
 public int Page2count ()
 {
  int counter1 = 0;
 for ( WebElement element : driver.findElements(searchResultsSecondPage))
 {
  LogsUtils.info("Element on second page " + element.getText());
   counter1++;
 }

  return counter1;
 }



 @Step("Count the number of results displayed on the third page")
 public int Page3count ()
 {
  int counter2 = 0;
  for ( WebElement element : driver.findElements(searchResultsThirdPage))
  {
   LogsUtils.info("Element on third page " + element.getText());
   counter2++;
  }

  return counter2;
 }


 //Verify that the number of search results on Page 2 equals the number on Page 3.

@Step("verifyResultsCountIsEqualBetweenPage2AndPage3 ")
 public void verifyResultsCountIsEqualBetweenPage2AndPage3()
{
 goToSecondPage();
 int page2counter=Page2count();
 goToThirdPage();
int page3counter=Page3count();

//=================Assertion between counter of the 2 pages =================

 Validation.validateEqual(page2counter,page3counter,"❌ Number of results on Page 2 ( " + page2counter + " ) " +
         "is not equal to Page 3 ( "  + page3counter +")");
}

}
