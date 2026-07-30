package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class BaseClass {

	public static WebDriver driver;
	public static Logger logger =
	        LogManager.getLogger(BaseClass.class);
   
    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        logger.info("Launching Browser");

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        logger.info("Opening OrangeHRM");
    }

    @AfterMethod
    public void closeall() {

        if (driver != null) {
            driver.quit();
            logger.info("Closing Browser");
        }

    }

}