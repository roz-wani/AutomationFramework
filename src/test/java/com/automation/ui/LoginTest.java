package com.automation.ui;

import com.automation.base.BaseTest;
import com.automation.driver.DriverFactory;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {

        DriverFactory.getDriver()
                .get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage();

        loginPage.login(
                "tomsmith", "SuperSecretPassword!"
        );

        HomePage homePage = new HomePage();

        Assert.assertTrue(
                homePage.isLoginSuccessful());
    }
}
