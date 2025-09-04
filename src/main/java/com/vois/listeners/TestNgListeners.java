package com.vois.listeners;

import com.vois.Utils.FileUtils;
import com.vois.Utils.LogsUtils;
import com.vois.Utils.ScreenShotUtils;
import com.vois.Utils.allureUtils;
import org.testng.*;

import java.io.File;

import static com.vois.Utils.propertiesUtils.loadProperties;

public class TestNgListeners implements IExecutionListener, ITestListener, IInvokedMethodListener {
    File allure_results = new File("test-outputs/allure-results");
    File logs = new File("test-outputs/Logs");
    File screenshots = new File("test-outputs/Screenshots");

    @Override
    public void onExecutionStart() {
        LogsUtils.info("Test Exeution started");
        loadProperties();
        FileUtils.cleanDirectory(screenshots);
        FileUtils.deletefiles(allure_results);
        FileUtils.createDirectory(screenshots);
    }

    @Override
    public void onExecutionFinish() {

        LogsUtils.info("Test Exeution finished");
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("➡️ Before Method: " + method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            switch (testResult.getStatus()) {
                case ITestResult.SUCCESS -> ScreenShotUtils.takeScreenShot("Passed-" + testResult.getName());
                case ITestResult.FAILURE -> ScreenShotUtils.takeScreenShot("failed-" + testResult.getName());
                case ITestResult.SKIP -> ScreenShotUtils.takeScreenShot("Skipped-" + testResult.getName());

            }
            allureUtils.attachLogsToAllureReport();

        }

    }
    @Override
    public void onTestStart(ITestResult result) {
        LogsUtils.info(result.getName() + "started");
    }


    public void onTestSuccess(ITestResult result) {

        LogsUtils.info("TestCase" + result.getName() + "passed");
    }


    public void onTestFailure(ITestResult result) {
        LogsUtils.info("TestCase" + result.getName() + "failed");
        ScreenShotUtils.takeScreenShot("fail-" + result.getName());

    }

    public void onTestSkipped(ITestResult result) {

        LogsUtils.info("TestCase" + result.getName() + "skipped");
        ScreenShotUtils.takeScreenShot("skipped-" + result.getName());

    }

}
