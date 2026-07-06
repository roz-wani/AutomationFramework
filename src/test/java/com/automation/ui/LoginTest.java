package com.automation.ui;

import com.automation.base.BaseTest;
import com.automation.driver.DriverFactory;
import com.automation.pages.LoginPage;
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

        Assert.assertTrue(
                loginPage.getFlashMessage()
                        .contains("You logged into a secure area!")
        );
    }
}
