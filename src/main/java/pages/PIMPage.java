package pages;
import java.util.Random;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage {
	WebDriver driver;
	
	public PIMPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	


	@FindBy(xpath="//span[text()='PIM']")
	WebElement pimMenu;

	@FindBy(linkText="Employee List")
	WebElement employeeList;

	@FindBy(linkText="Add Employee")
	WebElement addEmp;
	
	@FindBy(xpath="//label[text()='Employee Id']/../following-sibling::div/input")
	WebElement employeeId;

	@FindBy(name="firstName")
	WebElement firstname;

	@FindBy(name="lastName")
	WebElement lastname;

	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement saveButton;

	@FindBy(xpath="//h6[normalize-space()='Personal Details']")
	WebElement personalDetailHeader;

	@FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]")
	WebElement employeeName;

	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement searchButton;
	
	@FindBy(xpath="(//div[@role='row'])[2]")
	WebElement employeeRow;

	@FindBy(name="lastName")
	WebElement lastName;

	@FindBy(xpath="//button[@type='submit']")
	WebElement saveButtonn;

	@FindBy(xpath="//p[contains(@class,'oxd-text--toast-message')]")
	WebElement successMessagee;

	@FindBy(xpath="//button[.//i[contains(@class,'bi-trash')]]")
	WebElement deleteButton;
	
	@FindBy(xpath="//button[normalize-space()='Yes, Delete']")
	WebElement yesDeleteButton;

	@FindBy(xpath="//div[contains(@class,'oxd-toast-content')]")
	WebElement successMessage;
	public void clickPIM() {
	    pimMenu.click();
	}

	public void clickEmployeeList() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.elementToBeClickable(employeeList)).click();
	}

	public void clickAddEmployee() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.elementToBeClickable(addEmp)).click();
	}
	public void addEmployee(String fname, String lname) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    wait.until(ExpectedConditions.visibilityOf(firstname));

	    firstname.clear();
	    firstname.sendKeys(fname);

	    lastname.clear();
	    lastname.sendKeys(lname);

	    wait.until(ExpectedConditions.visibilityOf(employeeId));

	    employeeId.click();
	    employeeId.sendKeys(org.openqa.selenium.Keys.CONTROL + "a");
	    employeeId.sendKeys(org.openqa.selenium.Keys.DELETE);

	    Random random = new Random();
	    int id = 100000000 + random.nextInt(900000000);

	    System.out.println("Generated Employee ID : " + id);

	    employeeId.sendKeys(String.valueOf(id));
	}
	

	public void clickSave() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	            By.className("oxd-form-loader")));

	    WebElement save = wait.until(
	            ExpectedConditions.elementToBeClickable(saveButton));

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].scrollIntoView(true);", save);

	    save.click();

	    System.out.println("URL After Save : " + driver.getCurrentUrl());
	}
	public boolean isPersonalDetailsDisplayed() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    WebElement header = wait.until(
	            ExpectedConditions.visibilityOf(personalDetailHeader));

	    return header.isDisplayed();
	}
	public void searchEmployee(String name) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOf(employeeName)).sendKeys(name);
	}

	public void clickSearch() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
	}
	
	public void openEmployee() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    WebElement row = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("(//div[@role='row'])[2]")
	        )
	    );

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].click();", row);
	}
	public void editLastName(String lname) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    wait.until(ExpectedConditions.visibilityOf(lastName));

	    lastName.clear();

	    lastName.sendKeys(lname);
	}	
	public void clickSaveDetails() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	            By.className("oxd-form-loader")));

	    
	    WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("(//button[@type='submit'])[2]")));

	    // Scroll
	    ((JavascriptExecutor)driver).executeScript(
	            "arguments[0].scrollIntoView(true);", saveBtn);

	    // JS Click
	    ((JavascriptExecutor)driver).executeScript(
	            "arguments[0].click();", saveBtn);
	}
	public boolean isUpdateSuccessful() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    return wait.until(ExpectedConditions.visibilityOf(successMessage))
	               .isDisplayed();
	}
	public void clickDelete() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // Search result आल्यानंतर Delete icon click
	    WebElement deleteBtn = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    By.xpath("(//button[i[contains(@class,'bi-trash')]])[1]")));

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].click();", deleteBtn);
	}

	public void confirmDelete() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    WebElement yesBtn = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    By.xpath("//button[normalize-space()='Yes, Delete']")));

	    yesBtn.click();
	}

	public boolean isDeleteSuccessMessageDisplayed() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    WebElement toast = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//div[contains(@class,'oxd-toast')]")));

	    return toast.isDisplayed();
	}
	}
	
	
	


