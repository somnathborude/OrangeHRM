package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;

public class EditEmployeeTest extends BaseClass {

    @Test

    public void verifyEditEmployee() throws InterruptedException {

        LoginPage lp = new LoginPage(driver);
        lp.login("Admin", "admin123");

        DashboardPage dp = new DashboardPage(driver);
        Assert.assertTrue(dp.isDashboardDisplayed());

        PIMPage pim = new PIMPage(driver);

        pim.clickPIM();

        pim.clickEmployeeList();

        pim.searchEmployee("Soma");

        pim.clickSearch();

        pim.openEmployee();

        pim.editLastName("Patil");
        
        Thread.sleep(1000);

        pim.clickSaveDetails();

        Assert.assertTrue(pim.isUpdateSuccessful());

        System.out.println("Employee Updated Successfully");
    }
}