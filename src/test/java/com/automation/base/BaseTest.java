package com.automation.base;

import com.automation.config.ConfigReader;
import com.automation.driver.DriverFactory;
import com.automation.listeners.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseTest {

    @BeforeMethod
    public void setup() {

        DriverFactory.initDriver();

        DriverFactory.getDriver().manage().window().maximize();

        DriverFactory.getDriver().get(
                ConfigReader.getProperty("base.url"));
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}
