import basetests.BaseSetup;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeTest extends BaseSetup {
    @Test
    public void HomePage_Accessibility() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        assertTrue(homePage.isOnHomePage(), "Home page is accessible");
    }
    @Test
    public void Homepage_Layout_Display() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        assertTrue(homePage.isOnHomePage(), "Home page is displayed after successful login");
        assertTrue(homePage.areProductCardsDisplayed(), "Product cards should be displayed in grid/list format");
        assertTrue(homePage.getNumberOfProductsDisplayed() >= 6, "Expected at least 6 products on the homepage");
    }
    @Test
    public void Verify_Product_Card_Elements(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        assertTrue(homePage.isProductNameVisible(), "Product name is visible");
        assertTrue(homePage.isPriceVisible(), "Product price is visible");
        assertTrue(homePage.isImageVisible(), "Product image is visible");
        assertTrue(homePage.isAddToCartButtonVisible(), "Add to cart button is visible");
    }
    @Test
    public void Verify_Navigation_To_Product_Details(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        homePage.clickOnFirstProductName();
        assertTrue(productPage.isProductNameVisible(), "Product name is visible");
        assertTrue(productPage.isProductDescriptionVisible(), "Product description is visible");
       assertTrue(productPage.isProductPriceVisible(), "Product price is visible");
        assertTrue(productPage.isProductImageVisible(), "Product image is visible");
        assertTrue(productPage.isAddToCartButtonVisible(), "Add to cart button is visible");
    }
}
