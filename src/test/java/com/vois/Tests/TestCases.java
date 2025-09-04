package com.vois.Tests;

import com.vois.Drivers.DriverManger;
import com.vois.Pages.GooglePage;
import com.vois.Pages.SearchPage;
import com.vois.Pages.SearchPageTwo;
import com.vois.Utils.*;
import com.vois.listeners.TestNgListeners;
import org.openqa.selenium.WebDriver;
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

        DriverManger.create_instance(browser_name);
        driver = DriverManger.get_driver();
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
