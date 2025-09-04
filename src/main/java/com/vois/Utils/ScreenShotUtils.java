package com.vois.Utils;

import com.vois.Drivers.DriverManger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ScreenShotUtils
{
    private ScreenShotUtils()
    {
        super();
    }
    public static String SCREENSHOTS_PATH = "test-outputs/Screenshots/";

    public static void takeScreenShot(String screenshotName)
    {
        try
        {
          File screenshot =((TakesScreenshot) DriverManger.get_driver()).getScreenshotAs(OutputType.FILE);
          File screenshotfile=new File(SCREENSHOTS_PATH + screenshotName + ".png");
            FileUtils.copyFile(screenshot,screenshotfile);
            allureUtils.attachScreenshotToAllure(screenshotName, screenshotfile.getPath());

        }
        catch (Exception e)
        {
            LogsUtils.error("Failed to take screenshot: " + e.getMessage());
        }
    }
}
