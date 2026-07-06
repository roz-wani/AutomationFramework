package com.automation.base;

import com.automation.driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        DriverFactory.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
