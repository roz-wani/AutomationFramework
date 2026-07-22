package com.automation.listeners;

import com.automation.reports.ExtentManager;
import com.automation.utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{

    private static final ExtentReports extent = ExtentManager.getInstance();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        System.out.println("=========== TEST SUITE STARTED ===========");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Flushing Extent Report ...");
        extent.flush();
        System.out.println("=========== TEST SUITE FINISHED ===========");
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = extent.createTest(result.getName());

        test.set(extentTest);

        System.out.println("STARTED :" + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed");

        System.out.println("PASSED : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String screenshotPath = ScreenshotUtil.capture(result.getName());

        test.get().fail(result.getThrowable());

        try {

            test.get().addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {

            e.printStackTrace();
        }

        System.out.println("FAILED :" + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test Skipped");

        System.out.println("SKIPPED :" + result.getName());
    }
}
