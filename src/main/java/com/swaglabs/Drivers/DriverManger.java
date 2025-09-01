package com.swaglabs.Drivers;

import com.swaglabs.Utils.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class DriverManger
{
    private static final ThreadLocal<WebDriver> driverThreadLocal =new ThreadLocal<>();

    // تشغل تيستات بالتوازى بدون مشاكل وكل تيست عنده درايفر خاص بيه

@Step("create driver instant on : {browsername}")

    public static WebDriver create_instance(String browsername)
    {
  WebDriver driver=BrowserFactory.getBrowser(browsername);
  LogsUtils.info("driver created on : " , browsername);
  set_driver(driver);
  return get_driver();

    }


    public static void set_driver(WebDriver driver)
    {
        driverThreadLocal.set(driver);

    }
    public static WebDriver get_driver()
    {
if (driverThreadLocal.get()==null)
{
    LogsUtils.info("Driver is null");
     fail("driver is null");
}
return driverThreadLocal.get();

    }





}
