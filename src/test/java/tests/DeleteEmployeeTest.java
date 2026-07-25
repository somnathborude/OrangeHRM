package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;

public class DeleteEmployeeTest extends BaseClass {

    @Test
    public void verifyDeleteEmployee() {

        LoginPage lp = new LoginPage(driver);
        lp.login("Admin", "admin123");

        DashboardPage dp = new DashboardPage(driver);
        Assert.assertTrue(dp.isDashboardDisplayed());

        PIMPage pim = new PIMPage(driver);

        pim.clickPIM();

        pim.clickAddEmployee();

        String empName = pim.addEmployeeAndReturnName();

        Assert.assertTrue(pim.isPersonalDetailsDisplayed());

        pim.clickPIM();

        pim.clickEmployeeList();

        pim.searchEmployee(empName);

        pim.clickSearch();

        pim.clickDelete();

        pim.confirmDelete();

        Assert.assertTrue(pim.isDeleteSuccessMessageDisplayed());

        System.out.println("Employee Deleted Successfully");
    }
}