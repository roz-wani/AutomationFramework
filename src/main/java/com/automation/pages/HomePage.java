package com.automation.pages;

import com.automation.base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    //Locator for the success message after login / Success message
    private final By flashMessage = By.id("flash");

    //Logout button
    private final By logoutButton =
            By.cssSelector("a[href='/logout']");

    public HomePage() {

        super();
    }

    //Return the success message displayed after login
    public String getSuccessMessage() {

        return getText(flashMessage);
    }

    //Check whether login was successful
    public boolean isLoginSuccessful() {

        return getSuccessMessage().contains("You logged into a secure area");
    }

    //Logout
    public void logout() {

        click(logoutButton);
    }
}
