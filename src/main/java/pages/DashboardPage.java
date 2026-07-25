package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	WebDriver driver;
	@FindBy(xpath = "//h6[text()='Dashboard']")
	WebElement dashboardText;


	
	
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
	WebElement profileDropdown;
	@FindBy(linkText= "Logout")
	WebElement logoutLink;
	public DashboardPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	public boolean isDashboardDisplayed() {

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(30));

	    return wait.until(
	            ExpectedConditions.visibilityOf(dashboardText))
	            .isDisplayed();
	}
	public void logout() {
		profileDropdown.click();
		logoutLink.click();
	}
	
	

}
