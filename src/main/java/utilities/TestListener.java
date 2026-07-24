package utilities;
import base.BaseClass;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtenetManager.getReport();
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Execution Started");
    }

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

        System.out.println("Failure Listener Called");

        test.fail(result.getThrowable());

        try {

            String path = ScreenshotUtil.captureScreenshot(
                    BaseClass.driver,
                    result.getMethod().getMethodName());

            test.addScreenCaptureFromPath(path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("Report Generated Successfully");
    }
   
}

