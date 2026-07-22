package com.automation.ui;

import com.automation.base.BaseTest;
import com.automation.dataprovider.LoginDataProvider;
import com.automation.driver.DriverFactory;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData",
    dataProviderClass = LoginDataProvider.class)

    public void loginTest(String username,
                          String password,
                          String expected) {

        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);

        if (expected.equalsIgnoreCase("PASS")) {

            HomePage homePage = new HomePage();

            Assert.assertTrue(homePage.isLoginSuccessful(),
                    "Expected login is succeed.");

            homePage.logout();

        } else {

            Assert.assertTrue(
                    loginPage.isErrorMessageDisplayed(),
                    "Expected error message to be displayed.");
        }
    }
}