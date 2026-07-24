package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;

public class PIMTest extends BaseClass {

    @Test
    public void verifyAddEmployee() throws InterruptedException {

        LoginPage lp = new LoginPage(driver);
        lp.login("Admin", "admin123");

        DashboardPage dp = new DashboardPage(driver);
        Assert.assertTrue(dp.isDashboardDisplayed());

        PIMPage pim = new PIMPage(driver);

        // Open PIM
        pim.clickPIM();

        // Add Employee
        pim.clickAddEmployee();
        pim.addEmployee("Soma", "Borude");
        pim.clickSave();

        // Verify Personal Details Page
        Assert.assertTrue(pim.isPersonalDetailsDisplayed());

        // Go to Employee List
        pim.clickPIM();
        pim.clickEmployeeList();

        // Search Employee
        pim.searchEmployee("Soma");
        pim.clickSearch();

        Thread.sleep(3000);

        System.out.println("Current URL : " + driver.getCurrentUrl());
        System.out.println("Employee Added and Searched Successfully");
    }
}