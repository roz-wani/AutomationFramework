package com.automation.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // Locators

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By flashMessage = By.id("flash");

    //Constructor
    public LoginPage() {
        super();
    }

    //Action
    public void enterUsername(String user) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword (String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    public String getFlashMessage() {
        return driver.findElement(flashMessage).getText();
    }
}
