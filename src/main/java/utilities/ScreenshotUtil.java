package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static String captureScreenshot(WebDriver driver, String testName) throws IOException {

	    System.out.println("Screenshot Method Called");

	    TakesScreenshot ts = (TakesScreenshot) driver;

	    File source = ts.getScreenshotAs(OutputType.FILE);

	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	    String path = System.getProperty("user.dir")
	            + "\\Screenshots\\"
	            + testName + "_" + timeStamp + ".png";

	    File destination = new File(path);

	    FileUtils.copyFile(source, destination);

	    System.out.println("Screenshot Saved : " + path);

	    return path;
	}
}