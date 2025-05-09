package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    WebDriver driver;

    private By firstremoveBtn = By.id("remove-sauce-labs-backpack");
    private By secondremoveBtn = By.id("remove-sauce-labs-bike-light");
    private By checkoutBtn = By.id("checkout");
    private By productNameInCart = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void firstClickRemove() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstremoveBtn));
        driver.findElement(firstremoveBtn).click();
    }
    public void secondClickRemove() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondremoveBtn));
        driver.findElement(secondremoveBtn).click();
    }
    public boolean isCheckoutButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn));
        return driver.findElement(checkoutBtn).isDisplayed();
    }
    public boolean isItemPresent(String itemName) {
        List<WebElement> items = driver.findElements(productNameInCart);
        for (WebElement item : items) {
            if (item.getText().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }
    public void clickCheckoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn));
        driver.findElement(checkoutBtn).click();
    }
}
