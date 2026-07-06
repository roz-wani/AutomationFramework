package com.automation.ui;

import com.automation.config.ConfigReader;

public class ConfigTest {

    public static void main(String[] args) {

        System.out.println(ConfigReader.getProperty("browser"));

        System.out.println(ConfigReader.getProperty("url"));
    }
}
