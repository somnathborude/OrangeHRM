package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	WebDriver driver;
	
	@FindBy(xpath="//h6[text()='Dashboard']")
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
		return dashboardText.isDisplayed();
		
		
	}
	
	public void logout() {
		profileDropdown.click();
		logoutLink.click();
	}
	
	

}
