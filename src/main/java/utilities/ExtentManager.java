package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	public static ExtentReports extent;
	public static ExtentReports getReport() {
		if(extent == null) {
			ExtentSparkReporter  spark =
					new ExtentSparkReporter("reports/OrangeHRMReport.html");
			
			spark.config().setReportName("OrangeHRM Automation Report");
			spark.config().setDocumentTitle("Automation Test Report");
			
			extent = new ExtentReports();
			extent.attachReporter(spark);
			
			extent.setSystemInfo("Tester","Somnath Borude");
			 extent.setSystemInfo("Project", "OrangeHRM");
	            extent.setSystemInfo("Framework", "Selenium + TestNG");
	            extent.setSystemInfo("OS", System.getProperty("os.name"));
				
			}
		  return extent;
		}
		
	}


