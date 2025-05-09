package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
     WebDriver driver;

    private By menu = By.id("react-burger-menu-btn");
    private By logout = By.id("logout_sidebar_link");
    private By productCards = By.className("inventory_item");
    private By firstProductName = By.className("inventory_item_name");
    private By firstProductPrice = By.className("inventory_item_price");
    private By firstProductImage = By.className("inventory_item_img");
    private By firstAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By firstRemoveButton = By.id("remove-sauce-labs-backpack");
    private By cartBadge = By.className("shopping_cart_badge");
    private By secondAddToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By secondRemoveButton = By.id("remove-sauce-labs-bike-light");
    private By thirdAddToCartButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By thirdRemoveButton = By.id("remove-sauce-labs-bolt-t-shirt");
    private By cartLink = By.className("shopping_cart_link");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isOnHomePage() {
        return driver.getCurrentUrl().contains("inventory.html");
    }
    public boolean isProductNameVisible() {
        return driver.findElement(firstProductName).isDisplayed();
    }
    public boolean isPriceVisible() {
        return driver.findElement(firstProductPrice).isDisplayed();
    }
    public boolean isImageVisible() {
        return driver.findElement(firstProductImage).isDisplayed();
    }
    public boolean isAddToCartButtonVisible() {
        return driver.findElement(firstAddToCartButton).isDisplayed();
    }
    public boolean isRemoveButtonVisible() {
        return driver.findElement(firstRemoveButton).isDisplayed();
    }
    public boolean isCartCounterVisible() {
        return driver.findElements(cartBadge).size() > 0;
    }
    public String getCartCount() {
        return driver.findElement(cartBadge).getText();
    }

    public void goToCartPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartLink));
        driver.findElement(cartLink).click();
    }


    public boolean areProductCardsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCards));
        List<WebElement> cards = driver.findElements(productCards);
        return cards.size() > 0 && cards.get(0).isDisplayed();
    }

    public int getNumberOfProductsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCards));
        return driver.findElements(productCards).size();
    }
    public void clickOnFirstAddToCartButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstAddToCartButton));
        driver.findElement(firstAddToCartButton).click();
    }
    public void clickOnFirstRemoveButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstRemoveButton));
        driver.findElement(firstRemoveButton).click();
    }
    public void clickOnSecondAddToCartButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondAddToCartButton));
        driver.findElement(secondAddToCartButton).click();
    }
    public void clickOnSecondRemoveButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondRemoveButton));
        driver.findElement(secondRemoveButton).click();
    }
    public void clickOnThirdAddToCartButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(thirdAddToCartButton));
        driver.findElement(thirdAddToCartButton).click();
    }
    public void clickOnThirdRemoveButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(thirdRemoveButton));
        driver.findElement(thirdRemoveButton).click();
    }
    public void clickOnMenu(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(menu));
        driver.findElement(menu).click();
    }
    public void clickOnLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
        driver.findElement(logout).click();
    }
    public void clickOnFirstProductName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductName));
        driver.findElement(firstProductName).click();
    }


}
