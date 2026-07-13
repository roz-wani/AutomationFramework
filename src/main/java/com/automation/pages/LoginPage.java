package com.automation.pages;

import com.automation.base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // Locators

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By flashMessage = By.id("flash");

    //Login Method
    public void login(String user, String pass) {
        type(username, user);
        type(password, pass);
        click(loginButton);
    }

    //Get success / error message
    public String getFlashMessage() {
        return driver.findElement(flashMessage).getText();
    }
}
