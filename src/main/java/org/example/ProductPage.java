package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;
    private By productName = By.className("inventory_details_name");
    private By productDescription = By.className("inventory_details_desc");
    private By productImage = By.className("inventory_details_img");
    private By productPrice = By.className("inventory_details_price");
    private By addToCartButton = By.id("add-to-cart");


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isProductDescriptionVisible() {
        return driver.findElement(productDescription).isDisplayed();
    }
    public boolean isProductNameVisible() {
        return driver.findElement(productName).isDisplayed();
    }
    public boolean isProductImageVisible() {
        return driver.findElement(productImage).isDisplayed();
    }
    public boolean isProductPriceVisible() {
        return driver.findElement(productPrice).isDisplayed();
    }
    public boolean isAddToCartButtonVisible() {
        return driver.findElement(addToCartButton).isDisplayed();
    }
}
