package com.vois.Utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
public class BrowserActions {

    public BrowserActions() {

    }
@Step("navigate to :{https://www.google.com/}")
    public static void Navigate_To_Browser(WebDriver driver, String url) {
        driver.get(url);
    }
}

