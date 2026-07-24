package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtenetManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("Reports/AutomationReport.html");

            spark.config().setReportName("OrangeHRM Automation Report");
            spark.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Somnath");
            extent.setSystemInfo("Project", "OrangeHRM");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}