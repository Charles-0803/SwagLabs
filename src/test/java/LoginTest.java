import basetests.BaseSetup;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

@Epic("Login Feature")
@Feature("Login Page")
public class LoginTest extends BaseSetup {
    @Test
    public void LoginPage_Accessibility() {
        assertTrue(driver.getCurrentUrl().contains("saucedemo"), "Login page is accessible");
    }
    @Test
    public void LoginForm_Display() {
        assertTrue(loginPage.isLoginFormDisplayed(), "Login form is displayed");
    }
    @Test
    public void Successful_Login() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        assertTrue(homePage.isOnHomePage(), "Home page is displayed after successful login");
    }
    @Test
    public void Unsuccessful_Login() {
        loginPage.setUsername("invalid_user");
        loginPage.setPassword("invalid_password");
        loginPage.clickLogin();
        assertTrue(loginPage.getErrorMessage().contains("Epic sadface: Username and password do not match any user in this service"));
    }
    @Test
    public void RestrictedAccess_WithoutLogin() {
        driver.get("https://www.saucedemo.com/inventory.html");
        assertTrue(loginPage.isLoginFormDisplayed(), "Login form is displayed when accessing restricted page without login");
    }
    @Test
    public void Logout() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        homePage.clickOnMenu();
        homePage.clickOnLogout();
        assertTrue(loginPage.isLoginFormDisplayed(), "Login form is displayed after logout");
    }
}
