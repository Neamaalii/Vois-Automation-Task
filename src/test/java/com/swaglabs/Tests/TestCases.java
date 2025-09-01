package com.swaglabs.Tests;

import com.swaglabs.Drivers.DriverManger;
import com.swaglabs.Pages.GooglePage;
import com.swaglabs.Pages.SearchPage;
import com.swaglabs.Pages.SearchPageTwo;
import com.swaglabs.Utils.*;
import com.swaglabs.listeners.TestNgListeners;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestNgListeners.class)
public class TestCases {

    WebDriver driver;
    JsonUtils testData;

    @BeforeClass
    @Parameters("browserType")
    public void beforeClass(@Optional("") String browserNameFromXML) {
        testData = new JsonUtils("test_data");

        // Browser selection
        String browser_name;
        if (browserNameFromXML == null || browserNameFromXML.isEmpty()) {
            browser_name = propertiesUtils.getPropertyValue("browserType");
        } else {
            browser_name = browserNameFromXML;
        }

        // إنشاء driver مرة واحدة لكل الـ tests
        DriverManger.create_instance(browser_name);
        driver = DriverManger.get_driver();

        // فتح الصفحة مرة واحدة
        new GooglePage(driver).gotourl();
    }




    @Test
    public void success_Search() {
        new GooglePage(driver)
                .enterSearchText(testData.getJsonData("bing-data.searchText"));
    }

    @Test(dependsOnMethods = {"success_Search"})
    public void verifyFirstSectionItemsContainVodafone()
    {
        new SearchPage(driver)
                .verifyThatSectionContainsVodafone(testData.getJsonData("bing-data.expectedKeyword"));
    }


    @Test(dependsOnMethods ={"success_Search"} )
    public void comparebetween2results()
    {
        new SearchPageTwo(driver)
                .verifyResultsCountIsEqualBetweenPage2AndPage3();
    }



@AfterClass
    public void close()
{
    driver.close();
}

}
