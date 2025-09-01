package com.swaglabs.Utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validation {
    private Validation() {

    }

    public static void ValidateTrue(boolean condition , String message)
    {
        Assert.assertTrue(condition,message);
    }
    public static void Validate_false(boolean condition , String message)
    {
        Assert.assertTrue(condition,message);
    }

    public static void validateEqual(String actual , String expected , String txt)
    {
      Assert.assertEquals( actual,expected,txt);
    }
    public static void validate_not_equal(String actual , String expected , String txt)
    {
        Assert.assertNotEquals(actual,expected,txt);
    }
    public static void validate_page_url(WebDriver driver,String expected)
    {
        Assert.assertEquals(BrowserActions.get_current_url(driver),expected);
    }
    public static void validate_Page_titile(WebDriver driver,String title)
    {
     Assert.assertEquals(BrowserActions.get_page_title(driver),title);
    }

}
