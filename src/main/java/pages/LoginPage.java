package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;

    @FindBy(name = "username")
    WebElement txtUsername;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;
    
    @FindBy(xpath="//p[text()='Invalid credentials']")
    WebElement invalidMessage;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
       
    }

    public void login(String username, String password) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
        
    }

    public boolean isLoginPageDisplayed() {
        return txtUsername.isDisplayed();
    }
    
    public boolean isInvalidCredentialDisplayed() {
        return invalidMessage.isDisplayed();
    }
    
}