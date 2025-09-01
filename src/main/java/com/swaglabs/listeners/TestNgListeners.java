package com.swaglabs.listeners;

import com.swaglabs.Utils.FileUtils;
import com.swaglabs.Utils.LogsUtils;
import com.swaglabs.Utils.ScreenShotUtils;
import com.swaglabs.Utils.allureUtils;
import org.testng.*;

import java.io.File;

import static com.swaglabs.Utils.propertiesUtils.loadProperties;

public class TestNgListeners implements IExecutionListener, ITestListener, IInvokedMethodListener {
    File allure_results=new File("test-outputs/allure-results");
    File logs =new File("test-outputs/Logs");

    @Override
    public void onExecutionStart() {
        LogsUtils.info("Test Exeution started");
        loadProperties();
        FileUtils.deletefiles(allure_results);
        FileUtils.cleanDirectory(logs);
    }

    @Override
    public void onExecutionFinish()
    {

LogsUtils.info("Test Exeution finished");
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("➡️ Before Method: " + method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod())
        {
            switch (testResult.getStatus())
            {
                case ITestResult.SUCCESS ->   ScreenShotUtils.takeScreenShot("Passed-"+testResult.getName());
                case ITestResult.FAILURE ->   ScreenShotUtils.takeScreenShot("failed-"+testResult.getName());
                case ITestResult.SKIP ->   ScreenShotUtils.takeScreenShot("Skipped-"+testResult.getName());

            }
            allureUtils.attachLogsToAllureReport();

        }

    }
    // result.getName() الميثود اللي اسمها كذا كانت باص
    @Override
    public void onTestStart(ITestResult result) {
        LogsUtils.info( result.getName()+ "started");
    }


    public void onTestSuccess(ITestResult result) {

        LogsUtils.info("TestCase" + result.getName()+ "passed");
    }


    public void onTestFailure(ITestResult result) {
        LogsUtils.info("TestCase" + result.getName()+ "failed");
        ScreenShotUtils.takeScreenShot("fail-"+result.getName());

    }

    public void onTestSkipped(ITestResult result)
    {

        LogsUtils.info("TestCase" + result.getName()+ "skipped");
        ScreenShotUtils.takeScreenShot("skipped-"+result.getName());

    }

}
