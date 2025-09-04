package com.vois.Drivers;
import com.vois.Utils.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.fail;
/**
 * DriverManger is responsible for managing WebDriver instances in a thread-safe way.
 * Uses ThreadLocal to allow parallel test execution where each test gets its own WebDriver instance.
 * Provides methods to create, set, and get the WebDriver.
 */

public class DriverManger
{
    private static final ThreadLocal<WebDriver> driverThreadLocal =new ThreadLocal<>();
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
