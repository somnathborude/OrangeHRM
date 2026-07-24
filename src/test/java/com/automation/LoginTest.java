package com.automation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginTest {
   
	   @Test
	 public void launchBrowser() throws InterruptedException {
    WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
    driver.get("https://opensource-demo.orangehrmlive.com/");
     Thread.sleep(5000);
    driver.findElement(By.name("username")).sendKeys("Admin");
    driver.findElement(By.name("password")).sendKeys("admin123");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
	System.out.println("title :"+ driver.getTitle());
	Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    driver.quit();
   }
}
