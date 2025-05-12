import basetests.BaseSetup;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@Epic("Cart Feature")
@Feature("Add to Cart")
public class CartTest extends BaseSetup{
    @Test
    public void AddSingleProductToCart() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        homePage.clickOnFirstAddToCartButton();
        assertTrue(homePage.isRemoveButtonVisible(), "Remove button should be visible after adding 1 item");
        assertTrue(homePage.isCartCounterVisible(), "Cart counter should be visible after adding 1 item");
        assertEquals("1", homePage.getCartCount(), "Cart counter should show 1 after adding 1 item");
    }
    @Test
    public void AddMultipleProductsToCart() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        homePage.clickOnFirstAddToCartButton();
        homePage.clickOnSecondAddToCartButton();
        assertEquals("2", homePage.getCartCount(), "Cart counter should show 2 after adding 2 items");
        homePage.goToCartPage();
        assertTrue(cartPage.isItemPresent("Sauce Labs Backpack"), "Backpack should be present in cart");
        assertTrue(cartPage.isItemPresent("Sauce Labs Bike Light"), "Bike Light should be present in cart");
    }
    @Test
    public void RemoveProductFromHomePage(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        homePage.clickOnFirstAddToCartButton();
        homePage.clickOnSecondAddToCartButton();
        homePage.clickOnFirstRemoveButton();
        homePage.clickOnSecondRemoveButton();
        assertFalse(homePage.isCartCounterVisible(), "Cart counter should not be visible after removing all item");
    }
    @Test
    public void RemoveProductFromCart(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        homePage.clickOnFirstAddToCartButton();
        homePage.clickOnSecondAddToCartButton();
        homePage.goToCartPage();
        cartPage.firstClickRemove();
        cartPage.secondClickRemove();
        assertFalse(cartPage.isItemPresent("Sauce Labs Backpack"), "Product should be removed from cart");
        assertFalse(cartPage.isItemPresent("Sauce Labs Bike Light"), "Product should be removed from cart");
    }
    @Test
    public void CheckoutButtonVisible(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        homePage.clickOnFirstAddToCartButton();
        homePage.goToCartPage();
        assertTrue(cartPage.isCheckoutButtonVisible(), "Checkout button should be visible");
    }
}