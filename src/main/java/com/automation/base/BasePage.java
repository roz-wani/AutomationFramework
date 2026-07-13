package com.automation.base;

import com.automation.driver.DriverFactory;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;

public class BasePage {

    protected WebDriver driver;
    private final WaitUtils waitUtils = new WaitUtils();

    public BasePage() {
        driver = DriverFactory.getDriver();
    }

    //Click Element
    protected void click(By locator) {
        waitUtils.waitForClickable(locator).click();
    }

    //Type Text
    protected void type(By locator, String text) {
        WebElement element = waitUtils.waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    //Read Text
    protected String getText(By locator) {
        return waitUtils.waitForVisibility(locator).getText();
    }

    //Check element displayed
    protected boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    protected String getTitle() {
        return  driver.getTitle();
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}