package com.swaglabs.Utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
public class BrowserActions {

    public BrowserActions() {

    }
@Step("navigate to :{https://www.bing.com}")
    public static void Navigate_To_Browser(WebDriver driver, String url) {
        driver.get(url);
        LogsUtils.info("");
    }

    //get url

    public static String get_current_url (WebDriver driver)
    {
        return driver.getCurrentUrl();
    }
    public static String get_page_title(WebDriver driver)
    {
        return driver.getTitle();
    }

    //refresh
    public static void reload(WebDriver driver)
    {
       driver.navigate().refresh();
    }

}

