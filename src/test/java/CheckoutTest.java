import basetests.BaseSetup;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Checkout Feature")
@Feature("Checkout Process")
public class CheckoutTest extends BaseSetup {
    @Test
    public void CheckoutButtonVisible() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        homePage.clickOnFirstAddToCartButton();
        homePage.goToCartPage();
        assertTrue(cartPage.isCheckoutButtonVisible(), "Checkout button should be visible after adding items to cart");
    }
    @Test
    public void CheckoutFormDisplay() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        homePage.clickOnFirstAddToCartButton();
        homePage.goToCartPage();
        cartPage.clickCheckoutButton();
        assertTrue(checkoutPage.isCheckoutFormDisplayed(), "Checkout form should be displayed after clicking checkout button");
    }
    @Test
    public void CheckoutFormWithValidInput() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        homePage.clickOnFirstAddToCartButton();
        homePage.goToCartPage();
        cartPage.clickCheckoutButton();
        checkoutPage.fillForm("John", "Doe", "12345");
        checkoutPage.clickContinueButton();
        assertTrue(driver.getCurrentUrl().contains("checkout-step-two"), "Should proceed to overview page.");
    }
    @Test
    public void CheckoutFormWithInvalidFirstName() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        homePage.clickOnFirstAddToCartButton();
        homePage.goToCartPage();
        cartPage.clickCheckoutButton();
        checkoutPage.fillForm("John12#", "Doe", "12345");
        checkoutPage.clickContinueButton();
        assertTrue(driver.getCurrentUrl().contains("checkout-step-two"), "Invalid first name should stay on form.");
    }
    @Test
    public void CheckoutFormWithInvalidLastName() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        homePage.clickOnFirstAddToCartButton();
        homePage.goToCartPage();
        cartPage.clickCheckoutButton();
        checkoutPage.fillForm("John", "Doe@8", "12345");
        checkoutPage.clickContinueButton();
        assertTrue(driver.getCurrentUrl().contains("checkout-step-two"), "Invalid last name should stay on form.");
    }
    @Test
    public void CheckoutFormWithValidZip() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        homePage.clickOnFirstAddToCartButton();
        homePage.goToCartPage();
        cartPage.clickCheckoutButton();
        checkoutPage.fillForm("John", "Doe", "abcde");
        checkoutPage.clickContinueButton();
        assertTrue(driver.getCurrentUrl().contains("checkout-step-two"), "Invalid zip should stay on form.");
    }
    @Test
    public void SuccessfulOrderPlacement() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        homePage.clickOnFirstAddToCartButton();
        homePage.goToCartPage();
        cartPage.clickCheckoutButton();
        checkoutPage.fillForm("John", "Doe", "12345");
        checkoutPage.clickContinueButton();
        overviewPage.clickFinishButton();
        String confirmationMsg = confirmationPage.getConfirmationMessage();
        assertEquals("Thank you for your order!", confirmationMsg, "Order confirmation should appear.");
    }
}
