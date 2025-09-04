package com.vois.Utils;

import io.qameta.allure.Allure;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class allureUtils
{
    private allureUtils()
    {super();}

    public static void attachLogsToAllureReport()
    {
        try {
            File logfile = FileUtils.get_latest_file(LogsUtils.Logs_Path);
            if (!logfile.exists()) {
                LogsUtils.warn("Log file does not exist: " + LogsUtils.Logs_Path);
                return;
            }
            Allure.addAttachment("logs.logs", Files.readString(Path.of(logfile.getPath())));
        }
        catch (Exception e)
        {
            LogsUtils.error("Failed to attach logs to Allure report: " + e.getMessage());

        }
    }
    public static void attachScreenshotToAllure(String screenshotname, String screenshotpath)
    {
try
{
    Allure.addAttachment(screenshotname,Files.newInputStream(Path.of(screenshotpath)));

}
catch (Exception e)
{
    LogsUtils.error("Failed to attach screenshot to Allure report: " + e.getMessage());
}
    }


}
