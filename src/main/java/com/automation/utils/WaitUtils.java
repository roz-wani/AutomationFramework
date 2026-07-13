package com.automation.utils;

import com.automation.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.time.Duration;

public class WaitUtils {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public WaitUtils() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Wait until element is visible
    public WebElement waitForVisibility(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Wait until element is clickable
    public WebElement waitForClickable(By locator) {
        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));
    }

    //Wait until text is present
    public boolean waitForText(By locator, String text) {
        return wait.until(
                ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    //Wait until title contain text
    public boolean waitForTitle(String title) {
        return wait.until(
                ExpectedConditions.titleContains(title));
    }

    //Wait until URL contains text
    public boolean waitForUrl(String url) {
        return wait.until(
                ExpectedConditions.urlContains(url));
    }
}
