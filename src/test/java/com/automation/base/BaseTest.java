package com.automation.base;

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
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}
