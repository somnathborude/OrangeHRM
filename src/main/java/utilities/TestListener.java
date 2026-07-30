package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReport();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        WebDriver driver = BaseClass.driver;

        String path = ScreenshotUtility.captureScreenshot(driver,
                result.getMethod().getMethodName());

        test.addScreenCaptureFromPath(path);
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}