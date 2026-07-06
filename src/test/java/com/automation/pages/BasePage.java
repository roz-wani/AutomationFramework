package com.automation.pages;

import com.automation.driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        driver = DriverFactory.getDriver();
    }
}
