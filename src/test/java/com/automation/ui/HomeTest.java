package com.automation.ui;

import com.automation.base.BaseTest;
import com.automation.driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test
    public void verifyHomePage() {

        DriverFactory.getDriver().get("https://the-internet.herokuapp.com");

        Assert.assertTrue(
                DriverFactory.getDriver().getTitle().contains("The Internet")
        );
    }
}
