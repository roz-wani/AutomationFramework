package com.automation.config;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigTest {

    @Test
    public void verifyConfigProperties() {

        Assert.assertEquals(
                ConfigReader.getProperty("browser"),
                "chrome"
        );

        Assert.assertEquals(
                ConfigReader.getProperty("headless"),
                "false"
        );

        Assert.assertEquals(
                ConfigReader.getProperty("url"),
                "htpps://the-internet.herokuapp.com"
        );

        System.out.println("Config file load successfully");
    }
}
