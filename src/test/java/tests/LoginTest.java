package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.LoginDataProvider;

public class LoginTest extends BaseClass {

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void verifyLogin(String username, String password) {

        LoginPage lp = new LoginPage(driver);
        lp.login(username, password);

        if (username.equals("Admin") && password.equals("admin123")) {

            DashboardPage dp = new DashboardPage(driver);

            Assert.assertTrue(dp.isDashboardDisplayed());

            System.out.println("Login Successful : " + username);

            dp.logout();

            Assert.assertTrue(lp.isLoginPageDisplayed());

            System.out.println("Logout Successful");

        } else {

            Assert.assertTrue(lp.isInvalidCredentialDisplayed());

            System.out.println("Invalid Login Verified : " + username);
        }
    }
}