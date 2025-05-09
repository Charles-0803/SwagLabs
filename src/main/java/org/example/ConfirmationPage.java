package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationPage {
    WebDriver driver;

    private By confirmationMessage = By.className("complete-header");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getConfirmationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
        return driver.findElement(confirmationMessage).getText();
    }
}
