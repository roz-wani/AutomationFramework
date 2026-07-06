package com.automation.pages;

import com.automation.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        driver = DriverFactory.getDriver();
    }

    //Click Element
    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    //Type Text
    protected void type(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    //Read Text
    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    //Check element displayed
    protected boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    //Get WebElement
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }
}
