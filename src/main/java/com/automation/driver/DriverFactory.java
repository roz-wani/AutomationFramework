package com.automation.driver;

import com.automation.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        String browser = ConfigReader.getProperty("browser");

        switch (browser.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;

            default:
                throw new RuntimeException("Browser not supported : " + browser);
        }

        getDriver().manage().window().maximize();

        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(
                        Long.parseLong(ConfigReader.getProperty("implicitWait"))
                ));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
